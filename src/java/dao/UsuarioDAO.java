/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.Usuario;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import util.Cambiar;


public class UsuarioDAO {

    public static int agregar(Usuario usuario) {
        Connection cn = null;
        try {
            String sql = "insert into usuario values(?,?,?)";
            cn = MySQL.getInstance().getConnection();
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, usuario.getCodiUsua());
            pstm.setString(2, usuario.getLogiUsua());
            pstm.setString(3, Cambiar.cifrar(usuario.getPassUsua()));
            int i = pstm.executeUpdate();
            cn.close();
            return i;
        } catch (Exception e) {
            return 0;
        }
    }

    public static boolean validar(Usuario usuario) {
        Connection cn = null;
        try {
            String sql = "select*from usuario where logiUsua=? and passUsua=?";
            cn = MySQL.getInstance().getConnection();
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, usuario.getLogiUsua());
            pstm.setString(2, Cambiar.descifrar(usuario.getPassUsua()));
            ResultSet rs = pstm.executeQuery();
            rs.next();
            String valor = rs.getString(1);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Usuario> listar() {
        try {
            String sql = "select * from usuario";
            Connection cn = MySQL.getInstance().getConnection();
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rst = pstm.executeQuery();

            List<Usuario> lista = new ArrayList<>();
            while (rst.next()) {
                Usuario usu = new Usuario(rst.getString(1), rst.getString(2),Cambiar.descifrar(rst.getString(3)));
                lista.add(usu);
            }

            return lista;
        } catch (Exception ex) {
            return null;
        }
    }

    public String listarJSon() {
        List<Usuario> lista = listar();
        Gson gson = new GsonBuilder().create();

        String contenido = "";
        for (int i = 0; i < lista.size(); i++) {
            contenido += gson.toJson(lista.get(i)) + ",";
        }
        contenido = contenido.substring(0, contenido.length() - 1);
        String resultado = "{\"data\":[" + contenido + "]}";
        return resultado;
    }

    public Usuario buscar(String codigo) {
        try {
            String sql = "select * from usuario where codiUsua='" + codigo + "'";
            Connection cn = MySQL.getInstance().getConnection();
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rst = pstm.executeQuery();

            rst.next();
            Usuario usu = new Usuario(rst.getString(1), rst.getString(2), rst.getString(3));
            return usu;
        } catch (Exception ex) {
            return null;
        }
    }
    
    public String buscarJSon(String codigo) {
        Usuario usu = buscar(codigo);
        Gson gson = new GsonBuilder().create();
        String contenido = "";
        contenido += gson.toJson(usu);
        String resultado = "{\"data\":[" + contenido + "]}";
        return resultado;
    }

    public static void main(String[] args) {
        UsuarioDAO obj=new UsuarioDAO();
        /*Usuario usu=new Usuario("12343234","tito","hola");
        UsuarioDAO.agregar(usu);
        Usuario usu=new Usuario("","rosa","lepu");
        //JOptionPane.showMessageDialog(null, UsuarioDAO.validar(usu));
        List<Usuario> lista = obj.listar();
        for (Usuario usu : lista) {
            System.out.println(usu.getLogiUsua());
        }*/
        //System.out.println(obj.listarJSon());
    }
}
