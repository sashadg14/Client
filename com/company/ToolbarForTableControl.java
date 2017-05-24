package com.company;

import com.company.controllers.RequestManager;
import com.company.model.Table;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by alex o n 23.04.2017.
 */
public class ToolbarForTableControl {
    RequestManager requestManager;
    Window window;
    JButton leftButton;
    JButton rightButton;
    JButton leftButtonToEnd;
    JButton rightButtonToEnd;
    JButton resizeButton;
    Table table;
    JLabel jLabel;
    int posX,posY;
    public ToolbarForTableControl(int posX, int posY, RequestManager requestManager, Window window, Table table){
        this.requestManager=requestManager;
        this.window=window;
        this.table=table;
        this.posX=posX;
        this.posY=posY;
        jLabel=new JLabel();
       // window.add(jLabel);
        leftButton = new JButton();
        rightButton = new JButton();
        leftButtonToEnd = new JButton();
        rightButtonToEnd = new JButton();
        resizeButton = new JButton();
        leftButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("left.png")));
        rightButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("right.png")));
        leftButtonToEnd.setIcon(new ImageIcon(getClass().getClassLoader().getResource("left_1.png")));
        rightButtonToEnd.setIcon(new ImageIcon(getClass().getClassLoader().getResource("right_1.png")));
        resizeButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("resize.png")));
        JToolBar jToolBarSecond = new JToolBar("Toolbar", JToolBar.HORIZONTAL);
        jToolBarSecond.add(leftButtonToEnd);
        jToolBarSecond.add(leftButton);
        jToolBarSecond.add(rightButton);
        jToolBarSecond.add(rightButtonToEnd);
        jToolBarSecond.add(resizeButton);
        //createJLable();
        jToolBarSecond.add(jLabel);
        jToolBarSecond.setBounds(posX,posY,1600,30);
        setListeners();
        window.add(jToolBarSecond);
    }
    public void createJLable(){
        jLabel.setText(requestManager.getInformOboutTable()
        );
    }

    private void setListeners()
    {
        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                requestManager.nextPageRequest();
                try {
                    table.renderTable(requestManager.getBasicPage());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                createJLable();
            }
        });
        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                requestManager.previousPageRequest();
                try {
                    table.renderTable(requestManager.getBasicPage());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                createJLable();
            }
        });
        rightButtonToEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                requestManager.lastPageRequest();
                try {
                    table.renderTable(requestManager.getBasicPage());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                createJLable();
            }
        });
        leftButtonToEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                requestManager.firstPageRequest();
                try {
                    table.renderTable(requestManager.getBasicPage());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                createJLable();
            }
        });

        resizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String number=JOptionPane.showInputDialog("Введите число студентов на странице");
                if(number!=""||number!=null) {
                    try {
                        requestManager.resizePageRequest(Integer.parseInt(number));
                        table.renderTable(requestManager.getBasicPage());
                        createJLable();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }}
            }
        });
    }

    public JButton getLeftButton() {
        return leftButton;
    }

    public JButton getRightButton() {
        return rightButton;
    }

    public JButton getLeftButtonToEnd() {
        return leftButtonToEnd;
    }

    public JButton getRightButtonToEnd() {
        return rightButtonToEnd;
    }

    public JButton getResizeButton() {
        return resizeButton;
    }

    public void setRequestManager(RequestManager requestManager) {
        this.requestManager = requestManager;
    }
}
