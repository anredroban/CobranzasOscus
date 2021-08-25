package callcenter
import com.pw.security.*
import grails.converters.JSON
import jxl.Cell
import jxl.Sheet
import jxl.Workbook
import jxl.WorkbookSettings
import liquibase.util.file.FilenameUtils
import utilitarios.Util

import java.text.DateFormat
import java.text.DecimalFormat
import java.text.ParseException
import java.text.SimpleDateFormat

class GestionController {


	static beforeInterceptor = {
		String accion = actionUri;
		if(!accion.equals("/usuario/login") && !accion.equals("/usuario/logout")){
			if(!session.user){
				redirect(uri: "/usuario/login");
				return false;
			}else{
				boolean tienePermiso = utilitarios.Util.checkAccess(session.user.usuario, accion)
				if(!tienePermiso){
					render "No tienes permiso para ingresar a este sitio-> "+accion;
				}
			}
		}
	}

	/**
	 * @author Giovanny Granda
	 * Muestra en pantalla los clientes asignados
	 * @return
	 */
	def index() {
		Usuario usuario = Usuario.findById(session.user.id);
		def plataforma = 'PURE CLOUD'
//		def clientesGestionar = Clientes.executeQuery("from Clientes c where subestadoGestion.rellamar = 'SI' and usuario = :usuario order by c.intentos", [usuario: usuario])

		def clients = Clientes.withCriteria {
			eq('usuario',usuario)
			eq('isActive', true)
			notEqual('plataforma', plataforma)
			subestadoGestion {
				or{
					eq('type', Subestado.constraints.type.inList[0].toString())
					eq('type', Subestado.constraints.type.inList[1].toString())
				}
			}
			order("intentos")
		}
		def clientsNoManagement = Clientes.withCriteria {
			eq('usuario',usuario)
			eq('isActive', true)
			isNull('subestadoGestion')
			notEqual('plataforma', plataforma)
		}

		clients.each {client ->
			clientsNoManagement.add(client)
		}
//		print clientsNoManagement.size()

//		def clientesGestionar = Clientes.withCriteria {
//			eq('usuario',usuario)
//			(
//					{
//						isNull('subestadoGestion')
//					}
//			)
//					{
//						or{
//							subestadoGestion{
//								eq('type',Subestado.constraints.type.inList[0].toString())
//							}
//							subestadoGestion{
//								eq('type',Subestado.constraints.type.inList[1].toString())
//							}
//						}
//					}
//			order('intentos','asc')
//		}
		[clientesGestionar: clientsNoManagement]
	}

