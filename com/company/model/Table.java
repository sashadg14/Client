package com.company.model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by alex o n 11.04.2017.
 */
public class Table {
    int widh=130;
    int heigth=20;
    int heigthAligment=50;
    //JFrame jFrame;
    Window window;
    JLabel fio;
    JLabel group;
    JLabel publicWorsk;
    JLabel[] jLable;
    ArrayList<Component> componentArrayList;
    public Table(Window window){
        componentArrayList=new ArrayList<Component>();
        this.window=window;
        jLable= new JLabel[10];
    }
    public Table(int heigthAligment, Window window){
        componentArrayList=new ArrayList<Component>();
        this.heigthAligment=heigthAligment;
        this.window=window;
        jLable= new JLabel[10];
    }
    public void renderTable(ArrayList<String[]> stringArrayList) {
        for(Component component:componentArrayList){
            window.remove(component);
        }
        componentArrayList.clear();
        fio= new JLabel("ФИО");
        fio.setBounds(0,heigthAligment,widh,heigth*2);
        fio.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        fio.setHorizontalAlignment(JLabel.CENTER);
        fio.setVerticalAlignment(JLabel.CENTER);
        window.add(fio);
        componentArrayList.add(fio);
        group= new JLabel("Группа");
        group.setBounds(widh,heigthAligment,widh,heigth*2);
        group.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        group.setHorizontalAlignment(JLabel.CENTER);
        group.setVerticalAlignment(JLabel.CENTER);
        window.add(group);
        componentArrayList.add(group);
        publicWorsk= new JLabel("Общественные работы");
        publicWorsk.setBounds(widh*2,heigthAligment,widh*10,heigth);
        publicWorsk.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        publicWorsk.setHorizontalAlignment(JLabel.CENTER);
        publicWorsk.setVerticalAlignment(JLabel.CENTER);
        window.add(publicWorsk);
        componentArrayList.add(publicWorsk);
        for(int i=0;i<10;i++){
            jLable[i] = new JLabel(Integer.toString(1+i)+" семестр");
            window.remove(jLable[i]);
            jLable[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            jLable[i].setHorizontalAlignment(JLabel.CENTER);
            jLable[i].setVerticalAlignment(JLabel.CENTER);
            jLable[i].setBounds(widh*(2+i),heigthAligment+heigth,widh,heigth);
            window.add(jLable[i]);
        }
        for(String[] stringsArr: stringArrayList){
            createRow(stringsArr,stringArrayList.indexOf(stringsArr));
        }
        window.update(window.getGraphics());
        // System.out.println(stringArrayList.get(0).getGroup()+" ------");

    }

   void createRow(String[] strings, int index){
       JLabel name = new JLabel(" "+strings[0]+" "+strings[1]+" "+strings[2]);
       name.setBounds(0,heigthAligment+heigth*2+(heigth*index),widh,heigth);
       //System.out.println(name.getY()+"----");
       name.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
       //name.setHorizontalAlignment(JLabel.CENTER);
       name.setVerticalAlignment(JLabel.CENTER);
       window.add(name);
       componentArrayList.add(name);
       JLabel group = new JLabel(strings[3]);
       group.setBounds(widh,heigthAligment+heigth*2+(heigth*index),widh,heigth);
       group.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
       group.setHorizontalAlignment(JLabel.CENTER);
       group.setVerticalAlignment(JLabel.CENTER);
       window.add(group);
       componentArrayList.add(group);
       JLabel[] jLable = new JLabel[10];
       for(int i=0;i<10;i++){
           jLable[i] = new JLabel(strings[4+i]);
           jLable[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
           jLable[i].setHorizontalAlignment(JLabel.CENTER);
           jLable[i].setVerticalAlignment(JLabel.CENTER);
           jLable[i].setBounds(widh*(2+i),heigthAligment+heigth*2+(heigth*index),widh,heigth);
           window.add(jLable[i]);
           componentArrayList.add(jLable[i]);
       }
   }
}
