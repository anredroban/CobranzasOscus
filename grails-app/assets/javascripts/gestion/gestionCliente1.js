$(document).ready(function(){
    $("#overlay").hide();
    $telefonoContactadoDiv = $("#telefonoContactadoDiv");
    $telefonoContactado = $("#telefonoContactado");
    $numeroCasaDomicilio = $("#numeroCasaDomicilio");
    $telefonoContacto = $("#telefonoContacto");
    $status = $("#status")
    $subSubStatus = $("#subSubStatus");
    $divMotivo = $("#divMotivo");
    init();

    $status.change(function(){
        esconderCamposEstados();
        //$telefonoContactadoDiv.hide();
        $telefonoContactado.val("");
        if($status.val() == ""){
            emptySelect('subSubStatus');
            emptySelect('estadoTelefonoContactado');
        }else{
            $statusId = this.value;
            if($statusId == 1){
                // $telefonoContactadoDiv.show();
            }
            $.get(baseUrl + "/FuncionesAjax/getSubStatusByStatus", {
                id: $statusId
            }, function (data) {
                fillSelect('subSubStatus', data);
            });
            $.get(baseUrl + "/FuncionesAjax/getEstadosTelefono", {
                id: $statusId
            }, function (data) {
                fillSelect('estadoTelefonoContactado', data);
            });
        }
    });



    //Cuando cambia el SUBESTADO
   /* $("#substatus").change(function () {
        esconderCamposEstados();
        // $("#btnAdicional").attr("disabled", true);
        if($("#substatus").val() == ""){
            emptySelect("subSubStatus");
        }else{
            $subStatusId = this.value;
            $.get(baseUrl + "/FuncionesAjax/getSubSubStatusBySubStatus", {
                id: $subStatusId
            }, function (data) {
                if(fillSelect('subSubStatus', data) > 0){
                    $("#subSubStatusDiv").show();
                    //  $telefonoContactadoDiv.show();
                }else{
                    $("#subSubStatusDiv").hide();
                    //$("#send").show()
                }
                if(data[2] == 'Rellamada'){
                    $("#recallDiv").show();
                }else{
                    $("#recallDiv").hide();
                }
                if(data[2] == 'Exitoso'){
                    $("#managementData").show();
                }else{
                    $("#recallDiv").hide();
                }
            });
        }
    });*/
    $("#subSubStatus").change(function () {
        esconderCamposEstados();
        // $("#btnAdicional").attr("disabled", true);
        if($("#subSubStatus").val() == ""){
            emptySelect("substatus");
        }else{
            $subStatusId = this.value;
            $.get(baseUrl + "/FuncionesAjax/getSubSubStatusBySubStatus", {
                id: $subStatusId
            }, function (data) {
                if(fillSelect('substatus', data) > 0){
                    $("#subStatusDiv").show();
                    //  $telefonoContactadoDiv.show();
                }else{
                    $("#subStatusDiv").hide();
                    //$("#send").show()
                }
                if(data[2] == 'Rellamada'){
                    $("#recallDiv").show();
                }else{
                    $("#recallDiv").hide();
                }
                if(data[2] == 'Exitoso'){
                    $("#managementData").show();
                }else{
                    $("#managementData").hide();
                }
                if(data[2] == 'Condonacion'){
                    $("#condonacionData").show();
                }else{
                    $("#condonacionData").hide();
                }
                /*if(data[3] == 'ScriptFallecidoMuerteNatural'){
                    $("#divScriptFallecidoMuerteNatural").show();
                }else{
                    $("#divScriptFallecidoMuerteNatural").hide();
                }*/
            });
        }
    });


    $("#substatus").change(function () {
        if($(this).val().trim() == 2 || $(this).val().trim() == 28){
            $("#managementData").show();
            $("#divEstadoNivel4").show();

        }else{
            $("#managementData").hide();
            $("#divEstadoNivel4").hide();
        }
        if($(this).val().trim() == 9){
            $("#recallDiv").show();
        }else{
            $("#recallDiv").hide();
        }
        if($(this).val().trim() == 29){
            $("#condonacionData").show();
        }else{
            $("#condonacionData").hide();
        }
        if($(this).val().trim() == 15){
            $("#divScriptFallecidoMuerteNatural").show();
        }else{
            $("#divScriptFallecidoMuerteNatural").hide();
        }
        if($(this).val().trim() == 30){
            $("#divScriptFallecidoAccidente").show();
        }else{
            $("#divScriptFallecidoAccidente").hide();
        }
        if($(this).val().trim() == 31){
            $("#divScriptIncapacidadTotalPermanente").show();
        }else{
            $("#divScriptIncapacidadTotalPermanente").hide();
        }
        if($(this).val().trim() == 32){
            $("#divScriptIncapacidadLaboralTemporal").show();
        }else{
            $("#divScriptIncapacidadLaboralTemporal").hide();
        }

    });

    //Cuando cambia el check PROTECCION FRAUDES
    $("#fraudes").change(function () {
        $("#cobroProteccionFraudes").val($("#cobroProteccionFraudes option:first").val());
        if($(this).prop('checked')){
            $("#cobroDiv").show();
        }else
            $("#cobroDiv").hide();
    });


    //Cuando se escribe la cédula
    $('#cedula').keyup(function(){
        if($(this).val().trim().length == 10){
            var query = $(this).val();
            if(query != ''){
                load_data(query);

            }else{
                load_data();
            }
        }
    });




    //Cuando sale de foco el SEGUNDO NOMBRE
    $("#segundoNombre").focusout(function () {
        if($("#segundoNombre").val().trim() != ''){
            $("#radioSegundoNombre").prop('disabled', false);
        }else {
            $("#radioPrimerNombre").prop('checked', true);
            $("#radioSegundoNombre").prop('disabled', true);
        }
    });

    //Cuando se cambia la PROVINCIA DE DOMICILIO
    $("#provinciaGestion").change(function (data) {
        //emptySelect("ciudadGestion");
        emptySelect("cantonGestion");
        emptySelect("parroquiaGestion");
        if($("#provinciaGestion").val() != ""){
            $idProvincia = this.value;
            /*$.get(baseUrl + "/FuncionesAjax/getCiudadesEntrega", {id: $idProvincia}, function (data) {
                fillSelect("ciudadGestion", data)
            });*/
            $.get(baseUrl + "/FuncionesAjax/getCantones", {id: $idProvincia}, function (data) {
                fillSelect("cantonGestion", data)
            })
        }
    });

    //Cuando se cambia la PROVINCIA DE DOMICILIO
    $("#provinciaGestion").change(function (data) {
        emptySelect("ciudadGestiones");
        //emptySelect("cantonGestion");
        emptySelect("parroquiaGestion");
        if($("#provinciaGestion").val() != ""){
            $idProvincia = this.value;
            $.get(baseUrl + "/FuncionesAjax/getCiudadesEntrega", {id: $idProvincia}, function (data) {
                fillSelect("ciudadGestiones", data)
            });
            /*$.get(baseUrl + "/FuncionesAjax/getCantones", {id: $idProvincia}, function (data) {
                fillSelect("cantonGestion", data)
            })*/
        }
    });



    //Cuando se cambia el CANTON DE DOMICILIO
    $("#cantonGestion").change(function (data) {
        emptySelect("parroquiaGestion");
        if($("#cantonGestion").val() != ""){
            $idCanton = this.value;
            $.get(baseUrl + "/FuncionesAjax/getParroquias", {id: $idCanton}, function (data) {
                fillSelect("parroquiaGestion", data)
            });
        }
    });


    //Cuando se cambia la PROVINCIA DE AGENCIA
    $("#provinciaAgencia").change(function (data) {
        emptySelect("ciudadAgencia");
        if($("#provinciaAgencia").val() != ""){
            $idProvincia = this.value;
            $.get(baseUrl + "/FuncionesAjax/getCiudades", {id: $idProvincia}, function (data) {
                fillSelect("ciudadAgencia", data)
            });
        }
    });

    //Cuando se cambia la CIUDAD DE AGENCIA
    $("#ciudadAgencia").change(function (data) {
        emptySelect("nombreCondonacionAgencia");
        if($("#ciudadAgencia").val() != ""){
            $idCiudad = this.value;
            $.get(baseUrl + "/FuncionesAjax/getParroquiasAgencias", {id: $idCiudad}, function (data) {
                fillSelect("nombreCondonacionAgencia", data)
            });
        }
    });


    $("#respuestaTel1").change(function () {
        var hoy = new Date();
        var fecha = hoy.getDate() + '/' + ( hoy.getMonth() + 1 ) + '/' + hoy.getFullYear();
        var extraeHoras = hoy.getHours();
        var horas =  ( extraeHoras < 10 ? '0' : '' ) + extraeHoras;
        if (horas.length <= 1){ horas = '0' + horas}
        var extraeMinutos = hoy.getMinutes();
        var minutos =  ( extraeMinutos < 10 ? '0' : '' ) + extraeMinutos;
        var horaFinal = horas + ':' + minutos;
        var fechaFinal = fecha + ' ' + horaFinal;
        $('#fechaTelf1').val(fechaFinal);
    });
    $('#fechaTelf1').on('keypress', function(e) {
        if(checkIfNumberNoSpace(e.which, e)==0){
            return false;
        }else{
            return;
        }
    });
    $("#respuestaTel2").change(function () {
        var hoy = new Date();
        var fecha = hoy.getDate() + '/' + ( hoy.getMonth() + 1 ) + '/' + hoy.getFullYear();
        var extraeHoras = hoy.getHours();
        var horas =  ( extraeHoras < 10 ? '0' : '' ) + extraeHoras;
        if (horas.length <= 1){ horas = '0' + horas}
        var extraeMinutos = hoy.getMinutes();
        var minutos =  ( extraeMinutos < 10 ? '0' : '' ) + extraeMinutos;
        var horaFinal = horas + ':' + minutos;
        var fechaFinal = fecha + ' ' + horaFinal;
        $('#fechaTelf2').val(fechaFinal);

    });
    $('#fechaTelf2').on('keypress', function(e) {
        if(checkIfNumberNoSpace(e.which, e)==0){
            return false;
        }else{
            return;
        }
    });
    $("#respuestaTel3").change(function () {
        var hoy = new Date();
        var fecha = hoy.getDate() + '/' + ( hoy.getMonth() + 1 ) + '/' + hoy.getFullYear();
        var extraeHoras = hoy.getHours();
        var horas =  ( extraeHoras < 10 ? '0' : '' ) + extraeHoras;
        if (horas.length <= 1){ horas = '0' + horas}
        var extraeMinutos = hoy.getMinutes();
        var minutos =  ( extraeMinutos < 10 ? '0' : '' ) + extraeMinutos;
        var horaFinal = horas + ':' + minutos;
        var fechaFinal = fecha + ' ' + horaFinal;
        $('#fechaTelf3').val(fechaFinal);
    });
    $('#fechaTelf3').on('keypress', function(e) {
        if(checkIfNumberNoSpace(e.which, e)==0){
            return false;
        }else{
            return;
        }
    });
    $("#respuestaTel4").change(function () {
        var hoy = new Date();
        var fecha = hoy.getDate() + '/' + ( hoy.getMonth() + 1 ) + '/' + hoy.getFullYear();
        var extraeHoras = hoy.getHours();
        var horas =  ( extraeHoras < 10 ? '0' : '' ) + extraeHoras;
        if (horas.length <= 1){ horas = '0' + horas}
        var extraeMinutos = hoy.getMinutes();
        var minutos =  ( extraeMinutos < 10 ? '0' : '' ) + extraeMinutos;
        var horaFinal = horas + ':' + minutos;
        var fechaFinal = fecha + ' ' + horaFinal;
        $('#fechaTelf4').val(fechaFinal);
    });
    $('#fechaTelf4').on('keypress', function(e) {
        if(checkIfNumberNoSpace(e.which, e)==0){
            return false;
        }else{
            return;
        }
    });

    $("#respuestaTel5").change(function () {
        var hoy = new Date();
        var fecha = hoy.getDate() + '/' + ( hoy.getMonth() + 1 ) + '/' + hoy.getFullYear();
        var extraeHoras = hoy.getHours();
        var horas =  ( extraeHoras < 10 ? '0' : '' ) + extraeHoras;
        if (horas.length <= 1){ horas = '0' + horas}
        var extraeMinutos = hoy.getMinutes();
        var minutos =  ( extraeMinutos < 10 ? '0' : '' ) + extraeMinutos;
        var horaFinal = horas + ':' + minutos;
        var fechaFinal = fecha + ' ' + horaFinal;
        $('#fechaTelf5').val(fechaFinal);
    });
    $('#fechaTelf5').on('keypress', function(e) {
        if(checkIfNumberNoSpace(e.which, e)==0){
            return false;
        }else{
            return;
        }
    });

    $("#respuestaTel6").change(function () {
        var hoy = new Date();
        var fecha = hoy.getDate() + '/' + ( hoy.getMonth() + 1 ) + '/' + hoy.getFullYear();
        var extraeHoras = hoy.getHours();
        var horas =  ( extraeHoras < 10 ? '0' : '' ) + extraeHoras;
        if (horas.length <= 1){ horas = '0' + horas}
        var extraeMinutos = hoy.getMinutes();
        var minutos =  ( extraeMinutos < 10 ? '0' : '' ) + extraeMinutos;
        var horaFinal = horas + ':' + minutos;
        var fechaFinal = fecha + ' ' + horaFinal;
        $('#fechaTelf6').val(fechaFinal);
    });
    $('#fechaTelf6').on('keypress', function(e) {
        if(checkIfNumberNoSpace(e.which, e)==0){
            return false;
        }else{
            return;
        }
    });
    $("#respuestaTel7").change(function () {
        var hoy = new Date();
        var fecha = hoy.getDate() + '/' + ( hoy.getMonth() + 1 ) + '/' + hoy.getFullYear();
        var extraeHoras = hoy.getHours();
        var horas =  ( extraeHoras < 10 ? '0' : '' ) + extraeHoras;
        if (horas.length <= 1){ horas = '0' + horas}
        var extraeMinutos = hoy.getMinutes();
        var minutos =  ( extraeMinutos < 10 ? '0' : '' ) + extraeMinutos;
        var horaFinal = horas + ':' + minutos;
        var fechaFinal = fecha + ' ' + horaFinal;
        $('#fechaTelf7').val(fechaFinal);
    });
    $('#fechaTelf7').on('keypress', function(e) {
        if(checkIfNumberNoSpace(e.which, e)==0){
            return false;
        }else{
            return;
        }
    });
    $("#respuestaTel8").change(function () {
        var hoy = new Date();
        var fecha = hoy.getDate() + '/' + ( hoy.getMonth() + 1 ) + '/' + hoy.getFullYear();
        var extraeHoras = hoy.getHours();
        var horas =  ( extraeHoras < 10 ? '0' : '' ) + extraeHoras;
        if (horas.length <= 1){ horas = '0' + horas}
        var extraeMinutos = hoy.getMinutes();
        var minutos =  ( extraeMinutos < 10 ? '0' : '' ) + extraeMinutos;
        var horaFinal = horas + ':' + minutos;
        var fechaFinal = fecha + ' ' + horaFinal;
        $('#fechaTelf8').val(fechaFinal);
    });
    $('#fechaTelf8').on('keypress', function(e) {
        if(checkIfNumberNoSpace(e.which, e)==0){
            return false;
        }else{
            return;
        }
    });
    $("#respuestaTel9").change(function () {
        var hoy = new Date();
        var fecha = hoy.getDate() + '/' + ( hoy.getMonth() + 1 ) + '/' + hoy.getFullYear();
        var extraeHoras = hoy.getHours();
        var horas =  ( extraeHoras < 10 ? '0' : '' ) + extraeHoras;
        if (horas.length <= 1){ horas = '0' + horas}
        var extraeMinutos = hoy.getMinutes();
        var minutos =  ( extraeMinutos < 10 ? '0' : '' ) + extraeMinutos;
        var horaFinal = horas + ':' + minutos;
        var fechaFinal = fecha + ' ' + horaFinal;
        $('#fechaTelf9').val(fechaFinal);
    });
    $('#fechaTelf9').on('keypress', function(e) {
        if(checkIfNumberNoSpace(e.which, e)==0){
            return false;
        }else{
            return;
        }
    });
    $("#respuestaTel10").change(function () {
        var hoy = new Date();
        var fecha = hoy.getDate() + '/' + ( hoy.getMonth() + 1 ) + '/' + hoy.getFullYear();
        var extraeHoras = hoy.getHours();
        var horas =  ( extraeHoras < 10 ? '0' : '' ) + extraeHoras;
        if (horas.length <= 1){ horas = '0' + horas}
        var extraeMinutos = hoy.getMinutes();
        var minutos =  ( extraeMinutos < 10 ? '0' : '' ) + extraeMinutos;
        var horaFinal = horas + ':' + minutos;
        var fechaFinal = fecha + ' ' + horaFinal;
        $('#fechaTelf10').val(fechaFinal);
    });
    $('#fechaTelf10').on('keypress', function(e) {
        if(checkIfNumberNoSpace(e.which, e)==0){
            return false;
        }else{
            return;
        }
    });
    $("#respuestaTel11").change(function () {
        var hoy = new Date();
        var fecha = hoy.getDate() + '/' + ( hoy.getMonth() + 1 ) + '/' + hoy.getFullYear();
        var extraeHoras = hoy.getHours();
        var horas =  ( extraeHoras < 10 ? '0' : '' ) + extraeHoras;
        if (horas.length <= 1){ horas = '0' + horas}
        var extraeMinutos = hoy.getMinutes();
        var minutos =  ( extraeMinutos < 10 ? '0' : '' ) + extraeMinutos;
        var horaFinal = horas + ':' + minutos;
        var fechaFinal = fecha + ' ' + horaFinal;
        $('#fechaTelf11').val(fechaFinal);
    });
    $('#fechaTelf11').on('keypress', function(e) {
        if(checkIfNumberNoSpace(e.which, e)==0){
            return false;
        }else{
            return;
        }
    });
    $("#respuestaTel12").change(function () {
        var hoy = new Date();
        var fecha = hoy.getDate() + '/' + ( hoy.getMonth() + 1 ) + '/' + hoy.getFullYear();
        var extraeHoras = hoy.getHours();
        var horas =  ( extraeHoras < 10 ? '0' : '' ) + extraeHoras;
        if (horas.length <= 1){ horas = '0' + horas}
        var extraeMinutos = hoy.getMinutes();
        var minutos =  ( extraeMinutos < 10 ? '0' : '' ) + extraeMinutos;
        var horaFinal = horas + ':' + minutos;
        var fechaFinal = fecha + ' ' + horaFinal;
        $('#fechaTelf12').val(fechaFinal);
    });
    $('#fechaTelf12').on('keypress', function(e) {
        if(checkIfNumberNoSpace(e.which, e)==0){
            return false;
        }else{
            return;
        }
    });
    $("#respuestaTel13").change(function () {
        var hoy = new Date();
        var fecha = hoy.getDate() + '/' + ( hoy.getMonth() + 1 ) + '/' + hoy.getFullYear();
        var extraeHoras = hoy.getHours();
        var horas =  ( extraeHoras < 10 ? '0' : '' ) + extraeHoras;
        if (horas.length <= 1){ horas = '0' + horas}
        var extraeMinutos = hoy.getMinutes();
        var minutos =  ( extraeMinutos < 10 ? '0' : '' ) + extraeMinutos;
        var horaFinal = horas + ':' + minutos;
        var fechaFinal = fecha + ' ' + horaFinal;
        $('#fechaTelf13').val(fechaFinal);
    });
    $('#fechaTelf13').on('keypress', function(e) {
        if(checkIfNumberNoSpace(e.which, e)==0){
            return false;
        }else{
            return;
        }
    });
    $("#respuestaTel14").change(function () {
        var hoy = new Date();
        var fecha = hoy.getDate() + '/' + ( hoy.getMonth() + 1 ) + '/' + hoy.getFullYear();
        var extraeHoras = hoy.getHours();
        var horas =  ( extraeHoras < 10 ? '0' : '' ) + extraeHoras;
        if (horas.length <= 1){ horas = '0' + horas}
        var extraeMinutos = hoy.getMinutes();
        var minutos =  ( extraeMinutos < 10 ? '0' : '' ) + extraeMinutos;
        var horaFinal = horas + ':' + minutos;
        var fechaFinal = fecha + ' ' + horaFinal;
        $('#fechaTelf14').val(fechaFinal);
    });
    $('#fechaTelf14').on('keypress', function(e) {
        if(checkIfNumberNoSpace(e.which, e)==0){
            return false;
        }else{
            return;
        }
    });
    $("#respuestaTel15").change(function () {
        var hoy = new Date();
        var fecha = hoy.getDate() + '/' + ( hoy.getMonth() + 1 ) + '/' + hoy.getFullYear();
        var extraeHoras = hoy.getHours();
        var horas =  ( extraeHoras < 10 ? '0' : '' ) + extraeHoras;
        if (horas.length <= 1){ horas = '0' + horas}
        var extraeMinutos = hoy.getMinutes();
        var minutos =  ( extraeMinutos < 10 ? '0' : '' ) + extraeMinutos;
        var horaFinal = horas + ':' + minutos;
        var fechaFinal = fecha + ' ' + horaFinal;
        $('#fechaTelf15').val(fechaFinal);
    });
    $('#fechaTelf15').on('keypress', function(e) {
        if(checkIfNumberNoSpace(e.which, e)==0){
            return false;
        }else{
            return;
        }
    });




    $(".accordion-titulo").click(function(){

        var contenido=$(this).next(".accordion-content");

        if(contenido.css("display")=="none"){ //open
            contenido.slideDown(250);
            $(this).addClass("open");
        }
        else{ //close
            contenido.slideUp(250);
            $(this).removeClass("open");
        }
    });



    //Cuando se quiere GUARDAR LA GESTION
    $("#send").click(function (e) {
        if(!validateManagementData()){
            e.preventDefault()
            return false
        }else{
            $("#send").hide();
            $("#overlay").show();
        }
    });

});