	/**
	 * @author Giovanny Granda
	 * Muestra la pantalla de gestion donde se hara rectificación de datos
	 * @param id
	 * @return
	 */
	def gestionCliente(long id){
		long idCliente = id
		Clientes cliente = Clientes.findById(idCliente)
		session.user
		Historial historial = Historial.findByCliente(cliente)
		//def historial = Historial.executeQuery("select subSubEstado from Historial where cliente = cliente.id")
		Date fecha = new Date()
		SimpleDateFormat objSDF = new SimpleDateFormat('yyyy-MM-dd HH:mm:ss')
		String fechaInicio = objSDF.format(fecha)
		long idManagement = cliente.id
		Clientes.executeUpdate("update Clientes set fechaInicioLlamada = :fechaInicio where id = :idManagement", [fechaInicio: fechaInicio, idManagement: idManagement])
		String resultado = ""
		String estadoNivel = ""
		if(cliente.subestadoGestion != null){
			if(cliente.fecha_promesa != null){
				Calendar datos = Calendar.getInstance()
				int dia = datos.get(Calendar.DATE)
				int mes = datos.get(Calendar.MONTH)
				int anio = datos.get(Calendar.YEAR)
				String fechaActual = anio + '-' + (mes+1) + '-' + dia
				SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd")
				Date fecha1 = sfd.parse(fechaActual.toString())
				Date fecha2 = sfd.parse(cliente.fecha_promesa)
				String salida = fecha1.compareTo(fecha2)

				//println(diff / 1000L / 60L / 60L / 24L)
				if(salida == "-1"){
					render(view: "modelValidacion",  model: [idCliente: cliente.id, fechaPromesa: cliente.fecha_promesa])
				}
			}
			if (cliente.subestadoGestion.id == 28){
					if(cliente.fecha_promesa != '' && cliente.fecha_promesa != null){
						/*String[] arrayFechaPromesa = cliente.fecha_promesa.split("-")
						int diaPromesa = arrayFechaPromesa[2].toInteger()
						SimpleDateFormat objSDF2 = new SimpleDateFormat('dd')
						int fechaActualCalculo = objSDF2.format(fecha).toInteger()
						int resultadoCalculo = diaPromesa - fechaActualCalculo*/
						SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd")
						Calendar datos = Calendar.getInstance()
						int dia = datos.get(Calendar.DATE)
						int mes = datos.get(Calendar.MONTH)
						int anio = datos.get(Calendar.YEAR)
						String fechaActual = anio + '-' + (mes+1) + '-' + dia
						Date fecha2 = sfd.parse(fechaActual.toString())
						Date fechaPromesa = sfd.parse(cliente.fecha_promesa)
						long difCalculo = fechaPromesa.getTime() - fecha2.getTime();
						String resultadoCalculo = difCalculo / 1000L / 60L / 60L / 24L
						String strResultado = resultadoCalculo.toString()
						if(resultadoCalculo.toInteger() >= 0){
							resultado = "PROMESA POR VENCER " + strResultado.replace('-','') + " DIA(S)"
						}else{
							resultado = "PROMESA VENCIDA "+ strResultado.replace('-','') + " DIA(S)"
						}
					}else{
						resultado = "VALORES INVÁLIDOS CÁLCULOS NO REALIZADOS"
					}
					Clientes.executeUpdate("update Clientes set tipoGestion = :resultado where id = :idManagement", [resultado: resultado, idManagement: idManagement])
			}
		}
		if(cliente.dias_vencidos != null){
			// estadoNivel
			if(cliente.dias_vencidos.toInteger() >= 1 && cliente.dias_vencidos.toInteger() <= 60){
				estadoNivel = 'DIFERIDO INTERNO'
			}
			else{
				if(cliente.dias_vencidos.toInteger() >= 61 && cliente.dias_vencidos.toInteger() <= 90){
					estadoNivel = 'REFINANCIAMIENTO'
				}else{
					if(cliente.dias_vencidos.toInteger() >= 91){
						estadoNivel = 'REESTRUCTURACION'
					}
				}
			}
		}
		[cliente: cliente,usuario: session.user, estadoNivel: estadoNivel, resultado: resultado, historial: historial]
	}


