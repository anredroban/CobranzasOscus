package callcenter
import java.util.Date;
import com.pw.security.*;

class Clientes {

	//Campos de la base
	String codigoCampania//SI
	String nombreCampania//SI
	String nombre //SI
	String identificacion//SI
	String edad//SI
	String telefono1//SI
	String telefono2//SI
	String telefono3//SI
	String telefono5//SI
	String telefono4//SI
	String telefono6//SI
	String telefono7//SI
	String telefono8//SI
	String telefono9//SI
	String telefono10//SI
	String telefono11//SI
	String telefono12//SI
	String telefono13//SI
	String telefono14//SI
	String telefono15//SI



	String tipodocumento
	String numero_identificacion
	String numero_operacion
	String nombre_completo
	String apellidos
	String nombres
	String agencia
	String ciudad
	String provincia
	String sexo
	String estado_civil
	String profesion
	String direccion_1
	String tipo_direccion_1
	String provincia_1
	String direccion_2
	String tipo_direccion_2
	String provincia_2
	String direccion_3
	String tipo_direccion_3
	String provincia_3
	String direccion_4
	String tipo_direccion_4
	String provincia_4
	String direccion_5
	String tipo_direccion_5
	String provincia_5
	String telf_1
	String tipo_telf_1
	String descripcion_tipo_telf_1
	String telf_2
	String tipo_telf_2
	String descripcion_tipo_telf_2
	String telf_3
	String tipo_telf_3
	String descripcion_tipo_telf_3
	String telf_4
	String tipo_telf_4
	String descripcion_tipo_telf_4
	String telf_5
	String tipo_telf_5
	String descripcion_tipo_telf_5
	String numero_identificacion_ref_1
	String nombre_completo_ref_1
	String telefono_ref_1
	String tipo_referencia_ref_1
	String descripcion_ref_1
	String numero_identificacion_ref_2
	String nombre_completo_ref_2
	String telefono_ref_2
	String tipo_referencia_ref_2
	String descripcion_ref_2
	String numero_identificacion_ref_3
	String nombre_completo_ref_3
	String telefono_ref_3
	String tipo_referencia_ref_3
	String tipo_referencia_ref_3_2
	String numero_identificacion_ref_4
	String nombre_completo_ref_4
	String telefono_ref_4
	String tipo_referencia_ref_4
	String numero_identificacion_ref_5
	String nombre_completo_ref_5
	String telefono_ref_5
	String tipo_referencia_ref_5
	String csolicitud
	String cestadotarjeta
	String cestadooperacion
	String calificacion
	String dias_vencidos
	String pagos_vencidos
	String pago_minimo
	String valor_vencido
	String total_a_pagar
	String capital_provision
	String cupo_utilizado
	String int_rec
	String marca_tc
	String tel_propios
	String tel_trabajo
	String tel_familiares
	String total_ref
	String ref_familiar
	String ref_amigos
	String dias_vencidos2
	String plazoGestion

	//Datos Encuesta
	String provinciaGestion
	String ciudadGestion
	String cantonGestion
	String parroquiaGestion
	String callePrincipalGestion
	String numeroCasaGestion
	String calleSecundariaGestion
	String referenciaGestion
	String valor_promesa
	String fecha_promesa
	String valoresPendientesTc
	String tipoBase


	//Campos que SIEMPRE van en la gestión
	Date fechaGestion
	int intentos
	String estadoGestion
	Subestado subestadoGestion
	String subSubEstado
	Usuario usuario
	String nombreBase
	String nombreVendedor
	Date fechaRellamada
	String observaciones
	String motivoNoDesea
	String telefonoContactado
	boolean isActive
	String registroExitoso
	String codigoAsignacion //SI
	String agendamientoAsesor
	String motivoNoAceptaSeguro
	String fechaInicioLlamada
	String fechaFinLlamada

	/*Creacion de campos solicitados por el area de Reporting 2019-05-11*/
	String tipo_cartera
	String provincia_segmentacion
	String pagos_vencidos_segmentacion
	String rango_condonacion
	String rango_refinanciamiento
	String segmentacion_ad1
	String segmentacion_ad2
	String segmentacion_ad3
	String segmentacion_ad4
	String easy_tipo_cartera
	String easy_code_provincia
	String easy_code_pagos_vencidos
	String easy_code_condonacion
	String easy_code_refinanciamiento
	String easyCodeAd1
	String easyCodeAd2
	String easyCodeAd3
	String easyCodeAd4
	String easyCodeAd5
	String prioridadCampania
	String fechaCaducidad
	String deudaProtegida
	String metaContactabilidad
	String metaEfectividadTelefonica
	String metaEfectividadReal
	String tipoGestion
	String plataforma
	String estadoTelefonoContactado

