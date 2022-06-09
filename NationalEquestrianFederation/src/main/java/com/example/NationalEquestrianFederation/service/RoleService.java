package com.example.NationalEquestrianFederation.service;

import com.example.NationalEquestrianFederation.iservice.IRoleService;
import com.example.NationalEquestrianFederation.model.Role;
import com.example.NationalEquestrianFederation.repository.IRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService implements IRoleService {

    private IRoleRepository roleRepository;

    @Override
    public Role getByName(String name) {
        return  roleRepository.findByName(name);
    }

}
