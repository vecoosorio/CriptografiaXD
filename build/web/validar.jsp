<%@page import="dto.Usuario"%>
<%@page import="dao.UsuarioDAO"%>
<%
    String login = request.getParameter("login");
    String password = request.getParameter("password");
    Usuario usuario=new Usuario("",login,password);
    boolean result=UsuarioDAO.validar(usuario);
    if(result){
        out.print("ok");
    }
    else{
        out.print("error");
    }
%>


