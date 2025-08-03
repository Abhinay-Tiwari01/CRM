package com.abhi.CRM.Repository;

import com.abhi.CRM.Model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepo extends JpaRepository<CustomerEntity,Integer> {
    @Query(value = "CALL GetCustomerFullViewById(:custId)", nativeQuery = true)
    List<Object[]> getCustomerFullViewById(Integer custId);
}
    