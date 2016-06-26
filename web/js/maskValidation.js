$('input:radio[name=identifierType]').change(testDebtorType);

function testDebtorType(){
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
$('#identifier').mask('999.999.999-99');
