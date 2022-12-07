package com.etiya.ecommercedemopair2.core.util.mapping;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService{

    private ModelMapper modelMapper;

    @Override
    public ModelMapper getMapper() {

        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)//birden fazla aynı alana gelirse bunu ignore et
                .setMatchingStrategy(MatchingStrategies.STANDARD);

        return this.modelMapper;
    }

    //Request ve Response için configurationlar değişebilir
    //TODO: iki fonk oluştur. forRequest,forResponse request ve response için configürasyon yapıp
    //model mappperi
}
