package com.unal.aquality.service;

import com.unal.aquality.controller.dto.WaterSrcDto;
import com.unal.aquality.model.FuenteHidrica;
import com.unal.aquality.model.User;
import com.unal.aquality.model.Valoracion;
import com.unal.aquality.repository.WaterSrcRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WatersrcServiceImpl implements WatersrcService{

    private WaterSrcRepository waterSrcRepository;
    public WatersrcServiceImpl(WaterSrcRepository waterSrcRepository){
        super();
        this.waterSrcRepository = waterSrcRepository;
    }

    @Override
    public List<FuenteHidrica> listWaterSrc() throws Exception {
        List<FuenteHidrica> fuenteHidricaList;
        fuenteHidricaList = waterSrcRepository.findAll();
        if (!fuenteHidricaList.isEmpty()){
            return fuenteHidricaList;
        }else {
            return null;
        }
    }
    @Override
    public FuenteHidrica getFuente(String name){
        FuenteHidrica fuenteHidrica = waterSrcRepository.findByname(name);
        return fuenteHidrica;
    }
    @Override
    public FuenteHidrica registerWaterSrc(WaterSrcDto waterSrcDto) throws Exception {
        FuenteHidrica fuenteHidrica = waterSrcRepository.findByname(waterSrcDto.getName());
        System.out.println(fuenteHidrica);
        if( fuenteHidrica != null){
            fuenteHidrica.getValoracion().getpH().add(waterSrcDto.getValoracion().getpH());
            fuenteHidrica.getValoracion().getConductivity().add(waterSrcDto.getValoracion().getConductivity());
            fuenteHidrica.getValoracion().getDepth().add(waterSrcDto.getValoracion().getDepth());
            fuenteHidrica.getValoracion().getTemperature().add(waterSrcDto.getValoracion().getTemperature());
            fuenteHidrica.getValoracion().getTurbidity().add(waterSrcDto.getValoracion().getTurbidity());
            return waterSrcRepository.save(fuenteHidrica);
        }else{
            Valoracion valoracion =  new Valoracion(waterSrcDto.getValoracion().getpH(),waterSrcDto.getValoracion().getConductivity(),waterSrcDto.getValoracion().getTemperature(),waterSrcDto.getValoracion().getTurbidity(),waterSrcDto.getValoracion().getDepth());
            fuenteHidrica = new FuenteHidrica(waterSrcDto.getName(),valoracion);
            return waterSrcRepository.save(fuenteHidrica);
        }
    }

    @Override
    public FuenteHidrica getWaterSrc(ObjectId userId){
        try{
            return waterSrcRepository.findBy_id(userId);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public FuenteHidrica updateWaterSrc(WaterSrcDto waterSrcDto){

        FuenteHidrica waterSrc = waterSrcRepository.findByname(waterSrcDto.getName());
        if(waterSrc != null){
            /*waterSrc.setName(waterSrcDto.getName());
            waterSrc.setValoracion(waterSrcDto.getValoracion());
            waterSrc.setGeoJson(waterSrcDto.getGeoJson());
            waterSrcRepository.save(waterSrc);
            return waterSrc;*/
        }
        return null;
    }

    @Override
    public ObjectId deleteWaterSrc(ObjectId waterSrcId) {
        if (getWaterSrc(waterSrcId) == null) {
            return null;
        } else {
            waterSrcRepository.deleteBy_id(waterSrcId);
            return waterSrcId;
        }
    }

}
