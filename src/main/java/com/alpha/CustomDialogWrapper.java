package com.alpha;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import org.jdesktop.swingx.*;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomDialogWrapper extends DialogWrapper {
    JLabel labelTime;
    JTextField textField;
    JLabel labelMode;
    JButton button1, button2;
    TYPE type;
    Project project;
    public String input = "";

    public CustomDialogWrapper(Project project) {
        super(project);
        init();
        setTitle("Test DialogWrapper");
        this.project = project;
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        var dialogPanel = new JPanel();
        labelTime = new JLabel("After");
        dialogPanel.add(labelTime);
        textField = new JTextField();
        dialogPanel.add(textField);
        labelMode = new JXLabel("minute(s) remind me to");
        dialogPanel.add(labelMode);
        button1 = new JButton("Chill");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                type = TYPE.CHILL;
            }
        });
        dialogPanel.add(button1);
        button2 = new JButton("Eat");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                type = TYPE.EAT;
            }
        });
        dialogPanel.add(button2);
        return dialogPanel;
    }

    public void setNotify() {
        Notification notification = new Notification(Float.parseFloat(textField.getText()), type, project);
    }
}