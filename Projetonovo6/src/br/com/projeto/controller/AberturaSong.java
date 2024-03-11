package br.com.projeto.controller;

import javax.sound.sampled.*;
import javax.swing.JButton;

import java.io.File;

public class AberturaSong { 
    public static void getSong() { 
        new Thread(() -> {
            try {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("Sons/Abertura.wav"));
                Clip clip = AudioSystem.getClip();

                clip.addLineListener(event -> {
                    if (event.getType() == LineEvent.Type.STOP)
                        clip.close();
                });

                clip.open(audioStream);
                clip.start();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }).start();
    }
}