	String meta_mensual_jep //fecha_gestion_anterior
	String operaciones_jep //estado_anterior
	String semana_gestion // valor_promesa_anterior
	String faltante_pw //fecha_promesa_anterior
	String objetivo_diario_pw //fecha_gestion_anterior2
	String riesgo_jep //estado_anterior2
	String valor_promesa_anterior2
	String fecha_de_pago //fecha_promesa_anterior2
	String estado_nivel_2

	String valorCondonacion
	String nombreCondonacionAgencia
	String fechaVisitaAgenciaCondonacion
	String observacionesCondonacion
	String valor_condonado
	Provincia provinciaPromesa
	Ciudad ciudadPromesa
	Canton cantonPromesa
	Parroquia parroquiaPromesa
	//actualizacion iess
	String agenciaId
	String estadoNivel4

	String telefonoDomicilio
	String celular
	String fechacorteestadocuenta
	String cupoAutorizado
	String saldoDisponible
	String pagocontado
	String pagominimotope
	String fechaUltimoPago
	String montoUltimoPago
	String pagosDelMes
	String deudaVencida
	String sobregiro
	String numeroPagosVencidos


	static constraints = {
		//Campos de la base
		provinciaPromesa nullable: true
		ciudadPromesa nullable: true
		cantonPromesa nullable: true
		parroquiaPromesa nullable: true
		codigoCampania nullable: true
		nombreCampania nullable: true
		identificacion nullable: true
		nombre nullable: true
		edad nullable: true
		telefono1 nullable: true
		telefono2 nullable: true
		telefono3 nullable: true
		telefono4 nullable: true
		telefono5 nullable: true
		telefono6 nullable: true
		telefono7 nullable: true
		telefono8 nullable: true
		telefono9 nullable: true
		telefono10 nullable: true
		telefono11 nullable: true
		telefono12 nullable: true
		telefono13 nullable: true
		telefono14 nullable: true
		telefono15 nullable: true
		codigoAsignacion nullable: true
		fechaInicioLlamada nullable: true
		fechaFinLlamada nullable: true
		valor_condonado nullable: true


		/*----Encuesta----*/
		tipodocumento nullable: true
		numero_identificacion nullable: true
		numero_operacion nullable: true
		nombre_completo nullable: true
		apellidos nullable: true
		nombres nullable: true
		agencia nullable: true
		ciudad nullable: true
		provincia nullable: true
		sexo nullable: true
		estado_civil nullable: true
		profesion nullable: true
		direccion_1 nullable: true
		tipo_direccion_1 nullable: true
		provincia_1 nullable: true
		direccion_2 nullable: true
		tipo_direccion_2 nullable: true
		provincia_2 nullable: true
		direccion_3 nullable: true
		tipo_direccion_3 nullable: true
		provincia_3 nullable: true
		direccion_4 nullable: true
		tipo_direccion_4 nullable: true
		provincia_4 nullable: true
		direccion_5 nullable: true
		tipo_direccion_5 nullable: true
		provincia_5 nullable: true
		telf_1 nullable: true
		tipo_telf_1 nullable: true
		descripcion_tipo_telf_1 nullable: true
		telf_2 nullable: true
		tipo_telf_2 nullable: true
		descripcion_tipo_telf_2 nullable: true
		telf_3 nullable: true
		tipo_telf_3 nullable: true
		descripcion_tipo_telf_3 nullable: true
		telf_4 nullable: true
		tipo_telf_4 nullable: true
		descripcion_tipo_telf_4 nullable: true
		telf_5 nullable: true
		tipo_telf_5 nullable: true
		descripcion_tipo_telf_5 nullable: true
		numero_identificacion_ref_1 nullable: true
		nombre_completo_ref_1 nullable: true
		telefono_ref_1 nullable: true
		tipo_referencia_ref_1 nullable: true
		descripcion_ref_1 nullable: true
		numero_identificacion_ref_2 nullable: true
		nombre_completo_ref_2 nullable: true
		telefono_ref_2 nullable: true
		tipo_referencia_ref_2 nullable: true
		descripcion_ref_2 nullable: true
		numero_identificacion_ref_3 nullable: true
		nombre_completo_ref_3 nullable: true
		telefono_ref_3 nullable: true
		tipo_referencia_ref_3 nullable: true
		tipo_referencia_ref_3_2 nullable: true
		numero_identificacion_ref_4 nullable: true
		nombre_completo_ref_4 nullable: true
		telefono_ref_4 nullable: true
		tipo_referencia_ref_4 nullable: true
		numero_identificacion_ref_5 nullable: true
		nombre_completo_ref_5 nullable: true
		telefono_ref_5 nullable: true
		tipo_referencia_ref_5 nullable: true
		csolicitud nullable: true
		cestadotarjeta nullable: true
		cestadooperacion nullable: true
		calificacion nullable: true
		dias_vencidos nullable: true
		pagos_vencidos nullable: true
		pago_minimo nullable: true
		valor_vencido nullable: true
		total_a_pagar nullable: true
		capital_provision nullable: true
		cupo_utilizado nullable: true
		int_rec nullable: true
		marca_tc nullable: true
		tel_propios nullable: true
		tel_trabajo nullable: true
		tel_familiares nullable: true
		total_ref nullable: true
		ref_familiar nullable: true
		ref_amigos nullable: true
		dias_vencidos2 nullable: true
		estadoNivel4 nullable: true
		plazoGestion nullable: true

		provinciaGestion nullable: true
		ciudadGestion nullable: true
		cantonGestion nullable: true
		parroquiaGestion nullable: true
		callePrincipalGestion nullable: true
		numeroCasaGestion nullable: true
		calleSecundariaGestion nullable: true
		referenciaGestion nullable: true
		valor_promesa nullable: true
		fecha_promesa nullable: true
		valoresPendientesTc nullable: true
		tipoBase nullable: true

		telefonoDomicilio nullable: true
		celular nullable: true
		fechacorteestadocuenta nullable: true
		cupoAutorizado nullable: true
		saldoDisponible nullable: true
		pagocontado nullable: true
		pagominimotope nullable: true
		fechaUltimoPago nullable: true
		montoUltimoPago nullable: true
		pagosDelMes nullable: true
		deudaVencida nullable: true
		sobregiro nullable: true
		numeroPagosVencidos nullable: true


		//Campos que SIEMPRE van en la gestión
		fechaGestion nullable: true
		intentos nullable: true
		estadoGestion nullable: true
		subestadoGestion nullable: true
		subSubEstado nullable: true
		usuario nullable: true
		nombreBase nullable: true
		nombreVendedor nullable: true
		fechaRellamada nullable: true
		observaciones nullable: true
		motivoNoDesea nullable: true

		isActive nullable: true
		telefonoContactado nullable: true
		motivoNoAceptaSeguro nullable: true
		agendamientoAsesor nullable: true
		registroExitoso nullable: true
		estado_nivel_2 nullable: true

		/*Creacion de campos solicitados por el area de Reporting 2019-05-11*/
		tipo_cartera nullable: true
		provincia_segmentacion nullable: true
		pagos_vencidos_segmentacion nullable: true
		rango_condonacion nullable: true
		rango_refinanciamiento nullable: true
		segmentacion_ad1 nullable: true
		segmentacion_ad2 nullable: true
		segmentacion_ad3 nullable: true
		segmentacion_ad4 nullable: true
		easy_tipo_cartera nullable: true
		easy_code_provincia nullable: true
		easy_code_pagos_vencidos nullable: true
		easy_code_condonacion nullable: true
		easy_code_refinanciamiento nullable: true
		easyCodeAd1 nullable: true
		easyCodeAd2 nullable: true
		easyCodeAd3 nullable: true
		easyCodeAd4 nullable: true
		easyCodeAd5 nullable: true
		prioridadCampania nullable: true
		fechaCaducidad nullable: true
		deudaProtegida nullable: true
		metaContactabilidad nullable: true
		metaEfectividadTelefonica nullable: true
		metaEfectividadReal nullable: true
		tipoGestion nullable: true
		plataforma nullable: true
		estadoTelefonoContactado nullable: true

		meta_mensual_jep nullable: true
		operaciones_jep nullable: true
		riesgo_jep nullable: true
		objetivo_diario_pw nullable: true
		faltante_pw nullable: true
		fecha_de_pago nullable: true
		valor_promesa_anterior2 nullable: true
		semana_gestion nullable: true

		valorCondonacion nullable: true
		nombreCondonacionAgencia nullable: true
		fechaVisitaAgenciaCondonacion nullable: true
		observacionesCondonacion nullable: true
		agenciaId nullable: true


	}

