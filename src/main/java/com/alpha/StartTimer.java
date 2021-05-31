package com.alpha;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class StartTimer extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        CustomDialogWrapper customDialogWrapper = new CustomDialogWrapper(e.getProject());
        if (customDialogWrapper.showAndGet()) {
            customDialogWrapper.setNotify();
        }
    }
}