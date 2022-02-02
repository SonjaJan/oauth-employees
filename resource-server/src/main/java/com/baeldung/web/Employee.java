package com.baeldung.web;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;

    @JsonManagedReference
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EmployeeRole> roles = new ArrayList<EmployeeRole>();

    public Employee(Employee employee) {
        this.firstName = employee.firstName;
        this.lastName = employee.lastName;
    }

    public void addEmployeeRole(EmployeeRole employeeRole) {
        this.roles.add(employeeRole);
        employeeRole.setEmployee(this);
    }

    public void removeEmployeeRole(EmployeeRole employeeRole) {
        this.roles.remove(employeeRole);
        employeeRole.setEmployee(null);
    }

}
