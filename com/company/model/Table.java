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

    public void renderTable(ArrayList<Student> studentArrayList) {
        for(Component component:componentArrayList){
            window.remove(component);
        }
        componentArrayList.clear();
        fio= new JLabel("ФИО");
        fio.setBounds(0,50,widh,heigth*2);
        fio.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        fio.setHorizontalAlignment(JLabel.CENTER);
        fio.setVerticalAlignment(JLabel.CENTER);
        window.add(fio);
        componentArrayList.add(fio);
        group= new JLabel("Группа");
        group.setBounds(widh,50,widh,heigth*2);
        group.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        group.setHorizontalAlignment(JLabel.CENTER);
        group.setVerticalAlignment(JLabel.CENTER);
        window.add(group);
        componentArrayList.add(group);
        publicWorsk= new JLabel("Общественные работы");
        publicWorsk.setBounds(widh*2,50,widh*10,heigth);
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
            jLable[i].setBounds(widh*(2+i),70,widh,heigth);
            window.add(jLable[i]);
        }
        for(Student student: studentArrayList){
            createRow(student,studentArrayList);
        }
        window.update(window.getGraphics());
        // System.out.println(studentArrayList.get(0).getGroup()+" ------");

    }

   void createRow(Student student, ArrayList<Student> studentArrayList){
       JLabel name = new JLabel(" "+student.getFirstName()+" "+student.getMiddleName()+" "+student.getLastName());
       name.setBounds(0,90+(heigth*studentArrayList.indexOf(student)),widh,heigth);
       //System.out.println(name.getY()+"----");
       name.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
       //name.setHorizontalAlignment(JLabel.CENTER);
       name.setVerticalAlignment(JLabel.CENTER);
       window.add(name);
       componentArrayList.add(name);
       JLabel group = new JLabel(student.getGroup());
       group.setBounds(widh,90+(heigth*studentArrayList.indexOf(student)),widh,heigth);
       group.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
       group.setHorizontalAlignment(JLabel.CENTER);
       group.setVerticalAlignment(JLabel.CENTER);
       window.add(group);
       componentArrayList.add(group);
       JLabel[] jLable = new JLabel[10];
       for(int i=0;i<10;i++){
           jLable[i] = new JLabel(student.getPublicWork().get(i));
           jLable[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
           jLable[i].setHorizontalAlignment(JLabel.CENTER);
           jLable[i].setVerticalAlignment(JLabel.CENTER);
           jLable[i].setBounds(widh*(2+i),90+(heigth*studentArrayList.indexOf(student)),widh,heigth);
           window.add(jLable[i]);
           componentArrayList.add(jLable[i]);
       }
   }
}
