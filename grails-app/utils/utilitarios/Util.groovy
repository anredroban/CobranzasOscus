package utilitarios
import com.pw.security.*;
import callcenter.*
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

import java.text.DecimalFormat;
class Util {

	static boolean checkAccess(String username, String controlador){
		boolean accesoPermitido = isAdmin(username)?true:false;
		def usuario = Usuario.findByUsuario(username);
		def rol = Rol.findById(usuario.rolId);
		def permiso = Permiso.findByDescripcion(controlador);

		//CREAR PERMISO SI NO EXISTE
		if(permiso == null){
			def nuevoPermiso = new Permiso()
			nuevoPermiso.descripcion = controlador
			if(nuevoPermiso.save(flush:true)){
				permiso = nuevoPermiso
				println "nuevo permiso creado"
			}else
			{
				println "no se pudo crear el permiso"
			}
		}

		//BUSCA SI EL PERMISO ESTA ASIGNADO AL ROL
		for(perm in rol.permisos){
			if(perm == permiso){
				accesoPermitido = true;
				break;
			}
		}
		return accesoPermitido;
	}

	static boolean isAdmin(String username){

		boolean isAdmin = false
		def usuario = Usuario.findByUsuario(username)
		if(usuario.rol.nombre.equalsIgnoreCase("ADMINISTRADOR"))
			isAdmin = true
		return isAdmin
	}

	static boolean isOperator(String username){

		boolean isOperator = false
		def usuario = Usuario.findByUsuario(username)
		if(usuario.rol.nombre.equalsIgnoreCase("OPERADOR"))
			isOperator = true
		return isOperator
	}

	static int getCantidadVentas(){
		Date fechaInicio = Date.parse("yyyy-MM-dd HH:mm:ss", new Date().format("yyyy-MM-dd 00:00:00"))
		Date fechaFin = Date.parse("yyyy-MM-dd HH:mm:ss", new Date().format("yyyy-MM-dd 23:59:59"))
		def subestados = Subestado.findAllByType("Exitoso")
		//println(subestados)
		//def subestados = Subestado.executeQuery("from Subestado where id in (1, 3)")
		def ventas = Sesion.executeQuery("from Clientes c where c.subestadoGestion in (:subestados) and c.fechaGestion between :fechaInicio and :fechaFin", [subestados: subestados, fechaInicio: fechaInicio, fechaFin: fechaFin])
		return ventas.size()
	}

	static int getCantidadCredito(){
		Date fechaInicio = Date.parse("yyyy-MM-dd HH:mm:ss", new Date().format("yyyy-MM-dd 00:00:00"))
		Date fechaFin = Date.parse("yyyy-MM-dd HH:mm:ss", new Date().format("yyyy-MM-dd 23:59:59"))
		def subestados = Subestado.findByType("Exitoso")
		//def subestados = Subestado.executeQuery("from Subestado where id in (1, 3)")
		def ventas = Sesion.executeQuery("from Clientes c where c.subestadoGestion in (:subestados) and subSubEstado = 'CREDITO' and c.fechaGestion between :fechaInicio and :fechaFin", [subestados: subestados, fechaInicio: fechaInicio, fechaFin: fechaFin])
		return ventas.size()
	}

	static int getCantidadCu3(){
		Date fechaInicio = Date.parse("yyyy-MM-dd HH:mm:ss", new Date().format("yyyy-MM-dd 00:00:00"))
		Date fechaFin = Date.parse("yyyy-MM-dd HH:mm:ss", new Date().format("yyyy-MM-dd 23:59:59"))
		Subestado subestado = Subestado.findById(3)
		def ventascu3 = Sesion.executeQuery("from Clientes c where c.subestadoGestion in (:subestado) and c.fechaGestion between :fechaInicio and :fechaFin", [subestado: subestado, fechaInicio: fechaInicio, fechaFin: fechaFin])
		return ventascu3.size()
	}


