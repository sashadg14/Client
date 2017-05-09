package com.company.controllers;

import com.company.FindView;
import com.company.ToolbarForTableControl;
import com.company.model.Table;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by alex o n 22.04.2017.
 */
public class ListenerFirst implements ActionListener {
    FindView findView;
    RequestManager requestManager;
    public ListenerFirst(FindView findView, RequestManager requestManager){
        this.findView=findView;
        this.requestManager=requestManager;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int higthAligment=50;
        int heigth=20;
        int width=100;
            findView.removeBottons();
            final JLabel jLabel=new JLabel("Введите фамилию студента и группу");
            jLabel.setBounds(20,higthAligment-40,300,20);
            findView.getjDialog().add(jLabel);
            final TextField nameField = new TextField();
            nameField.setBounds(20,higthAligment,width,heigth);
            findView.getjDialog().add(nameField);
            final TextField groupField = new TextField();
            groupField.setBounds(140, higthAligment,width,heigth);
            findView.getjDialog().add(groupField);
            final JButton jButton = new JButton("Поиск");
            jButton.setBounds(70,higthAligment+40,50,20);
            findView.getjDialog().add(jButton);
            findView.getjDialog().update(findView.getjDialog().getGraphics());
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    findView.getjDialog().setBounds(0,200,1600,500);
                    findView.getjDialog().remove(jLabel);
                    findView.getjDialog().remove(nameField);
                    findView.getjDialog().remove(groupField);
                    findView.getjDialog().remove(jButton);
                    Table table = new Table(findView.getjDialog());
                    //PageManipulator pageManipulator=new PageManipulator(requestManager.findStudentByNameAndGrop(nameField.getText(),secondData.getText()),table);
                    new ToolbarForTableControl(requestManager,findView.getjDialog(),table);
                    try {
                        requestManager.findStudentByNameAndGropRequest("1","");
                        table.renderTable(requestManager.getBasicPage());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    findView.getjDialog().update(findView.getjDialog().getGraphics());
                }
            });
    }
}
