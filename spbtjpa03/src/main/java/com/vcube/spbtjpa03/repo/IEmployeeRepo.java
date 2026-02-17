package com.vcube.spbtjpa03.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcube.spbtjpa03.model.Employee;

@Repository
public interface IEmployeeRepo extends JpaRepository<Employee,Integer>{
   public abstract Employee findByFirstname(String firstname);
}
