package sew9.worttrainer.cpolat.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrainerTest {

    @Test
    public void nullTest() {
        assertThrows(IllegalArgumentException.class, () -> new WortTrainer(null));
    }

    @Test
    public void addEintragTest() {
        WortTrainer trainer = new WortTrainer();
        WortEintrag entry = new WortEintrag("wort", "https://elearning.tgm.ac.at/");
        trainer.addEintrag(entry);
        assertTrue(trainer.getEintraege().contains(entry));
    }

    @Test
    public void rmvEintragTest() {
        WortTrainer trainer = new WortTrainer();
        WortEintrag entry = new WortEintrag("wort", "https://elearning.tgm.ac.at/");
        trainer.addEintrag(entry);
        trainer.removeEintrag(entry);
        assertFalse(trainer.getEintraege().contains(entry));
    }

    @Test
    public void ohneEintragChecken() {
        WortTrainer trainer = new WortTrainer();
        assertThrows(IllegalStateException.class, () -> trainer.check("aasdasdasdf"));
    }

    @Test
    public void richtigerCheck() {
        WortTrainer trainer = new WortTrainer();
        WortEintrag entry = new WortEintrag("wort", "https://elearning.tgm.ac.at/");
        trainer.setAktuellerEintrag(entry);
        assertTrue(trainer.check("wort"));
    }

    @Test
    public void falscherCheck() {
        WortTrainer trainer = new WortTrainer();
        WortEintrag entry = new WortEintrag("wort", "https://elearning.tgm.ac.at/");
        trainer.setAktuellerEintrag(entry);
        assertFalse(trainer.check("asdasdasd"));
    }
}
