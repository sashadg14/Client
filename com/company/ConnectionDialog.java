package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alex on 24.05.2017.
 */
public class ConnectionDialog {
    JDialog jDialog;
    JLabel ipLabel;
    JLabel portLabel;
    JTextField ipField;
    JTextField portField;
    JButton button;
    int higth=20;
    int widh=100;
    int higthAlligment=30;
    int leftAligment=70;
    Client client;
    public ConnectionDialog(){
        jDialog=new JDialog();
        jDialog.getContentPane().setLayout(null);
        ipLabel=new JLabel("IP");
        portLabel=new JLabel("PORT");
        ipField=new JTextField();
        portField=new JTextField();
        button=new JButton("Подключиться");
        jDialog.add(ipField);
        jDialog.add(ipLabel);
        jDialog.add(portField);
        jDialog.add(portLabel);
        jDialog.add(portLabel);
        jDialog.add(button);
        jDialog.setBounds(700,400,300,200);
        jDialog.setVisible(true);
        ipField.setBounds(leftAligment,higthAlligment,widh,higth);
        portField.setBounds(leftAligment,higthAlligment+higth*2,widh/2,higth);
        ipLabel.setBounds(leftAligment-30,higthAlligment,widh,higth);
        portLabel.setBounds(leftAligment-40,higthAlligment+higth*2,widh/2,higth);
        button.setBounds(leftAligment-15,higthAlligment+higth*4,widh+30,higth);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            client.setIp(ipField.getText());
            client.setPort(Integer.parseInt(portField.getText()));
            new Thread(client).start();
            jDialog.setVisible(false);
            }
        });
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
