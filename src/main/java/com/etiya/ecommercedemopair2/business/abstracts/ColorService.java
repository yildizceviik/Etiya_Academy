package com.etiya.ecommercedemopair2.business.abstracts;

import com.etiya.ecommercedemopair2.business.dtos.request.color.AddColorRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.color.AddColorResponse;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.entities.concretes.Color;

public interface ColorService {
    DataResult<AddColorResponse> addColor (AddColorRequest addColorRequest);

    DataResult<Color> getById(int id);
}
