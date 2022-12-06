package com.etiya.ecommercedemopair2.business.concretes;

import com.etiya.ecommercedemopair2.business.abstracts.RoleService;
import com.etiya.ecommercedemopair2.business.abstracts.ShipperService;
import com.etiya.ecommercedemopair2.business.dtos.request.shipper.AddShipperRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.shipper.AddShipperResponse;
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

    @Override
    public AddShipperResponse addShipper(AddShipperRequest addShipperRequest) {
        Shipper shipper = new Shipper();

        shipper.setCompany_name(addShipperRequest.getCompany_name());
        shipper.setPhone_number(addShipperRequest.getPhone_number());
        Role role = roleService.getById(addShipperRequest.getRole_id());
        shipper.setRole(role);

        Shipper savedShipper = shipperRepository.save(shipper);

        AddShipperResponse response =
                new AddShipperResponse(savedShipper.getId(), savedShipper.getCompany_name(), savedShipper.getPhone_number(),savedShipper.getRole().getId());

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