	static int getContactados(){

		Date fechaInicio = Date.parse("yyyy-MM-dd HH:mm:ss", new Date().format("yyyy-MM-dd 00:00:00"))
		Date fechaFin = Date.parse("yyyy-MM-dd HH:mm:ss", new Date().format("yyyy-MM-dd 23:59:59"))
		int contactadosQuito = Clientes.executeQuery("from Clientes where estadoGestion = :estado and fechaGestion between :fechaInicio and :fechaFin", [estado: "CONTACTADO", fechaInicio: fechaInicio, fechaFin: fechaFin]).size()
		return contactadosQuito
	}

	static ArrayList<Usuario> getOperadores(){
		Rol rol = Rol.findByNombre("OPERADOR")
		def operadores = Usuario.executeQuery("from Usuario where estado = 'ACTIVO' and rol = :rol", [rol: rol])
		return operadores
	}
	static ArrayList<String> getNumOperaciones(String identificacion){
		String ide = identificacion
		def operadores = Clientes.executeQuery("from Clientes where identificacion = :ide", [ide: ide])
		return operadores
	}
	static ArrayList<String> getNumOperaciones2(String identificacion, String nombreBase){
		String salida = ''
		def cliente = Clientes.executeQuery("from Clientes where identificacion = :identificacion and nombreBase = :nombreBase", [identificacion: identificacion, nombreBase: nombreBase])
		ArrayList<String> productos = new ArrayList<>()
			for(int i = 0; i < cliente.size(); i++){
				Clientes c = cliente.get(i)
				productos.add(c.id)
			}
		//salida = productos
		return productos

	}

	static int getOperadoresLogueados(){

		Date fechaInicio = Date.parse("yyyy-MM-dd HH:mm:ss", new Date().format("yyyy-MM-dd 00:00:00"))
		Date fechaFin = Date.parse("yyyy-MM-dd HH:mm:ss", new Date().format("yyyy-MM-dd 23:59:59"))
		Rol rol = Rol.findByNombre("OPERADOR")
		def usuarios = Sesion.executeQuery("select distinct s.usuario, max(s.fechaInicio) from Sesion s where s.fechaInicio between :fechaInicio and :fechaFin and s.usuario.rol = :rol and s.usuario.estado = 'ACTIVO' group by s.usuario", [fechaInicio: fechaInicio, fechaFin: fechaFin, rol: rol])
		int contador = 0
		for(int i = 0; i < usuarios.size(); i++){
			Sesion sesion = Sesion.findByUsuarioAndFechaInicio(usuarios[i][0], usuarios[i][1])
			if (sesion.fechaFin == null)
				contador++
		}

		return contador

	}

	static ArrayList<Usuario> getOperDisponiblesAsignacion(){
		ArrayList<Usuario> users = new ArrayList<>()
		Date fechaInicio = Date.parse("yyyy-MM-dd HH:mm:ss", new Date().format("yyyy-MM-dd 00:00:00"))
		Date fechaFin = Date.parse("yyyy-MM-dd HH:mm:ss", new Date().format("yyyy-MM-dd 23:59:59"))
		Rol rol = Rol.findByNombre("OPERADOR")
		def usuarios = Sesion.executeQuery("select distinct s.usuario, max(s.fechaInicio) from Sesion s where s.fechaInicio between :fechaInicio and :fechaFin and s.usuario.rol = :rol and s.usuario.estado = 'ACTIVO' group by s.usuario", [fechaInicio: fechaInicio, fechaFin: fechaFin, rol: rol])
		for(int i = 0; i < usuarios.size(); i++){
			Sesion sesion = Sesion.findByUsuarioAndFechaInicio(usuarios[i][0], usuarios[i][1])
			if (sesion.fechaFin == null)
				users.add(sesion.usuario)
		}

		return users
	}

	/*static ArrayList<SubSubestado> getSubestadosRegestionables(){
		Subestado subestado = Subestado.findById(8)
		def subestados = SubSubestado.executeQuery("from SubSubestado where subestado = :subestado", [subestado: subestado])
		return  subestados
	}*/

	static ArrayList<Subestado> getSubestadosRegestionables(){
		//Subestado subestado = Subestado.findByAlias('Regestionable')
		def subestados = Subestado.executeQuery("from Subestado where type = 'Regestionable'")
		return  subestados
	}

