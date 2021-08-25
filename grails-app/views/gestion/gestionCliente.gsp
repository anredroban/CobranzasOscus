<meta name="layout" content="main">
<%@ page contentType="text/html;charset=UTF-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta charset="utf-8" />
<!--This is what you should include-->
<meta http-equiv="content-type" content="application/vnd.ms-excel; charset=UTF-8">
<asset:stylesheet src="usogeneral/bootstrap-datepicker.min.css"></asset:stylesheet>

<div class="container-fluid">
	<title>Gestionar Cliente</title>

<asset:stylesheet src="usogeneral/datetimepicker.css" />
<asset:stylesheet src="gestion/gestionCliente.css" />

<asset:javascript src="usogeneral/jquery-ui.min.js" />
<asset:stylesheet src="usogeneral/breadcrumb.css" />
<asset:javascript src="usogeneral/breadcrumb.js" />

<script>
    window.setInterval (BlinkIt, 500);
    var color = "red";
    function BlinkIt () {
        var blink = document.getElementById ("blink");
        color = (color == "#ffffff")? "red" : "#ffffff";
        blink.style.color = color;
        blink.style.fontSize='36px';}
</script>


<div class="col-lg-12 col-md-12 col-xs-12">
	<br><h1><span class="fa fa-phone"></span> Gestionar Cliente</h1>
</div>
<g:form action="guardarCliente">

	<%--<g:if test="${cliente.registroExitoso == 'SI'}">
		<div class="col-lg-12 col-md-12 col-xs-12">
			<label id="blink" style="font-size: 28px; font-weight: bold; color: red" >¡AVISO! </label><span id="priodidadTc" style="font-size: 28px; font-weight: bold; color: red">CLIENTE CONTACTADO NO GESTIONAR</span>
		</div>
	</g:if>--%>

	<g:if test="${cliente.subestadoGestion != null}">
		<g:if test="${cliente.subestadoGestion.id == 28}">
			<div class="col-md-8"><div class="alert alert-success" role="alert"><i class="fa fa-fw fa-exclamation-triangle" style="font-size: 30px"></i><span style="font-size: 26px; font-weight: bold">ATENCIÓN</span><span style="font-size: 24px"> CLIENTE CON ESTADO PROMESA DE PAGO</span></div></div>
			<div style="border-radius: 30px" class="panel panel-default col-lg-12 col-md-12 col-xs-12">
				<div class="col-lg-12 col-md-12 col-xs-12" style="font-size: 20px">
					<label>GESTIÓN: </label> <span style="color: #2c3c53; font-weight: bold; font-size: 24px" >${resultado}</span>
				</div>
				<div class="col-lg-12 col-md-12 col-xs-12" style="font-size: 20px">
					<label>PROMESA DE PAGO: </label> ${cliente.valor_promesa}
				</div>
				<div class="col-lg-12 col-md-12 col-xs-12" style="font-size: 20px">
					<label>FECHA PROMESA DE PAGO INICIAL: </label> <g:each in="${utilitarios.Util.getHistorial(cliente.id.toString(), 'FECHA PROMESA INICIAL')}">${it}</g:each>
				</div>
				<div class="col-lg-12 col-md-12 col-xs-12" style="font-size: 20px">
					<label>FECHAS PROMESA ANTERIORES: </label><br>
					<g:each in="${utilitarios.Util.getHistorialFechaPromesa(cliente.id.toString(), 'FECHA ANTERIORES')}">
						<li style="list-style: none">${it}</li>
					</g:each>
				</div>
				<div class="col-lg-12 col-md-12 col-xs-12" style="font-size: 20px">
					<label>PROVINCIA: </label> ${cliente.provinciaGestion}
				</div>
				<div class="col-lg-12 col-md-12 col-xs-12" style="font-size: 20px">
					<label>CIUDAD: </label> ${cliente.ciudadGestion}
				</div>
				<div class="col-lg-12 col-md-12 col-xs-12" style="font-size: 20px">
					<label>CANTON: </label> ${cliente.cantonGestion}
				</div>
				<div class="col-lg-12 col-md-12 col-xs-12" style="font-size: 20px">
					<label>PARROQUIA: </label> ${cliente.parroquiaGestion}
				</div>
			</div>

		</g:if>
	</g:if>


	<div class="col-lg-12 col-md-12 col-xs-12">
		<h5> <b>Datos del Cliente</b></h5>
	</div>
<div style="border-radius: 30px" class="panel panel-default col-lg-12 col-md-12 col-xs-12">
	<div class="form-group col-lg-4 col-md-6 col-xs-12">
		<label>Nombre Cliente: </label>
		${cliente.nombre}
	</div>
	<div class="form-group col-lg-4 col-md-6 col-xs-12">
		<label>Identificación: </label>
		${cliente.identificacion}
	</div>
	<g:if test="${cliente.numero_operacion&& cliente.numero_operacion.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Número de Operación: </label>
			${cliente.numero_operacion}
		</div>
	</g:if>
	<g:if test="${cliente.sexo && cliente.sexo.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Sexo: </label>
			${cliente.sexo}
		</div>
	</g:if>
	<g:if test="${cliente.estado_civil && cliente.estado_civil.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Estado Civil: </label>
			${cliente.estado_civil}
		</div>
	</g:if>

	<g:if test="${cliente.profesion && cliente.profesion.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Profesion: </label>
			${cliente.profesion}
		</div>
	</g:if>
	<g:if test="${cliente.provincia_1 && cliente.provincia_1.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Provincia 1: </label>
			${cliente.provincia_1}
		</div>
	</g:if>
	<g:if test="${cliente.direccion_1 && cliente.direccion_1.trim() != ''}">
		<div class="form-group col-lg-12 col-md-12 col-xs-12">
			<label>Dirección 1: </label>
			${cliente.direccion_1}
		</div>
	</g:if>
	<g:if test="${cliente.pagos_vencidos && cliente.pagos_vencidos.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Pagos Vencidos: </label>
			${cliente.pagos_vencidos}
		</div>
	</g:if>
	<g:if test="${cliente.pago_minimo && cliente.pago_minimo.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Pago Mínimo: </label>
			${cliente.pago_minimo}
		</div>
	</g:if>
	<g:if test="${cliente.valor_vencido && cliente.valor_vencido.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Valor Vencido: </label>
			${cliente.valor_vencido}
		</div>
	</g:if>
	<g:if test="${cliente.total_a_pagar && cliente.total_a_pagar.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label style="color: red">Total a Pagar: </label>
			${cliente.total_a_pagar}
		</div>
	</g:if>

	<g:if test="${cliente.marca_tc && cliente.marca_tc.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Marca TC: </label>
			${cliente.marca_tc}
		</div>
	</g:if>
	<g:if test="${cliente.int_rec && cliente.int_rec.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label style="color: red">Int REC: </label>
			${cliente.int_rec}
		</div>
	</g:if>
	<g:if test="${cliente.calificacion && cliente.calificacion.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Calificación: </label>
			${cliente.calificacion}
		</div>
	</g:if>
	<g:if test="${cliente.capital_provision && cliente.capital_provision.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Capital Provisión: </label>
			${cliente.capital_provision}
		</div>
	</g:if>
	<g:if test="${cliente.valorCondonacion && cliente.valorCondonacion.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label style="color: red">Valor Condonación: </label>
			${cliente.valorCondonacion}
		</div>
	</g:if>
	<g:if test="${cliente.valoresPendientesTc && cliente.valoresPendientesTc.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Valores Pendientes TC: </label>
			${cliente.valoresPendientesTc}
		</div>
	</g:if>
	<g:if test="${cliente.tipoBase && cliente.tipoBase.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Tipo Base: </label>
			${cliente.tipoBase}
		</div>
	</g:if>
	<g:if test="${cliente.valor_condonado && cliente.valor_condonado.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Valor Condonado: </label>
			${cliente.valor_condonado}
		</div>
	</g:if>
	<g:if test="${cliente.segmentacion_ad4 && cliente.segmentacion_ad4.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Recuperación: </label>
			${cliente.segmentacion_ad4}
		</div>
	</g:if>
	<g:if test="${cliente.agenciaId && cliente.agenciaId.trim() != ''}">
	<div class="form-group col-lg-4 col-md-6 col-xs-12">
		<label>Salario IESS: </label>
		${cliente.agenciaId}
	</div>
	</g:if>
		<g:if test="${cliente.deudaProtegida && cliente.deudaProtegida.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Fecha Afiliación IESS: </label>
			${cliente.deudaProtegida}
		</div>
	</g:if>
	<g:if test="${cliente.deudaVencida && cliente.deudaVencida.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Deuda Vencida: </label>
			${cliente.deudaVencida}
		</div>
	</g:if>
	<g:if test="${cliente.cupo_utilizado && cliente.cupo_utilizado.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Cupo Utilizado: </label>
			${cliente.cupo_utilizado}
		</div>
	</g:if>
	<g:if test="${cliente.dias_vencidos && cliente.dias_vencidos.trim() != ''}">
		<div style="color: black; font-weight: bold; font-size: 18px" class="form-group col-lg-12 col-md-12 col-xs-12">
			<label>Dias Vencidos: </label>
			${cliente.dias_vencidos}
		</div>

			<div class="col-lg-12 col-md-12 col-xs-12">
				<label id="blink" style="font-size: 28px; font-weight: bold; color: red" >${estadoNivel}</label>
			</div>

	</g:if>
	<%--<g:if test="${cliente.numeroOperaciones && cliente.numeroOperaciones.trim() != '' && cliente.numeroOperaciones.trim() > '1'}">
		<div class="form-group col-lg-12 col-md-12 col-xs-12">
			<label style="font-size: 28px; font-weight: bold; color: red">Número de Operaciones: </label>
			<label id="blink" style="font-size: 28px; font-weight: bold; color: red" >${cliente.numeroOperaciones}</label>
		</div>
		<div class="form-group col-lg-12 col-md-12 col-xs-12">
		<p><strong style="font-size: 20px">Id´s pertenecientes al cliente:</strong></p>
		<p>
			<blockquote>
		${utilitarios.Util.getNumOperaciones2(cliente.identificacion, cliente.nombreBase)}
		</blockquote>
   </p>
   </div>
	</g:if>--%>
	<%--<g:if test="${cliente.clientesMasUnaOperacion && cliente.clientesMasUnaOperacion.trim() != '' && cliente.clientesMasUnaOperacion.trim() > '1'}">
		<div class="form-group col-lg-12 col-md-12 col-xs-12">
			<label style="font-size: 28px; font-weight: bold; color: red">Número de Operaciones: </label>
			<label id="blink" style="font-size: 28px; font-weight: bold; color: red" >${cliente.clientesMasUnaOperacion}</label>
		</div>
		<div class="form-group col-lg-12 col-md-12 col-xs-12">
		<p><strong style="font-size: 20px">Id´s pertenecientes al cliente:</strong></p>
		<p>
			<blockquote>
		        ${utilitarios.Util.getNumOperaciones2(cliente.identificacion, cliente.nombreBase)}
			 </blockquote>
		</p>
		</div>
	</g:if>--%>
