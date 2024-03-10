/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class JavaDynUI extends JFrame {
    private static JavaDynUI myFrame;
    private static int countMe = 0;
    private JPanel mainPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        myFrame = new JavaDynUI();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.prepareUI();
        myFrame.pack();
        myFrame.setVisible(true);
    }

    private void prepareUI() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());

        JButton buttonAdd = new JButton("Add subPanel");
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.add(new SubPanel());
                myFrame.pack();
            }
        });

        JButton buttonRemoveAll = new JButton("Remove All");
        buttonRemoveAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                myFrame.pack();
            }
        });

        getContentPane().add(mainPanel, BorderLayout.CENTER);
        getContentPane().add(buttonAdd, BorderLayout.PAGE_START);
        getContentPane().add(buttonRemoveAll, BorderLayout.PAGE_END);
    }

    private class SubPanel extends JPanel {
        private JLabel myLabel;
        private JSpinner mySpinner;

        public SubPanel() {
            super();
            myLabel = new JLabel("Hello SubPanel(): " + countMe++);
            mySpinner = new JSpinner(new SpinnerNumberModel(1, 0, Integer.MAX_VALUE, 1));

            mySpinner.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    int value = (int) mySpinner.getValue();
                    if (value == 0) {
                        // Xoá subPanel khi giá trị của Spinner về 0
                        removeThisSubPanel();
                    }
                }
            });

            JButton myButtonRemoveMe = new JButton("Remove me");
            myButtonRemoveMe.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    removeThisSubPanel();
                }
            });

            setLayout(new FlowLayout());
            add(myLabel);
            add(mySpinner);
            add(myButtonRemoveMe);
        }

        private void removeThisSubPanel() {
            mainPanel.remove(this);
            myFrame.pack();
        }
    }
}
