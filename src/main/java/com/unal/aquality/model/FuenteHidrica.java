package com.unal.aquality.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJson;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "WaterResources")
public class FuenteHidrica {

    @Id
    private ObjectId id;
    private String name;
    private GeoJson coordinates;
    private Valoracion valoracion;

    public FuenteHidrica(String name, GeoJson geoJson, Valoracion valoracion) {
        this.name = name;
        this.coordinates = geoJson;
        this.valoracion = valoracion;
    }

    // ObjectId needs to be converted to string
    public String getId() {
        return id.toHexString();
    }

    public void setId(ObjectId id) {
        this.id = id;
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
