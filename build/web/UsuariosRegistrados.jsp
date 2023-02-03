<%@page import="dao.UsuarioDAO"%>
<%
    
    UsuarioDAO objUsuarioDAO = new UsuarioDAO();

            out.println(objUsuarioDAO.listarJSon());
           
%>
