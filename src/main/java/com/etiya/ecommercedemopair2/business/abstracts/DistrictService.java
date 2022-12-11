package com.etiya.ecommercedemopair2.business.abstracts;

import com.etiya.ecommercedemopair2.business.dtos.request.district.AddDistrictRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.district.AddDistrictResponse;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.entities.concretes.District;

public interface DistrictService {

    DataResult<AddDistrictResponse> addDistrict (AddDistrictRequest addDistrictRequest);

    DataResult<District> getById(int id);
}