	/**
	 * @author Giovanny Granda
	 * Guarda la gestion del call center
	 * @param id
	 * @return
	 */
	def guardarCliente(){
		Usuario usuario = Usuario.findById(session.user.id)
		Date fechaActual = new Date()
		long idCliente = params.idCliente.toLong()
		long idEstadoGestion = params.estado.toLong()
		long idSubestadoGestion = params.substatus.toLong()
		long idSubSubestadoGestion = params.subSubStatus.toLong()

		SimpleDateFormat objSDF = new SimpleDateFormat('yyyy-MM-dd HH:mm:ss')
		String fechaFin = objSDF.format(fechaActual)

		Estado estadoGestion = Estado.findById(idEstadoGestion)
		//String estadoGestion = Estado.findById(params.status.toString().toLong())
		Subestado objSubestadoGestion = Subestado.findById(idSubestadoGestion)
		SubSubestado objSubSubestadoGestion = SubSubestado.findById(idSubSubestadoGestion)

		//Busco el cliente por su id
		Clientes cliente = Clientes.findById(idCliente)
		int intentos = cliente.intentos?: 0

		if(cliente.registroExitoso != "SI"){
		//if(objSubestadoGestion.enableManagement && params.subSubStatus != "4" && params.subSubStatus != "10"){
		if(objSubestadoGestion.enableManagement == true){
			if (params.provinciaGestion != ""){
				long idProvinciaPromesa = params.provinciaGestion.toLong()
				Provincia objProvinciaPromesa = Provincia.findById(idProvinciaPromesa)
				cliente.provinciaGestion = Provincia.findById(params.provinciaGestion.toLong()).nombre
				cliente.provinciaPromesa = objProvinciaPromesa
			}else{
				cliente.provinciaGestion = ""
			}

			if (params.ciudadGestiones != ""){
				long idCiudadPromesa = params.ciudadGestiones.toLong()
				Ciudad objCiudadPromesa = Ciudad.findById(idCiudadPromesa)
				cliente.ciudadGestion = Ciudad.findById(params.ciudadGestiones).nombre
				cliente.ciudadPromesa = objCiudadPromesa
				//cliente.ciudadPromesa = Ciudad.findById(params.ciudadGestion.toString().toLong())
			}else{
				cliente.ciudadGestion = ""
			}

			if (params.cantonGestion != ""){
				long idCantonPromesa = params.cantonGestion.toLong()
				Canton objCantonPromesa = Canton.findById(idCantonPromesa)
				cliente.cantonGestion = Canton.findById(params.cantonGestion.toLong()).nombre
				cliente.cantonPromesa = objCantonPromesa
			}else{
				cliente.cantonGestion = ""
			}

			if (params.parroquiaGestion != ""){
				long idParroquiaPromesa = params.parroquiaGestion.toLong()
				Parroquia objParroquiaPromesa = Parroquia.findById(idParroquiaPromesa)
				cliente.parroquiaGestion = Parroquia.findById(params.parroquiaGestion.toLong()).nombre
				cliente.parroquiaPromesa = objParroquiaPromesa
			}else{
				cliente.parroquiaGestion = ""
			}
			cliente.callePrincipalGestion = formatearTexto(params.callePrincipalGestion.toString()).toUpperCase()
			cliente.numeroCasaGestion = formatearTexto(params.numeroCasaGestion.toString()).toUpperCase()
			cliente.calleSecundariaGestion = formatearTexto(params.calleSecundariaGestion.toString()).toUpperCase()
			cliente.referenciaGestion = formatearTexto(params.referenciaGestion.toString()).toUpperCase()


			cliente.fecha_promesa = params.fecha_promesa
			cliente.valor_promesa = params.valor_promesa
			cliente.telefonoDomicilio = params.telefonoDomicilio
			cliente.celular = params.celular
			cliente.estadoNivel4 = params.estadoNivel4
			cliente.plazoGestion = params.plazoGestion

		}

		if(objSubestadoGestion.type.equalsIgnoreCase("Condonacion")){
			cliente.valorCondonacion = params.valorCondonacion
			cliente.nombreCondonacionAgencia = params.nombreCondonacionAgencia
			cliente.fechaVisitaAgenciaCondonacion = params.fechaVisitaAgenciaCondonacion
			cliente.observacionesCondonacion = params.observacionesCondonacion
		}

		if(objSubestadoGestion.type.toString().equalsIgnoreCase("Rellamada")){
			cliente.fechaRellamada = new Date().parse('yyyy-MM-dd HH:mm:ss', params.recall.toString().replace('/','-') + ':00')
			//cliente.fechaRellamada =  new Date().parse('yyyy-MM-dd HH:mm:ss', formatearRellamada(params.recall.toString()))
			cliente.agendamientoAsesor = params.agendamiento
		}

		/*if(objSubestadoGestion.nombre.toString().equalsIgnoreCase("CU5 NO DESEA EL PRODUCTO")){
			cliente.telefonoCelularGestion = params.telefonoCelularGestionCU5
		}else{
			cliente.motivoNoAceptaSeguro = ""
		}*/
			/*if(objSubSubestadoGestion.name.equalsIgnoreCase("NO LE INTERESA LA OFERTA_ESCUCHA TODA OFERTA" ) && params.formasPago.toString() == 'MANTIENE FORMA DE PAGO'){
				cliente.confirmacionCliente = 'NO'
				cliente.interesaBeneficio = 'NO'
				cliente.formasPago = params.formasPago
			}*/
			if(objSubestadoGestion.alias.equalsIgnoreCase("NO EDITABLE")){
				cliente.registroExitoso = 'SI'
			}


		cliente.estadoGestion = estadoGestion.nombre
		cliente.retroalimentacion = params.retroalimentacion

		cliente.subestadoGestion = objSubestadoGestion
		if (params.subSubStatus != ""){
			String nombreSubSubEstado = SubSubestado.findById(params.subSubStatus.toString().toLong()).name
			cliente.subSubEstado = nombreSubSubEstado
			cliente.estado_nivel_2 = nombreSubSubEstado

		}
		else{
			cliente.subSubEstado = ""
			cliente.estado_nivel_2 = ""
		}

		cliente.intentos = intentos+1
		cliente.fechaGestion = fechaActual
		cliente.usuario = usuario
		cliente.nombreVendedor = usuario.nombre
		cliente.telefonoContactado = params.telefonoContactado
		cliente.estadoTelefonoContactado = params.estadoTelefonoContactado
		cliente.observaciones = params.observaciones
		cliente.motivoNoDesea = params.motivoNoDesea
		cliente.fechaFinLlamada = fechaFin

		cliente.save(flush: true)

		//Se guarda informacion en el historial
		Historial historial = new Historial()
		historial.cliente = Clientes.findById(cliente.id.toLong())
		historial.clienteIdentificador = cliente.id
		historial.estadoGestion = cliente.estadoGestion
		historial.subestadoGestion = cliente.subestadoGestion
		historial.subSubEstado = cliente.subSubEstado
		historial.fechaGestion = fechaActual
		historial.intentos = cliente.intentos
		historial.nombreVendedor = cliente.nombreVendedor
		historial.observacionesGestion = cliente.observaciones
		historial.usuario = cliente.usuario
		historial.plataforma = cliente.plataforma
		historial.fechaInicioLlamada = cliente.fechaInicioLlamada
		historial.fechaFinLlamada = cliente.fechaFinLlamada

		historial.estadoTel1 = params.estadoTel1
		historial.estadoTel1 = params.estadoTel1
		historial.respuestaTel1 = params.respuestaTel1
		historial.fechaTelf1 = params.fechaTelf1
		historial.observacionTelf1 = params.observacionTelf1
		historial.estadoTel2 = params.estadoTel2
		historial.respuestaTel2 = params.respuestaTel2
		historial.fechaTelf2 = params.fechaTelf2
		historial.observacionTelf2 = params.observacionTelf2
		historial.estadoTel3 = params.estadoTel3
		historial.respuestaTel3 = params.respuestaTel3
		historial.fechaTelf3 = params.fechaTelf3
		historial.observacionTelf3 = params.observacionTelf3
		historial.estadoTel4 = params.estadoTel4
		historial.respuestaTel4 = params.respuestaTel4
		historial.fechaTelf4 = params.fechaTelf4
		historial.observacionTelf4 = params.observacionTelf4
		historial.estadoTel5 = params.estadoTel5
		historial.respuestaTel5 = params.respuestaTel5
		historial.fechaTelf5 = params.fechaTelf5
		historial.observacionTelf5 = params.observacionTelf5
		historial.estadoTel6 = params.estadoTel6
		historial.respuestaTel6 = params.respuestaTel6
		historial.fechaTelf6 = params.fechaTelf6
		historial.observacionTelf6 = params.observacionTelf6
		historial.estadoTel7 = params.estadoTel7
		historial.respuestaTel7 = params.respuestaTel7
		historial.fechaTelf7 = params.fechaTelf7
		historial.observacionTelf7 = params.observacionTelf7
		historial.estadoTel8 = params.estadoTel8
		historial.respuestaTel8 = params.respuestaTel8
		historial.fechaTelf8 = params.fechaTelf8
		historial.observacionTelf8 = params.observacionTelf8
		historial.estadoTel9 = params.estadoTel9
		historial.respuestaTel9 = params.respuestaTel9
		historial.fechaTelf9 = params.fechaTelf9
		historial.observacionTelf9 = params.observacionTelf9
		historial.estadoTel10 = params.estadoTel10
		historial.respuestaTel10 = params.respuestaTel10
		historial.fechaTelf10 = params.fechaTelf10
		historial.observacionTelf10 = params.observacionTelf10
		historial.estadoTel11 = params.estadoTel11
		historial.respuestaTel11 = params.respuestaTel11
		historial.fechaTelf11 = params.fechaTelf11
		historial.observacionTelf11 = params.observacionTelf11
		historial.estadoTel12 = params.estadoTel12
		historial.respuestaTel12 = params.respuestaTel12
		historial.fechaTelf12 = params.fechaTelf12
		historial.observacionTelf12 = params.observacionTelf12
		historial.estadoTel13 = params.estadoTel13
		historial.respuestaTel13 = params.respuestaTel13
		historial.fechaTelf13 = params.fechaTelf13
		historial.observacionTelf13 = params.observacionTelf13
		historial.estadoTel14 = params.estadoTel14
		historial.respuestaTel14 = params.respuestaTel14
		historial.fechaTelf14 = params.fechaTelf14
		historial.observacionTelf14 = params.observacionTelf14
		historial.estadoTel15 = params.estadoTel15
		historial.respuestaTel15 = params.respuestaTel15
		historial.fechaTelf15 = params.fechaTelf15
		historial.observacionTelf15 = params.observacionTelf15
		historial.telefonoContactado = params.telefonoContactado
		historial.estadoTelefonoContactado = cliente.estadoTelefonoContactado
		historial.fecha_promesa = cliente.fecha_promesa
		historial.valor_promesa = cliente.valor_promesa
		historial.estado_nivel_2 = cliente.estado_nivel_2
		historial.save(flush: true)
		session.setAttribute("lastManageId","")
		redirect(uri: "/gestion/index")
		}else{
			boolean visualizar = true
			render(view: "modelValidacion",  model: [estado:cliente.estadoGestion, subestado: cliente.subestadoGestion.nombre, idCliente: cliente.id, visualizar: visualizar])
		}

	}

