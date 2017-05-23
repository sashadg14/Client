package com.company;

import com.company.controllers.RequestManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by alex o n 11.04.2017.
 */
public class DeleteView {
    private RequestManager requestManager;
    private FindView findView;
    private View view;
    public DeleteView(RequestManager requestManager,View view){
        findView=new FindView(requestManager);
        this.requestManager=requestManager;
        this.view=view;

    }
    public void createDeleteWindow(){
           findView.createElementsOfWindow("Удаление");
           findView.getjDialog().setBounds(0, 0, 1600, 900);

           findView.getFindByNameAndGroupButton().addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent actionEvent) {
                   findView.removeElements();
                   findView.addFindByNameAndGroupElemens("Удаление",new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent actionEvent) {
                           try {
                               int count=requestManager.deleteStudentByNameAndGropRequest(findView.getFirstData().getText(), findView.getSecondData().getText());
                               JOptionPane.showMessageDialog(new JFrame(), "Записей найдено и удалено " + count);
                               findView.getjDialog().setVisible(false);
                               view.renderTable();
                           } catch (IOException e) {
                               e.printStackTrace();
                           }

                       }
                   });
               }
           });

       findView.getFindByNameAndWorkButton().addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent actionEvent) {
                   findView.removeElements();
                   findView.addFindByNameAndGroupElemens("Удаление",new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent actionEvent) {
                           try {
                               int count=requestManager.deleteStudentByNameAndWorkRequest(findView.getFirstData().getText(), findView.getSecondData().getText());
                               JOptionPane.showMessageDialog(new JFrame(), "Записей найдено и удалено " + count);
                               findView.getjDialog().setVisible(false);
                               view.renderTable();
                           } catch (IOException e) {
                               e.printStackTrace();
                           }

                       }
                   });
               }
           });

       findView.getFindByNameNumberOfWorkButton().addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent actionEvent) {
                   findView.removeElements();
                   findView.addFindByNameAndNumberOfWorkElemens("Удаление", new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent actionEvent) {
                           try {
                               int count=requestManager.deleteStudentByNameAndNumberOfWork(findView.getFirstData().getText(), findView.getSecondData().getText(),findView.getThirdData().getText());
                               JOptionPane.showMessageDialog(new JFrame(), "Записей найдено и удалено " + count);
                               findView.getjDialog().setVisible(false);
                               view.renderTable();
                           } catch (IOException e) {
                               e.printStackTrace();
                           }
                       }
                   });
               }
           });


    }

}
