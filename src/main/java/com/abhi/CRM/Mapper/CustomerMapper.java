package com.abhi.CRM.Mapper;

import com.abhi.CRM.Dtos.CustomerDto.CustomerEntryDto;
import com.abhi.CRM.Dtos.CustomerDto.CustomerResponseDto;
import com.abhi.CRM.Model.EntryEntites.CustomerEntity;

public class CustomerMapper {
    public static CustomerEntity toCustomerEntity(CustomerEntryDto customerEntryDto){
//        CustomerEntity customerEntity = getCustomerEntity(customerEntryDto);
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(customerEntryDto.getName());
        customerEntity.setAddress(customerEntryDto.getAddress());
        customerEntity.setMobile(customerEntryDto.getMobile());
        customerEntity.setTitle(customerEntryDto.getTitle());
        return customerEntity;
    }

//    private static CustomerEntity getCustomerEntity(CustomerEntryDto customerEntryDto) {
//        CustomerEntity customerEntity = new CustomerEntity();
//        customerEntity.setName(customerEntryDto.getName());
//        customerEntity.setAddress(customerEntryDto.getAddress());
//        customerEntity.setMobile(customerEntryDto.getMobile());
//        customerEntity.setTitle(customerEntryDto.getTitle());
//        return customerEntity;
//    }

    public static CustomerEntryDto toCustomerEntryDto(CustomerEntity customerEntity){
//        CustomerEntryDto customerEntryDto = getCustomerEntryDto(customerEntity);
        CustomerEntryDto customerEntryDto = new CustomerEntryDto();
        customerEntryDto.setId(customerEntity.getId());
        customerEntryDto.setName(customerEntity.getName());
        customerEntryDto.setAddress(customerEntity.getAddress());
        customerEntryDto.setMobile(customerEntity.getMobile());
        customerEntryDto.setTitle(customerEntity.getTitle());
        customerEntryDto.setCityId(customerEntity.getCity().getCityId());
        customerEntryDto.setAreaId(customerEntity.getArea().getAreaId());
        customerEntryDto.setStateCode(customerEntity.getState().getCode());
        //here add ids and down there changes ids to names
        return customerEntryDto;
    }

//    private static CustomerEntryDto getCustomerEntryDto(CustomerEntity customerEntity) {
//        CustomerEntryDto customerEntryDto = new CustomerEntryDto();
//        customerEntryDto.setName(customerEntity.getName());
//        customerEntryDto.setAddress(customerEntity.getAddress());
//        customerEntryDto.setMobile(customerEntity.getMobile());
//        customerEntryDto.setTitle(customerEntity.getTitle());
//        customerEntryDto.setStateCode(customerEntity.getCity().getState().getCode());
//        customerEntryDto.setCityId(customerEntity.getCity().getCityId());
//        customerEntryDto.setAreaId(customerEntity.getArea().getAreaId());
//        return customerEntryDto;
//    }

    public static CustomerResponseDto toCustomerResponseDto(CustomerEntity customerEntity)
    {
        CustomerResponseDto customerResponseDto = new CustomerResponseDto();
        customerResponseDto.setId(customerEntity.getId());
        customerResponseDto.setName(customerEntity.getName());
        customerResponseDto.setTitle(customerEntity.getTitle());
        customerResponseDto.setAddress(customerEntity.getAddress());
        customerResponseDto.setMobile(customerEntity.getMobile());

        customerResponseDto.setStateCode(customerEntity.getState().getCode());
        customerResponseDto.setStateName(customerEntity.getState().getState());

        customerResponseDto.setCityId(customerEntity.getCity().getCityId());
        customerResponseDto.setCityName(customerEntity.getCity().getCityName());

        customerResponseDto.setAreaId(customerEntity.getArea().getAreaId());
        customerResponseDto.setAreaName(customerEntity.getArea().getArea());

        return customerResponseDto;

    }
}
