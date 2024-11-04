function adicionaCpf(){
    let cpf = document.getElementById("cpf").value;
    alert("CPF: " + cpf);
    th:href="@{/buscarCpf(cpf)}";
}