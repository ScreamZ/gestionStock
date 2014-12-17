package presentation;

import application.AchatVenteControleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetreAchat extends JFrame implements ActionListener {

    private JButton btAchat;
    private JTextField txtQuantite;
    private JComboBox<String> combo;
    private String[] lesProduits;
    private AchatVenteControleur achatVenteControleur;

    public FenetreAchat(String[] lesProduits) {

        this.achatVenteControleur = new AchatVenteControleur();
        this.lesProduits = lesProduits;
        setTitle("Achat");
        setBounds(500, 500, 200, 125);
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        btAchat = new JButton("Achat");
        txtQuantite = new JTextField(5);
        txtQuantite.setText("0");

        combo = new JComboBox<String>(lesProduits);
        combo.setPreferredSize(new Dimension(100, 20));
        contentPane.add(new JLabel("Produit"));
        contentPane.add(combo);
        contentPane.add(new JLabel("Quantité achetée"));
        contentPane.add(txtQuantite);
        contentPane.add(btAchat);

        btAchat.addActionListener(this);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String nomProduitSelectionne = this.lesProduits[this.combo.getSelectedIndex()];
        int quantiteAchetee = Integer.parseInt(this.txtQuantite.getText());
        this.achatVenteControleur.acheterProduit(nomProduitSelectionne, quantiteAchetee);
        this.dispose();
    }

}
