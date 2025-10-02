package com.keyboard.component;

import com.keyboard.util.RobotUtil;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class HighlightButton extends JButton {
    public HighlightButton() {
        super("Highlight");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Robot robot = new Robot();
                    RobotUtil.switchToPreviousApp(robot);
                    Thread.sleep(RobotUtil.getSleepTime());
                    RobotUtil.highlightText(robot);
                } catch (AWTException | InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}