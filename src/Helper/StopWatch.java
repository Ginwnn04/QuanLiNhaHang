/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

/**
 *
 * @author DELL
 */
public class StopWatch {
    private long start;

    private static StopWatch instance = null;
    
    public static StopWatch getInstance() {
        if (instance == null) {
            instance = new StopWatch();
        }
        return instance;
    }
    
    public void Start(){
        start = System.currentTimeMillis();
    }
    
    public void Stop(){
        long end = System.currentTimeMillis(); 
        long elapsedTime = end - start; 
        System.out.println("Thời gian chạy: " + elapsedTime + " milliseconds");
        start = 0;
    }
    
}
