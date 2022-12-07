package com.etiya.ecommercedemopair2.business.concretes;

import com.etiya.ecommercedemopair2.business.abstracts.RoleService;
import com.etiya.ecommercedemopair2.business.abstracts.ShipperService;
import com.etiya.ecommercedemopair2.business.dtos.request.shipper.AddShipperRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.shipper.AddShipperResponse;
import com.etiya.ecommercedemopair2.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair2.entities.concretes.Role;
import com.etiya.ecommercedemopair2.entities.concretes.Shipper;
import com.etiya.ecommercedemopair2.repository.abstracts.ShipperRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShipperManager implements ShipperService {
    private ShipperRepository shipperRepository;

    private RoleService roleService;
    private ModelMapperService modelMapperService;

    @Override
    public AddShipperResponse addShipper(AddShipperRequest addShipperRequest) {
        Shipper shipper=modelMapperService.getMapper().map(addShipperRequest,Shipper.class);

        Shipper savedShipper = shipperRepository.save(shipper);

        AddShipperResponse response =
                modelMapperService.getMapper().map(savedShipper,AddShipperResponse.class);
        return response;
    }

    @Override
    public List<Shipper> getAll() {
        return shipperRepository.findAll();
    }

    @Override
    public Shipper getById(int id) {
        return shipperRepository.findById(id).orElseThrow();
    }
}
