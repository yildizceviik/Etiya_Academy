package com.etiya.ecommercedemopair2.business.concretes;

import com.etiya.ecommercedemopair2.business.abstracts.ColorService;
import com.etiya.ecommercedemopair2.business.dtos.request.color.AddColorRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.color.AddColorResponse;
import com.etiya.ecommercedemopair2.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair2.entities.concretes.Color;
import com.etiya.ecommercedemopair2.repository.abstracts.ColorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService {
    private ColorRepository colorRepository;
    private ModelMapperService modelMapperService;

    @Override
    public AddColorResponse addColor(AddColorRequest addColorRequest) {

        Color color=modelMapperService.getMapper().map(addColorRequest,Color.class);
        Color savedColor =colorRepository.save(color);

        AddColorResponse response =
                modelMapperService.getMapper().map(savedColor,AddColorResponse.class);
        return response;
    }

    @Override
    public Color getById(int id) {
        return colorRepository.findById(id).orElseThrow();
    }
}
