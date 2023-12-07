<%-- 
    Document   : consultarId
    Created on : 6 de dez. de 2023, 18:35:06
    Author     : stock
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Cliente"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    </head>
    <body>
                 <table class="table">
            <thead class="thead-dark">
                <tr>
                <th scope="col">Nome</th>
                <th scope="col">Idade</th>
                <th scope="col">Email</th>
                <th scope="col">Senha</th>
                <th scope="col">Telefone</th>
                <th scope="col">Endereco</th>
                <th scope="col">Cidade</th>
                <th scope="col">Estado</th>
                <th scope="col">Cep</th>
                <th scope="col">Data de Nascimento</th>

            </tr>
            <tr>

                <td><%Cliente cliente = (Cliente) request.getAttribute("cliente");
                        out.println(cliente.getNome()); %></td>
                <td><% out.println(cliente.getIdade());%></td>
                <td><%out.println(cliente.getEmail());%></td>
                <td><%  out.println(cliente.getSenha());%></td>
                <td><%  out.println(cliente.getTelefone());%></td>
                <td><% out.println(cliente.getEndereco());%></td>
                <td><%    out.println(cliente.getCidade());%></td>
                <td><%out.println(cliente.getEstado());%></td>
                <td><% out.println(cliente.getCep());%></td>
                <td><% out.println(cliente.getDataNascimento());%></td>


            </tr>
    </body>
</html>
