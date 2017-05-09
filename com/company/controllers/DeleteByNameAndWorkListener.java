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
public class DeleteByNameAndWorkListener implements ActionListener {
    DeleteView deleteView;
    RequestManager dataBaseManipulation;
    View view;
    public DeleteByNameAndWorkListener(DeleteView deleteView, RequestManager dataBaseManipulation, View view){
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
        final JLabel jLabel=new JLabel("Введите фамилию студента и вид работы");
        jLabel.setBounds(20,higthAligment-40,300,20);
        deleteView.getjDialog().add(jLabel);
        final TextField name = new TextField();
        name.setBounds(20,higthAligment,width,heigth);
        deleteView.getjDialog().add(name);
        final TextField work = new TextField();
        work.setBounds(140, higthAligment,width,heigth);
        deleteView.getjDialog().add(work);
        final JButton jButton = new JButton("Удаление");
        jButton.setBounds(70,higthAligment+40,80,20);
        deleteView.getjDialog().add(jButton);
        deleteView.getjDialog().update(deleteView.getjDialog().getGraphics());
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                   deleteView.showCountOfDeletingStudents(dataBaseManipulation.deleteStudentByNameAndWorkRequest(name.getText(),work.getText()));
                    view.renderTable();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                deleteView.getjDialog().setVisible(false);
            }
        });
    }
}

