/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import java.text.SimpleDateFormat;

/**
 *
 * @author quang
 */
public class FormatDate {
    private static FormatDate instance;
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private FormatDate() {
    }

    public static FormatDate getInstance() {
        if (instance == null) {
            instance = new FormatDate();
        }
        return instance;
    }

    public SimpleDateFormat getFormat() {
        return format;
    }
    
    
    
}