//Validación de los DATOS DE GESTION
function validateManagementData() {
    $isValid = true

    if ($("#number1").is(":visible")) {
        if ($("#estadoTel1").val() == "") {
            alert("Debe seleccionar un estado para el numero de Telefono 1");
            $isValid = false;
            return
        }
        if ($("#respuestaTel1").val() == "") {
            alert("Debe seleccionar la respuesta para el numero de Telefono 1");
            $isValid = false;
            return
        }

        if ($("#observacionTelf1").val() == "") {
            alert("Debe seleccionar la Observación para el numero de Telefono 1");
            $isValid = false;
            return
        }
    }
    if ($("#number2").is(":visible")) {
        if ($("#estadoTel2").val() == "") {
            alert("Debe seleccionar un estado para el numero de Telefono 2");
            $isValid = false;
            return
        }
        if ($("#respuestaTel2").val() == "") {
            alert("Debe seleccionar la respuesta para el numero de Telefono 2");
            $isValid = false;
            return
        }
        if ($("#observacionTelf2").val() == "") {
            alert("Debe seleccionar la Observación para el numero de Telefono 2");
            $isValid = false;
            return
        }
    }
    if ($("#number3").is(":visible")) {
        if ($("#estadoTel3").val() == "") {
            alert("Debe seleccionar un estado para el numero de Telefono 3");
            $isValid = false;
            return
        }
        if ($("#respuestaTel3").val() == "") {
            alert("Debe seleccionar la respuesta para el numero de Telefono 3");
            $isValid = false;
            return
        }
        if ($("#observacionTelf3").val() == "") {
            alert("Debe seleccionar la Observación para el numero de Telefono 3");
            $isValid = false;
            return
        }
    }
    if ($("#number4").is(":visible")) {
        if ($("#estadoTel4").val() == "") {
            alert("Debe seleccionar un estado para el numero de Telefono 4");
            $isValid = false;
            return
        }
        if ($("#respuestaTel4").val() == "") {
            alert("Debe seleccionar la respuesta para el numero de Telefono 4");
            $isValid = false;
            return
        }
        if ($("#observacionTelf4").val() == "") {
            alert("Debe seleccionar la Observación para el numero de Telefono 4");
            $isValid = false;
            return
        }
    }
    if ($("#number5").is(":visible")) {
        if ($("#estadoTel5").val() == "") {
            alert("Debe seleccionar un estado para el numero de Telefono 5");
            $isValid = false;
            return
        }
        if ($("#respuestaTel5").val() == "") {
            alert("Debe seleccionar la respuesta para el numero de Telefono 5");
            $isValid = false;
            return
        }
        if ($("#observacionTelf5").val() == "") {
            alert("Debe seleccionar la Observación para el numero de Telefono 5");
            $isValid = false;
            return
        }
    }
    if ($("#number6").is(":visible")) {
        if ($("#estadoTel6").val() == "") {
            alert("Debe seleccionar un estado para el numero de Telefono 6");
            $isValid = false;
            return
        }
        if ($("#respuestaTel6").val() == "") {
            alert("Debe seleccionar la respuesta para el numero de Telefono 6");
            $isValid = false;
            return
        }
        if ($("#observacionTelf6").val() == "") {
            alert("Debe seleccionar la Observación para el numero de Telefono 6");
            $isValid = false;
            return
        }
    }
    if ($("#number7").is(":visible")) {
        if ($("#estadoTel7").val() == "") {
            alert("Debe seleccionar un estado para el numero de Telefono 7");
            $isValid = false;
            return
        }
        if ($("#respuestaTel7").val() == "") {
            alert("Debe seleccionar la respuesta para el numero de Telefono 7");
            $isValid = false;
            return
        }
        if ($("#observacionTelf7").val() == "") {
            alert("Debe seleccionar la Observación para el numero de Telefono 7");
            $isValid = false;
            return
        }
    }
    if ($("#number8").is(":visible")) {
        if ($("#estadoTel8").val() == "") {
            alert("Debe seleccionar un estado para el numero de Telefono 8");
            $isValid = false;
            return
        }
        if ($("#respuestaTel8").val() == "") {
            alert("Debe seleccionar la respuesta para el numero de Telefono 8");
            $isValid = false;
            return
        }
        if ($("#observacionTelf8").val() == "") {
            alert("Debe seleccionar la Observación para el numero de Telefono 8");
            $isValid = false;
            return
        }
    }
    if ($("#number9").is(":visible")) {
        if ($("#estadoTel9").val() == "") {
            alert("Debe seleccionar un estado para el numero de Telefono 9");
            $isValid = false;
            return
        }
        if ($("#respuestaTel9").val() == "") {
            alert("Debe seleccionar la respuesta para el numero de Telefono 9");
            $isValid = false;
            return
        }
        if ($("#observacionTelf9").val() == "") {
            alert("Debe seleccionar la Observación para el numero de Telefono 9");
            $isValid = false;
            return
        }
    }
    if ($("#number10").is(":visible")) {
        if ($("#estadoTel10").val() == "") {
            alert("Debe seleccionar un estado para el numero de Telefono 10");
            $isValid = false;
            return
        }
        if ($("#respuestaTel10").val() == "") {
            alert("Debe seleccionar la respuesta para el numero de Telefono 10");
            $isValid = false;
            return
        }
        if ($("#observacionTelf10").val() == "") {
            alert("Debe seleccionar la Observación para el numero de Telefono 10");
            $isValid = false;
            return
        }
    }
    if ($("#number11").is(":visible")) {
        if ($("#estadoTel11").val() == "") {
            alert("Debe seleccionar un estado para el numero de Telefono 11");
            $isValid = false;
            return
        }
        if ($("#respuestaTel11").val() == "") {
            alert("Debe seleccionar la respuesta para el numero de Telefono 11");
            $isValid = false;
            return
        }
        if ($("#observacionTelf11").val() == "") {
            alert("Debe seleccionar la Observación para el numero de Telefono 11");
            $isValid = false;
            return
        }
    }
    if ($("#number12").is(":visible")) {
        if ($("#estadoTel12").val() == "") {
            alert("Debe seleccionar un estado para el numero de Telefono 12");
            $isValid = false;
            return
        }
        if ($("#respuestaTel12").val() == "") {
            alert("Debe seleccionar la respuesta para el numero de Telefono 12");
            $isValid = false;
            return
        }
        if ($("#observacionTelf12").val() == "") {
            alert("Debe seleccionar la Observación para el numero de Telefono 12");
            $isValid = false;
            return
        }
    }
    if ($("#number13").is(":visible")) {
        if ($("#estadoTel13").val() == "") {
            alert("Debe seleccionar un estado para el numero de Telefono 13");
            $isValid = false;
            return
        }
        if ($("#respuestaTel13").val() == "") {
            alert("Debe seleccionar la respuesta para el numero de Telefono 13");
            $isValid = false;
            return
        }
        if ($("#observacionTelf3").val() == "") {
            alert("Debe seleccionar la Observación para el numero de Telefono 13");
            $isValid = false;
            return
        }
    }
    if ($("#number14").is(":visible")) {
        if ($("#estadoTel14").val() == "") {
            alert("Debe seleccionar un estado para el numero de Telefono 14");
            $isValid = false;
            return
        }
        if ($("#respuestaTel14").val() == "") {
            alert("Debe seleccionar la respuesta para el numero de Telefono 14");
            $isValid = false;
            return
        }
        if ($("#observacionTelf14").val() == "") {
            alert("Debe seleccionar la Observación para el numero de Telefono 14");
            $isValid = false;
            return
        }
    }
    if ($("#number15").is(":visible")) {
        if ($("#estadoTel15").val() == "") {
            alert("Debe seleccionar un estado para el numero de Telefono 15");
            $isValid = false;
            return
        }
        if ($("#respuestaTel15").val() == "") {
            alert("Debe seleccionar la respuesta para el numero de Telefono 15");
            $isValid = false;
            return
        }
        if ($("#observacionTelf15").val() == "") {
            alert("Debe seleccionar la Observación para el numero de Telefono 15");
            $isValid = false;
            return
        }
    }

    if ($("#status").val() == "") {
        alert("Debe escoger un estado");
        $isValid = false;
        return
    } else {
        if ($("#substatus").val() == "") {
            alert("Debe escoger un subestado");
            $isValid = false
            return
        } else {
            if ($("#recall").is(":visible")) {
                if ($("#agendamiento").val() == "") {
                    alert("Campo agendamiento vacio")
                    $isValid = false;
                    return
                }
                if ($("#recall").val() == "") {
                    alert("Debe ingresar una fecha para la rellamada")
                    $isValid = false;
                    return
                } else {
                    if (calcularDias($("#recall").val()) > 3) {
                        alert("La fecha de rellamada no puede sobrepasar los tres días")
                        $isValid = false;
                        return
                    }
                }
            }
            if ($("#subSubStatus").is(":visible")) {
                if ($("#subSubStatus").val() == "") {
                    alert("Debe escoger un sub subestado")
                    $isValid = false;
                    return
                }
            }
            if ($divMotivo.is(":visible")) {
                if ($("#motivoNoAceptaSeguro").val() == "") {
                    alert("Debe escoger el motivo no desea seguro")
                    $isValid = false;
                    return
                }
            }
            if ($telefonoContactadoDiv.is(":visible")) {
                if ($telefonoContactado.val() === "") {
                    alert("Ingrese el teléfono al cual pudo contactar al cliente");
                    $isValid = false;
                    return
                } else {
                    if ($telefonoContactado.val().substring(0, 1) != 0) {
                        alert("El teléfono contactado es incorrecto");
                        $isValid = false;
                        return
                    } else {
                        if (!validarSiNumero($telefonoContactado.val())) {
                            alert("El teléfono contactado no es un número válido");
                            $isValid = false;
                            return
                        }else{
                            if ($telefonoContactado.val().length ==  9 && $telefonoContactado.val().trim().substring(0, 2) == "09" ) {
                                alert("Esta ingresando un telefono convencional incorrecto. Verifique!");
                                $isValid = false;
                                return
                            }else {
                                if ($telefonoContactado.val().length ==  10 && $telefonoContactado.val().trim().substring(0, 2) != "09" ) {
                                    alert("Esta ingresando un telefono celular incorrecto. Verifique!");
                                    $isValid = false;
                                    return
                                }
                            }
                        }
                    }
                }
                if ($("#estadoTelefonoContactado").val() === "") {
                    alert("Ingrese el estado del teléfono contactado");
                    $isValid = false;
                    return
                }
            }

            if ($("#retroalimentacion").val() === "") {
                alert("Campo retroalimentación vacio");
                $isValid = false;
                return
            }
        }
    }

    if ($("#managementData").is(":visible")) {
        if ($("#provinciaGestion").val() == "") {
            alert("Debe ingresar la provincia");
            $isValid = false;
            return;
        }
        if ($("#ciudadGestion").val() == "") {
            alert("Debe ingresar la ciudad");
            $isValid = false;
            return;
        }
        if ($("#cantonGestion").val() == "") {
            alert("Debe ingresar el canton");
            $isValid = false;
            return;
        }
        if ($("#parroquiaGestion").val() == "") {
            alert("Debe ingresar la parroquia");
            $isValid = false;
            return;
        }
        if ($("#callePrincipalGestion").val() == "") {
            alert("Debe ingresar la calle principal");
            $isValid = false;
            return;
        }
        if ($("#numeroCasaGestion").val() == "") {
            alert("Debe ingresar el número de casa");
            $isValid = false;
            return;
        }
        if ($("#calleSecundariaGestion").val() == "") {
            alert("Debe ingresar la calle secundaria");
            $isValid = false;
            return;
        }
        if ($("#fecha_promesa").val() == "") {
            alert("Campo Fecha Promesa Vacio");
            $isValid = false;
            return;
        }/*else{
            if(validateFechaMayorQue($("#fecha_promesa").val())){
                alert("Las fecha de promesa de pago no puede ser menor a la fecha actual.")
                $isValid = false;
                return
            }

        }*/
        if ($("#valor_promesa").val() == "") {
            alert("Campo Valor promesa vacio.");
            $isValid = false;
            return;
        }/*else{
            if (!validarSiNumero($("#valor_promesa").val())) {
                alert("No se puede ingresar letras en el campo valor promesa.");
                $isValid = false;
                return
            }
        }*/
        /*if ($("#telefonoCelularGestion").val() == "") {
            alert("Campo teléfono de contacto vacío");
            $isValid = false;
            return
        }else{
            if ($("#telefonoCelularGestion").val().substring(0, 1) != 0) {
                alert("El teléfono de contacto es incorrecto");
                $isValid = false;
                return
            } else {
                if (!validarSiNumero($("#telefonoCelularGestion").val())) {
                    alert("El teléfono de contacto no es un número válido");
                    $isValid = false;
                    return
                }else{
                    if ($("#telefonoCelularGestion").val().length ==  10 && $("#telefonoCelularGestion").val().trim().substring(0, 2) != "09" ) {
                        alert("Esta ingresando un telefono celular incorrecto. Verifique!");
                        $isValid = false;
                        return
                    }
                }
            }
        }*/


    }

    if ($("#condonacionData").is(":visible")) {
        if ($("#valorCondonacion").val() == "") {
            alert("Campo Condonación vacío.");
            $isValid = false;
            return;
        }
        if ($("#provinciaAgencia").val() == "") {
            alert("Campo provincia agencia vacío.");
            $isValid = false;
            return;
        }
        if ($("#ciudadAgencia").val() == "") {
            alert("Campo ciudad agencia vacío.");
            $isValid = false;
            return;
        }
        if ($("#nombreCondonacionAgencia").val() == "") {
            alert("Campo nombre agencia vacío.");
            $isValid = false;
            return;
        }
        if ($("#fechaVisitaAgenciaCondonacion").val() == "") {
            alert("Campo fecha visita agencia vacío.");
            $isValid = false;
            return;
        }
    }

    return $isValid;
}


