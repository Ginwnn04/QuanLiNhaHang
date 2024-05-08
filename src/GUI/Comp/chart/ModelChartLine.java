/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.Comp.chart;

public class ModelChartLine {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public ModelChartLine(String name, long value) {
        this.name = name;
        this.value = value;
    }

    public ModelChartLine() {
    }

    private String name;
    private long value;
}
