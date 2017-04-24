package com.company;

import com.company.controllers.RequestManager;
import com.company.controllers.PageManipulator;
import com.company.model.StudentBase;
import com.company.model.Table;
import com.company.resourses.ToolbarForTableControl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alex o n 11.04.2017.
 */
public class View {

    JFrame jFrame;
    JButton findButton;
    JButton addButton;
    JButton deleteButton;
    JButton saveButton;
    JButton loadButton;

    Table table;
    StudentBase studentBase;
    RequestManager requestManager;
    PageManipulator pageManipulator;
    ToolbarForTableControl toolbarForTableControl;
   public View(){
       jFrame= new JFrame();
       studentBase= new StudentBase();
       requestManager = new RequestManager(studentBase,this);
       JLabel JLABLE = new JLabel();
       table= new Table(jFrame);
       pageManipulator=new PageManipulator(studentBase.getStudents(),table);
       toolbarForTableControl=new ToolbarForTableControl(pageManipulator,jFrame);
       JLABLE.setBounds(0,0,1600,900);
        jFrame.add(JLABLE);
       jFrame.setSize(1000,800);
       jFrame.setVisible(true);
       findButton = new JButton();
       addButton = new JButton();
        deleteButton = new JButton();
        saveButton=new JButton();
        loadButton=new JButton();
       findButton.setIcon(new ImageIcon("src\\com\\company\\resourses\\findIcon.png"));
       addButton.setIcon(new ImageIcon("src\\com\\company\\resourses\\addIcon.png"));
       deleteButton.setIcon(new ImageIcon("src\\com\\company\\resourses\\delete.png"));
       saveButton.setIcon(new ImageIcon("src\\com\\company\\resourses\\save.png"));
       loadButton.setIcon(new ImageIcon("src\\com\\company\\resourses\\load.png"));



       creatingTolbar();
       jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

    public Table getTable() {
        return table;
    }

    public JFrame getjFrame() {
        return jFrame;
    }

    private void creatingTolbar() {
        JToolBar toolbar = new JToolBar("Toolbar", JToolBar.HORIZONTAL);
        findButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                new FindView(requestManager);
            }
        });
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                new AddView(requestManager);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) { new DeleteView(requestManager);
            renderTable();
            }
        });
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                studentBase.saveStudentBase();
            }
        });
        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                studentBase.readStudentBase();
                renderTable();
            }
        });
        toolbar.add(addButton);
        toolbar.add(findButton);
        toolbar.add(deleteButton);
        toolbar.add(saveButton);
        toolbar.add(loadButton);

        jFrame.getContentPane().setLayout(null);
        toolbar.setBounds(0,0,1600,50);
        jFrame.add(toolbar);
        renderTable();
        jFrame.update(jFrame.getGraphics());

        jFrame.getContentPane().setLayout(null);
        toolbar.setBounds(0,0,1600,50);
        jFrame.add(toolbar);
        renderTable();
        jFrame.update(jFrame.getGraphics());
        //jFrame.getContentPane().setLayout(null);
    }

   public void renderTable(){
       table.renderTable(pageManipulator.returnPageOfStudents());
    }
}