	static ArrayList<String> getNombresBase(){
		/*	def results = Clientes.withCriteria {
                projections{
                    distinct("nombreBase")
                }
                //eq('isActive', true)
            }
            return results*/
		def bases = Clientes.executeQuery("select distinct nombreBase from Clientes where isActive = true")
	}

	static ArrayList<String> getCodigoCampania(){
		/*	def results = Clientes.withCriteria {
                projections{
                    distinct("nombreBase")
                }
                //eq('isActive', true)
            }
            return results*/
		def bases = Clientes.executeQuery("select distinct codigoCampania from Clientes where isActive = true")
	}

	static ArrayList<String> getBasesNoHabiles(){
		def bases = Clientes.executeQuery("select distinct nombreBase from Clientes where isActive = false")
	}

	static ArrayList<Rol> getRoles(){
		def roles = Rol.executeQuery("from Rol where nombre != 'ADMINISTRADOR'");
		return roles;
	}

	/**
	 * @author Giovanny Granda
	 * Solo deja ver los primeros y últimos dígitos de un número de tarjeta
	 */
	static String hideCardNumber(String cardNumber){
		String result = ""
		if(cardNumber.length() > 3)
			result  = /*cardNumber.take(2) +*/ "xxxxxx" + cardNumber.reverse().take(4).reverse()
		else
			result = cardNumber
		return result
	}

	static String muestraCedulaOriginal(String cedula){
		String result = ""
		if(cedula.length() > 10)
			result  =  cedula.reverse().take(10).reverse()
		else
			result = cedula
		return result
	}

	static String hideNumberId(String cardNumber){
		String result = ""
		if(cardNumber.length() > 5)
			result  = cardNumber.reverse().take(2).reverse()
		else
			result = cardNumber
		return result
	}

	static String formatearFechaNacimiento(String entrada){
		return entrada.substring(0, 4) + entrada.substring(5, 7) + entrada.substring(8, 10)
	}

