package com.abhi.CRM.Repository;

import com.abhi.CRM.Model.LocationEntites.AreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AreaRepo extends JpaRepository<AreaEntity,Integer> {
    List<AreaEntity> findByCity_CityId(Integer cityId);

}
