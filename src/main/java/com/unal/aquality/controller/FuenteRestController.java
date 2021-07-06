package com.unal.aquality.controller;

import com.unal.aquality.controller.dto.WaterSrcDto;
import com.unal.aquality.model.FuenteHidrica;
import com.unal.aquality.service.WatersrcService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/watersource")
public class FuenteRestController {
    private final WatersrcService watersrcService;
    @Autowired
    public FuenteRestController(WatersrcService watersrcService){
        this.watersrcService = watersrcService;
    }
/*
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody WaterSrcDto waterSrcDto) throws Exception{
        System.out.println(waterSrcDto.getName());
        System.out.println(waterSrcDto.getValoracion());
        Map<String, Object> res = new HashMap<>();
        FuenteHidrica fuenteHidrica = watersrcService.registerWaterSrc(waterSrcDto);
        res.put("fuente", fuenteHidrica);
        if(fuenteHidrica == null){
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
    }
*/
    @DeleteMapping("source/{id}")
    public ResponseEntity<?> delete(@RequestParam() ObjectId id) throws Exception{
        ObjectId id_ = watersrcService.deleteWaterSrc(id);
        Map<String, Object> res = new HashMap<>();
        if(id_ == null){
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
    }
}
