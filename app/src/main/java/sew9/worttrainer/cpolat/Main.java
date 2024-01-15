package sew9.worttrainer.cpolat;

import sew9.worttrainer.cpolat.controller.Controller;
import sew9.worttrainer.cpolat.models.*;
import sew9.worttrainer.cpolat.saveLoad.*;

public class Main {
    public static void main(String[] args) {

        WortEintrag[] eintraege = {
                new WortEintrag("Auto",
                        "https://image.stern.de/8424922/t/8I/v2/w1440/r0/-/30--artikel22517bild01jpg---b5e7066e38d38876.jpg"),
                new WortEintrag("Fahrrad",
                        "https://media.istockphoto.com/id/1130470118/de/vektor/fahrrad-symbol-auf-wei%C3%9Fem-hintergrund.jpg?s=612x612&w=0&k=20&c=xBUVBOHjekPLT_jBbNFsdnsZy81rzv6_f9lmrdyx4_M=")
        };

        Json json = new Json();

        WortTrainer trainer = null;

        try {
            trainer = json.deserialize("Eintraege.wts", WortTrainer.class);
        } catch (Exception e) {
            trainer = null;

            System.out.println("No save file found. Using default.");
        }

        if (trainer == null) {
            trainer = new WortTrainer(eintraege);

        }

        Controller controller = new Controller(trainer);

        controller.show();
    }
}
