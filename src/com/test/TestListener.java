package com.test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TestListener {

    private static JFrame frame;
    private static JPanel myPanel;
    private JButton button1;
    private JButton button2;

    public TestListener(){
        myPanel=new JPanel();
        button1=new JButton("Button1");
        button2=new JButton("Button2");
        SimpleListener ourListener=new SimpleListener();
        button1.addActionListener(ourListener);
        button2.addActionListener(ourListener);
        myPanel.add(button1);
        myPanel.add(button2);
        frame = new JFrame("TestListener");
        frame.getContentPane().add(myPanel);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        frame.pack();
        frame.setVisible(true);
    }

    private class SimpleListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String buttonName=e.getActionCommand();
            if (buttonName.equals("Button1")){
                JOptionPane.showMessageDialog(frame,"button1 was clicked");
            }else if(buttonName.equals("Button2")){
                JOptionPane.showMessageDialog(frame,"button2 was clicked");
            }else{
                JOptionPane.showMessageDialog(frame, "Unknown Event!");
            }
        }
    }

}