	static Date[] formatearFechasReporte(String fechas){
		String[] arrayFechas = fechas.trim().split('-')
		String inicio = arrayFechas[0].replace('/', '-')
		String fin = arrayFechas[1].replace('/', '-')
		Date fechaInicio = Date.parse("yyyy-MM-dd HH:mm:ss", inicio+" 00:00:00")
		Date fechaFin = Date.parse("yyyy-MM-dd HH:mm:ss", fin+" 23:59:59")
		Date[] Arrayfechas = new Date[2]
		Arrayfechas[0] = fechaInicio
		Arrayfechas[1] = fechaFin
		return Arrayfechas
	}
	static void saveLog(long idUser, String description){

		Log log = new Log()
		Usuario user = Usuario.findById(idUser)
		log.hostName = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes())
				.getRequest().getRemoteHost()
		log.user = user
		log.description = description
		log.save(flush: true)

	}
	static formatearTexto(value){
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
	static int getAExitosasMes(){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		Date fechaInicio = Date.parse("yyyy-MM-dd HH:mm:ss", cal.getTime().format("yyyy-MM-dd 00:00:00"))
		Date fechaFin = Date.parse("yyyy-MM-dd HH:mm:ss", new Date().format("yyyy-MM-dd 23:59:59"))
		def subestados = Subestado.executeQuery("from Subestado where type = 'Exitoso'")
		def exitosas = Clientes.executeQuery("from Clientes a where a.subestadoGestion in (:subestados) and a.fechaGestion between :fechaInicio and :fechaFin", [subestados: subestados, fechaInicio: fechaInicio, fechaFin: fechaFin])
		return exitosas.size()
	}

	static int getContactadosMes(){

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		Date fechaInicio = Date.parse("yyyy-MM-dd HH:mm:ss", cal.getTime().format("yyyy-MM-dd 00:00:00"))
		Date fechaFin = Date.parse("yyyy-MM-dd HH:mm:ss", new Date().format("yyyy-MM-dd 23:59:59"))
		int contactadosQuito = Clientes.executeQuery("from Clientes where estadoGestion = :estado and fechaGestion between :fechaInicio and :fechaFin", [estado: "CONTACTADO", fechaInicio: fechaInicio, fechaFin: fechaFin]).size()
		return contactadosQuito
	}

	static String getContactabilidadMensual(){
		String salida = "0%"
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		Date fechaInicio = Date.parse("yyyy-MM-dd HH:mm:ss", cal.getTime().format("yyyy-MM-dd 00:00:00"))
		Date fechaFin = Date.parse("yyyy-MM-dd HH:mm:ss", new Date().format("yyyy-MM-dd 23:59:59"))
		int contactados = Historial.executeQuery("select count(*) from Historial where estadoGestion = 'CONTACTADO' and fechaGestion between :fechaInicio and :fechaFin", [fechaInicio: fechaInicio, fechaFin: fechaFin]).get(0)
		int gestionados = Historial.executeQuery("select count(*) from Historial where fechaGestion between :fechaInicio and :fechaFin", [fechaInicio: fechaInicio, fechaFin: fechaFin]).get(0)
		DecimalFormat df = new DecimalFormat("#.00")
		if(gestionados != 0)
			salida = (df.format((contactados/gestionados)*100)).toString()+"%"
		return salida

	}

	static String getContactabilidadDiaria(){
		String salida = "0%"
		Date fechaInicio = Date.parse("yyyy-MM-dd HH:mm:ss", new Date().format("yyyy-MM-dd 00:00:00"))
		Date fechaFin = Date.parse("yyyy-MM-dd HH:mm:ss", new Date().format("yyyy-MM-dd 23:59:59"))
		int contactados = Historial.executeQuery("select count(*) from Historial where estadoGestion = 'CONTACTADO' and fechaGestion between :fechaInicio and :fechaFin", [fechaInicio: fechaInicio, fechaFin: fechaFin]).get(0)
		int gestionados = Historial.executeQuery("select count(*) from Historial where fechaGestion between :fechaInicio and :fechaFin", [fechaInicio: fechaInicio, fechaFin: fechaFin]).get(0)
		DecimalFormat df = new DecimalFormat("#.00")
		if(gestionados != 0)
			salida = (df.format((contactados/gestionados)*100)).toString()+"%"
		return salida

	}


	static String getValorPromesaDiario(){
		//String salida = ""
		double salida = 0
		//String sumaTotal = ""
		//String sumaTotal = ""
		String sumaTotal = ""
		double suma = 0
		Date fechaInicio = Date.parse("yyyy-MM-dd HH:mm:ss", new Date().format("yyyy-MM-dd 00:00:00"))
		Date fechaFin = Date.parse("yyyy-MM-dd HH:mm:ss", new Date().format("yyyy-MM-dd 23:59:59"))
		ArrayList<SubSubestado> subestados = Subestado.executeQuery("from Subestado where type = 'Exitoso'")
		DecimalFormat df = new DecimalFormat("#.00")
		def ventas = Clientes.executeQuery("from Clientes where subestadoGestion in (:subestados) and fechaGestion between :fechaInicio and :fechaFin", [subestados: subestados, fechaInicio: fechaInicio, fechaFin: fechaFin])
		for (int i = 0; i < ventas.size(); i++){
			Clientes valores = ventas.get(i)
			salida = Double.parseDouble(valores.valor_promesa.replace(",","."))
			suma = suma + salida
			sumaTotal = df.format(suma)
		}
		return sumaTotal
	}

	/**
	 * @author Andres Redroban
	 * Solo deja ver los primeros y últimos dígitos de un número de tarjeta
	 */
	static String functionAsterisk(String id){
		String result = id
		int valor = 1
		for (int l = 0; l < valor; l++) {
			for(int i = 0; i < result.length(); i++){
				if(result.length() < 8){
					result  = "0" + result
				}
				else{
					if(result.length() > 8){
						break
					}
				}
			}
			if (result.length() == 8) {
				break;
			}
			valor = valor + 1
			println(result)
		}

		return result

	}
	static int getPromesas(){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		Date fechaInicio = Date.parse("yyyy-MM-dd HH:mm:ss", cal.getTime().format("yyyy-MM-dd 00:00:00"))
		Date fechaFin = Date.parse("yyyy-MM-dd HH:mm:ss", new Date().format("yyyy-MM-dd 23:59:59"))
		def subestados = Subestado.executeQuery("from Subestado where id = 28")
		def exitosas = Clientes.executeQuery("from Clientes a where a.subestadoGestion in (:subestados) and a.fechaGestion between :fechaInicio and :fechaFin", [subestados: subestados, fechaInicio: fechaInicio, fechaFin: fechaFin])
		return exitosas.size()
	}
	static String getValorPromesaRegestionable(){
		double salida = 0
		String sumaTotal = ""
		double suma = 0
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		Date fechaInicio = Date.parse("yyyy-MM-dd HH:mm:ss", cal.getTime().format("yyyy-MM-dd 00:00:00"))
		Date fechaFin = Date.parse("yyyy-MM-dd HH:mm:ss", new Date().format("yyyy-MM-dd 23:59:59"))
		ArrayList<SubSubestado> subestados = Subestado.executeQuery("from Subestado where id = 28")
		DecimalFormat df = new DecimalFormat("#.00")
		def ventas = Clientes.executeQuery("from Clientes where subestadoGestion in (:subestados) and fechaGestion between :fechaInicio and :fechaFin", [subestados: subestados, fechaInicio: fechaInicio, fechaFin: fechaFin])
		for (int i = 0; i < ventas.size(); i++){
			Clientes valores = ventas.get(i)
			if (valores.valor_promesa != null){
				println(valores.id)
				salida = Double.parseDouble(valores.valor_promesa.replace(",","."))
				suma = suma + salida
				sumaTotal = df.format(suma)
			}
		}
		return sumaTotal
	}



	/*static ArrayList<String> getHistorial(String identificacion, String nombreBase){
		String salida = ''
		def hitorial = Historial.executeQuery("from Clientes where identificacion = :identificacion and nombreBase = :nombreBase", [identificacion: identificacion, nombreBase: nombreBase])
		ArrayList<String> productos = new ArrayList<>()
		for(int i = 0; i < cliente.size(); i++){
			Clientes c = cliente.get(i)
			productos.add(c.id)
		}
		//salida = productos
		return productos

	}*/

	static ArrayList<String> getHistorial(String ide, String parametro){
		String salida = ''
		String datoEntrada = ide
		ArrayList<String> productos = new ArrayList<>()
		if (parametro == 'BUSCADOR ID'){
			def hitorial = Historial.executeQuery("from Historial where clienteIdentificador = :datoEntrada", [datoEntrada: datoEntrada])
			for(int i = 0; i < hitorial.size(); i++){
				Historial c = hitorial.get(i)
				productos.add(c.id)
			}
		}
		if (parametro == 'FECHA PROMESA INICIAL'){
			def historialPrimeraFechaPago = Historial.executeQuery("from Historial where id = (select min(id) from Historial where clienteIdentificador = :datoEntrada and fecha_promesa is not null and subestadoGestion in (2,28))", [datoEntrada: datoEntrada])
			for(int i = 0; i < historialPrimeraFechaPago.size(); i++){
				Historial c = historialPrimeraFechaPago.get(i)
				productos.add(c.fecha_promesa)
			}
		}
		return productos

	}

	static ArrayList<String> getHistorialFechaPromesa(String ide,  String parametro){
		String salida = ''
		String datoEntrada = ide
		ArrayList<String> productos = new ArrayList<>()
		if (parametro == 'FECHA ANTERIORES'){
			def historialPrimeraFechaPago = Historial.executeQuery("from Historial where clienteIdentificador = :datoEntrada and fecha_promesa is not null and subestadoGestion in (2,28)", [datoEntrada: datoEntrada])
			for(int i = 0; i < historialPrimeraFechaPago.size(); i++){
				Historial c = historialPrimeraFechaPago.get(i)
				productos.add(c.fecha_promesa)
			}
		}
		return productos

	}
}
