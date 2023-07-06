package com.bibavix.UI.StartBtn;

import com.bibavix.server.ServerController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class StartButton extends JToggleButton implements ItemListener {
    ServerController serverController;
    public StartButton(){
        serverController = new ServerController();
        this.setText("Run Server");
        this.addItemListener(this);
        this.setSize(20, 15);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        if (isSelected()){
            System.out.println("Selected");
            serverController.setServerStatus(Boolean.TRUE);
            serverController.startServer();
        } else {
            System.out.println("Not Selected");
            serverController.setServerStatus(Boolean.FALSE);
            serverController.stopServer();
        }
        if (serverController.getServerStatus()){
            serverController.acceptConnections();
        }
    }
}