	private String formatearTexto(String entrada){
		return entrada.toUpperCase().replace('Ñ', 'N').replace('-', ' ').replace('Á', 'A').replace('É', 'E').replace('Í', 'I').replace('Ó', 'O').replace('Ú', 'U').replace('.', ' ')
	}

	/**
	 * @author Andres Redroban
	 * Convierte de formato hh:MM AM/PM a formato 24H
	 * @return resultado
	 */
	private String formatearHora(String entrada){
		DateFormat formatoInicial = new SimpleDateFormat("hh:mm a") //11:00 pm
		Date hora = null
		try {
			hora = formatoInicial.parse(entrada)
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace()
		}
		DateFormat formatoFinal = new SimpleDateFormat("HH:mm")
		String resultado = formatoFinal.format(hora) // "23:00"

		return resultado
	}

	/**
	 * @author Andres Redroban
	 * Convierte el formato de campo Fecha Rellamada
	 * @return resultado
	 */
	private String formatearRellamada(String variable){
		String[] arrayFechas = variable.trim().split(' ')
		String fecha = arrayFechas[0].replace('/', '-')
		String hora =  arrayFechas[1] + ' ' + arrayFechas[2]
		SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
		SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
		Date date = parseFormat.parse(hora);
		String  horaFinal = displayFormat.format(date)+':00'
		String resultado = fecha + ' ' + horaFinal
		return resultado
	}

