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
    public ToolbarForTableControl(RequestManager requestManager, Window window, Table table){
        this.requestManager=requestManager;
        this.window=window;
        leftButton = new JButton();
        rightButton = new JButton();
        leftButtonToEnd = new JButton();
        rightButtonToEnd = new JButton();
        leftButton.setIcon(new ImageIcon("src\\com\\company\\resourses\\left.png"));
        rightButton.setIcon(new ImageIcon("src\\com\\company\\resourses\\right.png"));
        leftButtonToEnd.setIcon(new ImageIcon("src\\com\\company\\resourses\\left_1.png"));
        rightButtonToEnd.setIcon(new ImageIcon("src\\com\\company\\resourses\\right_1.png"));
        JToolBar jToolBarSecond = new JToolBar("Toolbar", JToolBar.HORIZONTAL);
        jToolBarSecond.add(leftButtonToEnd);
        jToolBarSecond.add(leftButton);
        jToolBarSecond.add(rightButton);
        jToolBarSecond.add(rightButtonToEnd);
        jToolBarSecond.setBounds(800,800,1600,30);
        setListeners(table);
        window.add(jToolBarSecond);
    }
    private void setListeners(final Table table) {
        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                requestManager.nextPageRequest();
                try {
                    table.renderTable(requestManager.getBasicPage());
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
            }
        });
    }

}
