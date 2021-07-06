package com.unal.aquality.model;

import java.util.ArrayList;

public class Valoracion {

    private ArrayList<Double> pH;
    private ArrayList<Double> conductivity;
    private ArrayList<Double> temperature;
    private ArrayList<Double> turbidity;
    private ArrayList<Double> depth;

    public Valoracion() {
    }

    public Valoracion(ArrayList<Double> pH, ArrayList<Double> conductivity, ArrayList<Double> temperature, ArrayList<Double> turbidity, ArrayList<Double> depth) {
        this.pH = pH;
        this.conductivity = conductivity;
        this.temperature = temperature;
        this.turbidity = turbidity;
        this.depth = depth;
    }

    public ArrayList<Double> getpH() {
        return pH;
    }

    public void setpH(ArrayList<Double> pH) {
        this.pH = pH;
    }

    public ArrayList<Double> getConductivity() {
        return conductivity;
    }

    public void setConductivity(ArrayList<Double> conductivity) {
        this.conductivity = conductivity;
    }

    public ArrayList<Double> getTemperature() {
        return temperature;
    }

    public void setTemperature(ArrayList<Double> temperature) {
        this.temperature = temperature;
    }

    public ArrayList<Double> getTurbidity() {
        return turbidity;
    }

    public void setTurbidity(ArrayList<Double> turbidity) {
        this.turbidity = turbidity;
    }

    public ArrayList<Double> getDepth() {
        return depth;
    }

    public void setDepth(ArrayList<Double> depth) {
        this.depth = depth;
    }
}