//Para cuando se INICIA LA GESTION
function init() {
    esconderCamposEstados();
   // $("#telefonoContactadoDiv").hide();
    $("#status").val($("#status option:first").val());
    $("#telefonoContactado").val("");
    $("#estadoTelefonoContactado").val($("#status option:first").val());
    $("#sexo").val($("#sexo option:first").val());
    $("#estadoCivil").val($("#estadoCivil option:first").val());
    $("#parentesco").val($("#parentesco option:first").val());
    $("#provinciaDomicilioGestion").val($("#estadoCivil option:first").val());
    $("#provinciaTrabajoGestion").val($("#estadoCivil option:first").val());
    $("#radioPrimerNombre").prop('checked', true);
    $("#radioSegundoNombre").prop('disabled', true);
    $("#tipoCliente").val($("#tipoCliente option:first").val());
    $("#btnAdicional").attr("disabled", true);
}

//This function empties a select component
function emptySelect(idSelect) {

    var select = document.getElementById(idSelect);
    var option = document.createElement('option');
    var NumberItems = select.length;

    while (NumberItems > 0) {
        NumberItems--;
        select.remove(NumberItems);
    }

    option.text = '-- Seleccione --';
    option.value = ''
    select.add(option, null);
}

//This function fills a select component
function fillSelect(idSelect, data) {

    var select = document.getElementById(idSelect);
    var numberSubstatus = data[0].length;

    emptySelect(idSelect)

    if (numberSubstatus > 0) {
        for (i = 0; i < numberSubstatus; i++) {
            var option = document.createElement('option');
            option.text = data[1][i];
            option.value = data[0][i];
            select.add(option, null);
        }
    }

    return numberSubstatus;
}


