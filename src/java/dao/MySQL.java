/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Usuario
 */
public class MySQL {
    Connection connection = null;
    static MySQL instance = null;

    public MySQL() throws Exception {
        String url = "jdbc:mysql://localhost:3306/criptografia";
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, "root", "123");
    }

    public static MySQL getInstance() throws Exception {
        if (instance == null) {
            instance = new MySQL();
        }
        return instance;
    }


    public Connection getConnection() {
        return connection;
    }

    @Override
    protected void finalize() throws Throwable {
        if (!connection.isClosed()) {
            connection.close();
            connection = null;
        }
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }
}