	def retirarBase(){
		boolean updateRealizado = false
		int resultado = 0
		if(params.usuario != null && params.tipo != null && params.nombrebase != null){

			String desde = params.desde
			String hasta = params.hasta

			updateRealizado = true
			Usuario usuarioAdministrador = Usuario.findById(1)

			def subestados
			if(params.tipo != "RELLAMADAS"){
				subestados = Subestado.executeQuery("from Subestado where type = 'Regestionable'")
			}else {
				subestados = Subestado.executeQuery("from Subestado where type = 'Rellamada'")
			}

			String sql = "update Clientes set usuario = :usuario, nombreVendedor = 'Administrador' where (subestadoGestion in (:subestados) or subestadoGestion is null) and usuario != :usuario and plataforma != 'PURE CLOUD' "


			def condiciones = [usuario: usuarioAdministrador, subestados: subestados]
			String condicionUsuario = ""
			String condicionTipo = ""
			String condicionNombreBase = ""
			String condicionDesde = ""
			String condicionHasta = ""

			if(params.desde != ""){
				condicionDesde = " and cast(codigoAsignacion as integer) >= :desde"
				condiciones.put("desde", desde.toString().toInteger())
			}

			if(params.hasta != ""){
				condicionHasta = " and cast(codigoAsignacion as integer) <= :hasta"
				condiciones.put("hasta", hasta.toString().toInteger())
			}

			if(params.usuario != ""){
				Usuario usuarioVendedor = Usuario.findById(params.usuario)
				condicionUsuario = " and usuario = :vendedor"
				condiciones.put("vendedor", usuarioVendedor)
			}

			if(params.tipo != ""){
				if(params.tipo == "REGESTIONABLE"){
					condicionTipo = " and intentos > 0"
				}
				if(params.tipo == "RELLAMADAS"){
					condicionTipo = " and intentos > 0 and agendamientoAsesor = 'AGENDAR PARA CUALQUIERA'"
				}
				if(params.tipo == "SIN GESTION"){
					condicionTipo = " and intentos = 0"
				}
			}

			if(params.nombrebase != ""){
				condicionNombreBase = " and nombreBase = :nombreBase"
				condiciones.put("nombreBase", params.nombrebase)
			}

			resultado = Clientes.executeUpdate(sql+condicionUsuario+condicionTipo+condicionNombreBase+condicionDesde+condicionHasta, condiciones)

		}
		[updateRealizado: updateRealizado, resultado: resultado]
	}

