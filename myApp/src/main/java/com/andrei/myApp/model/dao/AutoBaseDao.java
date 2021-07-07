package com.andrei.myApp.model.dao;

import com.andrei.myApp.model.entity.AutoBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoBaseDao extends JpaRepository<AutoBase,Long> {
    AutoBase getAutoBaseByNameOfOrganization(String nameOfOrganization);
    AutoBase getAutoBaseByAutoBaseId(Long autoBaseId);
}
