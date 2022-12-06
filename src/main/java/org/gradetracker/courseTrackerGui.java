package org.gradetracker;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class courseTrackerGui extends AppController{

    private JLabel courseName;
    private JPanel mainPan;
    private JPanel courseInfo;


    courseTrackerGui(int btnNum){
        loadComponents(getClassData().get(btnNum));
    }

    private void loadComponents(List<String> courseData) {

        frame.setContentPane(mainPan);

        for(String s : courseData){
            courseInfo.add(new JLabel(courseData.get(0)));
        }


        frame.pack();

    }

}
