package callcenter

//import javafx.scene.control.Cell
import jxl.Workbook
import jxl.WorkbookSettings
import jxl.format.Alignment
import jxl.format.Border
import jxl.format.BorderLineStyle
import jxl.format.Colour
import jxl.format.VerticalAlignment
import jxl.write.Label
import jxl.write.WritableFont
import jxl.write.WritableSheet
import jxl.write.WritableWorkbook
import telephony.BreakTime
import utilitarios.ExcelUtils


import com.pw.security.*
import groovy.sql.Sql
import org.hibernate.criterion.CriteriaSpecification
import utilitarios.Util

import java.text.DecimalFormat
import java.text.SimpleDateFormat

//import pl.touk.excel.export.WebXlsxExporter

class ReportesController {

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


/*	def bitacoraGestion(){
		if(params.nombreBase){
			//Obtenemos los datos
			ArrayList<SubSubestado> subestados = Subestado.executeQuery("from Subestado where id in (1,2,3)")
			def nombresBase = params.list("nombreBase")
			def condiciones = [nombresBase: nombresBase]
			String sqlPrincipales = "from Clientes where codigoCampania in (:nombresBase)"
			String sqlBroadcast = "from Clientes where codigoCampania in (:nombresBase) and estadoBroadcast is not null"
			def principalesList = Clientes.executeQuery(sqlPrincipales, condiciones)
			def broadcastList = Clientes.executeQuery(sqlBroadcast, condiciones)

			//Empezamos a crear y llenar el Excel
			def webrootDir = servletContext.getRealPath(grailsApplication.config.uploadFolder)
			File file = new File(webrootDir, "temporal.xls")
			WorkbookSettings workbookSettings = new WorkbookSettings()
			workbookSettings.setLocale(new Locale("es", "ES"))
			workbookSettings.setEncoding("Cp1252")
			workbookSettings.setUseTemporaryFileDuringWrite(true)
			WritableWorkbook workbook = Workbook.createWorkbook(file, workbookSettings)
			workbook.createSheet("GESTION", 0)
			workbook.createSheet("BROADCAST", 1)
			WritableFont cellFont = new WritableFont(WritableFont.TAHOMA, 10)
			WritableFont cellFont2 = new WritableFont(WritableFont.createFont("Calibri"), 11)
			WritableSheet sheetPrincipales = workbook.getSheet(0)
			WritableSheet sheetBroadcast = workbook.getSheet(1)
			String[] headersPrincipales = ['CODIGOCAMPANA',	'AGENTE',	'USUARIO ID',	'TIPO_GESTION',	'IDENTIFICACION',	'NOMBRECLIENTE',
										   'FECHAGESTION',	'ESTATUS',	'ULTIMOTELEFONOCONTACTO',	'OBSERVACIONMOTIVONODESEA',	'NUMEROINTENTOS',
										   'ESTADO_GESTION',	'NOMBRE BASE',	'TELEFONO1',	'TELEFONO2',	'TELEFONO3',	'TELEFONO4',
										   'TELEFONO5',	'ADICIONALES',	'GAMA',	'REGIONAL',	'RANGO EDAD',	'RANGO CUPO',	'CADUCIDAD',	'ID SISTEMA',
										   'ALIMENTACION', 'BROADCAST', 'RESPONDE SI / NO', 'FECHA ENVIO BROADCAST' ]
			String[] headersBroadcast = ['CODIGO CAMPAÑA',	'NUMERO DE CEDULA (14 DIGITOS)',	'NOMBRE DEL CLIENTE',	'OPERACIÓN',	'CALL',
										 'FECHA PRIMER ENVIO',	'OBSERVACION PRIMER ENVIO',	'FECHA SEGUNDO ENVIO',	'OBSERVACION SEGUNDO ENVIO']

			ExcelUtils.addCells(headersPrincipales, sheetPrincipales, 0, Colour.GOLD, Alignment.LEFT, VerticalAlignment.CENTRE, cellFont, Border.ALL, BorderLineStyle.HAIR)
			ExcelUtils.addCells(headersBroadcast, sheetBroadcast, 0, Colour.GRAY_25, Alignment.LEFT, VerticalAlignment.CENTRE, cellFont, Border.ALL, BorderLineStyle.HAIR)
			for (int i = 0; i < principalesList.size(); i++){
				String[] campos3 = new String[headersPrincipales.length]
				Clientes princ3 = principalesList.get(i)
				campos3[0] = princ3.codigoCampania
				campos3[1] = princ3.nombreVendedor
				if (princ3.usuario == null){
					campos3[2] = princ3.usuario
				}else{
					campos3[2] = princ3.usuario.id
				}
				campos3[3] = princ3.tipoGestion
				campos3[4] = princ3.identificacion
				campos3[5] = princ3.nombre
				if (princ3.fechaGestion == null){
					campos3[6] = princ3.fechaGestion
				}else{
					campos3[6] = princ3.fechaGestion.toString().substring(0,10).replace("/","-")
				}
				if (princ3.subestadoGestion == null){
					campos3[7] = princ3.subestadoGestion
				}else{
					campos3[7] = princ3.subestadoGestion.nombre
				}
				campos3[8] = princ3.telefonoContactado
				campos3[9] = princ3.subSubEstado
				campos3[10] = princ3.intentos
				campos3[11] = princ3.estadoGestion
				campos3[12] = princ3.nombreBase
				campos3[13] = princ3.telefono1
				campos3[14] = princ3.telefono2
				campos3[15] = princ3.telefono3
				campos3[16] = princ3.telefono4
				campos3[17] = princ3.telefono5
				campos3[18] = ''
				campos3[19] = princ3.gama
				campos3[20] = princ3.regional
				campos3[21] = princ3.rangoEdad
				campos3[22] = princ3.rangoCupo
				campos3[23] = princ3.fechaCaducidad
				campos3[24] = princ3.id
				campos3[25] = princ3.alimentacion
				campos3[26] = princ3.estadoBroadcast
				campos3[27] = princ3.respuestaBroadcast
				campos3[28] = princ3.fechaEnvioBroadcast
				ExcelUtils.addCells(campos3, sheetPrincipales, i+1, Colour.WHITE, Alignment.LEFT, VerticalAlignment.CENTRE, cellFont2, null, null)
			}
			for (int j = 0; j < broadcastList.size(); j++){
				String[] campos3 = new String[headersBroadcast.length]
				Clientes princ3 = broadcastList.get(j)
				campos3[0] = princ3.codigoCampania
				campos3[1] = princ3.identificacion
				campos3[2] = princ3.nombre
				campos3[3] = ""
				campos3[4] = "PW"
				campos3[5] = princ3.fechaEnvioBroadcast
				campos3[6] = princ3.estadoBroadcast
				campos3[7] = ""
				campos3[8] = ""
				ExcelUtils.addCells(campos3, sheetBroadcast, j+1, Colour.WHITE, Alignment.LEFT, VerticalAlignment.CENTRE, cellFont2, null, null)
			}
			workbook.write()
			workbook.close()
			response.setHeader("Content-disposition", "filename=bitacoraGestion.xls")
			response.setContentType("application/octet-stream")
			response.outputStream << file.getBytes()
			return
		}
	}*/

