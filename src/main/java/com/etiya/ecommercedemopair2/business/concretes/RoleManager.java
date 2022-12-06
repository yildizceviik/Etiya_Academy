package com.etiya.ecommercedemopair2.business.concretes;

import com.etiya.ecommercedemopair2.business.abstracts.RoleService;
import com.etiya.ecommercedemopair2.business.dtos.request.role.AddRoleRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.role.AddRoleResponse;
import com.etiya.ecommercedemopair2.entities.concretes.Role;
import com.etiya.ecommercedemopair2.repository.abstracts.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleManager implements RoleService {
    private RoleRepository roleRepository;
    @Override
    public AddRoleResponse addRole(AddRoleRequest addRoleRequest) {
        Role role =new Role();
        role.setRole_name(addRoleRequest.getRole_name());

        Role savedRole =roleRepository.save(role);

        AddRoleResponse response=
                new AddRoleResponse(savedRole.getId(),savedRole.getRole_name());
        return response;
    }

    @Override
    public Role getById(int id) {
        return this.roleRepository.findById(id).orElseThrow();
    }
}
