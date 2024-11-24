$("#cadastro").validate({
    rules: {
        nome: {
            required: true
        },
        cpf: {
            required: true,
            maxlength: 14
        },
        rg: {
            required: true
        },
        telefone: {
            required: true
        },
        rua: {
            required: true
        },
        cep: {
            required: true
        },
        cidade:{
            required: true
        },
        estado:{
            required: true,
            maxlength: 2
        },
        numero:{
            required: true
        },
        bairro:{
            required: true
        },
        fabricante:{
           required: true
       },
       anoFab:{
           required: true
       },
       placa:{
           required: true
       },
       modelo:{
           required: true
       },
       anoModelo:{
           required: true
       },
       hodometro:{
           required: true
       },
       kmAtual:{
           required: true
       },
       desc:{
           required: true
       },
       valorUnt:{
           required: true
       },
       qnt:{
           required: true
       },
       porcento:{
           required: true
       }
    },
    messages: {
        nome: {
            required: "Campo nome é obrigatório"
        },
        cpf: {
            required: "Campo cpf é obrigatório",
            maxlength: "Deve ter no maximo 14 caracteres" 
        },
        rg: {
            required: "Rg é obrigatório"
        },
        telefone: {
            required: "Informe um telefone"
        },
        rua: {
            required: "Rua obrigatório"
        },
        cep: {
            required: "Informe o CEP"
        },
        cidade:{
            required: "Campo Obrigatório"
        },
        estado:{
            required: "Informe o estado",
            maxlength: "Insira apenas a sigla Ex.'XX'"
        },
        numero:{
            required: "Digite um número"
        },
        bairro:{
            required: "Informe o bairro"
        },
        fabricante:{
           required: "Campo fabricante obrigatório"
       },
       anoFab:{
           required: "Campo ano fabricação obrigatório"
       },
       placa:{
           required: "Campo placa obrigatótio"
       },
       modelo:{
           required: "Campo modelo obrigatório"
       },
       anoModelo:{
           required: "Campo ano modelo obrigatório"
       },
       hodometro:{
           required: "Campo Km obrigatório"
       },
       kmAtual:{
           required: "Informe o Km atual"
       },
       desc:{
           required: "Informe a peça"
       },
       valorUnt:{
           required: "Insira o valor da peça"
       },
       qnt:{
           required: "Informe a quantidade"
       },
       porcento:{
           required: "Informe o valor da porcentagem da peça"
       }
    }
});

$(document).ready(function () {
            $('#telefone').mask('(00) 00000-0000');
            $('#cep').mask('00000-000');
            $('#cpf').mask('000.000.000-00');
            $('#data').mask('00/00/0000');
});
