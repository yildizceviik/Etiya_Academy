package com.etiya.ecommercedemopair2.business.abstracts;

import com.etiya.ecommercedemopair2.business.dtos.request.color.AddColorRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.color.AddColorResponse;
import com.etiya.ecommercedemopair2.entities.concretes.Color;

public interface ColorService {
    AddColorResponse addColor (AddColorRequest addColorRequest);

    Color getById(int id);
}
