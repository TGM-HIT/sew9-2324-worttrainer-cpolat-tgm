package sew9.worttrainer.cpolat.view;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.io.IOException;
import java.net.URL;

/**
 * Die UI für die App.
 * @author Can Polat
 * 
 * @version 2024-01-14
 */
public class View extends JFrame {

    JLabel img;

    JTextField inputFeld;

    JButton laden;
    JButton speichern;
    JButton hinzufügen;

    JLabel feedback;
    JLabel gesamtVersuche;
    JLabel korrekteVersuche;
    JLabel falscheVersuche;

    public View() {

        setTitle("Worttrainer Reloaded");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        img = new JLabel();
        img.setHorizontalAlignment(JLabel.CENTER);
        add(img, BorderLayout.CENTER);

        inputFeld = new JTextField();
        add(inputFeld, BorderLayout.SOUTH);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        feedback = new JLabel("Was siehst du auf dem Bild?");
        feedback.setHorizontalAlignment(JLabel.CENTER);
        panel.add(feedback, BorderLayout.NORTH);

        JPanel buttons = new JPanel();
        laden = new JButton("Laden");
        speichern = new JButton("Speichern");
        hinzufügen = new JButton("Hinzufügen");

        buttons.add(laden);
        buttons.add(speichern);
        buttons.add(hinzufügen);

        panel.add(buttons);

        JPanel ergebnis = new JPanel();

        gesamtVersuche = new JLabel("Gesamt: 0");
        korrekteVersuche = new JLabel("Korrekt: 0");
        falscheVersuche = new JLabel("Falsch: 0");

        ergebnis.add(gesamtVersuche);
        ergebnis.add(korrekteVersuche);
        ergebnis.add(falscheVersuche);

        panel.add(ergebnis);

        add(panel, BorderLayout.NORTH);
    }

    public JTextField getInputFeld() {
        return inputFeld;
    }

    public JButton getAddButton() {
        return hinzufügen;
    }

    public JButton getLoadButton() {
        return laden;
    }

    public JButton getSaveButton() {
        return speichern;
    }

    public String getInput() {
        return inputFeld.getText();
    }

    public void setImage(String imageUrl) throws IOException {

        URL url = new URL(imageUrl);
        Image image = ImageIO.read(url);
        ImageIcon imageIcon = new ImageIcon(image);
        img.setIcon(imageIcon);
    }

    public void setFeedback(String s) {
        feedback.setText(s);
    }

    public void setGesamt(int i) {
        gesamtVersuche.setText("Gesamt: " + i);
    }

    public void setKorrekt(int i) {
        korrekteVersuche.setText("Korrekt: " + i);
    }

    public void setFalsch(int i) {
        falscheVersuche.setText("Falsch: " + i);
    }

    public void clearInput() {
        inputFeld.setText("");
    }
}
