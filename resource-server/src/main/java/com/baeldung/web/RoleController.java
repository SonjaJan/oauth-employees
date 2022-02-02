package com.baeldung.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    public EmployeeRoleRepository repository;

    @GetMapping("/roles")
    public List<EmployeeRole> getAllRoles() {
        System.out.println("Getting all roles...");
        return repository.findAll();
    }

    @PostMapping("/roles/newrole")
    public void addRole(@RequestBody EmployeeRole employeeRole) {
        EmployeeRole empRole = EmployeeRole.builder().
                roleName(employeeRole.getRoleName()).
                projectName(employeeRole.getProjectName()).
                employee(employeeRole.getEmployee()).
                build();
        repository.save(empRole);
    }

    @PutMapping("/roles")
    public void updateEmployeeRole(@RequestBody EmployeeRole employeeRole) {
        EmployeeRole empRole = EmployeeRole.builder().
                roleId(employeeRole.getRoleId()).
                roleName(employeeRole.getRoleName()).
                projectName(employeeRole.getProjectName()).
                employee(employeeRole.getEmployee()).
                build();
        repository.save(empRole);
    }

    @DeleteMapping("/role/{id}")
    public void deleteEmployeeRole(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
