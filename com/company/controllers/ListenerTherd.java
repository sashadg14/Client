package com.company.controllers;

import com.company.FindView;
import com.company.model.Table;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alex o n 22.04.2017.
 */
public class ListenerTherd implements ActionListener {
    FindView findView;
    RequestManager dataBaseManipulation;
    public ListenerTherd(FindView findView, RequestManager dataBaseManipulation){
        this.findView=findView;
        this.dataBaseManipulation=dataBaseManipulation;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int higthAligment=50;
        int heigth=20;
        int width=100;
        findView.removeBottons();
        final JLabel jLabel=new JLabel("Введите фамилию студента и диапазон количество работ");
        jLabel.setBounds(20,higthAligment-40,300,20);
        findView.getjDialog().add(jLabel);
        final TextField firstData = new TextField();
        firstData.setBounds(20,higthAligment,width,heigth);
        findView.getjDialog().add(firstData);
        final JLabel jLabel1= new JLabel("от");
        jLabel1.setBounds(160,higthAligment,20,heigth);
        findView.getjDialog().add(jLabel1);
        final TextField secondData = new TextField();
        secondData.setBounds(180, higthAligment,width/3,heigth);
        findView.getjDialog().add(secondData);
        final JLabel jLabel2= new JLabel("до");
        jLabel2.setBounds(180+width/3+10,higthAligment,20,heigth);
        findView.getjDialog().add(jLabel2);
        final TextField textField= new TextField();
        textField.setBounds(180+width/3+30, higthAligment,width/3,heigth);
        findView.getjDialog().add(textField);
        final JButton jButton=new JButton("Поиск");
        jButton.setBounds(70,higthAligment+40,50,20);
        findView.getjDialog().add(jButton);
        findView.getjDialog().update(findView.getjDialog().getGraphics());
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                findView.getjDialog().setBounds(0,200,1600,500);
                findView.getjDialog().remove(jLabel);
                findView.getjDialog().remove(jLabel1);
                findView.getjDialog().remove(jLabel2);
                findView.getjDialog().remove(firstData);
                findView.getjDialog().remove(secondData);
                findView.getjDialog().remove(textField);
                findView.getjDialog().remove(jButton);
                Table table = new Table(findView.getjDialog());
                table.renderTable(dataBaseManipulation.findStudentByNameAndNumberOfWork(firstData.getText(),secondData.getText(),textField.getText()));
                findView.getjDialog().update(findView.getjDialog().getGraphics());
            }
        });
    }
}
