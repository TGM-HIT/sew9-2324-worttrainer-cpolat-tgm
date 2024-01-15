package sew9.worttrainer.cpolat.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EintragTest {

    @Test
    public void nullWerte() {
        assertThrows(IllegalArgumentException.class, () -> new WortEintrag(null, "https://elearning.tgm.ac.at/"));
        assertThrows(IllegalArgumentException.class, () -> new WortEintrag("wort", null));
    }

    @Test
    public void keineGueltigeURL() {
        assertThrows(IllegalArgumentException.class, () -> new WortEintrag("wort", "asdsadsad"));
    }

    @Test
    public void gueltigeURL() {
        WortEintrag entry = new WortEintrag("word", "https://elearning.tgm.ac.at/");
        assertTrue(entry.validateUrl());
    }

    @Test
    public void setURLTest() {
        WortEintrag entry = new WortEintrag();
        entry.setUrl("asdasdasd");
        assertThrows(IllegalArgumentException.class, () -> entry.validateUrl());
    }
}
