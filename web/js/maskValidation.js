$('input:radio[name=identifierType]').change(testDebtorType);
$('input:radio[name=identifierType]').ready(testDebtorType);
function testDebtorType() {
    var type;
    $('input:radio[name=identifierType]').each(function () {
        if ($(this).is(':checked'))
            type = $(this).val();
    });
    if (type === 'cpf') {
        $('#identifier').mask('999.999.999-99');
    } else {
        $('#identifier').mask("99.999.999/9999-99");
    }
}
if (!$('#identifier').length===0) {
    $('#identifier').mask('999.999.999-99');
}
$(document).ready(function () {
    $('.identifier-to-show').each(function (index, element) {
        var identifier = $(element);
        if (identifier.html().length === 11) {
            identifier.mask("999.999.999-99");
        } else if (identifier.html().length === 14) {
            identifier.mask("99.999.999/9999-99");
        }
    })
})