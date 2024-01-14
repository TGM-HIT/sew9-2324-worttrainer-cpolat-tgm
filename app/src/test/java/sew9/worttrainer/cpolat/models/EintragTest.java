package sew9.worttrainer.cpolat.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EintragTest {

    @Test
    public void nullWerte() {
        assertThrows(IllegalArgumentException.class, () -> new WortEintrag(null, "https://example.com"));
        assertThrows(IllegalArgumentException.class, () -> new WortEintrag("word", null));
    }

    @Test
    public void keineGültigeURL() {
        assertThrows(IllegalArgumentException.class, () -> new WortEintrag("wort", "asdsadsad"));
    }

    @Test
    public void gültigeURL() {
        WortEintrag entry = new WortEintrag("word", "https://example.com");
        assertTrue(entry.validateUrl());
    }

    @Test
    public void setURLTest() {
        WortEintrag entry = new WortEintrag();
        entry.setUrl("not a url");
        assertFalse(entry.validateUrl());
    }
}
