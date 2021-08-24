package callcenter

import com.pw.security.*;

class Historial {

	String estadoGestion
	Subestado subestadoGestion
	String subSubEstado
	Date fechaGestion
	int intentos
	String nombreVendedor
	String observacionesGestion
	Usuario usuario
	Clientes cliente
	String plataforma
	String telefonoContactado
	String estadoTelefonoContactado
	String estadoTel1
	String respuestaTel1
	String fechaTelf1
	String observacionTelf1
	String estadoTel2
	String respuestaTel2
	String fechaTelf2
	String observacionTelf2
	String estadoTel3
	String respuestaTel3
	String fechaTelf3
	String observacionTelf3
	String estadoTel4
	String respuestaTel4
	String fechaTelf4
	String observacionTelf4
	String estadoTel5
	String respuestaTel5
	String fechaTelf5
	String observacionTelf5
	String estadoTel6
	String respuestaTel6
	String fechaTelf6
	String observacionTelf6
	String estadoTel7
	String respuestaTel7
	String fechaTelf7
	String observacionTelf7
	String estadoTel8
	String respuestaTel8
	String fechaTelf8
	String observacionTelf8
	String estadoTel9
	String respuestaTel9
	String fechaTelf9
	String observacionTelf9
	String estadoTel10
	String respuestaTel10
	String fechaTelf10
	String observacionTelf10
	String estadoTel11
	String respuestaTel11
	String fechaTelf11
	String observacionTelf11
	String estadoTel12
	String respuestaTel12
	String fechaTelf12
	String observacionTelf12
	String estadoTel13
	String respuestaTel13
	String fechaTelf13
	String observacionTelf13
	String estadoTel14
	String respuestaTel14
	String fechaTelf14
	String observacionTelf14
	String estadoTel15
	String respuestaTel15
	String fechaTelf15
	String observacionTelf15
	String duracionLlamada
	String fechaInicioLlamada
	String fechaFinLlamada
	String valor_promesa
	String fecha_promesa
	String estado_nivel_2
	String clienteIdentificador


	static constraints = {
		estadoGestion nullable: true
		subestadoGestion nullable: true
		subSubEstado nullable: true
		fechaGestion nullable: true
		intentos nullable: true
		nombreVendedor nullable: true
		observacionesGestion nullable: true
		usuario nullable: true
		cliente nullable: true
		plataforma nullable: true
		estadoTelefonoContactado nullable: true
		estadoTel1 nullable: true
		respuestaTel1 nullable: true
		fechaTelf1 nullable: true
		observacionTelf1 nullable: true
		estadoTel2 nullable: true
		respuestaTel2 nullable: true
		fechaTelf2 nullable: true
		observacionTelf2 nullable: true
		estadoTel3 nullable: true
		respuestaTel3 nullable: true
		fechaTelf3 nullable: true
		observacionTelf3 nullable: true
		estadoTel4 nullable: true
		respuestaTel4 nullable: true
		fechaTelf4 nullable: true
		observacionTelf4 nullable: true
		estadoTel5 nullable: true
		respuestaTel5 nullable: true
		fechaTelf5 nullable: true
		observacionTelf5 nullable: true
		estadoTel6 nullable: true
		respuestaTel6 nullable: true
		fechaTelf6 nullable: true
		observacionTelf6 nullable: true
		estadoTel7 nullable: true
		respuestaTel7 nullable: true
		fechaTelf7 nullable: true
		observacionTelf7 nullable: true
		estadoTel8 nullable: true
		respuestaTel8 nullable: true
		fechaTelf8 nullable: true
		observacionTelf8 nullable: true
		estadoTel9 nullable: true
		respuestaTel9 nullable: true
		fechaTelf9 nullable: true
		observacionTelf9 nullable: true
		estadoTel10 nullable: true
		respuestaTel10 nullable: true
		fechaTelf10 nullable: true
		observacionTelf10 nullable: true
		estadoTel11 nullable: true
		respuestaTel11 nullable: true
		fechaTelf11 nullable: true
		observacionTelf11 nullable: true
		estadoTel12 nullable: true
		respuestaTel12 nullable: true
		fechaTelf12 nullable: true
		observacionTelf12 nullable: true
		estadoTel13 nullable: true
		respuestaTel13 nullable: true
		fechaTelf13 nullable: true
		observacionTelf13 nullable: true
		estadoTel14 nullable: true
		respuestaTel14 nullable: true
		fechaTelf14 nullable: true
		observacionTelf14 nullable: true
		estadoTel15 nullable: true
		respuestaTel15 nullable: true
		fechaTelf15 nullable: true
		observacionTelf15 nullable: true
		duracionLlamada nullable: true
		fechaInicioLlamada nullable: true
		fechaFinLlamada nullable: true
		valor_promesa nullable: true
		fecha_promesa nullable: true
		estado_nivel_2 nullable: true
		clienteIdentificador nullable: true


	}
	
	static mapping = {
		version false
		observacionesGestion type: "text"
		observacionTelf1 type: 'text'
		observacionTelf2 type: 'text'
		observacionTelf3 type: 'text'
		observacionTelf4 type: 'text'
		observacionTelf5 type: 'text'
		observacionTelf6 type: 'text'
		observacionTelf7 type: 'text'
		observacionTelf8 type: 'text'
		observacionTelf9 type: 'text'
		observacionTelf10 type: 'text'
		observacionTelf11 type: 'text'
		observacionTelf12 type: 'text'
		observacionTelf13 type: 'text'
		observacionTelf14 type: 'text'
		observacionTelf15 type: 'text'

	}
}
