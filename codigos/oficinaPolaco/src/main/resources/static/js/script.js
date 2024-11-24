$("#cadastroCliente").validate({
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
            required: true
        },
        numero:{
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
            required: "Informe o estado"
        },
        numero:{
            required: "Digite um número"
        }
    }
});

$(document).ready(function () {
            $('#telefone').mask('(00) 00000-0000');
            $('#cep').mask('00000-000');
            $('#cpf').mask('000.000.000-00');
            $('#cnpj').mask('00.000.000/0000-00');
            $('#data').mask('00/00/0000');
        });
