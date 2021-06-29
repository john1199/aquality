package com.unal.aquality.controller.dto;

import com.unal.aquality.model.Valoracion;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.geo.GeoJson;

public class WaterSrcDto {

    private ObjectId _id;
    private String name;
    private GeoJson coordinates;
    private Valoracion valoracion;

    public WaterSrcDto(String name, GeoJson geoJson, Valoracion valoracion) {
        this.name = name;
        this.coordinates = geoJson;
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

    public Valoracion getValoracion() {
        return valoracion;
    }

    public void setValoracion(Valoracion valoracion) {
        this.valoracion = valoracion;
    }
}
