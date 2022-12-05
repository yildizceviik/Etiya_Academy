package com.etiya.ecommercedemopair2.business.concretes;

import com.etiya.ecommercedemopair2.business.abstracts.DistrictService;
import com.etiya.ecommercedemopair2.business.dtos.request.district.AddDistrictRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.district.AddDistrictResponse;
import com.etiya.ecommercedemopair2.entities.concretes.District;
import com.etiya.ecommercedemopair2.repository.abstracts.DistrictRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DistrictManager implements DistrictService {

    private DistrictRepository districtRepository;
    @Override
    public AddDistrictResponse addDistrict(AddDistrictRequest addDistrictRequest) {
        District district =new District();
        district.setDistrict_name(addDistrictRequest.getDistrict_name());

        District savedDistrict = districtRepository.save(district);

        AddDistrictResponse response=
                new AddDistrictResponse(savedDistrict.getId(),savedDistrict.getDistrict_name());
        return response;
    }

    @Override
    public District getById(int id) {
        return this.districtRepository.findById(id).orElseThrow();
    }
}
