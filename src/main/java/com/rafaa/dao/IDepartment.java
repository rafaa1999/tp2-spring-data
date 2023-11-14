package com.rafaa.dao;

import com.rafaa.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepartment extends JpaRepository<Department,Integer> {
}
