package sn.rachid.commandPharm.gui;

import sn.rachid.commandPharm.dao.implementations.ClientDaoImpl;
import sn.rachid.commandPharm.models.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Graphic User Interface Class
 *
 * Pour representation graphiquement l'application
 */
public class Gui extends JFrame {

    // Panel Client - Label, TextField, Button
    private JPanel panel;
    private JLabel labelNom, labelAdresse, labelMail, labelIdClient, labelResult;
    private TextField nom, adresse, idClient, mail;
    private JButton buttonAjout, buttonSupprimer, buttonReset, buttonModifier;

    // Initialisation de l'interface graphique (GUI)
    public Gui(){
        initUI();
    }

    public void initUI(){
        // Pour le Client
        setTitle("Espace Client - Administrateur");
        setSize(200, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        buttonAjout = new JButton("Ajouter");
        buttonAjout.setBounds(15, 250, 190, 25);

        buttonSupprimer = new JButton("Supprimer");
        buttonSupprimer.setBounds(250, 250, 190, 25);

        buttonReset = new  JButton("Reset");
        buttonReset.setBounds(500,250,190,25);

        buttonModifier = new JButton("Modifier");
        buttonModifier.setBounds(250, 300, 190, 25);

        labelResult = new JLabel();
        labelResult.setBounds(30, 157, 190, 25);

        labelNom = new  JLabel("Nom Client");
        labelNom.setBounds(15,30,190,25);
        nom = new TextField();
        nom.setBounds(15,45,190,30);

        labelAdresse = new  JLabel("Adresse Client");
        labelAdresse.setBounds(250,30,190,25);
        adresse = new TextField();
        adresse.setBounds(250,45,190,30);

        labelMail = new  JLabel("Mail Client");
        labelMail.setBounds(480,30,190,25);
        mail= new TextField();
        mail.setBounds(480,45,190,30);

        labelIdClient = new  JLabel("Id Client");
        labelIdClient.setBounds(700,30,190,25);
        idClient = new TextField();
        idClient.setBounds(700,45,190,30);

        panel = new JPanel();
        panel.setLayout(null);


        // Listener sur le bouton Ajout - Evenement "Ajouter un client"
        buttonAjout.addActionListener((ActionListener) new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                try {

                    Client client = new Client();

                    // On récupère les informations entrées dans les champs de la GUI
                    String nomBD = nom.getText();
                    String adresseBD = adresse.getText();
                    String mailBD = mail.getText();


                    // On les met dans la base de données à l'aide du clientDao
                    client.setNomClient(nomBD);
                    client.setAdresseClient(adresseBD);
                    client.setMailClient(mailBD);
                    ClientDaoImpl clientDao = new ClientDaoImpl();

                    // Ajout du client dans la base de données
                    clientDao.addClient(client);

                    // Mise à jour de la GUI avec les messages d'info
                    labelResult.setForeground(Color.BLUE);
                    labelResult.setText("Client ajouté avec succès");
                    JOptionPane.showMessageDialog(panel, "Client ajouté avec succès");
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // Listener sur le bouton Supprimer - Evenement "Supprimer un client"
        buttonSupprimer.addActionListener((ActionListener) new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                try {

                    // On récupère de la GUI l'ID du client à supprimer
                    String idClientBD = idClient.getText();
                    int intIdClientBD = Integer.parseInt(idClientBD); // Conversion du Text récupèré en Integer

                    // On le cherche dans la base de données à l'aide du clientDao
                    ClientDaoImpl clientDao = new ClientDaoImpl();

                    // Suppression du client de la base de données
                    clientDao.deleteClient(intIdClientBD);

                    // Mise à jour de la GUI avec les messages d'info
                    labelResult.setForeground(Color.RED);
                    labelResult.setText("Client supprimé avec succès");
                    JOptionPane.showMessageDialog(panel, "Client supprimé avec succès");
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // Listener sur le bouton Modifier - Evenement "Modifier un client"
        buttonModifier.addActionListener((ActionListener) new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                try {

                    // On récupère les informations entrées dans les champs de la GUI
                    String nomBD = nom.getText();
                    String adresseBD = adresse.getText();
                    String mailBD = mail.getText();

                    String idClientBD = idClient.getText();
                    int intIdClientBD = Integer.parseInt(idClientBD);


                    // On les met dans la base de données à l'aide du clientDao
                    ClientDaoImpl clientDao = new ClientDaoImpl();
                    Client tempClient = clientDao.getClient(intIdClientBD);

                    tempClient.setNomClient(nomBD);
                    tempClient.setAdresseClient(adresseBD);
                    tempClient.setMailClient(mailBD);

                    // Modification du client dans la base de données
                    clientDao.updateClient(tempClient);

                    // Mise à jour de la GUI avec les messages d'info
                    labelResult.setForeground(Color.GREEN);
                    labelResult.setText("Client modifié avec succès");
                    JOptionPane.showMessageDialog(panel, "Client modifié avec succès");
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // Listener sur le bouton Reset - Evenement "Reset l'interface graphique (GUI)"
        buttonReset.addActionListener((ActionListener) new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                try {

                    // On réinitialise la GUI
                    nom.setText("");
                    adresse.setText("");
                    mail.setText("");
                    idClient.setText("");
                    labelResult.setText("");

                    // Mise à jour de la GUI avec les messages d'info
                    JOptionPane.showMessageDialog(panel, "GUI reset !");
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });


        // Ajout du panel, des labels, des fields et des boutons dans la GUI
        this.add(panel);

        panel.add(labelResult);

        panel.add(labelNom);
        panel.add(nom);

        panel.add(labelAdresse);
        panel.add(adresse);

        panel.add(labelMail);
        panel.add(mail);

        panel.add(labelIdClient);
        panel.add(idClient);

        panel.add(buttonAjout);
        panel.add(buttonSupprimer);
        panel.add(buttonReset);
        panel.add(buttonModifier);
    }


    // Lanceur de la GUI
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Gui window = new Gui();
            window.setVisible(true);
        });
    }

    public Gui addGui() {
        return null;
    }
}
