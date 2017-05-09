package com.company;

import com.company.controllers.RequestManager;
import com.company.model.Table;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
    TextField ip;
    TextField port;
    Table table;
    RequestManager requestManager;
    ToolbarForTableControl toolbarForTableControl;
   public View(RequestManager requestManager){
       jFrame= new JFrame();
       this.requestManager = requestManager;
       table= new Table(jFrame);
       toolbarForTableControl=new ToolbarForTableControl(requestManager,jFrame, table);
       jFrame.getContentPane().setLayout(null);
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
       JToolBar jToolBar=new JToolBar("",JToolBar.HORIZONTAL);
       ip=new TextField();
       ip.setText("localhost");
       ip.setBounds(700,0,150,20);
       jFrame.add(ip);
       port=new TextField();
       port.setBounds(700,30,100,20);
       port.setText("4444");
       jFrame.add(port);
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
                new AddView(requestManager,View.this);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) { new DeleteView(requestManager,View.this);
          //  renderTable();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String filename=JOptionPane.showInputDialog("Введите имя файла");
                if(filename!=""&&filename!=null)
                requestManager.saveRequest(filename);
                else JOptionPane.showMessageDialog(new JFrame(), "Введите название файла!");
            }
        });
        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String filename=JOptionPane.showInputDialog("Введите имя файла");
                if (filename != "" && filename != null) {
                    requestManager.loadRequest(filename);
                    renderTable();
                }
                else JOptionPane.showMessageDialog(new JFrame(), "Введите название файла!");

            }
        });

        toolbar.add(addButton);
        toolbar.add(findButton);
        toolbar.add(deleteButton);
        toolbar.add(saveButton);
        toolbar.add(loadButton);

        jFrame.getContentPane().setLayout(null);
        toolbar.setBounds(0,0,toolbar.getWidth(),50);
        jFrame.add(toolbar);
        jFrame.update(jFrame.getGraphics());
        jFrame.getContentPane().setLayout(null);
        toolbar.setBounds(0,0,1600,50);
        jFrame.add(toolbar);
        renderTable();
        jFrame.update(jFrame.getGraphics());
        //jFrame.getContentPane().setLayout(null);
    }
    public String getIP(){
       return ip.getText();
    }
   public String getPort(){
       return port.getText();
    }
   public void renderTable(){

       try {
           table.renderTable(requestManager.getBasicPage());
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}
