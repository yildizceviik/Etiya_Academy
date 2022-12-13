package com.etiya.ecommercedemopair2.repository.abstracts;

import com.etiya.ecommercedemopair2.business.dtos.response.district.ListDistrictResponse;
import com.etiya.ecommercedemopair2.business.dtos.response.product.ListProductResponse;
import com.etiya.ecommercedemopair2.entities.concretes.District;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DistrictRepository extends JpaRepository<District,Integer> {
    @Query("Select new com.etiya.ecommercedemopair2.business.dtos.response.district.ListProductResponse(p.id,p.districtName) from District as p")
    Page<ListDistrictResponse> getAllListDistrict(Pageable pageable);
}
