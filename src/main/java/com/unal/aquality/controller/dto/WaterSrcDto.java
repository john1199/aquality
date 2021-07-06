package com.unal.aquality.controller.dto;

import com.unal.aquality.model.Valoracion;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.geo.GeoJson;

public class WaterSrcDto {

    private ObjectId _id;
    private String name;
    private GeoJson coordinates;
    private ValoracionDto valoracion;

    public WaterSrcDto() {
    }

    public WaterSrcDto(String name, ValoracionDto valoracion) {
        this.name = name;
        this.valoracion = valoracion;
    }
    // ObjectId needs to be converted to string
    public String getId() {
        return _id.toHexString();
    }

    public void setId(ObjectId id) {
        this._id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GeoJson getGeoJson() {
        return coordinates;
    }

    public void setGeoJson(GeoJson geoJson) {
        this.coordinates = geoJson;
    }

    public ValoracionDto getValoracion() {
        return valoracion;
    }

    public void setValoracion(ValoracionDto valoracion) {
        this.valoracion = valoracion;
    }
}
