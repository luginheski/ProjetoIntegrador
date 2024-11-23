function calculaPeca(element){
    let valorUnt = document.getElementById("valorUnt").value;
    let qnt = document.getElementById("qnt").value;
    let porcento = document.getElementById("porcento").value;
    let valorTotal = 0;
    
    let valorUntF = parseFloat(valorUnt);
    let qntF = parseFloat(qnt);
    let porcentoF = parseFloat(porcento);
    
    valorTotal = (((valorUntF*porcentoF)/100)+valorUntF)*qntF;
    let imprimir = valorTotal.toFixed(2).replace(".",",");
    
    element.innerHTML = imprimir;
    element.className = 'descricao inbox';
    
    alert("valor total: "+ imprimir);
}

var input = document.getElementById('nome');
    input.oninvalid = function(event) {
    event.target.setCustomValidity('O nome de usuário deve conter apenas letras no máximo com 50 caracteres. ex: Rodrigo');
};

var input = document.getElementById('cpf');
    input.oninvalid = function(event) {
    event.target.setCustomValidity('O CPF deve conter apenas numeros no máximo com 11 caracteres. ex: 000.111.222-33');
};

var input = document.getElementById('rg');
    input.oninvalid = function(event) {
    event.target.setCustomValidity('O RG deve conter apenas números ');
};

var input = document.getElementById('telefone');
    input.oninvalid = function(event) {
    event.target.setCustomValidity('O telefone deve conter apenas numeros no máximo com 11 caracteres. ex: (41)99999-8888');
};