	static mapping = {
		version false
		observaciones type: 'text'
	}

	static String[] getFields(){
		String[] fields = [
							"identificacion",
							"nombre",

							"fechacorteestadocuenta",
							"cupoAutorizado",
							"saldoDisponible",
							"pagocontado",
							"pagominimotope",
							"fechaUltimoPago",
							"montoUltimoPago",
							"pagosDelMes",
							"deudaVencida",
							"sobregiro",

							'tipodocumento',
							'numero_identificacion',
							'numero_operacion',
							'nombre_completo',
							'apellidos',
							'nombres',
							'agencia',
							'ciudad',
							'provincia',
							'sexo',
							'estado_civil',
							'profesion',
							'direccion_1',
							'tipo_direccion_1',
							'provincia_1',
							'direccion_2',
							'tipo_direccion_2',
							'provincia_2',
							'direccion_3',
							'tipo_direccion_3',
							'provincia_3',
							'direccion_4',
							'tipo_direccion_4',
							'provincia_4',
							'direccion_5',
							'tipo_direccion_5',
							'provincia_5',
							'telf_1',
							'tipo_telf_1',
							'descripcion_tipo_telf_1',
							'telf_2',
							'tipo_telf_2',
							'descripcion_tipo_telf_2',
							'telf_3',
							'tipo_telf_3',
							'descripcion_tipo_telf_3',
							'telf_4',
							'tipo_telf_4',
							'descripcion_tipo_telf_4',
							'telf_5',
							'tipo_telf_5',
							'descripcion_tipo_telf_5',
							'numero_identificacion_ref_1',
							'nombre_completo_ref_1',
							'telefono_ref_1',
							'tipo_referencia_ref_1',
							'descripcion_ref_1',
							'numero_identificacion_ref_2',
							'nombre_completo_ref_2',
							'telefono_ref_2',
							'tipo_referencia_ref_2',
							'descripcion_ref_2',
							'numero_identificacion_ref_3',
							'nombre_completo_ref_3',
							'telefono_ref_3',
							'tipo_referencia_ref_3',
							'tipo_referencia_ref_3_2',
							'numero_identificacion_ref_4',
							'nombre_completo_ref_4',
							'telefono_ref_4',
							'tipo_referencia_ref_4',
							'numero_identificacion_ref_5',
							'nombre_completo_ref_5',
							'telefono_ref_5',
							'tipo_referencia_ref_5',
							'csolicitud',
							'cestadotarjeta',
							'cestadooperacion',
							'calificacion',
							'dias_vencidos',
							'pagos_vencidos',
							'pago_minimo',
							'valor_vencido',
							'total_a_pagar',
							'capital_provision',
							'cupo_utilizado',
							'int_rec',
							'marca_tc',
							'tel_propios',
							'tel_trabajo',
							'tel_familiares',
							'total_ref',
							'ref_familiar',
							'ref_amigos',
							'dias_vencidos2',
						   "telefono1",
						   "telefono2",
						   "telefono3",
						   "telefono4",
						   "telefono5",
						   "telefono6",
						   "telefono7",
						   "telefono8",
						   "telefono9",
						   "telefono10",
						   "telefono11",
						   "telefono12",
						   "telefono13",
						   "telefono14",
						   "telefono15",
						   "codigoAsignacion"
						   , "tipo_cartera"
						   , "provincia_segmentacion"
						   , "pagos_vencidos_segmentacion"
						   , "rango_condonacion"
						   , "rango_refinanciamiento"
						   , "segmentacion_ad1"
						   , "segmentacion_ad2"
						   , "segmentacion_ad3"
						   , "segmentacion_ad4"
						   , "easy_tipo_cartera"
						   , "easy_code_provincia"
						   , "easy_code_pagos_vencidos"
						   , "easy_code_condonacion"
						   , "easy_code_refinanciamiento"
						   , "easyCodeAd1"
						   , "easyCodeAd2"
						   , "easyCodeAd3"
						   , "easyCodeAd4"
						   , "easyCodeAd5"
						   , "prioridadCampania"
						   , "fechaCaducidad"
						   , "deudaProtegida"
						   , "metaContactabilidad"
						   , "metaEfectividadTelefonica"
						   , "metaEfectividadReal"
						   , "plataforma"
		]
		return fields
	}
	static HashMap getTiposParientes(){
		return ['': '-- Seleccione --', '00':'Ninguno', '01': 'Padre', '02': 'Madre', '03': 'Hermano(a)', '04': 'Primo(a)',
				'05': 'Tío(a)', '06': 'Sobrino(a)', '07': 'Esposa(o)', '08': 'Cuñado', '09': 'Yerno (Nuera)', '10': 'Suegro(a)', '11': 'Hijo(a)',
				'12': 'Amigo(a)', '13': 'Abuelo(a)', '14': 'Novio (a)', '15': 'Nieto (a)', '16': 'Compañero de Trabajo', '17': 'Familiar',
				'18': 'Representante Legal', '19': 'Relación Comercial', '20': 'Relación Laboral', '21': 'Presidente', '22': 'Vice-presidente',
				'23': 'Funcionario', '24': 'Ejecutivo']
	}
}
