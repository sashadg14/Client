package com.company.resourses;

import com.company.controllers.PageManipulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alex o n 23.04.2017.
 */
public class ToolbarForTableControl {
    PageManipulator pageManipulator;
    Window window;
    JButton leftButton;
    JButton rightButton;
    JButton leftButtonToEnd;
    JButton rightButtonToEnd;
    public ToolbarForTableControl(PageManipulator pageManipulator, Window window){
        this.pageManipulator=pageManipulator;
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
        setListeners();
        window.add(jToolBarSecond);
    }

    private void setListeners()
    {
        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pageManipulator.NextPage();
            }
        });
        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pageManipulator.PreviousPage();
            }
        });
        rightButtonToEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pageManipulator.LastPage();
            }
        });
        leftButtonToEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pageManipulator.FirstPage();
            }
        });
    }

}
