package com.unal.aquality.service;

import com.unal.aquality.controller.dto.WaterSrcDto;
import com.unal.aquality.model.FuenteHidrica;
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
    public FuenteHidrica registerWaterSrc(WaterSrcDto waterSrcDto) throws Exception {
        if(waterSrcRepository.findByname(waterSrcDto.getName()) == null){
            Valoracion valoracion = new Valoracion(waterSrcDto.getValoracion().getpH(),waterSrcDto.getValoracion().getConductivity(),waterSrcDto.getValoracion().getTemperature(),waterSrcDto.getValoracion().getTurbidity(),waterSrcDto.getValoracion().getDepth());
            FuenteHidrica fuenteHidrica = new FuenteHidrica(waterSrcDto.getName(),valoracion);
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
