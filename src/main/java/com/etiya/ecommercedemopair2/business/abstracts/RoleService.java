package com.etiya.ecommercedemopair2.business.abstracts;

import com.etiya.ecommercedemopair2.business.dtos.request.role.AddRoleRequest;
import com.etiya.ecommercedemopair2.business.dtos.response.role.AddRoleResponse;
import com.etiya.ecommercedemopair2.entities.concretes.Country;
import com.etiya.ecommercedemopair2.entities.concretes.Role;

public interface RoleService {
    AddRoleResponse addRole (AddRoleRequest addRoleRequest);

    Role getById(int id);
}
