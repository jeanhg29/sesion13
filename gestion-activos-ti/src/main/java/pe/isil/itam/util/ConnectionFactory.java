package pe.isil.itam.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    //Aquí va el nombre de la BD que estás usando en databaseName. RECUERDA CAMBIARLA!!!
    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=itam;encrypt=false;trustServerCertificate=true;";
    //Aquí va el us usuario, que debería ser "sa"
    private static final String USER = "sa";
    //Aquí va la contraseña. RECUERDA CAMBIARLA!!!
    private static final String PASSWORD = "sa";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }
}
