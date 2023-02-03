<%@page import="dto.Usuario"%>
<%@page import="dao.UsuarioDAO"%>
<%
    String codigo = request.getParameter("codigo");
    String login = request.getParameter("login");
    String password = request.getParameter("password");
    Usuario usuario=new Usuario(codigo,login,password);
    int i=UsuarioDAO.agregar(usuario);
    if(i>0){
        out.print("ok");
    }
    else{
        out.print("error");
    }
%>