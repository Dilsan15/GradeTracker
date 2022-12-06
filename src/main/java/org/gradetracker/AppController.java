package org.gradetracker;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class AppController {

    public static JFrame frame = new JFrame("Grade Tracker");
    public static DatabaseRetriever dataBase = new DatabaseRetriever();


    public void loadApp() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon iconImg = new ImageIcon("src/main/resources//appleLogo.png");
        frame.setIconImage(iconImg.getImage());
        frame.setMinimumSize(new Dimension(400, 200));
        frame.setVisible(true);
        createHomeScreenGui();

    }
    public void removeAllCom() {

        frame.getContentPane().removeAll();
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();

    }

    public void createHomeScreenGui() {

        new homeScreenGui();


    }
    public void createAddSubScreenGui(){
        new addSubScreenGui();
    }

    public void createDeleteSubjectScreenGui(){new deleteSubScreenGui();}

    public void createSubjectTracker(int btnNum){
        new courseTrackerGui(btnNum);
    }

    public List<List<String>> getClassData() {
        return dataBase.readSubject();

    }

    public void setClassData(List<String> textFieldData){
        dataBase.addSubject(textFieldData);
    }

    public void deleteSubjectData(String subjectName){
        dataBase.removeSubject(subjectName);
    }


}
