package com.unal.aquality.model;

import java.util.ArrayList;

public class Valoracion {

    private ArrayList<Double> pH = new ArrayList<>();
    private ArrayList<Double> conductivity= new ArrayList<>();
    private ArrayList<Double> temperature= new ArrayList<>();
    private ArrayList<Double> turbidity= new ArrayList<>();
    private ArrayList<Double> depth= new ArrayList<>();

    public Valoracion() {
    }

    public Valoracion(double pH, double conductivity, double temperature, double turbidity, double depth) {
        this.pH.add(pH);
        this.conductivity.add(conductivity);
        this.temperature.add(temperature);
        this.turbidity.add(turbidity);
        this.depth.add(depth);
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