</div>

<g:if test="${cliente.semana_gestion && cliente.semana_gestion.trim() != ''}">
	<div class="col-lg-12 col-md-12 col-xs-12">
		<h5> <b>Datos de Saldos Anteriores</b></h5>
	</div>
	<div style="border-radius: 30px" class="panel panel-default col-lg-12 col-md-12 col-xs-12">

		<g:if test="${cliente.meta_mensual_jep && cliente.meta_mensual_jep.trim() != ''}">
			<div class="form-group col-lg-4 col-md-6 col-xs-12">
				<label>Fecha Gestión Anterior: </label>
				${cliente.meta_mensual_jep}
			</div>
		</g:if>
		<g:if test="${cliente.operaciones_jep && cliente.operaciones_jep.trim() != ''}">
			<div class="form-group col-lg-4 col-md-6 col-xs-12">
				<label>Estado Anterior: </label>
				${cliente.operaciones_jep}
			</div>
		</g:if>
		<g:if test="${cliente.semana_gestion && cliente.semana_gestion.trim() != ''}">
			<div class="form-group col-lg-4 col-md-6 col-xs-12">
				<label>Valor Promesa Anterior: </label>
				${cliente.semana_gestion}
			</div>
		</g:if>
		<g:if test="${cliente.faltante_pw && cliente.faltante_pw.trim() != ''}">
			<div class="form-group col-lg-4 col-md-6 col-xs-12">
				<label>Fecha Promesa Anterior: </label>
				${cliente.faltante_pw}
			</div>
		</g:if>
		<g:if test="${cliente.objetivo_diario_pw && cliente.objetivo_diario_pw.trim() != ''}">
			<div class="form-group col-lg-4 col-md-6 col-xs-12">
				<label>Fecha Gestión Anterior 2: </label>
				${cliente.objetivo_diario_pw}
			</div>
		</g:if>
		<g:if test="${cliente.riesgo_jep && cliente.riesgo_jep.trim() != ''}">
			<div class="form-group col-lg-4 col-md-6 col-xs-12">
				<label>Estado Anterior 2: </label>
				${cliente.riesgo_jep}
			</div>
		</g:if>
		<g:if test="${cliente.valor_promesa_anterior2 && cliente.valor_promesa_anterior2.trim() != ''}">
			<div class="form-group col-lg-4 col-md-6 col-xs-12">
				<label>Valor Promesa Anterior 2: </label>
				${cliente.valor_promesa_anterior2}
			</div>
		</g:if>
		<g:if test="${cliente.fecha_de_pago && cliente.fecha_de_pago.trim() != ''}">
			<div class="form-group col-lg-4 col-md-6 col-xs-12">
				<label>Fecha Promesa Anterior 2: </label>
				${cliente.fecha_de_pago}
			</div>
		</g:if>

	</div>
</g:if>



	<%--<g:if test="${cliente.segmentacionAd1 && cliente.segmentacionAd1.trim() != '' && cliente.segmentacionAd1.trim() > '1'}">
		<div class="form-group col-lg-12 col-md-12 col-xs-12">
		<p><strong style="font-size: 20px">Id´s pertenecientes al cliente:</strong></p>
		<p>
			<blockquote>
		<g:each in="${utilitarios.Util.getHistorial(cliente.id.toString(), 'BUSCADOR ID')}">
				<li>${it}</li>
		</g:each>
		</blockquote>
        </p>
       </div>
	</g:if>

	<g:if test="${cliente.segmentacionAd1 && cliente.segmentacionAd1.trim() != '' && cliente.segmentacionAd1.trim() > '1'}">
		<div class="form-group col-lg-12 col-md-12 col-xs-12">
		<p><strong style="font-size: 20px">Fecha Promesa Inicial:</strong></p>
		<p>
			<blockquote>
		<g:each in="${utilitarios.Util.getHistorial(cliente.id.toString(), 'FECHA PROMESA INICIAL')}">
			<li>${it}</li>
		</g:each>
		</blockquote>
        </p>
       </div>
	</g:if>--%>

<%--INICIO DE COMENTARIOS--%>

<div class="col-lg-12 col-md-12 col-xs-12">
	<h5> <b>Datos de Contácto (Números PROPIOS)</b></h5>
</div>

