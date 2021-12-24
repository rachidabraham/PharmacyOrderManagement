package sn.rachid.commandPharm.models;

/**
 * Classe pour l'entite Client
 */
public class Client {

    protected int idClient;
    protected String nomClient;
    protected String adresseClient;
    protected String mailClient;

    // Constructeur par defaut de la classe Client
    public Client() {
        // TODO Auto-generated constructor stub
    }

    // Constructeur de la classe Client
    public Client(int idClient,String nomClient, String adresseClient, String mailClient) {
        this.idClient = idClient;
        this.nomClient = nomClient;
        this.adresseClient = adresseClient;
        this.mailClient = mailClient;
    }

    // Getters and Setters

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getAdresseClient() {
        return adresseClient;
    }

    public void setAdresseClient(String adresseClient) {
        this.adresseClient = adresseClient;
    }

    public String getMailClient() {
        return mailClient;
    }

    public void setMailClient(String mailClient) {
        this.mailClient = mailClient;
    }

    // ToString method
    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", nomClient='" + nomClient + '\'' +
                ", adresseClient='" + adresseClient + '\'' +
                ", mailClient='" + mailClient + '\'' +
                '}';
    }
}
