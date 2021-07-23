package com.unal.aquality.controller;

import com.unal.aquality.controller.dto.WaterSrcDto;
import com.unal.aquality.model.FuenteHidrica;
import com.unal.aquality.model.User;
import com.unal.aquality.service.UserService;
import com.unal.aquality.service.WatersrcService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/watersource")
public class FuenteController {

    private final WatersrcService watersrcService;
    @Autowired
    public FuenteController(WatersrcService watersrcService){
        this.watersrcService = watersrcService;
    }

    @Autowired
    UserService userService;
    @GetMapping()
    public ResponseEntity<?> getFuente(@RequestParam String name){
        Map<String, Object> res = new HashMap<>();
        FuenteHidrica fuenteHidrica = watersrcService.getFuente(name);
        res.put("fuente", fuenteHidrica);
        if(fuenteHidrica == null){
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
    }
    @GetMapping("/list")
    public ResponseEntity<?> map() throws Exception {
        Map<String, Object> res = new HashMap<>();
        List<FuenteHidrica> fuenteHidricaList = watersrcService.listWaterSrc();
        res.put("fuente", fuenteHidricaList);
        if(fuenteHidricaList == null){
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
    }
    @GetMapping("/adminWaterSrc")
    public String list(Model  model) throws Exception {
        List<FuenteHidrica> fuenteHidricaList = watersrcService.listWaterSrc();
        System.out.println(fuenteHidricaList.get(0).getValoracion().getpH().get(fuenteHidricaList.get(0).getValoracion().getpH().size() - 1));
        model.addAttribute("fuentes",fuenteHidricaList);
        return "adminWaterSrc";
    }
    @PostMapping("/{id}")
    public String delete(@RequestParam()ObjectId id){
        ObjectId objectId =  watersrcService.deleteWaterSrc(id);
        if(objectId == null){
            return "redirect:/watersource/adminWaterSrc?error";
        }else{
            return "redirect:/watersource/adminWaterSrc?success";
        }
    }
    @DeleteMapping("/{id}")
    public String del(@RequestParam()ObjectId id){
        ObjectId objectId =  watersrcService.deleteWaterSrc(id);
        if(objectId == null){
            return "redirect:/adminWaterSrc?error";
        }else{
            return "redirect:/adminWaterSrc?success";
        }
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody WaterSrcDto waterSrcDto) throws Exception{
        Map<String, Object> res = new HashMap<>();
        FuenteHidrica fuenteHidrica = watersrcService.registerWaterSrc(waterSrcDto);
        res.put("fuente", fuenteHidrica);
        if(fuenteHidrica == null){
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
    }
    @PutMapping("/update")
    public String update(@ModelAttribute("waterSrc")WaterSrcDto waterSrcDto) throws Exception {
        FuenteHidrica fuenteHidrica = watersrcService.updateWaterSrc(waterSrcDto);
        return fuenteHidrica.getId();
    }

    @ModelAttribute("waterSrc")
    public WaterSrcDto waterSrcDto(){
        return new WaterSrcDto();
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
}
