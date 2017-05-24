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
    JButton start;
    Table table;
    RequestManager requestManager;
    ToolbarForTableControl toolbarForTableControl;
   public View(final Client client){
       jFrame= new JFrame();
       table= new Table(jFrame);
       toolbarForTableControl=new ToolbarForTableControl(700,700,requestManager,jFrame, table);
       jFrame.getContentPane().setLayout(null);
       jFrame.setSize(1000,800);
       jFrame.setVisible(true);
       findButton = new JButton();
       addButton = new JButton();
        deleteButton = new JButton();
        saveButton=new JButton();
        loadButton=new JButton();
       findButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("findIcon.png")));
       addButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("addIcon.png")));
       deleteButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("delete.png")));
       saveButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("save.png")));
       loadButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("load.png")));
       JToolBar jToolBar=new JToolBar("",JToolBar.HORIZONTAL);
       start=new JButton("start");
       start.setBounds(700,30,70,20);
       jFrame.add(start);
       start.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent actionEvent) {
               new ConnectionDialog().setClient(client);
           }
       });
       creatingTolbar();
       creatingMenu();
       jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

    public void setRequestManager(RequestManager requestManager) {
        this.requestManager = requestManager;
        toolbarForTableControl.setRequestManager(requestManager);
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
                new FindView(requestManager).createFindWindow();

            }
        });
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                new AddView(requestManager,View.this);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) { new DeleteView(requestManager,View.this).createDeleteWindow();
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
        //renderTable();
        jFrame.update(jFrame.getGraphics());
        //jFrame.getContentPane().setLayout(null);
    }
    private void creatingMenu(){
        JMenuBar menuBar = new JMenuBar();
        jFrame.setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("Файл");
        menuBar.add(fileMenu);
        fileMenu.add(new JMenuItem(new AbstractAction("Сохранить как...") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                saveButton.doClick();
            }
        }));
        fileMenu.add(new JMenuItem(new AbstractAction("Загрузить") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                loadButton.doClick();
            }
        }));

        JMenu dataBase = new JMenu("База студентов");
        menuBar.add(dataBase);
        dataBase.add(new JMenuItem(new AbstractAction("Добавить") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addButton.doClick();
            }
        }));
        dataBase.add(new JMenuItem(new AbstractAction("Удалить") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                deleteButton.doClick();
            }
        }));
        dataBase.add(new JMenuItem(new AbstractAction("Поиск") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                findButton.doClick();
            }
        }));

        JMenu table = new JMenu("Таблица");
        menuBar.add(table);
        dataBase.add(new JMenuItem(new AbstractAction("Следующая страница") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                toolbarForTableControl.getRightButton().doClick();
            }
        }));
        table.add(new JMenuItem(new AbstractAction("Предыдущая страница") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                toolbarForTableControl.getLeftButton().doClick();
            }
        }));
        table.add(new JMenuItem(new AbstractAction("Первая страница") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                toolbarForTableControl.getLeftButtonToEnd().doClick();
            }
        }));
        table.add(new JMenuItem(new AbstractAction("Последняя страница") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                toolbarForTableControl.getRightButtonToEnd().doClick();
            }
        }));
        table.add(new JMenuItem(new AbstractAction("Изменить размер страницы") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                toolbarForTableControl.getResizeButton().doClick();
            }
        }));
    }
   public void renderTable(){

       try {
           table.renderTable(requestManager.getBasicPage());
           toolbarForTableControl.createJLable();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }


    public JButton getStart() {
        return start;
    }
}
