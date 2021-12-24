package sn.rachid.commandPharm.dao.interfaces;

import sn.rachid.commandPharm.models.Client;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface DAO (Database Access Object) - ClientDao
 *
 * Declaration de l'ensemble des operations à faire
 * sur l'entite Client
 */
public interface ClientDao {

    // Ajouter un client
    public int addClient (Client client) throws SQLException;

    // Supprimer un client (par son ID)
    public void deleteClient( int id) throws SQLException;

    // Afficher un client (par son ID)
    public Client getClient(int id) throws SQLException;

    // Afficher l'ensemble des clients
    public List<Client> getClients() throws SQLException;

    // Mise à jour (modification) d'un client
    public void updateClient(Client client) throws SQLException;
}
