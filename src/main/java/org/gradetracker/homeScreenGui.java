package org.gradetracker;

import javax.security.auth.Subject;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class homeScreenGui extends AppController {
    private JPanel mainPan;
    private JButton addSub;
    private JPanel addSubPan;
    private JButton deleteButton;

    public ArrayList<JButton> subjectButtons = new ArrayList<>();


    homeScreenGui() {

        loadComponents(getClassData());
        addBtnListeners();
    }

    public void loadComponents(List<List<String>> classList) {

        frame.setContentPane(mainPan);

        JPanel classesPanel = new JPanel();
        classesPanel.setLayout(new GridLayout(3, 3, 15, 15));
        classesPanel.setBorder(BorderFactory.createEmptyBorder(20, 3, 3, 3));


        for (List<String> strings : classList) {

            JPanel i = new JPanel();
            i.setLayout(new GridLayout(3, 1));

            JButton newBtn = new JButton(strings.get(0));

            subjectButtons.add(newBtn);
            i.add(newBtn);

            JLabel x = new JLabel(strings.get(1));
            x.setHorizontalAlignment(JLabel.CENTER);
            i.add(x);

            JLabel y = new JLabel(strings.get(2));
            y.setHorizontalAlignment(JLabel.CENTER);
            i.add(y);

            classesPanel.add(i, BorderLayout.CENTER);

        }
        frame.add(classesPanel);
        frame.pack();
    }

    public void addBtnListeners() {
        addSub.addActionListener(e -> {
            removeAllCom();
            createAddSubScreenGui();
        });

        if (subjectButtons.size() > 0) {

            deleteButton.addActionListener(e -> {
                removeAllCom();
                createDeleteSubjectScreenGui();

            });

        } else {
            deleteButton.setEnabled(false);
        }

        for(JButton btn: subjectButtons){
            btn.addActionListener(e ->{
                removeAllCom();
                createSubjectTracker(subjectButtons.indexOf(btn));
            });
        }


    }


}