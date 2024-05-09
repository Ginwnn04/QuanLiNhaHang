package GUI.Comp.chart;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class TableHeader extends JLabel {

    public TableHeader(String text) {
        super(text);
        setOpaque(false);
        setBackground(new Color(250, 250, 250));
        setFont(new java.awt.Font("sansserif", 1, 13));
        setForeground(new Color(102, 102, 102));
        setBorder(new EmptyBorder(10, 5, 10, 5));
    }
}
