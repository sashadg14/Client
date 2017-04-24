package com.company.controllers;

import com.company.model.Student;
import com.company.model.Table;

import java.util.ArrayList;

/**
 * Created by alex o n 23.04.2017.
 */
public class PageManipulator {
    private ArrayList<Student> studentArrayList;
    private int countOfStudentOnLists=5;
    private int noOfPage =0;
    private Table table;
    public PageManipulator(ArrayList<Student> studentArrayList, Table table){
        this.studentArrayList=studentArrayList;
        this.table=table;
    }
    public void setCountOfStudentOnLists(int countOfStudentOnLists) {
        this.countOfStudentOnLists = countOfStudentOnLists;
    }
    public ArrayList<Student> returnPageOfStudents(){
        ArrayList<Student> pageOfStudents= new ArrayList<Student>();
        //int countOfPages=(int)studentArrayList.size()/countOfStudentOnLists;
        //System.out.println(countOfPages+" count");
            for(int i = noOfPage *countOfStudentOnLists; i<(noOfPage +1)*countOfStudentOnLists&&i<studentArrayList.size(); i++)
                pageOfStudents.add(studentArrayList.get(i));
        return pageOfStudents;
    }
    public void NextPage() {
        if (countOfStudentOnLists*(noOfPage +1)<studentArrayList.size())
        {   noOfPage++;
            table.renderTable(returnPageOfStudents());
        }
    }
    public void PreviousPage(){
        if(noOfPage !=0){
            noOfPage--;
            table.renderTable(returnPageOfStudents());
        }
    }
    public void FirstPage(){
        noOfPage =0;
        table.renderTable(returnPageOfStudents());
    }
    public void LastPage(){
        int countOfPages=(int)studentArrayList.size()/countOfStudentOnLists;
        if (countOfStudentOnLists*(countOfPages)<studentArrayList.size())
        {   noOfPage =countOfPages;
       // System.out.println(countOfStudentOnLists*(countOfPages));
            table.renderTable(returnPageOfStudents());
        }
    }
}
