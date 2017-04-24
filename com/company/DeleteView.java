package com.company;

import com.company.controllers.*;

import javax.swing.*;

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
    public DeleteView(RequestManager dataBaseManipulation){
        this.dataBaseManipulation=dataBaseManipulation;
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

        deleteButton3.addActionListener(new DeleteByNameAndNumberOfWorkListener(this, dataBaseManipulation));
        deleteButton2.addActionListener(new DeleteByNameAndWorkListener(this, dataBaseManipulation));
        deleteButton1.addActionListener(new DeleteByNameAndGroupListener(this, dataBaseManipulation));
    }

    public void removeBottons() {/**/
        jDialog.remove(deleteButton1);
        jDialog.remove(deleteButton2);
        jDialog.remove(deleteButton3);
    }

    public JDialog getjDialog() {
        return jDialog;
    }




}
