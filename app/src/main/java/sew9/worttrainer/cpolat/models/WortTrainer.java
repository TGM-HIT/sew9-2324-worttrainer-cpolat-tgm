package sew9.worttrainer.cpolat.models;

import java.io.Serializable;
import java.util.*;

/**
 * Worttrainer
 * 
 * @author Can Polat
 * @version 2024-01-14
 */
public class WortTrainer implements Serializable {
    private List<WortEintrag> eintraege;

    private WortEintrag aktuellerEintrag;

    private int gesamtVersuche;
    private int richtigeVersuche;

    /**
     * Konstruktor
     */
    public WortTrainer() {
        this(new WortEintrag[0]);
    }

    /**
     * Konstruktor
     * 
     * @param eintraege die Worteinträge
     * 
     */
    public WortTrainer(WortEintrag[] eintraege) {

        if (eintraege == null) {
            throw new IllegalArgumentException("Die Einträge dürfen nicht null sein");
        }

        // make entries mutable, as `Arrays.asList` returns an immutable list
        this.eintraege = new ArrayList<>(Arrays.asList(eintraege));
    }

    public void setRichtigeVersuche(int richtig) {
        this.richtigeVersuche = richtig;
    }

    public void setAktuellerEintrag(WortEintrag aktuell) {
        this.aktuellerEintrag = aktuell;
    }

    public void setEintraege(List<WortEintrag> eintraege) {
        this.eintraege = eintraege;
    }

    public void setGesamtVersuche(int gesamt) {
        this.gesamtVersuche = gesamt;
    }

    /**
     * Wirft eine {@link IllegalStateException}, wenn etwas null ist
     */
    public void nullCheck() {
        if (eintraege == null) {
            throw new IllegalStateException("Die Einträge dürfen nicht null sein");
        }

        for (WortEintrag eintrag : eintraege) {
            if (eintrag == null) {
                throw new IllegalStateException("Die Einträge dürfen kein null enthalten");
            }
        }
    }

    public List<WortEintrag> getEintraege() {
        return Collections.unmodifiableList(eintraege);
    }

    /**
     * Fügt einen Eintrag hinzu.
     * 
     * @param eintrag der Eintrag
     */
    public void addEintrag(WortEintrag eintrag) {
        eintraege.add(eintrag);
    }

    /**
     * Entfernt einen Eintrag.
     * 
     * @param eintrag der Eintrag
     */
    public void removeEintrag(WortEintrag eintrag) {
        eintraege.remove(eintrag);
    }

    /**
     * Wählt einen zufälligen Eintrag aus und gibt ihn zurück.
     * 
     * @return ein zufälliger Eintrag
     */
    public WortEintrag getRandomEintrag() {
        Random random = new Random();

        return aktuellerEintrag = eintraege.get(random.nextInt(eintraege.size()));
    }

    /**
     * Gibt den aktuell ausgewählten Eintrag zurück.
     * 
     * @return aktueller Eintrag
     */
    public WortEintrag getAktuellerEintrag() {
        return aktuellerEintrag;
    }

    /**
     * Gibt die Gesamtzahl der verfolgten Versuche beim Raten zurück.
     * 
     * @return Die Gesamtzahl der Versuche
     */
    public int getGesamtVersuche() {
        return gesamtVersuche;
    }

    /**
     * Gibt die Anzahl der korrekten Versuche beim Raten zurück.
     * 
     * @return Die Anzahl der korrekten Versuche
     */
    public int getRichtigeVersuche() {
        return richtigeVersuche;
    }

    /**
     * Gibt die Anzahl der falschen Versuche beim Raten zurück.
     * 
     * @return Die Anzahl der falschen Versuche
     */
    public int getFalscheVersuche() {
        return gesamtVersuche - richtigeVersuche;
    }

    /**
     * Überprüft, ob die Vermutung korrekt ist.
     * 
     * @param input Die zu überprüfende Vermutung
     * @return true, wenn die Vermutung korrekt ist, sonst false.
     * 
     */
    public boolean check(String input) {
        if (aktuellerEintrag == null) {
            throw new IllegalStateException("Es gibt keinen aktuellen Eintrag");
        }

        gesamtVersuche++;

        if (vergleichen(input, aktuellerEintrag.getWort())) {
            richtigeVersuche++;

            aktuellerEintrag = null;

            return true;
        }
        return false;
    }

    /**
     * Vergleicht den Input mit der Lösung.
     * 
     * @param lösung die Lösung
     * @param input  der Input
     * @return true, wenn die Antwort stimmt
     */
    public boolean vergleichen(String lösung, String input) {
        return lösung.equals(input);
    }

    @Override
    public String toString() {
        return "Trainer [Einträge=" + eintraege + ", aktuellerEintrag=" + aktuellerEintrag + ", gesamtVersuche="
                + gesamtVersuche + ", korrekteVersuche=" + richtigeVersuche + "]";
    }

}
