package com.etiya.ecommercedemopair2.business.concretes;

import com.etiya.ecommercedemopair2.business.abstracts.DistrictService;
import com.etiya.ecommercedemopair2.business.dtos.request.district.AddDistrictRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.district.AddDistrictResponse;
import com.etiya.ecommercedemopair2.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair2.core.util.results.DataResult;
import com.etiya.ecommercedemopair2.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair2.entities.concretes.District;
import com.etiya.ecommercedemopair2.repository.abstracts.DistrictRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DistrictManager implements DistrictService {

    private DistrictRepository districtRepository;
    private ModelMapperService modelMapperService;
    @Override
    public DataResult<AddDistrictResponse> addDistrict(AddDistrictRequest addDistrictRequest) {

        District district =modelMapperService.forRequest().map(addDistrictRequest,District.class);
        District savedDistrict = districtRepository.save(district);

        AddDistrictResponse response=
                modelMapperService.forResponse().map(savedDistrict,AddDistrictResponse.class);
        return new SuccessDataResult<AddDistrictResponse>(response,"İlçe eklendi.");
    }

    @Override
    public DataResult<District> getById(int id) {
        return new SuccessDataResult<District>
                (this.districtRepository.findById(id).orElseThrow(),"Id'ye göre listelendi.");

    }
}
