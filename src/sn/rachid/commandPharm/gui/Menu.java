package sn.rachid.commandPharm.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Classe Menu
 *
 * Pour représenter les choix dans le Menu
 */
public class Menu extends JFrame {

    private JPanel contentPane;

    /**
     * Creer la frame Menu
     */
    public Menu() {
        // Titre du menu
        setTitle("Gestion des Commandes - Pharmacie");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 539, 300);

        // Barre du menu
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.LIGHT_GRAY);
        setJMenuBar(menuBar);

        // Menu File
        JMenu menuFile = new JMenu("File");
        menuBar.add(menuFile);

        JMenuItem itemNew = new JMenuItem("New");
        menuFile.add(itemNew);

        JMenuItem itemEnregistrer = new JMenuItem("Enregistrer");
        menuFile.add(itemEnregistrer);

        JMenuItem itemEnregisterSous = new JMenuItem("Enregistrer sous");
        menuFile.add(itemEnregisterSous);

        JMenuItem itemImprimer = new JMenuItem("Imprimer");
        menuFile.add(itemImprimer);

        JMenuItem itemPartager = new JMenuItem("Partager");
        menuFile.add(itemPartager);

        JMenuItem itemExporter = new JMenuItem("Exporter");
        menuFile.add(itemExporter);

        JMenuItem itemOption = new JMenuItem("Option");
        menuFile.add(itemOption);

        JMenuItem itemQuitter = new JMenuItem("Quitter");
        menuFile.add(itemQuitter);

        // Menu Help
        JMenu menuHelp = new JMenu("Help");
        menuBar.add(menuHelp);

        // Menu Insert
        JMenu menuInsert = new JMenu("Insert");
        menuBar.add(menuInsert);

        // Menu Clients
        JMenu menuClients = new JMenu("Clients");
        menuBar.add(menuClients);

        JMenuItem itemAfficher = new JMenuItem("Afficher");
        menuClients.add(itemAfficher);

        JMenuItem itemAjouter = new JMenuItem("Ajouter ");
        menuClients.add(itemAjouter);

        // Menu Suppliers
        JMenu menuSuppliers = new JMenu("Suppliers");
        menuBar.add(menuSuppliers);

        JMenuItem itemAfficherSuppl = new JMenuItem("Afficher");
        menuSuppliers.add(itemAfficherSuppl);

        JMenuItem itemSupprimerSuppl = new JMenuItem("Supprimer");
        menuSuppliers.add(itemSupprimerSuppl);

        JMenuItem itemAjouterSuppl = new JMenuItem("Ajouter");
        menuSuppliers.add(itemAjouterSuppl);

        // Menu Historique
        JMenu menuHistorique = new JMenu("Historique");
        menuBar.add(menuHistorique);

        JMenuItem itemVente = new JMenuItem("Historique vente");
        menuHistorique.add(itemVente);

        JMenuItem itemAchat = new JMenuItem("Historique Achat");
        menuHistorique.add(itemAchat);

        //Menu Stockage
        JMenu menuStockage = new JMenu("Stockage");
        menuBar.add(menuStockage);

        JMenuItem itemProFini = new JMenuItem("Produit fini");
        menuStockage.add(itemProFini);

        JMenuItem itemMatPrem = new JMenuItem("Matière première");
        menuStockage.add(itemMatPrem);

        // Personalisation du Panel
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
    }


    /**
     * Lanceur de la GUI Menu (Application)
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Menu frame = new Menu();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public boolean onCreeUnSousMenu(Gui Afficher){
        Gui guimenu = Afficher.addGui();
        return true;
    }
}