	def bitacoraGestion(){
		if(params.fechas){
			//Obtenemos los datos
			ArrayList<SubSubestado> subestados = Subestado.executeQuery("from Subestado where id in (1,2,3)")
			Date[] fechas = Util.formatearFechasReporte(params.fechas.toString())
			def nombresBase = params.list("nombreBase")
			def condiciones = [fechaInicio: fechas[0], fechaFin: fechas[1]]
			String sqlPrincipales = "from Clientes where fechaGestion between :fechaInicio and :fechaFin"
			String sqlHistorial = "from Historial where fechaGestion between :fechaInicio and :fechaFin order by cliente"
			def principalesList = Clientes.executeQuery(sqlPrincipales, condiciones)
			def historialGestionList = Clientes.executeQuery(sqlHistorial, condiciones)
			//Empezamos a crear y llenar el Excel
			def webrootDir = servletContext.getRealPath(grailsApplication.config.uploadFolder)
			File file = new File(webrootDir, "temporal.xls")
			WorkbookSettings workbookSettings = new WorkbookSettings()
			workbookSettings.setLocale(new Locale("es", "ES"))
			workbookSettings.setEncoding("Cp1252")
			workbookSettings.setUseTemporaryFileDuringWrite(true)
			WritableWorkbook workbook = Workbook.createWorkbook(file, workbookSettings)
			workbook.createSheet("GESTION", 0)
			WritableFont cellFont = new WritableFont(WritableFont.TAHOMA, 10)
			WritableFont cellFont2 = new WritableFont(WritableFont.createFont("Calibri"), 11)
			WritableSheet sheetPrincipales = workbook.getSheet(0)
			String[] headersPrincipales = ['identificacion',	'tarjetahabiente',	'direccionDomicilio',	'usuariosolicitud',	'oficina',
										   'telefonoDomicilio',	'celular',	'fechacorteestadocuenta',	'cupoAutorizado',	'cupoUtilizado',
										   'saldoDisponible',	'pagoMinimo',	'pagocontado',	'pagominimotope',	'fechaUltimoPago',
										   'montoUltimoPago',	'pagosDelMes',	'deudaVencida',	'sobregiro',	'numeroPagosVencidos', 'diasVencidos']
			ExcelUtils.addCells(headersPrincipales, sheetPrincipales, 0, Colour.GOLD, Alignment.LEFT, VerticalAlignment.CENTRE, cellFont, Border.ALL, BorderLineStyle.HAIR)
			for(int i = 0; i < principalesList.size(); i++){
				String[] campos = new String[headersPrincipales.length]
				Clientes cli = principalesList.get(i)
				campos[0] = cli.identificacion
				campos[1] = cli.nombre
				campos[2] = cli.callePrincipalGestion + " " + cli.numeroCasaGestion + " " + cli.calleSecundariaGestion + " " + cli.referenciaGestion
				campos[3] = cli.nombreVendedor
				campos[4] = cli.cantonGestion
				campos[5] = cli.telefonoDomicilio
				campos[6] = cli.celular
				campos[7] = cli.fechacorteestadocuenta
				campos[8] = cli.cupoAutorizado
				campos[9] = cli.cupo_utilizado
				campos[10] = cli.saldoDisponible
				campos[11] = cli.pago_minimo
				campos[12] = cli.pagocontado
				campos[13] = cli.pagominimotope
				campos[14] = cli.fechaUltimoPago
				campos[15] = cli.montoUltimoPago
				campos[16] = cli.pagosDelMes
				campos[17] = cli.deudaVencida
				campos[18] = cli.sobregiro
				campos[19] = cli.pagos_vencidos
				campos[20] = cli.dias_vencidos
				ExcelUtils.addCells(campos, sheetPrincipales, i+1, Colour.WHITE, Alignment.LEFT, VerticalAlignment.CENTRE, cellFont2, null, null)
			}

			workbook.write()
			workbook.close()
			response.setHeader("Content-disposition", "filename=bitacoraGestion.xls")
			response.setContentType("application/octet-stream")
			response.outputStream << file.getBytes()
			return
		}
	}

/**
 * @author Andres Redroban
 * @description Funcion que transforma una fecha en formato EEEE dd MMM YYYY. Ejemplo Miercoles 17 de 04 del 2019
 * @param fecha
 * @return formato
 */
	def convertirFecha(String fecha){
		//String formato = new SimpleDateFormat("EEEE dd 'de' MMMM 'del' YYYY", new Locale("ES")).format(fecha)
		String formato = ""
		String[] arrayFechas = fecha.trim().split('-')
		String dia = arrayFechas[2]
		String mes = arrayFechas[1]
		String anio = arrayFechas[0]
		formato = dia + "/" + mes + "/" + anio
		return formato
	}


