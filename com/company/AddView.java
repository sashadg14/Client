package com.company;



import com.company.controllers.RequestManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by alex o n 11.04.2017.
 */
public class AddView {
    JDialog jDialog;
    int leftAligment=200;
    int heigth=20;
    int width=100;
    TextField fistNameField;
    TextField surNameField;
    TextField lastNameField;
    TextField groupField;
    ArrayList<TextField> publicWorkFieldArray;
    RequestManager dataBaseManipulation;
    public AddView(RequestManager dataBaseManipulation){
        this.dataBaseManipulation=dataBaseManipulation;
        jDialog=new JDialog();
        publicWorkFieldArray= new ArrayList<TextField>();
        jDialog.getContentPane().setLayout(null);
        jDialog.setSize(500,500);
        jDialog.setVisible(true);
        createElementsOfWindow();
    }
    void createElementsOfWindow(){
        fistNameField = new TextField();
        fistNameField.setBounds(leftAligment,0,width,heigth);
        jDialog.add(fistNameField);
        surNameField = new TextField();
        surNameField.setBounds(leftAligment, (int) (heigth*1.5),width,heigth);
        jDialog.add(surNameField);
        lastNameField = new TextField();
        lastNameField.setBounds(leftAligment,heigth*3,width,heigth);
        jDialog.add(lastNameField);
        groupField = new TextField();
        groupField.setBounds(leftAligment, (int) (heigth*4.5),width,heigth);
        jDialog.add(groupField);
        for(int i=0;i<10;i++){
            publicWorkFieldArray.add(new TextField());
            publicWorkFieldArray.get(i).setBounds(leftAligment, (int) (heigth*(7.5+1.5*i)),width,heigth);
            jDialog.add(publicWorkFieldArray.get(i));
            JLabel jLabel = new JLabel((1+i)+" семестр");
            jLabel.setBounds(50,(int) (heigth*(7.5+1.5*i)),80,heigth);
            jDialog.add(jLabel);
        }
        JLabel firstName = new JLabel("Фамилия");
        firstName.setBounds(50,0,100,20);
        jDialog.add(firstName);
        JLabel secondName = new JLabel("Имя(инициалы)");
        secondName.setBounds(50,(int) (heigth*1.5),100,20);
        jDialog.add(secondName);
        JLabel lastName = new JLabel("Отчество(инициалы)");
        lastName.setBounds(50, heigth*3,150,20);
        jDialog.add(lastName);
        JLabel group = new JLabel("группа");
        group.setBounds(50,(int) (heigth*4.5),150,20);
        jDialog.add(group);
        JLabel publicWork = new JLabel("Общественные работы");
        publicWork.setBounds(175, heigth*6,150,20);
        jDialog.add(publicWork);
        JButton jButton = new JButton("Добавить");
        jButton.setBounds(300,300,80,40);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            dataBaseManipulation.AddNewStudentInBase(AddView.this);

            jDialog.setVisible(false);
            }
        });
        jDialog.add(jButton);


    }

    public TextField getFistNameField() {
        return fistNameField;
    }

    public TextField getSurNameField() {
        return surNameField;
    }

    public TextField getLastNameField() {
        return lastNameField;
    }

    public TextField getGroupField() {
        return groupField;
    }

    public ArrayList<TextField> getPublicWorkFieldArray() {
        return publicWorkFieldArray;
    }
}
