package com.alpha;

import com.intellij.openapi.project.Project;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

enum TYPE {
    CHILL,
    EAT
}

public class Notification {
    TYPE type;
    Timer timer = new Timer();
    Project project;

    Notification(float minutes, TYPE type, Project project) {
        float milliseconds = minutes * 60 * 1000;
        this.type = type;
        timer.schedule(new MyTimerTask(this.type, this.project), (long) milliseconds);
        this.project = project;
    }

    public class MyTimerTask extends TimerTask {
        TYPE typeOfTask;
        Project project;

        MyTimerTask(TYPE typeOfTask, Project project) {
            this.typeOfTask = typeOfTask;
            this.project = project;
        }

        @Override
        public void run() {
            selectImage().show();
            timer.cancel();
        }

        public JFrame selectImage() {
            JFrame jFrame = new JFrame("You need to rest");
            jFrame.setLocationRelativeTo(null);
            jFrame.setVisible(true);
            var dialogPanel = new JPanel();
            BufferedImage previewImage = null;
            String urlImage = "";
            int width, height;
            if (type == TYPE.CHILL) {
                urlImage = "https://memepedia.ru/wp-content/uploads/2021/04/qblulgcbrwk-%E2%80%94-kopija.jpg";
                width = 600;
                height = 400;
            } else {
                urlImage = "https://www.meme-arsenal.com/memes/28de5591d4dda1e87caa7ec3d64c3d1e.jpg";
                width = 600;
                height = 400;
            }
            try {
                previewImage = ImageIO.read(new URL(urlImage));
            } catch (IOException e) {
                e.printStackTrace();
            }
            JLabel wIcon = new JLabel(new ImageIcon(previewImage));
            dialogPanel.add(wIcon);
            jFrame.add(dialogPanel);
            jFrame.setSize(width, height);
            jFrame.pack();
            jFrame.setLocationRelativeTo(null);
            jFrame.setVisible(true);
            return jFrame;
        }
    }
}