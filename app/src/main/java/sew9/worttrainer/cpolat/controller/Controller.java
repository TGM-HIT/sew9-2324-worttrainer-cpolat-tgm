package sew9.worttrainer.cpolat.controller;

import sew9.worttrainer.cpolat.models.*;
import sew9.worttrainer.cpolat.saveLoad.*;
import sew9.worttrainer.cpolat.view.*;

import java.io.File;

import javax.swing.*;

/**
 * Controller
 * 
 * @author Can Polat
 * @version 2024-01-2024
 */
public class Controller {
    private WortTrainer trainer;
    private View view;

    public Controller(WortTrainer trainer) {
        this.trainer = trainer;
        this.view = new View();

        view.getInputFeld().addActionListener(e -> vergleichen());
        view.getAddButton().addActionListener(e -> getImg());
        view.getSaveButton().addActionListener(e -> speichern());
        view.getLoadButton().addActionListener(e -> laden());

        if (trainer.getAktuellerEintrag() == null) {
            getRandomEintrag();
        } else {
            updateUI();
        }
    }

    private void updateUI() {
        view.setGesamt(trainer.getGesamtVersuche());
        view.setKorrekt(trainer.getRichtigeVersuche());
        view.setFalsch(trainer.getFalscheVersuche());

        try {
            view.setImage(trainer.getAktuellerEintrag().getUrl());
        } catch (Exception e) {
            view.setFeedback("Bild kann nicht geladen werden!");
        }
    }

    private void getRandomEintrag() {
        trainer.getRandomEintrag();

        updateUI();

        view.clearInput();
    }

    private void vergleichen() {
        String guess = view.getInput();
        if (trainer.check(guess)) {
            view.setFeedback("Korrekt!");
            getRandomEintrag();
        } else {
            view.setFeedback("Falsch!");
        }

        updateUI();
    }

    private void getImg() {
        String wort = JOptionPane.showInputDialog(view, "Wort:");
        if (wort == null || wort.trim().isEmpty())
            return;

        String url = JOptionPane.showInputDialog(view, "URL:");

        if (url == null || url.trim().isEmpty())
            return;

        try {
            WortEintrag eintrag = new WortEintrag(wort, url);

            trainer.addEintrag(eintrag);
            view.setFeedback("Erfolgreich hinzugefügt!");
        } catch (Exception e) {
            view.setFeedback("URL nicht gültig!");
        }

    }

    private void laden() {
        File f = new File("Einträge.wts");

        if (f.exists()) {
            try {
                trainer = new Json().deserialize(f, WortTrainer.class);
                view.setFeedback("Erfolgreich geladen!");

                updateUI();
            } catch (Exception e) {
                view.setFeedback("Laden fehlgeschlagen!");
            }
        } else {
            view.setFeedback("keine Speicherung gefunden!");
        }

    }

    private void speichern() {
        try {
            new Json().serialize(trainer, "Einträge.wts");
            view.setFeedback("Erfolgreich gespeichert!");
        } catch (Exception e) {
            view.setFeedback("Speichern fehlgeschlagen!");
        }
    }

    public void show() {
        view.setVisible(true);
    }
}
