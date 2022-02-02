package com.baeldung.web;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE e.firstName = ?1")
    List<Employee> findEmployeeByNameWithQuery(String name);

    List<Employee> findEmployeeByFirstName(String name);
}
