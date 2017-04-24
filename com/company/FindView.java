package com.company;

import com.company.controllers.RequestManager;
import com.company.controllers.ListenerFirst;
import com.company.controllers.ListenerSecond;
import com.company.controllers.ListenerTherd;

import javax.swing.*;

/**
 * Created by alex o n 11.04.2017.
 */
public class FindView {
    JDialog jDialog;
    int higthAligment=50;
    int heigth=20;
    int width=100;
    JButton findButton1;
    JButton findButton2;
    JButton findButton3;
    RequestManager dataBaseManipulation;
    public FindView(RequestManager dataBaseManipulation){
        this.dataBaseManipulation=dataBaseManipulation;
        jDialog=new JDialog();
        createElementsOfWindow();
    }
    void createElementsOfWindow() {
        jDialog.getContentPane().setLayout(null);
        jDialog.setVisible(true);
        jDialog.setBounds(500, 250, 500, 500);
        findButton1 = new JButton("Поиск по группе и фамилии");
        findButton1.setBounds(20, higthAligment + 30, 300, 20);
        jDialog.add(findButton1);
        findButton2 = new JButton("Поиск по фамилии и работе");
        findButton2.setBounds(20, higthAligment + 70, 300, 20);
        jDialog.add(findButton2);
        findButton3 = new JButton("Поиск по фамилии и количеству работ");
        findButton3.setBounds(20, higthAligment + 110, 300, 20);
        jDialog.add(findButton3);

        findButton1.addActionListener(new ListenerFirst(this, dataBaseManipulation));
        findButton2.addActionListener(new ListenerSecond(this, dataBaseManipulation));
        findButton3.addActionListener(new ListenerTherd(this, dataBaseManipulation));
    }

    public void removeBottons() {/**/
        jDialog.remove(findButton1);
        jDialog.remove(findButton2);
        jDialog.remove(findButton3);
    }

    public JDialog getjDialog() {
        return jDialog;
    }




}
