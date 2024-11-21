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