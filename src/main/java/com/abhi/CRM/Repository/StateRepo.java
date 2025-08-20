package com.abhi.CRM.Repository;

import com.abhi.CRM.Model.LocationEntites.StateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepo extends JpaRepository<StateEntity,Integer> {
}
