package com.bibavix.UI;

import com.bibavix.UI.StartBtn.StartButton;

import javax.swing.*;
import java.awt.*;

public class MainScreen extends JFrame {
    public MainScreen (){
        init();
    }
    void init(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        StartButton startButton = new StartButton();
        this.add(startButton, BorderLayout.CENTER);

        setLocationRelativeTo(null);
    }
}