<div style="border-radius: 30px" class="panel panel-default col-lg-12 col-md-12 col-xs-12">
	<g:if test="${cliente.telefono1}">
		<div class="col-lg-12 col-md-12 col-xs-12">
			<div id="number1" class="form-group col-lg-12 col-md-12 col-xs-12">
				<label style="color: red" ><span class="fa fa-mobile-phone"></span> Teléfono 1: </label>
				${cliente.telefono1}
			</div>
			<div class="form-group col-lg-5 col-md-5 col-xs-12">
					<g:select class="form-control" id="estadoTel1" name="estadoTel1" from="${['51':'LLAMADA DEUDOR Y/O CONYUGE','52':'LLAMADA CONYUGUE DEUDOR','53':'LLAMADA GARANTE Y/O CONYUGE GARANTE','54':'LLAMADA CONYUGUE GARANTE','55':'LLAMADA FAMILIAR','56':'LLAMADA OTROS','0':'EQUIVOCADO']}" noSelection="${['': '-- Seleccione --']}" optionValue="value" optionKey="key" />
			</div>
			<div class="form-group col-lg-5 col-md-5 col-xs-12">
				<g:select class="form-control" id="respuestaTel1" name="respuestaTel1" from="${['1':'CONTACTADO','0':'NO CONTESTA/NO SATISFACTORIA']}" noSelection="${['': '-- Seleccione --']}" optionValue="value" optionKey="key" />
			</div>
			<div class="form-group col-lg-2 col-md-2 col-xs-12">
				<g:textField id="fechaTelf1" name="fechaTelf1" class="form-control" onkeypress="return soloLetras(event)"/>
			</div>
			<div class="form-group col-lg-12 col-md-12 col-xs-12">
				<label>Observación: </label>
				<g:textField id="observacionTelf1" name="observacionTelf1" class="form-control"/>
			</div>
		</div>
	</g:if>
	<g:if test="${cliente.telefono2}">
		<div class="col-lg-12 col-md-12 col-xs-12">
			<div id="number2" class="form-group col-lg-12 col-md-12 col-xs-12">
				<label style="color: red" ><span class="fa fa-mobile-phone"></span> Teléfono 2: </label>
				${cliente.telefono2}
			</div>
			<div class="form-group col-lg-5 col-md-5 col-xs-12">
				<g:select class="form-control" id="estadoTel2" name="estadoTel2" from="${['51':'LLAMADA DEUDOR Y/O CONYUGE','52':'LLAMADA CONYUGUE DEUDOR','53':'LLAMADA GARANTE Y/O CONYUGE GARANTE','54':'LLAMADA CONYUGUE GARANTE','55':'LLAMADA FAMILIAR','56':'LLAMADA OTROS','0':'EQUIVOCADO']}" noSelection="${['': '-- Seleccione --']}" optionValue="value" optionKey="key" />
			</div>
			<div class="form-group col-lg-5 col-md-5 col-xs-12">
				<g:select class="form-control" id="respuestaTel2" name="respuestaTel2" from="${['1':'CONTACTADO','0':'NO CONTESTA/NO SATISFACTORIA']}" noSelection="${['': '-- Seleccione --']}" optionValue="value" optionKey="key" />
			</div>
			<div class="form-group col-lg-2 col-md-2 col-xs-12">
				<g:textField id="fechaTelf2" name="fechaTelf2" class="form-control" onkeypress="return soloLetras(event)"/>
			</div>
			<div class="form-group col-lg-12 col-md-12 col-xs-12">
				<label>Observación: </label>
				<g:textField id="observacionTelf2" name="observacionTelf2" class="form-control"/>
			</div>
		</div>
	</g:if>
	<g:if test="${cliente.telefono3}">
		<div class="col-lg-12 col-md-12 col-xs-12">
			<div id="number3" class="form-group col-lg-12 col-md-12 col-xs-12">
				<label style="color: red" ><span class="fa fa-mobile-phone"></span> Teléfono 3: </label>
				${cliente.telefono3}
			</div>
			<div class="form-group col-lg-5 col-md-5 col-xs-12">
				<g:select class="form-control" id="estadoTel3" name="estadoTel3" from="${['51':'LLAMADA DEUDOR Y/O CONYUGE','52':'LLAMADA CONYUGUE DEUDOR','53':'LLAMADA GARANTE Y/O CONYUGE GARANTE','54':'LLAMADA CONYUGUE GARANTE','55':'LLAMADA FAMILIAR','56':'LLAMADA OTROS','0':'EQUIVOCADO']}" noSelection="${['': '-- Seleccione --']}" optionValue="value" optionKey="key" />
			</div>
			<div class="form-group col-lg-5 col-md-5 col-xs-12">
				<g:select class="form-control" id="respuestaTel3" name="respuestaTel3" from="${['1':'CONTACTADO','0':'NO CONTESTA/NO SATISFACTORIA']}" noSelection="${['': '-- Seleccione --']}" optionValue="value" optionKey="key" />
			</div>
			<div class="form-group col-lg-2 col-md-2 col-xs-12">
				<g:textField id="fechaTelf3" name="fechaTelf3" class="form-control" onkeypress="return soloLetras(event)"/>
			</div>
			<div class="form-group col-lg-12 col-md-12 col-xs-12">
				<label>Observación: </label>
				<g:textField id="observacionTelf3" name="observacionTelf3" class="form-control"/>
			</div>
		</div>
	</g:if>
	<g:if test="${cliente.telefono4}">
		<div class="col-lg-12 col-md-12 col-xs-12">
			<div id="number4" class="form-group col-lg-12 col-md-12 col-xs-12">
				<label style="color: red" ><span class="fa fa-mobile-phone"></span> Teléfono 4: </label>
				${cliente.telefono4}
			</div>
			<div class="form-group col-lg-5 col-md-5 col-xs-12">
				<g:select class="form-control" id="estadoTel4" name="estadoTel4" from="${['51':'LLAMADA DEUDOR Y/O CONYUGE','52':'LLAMADA CONYUGUE DEUDOR','53':'LLAMADA GARANTE Y/O CONYUGE GARANTE','54':'LLAMADA CONYUGUE GARANTE','55':'LLAMADA FAMILIAR','56':'LLAMADA OTROS','0':'EQUIVOCADO']}" noSelection="${['': '-- Seleccione --']}" optionValue="value" optionKey="key" />
			</div>
			<div class="form-group col-lg-5 col-md-5 col-xs-12">
				<g:select class="form-control" id="respuestaTel4" name="respuestaTel4" from="${['1':'CONTACTADO','0':'NO CONTESTA/NO SATISFACTORIA']}" noSelection="${['': '-- Seleccione --']}" optionValue="value" optionKey="key" />
			</div>
			<div class="form-group col-lg-2 col-md-2 col-xs-12">
				<g:textField id="fechaTelf4" name="fechaTelf4" class="form-control" onkeypress="return soloLetras(event)"/>
			</div>
			<div class="form-group col-lg-12 col-md-12 col-xs-12">
				<label>Observación: </label>
				<g:textField id="observacionTelf4" name="observacionTelf4" class="form-control"/>
			</div>
		</div>
	</g:if>
	<g:if test="${cliente.telefono5}">
		<div class="col-lg-12 col-md-12 col-xs-12">
			<div id="number5" class="form-group col-lg-12 col-md-12 col-xs-12">
				<label style="color: red" ><span class="fa fa-mobile-phone"></span> Teléfono 5: </label>
				${cliente.telefono5}
			</div>
			<div class="form-group col-lg-5 col-md-5 col-xs-12">
				<g:select class="form-control" id="estadoTel5" name="estadoTel5" from="${['51':'LLAMADA DEUDOR Y/O CONYUGE','52':'LLAMADA CONYUGUE DEUDOR','53':'LLAMADA GARANTE Y/O CONYUGE GARANTE','54':'LLAMADA CONYUGUE GARANTE','55':'LLAMADA FAMILIAR','56':'LLAMADA OTROS','0':'EQUIVOCADO']}" noSelection="${['': '-- Seleccione --']}" optionValue="value" optionKey="key" />
			</div>
			<div class="form-group col-lg-5 col-md-5 col-xs-12">
				<g:select class="form-control" id="respuestaTel5" name="respuestaTel5" from="${['1':'CONTACTADO','0':'NO CONTESTA/NO SATISFACTORIA']}" noSelection="${['': '-- Seleccione --']}" optionValue="value" optionKey="key" />
			</div>
			<div class="form-group col-lg-2 col-md-2 col-xs-12">
				<g:textField id="fechaTelf5" name="fechaTelf5" class="form-control" onkeypress="return soloLetras(event)"/>
			</div>
			<div class="form-group col-lg-12 col-md-12 col-xs-12">
				<label>Observación: </label>
				<g:textField id="observacionTelf5" name="observacionTelf5" class="form-control"/>
			</div>
		</div>
	</g:if>
