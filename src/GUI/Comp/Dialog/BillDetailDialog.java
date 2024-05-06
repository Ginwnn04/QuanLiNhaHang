/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.Comp.Dialog;

/**
 *
 * @author Tai
 */
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class BillDetailDialog extends JDialog {
    public BillDetailDialog(JFrame parent, String title, String detailInfo) {
        super(parent, title, true);
        JTextArea textArea = new JTextArea(detailInfo);
        textArea.setEditable(false);
        add(textArea);
        pack();
        setLocationRelativeTo(parent);
    }
}