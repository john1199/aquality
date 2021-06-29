package com.unal.aquality.controller;

import com.unal.aquality.controller.dto.WaterSrcDto;
import com.unal.aquality.model.FuenteHidrica;
import com.unal.aquality.service.WatersrcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.GeoJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/watersource")
public class FuenteController {
    @Autowired
    WatersrcService watersrcService;

    @PostMapping("/register")
    public String register(@ModelAttribute("waterSrc")WaterSrcDto waterSrcDto) throws Exception{
        waterSrcDto.setGeoJson((GeoJson)waterSrcDto.getGeoJson().getCoordinates());
        FuenteHidrica fuenteHidrica =  watersrcService.registerWaterSrc(waterSrcDto);
        System.out.println(fuenteHidrica);
        if(fuenteHidrica != null){
            return "login";
        }else{
            return "register";
        }
    }

}
