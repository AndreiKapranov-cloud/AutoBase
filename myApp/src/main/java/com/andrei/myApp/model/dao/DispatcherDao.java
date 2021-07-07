package com.andrei.myApp.model.dao;

import com.andrei.myApp.model.entity.Dispatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DispatcherDao extends JpaRepository<Dispatcher,Long> {

}
