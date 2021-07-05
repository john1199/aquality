package com.unal.aquality.service;

import com.unal.aquality.controller.dto.WaterSrcDto;
import com.unal.aquality.model.FuenteHidrica;
import org.bson.types.ObjectId;

import java.util.List;

public interface WatersrcService {
    List<FuenteHidrica> listWaterSrc() throws Exception;
    FuenteHidrica registerWaterSrc(WaterSrcDto waterSrcDto) throws Exception;
    FuenteHidrica updateWaterSrc(WaterSrcDto waterSrcDto) throws Exception;
    ObjectId deleteWaterSrc(ObjectId id);
}
