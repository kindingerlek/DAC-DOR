
//triggers
$('.email').on('blur', testEmail);
$('#identifier').on('blur', testDebtorType);
$('input:radio[name=identifierType]').change(testDebtorType);
$('#confirmPassword').on('blur', testPassword);
$('#password').on('blur', testPassword);
$('#generateToken').on('click',function(){
        $('#token').val(generateToken());
    });

//functions
function putError(error) {
    $('.submit-button').attr('disabled', 'disabled');
    $('.error').html('<div class="alert alert-danger" role="alert"><span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span><span class="sr-only">Error:</span>  '+error+'</div>');
    return null;
}

function clearError() {
    $('.submit-button').removeAttr('disabled');
    $('.error').html('');
}

function testEmail() {
    var email = $('.email').val();
    if (!/@/i.test(email)) {
        return putError("Email inválido.");
    } else {
        clearError();
    }
}

function testDebtorType(){
    var type;
    $('input:radio[name=identifierType]').each(function () {
        if ($(this).is(':checked'))
            type = $(this).val();
    });
    if (type === 'cpf') {
        return testCpf();
    } else {
        return testCnpj();
    }
}

function testCnpj() {
    var cnpj = $('#identifier').val().replace(/[.-]/g, '');
    if (!isNumeric(cnpj)) {
        return putError("CNPJ com caracteres inválidos.");
    } else if (!validateCnpj(cnpj)) {
        return putError("CNPJ inválido");
    } else {
        clearError();
    }
}

function testCpf() {
    var cpf = $('#identifier').val().replace(/[.-]/g, '');
    if (!isNumeric(cpf)) {
        return putError("CPF com caracteres inválidos.");
    } else if (!validateCpf(cpf)) {
        return putError("CPF inválido");
    } else {
        clearError();
    }
}

function testPassword() {
    var password = $('#password').val();
    var confirmPassword = $('#confirmPassword').val();
    if (password !== confirmPassword) {
        return putError("As senhas não coincidem.");
    } else if (password === '' || confirmPassword === '') {
        return putError("O campo senha está vazio.");
    } else if (!isAlphanumeric(password)) {
        return putError("A senha tem caracteres inválidos.");
    } else {
        clearError();
    }
}

function isAlphanumeric(str) {
    return /^[0-9a-zA-Z]+$/.test(str);
}

function isNumeric(str) {
    return /^[0-9]+/.test(str);
}

function validateCnpj(cnpj) {

    cnpj = cnpj.replace(/[^\d]+/g, '');

    if (cnpj === '')
        return false;

    if (cnpj.length !== 14)
        return false;

    // Elimina CNPJs invalidos conhecidos
    if (cnpj === "00000000000000" ||
            cnpj === "11111111111111" ||
            cnpj === "22222222222222" ||
            cnpj === "33333333333333" ||
            cnpj === "44444444444444" ||
            cnpj === "55555555555555" ||
            cnpj === "66666666666666" ||
            cnpj === "77777777777777" ||
            cnpj === "88888888888888" ||
            cnpj === "99999999999999")
        return false;

    // Valida DVs
    length = cnpj.length - 2;
    numbers = cnpj.substring(0, length);
    digits = cnpj.substring(length);
    add = 0;
    pos = length - 7;
    for (i = length; i >= 1; i--) {
        add += numbers.charAt(length - i) * pos--;
        if (pos < 2)
            pos = 9;
    }
    result = add % 11 < 2 ? 0 : 11 - add % 11;
    if (result !== digits.charAt(0))
        return false;

    length = length + 1;
    numbers = cnpj.substring(0, length);
    add = 0;
    pos = length - 7;
    for (i = length; i >= 1; i--) {
        add += numbers.charAt(length - i) * pos--;
        if (pos < 2)
            pos = 9;
    }
    result = add % 11 < 2 ? 0 : 11 - add % 11;
    if (result !== digits.charAt(1))
        return false;

    return true;

}

function validateCpf(cpf) {
    var add;
    var mod;
    add = 0;
    if (cpf === "00000000000")
        return false;

    for (i = 1; i <= 9; i++)
        add = add + parseInt(cpf.substring(i - 1, i)) * (11 - i);
    mod = (add * 10) % 11;

    if ((mod === 10) || (mod === 11))
        mod = 0;
    if (mod !== parseInt(cpf.substring(9, 10)))
        return false;

    add = 0;
    for (i = 1; i <= 10; i++)
        add = add + parseInt(cpf.substring(i - 1, i)) * (12 - i);
    mod = (add * 10) % 11;

    if ((mod === 10) || (mod === 11))
        mod = 0;
    if (mod !== parseInt(cpf.substring(10, 11)))
        return false;
    return true;
}

function generateToken(){
    
    var text = "";
    var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    for( var i=0; i < 10; i++ )
        text += possible.charAt(Math.floor(Math.random() * possible.length));

    return text;
    
}