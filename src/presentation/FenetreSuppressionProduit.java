package presentation;

import application.CreerSupprimerProduitControleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetreSuppressionProduit extends JFrame implements ActionListener {

    private JButton btSupprimer;
    private JComboBox<String> combo;
    private CreerSupprimerProduitControleur creerSupprimerProduitControleur;
    private String lesProduits[];

    public FenetreSuppressionProduit(String lesProduits[]) {

        this.lesProduits = lesProduits;
        creerSupprimerProduitControleur = CreerSupprimerProduitControleur.getInstance();
        setTitle("Suppression produit");
        setBounds(500, 500, 200, 105);
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        btSupprimer = new JButton("Supprimer");

        combo = new JComboBox<String>(lesProduits);
        combo.setPreferredSize(new Dimension(100, 20));
        contentPane.add(new JLabel("Produit"));
        contentPane.add(combo);
        contentPane.add(btSupprimer);

        btSupprimer.addActionListener(this);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String nomProduitSelectionne = this.lesProduits[this.combo.getSelectedIndex()];
        creerSupprimerProduitControleur.supprimerProduit(nomProduitSelectionne);

        this.dispose();
    }

}
