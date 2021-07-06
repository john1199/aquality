package com.unal.aquality.controller;

import com.unal.aquality.controller.dto.UserDto;
import com.unal.aquality.controller.dto.WaterSrcDto;
import com.unal.aquality.model.FuenteHidrica;
import com.unal.aquality.model.User;
import com.unal.aquality.model.Valoracion;
import com.unal.aquality.repository.WaterSrcRepository;
import com.unal.aquality.service.WatersrcService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.GeoJson;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/watersource")
public class FuenteController {

    private final WatersrcService watersrcService;
    private List<WaterSrcDto> waterSrcDtoList;
    @Autowired
    public FuenteController(WatersrcService watersrcService){
        this.watersrcService = watersrcService;
    }

    @GetMapping("/map")
    public String list(Model  model) throws Exception {
        List<FuenteHidrica> fuenteHidricaList = watersrcService.listWaterSrc();
        model.addAttribute("fuentes",fuenteHidricaList);
        return "map";
    }

    @DeleteMapping("/{id}")
    public String delete(@RequestParam()ObjectId id){

        watersrcService.deleteWaterSrc(id);
        return "error";
    }

/*
    @PostMapping("/register")
    public String register(@ModelAttribute("waterSrc")WaterSrcDto waterSrcDto) throws Exception{
        FuenteHidrica fuenteHidrica = watersrcService.registerWaterSrc(waterSrcDto);
        if(fuenteHidrica == null){
            return "redirect:/registerWaterSrc?error";
        }else{
            return "redirect:/registerWaterSrc?success";
        }
    }
*/

    @PutMapping("/update")
    public String update(@ModelAttribute("waterSrc")WaterSrcDto waterSrcDto) throws Exception {
        FuenteHidrica fuenteHidrica = watersrcService.updateWaterSrc(waterSrcDto);
        return fuenteHidrica.getId();
    }

    @ModelAttribute("waterSrc")
    public WaterSrcDto waterSrcDto(){
        return new WaterSrcDto();
    }

}
