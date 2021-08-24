$(document).ready(function(){
    $('.datepicker').datepicker({
        format: "dd/mm/yyyy",
        clearBtn: "false",
        language: "es",
        autoclose: true,
        orientation: "top",
        defaultViewDate: {
            month: '04',
            day:'01',
            year: '2020'
        },
    });

    $('.datepickerdown').datepicker({
        format: "yyyy/mm/dd",
        todayBtn: "linked",
        language: "es",
        autoclose: true,
        orientation: "bottom",
        defaultViewDate: {
            month: '04',
            day:'01',
            year: '2020'
        },
    });
   // $('.datepickertest').setDefaults($.datepicker.regional["es"]);

    $('.datepickertest').datepicker({
        format: "yyyy-mm-dd",
        todayBtn: "linked",
        clearBtn: "false",
        language: "es",
        autoclose: true,
        orientation: "bottom",
        defaultViewDate: {
            month: '04',
            day:'01',
            year: '2020'
        },
        todayHighlight: false,
        daysOfWeekDisabled: [0],
        startDate: "0dd",
        endDate: "+"+validarRangoDias()+"d"
    });
});
function validarRangoDias() {
    var date = new Date();
    var ultimoDia = new Date(date.getFullYear(), date.getMonth() + 1, 0);
    var diaFinal = ultimoDia.getDate();
    var diaActual = date.getDate();
    var resultado = diaFinal - diaActual;
    return resultado;
}