</div>


	<div class="col-lg-12 col-md-12 col-xs-12">
		<h5> <b>Datos de Contácto (Números Alimentados)</b></h5>
	</div>

	<div style="border-radius: 30px" class="panel panel-default col-lg-12 col-md-12 col-xs-12">
		<g:if test="${cliente.telefono6}">
			<div class="col-lg-12 col-md-12 col-xs-12">
				<div id="number6" class="form-group col-lg-12 col-md-12 col-xs-12">
					<label style="color: red" ><span class="fa fa-mobile-phone"></span> Teléfono 6: </label>
					${cliente.telefono6}
				</div>
				<div class="form-group col-lg-5 col-md-5 col-xs-12">
					<g:select class="form-control" id="estadoTel6" name="estadoTel6" from="${['51':'LLAMADA DEUDOR Y/O CONYUGE','52':'LLAMADA CONYUGUE DEUDOR','53':'LLAMADA GARANTE Y/O CONYUGE GARANTE','54':'LLAMADA CONYUGUE GARANTE','55':'LLAMADA FAMILIAR','56':'LLAMADA OTROS','0':'EQUIVOCADO']}" noSelection="${['': '-- Seleccione --']}" optionValue="value" optionKey="key" />
				</div>
				<div class="form-group col-lg-5 col-md-5 col-xs-12">
					<g:select class="form-control" id="respuestaTel6" name="respuestaTel6" from="${['1':'CONTACTADO','0':'NO CONTESTA/NO SATISFACTORIA']}" noSelection="${['': '-- Seleccione --']}" optionValue="value" optionKey="key" />
				</div>
				<div class="form-group col-lg-2 col-md-2 col-xs-12">
					<g:textField id="fechaTelf6" name="fechaTelf6" class="form-control" onkeypress="return soloLetras(event)"/>
				</div>
				<div class="form-group col-lg-12 col-md-12 col-xs-12">
					<label>Observación: </label>
					<g:textField id="observacionTelf6" name="observacionTelf6" class="form-control"/>
				</div>
			</div>
		</g:if>
		<g:if test="${cliente.telefono7}">
			<div class="col-lg-12 col-md-12 col-xs-12">
				<div id="number7" class="form-group col-lg-12 col-md-12 col-xs-12">
					<label style="color: red" ><span class="fa fa-mobile-phone"></span> Teléfono 7: </label>
					${cliente.telefono7}
				</div>
				<div class="form-group col-lg-5 col-md-5 col-xs-12">
					<g:select class="form-control" id="estadoTel7" name="estadoTel7" from="${['51':'LLAMADA DEUDOR Y/O CONYUGE','52':'LLAMADA CONYUGUE DEUDOR','53':'LLAMADA GARANTE Y/O CONYUGE GARANTE','54':'LLAMADA CONYUGUE GARANTE','55':'LLAMADA FAMILIAR','56':'LLAMADA OTROS','0':'EQUIVOCADO']}" noSelection="${['': '-- Seleccione --']}" optionValue="value" optionKey="key" />
				</div>
				<div class="form-group col-lg-5 col-md-5 col-xs-12">
					<g:select class="form-control" id="respuestaTel7" name="respuestaTel7" from="${['1':'CONTACTADO','0':'NO CONTESTA/NO SATISFACTORIA']}" noSelection="${['': '-- Seleccione --']}" optionValue="value" optionKey="key" />
				</div>
				<div class="form-group col-lg-2 col-md-2 col-xs-12">
					<g:textField id="fechaTelf7" name="fechaTelf7" class="form-control" onkeypress="return soloLetras(event)"/>
				</div>
				<div class="form-group col-lg-12 col-md-12 col-xs-12">
					<label>Observación: </label>
					<g:textField id="observacionTelf7" name="observacionTelf7" class="form-control"/>
				</div>
			</div>
		</g:if>
		<g:if test="${cliente.telefono8}">
			<div class="col-lg-12 col-md-12 col-xs-12">
				<div id="number8" class="form-group col-lg-12 col-md-12 col-xs-12">
					<label style="color: red" ><span class="fa fa-mobile-phone"></span> Teléfono 8: </label>
					${cliente.telefono8}
				</div>
				<div class="form-group col-lg-5 col-md-5 col-xs-12">
					<g:select class="form-control" id="estadoTel8" name="estadoTel8" from="${['51':'LLAMADA DEUDOR Y/O CONYUGE','52':'LLAMADA CONYUGUE DEUDOR','53':'LLAMADA GARANTE Y/O CONYUGE GARANTE','54':'LLAMADA CONYUGUE GARANTE','55':'LLAMADA FAMILIAR','56':'LLAMADA OTROS','0':'EQUIVOCADO']}" noSelection="${['': '-- Seleccione --']}" optionValue="value" optionKey="key" />
				</div>
				<div class="form-group col-lg-5 col-md-5 col-xs-12">
					<g:select class="form-control" id="respuestaTel8" name="respuestaTel8" from="${['1':'CONTACTADO','0':'NO CONTESTA/NO SATISFACTORIA']}" noSelection="${['': '-- Seleccione --']}" optionValue="value" optionKey="key" />
				</div>
				<div class="form-group col-lg-2 col-md-2 col-xs-12">
					<g:textField id="fechaTelf8" name="fechaTelf8" class="form-control" onkeypress="return soloLetras(event)"/>
				</div>
				<div class="form-group col-lg-12 col-md-12 col-xs-12">
					<label>Observación: </label>
					<g:textField id="observacionTelf8" name="observacionTelf8" class="form-control"/>
				</div>
			</div>
		</g:if>
		<g:if test="${cliente.telefono9}">
			<div class="col-lg-12 col-md-12 col-xs-12">
				<div id="number9" class="form-group col-lg-12 col-md-12 col-xs-12">
					<label style="color: red" ><span class="fa fa-mobile-phone"></span> Teléfono 9: </label>
					${cliente.telefono9}
				</div>
				<div class="form-group col-lg-5 col-md-5 col-xs-12">
					<g:select class="form-control" id="estadoTel9" name="estadoTel9" from="${['51':'LLAMADA DEUDOR Y/O CONYUGE','52':'LLAMADA CONYUGUE DEUDOR','53':'LLAMADA GARANTE Y/O CONYUGE GARANTE','54':'LLAMADA CONYUGUE GARANTE','55':'LLAMADA FAMILIAR','56':'LLAMADA OTROS','0':'EQUIVOCADO']}" noSelection="${['': '-- Seleccione --']}" optionValue="value" optionKey="key" />
				</div>
				<div class="form-group col-lg-5 col-md-5 col-xs-12">
					<g:select class="form-control" id="respuestaTel9" name="respuestaTel9" from="${['1':'CONTACTADO','0':'NO CONTESTA/NO SATISFACTORIA']}" noSelection="${['': '-- Seleccione --']}" optionValue="value" optionKey="key" />
				</div>
				<div class="form-group col-lg-2 col-md-2 col-xs-12">
					<g:textField id="fechaTelf9" name="fechaTelf9" class="form-control" onkeypress="return soloLetras(event)"/>
				</div>
				<div class="form-group col-lg-12 col-md-12 col-xs-12">
					<label>Observación: </label>
					<g:textField id="observacionTelf9" name="observacionTelf9" class="form-control"/>
				</div>
			</div>
		</g:if>
		<g:if test="${cliente.telefono10}">
			<div class="col-lg-12 col-md-12 col-xs-12">
				<div id="number10" class="form-group col-lg-12 col-md-12 col-xs-12">
					<label style="color: red" ><span class="fa fa-mobile-phone"></span> Teléfono 10: </label>
					${cliente.telefono10}
				</div>
				<div class="form-group col-lg-5 col-md-5 col-xs-12">
					<g:select class="form-control" id="estadoTel10" name="estadoTel10" from="${['51':'LLAMADA DEUDOR Y/O CONYUGE','52':'LLAMADA CONYUGUE DEUDOR','53':'LLAMADA GARANTE Y/O CONYUGE GARANTE','54':'LLAMADA CONYUGUE GARANTE','55':'LLAMADA FAMILIAR','56':'LLAMADA OTROS','0':'EQUIVOCADO']}" noSelection="${['': '-- Seleccione --']}" optionValue="value" optionKey="key" />
				</div>
				<div class="form-group col-lg-5 col-md-5 col-xs-12">
					<g:select class="form-control" id="respuestaTel10" name="respuestaTel10" from="${['1':'CONTACTADO','0':'NO CONTESTA/NO SATISFACTORIA']}" noSelection="${['': '-- Seleccione --']}" optionValue="value" optionKey="key" />
				</div>
				<div class="form-group col-lg-2 col-md-2 col-xs-12">
					<g:textField id="fechaTelf10" name="fechaTelf10" class="form-control" onkeypress="return soloLetras(event)"/>
				</div>
				<div class="form-group col-lg-12 col-md-12 col-xs-12">
					<label>Observación: </label>
					<g:textField id="observacionTelf10" name="observacionTelf10" class="form-control"/>
				</div>
			</div>
		</g:if>
	</div>

	<div class="col-lg-12 col-md-12 col-xs-12">
		<h5> <b>Datos de Contácto (Números Referencias)</b></h5>
	</div>

	<div style="border-radius: 30px" class="panel panel-default col-lg-12 col-md-12 col-xs-12">
		<g:if test="${cliente.telefono11}">
			<div class="col-lg-12 col-md-12 col-xs-12">
				<div id="number11" class="form-group col-lg-12 col-md-12 col-xs-12">
					<label style="color: red" ><span class="fa fa-mobile-phone"></span> Teléfono 11: </label>
					${cliente.telefono11}
				</div>
				<div class="form-group col-lg-5 col-md-5 col-xs-12">
					<g:select class="form-control" id="estadoTel11" name="estadoTel11" from="${['51':'LLAMADA DEUDOR Y/O CONYUGE','52':'LLAMADA CONYUGUE DEUDOR','53':'LLAMADA GARANTE Y/O CONYUGE GARANTE','54':'LLAMADA CONYUGUE GARANTE','55':'LLAMADA FAMILIAR','56':'LLAMADA OTROS','0':'EQUIVOCADO']}" noSelection="${['': '-- Seleccione --']}" optionValue="value" optionKey="key" />
				</div>
				<div class="form-group col-lg-5 col-md-5 col-xs-12">
					<g:select class="form-control" id="respuestaTel11" name="respuestaTel11" from="${['1':'CONTACTADO','0':'NO CONTESTA/NO SATISFACTORIA']}" noSelection="${['': '-- Seleccione --']}" optionValue="value" optionKey="key" />
				</div>
				<div class="form-group col-lg-2 col-md-2 col-xs-12">
					<g:textField id="fechaTelf11" name="fechaTelf11" class="form-control" onkeypress="return soloLetras(event)"/>
				</div>
				<div class="form-group col-lg-12 col-md-12 col-xs-12">
					<label>Observación: </label>
					<g:textField id="observacionTelf11" name="observacionTelf11" class="form-control"/>
				</div>
			</div>
		</g:if>
		<g:if test="${cliente.telefono12}">
			<div class="col-lg-12 col-md-12 col-xs-12">
				<div id="number12" class="form-group col-lg-12 col-md-12 col-xs-12">
					<label style="color: red" ><span class="fa fa-mobile-phone"></span> Teléfono 12: </label>
					${cliente.telefono12}
				</div>
				<div class="form-group col-lg-5 col-md-5 col-xs-12">
					<g:select class="form-control" id="estadoTel12" name="estadoTel12" from="${['51':'LLAMADA DEUDOR Y/O CONYUGE','52':'LLAMADA CONYUGUE DEUDOR','53':'LLAMADA GARANTE Y/O CONYUGE GARANTE','54':'LLAMADA CONYUGUE GARANTE','55':'LLAMADA FAMILIAR','56':'LLAMADA OTROS','0':'EQUIVOCADO']}" noSelection="${['': '-- Seleccione --']}" optionValue="value" optionKey="key" />
				</div>
				<div class="form-group col-lg-5 col-md-5 col-xs-12">
					<g:select class="form-control" id="respuestaTel12" name="respuestaTel12" from="${['1':'CONTACTADO','0':'NO CONTESTA/NO SATISFACTORIA']}" noSelection="${['': '-- Seleccione --']}" optionValue="value" optionKey="key" />
				</div>
				<div class="form-group col-lg-2 col-md-2 col-xs-12">
					<g:textField id="fechaTelf12" name="fechaTelf12" class="form-control" onkeypress="return soloLetras(event)"/>
				</div>
				<div class="form-group col-lg-12 col-md-12 col-xs-12">
					<label>Observación: </label>
					<g:textField id="observacionTelf12" name="observacionTelf12" class="form-control"/>
				</div>
			</div>
		</g:if>
		<g:if test="${cliente.telefono13}">
			<div class="col-lg-12 col-md-12 col-xs-12">
				<div id="number13" class="form-group col-lg-12 col-md-12 col-xs-12">
					<label style="color: red" ><span class="fa fa-mobile-phone"></span> Teléfono 13: </label>
					${cliente.telefono13}
				</div>
				<div class="form-group col-lg-5 col-md-5 col-xs-12">
					<g:select class="form-control" id="estadoTel13" name="estadoTel13" from="${['51':'LLAMADA DEUDOR Y/O CONYUGE','52':'LLAMADA CONYUGUE DEUDOR','53':'LLAMADA GARANTE Y/O CONYUGE GARANTE','54':'LLAMADA CONYUGUE GARANTE','55':'LLAMADA FAMILIAR','56':'LLAMADA OTROS','0':'EQUIVOCADO']}" noSelection="${['': '-- Seleccione --']}" optionValue="value" optionKey="key" />
				</div>
				<div class="form-group col-lg-5 col-md-5 col-xs-12">
					<g:select class="form-control" id="respuestaTel13" name="respuestaTel13" from="${['1':'CONTACTADO','0':'NO CONTESTA/NO SATISFACTORIA']}" noSelection="${['': '-- Seleccione --']}" optionValue="value" optionKey="key" />
				</div>
				<div class="form-group col-lg-2 col-md-2 col-xs-12">
					<g:textField id="fechaTelf13" name="fechaTelf13" class="form-control" onkeypress="return soloLetras(event)"/>
				</div>
				<div class="form-group col-lg-12 col-md-12 col-xs-12">
					<label>Observación: </label>
					<g:textField id="observacionTelf13" name="observacionTelf13" class="form-control"/>
				</div>
			</div>
		</g:if>
		<g:if test="${cliente.telefono14}">
			<div class="col-lg-12 col-md-12 col-xs-12">
				<div id="number14" class="form-group col-lg-12 col-md-12 col-xs-12">
					<label style="color: red" ><span class="fa fa-mobile-phone"></span> Teléfono 14: </label>
					${cliente.telefono14}
				</div>
				<div class="form-group col-lg-5 col-md-5 col-xs-12">
					<g:select class="form-control" id="estadoTel14" name="estadoTel14" from="${['51':'LLAMADA DEUDOR Y/O CONYUGE','52':'LLAMADA CONYUGUE DEUDOR','53':'LLAMADA GARANTE Y/O CONYUGE GARANTE','54':'LLAMADA CONYUGUE GARANTE','55':'LLAMADA FAMILIAR','56':'LLAMADA OTROS','0':'EQUIVOCADO']}" noSelection="${['': '-- Seleccione --']}" optionValue="value" optionKey="key" />
				</div>
				<div class="form-group col-lg-5 col-md-5 col-xs-12">
					<g:select class="form-control" id="respuestaTel14" name="respuestaTel14" from="${['1':'CONTACTADO','0':'NO CONTESTA/NO SATISFACTORIA']}" noSelection="${['': '-- Seleccione --']}" optionValue="value" optionKey="key" />
				</div>
				<div class="form-group col-lg-2 col-md-2 col-xs-12">
					<g:textField id="fechaTelf14" name="fechaTelf14" class="form-control" onkeypress="return soloLetras(event)"/>
				</div>
				<div class="form-group col-lg-12 col-md-12 col-xs-12">
					<label>Observación: </label>
					<g:textField id="observacionTelf14" name="observacionTelf14" class="form-control"/>
				</div>
			</div>
		</g:if>
		<g:if test="${cliente.telefono15}">
			<div class="col-lg-12 col-md-12 col-xs-12">
				<div id="number15" class="form-group col-lg-12 col-md-12 col-xs-12">
					<label style="color: red" ><span class="fa fa-mobile-phone"></span> Teléfono 15: </label>
					${cliente.telefono15}
				</div>
				<div class="form-group col-lg-5 col-md-5 col-xs-12">
					<g:select class="form-control" id="estadoTel15" name="estadoTel15" from="${['51':'LLAMADA DEUDOR Y/O CONYUGE','52':'LLAMADA CONYUGUE DEUDOR','53':'LLAMADA GARANTE Y/O CONYUGE GARANTE','54':'LLAMADA CONYUGUE GARANTE','55':'LLAMADA FAMILIAR','56':'LLAMADA OTROS','0':'EQUIVOCADO']}" noSelection="${['': '-- Seleccione --']}" optionValue="value" optionKey="key" />
				</div>
				<div class="form-group col-lg-5 col-md-5 col-xs-12">
					<g:select class="form-control" id="respuestaTel15" name="respuestaTel15" from="${['1':'CONTACTADO','0':'NO CONTESTA/NO SATISFACTORIA']}" noSelection="${['': '-- Seleccione --']}" optionValue="value" optionKey="key" />
				</div>
				<div class="form-group col-lg-2 col-md-2 col-xs-12">
					<g:textField id="fechaTelf15" name="fechaTelf15" class="form-control" onkeypress="return soloLetras(event)"/>
				</div>
				<div class="form-group col-lg-12 col-md-12 col-xs-12">
					<label>Observación: </label>
					<g:textField id="observacionTelf15" name="observacionTelf15" class="form-control"/>
				</div>
			</div>
		</g:if>

		<%--FIN COMENTARIOS--%>

	</div>

	<g:if test="${cliente.tipo_cartera == 'CONDONACION'}">
		<div style="border-radius: 30px" class="panel panel-default col-lg-12 col-md-12 col-xs-12">
			<div class="col-lg-12 col-md-12 col-xs-12">
				<div class="line"><h5>SCRIPT CONDONACION</h5></div>
				<p>¿Sr(a) buenos días / tardes Me comunica con el Sr. <strong>${cliente.nombre}</strong>?</p>
				<p>Le saluda <strong>${session.user.nombre}</strong>, De la empresa de cobranzas PLUS WIRELESS en representación de Cooperativa Oscus,</p>
				<p>Sr. <strong>${cliente.nombre}</strong> solicitamos el pago INMEDIATO el día de hoy por el valor de $ <strong>${cliente.total_a_pagar}</strong> que mantiene con su Tarjeta de crédito <strong>${cliente.marca_tc}</strong>
				que hace referencia a sus <strong>${cliente.pagos_vencidos}</strong>, que perjudica su historial crediticio Coop Jep Aprobó el Pago inmediato de la <strong>${cliente.tipoBase}</strong> de su deuda con un
				valor de $ <strong>${cliente.valorCondonacion}</strong> con este plan puede finalizar su deuda, con un descuento de $<strong>${cliente.valor_condonado}</strong>.</p>
				<p>Sr. <strong>${cliente.nombre}</strong> ¿cotamos con su pago de $ <strong>${cliente.valorCondonacion}</strong> el día de hoy?</p>
				<p><i>Escuchar al cliente hasta que termine de hablar </i></p>
				<p><strong>¿Qué es la condonación?</strong></p>
				<p>La condonación de deudas es un acto jurídico con el que, de parte del acreedor (PRESTAMISTA), se expresa la voluntad de extinguir la deuda,
				está extinción puede ser total o parcial y a cambio de esta condonación no se pide nada a cambio.</p>
				<p><strong>¿Cómo aplicar la condonación con la cooperativa Jep?</strong></p>
				<p>
					<blockquote style="font-size: 16px">
						<ol>
							<li><i>El deudor tiene la obligación de asumir el pago total del valor pendiente que mantiene con la entidad.</i></li>
							<li><i>En caso de no poder asumir el valor de manera inmediata le podemos brindar la oportunidad de ejecutar el pago en un tiempo máximo de 90 días, así congelaría su deuda y durante este periodo de tiempo no se incrementaría valores moratorios u otros.</i></li>
							<li><i>En este periodo el cliente debe   notificar estar de acuerdo con la CONDONACION DE PAGO desde la supervisión de cobranzas deberán:</i></li>
							<blockquote style="font-size: 16px">
								<ul>
									<li><i>Emitir un correo con el formato especificado.</i></li>
									<li><i>b.	Indicar al cliente que puede mantener la Condonación si y solo si el cliente está de acuerdo en abonar en el pedido de los 90 días realizando el depósito a la cuenta   de la COOP JEP, cada vez que el cliente deposite deberá enviar la fotografía del depósito a la línea de atención al cliente WhatsApp
									<strong>https://api.whatsapp.com/send?phone=593984123871&text=COOPERATIVA%20JEP</strong> dando seguimiento para finalizar la condonación una vez depositado el valor de la condonación deberá ser notificado a la Coop Jep la culminación del abono para indicar al deudor que se acerque a la Agencia a finalizar el tramite.</i></li>
								</ul>
							</blockquote>
						</ol>
					</blockquote>
				</p>

			</div>
		</div>
	</g:if>
	<g:if test="${cliente.tipo_cartera == 'REFINANCIAMIENTO'}">
		<div style="border-radius: 30px" class="panel panel-default col-lg-12 col-md-12 col-xs-12">
			<div class="col-lg-12 col-md-12 col-xs-12">
				<div class="line"><h5>SCRIPT REFINANCIAMIENTO</h5></div>
				<p>¿Sr(a) buenos días / tardes Me comunica con el Sr. <strong>${cliente.nombre}</strong>?</p>
				<p>Le saluda <strong>${session.user.nombre}</strong>, De la empresa de cobranzas PLUS WIRELESS en representación de Cooperativa Oscus,</p>
				<p>Sr. <strong>${cliente.nombre}</strong> solicitamos el pago INMEDIATO el día de hoy por el valor de $ <strong>${cliente.total_a_pagar}</strong> que mantiene con su Tarjeta de crédito <strong>${cliente.marca_tc}</strong>
					que hace referencia a sus <strong>${cliente.pagos_vencidos}</strong>, que perjudica su historial crediticio Coop Jep solicita de inmediato Negociar el :  100%, 75% o 50% del $ <strong>${cliente.total_a_pagar}</strong> que disminuirá el valor total a pagar.</p>
				<p>Sr. <strong>${cliente.nombre}</strong> ¿cotamos con su pago de $ <strong>${cliente.total_a_pagar}</strong> el día de hoy?</p>
				<p>Escuchar al cliente hasta que termine de hablar </p>
				<p>Si hay negativa de pago proceder con el siguiente dialogo:</p>
				<p>Coop Jep Aprobó la alternativa del <strong>${cliente.tipoBase}</strong> su deuda con un valor de $ (Int REC) de su deuda otorgándole facilidades de pago hasta un máximo de
				48 meses plazo mejorando su credibilidad financiera realizando el depósito inmediato.</p>
				<p>¿Contamos con su pago el día de Hoy?</p>
				<p>Escuchar al cliente hasta que termine de hablar </p>
				<p><strong>DESPEDIDA</strong></p>
				<p>¿Sr. <strong>${cliente.nombre}</strong> Le recordamos el compromiso generado en esta llamada es por el $ (valor acordado) evite la acumulación de los valores en su siguiente estado.</p>

				<p>
					<strong>Información referente al refinanciamiento</strong>
					<blockquote style="font-size: 16px">
						<ol>
							<li><i>El socio deudor que opte por refinanciar su deuda deberá asumir el pago total del INT REC valor generado por intereses moratorios, el cual no podrá diferirlo o asumirlo en cuotas.</i></li>
							<li><i>Se deberá de comprobar la situación laboral del cliente (ingreso-capital) y de no poseer trabajo se solicitaría abonos parciales o totales a la deuda.</i></li>
							<li><i>Notificar al socio deudor que podrá diferir el valor adeudado hasta un lapso máximo de 48 meses considerando el monto en cuestión. (en caso de aplicabilidad).</i></li>
							<li><i>Solicitar presente los documentos habilitantes requeridos (copia de CI-copia de Planilla de servicios básicos de los últimos 60 días, comprobante de depósito del int rec).</i></li>
						</ol>
					</blockquote>
				</p>
			</div>
		</div>
	</g:if>


	<g:if test="${cliente.tipo_cartera == 'CONSOLIDACION'}">
		<div style="border-radius: 30px" class="panel panel-default col-lg-12 col-md-12 col-xs-12">
			<div class="col-lg-12 col-md-12 col-xs-12">
				<div class="line"><h5>SCRIPT CONSOLIDACION </h5></div>
				<p>¿Sr(a) buenos días / tardes Me comunica con el Sr. <strong>${cliente.nombre}</strong>?</p>
				<p>Le saluda <strong>${session.user.nombre}</strong>, De la empresa de cobranzas PLUS WIRELESS en representación de Cooperativa Oscus,</p>
				<p>Sr. <strong>${cliente.nombre}</strong> solicitamos el pago INMEDIATO el día de hoy por el valor de $ <strong>${cliente.total_a_pagar}</strong> que mantiene con su Tarjeta de crédito <strong>${cliente.marca_tc}</strong>
					que hace referencia a sus <strong>${cliente.pagos_vencidos}</strong>, que perjudica su historial crediticio Coop Jep solicita el valor de $ <strong>${cliente.valorCondonacion}</strong>) que deberán cancelar los valores vencidos   con este plan puede finalizar su deuda, con un descuento de $ <strong>${cliente.valor_condonado}</strong>.</p>
				<p>Sr. <strong>${cliente.nombre}</strong> ¿cotamos con su pago de $ <strong>${cliente.total_a_pagar}</strong> el día de hoy?</p>
				<p>Escuchar al cliente hasta que termine de hablar </p>
				<p>Coop Jep aprobó la alternativa de  <strong>${cliente.tipoBase}</strong> de su crédito y Tarjeta de crédito <strong>${cliente.marca_tc}</strong> para lo cual deberán cancelar los valores de exigibles previo a la unificación acercándose a la agencia mas cercana </p>
				<p>¿Sr. (Nombre de cliente) cual es la agencia más cercana? </p>
				<p>El día de mañana deberá acercarse a realizar la consolidación para el pago de valores.</p>
				<p><strong>CONSIDERACIONES DE CONSOLIDACION</strong></p>
				<p>Los socios que también mantienen crédito en la Cooperativa y que pueden consolidar las operaciones, para lo cual deberán cancelar los valores de exigibles (intereses, costos operativos e impuestos) previo a la unificación.</p>
				<p>En el caso de tarjetas castigadas, si socio no dispone de la cantidad solicitada para condonación, gestionar consolidación de operaciones.</p>
				<p>En el caso de tarjetas vencidas, si el socio no dispone de la cantidad para cancelar valores vencidos, recomendar que proceda con la consolidación de operaciones.</p>
			</div>
		</div>
	</g:if>

	<input type="hidden" name="idCliente" value="${cliente.id}" />
	<div style="border-radius: 30px" class="panel panel-default col-lg-12 col-md-12 col-xs-12">

		<div class="col-lg-4 col-md-6 col-xs-12 form-group">
			<label>Estado 1</label>
			<span class="required-indicator">*</span>
			<g:select class="form-control" name="estado" id="status"
					  from="${callcenter.Estado.list()}" optionKey="id"
					  optionValue="${{it.nombre	}}"
					  noSelection="${['': '-- Seleccione --']}" />
		</div>
		<div id="subSubStatusDiv" class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Estado 2</label>
			<span class="required-indicator">*</span>
			<g:select id="subSubStatus" class="form-control" name="subSubStatus" from="" noSelection="${['': '-- Seleccione --']}" optionKey="id"></g:select>
		</div>

		<div id="subStatusDiv" class="col-lg-4 col-md-6 col-xs-12 form-group">
			<label>Estado 3</label>
			<span class="required-indicator">*</span>
			<g:select class="form-control" name="substatus" id="substatus" from="" noSelection="${['': '-- Seleccione --']}" />
		</div>

		<div id="divEstadoNivel4" class="col-lg-4 col-md-6 col-xs-12 form-group">
			<label>Estado 4</label>
			<span class="required-indicator">*</span>
			<g:select class="form-control" name="estadoNivel4" id="estadoNivel4" from="${['DIFERIDO INTERNO':'DIFERIDO INTERNO', 'REESTRUCTURACION':'REESTRUCTURACION', 'REFINANCIAMIENTO':'REFINANCIAMIENTO']}" optionKey="key"
					  optionValue="value"
					  noSelection="${['': '-- Seleccione --']}" />
		</div>

		<div id="divMotivo" class="col-lg-12 col-md-12 col-xs-12 form-group">
			<label>Motivos No Acepta</label>
			<span class="required-indicator">*</span>
			<g:textArea class="form-control" name="motivoNoAceptaSeguro" value=""/>

		</div>

		<div id="recallDiv">
			<div class="col-lg-4 col-md-6 col-xs-12 form-group">
				<label>Agendamiento</label>
				<span class="required-indicator">*</span>
				<g:select class="form-control" name="agendamiento" id="agendamiento" from="${['AGENDAR PARA MI':'AGENDAR PARA MI', 'AGENDAR PARA CUALQUIERA':'AGENDAR PARA CUALQUIERA']}" optionKey="key"
						  optionValue="value"
						  noSelection="${['': '-- Seleccione --']}" />
			</div>
			<div class="col-lg-4 col-md-6 form-group">
				<label>Fecha Rellamada</label>
				<span class="required-indicator">*</span>
				<g:textField id="recall" name="recall" class="recall form-control"/>
			</div>
		</div>

		<div id="telefonoContactadoDiv" >
			<div class="col-lg-4 col-md-6 form-group">
				<label style="color: red">Teléfono Contactado</label>
				<span class="required-indicator">*</span>
				<g:textField maxlength="10" minlength="9" id="telefonoContactado" name="telefonoContactado" class="form-control"/>
			</div>
			<%--<div class="form-group col-lg-4 col-md-6 col-xs-12">
				<label >Estado Teléfono Contactado</label>
				<span class="required-indicator">*</span>
				<g:select class="form-control" id="estadoTelefonoContactado" name="estadoTelefonoContactado" from="" noSelection="${['': '-- Seleccione --']}" optionValue="value" optionKey="value" />

			</div>--%>
		</div>
		<div class="col-lg-4 col-md-6 col-xs-12 form-group">
			<label>Retroalimentación</label>
			<span class="required-indicator">*</span>
			<g:select class="form-control" name="retroalimentacion" id="retroalimentacion" from="${['SI':'SI', 'NO':'NO']}" optionKey="key"
					  optionValue="value"
					  noSelection="${['': '-- Seleccione --']}" />
		</div>
	</div>

	<div id="divScriptFallecidoMuerteNatural" style="border-radius: 30px" class="panel panel-default col-lg-12 col-md-12 col-xs-12">
		<div class="col-lg-12 col-md-12 col-xs-12">
			<div class="line"><h5 style="font-weight: bold">FALLECIDO POR MUERTE NATURAL </h5></div>
			<blockquote style="font-size: 16px">
				<ol>
					<li><i>Formulario de reclamación debidamente llenado y firmado por el reclamante.</i></li>
					<li><i>Historia clínica y certificado del medico tratante indicando las causas del fallecimiento y fechas de diagnostico. (Originales o copias certificadas o Notariadas).</i></li>
					<li><i>Copia de la cédula de identidad del fallecido. (Copia)</i></li>
					<li><i>Cédula de identidad del reclamante. (Copia)</i></li>
					<li><i>Acta de Defunción (Original o copia notariada)</i></li>
				</ol>
			</blockquote>
		</div>
	</div>
	<div id="divScriptFallecidoAccidente" style="border-radius: 30px" class="panel panel-default col-lg-12 col-md-12 col-xs-12">
		<div class="col-lg-12 col-md-12 col-xs-12">
			<div class="line"><h5 style="font-weight: bold">FALLECIDO POR ACCIDENTE</h5></div>
			<blockquote style="font-size: 16px">
				<ol>
					<li><i>Formulario de reclamación debidamente llenado y firmado por el reclamante.</i></li>
					<li><i>Parte policial (original o copia notariada)</i></li>
					<li><i>Acta de levantamiento del cadáver</i></li>
					<li><i>Protocolo de Autopsia</i></li>
					<li><i>Copia de la cédula de identidad del fallecido. (Copia)</i></li>
					<li><i>Cédula de identidad del reclamante. (Copia)</i></li>
					<li><i>Acta de Defunción (Original o copia notariada).</i></li>
				</ol>
			</blockquote>
		</div>
	</div>
	<div id="divScriptIncapacidadTotalPermanente" style="border-radius: 30px" class="panel panel-default col-lg-12 col-md-12 col-xs-12">
		<div class="col-lg-12 col-md-12 col-xs-12">
			<div class="line"><h5 style="font-weight: bold">INCAPACIDAD TOTAL Y PERMANENTE </h5></div>
			<blockquote style="font-size: 16px">
				<ol>
					<li><i>Formulario de reclamación debidamente llenado y firmado por el reclamante.</i></li>
					<li><i>Certificado del medico tratante actualizado indicando el diagnóstico, causas, tratamiento y pronostico del socio. (Original o copias simples).</i></li>
					<li><i>Historia clínica completa, información clínica, radiológica, histológica y de laboratorio. (Original o copias simples).</i></li>
					<li><i>Copia del carnet de discapacidad (Opcional)</i></li>
					<li><i>Copia de la cédula del socio.</i></li>
				</ol>
			</blockquote>
		</div>
	</div>
	<div id="divScriptIncapacidadLaboralTemporal" style="border-radius: 30px" class="panel panel-default col-lg-12 col-md-12 col-xs-12">
		<div class="col-lg-12 col-md-12 col-xs-12">
			<div class="line"><h5 style="font-weight: bold">INCAPACIDAD LABORAL TEMPORAL </h5></div>
			<blockquote style="font-size: 16px">
				<ol>
					<li><i>Formulario de reclamación debidamente llenado y firmado por el reclamante. (Original)</i></li>
					<li><i>Historia clínica y certificado del medico tratante indicando las causas y las fechas de incapacidad. (original o copia notariada o certificada).</i></li>
					<li><i>Información clínica, radiológica, histológica y de laboratorio. (Original o copia notariada o certificada).</i></li>
					<li><i>Certificado del IESS o del ministerio de salud publica validando la incapacidad. (Original o copia notariada o certificada en caso de existir).</i></li>
					<li><i>Carnet de discapacidad otorgado por el órgano regulador vigente. (en caso de existir).</i></li>
					<li><i>Tabla de amortización. (Copia).</i></li>
					<li><i>Pagare. (Copia).</i></li>
				</ol>
			</blockquote>
		</div>
	</div>

