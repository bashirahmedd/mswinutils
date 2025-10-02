package com.keyboard.app;

import com.keyboard.component.DeleteButton;
import com.keyboard.component.HighlightButton;
import com.keyboard.component.SaveButton;

import javax.swing.*;
import java.awt.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Keyboard App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 75);

        // Change the layout to BoxLayout for vertical alignment
        frame.setLayout(new FlowLayout());
        frame.add(new HighlightButton());
        frame.add(new DeleteButton());
        frame.add(new SaveButton());

        // Make the frame visible
        frame.setVisible(true);
    }
}
