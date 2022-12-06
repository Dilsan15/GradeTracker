package org.gradetracker;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class addSubScreenGui extends AppController {

    private JTextField teacherField;
    private JTextField importanceField;
    private JTextField classField;
    private JButton backBtn;
    private JButton submitBtn;
    private JPanel mainPan;
    private JLabel classLabel;
    private JLabel importanceLabel;
    private JLabel teacherLabel;
    private JLabel warningLabel;

    public JTextField[] textFieldCom = new JTextField[]{classField, teacherField, importanceField};
    public List<String> textFieldText = new ArrayList<>();


    public addSubScreenGui() {
        loadCompenents();
        addBtnListeners();
    }

    public void loadCompenents() {
        frame.setContentPane(mainPan);
    }

    public void addBtnListeners() {
        backBtn.addActionListener(e -> {
            removeAllCom();
            createHomeScreenGui();

        });

        submitBtn.addActionListener(e -> {

            boolean sendData = true;
            int textFieldNum = 0;

            for (JTextField textField : textFieldCom) {
                System.out.println(textFieldNum);
                String text = textField.getText();

                if (text.matches(".*[a-zA-Z]+.*") && text.length() >= 2 && textFieldNum != 2){
                    textFieldText.add(textField.getText());
                    textField.setText("");



                } else if (text.matches(".*[1-9]+.*") && text.length() == 2){
                    textFieldText.add(textField.getText());
                    textField.setText("");


                } else{
                    warningLabel.setText("Please Enter Valid Input!");
                    sendData = false;

                    for (JTextField allTextField : textFieldCom) {
                        allTextField.setText("");
                    }
                    break;

                }

                textFieldNum +=1;

            }

            if (sendData){
                setClassData(textFieldText);
                textFieldText.clear();
            }


        });


    }
}