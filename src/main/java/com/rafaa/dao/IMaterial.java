package com.rafaa.dao;

import com.rafaa.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMaterial extends JpaRepository<Material,Integer> {
}
