package com.andrei.myapp.model.dao;

import com.andrei.myapp.model.entity.AutoBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoBaseDao extends JpaRepository<AutoBase,Long> {
    AutoBase getAutoBaseByNameOfOrganization(String nameOfOrganization);
    AutoBase getAutoBaseByAutoBaseId(Long autoBaseId);
}
