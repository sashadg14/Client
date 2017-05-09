package com.company;

import com.company.controllers.*;

import javax.swing.*;
import java.io.IOException;

/**
 * Created by alex o n 11.04.2017.
 */
public class DeleteView {
    JDialog jDialog;
    int higthAligment=50;
    int heigth=20;
    int width=100;
    JButton deleteButton1;
    JButton deleteButton2;
    JButton deleteButton3;
    RequestManager dataBaseManipulation;
    View view;
    public DeleteView(RequestManager dataBaseManipulation, View view){
        this.dataBaseManipulation=dataBaseManipulation;
        this.view=view;
        jDialog=new JDialog();
        createElementsOfWindow();
    }
    void createElementsOfWindow() {
        jDialog.getContentPane().setLayout(null);
        jDialog.setVisible(true);
        jDialog.setBounds(500, 250, 500, 500);
        deleteButton1 = new JButton("Удаление по группе и фамилии");
        deleteButton1.setBounds(20, higthAligment + 30, 300, 20);
        jDialog.add(deleteButton1);
        deleteButton2 = new JButton("Удаление по фамилии и работе");
        deleteButton2.setBounds(20, higthAligment + 70, 300, 20);
        jDialog.add(deleteButton2);
        deleteButton3 = new JButton("Удаление по фамилии и количеству работ");
        deleteButton3.setBounds(20, higthAligment + 110, 300, 20);
        jDialog.add(deleteButton3);

        deleteButton3.addActionListener(new DeleteByNameAndNumberOfWorkListener(this, dataBaseManipulation,view));
        deleteButton2.addActionListener(new DeleteByNameAndWorkListener(this, dataBaseManipulation,view));
        deleteButton1.addActionListener(new DeleteByNameAndGroupListener(this, dataBaseManipulation,view));
    }

    public void removeBottons() {/**/
        jDialog.remove(deleteButton1);
        jDialog.remove(deleteButton2);
        jDialog.remove(deleteButton3);
    }
    public void showCountOfDeletingStudents(int count){
        jDialog.setVisible(false);
        if (count!=0){
            JOptionPane.showMessageDialog(new JFrame(), "Записей найдено и удалено "+count);
        }
        else JOptionPane.showMessageDialog(new JFrame(), "Записей не найдено");
        view.renderTable();
    }
    public JDialog getjDialog() {
        return jDialog;
    }




}
