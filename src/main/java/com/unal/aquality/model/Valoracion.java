package com.unal.aquality.model;

public class Valoracion {

    private double pH;
    private double conductivity;
    private double temperature;
    private double turbidity;
    private double depth;

    public Valoracion() {
    }

    public Valoracion(double pH, double conductivity, double temperature, double turbidity, double depth) {
        this.pH = pH;
        this.conductivity = conductivity;
        this.temperature = temperature;
        this.turbidity = turbidity;
        this.depth = depth;
    }

    public double getpH() {
        return pH;
    }

    public void setpH(double pH) {
        this.pH = pH;
    }

    public double getConductivity() {
        return conductivity;
    }

    public void setConductivity(double conductivity) {
        this.conductivity = conductivity;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public Double getTurbidity() {
        return turbidity;
    }

    public void setTurbidity(Double turbidity) {
        this.turbidity = turbidity;
    }

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }
}
