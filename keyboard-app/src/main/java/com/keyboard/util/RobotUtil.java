package com.keyboard.util;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RobotUtil {
    private static final Properties config = new Properties();

    static {
        try (InputStream input = RobotUtil.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input != null) {
                config.load(input);
            } else {
                throw new IOException("Configuration file not found.");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static int getSleepTime() {
        return Integer.parseInt(config.getProperty("sleep.time", "300"));
    }

    public static void switchToPreviousApp(Robot robot) {
        robot.keyPress(java.awt.event.KeyEvent.VK_ALT);
        robot.keyPress(java.awt.event.KeyEvent.VK_TAB);
        robot.keyRelease(java.awt.event.KeyEvent.VK_TAB);
        robot.keyRelease(java.awt.event.KeyEvent.VK_ALT);
    }

    public static void highlightText(Robot robot) {
        robot.keyPress(java.awt.event.KeyEvent.VK_A);
        robot.keyRelease(java.awt.event.KeyEvent.VK_A);
    }

    public static void save(Robot robot) {
        robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
        robot.keyPress(java.awt.event.KeyEvent.VK_SHIFT);
        robot.keyPress(java.awt.event.KeyEvent.VK_S);
        robot.keyRelease(java.awt.event.KeyEvent.VK_S);
        robot.keyRelease(java.awt.event.KeyEvent.VK_SHIFT);
        robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
    }

    public static void delete(Robot robot) {
        robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
        robot.keyPress(java.awt.event.KeyEvent.VK_DELETE);
        robot.keyRelease(java.awt.event.KeyEvent.VK_DELETE);
        robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
    }
}