<%-- EMPIEZA GESTIÓN --%>
	<br>
		<div id="managementData" >
			<div style="border-radius: 30px" class="panel panel-default col-lg-12 col-md-12 col-xs-12">
				<div class="col-lg-12 col-md-12 col-xs-12">
				<div class="line"><h5>Recopilación de datos</h5></div>

							<div class="form-group col-lg-3 col-md-6 col-xs-12">
								<label>Provincia</label>
								<span class="required-indicator"> *</span>
									<g:if test="${cliente.provinciaPromesa != null}">
										<g:select class="form-control" id="provinciaGestion" name="provinciaGestion" optionKey="id" noSelection="${['': '-- Seleccione --']}" from="${callcenter.Provincia.list(sort: "nombre", order: "asc")}"  optionValue="${{it.nombre}}" value="${cliente.provinciaPromesa.id}"/>
									</g:if>
									<g:else>
										<g:select class="form-control" id="provinciaGestion" name="provinciaGestion" optionKey="id" noSelection="${['': '-- Seleccione --']}" from="${callcenter.Provincia.list(sort: "nombre", order: "asc")}"  optionValue="${{it.nombre}}"/>
									</g:else>

							</div>
							<div class="form-group col-lg-3 col-md-6 col-xs-12">
								<label>Ciudad</label>
								<span class="required-indicator"> *</span>
								<g:if test="${cliente.ciudadPromesa != null}">
									<g:select class="form-control" id="ciudadGestiones" name="ciudadGestiones" optionKey="id" noSelection="${['': '-- Seleccione --']}" from="${callcenter.Ciudad.list()}" optionValue="${{it.nombre}}" value="${cliente.ciudadPromesa.id}"/>
								</g:if>
								<g:else>
									<g:select class="form-control" id="ciudadGestiones" name="ciudadGestiones" optionKey="id" noSelection="${['': '-- Seleccione --']}" from="" optionValue="${{it.nombre}}"/>
								</g:else>

							</div>
							<div class="form-group col-lg-3 col-md-6 col-xs-12">
								<label>Cantón</label>
								<span class="required-indicator"> *</span>
								<g:if test="${cliente.cantonPromesa != null}">
									<g:select class="form-control" id="cantonGestion" name="cantonGestion" optionKey="id" noSelection="${['': '-- Seleccione --']}" from="${callcenter.Canton.list()}" optionValue="${{it.nombre}}" value="${cliente.cantonPromesa.id}"/>
								</g:if>
								<g:else>
									<g:select class="form-control" id="cantonGestion" name="cantonGestion" optionKey="id" noSelection="${['': '-- Seleccione --']}" from="" optionValue="${{it.nombre}}"/>
								</g:else>

							</div>
							<div class="form-group col-lg-3 col-md-6 col-xs-12">
								<label>Parroquia</label>
								<span class="required-indicator"> *</span>
								<g:if test="${cliente.parroquiaPromesa != null}">
									<g:select class="form-control" id="parroquiaGestion" name="parroquiaGestion" optionKey="id" noSelection="${['': '-- Seleccione --']}" from="${callcenter.Parroquia.list()}" optionValue="${{it.nombre}}" value="${cliente.parroquiaPromesa.id}"/>
								</g:if>
								<g:else>
									<g:select class="form-control" id="parroquiaGestion" name="parroquiaGestion" optionKey="id" noSelection="${['': '-- Seleccione --']}" from="" optionValue="${{it.nombre}}"/>
								</g:else>

							</div>
							<div class="form-group col-lg-5 col-md-6 col-xs-12">
								<label>Calle Principal</label>
								<span class="required-indicator"> *</span>
								<g:textField id="callePrincipalGestion" name="callePrincipalGestion" class="form-control" value="${cliente.callePrincipalGestion}" />
							</div>
							<div class="form-group col-lg-2 col-md-2 col-xs-12">
								<label>Nro Casa</label>
								<span class="required-indicator"> *</span>
								<g:textField id="numeroCasaGestion" name="numeroCasaGestion" class="form-control" value="${cliente.numeroCasaGestion}" />
							</div>
							<div class="form-group col-lg-5 col-md-6 col-xs-12">
								<label>Calle Secundaria</label>
								<span class="required-indicator"> *</span>
								<g:textField id="calleSecundariaGestion" name="calleSecundariaGestion" class="form-control" value="${cliente.calleSecundariaGestion}" />
							</div>
							<div class="form-group col-lg-12 col-md-12 col-xs-12">
								<label>Referencia</label>
								<span class="required-indicator"> *</span>
								<g:textArea class="form-control" id="referenciaGestion"  name="referenciaGestion" value="${cliente.referenciaGestion}"/>
							</div>
							<div class="line"><h5>Valores</h5></div>
							<div class="form-group col-lg-3 col-md-6 col-xs-12">
								<label>Fecha Promesa</label>
								<span class="required-indicator">*</span>
								<g:textField id="fecha_promesa" name="fecha_promesa" class="datepickertest form-control" onkeypress="return soloLetras(event)" value="${cliente.fecha_promesa}"/>
							</div>
							<div class="form-group col-lg-3 col-md-6 col-xs-12">
								<label>Valor Promesa:</label>
								<span class="required-indicator"> *</span>
								<g:textField class="form-control" id="valor_promesa" name="valor_promesa" minlength="1" maxlength="15" value="${cliente.valor_promesa}" />
							</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Telefono Domicilio:</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control" id="telefonoDomicilio" name="telefonoDomicilio" minlength="9" maxlength="9" value="" />
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Telefono Celular:</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control" id="celular" name="celular" minlength="10" maxlength="10" value="" />
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Plazo</label>
						<span class="required-indicator">*</span>
						<g:select class="form-control" name="plazoGestion" id="plazoGestion" from="${['0':'0', '3':'3', 	'6':'6', 	'9':'9', 	'12':'12', 	'18':'18', 	'24':'24', 	'36':'36', 	'48':'48', 	'60':'60', 	'60 CON 2 GRACIA':'60 CON 2 GRACIA',]}" optionKey="key"
								  optionValue="value"
								  noSelection="${['': '-- Seleccione --']}" />
					</div>
				</div>
			</div>
	       </div>



	<div id="condonacionData" style="border-radius: 30px" class="panel panel-default col-lg-12 col-md-12 col-xs-12">
		<div class="line"><h5>Condonación Cliente</h5></div>
			<div class="col-lg-12 col-md-12 col-xs-12">
				<div class="form-group col-lg-3 col-md-6 col-xs-12">
					<label>Valor Condonación</label>
					<span class="required-indicator"> *</span>
					<g:textField id="valorCondonacion" name="valorCondonacion" class="form-control" value="${cliente?.valorCondonacion}" />
				</div>
				<div class="form-group col-lg-3 col-md-6 col-xs-12">
					<label>Provincia Agencia</label>
					<span class="required-indicator"> *</span>
					<g:select class="form-control" id="provinciaAgencia" name="provinciaAgencia" optionKey="id" noSelection="${['': '-- Seleccione --']}" from="${callcenter.Provincia.list(sort: "nombre", order: "asc")}"  optionValue="${{it.nombre}}"/>
				</div>
				<div class="form-group col-lg-3 col-md-6 col-xs-12">
					<label>Ciudad Agencia</label>
					<span class="required-indicator"> *</span>
					<g:select class="form-control" id="ciudadAgencia" name="ciudadGestion" optionKey="id" noSelection="${['': '-- Seleccione --']}" from="" optionValue="${{it.nombre}}"/>
				</div>

				<div class="form-group col-lg-3 col-md-6 col-xs-12">
					<label>Nombre Agencia</label>
					<span class="required-indicator"> *</span>
					<g:select class="form-control" id="nombreCondonacionAgencia" name="nombreCondonacionAgencia" optionKey="id" noSelection="${['': '-- Seleccione --']}" from="" optionValue="${{it.nombre}}"/>
				</div>
				<div class="form-group col-lg-3 col-md-6 col-xs-12">
					<label>Fecha Visita Agencia</label>
					<span class="required-indicator"> *</span>
					<g:textField id="fechaVisitaAgenciaCondonacion" name="fechaVisitaAgenciaCondonacion" class="datepickertest form-control" />
				</div>
				<div class="form-group col-lg-12 col-md-12 col-xs-12">
					<label>Observaciones Condonación</label>
					<g:textArea class="form-control" name="observacionesCondonacion"/>
				</div>
			</div>
	</div>

	<div style="border-radius: 30px" class="panel panel-default col-lg-12 col-md-12 col-xs-12">
		<div class="form-group col-lg-12 col-md-12 col-xs-12">
			<label>Observaciones</label>
			<g:textArea class="form-control" name="observaciones" value="${cliente?.observaciones}"/>
		</div>
	</div>
	<div class="overlay" id="overlay">
		<div class="loader"></div>
	</div>

	<div class="col-lg-12 col-md-12 col-xs-12">
		<g:submitButton id="send" name="btnGuardarCliente" class="btn btn-primary" value="Guardar Gestión" />
	</div>
	<div class="line"></div>
</g:form>
</div>

<asset:javascript src="usogeneral/objetos.js" />
<asset:javascript src="gestion/gestionCliente1.js" />
<asset:javascript src="usogeneral/customdatetimepicker.js" />
<asset:javascript src="usogeneral/datetimepicker.js" />
<asset:javascript src="usogeneral/bootstrap-datepicker.min.js" />
<asset:javascript src="usogeneral/customdatepicker.js" />
<asset:javascript src="usogeneral/bootstrap-datepicker.es.min.js" />
<asset:javascript src="usogeneral/moment.min.js" />
<asset:javascript src="usogeneral/daterangepicker.js" />
<asset:stylesheet src="usogeneral/daterangepicker.css" />
<asset:stylesheet src="usogeneral/customdaterangepicker.css" />