$('#fecha_promesa').on('keypress', function(e) {
    if(checkIfNumberNoSpace(e.which, e)==0){
        return false;
    }else{
        return;
    }
});
$('#fecha_promesa').on('keydown', function (e)
{
    try {
        if ((e.keyCode == 8 || e.keyCode == 46))
            return false;
        else
            return true;
    }
    catch (Exception)
    {
        return false;
    }
});

$('#valor_promesa').on('keypress', function(e) {
    if(checkIfNumberNoSpace(e.which, e)==0){
        return false;
    }else{
        return;
    }
});

$("#valor_promesa").on('paste', function(e){
    e.preventDefault();
    alert('Esta acción está prohibida');
})

/**
 *@description Funcion que evita que puedan ingresar numeros en campos
 * @author Andres Redroban
 * */

function checkIfNumberNoSpace(codeKey,e){
    if (codeKey == 32)
        return 0;
    // Asignando numero y no espacios
    if ($.inArray(codeKey, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
        // Allow: Ctrl+A
        (codeKey == 97 && e.ctrlKey === true) ||
        // Allow: Ctrl+C
        (codeKey == 99 && e.ctrlKey === true) ||
        // Allow: Ctrl+X
        (codeKey == 120 && e.ctrlKey === true) ||
        // Allow: home, end, left, right, tab
        (codeKey == 0)) {
        // let it happen, don't do anything
        return 1;
    }
    if ((codeKey < 48 || codeKey > 57)) {
        return 0;
    }
}
function soloLetras(e){
    key = e.keyCode || e.which;
    tecla = String.fromCharCode(key).toLowerCase();
    letras = " áéíóúabcdefghijklmnñopqrstuvwxyz";
    especiales = "8-37-39-46";

    tecla_especial = false
    for(var i in especiales){
        if(key == especiales[i]){
            tecla_especial = true;
            break;
        }
    }

    if(letras.indexOf(tecla)==-1 && !tecla_especial){
        return false;
    }
}



/**
 * Valida si el valor ingresado es numérico
 * @param numero
 */
function validarSiNumero(numero){
    $esNumero = true;
    if (!/^([0-9])*$/.test(numero)){
        $esNumero = false;
    }
    return $esNumero;
}
/**
 * Valida si el correo ingresado es correcto
 * @param email
 * @author Andres Redroban
 */
function validarEmail(email)
{
    var regex = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    return regex.test(email) ? true : false;
}

function validarSiSoloLetras(entrada){
    $esSoloTexto = true;
    $filtro = /^([A-Za-z ])*$/;
    if(!$filtro.test(entrada)){
        $esSoloTexto = false;
    }
    return $esSoloTexto;
}

/**
 * Valida si el numero ingresado contiene espacios en blanco
 * @param validar
 * @author Andres Redroban
 */
function validarVacio(validar) {
    $esVacio = true;
    for ( i = 0; i < validar.length; i++ ) {
        if ( validar.charAt(i) == " " ) {
            $esVacio = false
        }
    }
    return $esVacio
}

/**
 * Función bajada de internet https://es.stackoverflow.com/questions/31373/obtener-la-edad-a-partir-de-la-fecha-de-nacimiento-con-javascript-y-php
 * @param fecha
 * @returns {number}
 */
function calcularEdad(fecha) {
    var hoy = new Date();
    var cumpleanos = new Date(fecha);
    var edad = hoy.getFullYear() - cumpleanos.getFullYear();
    var m = hoy.getMonth() - cumpleanos.getMonth();

    if (m < 0 || (m === 0 && hoy.getDate() < cumpleanos.getDate())) {
        edad--;
    }

    return edad;
}
/**
 * Función tomada como ejemplo de internet https://www.lawebdelprogramador.com/foros/JavaScript/1594805-Calcular-la-cantidad-de-dias-entre-dos-fechas-Javascript-y-HTML.html
 * @param fecha
 * @returns {contdias}
 * @author Andres Redrobán
 * @description La siguiente función calcula el numero de dias tomando como referencia el facha actual y la fecha ingresada desde el sistema.
 */
function calcularDias(fecha){
    var fechaini = new Date();
    var fechafin = new Date(fecha);
    var diasdif= fechafin.getTime()-fechaini.getTime();
    var contdias = Math.round(diasdif/(1000*60*60*24));
    return contdias;
}

/**
 * Funcion para validar una fecha en formato YYYY-MM-DD
 * @param fecha
 * @return {boolean}
 * @author Andres Redrobán
 */

function validarFecha(fecha){
    $esVaido = true;
    var myDate = fecha;
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1;
    var yyyy = today.getFullYear();
    if(dd < 10)
        dd = '0' + dd;

    if(mm < 10)
        mm = '0' + mm;

    today = yyyy + '/' + mm + '7' + dd;
    myDate.attr("max", today);
    if(Date.parse(myDate)){
        if(myDate > today){
            /*alert('La fecha no puede ser mayor a la actual');
            myDate.val("");*/
            $esVaido = false;
        }
    }
    return $esVaido;
}
function validateFechaMayorQue(fechaFinal) {
    $esVaido = true;
    valuesEnd = fechaFinal.split("/");
    // Verificamos que la fecha no sea posterior a la actual
    var dateStart=new Date();
    var dateEnd=new Date(valuesEnd[0],(valuesEnd[1]-1),valuesEnd[2]);
    if(dateStart <= dateEnd) {
        $esVaido = false;
    }
    return $esVaido;
}

//Para limpiar luego de agregar un adicional
function cleanAdicionalData() {
    $("#cedula").val("");
    $("#primerNombre").val("");
    $("#segundoNombre").val("");
    $("#primerApellido").val("");
    $("#segundoApellido").val("");
    $("#radioPrimerNombre").prop('checked', true);
    $("#radioSegundoNombre").prop('disabled', true);
    $("#cupoOtorgado").val("");
    $("#sexo").val($("#sexo option:first").val());
    $("#parentesco").val($("#parentesco option:first").val());
    $("#fechaNacimiento").val("");
    $("#observaciones").val("");
    $("#estadoCivilAdicional").val($("#estadoCivilAdicional option:first").val());
    $("#nacionalidadAdicional").val("");
}

function load_data(query){
    $.post(baseUrl + "/FuncionesAjax/searchUser", {
        query:query
    }).done(function (data) {

        //$('#result').html(data);
        if(data == 'null'){

        }else{
            alert('ya tienes este usuario en la base de datos con la misma cedula');
        }
    });
}

function esconderCamposEstados(){
    $("#motivoNoDesea").val($("#motivoNoDesea option:first").val());
    $("#cobroProteccionFraudes").val($("#cobroProteccionFraudes option:first").val());
    $("#recallDiv").hide();
    $("#subStatusDiv").hide();
   // $("#subSubStatusDiv").hide();
    $("#managementData").hide();
    $("#divEstadoNivel4").hide();
    $("#condonacionData").hide();
    $("#divScriptFallecidoMuerteNatural").hide();
    $("#divScriptFallecidoAccidente").hide();
    $("#divScriptIncapacidadTotalPermanente").hide();
    $("#divScriptIncapacidadLaboralTemporal").hide();
    //$("#send").hide();
    $("#fechaEstimadaCU5").val("");
    $("#telefonoCelularGestionCU5").val("");
    $("#telefonoCelularGestion").val("");
    $("#formasPago").val($("#formasPago option:first").val());
    $divMotivo.hide();


}

function limpiarTipoCliente(){
    $("#nombreNegocio").val("");
    $("#fechaInicioNegocio").val("");
    $("#actividadEconomica").val("");
    $("#ventasHonorariosMensuales").val("");
    $("#costoVentas").val("");
    $("#gastosOperativos").val("");
    $("#situacionLaboral").val($("#situacionLaboral option:first").val());
    $("#nombreEmpresaGestion").val("");
    $("#contrato").val($("#contrato option:first").val());
    $("#cargo").val("");
    $("#fechaInicioTrabajoActual").val("");
    $("#sueldo").val("");
    $("#gastosFamilia").val("");
}