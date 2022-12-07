package com.etiya.ecommercedemopair2.business.concretes;

import com.etiya.ecommercedemopair2.business.abstracts.RoleService;
import com.etiya.ecommercedemopair2.business.dtos.request.role.AddRoleRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.role.AddRoleResponse;
import com.etiya.ecommercedemopair2.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair2.entities.concretes.Role;
import com.etiya.ecommercedemopair2.repository.abstracts.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleManager implements RoleService {
    private RoleRepository roleRepository;
    private ModelMapperService modelMapperService;
    @Override
    public AddRoleResponse addRole(AddRoleRequest addRoleRequest) {
        Role role=modelMapperService.getMapper().map(addRoleRequest,Role.class);

        Role savedRole =roleRepository.save(role);

        AddRoleResponse response=
                modelMapperService.getMapper().map(savedRole,AddRoleResponse.class);
        return response;
    }

    @Override
    public Role getById(int id) {
        return this.roleRepository.findById(id).orElseThrow();
    }
}
