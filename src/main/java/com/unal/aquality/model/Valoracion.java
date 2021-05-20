package com.unal.aquality.model;

public class Valoracion {

    private Double pH;
    private Double conductivity;
    private Double temperature;
    private Double turbidity;
    private Double depth;

    public Valoracion(Double pH, Double conductivity, Double temperature, Double turbidity, Double depth) {
        this.pH = pH;
        this.conductivity = conductivity;
        this.temperature = temperature;
        this.turbidity = turbidity;
        this.depth = depth;
    }

    public Double getpH() {
        return pH;
    }

    public void setpH(Double pH) {
        this.pH = pH;
    }

    public Double getConductivity() {
        return conductivity;
    }

    public void setConductivity(Double conductivity) {
        this.conductivity = conductivity;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
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