	def baseGestionada(){
		if(params.fechas){
			Date[] fechas = Util.formatearFechasReporte(params.fechas.toString())
			//def nombresBase = params.list("nombreBase")
			def subestados = params.list("subestados")
			def condiciones = [fechaInicio: fechas[0], fechaFin: fechas[1]]
			String sql = "from Clientes where fechaGestion between :fechaInicio and :fechaFin "
			def base = Clientes.executeQuery(sql, condiciones)

			//Empezamos a crear y llenar el Excel
			def webrootDir = servletContext.getRealPath(grailsApplication.config.uploadFolder)
			File file = new File(webrootDir, "temporal.xls")
			WorkbookSettings workbookSettings = new WorkbookSettings()
			workbookSettings.setLocale(new Locale("es", "ES"))
			workbookSettings.setEncoding("Cp1252")
			WritableWorkbook workbook = Workbook.createWorkbook(file, workbookSettings)
			workbook.createSheet("baseGestionada", 0)
			WritableSheet sheet = workbook.getSheet(0)
			String[] headers = [
					"CEDULA",
					"NOMBRES",
					"ESTADO",
					"SUBESTADO",
					"SUBSUBESTADO",
					"FECHA GESTION",
					"NOMBRE BASE",
					"NOMBRE VENDEDOR",
					"INTENTOS",
					"OBSERVACIONES",
					"TELEFONO CONTACTADO",
					"TELEFONO 1",
					"TELEFONO 2",
					"TELEFONO 3",
					"TELEFONO 4",
					"TELEFONO 5",
					"VALOR PROMESA",
					"FECHA PROMESA"
			]
			ExcelUtils.addCells(headers, sheet, 0, Colour.GRAY_25, Alignment.LEFT, VerticalAlignment.CENTRE, null, Border.ALL, BorderLineStyle.HAIR)
			for(int i = 0; i < base.size(); i++){
				String[] campos = new String[headers.length]
				Clientes c = base.get(i)
				campos[0] = c.identificacion
				campos[1] = c.nombre
				campos[2] = c.estadoGestion
				campos[3] = c.subestadoGestion.nombre
				campos[4] = c.subSubEstado
				campos[5] = c.fechaGestion.toString()
				campos[6] = c.nombreBase
				campos[7] = c.nombreVendedor
				campos[8] = c.intentos
				campos[9] = c.observaciones
				campos[10] = c.telefonoContactado
				campos[11] = c.telefono1
				campos[12] = c.telefono2
				campos[13] = c.telefono3
				campos[14] = c.telefono4
				campos[15] = c.telefono5
				campos[16] = c.valor_promesa
				campos[17] = c.fecha_promesa
				ExcelUtils.addCells(campos, sheet, i+1, Colour.WHITE, Alignment.LEFT, VerticalAlignment.CENTRE, null, null, null)
			}
			workbook.write()
			workbook.close()
			response.setHeader("Content-disposition", "filename=baseGestionadaDiferido.xls")
			response.setContentType("application/octet-stream")
			response.outputStream << file.getBytes()
			return

		}
	}
	def tiemposBreak() {
		if (params.fechas) {
			Date[] fechas = Util.formatearFechasReporte(params.fechas.toString())
			ArrayList<SubSubestado> subestados = Subestado.executeQuery("from Subestado where id in (1)")
			def nombresBase = params.list("nombreBase")
			def condiciones = [fechaInicio: fechas[0], fechaFin: fechas[1]]
			String sqlPrincipales = "from BreakTime where dateBreak between :fechaInicio and :fechaFin"
			def principalesList = BreakTime.executeQuery(sqlPrincipales, condiciones)
			//Empezamos a crear y llenar el Excel
			def webrootDir = servletContext.getRealPath(grailsApplication.config.uploadFolder)
			File file = new File(webrootDir, "temporal.xls")
			WorkbookSettings workbookSettings = new WorkbookSettings()
			workbookSettings.setLocale(new Locale("es", "ES"))
			workbookSettings.setEncoding("UTF-8")
			WritableWorkbook workbook = Workbook.createWorkbook(file)
			workbook.createSheet("Clientes Efectivos", 0)
			WritableFont cellFont = new WritableFont(WritableFont.createFont("Calibri"), 11, WritableFont.BOLD)
			cellFont.setColour(Colour.WHITE);
			WritableFont cellFont2 = new WritableFont(WritableFont.createFont("Calibri"), 11)
			WritableSheet sheetPrincipales = workbook.getSheet(0)
			String[] headersPrincipales = ["FECHA/HORA", "TIEMPO", "OPCION", "NOMBRE USUARIO"]
			ExcelUtils.addCells(headersPrincipales, sheetPrincipales, 0, Colour.GREEN, Alignment.LEFT, VerticalAlignment.CENTRE, cellFont, Border.ALL, BorderLineStyle.THIN)
			for (int i = 0; i < principalesList.size(); i++) {
				String[] campos = new String[headersPrincipales.length]
				BreakTime cli = principalesList.get(i)
				campos[0] = cli.dateBreak.toString()
				campos[1] = cli.timeBreak.toString()
				campos[2] = cli.typeBreak
				campos[3] = cli.user.nombre
				ExcelUtils.addCells(campos, sheetPrincipales, i + 1, Colour.WHITE, Alignment.LEFT, VerticalAlignment.CENTRE, cellFont2, null, null)
			}
			workbook.write()
			workbook.close()
			response.setHeader("Content-disposition", "filename=tiemposBreakAsesores.xls")
			response.setContentType("application/octet-stream")
			response.outputStream << file.getBytes()
			return
		}
	}

	def loginAgentes(){
		boolean visibilizar = false
		if(params.fechas) {
			visibilizar = true
			Date[] fechas = Util.formatearFechasReporte(params.fechas.toString())
			def nombresBase = params.list("nombreBase")
			Date fechaInicio = fechas[0]
			Date fechaFin = fechas[1]
			println(fechaInicio)
			def consulta = Clientes.executeQuery("select substring(fechaGestion,1,10), nombreVendedor, substring(min(fechaGestion),11,12), substring(max(fechaGestion),11,12) from Clientes where fechaGestion between :fechaInicio and :fechaFin group by substring(fechaGestion,1,10), nombreVendedor", [fechaInicio: fechaInicio, fechaFin: fechaFin])
			String[][] tablaResult = new String[consulta.size()][5]
			//Lleno la matriz de resultados con los resultados de las onsultas anteriores
			for(int i = 0; i < tablaResult.size(); i++) {
				tablaResult[i][0] = consulta[i][0]
				tablaResult[i][1] = consulta[i][1]
				tablaResult[i][2] = consulta[i][2]
				tablaResult[i][3] = consulta[i][3]
			}
			[visibilizar: visibilizar, tablaResult: tablaResult]
		}
	}

}
