<%-- 
    Document   : consultarTodos
    Created on : 6 de dez. de 2023, 18:35:17
    Author     : stock
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                    <th scope="col">Id</th>
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
                <c:forEach var="cliente" items="${clientesConsultados}">
                    <tr>
                        <td scope="row">${cliente.getId()}</td>
                        <td>${cliente.getNome()}</td>
                        <td>${cliente.getIdade()}</td>
                        <td>${cliente.getEmail()}</td>
                        <td>${cliente.getSenha()}</td>
                        <td>${cliente.getTelefone()}</td>
                        <td>${cliente.getEndereco()}</td>
                        <td>${cliente.getCidade()}</td>
                        <td>${cliente.getEstado()}</td>
                        <td>${cliente.getCep()}</td>
                        <td>${cliente.getDataNascimento()}</td>

                    </tr>
                </c:forEach>  
        </table>
    </body>
</html>
