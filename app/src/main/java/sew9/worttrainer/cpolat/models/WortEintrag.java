package sew9.worttrainer.cpolat.models;

import java.io.Serializable;

/**
 * WortEintrag
 * 
 * @author Can Polat
 * @version 2024-01-14
 */
public class WortEintrag implements Serializable {

    private String wort;
    private String url;

    /**
     * Leer-Konstruktor für die Serialisierung.
     */
    public WortEintrag() {
        url = null;
        wort = null;
    }

    /**
     * Konstruktor
     * 
     * @param wort das Word
     * @param url  die URL
     */
    public WortEintrag(String wort, String url) {
        this.wort = wort;
        this.url = url;

        if (wort == null || url == null) {
            throw new IllegalArgumentException("The word or the url must not be null");
        }

        validateUrl();
    }

    /**
     * Überprüft, ob die URL gültig ist.
     * 
     * @return true, wenn die URL fültig ist, sonst wird eine exception geworfen.
     * 
     */
    public boolean validateUrl() {
        if (!url.matches("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]"))
            throw new IllegalArgumentException("The url is not valid");
        else
            return true;

    }

    @Override
    public String toString() {
        return String.format("WordEntry[word=%s, url=%s]", wort, url);
    }

    public String getUrl() {
        return url;
    }

    public String getWort() {
        return wort;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setWort(String word) {
        this.wort = word;
    }
}
