/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.Main;

import GUI.Comp.PanelConfirmOrder;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
    public class List<E> extends ArrayList<E>{

        public void isExists(String name) {
        for (int i = 0; i < size(); i++) {
            E element = get(i);
            if (element instanceof PanelConfirmOrder) {
                PanelConfirmOrder panel = (PanelConfirmOrder) element;
                if (panel.getName() != null && panel.getName().equals(name)) {
//                    System.out.println(panel.getName());
                    // return i; // Nếu muốn trả về index nếu tìm thấy
                }
            }
        }
        // return -1; // Nếu muốn trả về -1 nếu không tìm thấy
    }
    }
