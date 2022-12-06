package org.gradetracker;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class deleteSubScreenGui extends AppController {

    private JPanel mainPan;
    private JPanel btnPanel;
    private JButton submitBtn;
    private JButton backBtn;

    public List<JCheckBox> checkBoxList = new ArrayList<>();

    public JPanel checkBoxPanel = new JPanel();

    deleteSubScreenGui(){
        loadComponents(getClassData());
        addListeners();


    }

    public void loadComponents(List<List<String>> subList){

        frame.setContentPane(mainPan);
        checkBoxPanel.setLayout(new FlowLayout());

        for (List<String> oneSubList : subList){
            JCheckBox i = new JCheckBox(oneSubList.get(0));
            checkBoxList.add(i);
            checkBoxPanel.add(i, BorderLayout.CENTER);
        }

        frame.add(checkBoxPanel);
        frame.pack();


    }

    public void addListeners(){
        backBtn.addActionListener(e -> {
            removeAllCom();
            createHomeScreenGui();
        });

        submitBtn.addActionListener(e -> {

            int numSelected = 0;

             for(JCheckBox checkBox : checkBoxList){
                if (checkBox.isSelected()){

                    deleteSubjectData(checkBox.getText());
                    checkBoxPanel.setVisible(false);
                    checkBoxPanel.remove(checkBox);
                    checkBoxPanel.updateUI();
                    numSelected +=1;

                    if (numSelected == checkBoxList.size()){
                        JLabel label = new JLabel("No More Classes");
                        label.setHorizontalAlignment(JLabel.CENTER);
                        label.setHorizontalTextPosition(JLabel.CENTER);

                        frame.add(label);
                        frame.revalidate();
                        frame.repaint();

                    }

                }

            }





        });

    }


}
