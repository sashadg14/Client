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
public class FindView {
    private JDialog jDialog;
    private int higthAligment=50;
    private int heigth=20;
    private int width=300;
    int leftAligment = 350;

    private JButton findByNameAndGroupButton;
    private JButton findByNameAndWorkButton;
    private JButton findNameNumberOfWorkButton;
    private RequestManager requestManager;

    private JLabel jLabel;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private TextField firstData;
    private TextField secondData;
    private TextField thirdData;
    private ActionListener totalAcionListener;
    private JButton actionButton ;

    public FindView(RequestManager RequestManager){
        this.requestManager =RequestManager;
        jDialog=new JDialog();
        jLabel=new JLabel();
        jLabel1= new JLabel("от");
        jLabel2= new JLabel("до");
        firstData = new TextField();
        secondData = new TextField();
        thirdData = new TextField();
        actionButton = new JButton();
        //createElementsOfWindow("");
    }
   void createElementsOfWindow(final String findButtonName) {
        jDialog.getContentPane().setLayout(null);
        jDialog.setVisible(true);
        jDialog.setBounds(200, 250, 900, 900);
        findByNameAndGroupButton = new JButton(findButtonName+" по группе и фамилии");
        findByNameAndGroupButton.setBounds(20, higthAligment , width, heigth);
        jDialog.add(findByNameAndGroupButton);
        findByNameAndWorkButton = new JButton(findButtonName+" по фамилии и работе");
        findByNameAndWorkButton.setBounds(20, higthAligment + 30, width, heigth);
        jDialog.add(findByNameAndWorkButton);
        findNameNumberOfWorkButton = new JButton(findButtonName+" по фамилии и количеству работ");
        findNameNumberOfWorkButton.setBounds(20, higthAligment + 60, width, heigth);
        jDialog.add(findNameNumberOfWorkButton);

        //findByNameAndGroupButton.addActionListener(new FindByNameAndGroupListener(this, requestManager,findButtonName));

       // findByNameAndWorkButton.addActionListener(new FindByNameAndWorkListener(this, requestManager));
        //findNameNumberOfWorkButton.addActionListener(new FindByNameAndNumberOfWorkListener(this, requestManager));
    }

    public void removeElements() {
        jDialog.remove(jLabel1);
        jDialog.remove(jLabel2);
        jDialog.remove(thirdData);
        jDialog.remove(firstData);
        jDialog.remove(secondData);
        jDialog.remove(jLabel);
        firstData.setText("");
        secondData.setText("");
        thirdData.setText("");
        jDialog.remove(actionButton);
        if(totalAcionListener!=null)
        actionButton.removeActionListener(totalAcionListener);
    }

    public void addFindByNameAndGroupElemens(String btnName, ActionListener actionForButton){
        totalAcionListener=actionForButton;
        jLabel.setText("Введите фамилию студента и группу");
        jLabel.setBounds(leftAligment, higthAligment - 10, 300, 20);
        getjDialog().add(jLabel);
        firstData.setBounds(leftAligment, higthAligment+30, width/3, heigth);
        getjDialog().add(firstData);
        secondData.setBounds(leftAligment+130, higthAligment+30, width/3, heigth);
        getjDialog().add(secondData);
        actionButton.setText(btnName);
        actionButton.setBounds(leftAligment+60, higthAligment + 70, 80, 20);
        getjDialog().add(actionButton);
        getjDialog().update(getjDialog().getGraphics());
        actionButton.addActionListener(actionForButton);
    }

    public void addFindByNameAndWorkElemens(String btnName, ActionListener actionForButton){
        addFindByNameAndGroupElemens(btnName,actionForButton);
        getjDialog().update(getjDialog().getGraphics());
        jLabel.setText("Введите фамилию студента и вид работы");
    }

    public void addFindByNameAndNumberOfWorkElemens(String btnName, ActionListener actionForButton){
        //removeElements();
        addFindByNameAndGroupElemens(btnName,actionForButton);

        jLabel.setText("Введите фамилию студента и диапазон количество работ");

        jLabel1.setBounds(leftAligment+120,higthAligment+30,20,heigth);
        getjDialog().add(jLabel1);
        secondData.setBounds(leftAligment+140, higthAligment+30,width/9,heigth);

        jLabel2.setBounds(leftAligment+180,higthAligment+30,20,heigth);
        getjDialog().add(jLabel2);
        thirdData.setBounds(leftAligment+200, higthAligment+30,width/9,heigth);
        getjDialog().add(thirdData);
    }


    public void createFindWindow(){
        createElementsOfWindow("Поиск");
        final Table table = new Table(higthAligment+100,jDialog);
        //PageManipulator pageManipulator=new PageManipulator(requestManager.findStudentByNameAndGrop(nameField.getText(),secondData.getText()),table);
        new ToolbarForTableControl(700,700,requestManager,jDialog,table);
        getjDialog().setBounds(0, 0, 1600, 900);

        findByNameAndGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                removeElements();
                addFindByNameAndGroupElemens("Поиск",new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        try {
                            requestManager.findStudentByNameAndGropRequest(firstData.getText(),secondData.getText());
                            table.renderTable(requestManager.getBasicPage());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        //findView.getjDialog().update(findView.getjDialog().getGraphics());
                    }
                });
            }
        });

        findByNameAndWorkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                removeElements();
                addFindByNameAndWorkElemens("Поиск", new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        try {
                            requestManager.findStudentByNameAndWorkRequest(firstData.getText(),secondData.getText());
                            table.renderTable(requestManager.getBasicPage());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

        findNameNumberOfWorkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                removeElements();
                addFindByNameAndNumberOfWorkElemens("Поиск", new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        try {
                            requestManager.findStudentByNameAndNumberOfWork(firstData.getText(),secondData.getText(),thirdData.getText());
                            table.renderTable(requestManager.getBasicPage());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

    }

    public JDialog getjDialog() {
        return jDialog;
    }

    public TextField getFirstData() {
        return firstData;
    }

    public TextField getSecondData() {
        return secondData;
    }

    public TextField getThirdData() {
        return thirdData;
    }

    public JButton getFindByNameAndGroupButton() {
        return findByNameAndGroupButton;
    }

    public JButton getFindByNameAndWorkButton() {
        return findByNameAndWorkButton;
    }

    public JButton getFindByNameNumberOfWorkButton() {
        return findNameNumberOfWorkButton;
    }
}
