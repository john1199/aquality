package com.unal.aquality.controller.dto;

import java.util.ArrayList;

public class ValoracionDto {

    private Double pH;
    private Double conductivity;
    private Double temperature;
    private Double turbidity;
    private Double depth;

    public ValoracionDto() {
    }

    public ValoracionDto(double pH, double conductivity, double temperature, double turbidity, double depth) {
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

    public double getTurbidity() {
        return turbidity;
    }

    public void setTurbidity(double turbidity) {
        this.turbidity = turbidity;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }
}
