package com.company.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by alex o n 20.04.2017.
 */
public class RequestManager {
    private BufferedReader in;
    private PrintWriter out;
    public RequestManager(BufferedReader in, PrintWriter out){
        this.in=in;
        this.out=out;
    }
    public void AddNewStudentInBase(ArrayList<String> stringArrayList) throws IOException {
        out.println("ADD");
        for(int i=0;i<14;i++){
            out.println(stringArrayList.get(i));
        }
    }

    public ArrayList<String[]> getBasicPage() throws IOException {
        out.println("GET PAGE");
        return getPage();
    }

    private ArrayList<String[]> getPage() throws IOException{
        String fserver;
        if((fserver = in.readLine())!=""&&(fserver)!="\0"&&(fserver)!=null) {
            System.out.println(fserver+" -------");
        }
        int count = Integer.parseInt(fserver);
        System.out.println(count+" +++---");
        ArrayList<String[]> arrayListOfDatas = new ArrayList<>();
        int i=0;
        while (i<count){
            int schetchik=0;
            String[] tempMass=new String[14];
            while (schetchik<14)
                if((fserver = in.readLine())!=null){
                    tempMass[schetchik]=fserver;
                    //System.out.println(fserver+"           -");
                    schetchik++;
                }
            arrayListOfDatas.add(tempMass);
            i++;
        }
        return arrayListOfDatas;
    }
    public int deleteStudentByNameAndGropRequest(String name, String group) throws IOException {
        out.println("DELETE BY NAME & GROUP");
        out.println(name);
        out.println(group);
        String fserver;
        if((fserver = in.readLine())!=null) {
            System.out.println(fserver+" ------dffgdg-");
        }
        return Integer.parseInt(fserver);
    }
    public int deleteStudentByNameAndWorkRequest(String name, String work) throws IOException {
        out.println("DELETE BY NAME & WORK");
        out.println(name);
        out.println(work);
        String fserver;
        if((fserver = in.readLine())!=null) {
            System.out.println(fserver+" -----dfh--");
        }
        return Integer.parseInt(fserver);
    }
    public int deleteStudentByNameAndNumberOfWork(String name, String lowerLimit, String upperLimit) throws IOException {
        out.println("DELETE BY NAME & NUMBER OF WORKS");
        out.println(name);
        out.println(lowerLimit);
        out.println(upperLimit);
        String fserver;
        if((fserver = in.readLine())!=null) {
            System.out.println(fserver+" ------dhd-");
        }
        return Integer.parseInt(fserver);
    }

    public void saveRequest(String filename){
        out.println("SAVE");
        out.println(filename);
    }
    public void loadRequest(String filename){
        out.println("LOAD");
        out.println(filename);
    }
    public void nextPageRequest(){
        out.println("NEXT PAGE");
    }
    public void previousPageRequest(){
        out.println("PREVIOUS PAGE");
    }
    public void firstPageRequest(){
        out.println("FIRST PAGE");
    }
    public void lastPageRequest(){
        out.println("LAST PAGE");
    }
    public void closeFindVindowPageRequest(){
        out.println("CLOSE FIND");
    }

    public void findStudentByNameAndGropRequest(String name, String group) throws IOException {
        out.println("FIND BY NAME & GROUP");
        out.println(name);
        out.println(group);
    }
    public void findStudentByNameAndWorkRequest(String name, String work) throws IOException {
        out.println("FIND BY NAME & WORK");
        out.println(name);
        out.println(work);

    }
    public void findStudentByNameAndNumberOfWork(String name, String lowerLimit, String upperLimit) throws IOException {
        out.println("FIND BY NAME & NUMBER OF WORKS");
        out.println(name);
        out.println(lowerLimit);
        out.println(upperLimit);

    }
    public void endFindingRequest(){
        out.println("END FINDING");
    }
    /*
    public ArrayList<Student> findStudentByNameAndWork(String name, String studWork){
        ArrayList<Student> findStudentArrayList = new ArrayList<Student>();
        for(Student student: studentBase.getStudents()){
            if(student.getFirstName().equalsIgnoreCase(name))
            {
                for(String work:student.getPublicWork()){
                    if(work.equalsIgnoreCase(studWork)){
                    findStudentArrayList.add(student);
                    break;
                    }
                }
            }
        }
        return  findStudentArrayList;
    }

    public ArrayList<Student> findStudentByNameAndNumberOfWork(String name, String lowerLimit, String upperLimit){
        ArrayList<Student> findStudentArrayList = new ArrayList<Student>();
        for(Student student: studentBase.getStudents()){
            if(student.getFirstName().equalsIgnoreCase(name))
            {int coll=0;
                    ArrayList<String> workMassiv=new ArrayList<>();
                for(String string:student.getPublicWork())
                {   boolean bool=false;
                    for(String string2:workMassiv){
                        if(string.equalsIgnoreCase(string2))
                            bool=true;
                    }
                    if(!bool)
                    workMassiv.add(new String(string));
                }
                ///System.out.println(workMassiv.size());
                if(workMassiv.size()-1>=Integer.parseInt(lowerLimit)&&workMassiv.size()-1<=Integer.parseInt(upperLimit))
                    findStudentArrayList.add(student);
            }
        }
        return  findStudentArrayList;
    }
    public void deleteStudentByNameAndGrop(String name, String group){
        studentBase.removeStudents(findStudentByNameAndGrop(name,group));
        view.renderTable();
    }
    public void deleteStudentByNameAndWork(String name, String group){
        studentBase.removeStudents(findStudentByNameAndWork(name,group));
        view.renderTable();
    }
    public void deleteStudentByNameAndNumberOfWork(String name, String lowerLimit,String upperLimit){
        studentBase.removeStudents(findStudentByNameAndNumberOfWork(name,lowerLimit,upperLimit));
        view.renderTable();
    }*/

}
