package com.bibavix.UI.StartBtn;

import com.bibavix.server.ServerController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButton extends JToggleButton implements ActionListener {
    ServerController serverController;
    public StartButton(){
        serverController = new ServerController();
        this.setText("Run Server");
        this.addActionListener(this);
        this.setSize(20, 15);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.isSelected()){
            serverController.startServer();
        } else {
            serverController.stopServer();
        }
    }
}
