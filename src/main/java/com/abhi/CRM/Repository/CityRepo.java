package com.abhi.CRM.Repository;

import com.abhi.CRM.Model.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CityRepo extends JpaRepository<CityEntity,Integer> {
    List<CityEntity> findByStateCode(int stateCode);

    @Query("SELECT DISTINCT c FROM CityEntity c LEFT JOIN FETCH c.areaEntityList")
    List<CityEntity> findAllWithAreas();
}
