function validaNome(){
    let nome = document.getElementById("nome").value;
    if(nome.length < 3){
        alert("Informe um nome válido");
        return false;
    }else{
        return true;
    }
}

function validaCpf(){
    let cpf = document.getElementById("cpf").value;
    if(cpf.length < 11){
        alert("Informe CPF válido");
        return false;
    }else{
        return true;
    }
}

function validaTelefone(){
    let telefone = document.getElementById("telefone").value;
    if(telefone.length < 1){
        alert("Informe um Telefone");
        return false;
    }else{
        return true;
    }
}

function validaRua(){
    let rua = document.getElementById("rua").value;
    if(rua.length < 1){
        alert("Informe a rua");
        return false;
    }else{
        return true;
    }
}

function validaCep(){
    let cep = document.getElementById("cep").value;
    if(cep.length < 8){
        alert("Informe um CEP");
        return false;
    }else{
        return true;
    }
}

function validaCidade(){
    let cidade = document.getElementById("cidade").value;
    if(cidade.length < 3){
        alert("Informe uma cidade valida");
        return false;
    }else{
        return true;
    }
}

function validaNumero(){
    let numero = document.getElementById("numero").value;
    if(numero == 0){
        alert("Informe o numero do endereço");
        return false;
    }else{
        return true;
    }
}

function validaBairro(){
    let bairro = document.getElementById("bairro").value;
    if(bairro < 3){
        alert("Informe um bairro");
        return false;
    }else{
        return true;
    }
}

function validaEstado(){
    let estado = document.getElementById("estado").value;
    if(estado < 2){
        alert("Informe um estado");
        return false;
    }else{
        return true;
    }
}