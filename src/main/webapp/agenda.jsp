<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="model.AgendaBean" %>
<%@ page import="java.util.ArrayList" %>
<%
	ArrayList<AgendaBean> contatos = (ArrayList<AgendaBean>) request.getAttribute("contatos");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Agenda de Contatos</title>
<link rel="icon" href="img/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Agenda de Contatos</h1>
	<a href="novo.html" class="Botao1">Novo contato</a>
	
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Fone</th>
				<th>Email</th>
			</tr>
		</thead>
		<tbody>
			<% for (int i = 0; i < contatos.size(); i++) {%>
			<tr>
				<td><%= contatos.get(i).getIdcon() %></td>
				<td><%= contatos.get(i).getNome() %></td>
				<td><%= contatos.get(i).getFone() %></td>
				<td><%= contatos.get(i).getEmail() %></td>
				
			</tr>
			<%} %>
		</tbody>
	</table>
</body>
</html>