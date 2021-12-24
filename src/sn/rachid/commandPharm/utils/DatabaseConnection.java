package sn.rachid.commandPharm.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe DatabaseConnection pour gérer la connection
 * avec la base de données MySQL
 */
public class DatabaseConnection {

    // Initialisation de la connection à null
    private static Connection connection = null;

    // Renseignement des informations de connection à la base
    static {
        String url = "jdbc:mysql://localhost:3306/pharmacie"; //URL vers la base de données MySQL
        String user = "rachid"; // Nom d'utilisateur de la base (par défaut, c'est "root")
        String password = "mypasswd"; // Mot de passe (par défaut, c'est "root")
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
