package com.abhi.CRM.Mapper;

import com.abhi.CRM.Dtos.CustomerDto.CustomerEntryDto;
import com.abhi.CRM.Model.CustomerEntity;

public class CustomerMapper {
    public static CustomerEntity toCustomerEntity(CustomerEntryDto customerEntryDto){
        CustomerEntity customerEntity = getCustomerEntity(customerEntryDto);
        return customerEntity;
    }

    private static CustomerEntity getCustomerEntity(CustomerEntryDto customerEntryDto) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(customerEntryDto.getName());
        customerEntity.setAddress(customerEntryDto.getAddress());
        customerEntity.setMobile(customerEntryDto.getMobile());
        customerEntity.setTitle(customerEntryDto.getTitle());


        return customerEntity;
    }

    public static CustomerEntryDto toCustomerEntryDto(CustomerEntity customerEntity){
        CustomerEntryDto customerEntryDto = getCustomerEntryDto(customerEntity);

        //here add ids and down there changes ids to names
        return customerEntryDto;
    }

    private static CustomerEntryDto getCustomerEntryDto(CustomerEntity customerEntity) {
        CustomerEntryDto customerEntryDto = new CustomerEntryDto();
        customerEntryDto.setName(customerEntity.getName());
        customerEntryDto.setAddress(customerEntity.getAddress());
        customerEntryDto.setMobile(customerEntity.getMobile());
        customerEntryDto.setTitle(customerEntity.getTitle());
        customerEntryDto.setStateCode(customerEntity.getCity().getState().getCode());
        customerEntryDto.setCityId(customerEntity.getCity().getCityId());
        customerEntryDto.setAreaId(customerEntity.getArea().getAreaId());
        return customerEntryDto;
    }
}
