package com.company.controllers;

import com.company.DeleteView;
import com.company.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by alex o n 23.04.2017.
 */
public class DeleteByNameAndNumberOfWorkListener implements ActionListener {
    DeleteView deleteView;
    RequestManager dataBaseManipulation;
    View view;
    public DeleteByNameAndNumberOfWorkListener(DeleteView deleteView, RequestManager dataBaseManipulation, View view){
        this.deleteView=deleteView;
        this.view=view;
        this.dataBaseManipulation=dataBaseManipulation;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int higthAligment=50;
        int heigth=20;
        int width=100;
        deleteView.removeBottons();
        final JLabel jLabel=new JLabel("Введите фамилию студента и диапазон количество работ");
        jLabel.setBounds(20,higthAligment-40,300,20);
        deleteView.getjDialog().add(jLabel);
        final TextField name = new TextField();
        name.setBounds(20,higthAligment,width,heigth);
        deleteView.getjDialog().add(name);
        final JLabel jLabel1= new JLabel("от");
        jLabel1.setBounds(160,higthAligment,20,heigth);
        deleteView.getjDialog().add(jLabel1);
        final TextField lowerLimit = new TextField();
        lowerLimit.setBounds(180, higthAligment,width/3,heigth);
        deleteView.getjDialog().add(lowerLimit);
        final JLabel jLabel2= new JLabel("до");
        jLabel2.setBounds(180+width/3+10,higthAligment,20,heigth);
        deleteView.getjDialog().add(jLabel2);
        final TextField upperLimit= new TextField();
        upperLimit.setBounds(180+width/3+30, higthAligment,width/3,heigth);
        deleteView.getjDialog().add(upperLimit);
        final JButton jButton=new JButton("Удаление");
        jButton.setBounds(70,higthAligment+40,80,20);
        deleteView.getjDialog().add(jButton);
        deleteView.getjDialog().update(deleteView.getjDialog().getGraphics());
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    deleteView.showCountOfDeletingStudents(dataBaseManipulation.deleteStudentByNameAndNumberOfWork(name.getText(),lowerLimit.getText(),upperLimit.getText()));
                    view.renderTable();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                deleteView.getjDialog().setVisible(false);
            }
        });
    }
}


