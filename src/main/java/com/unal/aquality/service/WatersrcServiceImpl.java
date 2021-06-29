package com.unal.aquality.service;

import com.unal.aquality.controller.dto.WaterSrcDto;
import com.unal.aquality.model.FuenteHidrica;
import com.unal.aquality.repository.WaterSrcRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
public class WatersrcServiceImpl implements WatersrcService{

    private WaterSrcRepository waterSrcRepository;
    public WatersrcServiceImpl(WaterSrcRepository waterSrcRepository){
        super();
        this.waterSrcRepository = waterSrcRepository;
    }
    @Override
    public FuenteHidrica listWaterSrc() throws Exception {
        return null;
    }

    @Override
    public FuenteHidrica registerWaterSrc(WaterSrcDto waterSrcDto) throws Exception {
        if(waterSrcRepository.findByname(waterSrcDto.getName()) == null){
            FuenteHidrica fuenteHidrica = new FuenteHidrica(waterSrcDto.getName(),waterSrcDto.getGeoJson(),waterSrcDto.getValoracion());
            return waterSrcRepository.save(fuenteHidrica);
        }else {
            return null;
        }
    }

    @Override
    public FuenteHidrica updateWaterSrc(WaterSrcDto waterSrcDto) throws Exception {
        return null;
    }

    @Override
    public ObjectId deleteWaterSrc(ObjectId id) {
        return null;
    }
}