	def cargarBase(){

	}

	def saveFile(){
		String[] formFields = Clientes.getFields()
		def file = request.getFile('file')
		Cell[] cells
		String[] headers
		if(file.empty){
			flash.message = "Por favor selecciona un archivo"
		}else{
			def webrootDir = servletContext.getRealPath(grailsApplication.config.uploadFolder) //app directory
			File fileDest = new File(webrootDir,file.getOriginalFilename())
			if(fileDest.mkdirs()){
				println "directory created"
			}else{
				println "directory not created or already exists"
			}
			file.transferTo(fileDest)

			//Reading Excel
			String ext = FilenameUtils.getExtension(fileDest.path)
			if(ext.equalsIgnoreCase("xls") || ext.equalsIgnoreCase("xlsx")){
				try {
					WorkbookSettings ws = new WorkbookSettings()
					ws.setEncoding("Cp1252")
					Workbook workbook = Workbook.getWorkbook(fileDest, ws)
					Sheet sheet = workbook.getSheet(0)
					cells = sheet.getRow(0)
					workbook.close()
				}catch (IOException ex){
					flash.error = "Problemas al cargar el archivo"
					render(view: "index")
				}
				headers = new String[cells.length]
				for(int i = 0; i < cells.length; i++){
					headers[i] = cells[i].getContents()
				}
				render(view: "sortExcel", model: [headers: headers, formFields:formFields, filePath:fileDest.path])
			}else{
				flash.error = "El archivo debe ser una hoja de cálculo de Excel"
				render(view: "index")
			}
		}
	}

	/**
	 * Status
	 * @return
	 */
	def getSubStatusByStatus(){
		if(params.id) {
			def status = Estado.findById(params.id)
			def subStatus = Subestado.findAllByEstado(status)
			def array = [subStatus.id, subStatus.nombre, subStatus.type, subStatus.enableManagement]
			render array as JSON
		}
	}


	/**
	 * make by someone
	 * @param value
	 * @return
	 */
	private removeSpecialCharacters(value){
		if(value != null){
			def newValue = value.replace("-"," ").replace("!","").replace("@","").replace("#","").replace("\$","")
					.replace("&","").replace("/","").replace("(","").replace(")","").replace("=","")
					.replace("?","").replace("¿","").replace("ç","").replace("{","").replace("}","")
					.replace("\\","").replace("á","a").replace("é","e").replace("í","i").replace("ó","o")
					.replace("ú","u").replace("\"","").replace("Á","A").replace("É","E").replace("Í","I")
					.replace("Ó","O").replace("Ú","U").replace("\'","").replace("  "," ").replace("  "," ")
					.replace("  "," ").replace("%","").replace(".","").replace(",","").replace("º","")
					.replace("ª","").replace("|","").replace("\$","").replace("¬","").replace("%","")
					.replace("*","").replace("+","").replace("_","")
			return newValue
		}
	}


}
