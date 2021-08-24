import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_cobranzasOscus_gestiongestionCliente_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/gestion/gestionCliente.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
invokeTag('captureMeta','sitemesh',1,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(0)
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',3,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=utf-8")],-1)
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'charset':("utf-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("content-type"),'content':("application/vnd.ms-excel; charset=UTF-8")],-1)
printHtmlPart(0)
invokeTag('stylesheet','asset',7,['src':("usogeneral/bootstrap-datepicker.min.css")],-1)
printHtmlPart(2)
createTagBody(1, {->
createClosureForHtmlPart(3, 2)
invokeTag('captureTitle','sitemesh',10,[:],2)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],1)
printHtmlPart(4)
invokeTag('stylesheet','asset',12,['src':("usogeneral/datetimepicker.css")],-1)
printHtmlPart(0)
invokeTag('stylesheet','asset',13,['src':("gestion/gestionCliente.css")],-1)
printHtmlPart(4)
invokeTag('javascript','asset',15,['src':("usogeneral/jquery-ui.min.js")],-1)
printHtmlPart(0)
invokeTag('stylesheet','asset',16,['src':("usogeneral/breadcrumb.css")],-1)
printHtmlPart(0)
invokeTag('javascript','asset',17,['src':("usogeneral/breadcrumb.js")],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
if(true && (cliente.subestadoGestion != null)) {
printHtmlPart(7)
if(true && (cliente.subestadoGestion.id == 28)) {
printHtmlPart(8)
expressionOut.print(resultado)
printHtmlPart(9)
expressionOut.print(cliente.valor_promesa)
printHtmlPart(10)
for( _it1546815184 in (utilitarios.Util.getHistorial(cliente.id.toString(), 'FECHA PROMESA INICIAL')) ) {
changeItVariable(_it1546815184)
expressionOut.print(it)
}
printHtmlPart(11)
for( _it2033250553 in (utilitarios.Util.getHistorialFechaPromesa(cliente.id.toString(), 'FECHA ANTERIORES')) ) {
changeItVariable(_it2033250553)
printHtmlPart(12)
expressionOut.print(it)
printHtmlPart(13)
}
printHtmlPart(14)
expressionOut.print(cliente.provinciaGestion)
printHtmlPart(15)
expressionOut.print(cliente.ciudadGestion)
printHtmlPart(16)
expressionOut.print(cliente.cantonGestion)
printHtmlPart(17)
expressionOut.print(cliente.parroquiaGestion)
printHtmlPart(18)
}
printHtmlPart(19)
}
printHtmlPart(20)
expressionOut.print(cliente.nombre)
printHtmlPart(21)
expressionOut.print(cliente.identificacion)
printHtmlPart(22)
if(true && (cliente.numero_operacion&& cliente.numero_operacion.trim() != '')) {
printHtmlPart(23)
expressionOut.print(cliente.numero_operacion)
printHtmlPart(24)
}
printHtmlPart(19)
if(true && (cliente.sexo && cliente.sexo.trim() != '')) {
printHtmlPart(25)
expressionOut.print(cliente.sexo)
printHtmlPart(24)
}
printHtmlPart(19)
if(true && (cliente.estado_civil && cliente.estado_civil.trim() != '')) {
printHtmlPart(26)
expressionOut.print(cliente.estado_civil)
printHtmlPart(24)
}
printHtmlPart(27)
if(true && (cliente.profesion && cliente.profesion.trim() != '')) {
printHtmlPart(28)
expressionOut.print(cliente.profesion)
printHtmlPart(24)
}
printHtmlPart(19)
if(true && (cliente.provincia_1 && cliente.provincia_1.trim() != '')) {
printHtmlPart(29)
expressionOut.print(cliente.provincia_1)
printHtmlPart(24)
}
printHtmlPart(19)
if(true && (cliente.direccion_1 && cliente.direccion_1.trim() != '')) {
printHtmlPart(30)
expressionOut.print(cliente.direccion_1)
printHtmlPart(24)
}
printHtmlPart(19)
if(true && (cliente.pagos_vencidos && cliente.pagos_vencidos.trim() != '')) {
printHtmlPart(31)
expressionOut.print(cliente.pagos_vencidos)
printHtmlPart(24)
}
printHtmlPart(19)
if(true && (cliente.pago_minimo && cliente.pago_minimo.trim() != '')) {
printHtmlPart(32)
expressionOut.print(cliente.pago_minimo)
printHtmlPart(24)
}
printHtmlPart(19)
if(true && (cliente.valor_vencido && cliente.valor_vencido.trim() != '')) {
printHtmlPart(33)
expressionOut.print(cliente.valor_vencido)
printHtmlPart(24)
}
printHtmlPart(19)
if(true && (cliente.total_a_pagar && cliente.total_a_pagar.trim() != '')) {
printHtmlPart(34)
expressionOut.print(cliente.total_a_pagar)
printHtmlPart(24)
}
printHtmlPart(27)
if(true && (cliente.marca_tc && cliente.marca_tc.trim() != '')) {
printHtmlPart(35)
expressionOut.print(cliente.marca_tc)
printHtmlPart(24)
}
printHtmlPart(19)
if(true && (cliente.int_rec && cliente.int_rec.trim() != '')) {
printHtmlPart(36)
expressionOut.print(cliente.int_rec)
printHtmlPart(24)
}
printHtmlPart(19)
if(true && (cliente.calificacion && cliente.calificacion.trim() != '')) {
printHtmlPart(37)
expressionOut.print(cliente.calificacion)
printHtmlPart(24)
}
printHtmlPart(19)
if(true && (cliente.capital_provision && cliente.capital_provision.trim() != '')) {
printHtmlPart(38)
expressionOut.print(cliente.capital_provision)
printHtmlPart(24)
}
printHtmlPart(19)
if(true && (cliente.valorCondonacion && cliente.valorCondonacion.trim() != '')) {
printHtmlPart(39)
expressionOut.print(cliente.valorCondonacion)
printHtmlPart(24)
}
printHtmlPart(19)
if(true && (cliente.valoresPendientesTc && cliente.valoresPendientesTc.trim() != '')) {
printHtmlPart(40)
expressionOut.print(cliente.valoresPendientesTc)
printHtmlPart(24)
}
printHtmlPart(19)
if(true && (cliente.tipoBase && cliente.tipoBase.trim() != '')) {
printHtmlPart(41)
expressionOut.print(cliente.tipoBase)
printHtmlPart(24)
}
printHtmlPart(19)
if(true && (cliente.valor_condonado && cliente.valor_condonado.trim() != '')) {
printHtmlPart(42)
expressionOut.print(cliente.valor_condonado)
printHtmlPart(24)
}
printHtmlPart(19)
if(true && (cliente.segmentacion_ad4 && cliente.segmentacion_ad4.trim() != '')) {
printHtmlPart(43)
expressionOut.print(cliente.segmentacion_ad4)
printHtmlPart(24)
}
printHtmlPart(19)
if(true && (cliente.agenciaId && cliente.agenciaId.trim() != '')) {
printHtmlPart(44)
expressionOut.print(cliente.agenciaId)
printHtmlPart(22)
}
printHtmlPart(7)
if(true && (cliente.deudaProtegida && cliente.deudaProtegida.trim() != '')) {
printHtmlPart(45)
expressionOut.print(cliente.deudaProtegida)
printHtmlPart(24)
}
printHtmlPart(19)
if(true && (cliente.deudaVencida && cliente.deudaVencida.trim() != '')) {
printHtmlPart(46)
expressionOut.print(cliente.deudaVencida)
printHtmlPart(24)
}
printHtmlPart(19)
if(true && (cliente.cupo_utilizado && cliente.cupo_utilizado.trim() != '')) {
printHtmlPart(47)
expressionOut.print(cliente.cupo_utilizado)
printHtmlPart(24)
}
printHtmlPart(19)
if(true && (cliente.dias_vencidos && cliente.dias_vencidos.trim() != '')) {
printHtmlPart(48)
expressionOut.print(cliente.dias_vencidos)
printHtmlPart(49)
expressionOut.print(estadoNivel)
printHtmlPart(50)
}
printHtmlPart(51)
if(true && (cliente.semana_gestion && cliente.semana_gestion.trim() != '')) {
printHtmlPart(52)
if(true && (cliente.meta_mensual_jep && cliente.meta_mensual_jep.trim() != '')) {
printHtmlPart(53)
expressionOut.print(cliente.meta_mensual_jep)
printHtmlPart(54)
}
printHtmlPart(7)
if(true && (cliente.operaciones_jep && cliente.operaciones_jep.trim() != '')) {
printHtmlPart(55)
expressionOut.print(cliente.operaciones_jep)
printHtmlPart(54)
}
printHtmlPart(7)
if(true && (cliente.semana_gestion && cliente.semana_gestion.trim() != '')) {
printHtmlPart(56)
expressionOut.print(cliente.semana_gestion)
printHtmlPart(54)
}
printHtmlPart(7)
if(true && (cliente.faltante_pw && cliente.faltante_pw.trim() != '')) {
printHtmlPart(57)
expressionOut.print(cliente.faltante_pw)
printHtmlPart(54)
}
printHtmlPart(7)
if(true && (cliente.objetivo_diario_pw && cliente.objetivo_diario_pw.trim() != '')) {
printHtmlPart(58)
expressionOut.print(cliente.objetivo_diario_pw)
printHtmlPart(54)
}
printHtmlPart(7)
if(true && (cliente.riesgo_jep && cliente.riesgo_jep.trim() != '')) {
printHtmlPart(59)
expressionOut.print(cliente.riesgo_jep)
printHtmlPart(54)
}
printHtmlPart(7)
if(true && (cliente.valor_promesa_anterior2 && cliente.valor_promesa_anterior2.trim() != '')) {
printHtmlPart(60)
expressionOut.print(cliente.valor_promesa_anterior2)
printHtmlPart(54)
}
printHtmlPart(7)
if(true && (cliente.fecha_de_pago && cliente.fecha_de_pago.trim() != '')) {
printHtmlPart(61)
expressionOut.print(cliente.fecha_de_pago)
printHtmlPart(54)
}
printHtmlPart(62)
}
printHtmlPart(63)
if(true && (cliente.telefono1)) {
printHtmlPart(64)
expressionOut.print(cliente.telefono1)
printHtmlPart(65)
invokeTag('select','g',302,['class':("form-control"),'id':("estadoTel1"),'name':("estadoTel1"),'from':(['51':'LLAMADA DEUDOR Y/O CONYUGE','52':'LLAMADA CONYUGUE DEUDOR','53':'LLAMADA GARANTE Y/O CONYUGE GARANTE','54':'LLAMADA CONYUGUE GARANTE','55':'LLAMADA FAMILIAR','56':'LLAMADA OTROS','0':'EQUIVOCADO']),'noSelection':(['': '-- Seleccione --']),'optionValue':("value"),'optionKey':("key")],-1)
printHtmlPart(66)
invokeTag('select','g',309,['class':("form-control"),'id':("respuestaTel1"),'name':("respuestaTel1"),'from':(['1':'CONTACTADO','0':'NO CONTESTA/NO SATISFACTORIA']),'noSelection':(['': '-- Seleccione --']),'optionValue':("value"),'optionKey':("key")],-1)
printHtmlPart(67)
invokeTag('textField','g',314,['id':("fechaTelf1"),'name':("fechaTelf1"),'class':("form-control"),'onkeypress':("return soloLetras(event)")],-1)
printHtmlPart(68)
invokeTag('textField','g',319,['id':("observacionTelf1"),'name':("observacionTelf1"),'class':("form-control")],-1)
printHtmlPart(69)
}
printHtmlPart(19)
if(true && (cliente.telefono2)) {
printHtmlPart(70)
expressionOut.print(cliente.telefono2)
printHtmlPart(66)
invokeTag('select','g',344,['class':("form-control"),'id':("estadoTel2"),'name':("estadoTel2"),'from':(['51':'LLAMADA DEUDOR Y/O CONYUGE','52':'LLAMADA CONYUGUE DEUDOR','53':'LLAMADA GARANTE Y/O CONYUGE GARANTE','54':'LLAMADA CONYUGUE GARANTE','55':'LLAMADA FAMILIAR','56':'LLAMADA OTROS','0':'EQUIVOCADO']),'noSelection':(['': '-- Seleccione --']),'optionValue':("value"),'optionKey':("key")],-1)
printHtmlPart(66)
invokeTag('select','g',349,['class':("form-control"),'id':("respuestaTel2"),'name':("respuestaTel2"),'from':(['1':'CONTACTADO','0':'NO CONTESTA/NO SATISFACTORIA']),'noSelection':(['': '-- Seleccione --']),'optionValue':("value"),'optionKey':("key")],-1)
printHtmlPart(67)
invokeTag('textField','g',359,['id':("fechaTelf2"),'name':("fechaTelf2"),'class':("form-control"),'onkeypress':("return soloLetras(event)")],-1)
printHtmlPart(68)
invokeTag('textField','g',364,['id':("observacionTelf2"),'name':("observacionTelf2"),'class':("form-control")],-1)
printHtmlPart(69)
}
printHtmlPart(19)
if(true && (cliente.telefono3)) {
printHtmlPart(71)
expressionOut.print(cliente.telefono3)
printHtmlPart(66)
invokeTag('select','g',373,['class':("form-control"),'id':("estadoTel3"),'name':("estadoTel3"),'from':(['51':'LLAMADA DEUDOR Y/O CONYUGE','52':'LLAMADA CONYUGUE DEUDOR','53':'LLAMADA GARANTE Y/O CONYUGE GARANTE','54':'LLAMADA CONYUGUE GARANTE','55':'LLAMADA FAMILIAR','56':'LLAMADA OTROS','0':'EQUIVOCADO']),'noSelection':(['': '-- Seleccione --']),'optionValue':("value"),'optionKey':("key")],-1)
printHtmlPart(66)
invokeTag('select','g',376,['class':("form-control"),'id':("respuestaTel3"),'name':("respuestaTel3"),'from':(['1':'CONTACTADO','0':'NO CONTESTA/NO SATISFACTORIA']),'noSelection':(['': '-- Seleccione --']),'optionValue':("value"),'optionKey':("key")],-1)
printHtmlPart(67)
invokeTag('textField','g',379,['id':("fechaTelf3"),'name':("fechaTelf3"),'class':("form-control"),'onkeypress':("return soloLetras(event)")],-1)
printHtmlPart(68)
invokeTag('textField','g',385,['id':("observacionTelf3"),'name':("observacionTelf3"),'class':("form-control")],-1)
printHtmlPart(69)
}
printHtmlPart(19)
if(true && (cliente.telefono4)) {
printHtmlPart(72)
expressionOut.print(cliente.telefono4)
printHtmlPart(66)
invokeTag('select','g',394,['class':("form-control"),'id':("estadoTel4"),'name':("estadoTel4"),'from':(['51':'LLAMADA DEUDOR Y/O CONYUGE','52':'LLAMADA CONYUGUE DEUDOR','53':'LLAMADA GARANTE Y/O CONYUGE GARANTE','54':'LLAMADA CONYUGUE GARANTE','55':'LLAMADA FAMILIAR','56':'LLAMADA OTROS','0':'EQUIVOCADO']),'noSelection':(['': '-- Seleccione --']),'optionValue':("value"),'optionKey':("key")],-1)
printHtmlPart(66)
invokeTag('select','g',397,['class':("form-control"),'id':("respuestaTel4"),'name':("respuestaTel4"),'from':(['1':'CONTACTADO','0':'NO CONTESTA/NO SATISFACTORIA']),'noSelection':(['': '-- Seleccione --']),'optionValue':("value"),'optionKey':("key")],-1)
printHtmlPart(67)
invokeTag('textField','g',400,['id':("fechaTelf4"),'name':("fechaTelf4"),'class':("form-control"),'onkeypress':("return soloLetras(event)")],-1)
printHtmlPart(68)
invokeTag('textField','g',406,['id':("observacionTelf4"),'name':("observacionTelf4"),'class':("form-control")],-1)
printHtmlPart(69)
}
printHtmlPart(19)
if(true && (cliente.telefono5)) {
printHtmlPart(73)
expressionOut.print(cliente.telefono5)
printHtmlPart(66)
invokeTag('select','g',415,['class':("form-control"),'id':("estadoTel5"),'name':("estadoTel5"),'from':(['51':'LLAMADA DEUDOR Y/O CONYUGE','52':'LLAMADA CONYUGUE DEUDOR','53':'LLAMADA GARANTE Y/O CONYUGE GARANTE','54':'LLAMADA CONYUGUE GARANTE','55':'LLAMADA FAMILIAR','56':'LLAMADA OTROS','0':'EQUIVOCADO']),'noSelection':(['': '-- Seleccione --']),'optionValue':("value"),'optionKey':("key")],-1)
printHtmlPart(66)
invokeTag('select','g',418,['class':("form-control"),'id':("respuestaTel5"),'name':("respuestaTel5"),'from':(['1':'CONTACTADO','0':'NO CONTESTA/NO SATISFACTORIA']),'noSelection':(['': '-- Seleccione --']),'optionValue':("value"),'optionKey':("key")],-1)
printHtmlPart(67)
invokeTag('textField','g',421,['id':("fechaTelf5"),'name':("fechaTelf5"),'class':("form-control"),'onkeypress':("return soloLetras(event)")],-1)
printHtmlPart(68)
invokeTag('textField','g',427,['id':("observacionTelf5"),'name':("observacionTelf5"),'class':("form-control")],-1)
printHtmlPart(69)
}
printHtmlPart(74)
if(true && (cliente.telefono6)) {
printHtmlPart(75)
expressionOut.print(cliente.telefono6)
printHtmlPart(76)
invokeTag('select','g',437,['class':("form-control"),'id':("estadoTel6"),'name':("estadoTel6"),'from':(['51':'LLAMADA DEUDOR Y/O CONYUGE','52':'LLAMADA CONYUGUE DEUDOR','53':'LLAMADA GARANTE Y/O CONYUGE GARANTE','54':'LLAMADA CONYUGUE GARANTE','55':'LLAMADA FAMILIAR','56':'LLAMADA OTROS','0':'EQUIVOCADO']),'noSelection':(['': '-- Seleccione --']),'optionValue':("value"),'optionKey':("key")],-1)
printHtmlPart(76)
invokeTag('select','g',443,['class':("form-control"),'id':("respuestaTel6"),'name':("respuestaTel6"),'from':(['1':'CONTACTADO','0':'NO CONTESTA/NO SATISFACTORIA']),'noSelection':(['': '-- Seleccione --']),'optionValue':("value"),'optionKey':("key")],-1)
printHtmlPart(77)
invokeTag('textField','g',449,['id':("fechaTelf6"),'name':("fechaTelf6"),'class':("form-control"),'onkeypress':("return soloLetras(event)")],-1)
printHtmlPart(78)
invokeTag('textField','g',452,['id':("observacionTelf6"),'name':("observacionTelf6"),'class':("form-control")],-1)
printHtmlPart(79)
}
printHtmlPart(7)
if(true && (cliente.telefono7)) {
printHtmlPart(80)
expressionOut.print(cliente.telefono7)
printHtmlPart(76)
invokeTag('select','g',459,['class':("form-control"),'id':("estadoTel7"),'name':("estadoTel7"),'from':(['51':'LLAMADA DEUDOR Y/O CONYUGE','52':'LLAMADA CONYUGUE DEUDOR','53':'LLAMADA GARANTE Y/O CONYUGE GARANTE','54':'LLAMADA CONYUGUE GARANTE','55':'LLAMADA FAMILIAR','56':'LLAMADA OTROS','0':'EQUIVOCADO']),'noSelection':(['': '-- Seleccione --']),'optionValue':("value"),'optionKey':("key")],-1)
printHtmlPart(76)
invokeTag('select','g',465,['class':("form-control"),'id':("respuestaTel7"),'name':("respuestaTel7"),'from':(['1':'CONTACTADO','0':'NO CONTESTA/NO SATISFACTORIA']),'noSelection':(['': '-- Seleccione --']),'optionValue':("value"),'optionKey':("key")],-1)
printHtmlPart(77)
invokeTag('textField','g',473,['id':("fechaTelf7"),'name':("fechaTelf7"),'class':("form-control"),'onkeypress':("return soloLetras(event)")],-1)
printHtmlPart(78)
invokeTag('textField','g',478,['id':("observacionTelf7"),'name':("observacionTelf7"),'class':("form-control")],-1)
printHtmlPart(79)
}
printHtmlPart(7)
if(true && (cliente.telefono8)) {
printHtmlPart(81)
expressionOut.print(cliente.telefono8)
printHtmlPart(76)
invokeTag('select','g',487,['class':("form-control"),'id':("estadoTel8"),'name':("estadoTel8"),'from':(['51':'LLAMADA DEUDOR Y/O CONYUGE','52':'LLAMADA CONYUGUE DEUDOR','53':'LLAMADA GARANTE Y/O CONYUGE GARANTE','54':'LLAMADA CONYUGUE GARANTE','55':'LLAMADA FAMILIAR','56':'LLAMADA OTROS','0':'EQUIVOCADO']),'noSelection':(['': '-- Seleccione --']),'optionValue':("value"),'optionKey':("key")],-1)
printHtmlPart(76)
invokeTag('select','g',490,['class':("form-control"),'id':("respuestaTel8"),'name':("respuestaTel8"),'from':(['1':'CONTACTADO','0':'NO CONTESTA/NO SATISFACTORIA']),'noSelection':(['': '-- Seleccione --']),'optionValue':("value"),'optionKey':("key")],-1)
printHtmlPart(77)
invokeTag('textField','g',493,['id':("fechaTelf8"),'name':("fechaTelf8"),'class':("form-control"),'onkeypress':("return soloLetras(event)")],-1)
printHtmlPart(78)
invokeTag('textField','g',499,['id':("observacionTelf8"),'name':("observacionTelf8"),'class':("form-control")],-1)
printHtmlPart(79)
}
printHtmlPart(7)
if(true && (cliente.telefono9)) {
printHtmlPart(82)
expressionOut.print(cliente.telefono9)
printHtmlPart(76)
invokeTag('select','g',508,['class':("form-control"),'id':("estadoTel9"),'name':("estadoTel9"),'from':(['51':'LLAMADA DEUDOR Y/O CONYUGE','52':'LLAMADA CONYUGUE DEUDOR','53':'LLAMADA GARANTE Y/O CONYUGE GARANTE','54':'LLAMADA CONYUGUE GARANTE','55':'LLAMADA FAMILIAR','56':'LLAMADA OTROS','0':'EQUIVOCADO']),'noSelection':(['': '-- Seleccione --']),'optionValue':("value"),'optionKey':("key")],-1)
printHtmlPart(76)
invokeTag('select','g',511,['class':("form-control"),'id':("respuestaTel9"),'name':("respuestaTel9"),'from':(['1':'CONTACTADO','0':'NO CONTESTA/NO SATISFACTORIA']),'noSelection':(['': '-- Seleccione --']),'optionValue':("value"),'optionKey':("key")],-1)
printHtmlPart(77)
invokeTag('textField','g',514,['id':("fechaTelf9"),'name':("fechaTelf9"),'class':("form-control"),'onkeypress':("return soloLetras(event)")],-1)
printHtmlPart(78)
invokeTag('textField','g',520,['id':("observacionTelf9"),'name':("observacionTelf9"),'class':("form-control")],-1)
printHtmlPart(79)
}
printHtmlPart(7)
if(true && (cliente.telefono10)) {
printHtmlPart(83)
expressionOut.print(cliente.telefono10)
printHtmlPart(76)
invokeTag('select','g',529,['class':("form-control"),'id':("estadoTel10"),'name':("estadoTel10"),'from':(['51':'LLAMADA DEUDOR Y/O CONYUGE','52':'LLAMADA CONYUGUE DEUDOR','53':'LLAMADA GARANTE Y/O CONYUGE GARANTE','54':'LLAMADA CONYUGUE GARANTE','55':'LLAMADA FAMILIAR','56':'LLAMADA OTROS','0':'EQUIVOCADO']),'noSelection':(['': '-- Seleccione --']),'optionValue':("value"),'optionKey':("key")],-1)
printHtmlPart(76)
invokeTag('select','g',532,['class':("form-control"),'id':("respuestaTel10"),'name':("respuestaTel10"),'from':(['1':'CONTACTADO','0':'NO CONTESTA/NO SATISFACTORIA']),'noSelection':(['': '-- Seleccione --']),'optionValue':("value"),'optionKey':("key")],-1)
printHtmlPart(77)
invokeTag('textField','g',535,['id':("fechaTelf10"),'name':("fechaTelf10"),'class':("form-control"),'onkeypress':("return soloLetras(event)")],-1)
printHtmlPart(78)
invokeTag('textField','g',541,['id':("observacionTelf10"),'name':("observacionTelf10"),'class':("form-control")],-1)
printHtmlPart(79)
}
printHtmlPart(84)
if(true && (cliente.telefono11)) {
printHtmlPart(85)
expressionOut.print(cliente.telefono11)
printHtmlPart(76)
invokeTag('select','g',552,['class':("form-control"),'id':("estadoTel11"),'name':("estadoTel11"),'from':(['51':'LLAMADA DEUDOR Y/O CONYUGE','52':'LLAMADA CONYUGUE DEUDOR','53':'LLAMADA GARANTE Y/O CONYUGE GARANTE','54':'LLAMADA CONYUGUE GARANTE','55':'LLAMADA FAMILIAR','56':'LLAMADA OTROS','0':'EQUIVOCADO']),'noSelection':(['': '-- Seleccione --']),'optionValue':("value"),'optionKey':("key")],-1)
printHtmlPart(76)
invokeTag('select','g',557,['class':("form-control"),'id':("respuestaTel11"),'name':("respuestaTel11"),'from':(['1':'CONTACTADO','0':'NO CONTESTA/NO SATISFACTORIA']),'noSelection':(['': '-- Seleccione --']),'optionValue':("value"),'optionKey':("key")],-1)
printHtmlPart(77)
invokeTag('textField','g',563,['id':("fechaTelf11"),'name':("fechaTelf11"),'class':("form-control"),'onkeypress':("return soloLetras(event)")],-1)
printHtmlPart(78)
invokeTag('textField','g',566,['id':("observacionTelf11"),'name':("observacionTelf11"),'class':("form-control")],-1)
printHtmlPart(79)
}
printHtmlPart(7)
if(true && (cliente.telefono12)) {
printHtmlPart(86)
expressionOut.print(cliente.telefono12)
printHtmlPart(76)
invokeTag('select','g',573,['class':("form-control"),'id':("estadoTel12"),'name':("estadoTel12"),'from':(['51':'LLAMADA DEUDOR Y/O CONYUGE','52':'LLAMADA CONYUGUE DEUDOR','53':'LLAMADA GARANTE Y/O CONYUGE GARANTE','54':'LLAMADA CONYUGUE GARANTE','55':'LLAMADA FAMILIAR','56':'LLAMADA OTROS','0':'EQUIVOCADO']),'noSelection':(['': '-- Seleccione --']),'optionValue':("value"),'optionKey':("key")],-1)
printHtmlPart(76)
invokeTag('select','g',578,['class':("form-control"),'id':("respuestaTel12"),'name':("respuestaTel12"),'from':(['1':'CONTACTADO','0':'NO CONTESTA/NO SATISFACTORIA']),'noSelection':(['': '-- Seleccione --']),'optionValue':("value"),'optionKey':("key")],-1)
printHtmlPart(77)
invokeTag('textField','g',585,['id':("fechaTelf12"),'name':("fechaTelf12"),'class':("form-control"),'onkeypress':("return soloLetras(event)")],-1)
printHtmlPart(78)
invokeTag('textField','g',590,['id':("observacionTelf12"),'name':("observacionTelf12"),'class':("form-control")],-1)
printHtmlPart(79)
}
printHtmlPart(7)
if(true && (cliente.telefono13)) {
printHtmlPart(87)
expressionOut.print(cliente.telefono13)
printHtmlPart(76)
invokeTag('select','g',599,['class':("form-control"),'id':("estadoTel13"),'name':("estadoTel13"),'from':(['51':'LLAMADA DEUDOR Y/O CONYUGE','52':'LLAMADA CONYUGUE DEUDOR','53':'LLAMADA GARANTE Y/O CONYUGE GARANTE','54':'LLAMADA CONYUGUE GARANTE','55':'LLAMADA FAMILIAR','56':'LLAMADA OTROS','0':'EQUIVOCADO']),'noSelection':(['': '-- Seleccione --']),'optionValue':("value"),'optionKey':("key")],-1)
printHtmlPart(76)
invokeTag('select','g',602,['class':("form-control"),'id':("respuestaTel13"),'name':("respuestaTel13"),'from':(['1':'CONTACTADO','0':'NO CONTESTA/NO SATISFACTORIA']),'noSelection':(['': '-- Seleccione --']),'optionValue':("value"),'optionKey':("key")],-1)
printHtmlPart(77)
invokeTag('textField','g',606,['id':("fechaTelf13"),'name':("fechaTelf13"),'class':("form-control"),'onkeypress':("return soloLetras(event)")],-1)
printHtmlPart(78)
invokeTag('textField','g',611,['id':("observacionTelf13"),'name':("observacionTelf13"),'class':("form-control")],-1)
printHtmlPart(79)
}
printHtmlPart(7)
if(true && (cliente.telefono14)) {
printHtmlPart(88)
expressionOut.print(cliente.telefono14)
printHtmlPart(76)
invokeTag('select','g',620,['class':("form-control"),'id':("estadoTel14"),'name':("estadoTel14"),'from':(['51':'LLAMADA DEUDOR Y/O CONYUGE','52':'LLAMADA CONYUGUE DEUDOR','53':'LLAMADA GARANTE Y/O CONYUGE GARANTE','54':'LLAMADA CONYUGUE GARANTE','55':'LLAMADA FAMILIAR','56':'LLAMADA OTROS','0':'EQUIVOCADO']),'noSelection':(['': '-- Seleccione --']),'optionValue':("value"),'optionKey':("key")],-1)
printHtmlPart(76)
invokeTag('select','g',623,['class':("form-control"),'id':("respuestaTel14"),'name':("respuestaTel14"),'from':(['1':'CONTACTADO','0':'NO CONTESTA/NO SATISFACTORIA']),'noSelection':(['': '-- Seleccione --']),'optionValue':("value"),'optionKey':("key")],-1)
printHtmlPart(77)
invokeTag('textField','g',627,['id':("fechaTelf14"),'name':("fechaTelf14"),'class':("form-control"),'onkeypress':("return soloLetras(event)")],-1)
printHtmlPart(78)
invokeTag('textField','g',632,['id':("observacionTelf14"),'name':("observacionTelf14"),'class':("form-control")],-1)
printHtmlPart(79)
}
printHtmlPart(7)
if(true && (cliente.telefono15)) {
printHtmlPart(89)
expressionOut.print(cliente.telefono15)
printHtmlPart(76)
invokeTag('select','g',641,['class':("form-control"),'id':("estadoTel15"),'name':("estadoTel15"),'from':(['51':'LLAMADA DEUDOR Y/O CONYUGE','52':'LLAMADA CONYUGUE DEUDOR','53':'LLAMADA GARANTE Y/O CONYUGE GARANTE','54':'LLAMADA CONYUGUE GARANTE','55':'LLAMADA FAMILIAR','56':'LLAMADA OTROS','0':'EQUIVOCADO']),'noSelection':(['': '-- Seleccione --']),'optionValue':("value"),'optionKey':("key")],-1)
printHtmlPart(76)
invokeTag('select','g',644,['class':("form-control"),'id':("respuestaTel15"),'name':("respuestaTel15"),'from':(['1':'CONTACTADO','0':'NO CONTESTA/NO SATISFACTORIA']),'noSelection':(['': '-- Seleccione --']),'optionValue':("value"),'optionKey':("key")],-1)
printHtmlPart(77)
invokeTag('textField','g',648,['id':("fechaTelf15"),'name':("fechaTelf15"),'class':("form-control"),'onkeypress':("return soloLetras(event)")],-1)
printHtmlPart(78)
invokeTag('textField','g',653,['id':("observacionTelf15"),'name':("observacionTelf15"),'class':("form-control")],-1)
printHtmlPart(79)
}
printHtmlPart(90)
if(true && (cliente.tipo_cartera == 'CONDONACION')) {
printHtmlPart(91)
expressionOut.print(cliente.nombre)
printHtmlPart(92)
expressionOut.print(session.user.nombre)
printHtmlPart(93)
expressionOut.print(cliente.nombre)
printHtmlPart(94)
expressionOut.print(cliente.total_a_pagar)
printHtmlPart(95)
expressionOut.print(cliente.marca_tc)
printHtmlPart(96)
expressionOut.print(cliente.pagos_vencidos)
printHtmlPart(97)
expressionOut.print(cliente.tipoBase)
printHtmlPart(98)
expressionOut.print(cliente.valorCondonacion)
printHtmlPart(99)
expressionOut.print(cliente.valor_condonado)
printHtmlPart(100)
expressionOut.print(cliente.nombre)
printHtmlPart(101)
expressionOut.print(cliente.valorCondonacion)
printHtmlPart(102)
}
printHtmlPart(19)
if(true && (cliente.tipo_cartera == 'REFINANCIAMIENTO')) {
printHtmlPart(103)
expressionOut.print(cliente.nombre)
printHtmlPart(92)
expressionOut.print(session.user.nombre)
printHtmlPart(93)
expressionOut.print(cliente.nombre)
printHtmlPart(94)
expressionOut.print(cliente.total_a_pagar)
printHtmlPart(95)
expressionOut.print(cliente.marca_tc)
printHtmlPart(104)
expressionOut.print(cliente.pagos_vencidos)
printHtmlPart(105)
expressionOut.print(cliente.total_a_pagar)
printHtmlPart(106)
expressionOut.print(cliente.nombre)
printHtmlPart(101)
expressionOut.print(cliente.total_a_pagar)
printHtmlPart(107)
expressionOut.print(cliente.tipoBase)
printHtmlPart(108)
expressionOut.print(cliente.nombre)
printHtmlPart(109)
}
printHtmlPart(110)
if(true && (cliente.tipo_cartera == 'CONSOLIDACION')) {
printHtmlPart(111)
expressionOut.print(cliente.nombre)
printHtmlPart(92)
expressionOut.print(session.user.nombre)
printHtmlPart(93)
expressionOut.print(cliente.nombre)
printHtmlPart(94)
expressionOut.print(cliente.total_a_pagar)
printHtmlPart(95)
expressionOut.print(cliente.marca_tc)
printHtmlPart(104)
expressionOut.print(cliente.pagos_vencidos)
printHtmlPart(112)
expressionOut.print(cliente.valorCondonacion)
printHtmlPart(113)
expressionOut.print(cliente.valor_condonado)
printHtmlPart(100)
expressionOut.print(cliente.nombre)
printHtmlPart(101)
expressionOut.print(cliente.total_a_pagar)
printHtmlPart(114)
expressionOut.print(cliente.tipoBase)
printHtmlPart(115)
expressionOut.print(cliente.marca_tc)
printHtmlPart(116)
}
printHtmlPart(117)
expressionOut.print(cliente.id)
printHtmlPart(118)
invokeTag('select','g',769,['class':("form-control"),'name':("estado"),'id':("status"),'from':(callcenter.Estado.list()),'optionKey':("id"),'optionValue':({it.nombre	}),'noSelection':(['': '-- Seleccione --'])],-1)
printHtmlPart(119)
invokeTag('select','g',773,['id':("subSubStatus"),'class':("form-control"),'name':("subSubStatus"),'from':(""),'noSelection':(['': '-- Seleccione --']),'optionKey':("id")],-1)
printHtmlPart(120)
invokeTag('select','g',774,['class':("form-control"),'name':("substatus"),'id':("substatus"),'from':(""),'noSelection':(['': '-- Seleccione --'])],-1)
printHtmlPart(121)
invokeTag('select','g',776,['class':("form-control"),'name':("estadoNivel4"),'id':("estadoNivel4"),'from':(['DIFERIDO INTERNO':'DIFERIDO INTERNO', 'REESTRUCTURACION':'REESTRUCTURACION', 'REFINANCIAMIENTO':'REFINANCIAMIENTO']),'optionKey':("key"),'optionValue':("value"),'noSelection':(['': '-- Seleccione --'])],-1)
printHtmlPart(122)
invokeTag('textArea','g',778,['class':("form-control"),'name':("motivoNoAceptaSeguro"),'value':("")],-1)
printHtmlPart(123)
invokeTag('select','g',782,['class':("form-control"),'name':("agendamiento"),'id':("agendamiento"),'from':(['AGENDAR PARA MI':'AGENDAR PARA MI', 'AGENDAR PARA CUALQUIERA':'AGENDAR PARA CUALQUIERA']),'optionKey':("key"),'optionValue':("value"),'noSelection':(['': '-- Seleccione --'])],-1)
printHtmlPart(124)
invokeTag('textField','g',783,['id':("recall"),'name':("recall"),'class':("recall form-control")],-1)
printHtmlPart(125)
invokeTag('textField','g',789,['maxlength':("10"),'minlength':("9"),'id':("telefonoContactado"),'name':("telefonoContactado"),'class':("form-control")],-1)
printHtmlPart(126)
if(true && (cliente.provinciaPromesa != null)) {
printHtmlPart(127)
invokeTag('select','g',878,['class':("form-control"),'id':("provinciaGestion"),'name':("provinciaGestion"),'optionKey':("id"),'noSelection':(['': '-- Seleccione --']),'from':(callcenter.Provincia.list(sort: "nombre", order: "asc")),'optionValue':({it.nombre}),'value':(cliente.provinciaPromesa.id)],-1)
printHtmlPart(128)
}
else {
printHtmlPart(127)
invokeTag('select','g',882,['class':("form-control"),'id':("provinciaGestion"),'name':("provinciaGestion"),'optionKey':("id"),'noSelection':(['': '-- Seleccione --']),'from':(callcenter.Provincia.list(sort: "nombre", order: "asc")),'optionValue':({it.nombre})],-1)
printHtmlPart(128)
}
printHtmlPart(129)
if(true && (cliente.ciudadPromesa != null)) {
printHtmlPart(128)
invokeTag('select','g',892,['class':("form-control"),'id':("ciudadGestiones"),'name':("ciudadGestiones"),'optionKey':("id"),'noSelection':(['': '-- Seleccione --']),'from':(callcenter.Ciudad.list()),'optionValue':({it.nombre}),'value':(cliente.ciudadPromesa.id)],-1)
printHtmlPart(130)
}
else {
printHtmlPart(128)
invokeTag('select','g',894,['class':("form-control"),'id':("ciudadGestiones"),'name':("ciudadGestiones"),'optionKey':("id"),'noSelection':(['': '-- Seleccione --']),'from':(""),'optionValue':({it.nombre})],-1)
printHtmlPart(130)
}
printHtmlPart(131)
if(true && (cliente.cantonPromesa != null)) {
printHtmlPart(128)
invokeTag('select','g',903,['class':("form-control"),'id':("cantonGestion"),'name':("cantonGestion"),'optionKey':("id"),'noSelection':(['': '-- Seleccione --']),'from':(callcenter.Canton.list()),'optionValue':({it.nombre}),'value':(cliente.cantonPromesa.id)],-1)
printHtmlPart(130)
}
else {
printHtmlPart(128)
invokeTag('select','g',906,['class':("form-control"),'id':("cantonGestion"),'name':("cantonGestion"),'optionKey':("id"),'noSelection':(['': '-- Seleccione --']),'from':(""),'optionValue':({it.nombre})],-1)
printHtmlPart(130)
}
printHtmlPart(132)
if(true && (cliente.parroquiaPromesa != null)) {
printHtmlPart(128)
invokeTag('select','g',910,['class':("form-control"),'id':("parroquiaGestion"),'name':("parroquiaGestion"),'optionKey':("id"),'noSelection':(['': '-- Seleccione --']),'from':(callcenter.Parroquia.list()),'optionValue':({it.nombre}),'value':(cliente.parroquiaPromesa.id)],-1)
printHtmlPart(130)
}
else {
printHtmlPart(128)
invokeTag('select','g',914,['class':("form-control"),'id':("parroquiaGestion"),'name':("parroquiaGestion"),'optionKey':("id"),'noSelection':(['': '-- Seleccione --']),'from':(""),'optionValue':({it.nombre})],-1)
printHtmlPart(130)
}
printHtmlPart(133)
invokeTag('textField','g',925,['id':("callePrincipalGestion"),'name':("callePrincipalGestion"),'class':("form-control"),'value':(cliente.callePrincipalGestion)],-1)
printHtmlPart(134)
invokeTag('textField','g',929,['id':("numeroCasaGestion"),'name':("numeroCasaGestion"),'class':("form-control"),'value':(cliente.numeroCasaGestion)],-1)
printHtmlPart(135)
invokeTag('textField','g',932,['id':("calleSecundariaGestion"),'name':("calleSecundariaGestion"),'class':("form-control"),'value':(cliente.calleSecundariaGestion)],-1)
printHtmlPart(136)
invokeTag('textArea','g',938,['class':("form-control"),'id':("referenciaGestion"),'name':("referenciaGestion"),'value':(cliente.referenciaGestion)],-1)
printHtmlPart(137)
invokeTag('textField','g',943,['id':("fecha_promesa"),'name':("fecha_promesa"),'class':("datepickertest form-control"),'onkeypress':("return soloLetras(event)"),'value':(cliente.fecha_promesa)],-1)
printHtmlPart(138)
invokeTag('textField','g',949,['class':("form-control"),'id':("valor_promesa"),'name':("valor_promesa"),'minlength':("1"),'maxlength':("15"),'value':(cliente.valor_promesa)],-1)
printHtmlPart(139)
invokeTag('textField','g',951,['class':("form-control"),'id':("telefonoDomicilio"),'name':("telefonoDomicilio"),'minlength':("9"),'maxlength':("9"),'value':("")],-1)
printHtmlPart(140)
invokeTag('textField','g',958,['class':("form-control"),'id':("celular"),'name':("celular"),'minlength':("10"),'maxlength':("10"),'value':("")],-1)
printHtmlPart(141)
invokeTag('select','g',965,['class':("form-control"),'name':("plazoGestion"),'id':("plazoGestion"),'from':(['0':'0', '3':'3', 	'6':'6', 	'9':'9', 	'12':'12', 	'18':'18', 	'24':'24', 	'36':'36', 	'48':'48', 	'60':'60', 	'60 CON 2 GRACIA':'60 CON 2 GRACIA',]),'optionKey':("key"),'optionValue':("value"),'noSelection':(['': '-- Seleccione --'])],-1)
printHtmlPart(142)
invokeTag('textField','g',974,['id':("valorCondonacion"),'name':("valorCondonacion"),'class':("form-control"),'value':(cliente?.valorCondonacion)],-1)
printHtmlPart(143)
invokeTag('select','g',981,['class':("form-control"),'id':("provinciaAgencia"),'name':("provinciaAgencia"),'optionKey':("id"),'noSelection':(['': '-- Seleccione --']),'from':(callcenter.Provincia.list(sort: "nombre", order: "asc")),'optionValue':({it.nombre})],-1)
printHtmlPart(144)
invokeTag('select','g',986,['class':("form-control"),'id':("ciudadAgencia"),'name':("ciudadGestion"),'optionKey':("id"),'noSelection':(['': '-- Seleccione --']),'from':(""),'optionValue':({it.nombre})],-1)
printHtmlPart(145)
invokeTag('select','g',993,['class':("form-control"),'id':("nombreCondonacionAgencia"),'name':("nombreCondonacionAgencia"),'optionKey':("id"),'noSelection':(['': '-- Seleccione --']),'from':(""),'optionValue':({it.nombre})],-1)
printHtmlPart(146)
invokeTag('textField','g',997,['id':("fechaVisitaAgenciaCondonacion"),'name':("fechaVisitaAgenciaCondonacion"),'class':("datepickertest form-control")],-1)
printHtmlPart(147)
invokeTag('textArea','g',998,['class':("form-control"),'name':("observacionesCondonacion")],-1)
printHtmlPart(148)
invokeTag('textArea','g',1005,['class':("form-control"),'name':("observaciones"),'value':(cliente?.observaciones)],-1)
printHtmlPart(149)
invokeTag('submitButton','g',1008,['id':("send"),'name':("btnGuardarCliente"),'class':("btn btn-primary"),'value':("Guardar Gestión")],-1)
printHtmlPart(150)
})
invokeTag('form','g',1010,['action':("guardarCliente")],1)
printHtmlPart(151)
invokeTag('javascript','asset',1011,['src':("usogeneral/objetos.js")],-1)
printHtmlPart(0)
invokeTag('javascript','asset',1013,['src':("gestion/gestionCliente1.js")],-1)
printHtmlPart(0)
invokeTag('javascript','asset',1013,['src':("usogeneral/customdatetimepicker.js")],-1)
printHtmlPart(0)
invokeTag('javascript','asset',1013,['src':("usogeneral/datetimepicker.js")],-1)
printHtmlPart(0)
invokeTag('javascript','asset',1013,['src':("usogeneral/bootstrap-datepicker.min.js")],-1)
printHtmlPart(0)
invokeTag('javascript','asset',1013,['src':("usogeneral/customdatepicker.js")],-1)
printHtmlPart(0)
invokeTag('javascript','asset',1015,['src':("usogeneral/bootstrap-datepicker.es.min.js")],-1)
printHtmlPart(0)
invokeTag('javascript','asset',1018,['src':("usogeneral/moment.min.js")],-1)
printHtmlPart(0)
invokeTag('javascript','asset',1023,['src':("usogeneral/daterangepicker.js")],-1)
printHtmlPart(0)
invokeTag('stylesheet','asset',1023,['src':("usogeneral/daterangepicker.css")],-1)
printHtmlPart(0)
invokeTag('stylesheet','asset',1024,['src':("usogeneral/customdaterangepicker.css")],-1)
printHtmlPart(0)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1628710915630L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
