package sn.rachid.commandPharm.dao.implementations;

import sn.rachid.commandPharm.dao.interfaces.ClientDao;
import sn.rachid.commandPharm.models.Client;
import sn.rachid.commandPharm.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe ClientDaoImpl pour l'implémentation des
 * operations dans l'interface ClientDao
 */
public class ClientDaoImpl implements ClientDao {

    // Connection à la base de données
    static Connection connection = DatabaseConnection.getConnection();

    // Ajout d'un client dans la base de données
    @Override
    public int addClient(Client client) throws SQLException {

        String query = "INSERT INTO client(nomClient, adresseClient, mailClient) VALUES (?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1, client.getNomClient());
        ps.setString(2, client.getAdresseClient());
        ps.setString(3, client.getMailClient());

        return ps.executeUpdate(); // to insert, update, delete
    }

    // Suppression d'un client de la base de données
    @Override
    public void deleteClient(int id) throws SQLException {

        String query = "DELETE FROM client WHERE idClient =?";
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setInt(1, id);
        ps.executeUpdate(); // to insert, update, delete
    }

    // Récupération (Affichage) d'un client de la base de données
    @Override
    public Client getClient(int id) throws SQLException {

        String query = "SELECT * FROM client WHERE idClient = ?";
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setInt(1, id);
        Client client = new Client();
        ResultSet rs = ps.executeQuery(); // to retrieve data
        boolean check = false;

        // On parcourt les données poour verifier l'existence du client à afficher
        while (rs.next()) {
            check = true;
            client.setIdClient(rs.getInt("idClient"));
            client.setNomClient(rs.getString("nomClient"));
            client.setMailClient(rs.getString("mailClient"));
            client.setAdresseClient(rs.getString("adresseClient"));
        }

        if (check == true) {
            return client;
        } else {
            return null;
        }
    }

    // Récuperation de l'ensemble des clients
    @Override
    public List<Client> getClients() throws SQLException {

        String query = "SELECT * FROM client";
        PreparedStatement ps = connection.prepareStatement(query);

        ResultSet rs = ps.executeQuery(); // to retrieve data
        List<Client> ls = new ArrayList();

        // On parcourt les données poour verifier l'existence des clients à afficher
        while (rs.next()) {
            Client client = new Client();

            client.setIdClient(rs.getInt("idClient"));
            client.setNomClient(rs.getString("nomClient"));
            client.setMailClient(rs.getString("mailClient"));
            client.setAdresseClient(rs.getString("adresseClient"));

            ls.add(client); // ajouter dans la liste le client trouvé
        }
        return ls;
    }

    // Mise à jour (Modification) d'un client de la base de données
    @Override
    public void updateClient(Client client) throws SQLException {

        String query = "UPDATE client SET nomClient=?, mailClient=?, adresseClient=? WHERE idClient=?";
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1, client.getNomClient());
        ps.setString(2, client.getMailClient());
        ps.setString(3, client.getAdresseClient());
        ps.setInt(4, client.getIdClient());

        ps.executeUpdate(); // to insert, update, delete
    }
}
