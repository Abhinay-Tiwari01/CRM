package com.abhi.CRM.Services;

import com.abhi.CRM.Dtos.CustomerDto.CustomerEntryDto;
import com.abhi.CRM.Mapper.CustomerMapper;
import com.abhi.CRM.Model.AreaEntity;
import com.abhi.CRM.Model.CityEntity;
import com.abhi.CRM.Model.CustomerEntity;
import com.abhi.CRM.Model.StateEntity;
import com.abhi.CRM.Repository.AreaRepo;
import com.abhi.CRM.Repository.CityRepo;
import com.abhi.CRM.Repository.CustomerRepo;
import com.abhi.CRM.Repository.StateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {


    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    StateRepo stateRepo;
    @Autowired
    CityRepo cityRepo;
    @Autowired
    AreaRepo areaRepo;

    public CustomerEntryDto createCustomer(CustomerEntryDto customerEntryDto){
        CustomerEntity customerEntity = CustomerMapper.toCustomerEntity(customerEntryDto);

        StateEntity state = stateRepo.findById(customerEntryDto.getStateCode())
                .orElseThrow(() -> new RuntimeException("Invalid state code"));

        CityEntity city = cityRepo.findById(customerEntryDto.getCityId())
                .orElseThrow(() -> new RuntimeException("Invalid city id"));

        AreaEntity area = areaRepo.findById(customerEntryDto.getAreaId())
                .orElseThrow(() -> new RuntimeException("Invalid area id"));

        CustomerEntity savedCustomer = customerRepo.save(customerEntity);
        System.out.println("hello from create customer services");
        return CustomerMapper.toCustomerEntryDto(savedCustomer);

    }



}
