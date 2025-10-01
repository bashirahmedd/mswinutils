package com.keyboard.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Robot;
import java.awt.AWTException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Keyboard App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 75);

        // Create highlight button
        JButton highlightBtn = new JButton("Highlight");
        highlightBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    
                    Robot robot = new Robot();

                    // Simulate ALT+TAB to switch focus to the previous application
                    robot.keyPress(java.awt.event.KeyEvent.VK_ALT);
                    robot.keyPress(java.awt.event.KeyEvent.VK_TAB);
                    robot.keyRelease(java.awt.event.KeyEvent.VK_TAB);
                    robot.keyRelease(java.awt.event.KeyEvent.VK_ALT);
                    Thread.sleep(500);

                    // Send the 'A' keypress event to highlight text
                    robot.keyPress(java.awt.event.KeyEvent.VK_A);
                    robot.keyRelease(java.awt.event.KeyEvent.VK_A);
                } catch (AWTException | InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Create save button
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Simulate ALT+TAB to switch focus to the previous application
                    Robot robot = new Robot();
                    robot.keyPress(java.awt.event.KeyEvent.VK_ALT);
                    robot.keyPress(java.awt.event.KeyEvent.VK_TAB);
                    robot.keyRelease(java.awt.event.KeyEvent.VK_TAB);
                    robot.keyRelease(java.awt.event.KeyEvent.VK_ALT);

                    // Wait briefly to ensure the previous application regains focus
                    Thread.sleep(500);

                    // Send the Ctrl+Shift+S keypress event
                    robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
                    robot.keyPress(java.awt.event.KeyEvent.VK_SHIFT);
                    robot.keyPress(java.awt.event.KeyEvent.VK_S);
                    robot.keyRelease(java.awt.event.KeyEvent.VK_S);
                    robot.keyRelease(java.awt.event.KeyEvent.VK_SHIFT);
                    robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
                } catch (AWTException | InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });


        // Create delete button
        JButton deleteButton = new JButton("Del");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Simulate ALT+TAB to switch focus to the previous application
                    Robot robot = new Robot();
                    robot.keyPress(java.awt.event.KeyEvent.VK_ALT);
                    robot.keyPress(java.awt.event.KeyEvent.VK_TAB);
                    robot.keyRelease(java.awt.event.KeyEvent.VK_TAB);
                    robot.keyRelease(java.awt.event.KeyEvent.VK_ALT);

                    // Wait briefly to ensure the previous application regains focus
                    Thread.sleep(500);

                    // Send the Ctrl+Delete keypress event
                    robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
                    robot.keyPress(java.awt.event.KeyEvent.VK_DELETE);
                    robot.keyRelease(java.awt.event.KeyEvent.VK_DELETE);
                    robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
                } catch (AWTException | InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Add the button to the frame
        // Change the layout to BoxLayout for vertical alignment
        frame.setLayout(new FlowLayout());
        frame.add(highlightBtn);
        frame.add(deleteButton);
        frame.add(saveButton);

        // Make the frame visible
        frame.setVisible(true);
    }
}
