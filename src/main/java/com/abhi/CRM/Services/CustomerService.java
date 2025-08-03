package com.abhi.CRM.Services;

import com.abhi.CRM.Dtos.CityDto;
import com.abhi.CRM.Dtos.CustomerDto.CustomerEntryDto;
import com.abhi.CRM.Dtos.CustomerDto.CustomerResponseDto;
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
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<CityEntity> getCitiesByState(int stateCode) {
        return cityRepo.findByState_Code(stateCode);
    }

    public List<AreaEntity> getAreaByCity(int cityId){
        return areaRepo.findByCity_CityId(cityId);
    }
//
//    public CustomerEntryDto createCustomer(CustomerEntryDto customerEntryDto){
//        CustomerEntity customerEntity = CustomerMapper.toCustomerEntity(customerEntryDto);
//
//        StateEntity state = stateRepo.findById(customerEntryDto.getStateCode())
//                .orElseThrow(() -> new RuntimeException("Invalid state code"));
//        customerEntity.setState(state);
//
//        CityEntity city = cityRepo.findById(customerEntryDto.getCityId())
//                .orElseThrow(() -> new RuntimeException("Invalid city id"));
//        customerEntity.setCity(city);
//
//        AreaEntity area = areaRepo.findById(customerEntryDto.getAreaId())
//                .orElseThrow(() -> new RuntimeException("Invalid area id"));
//        customerEntity.setArea(area);
//        CustomerEntity savedCustomer = customerRepo.save(customerEntity);
//        System.out.println("hello from create customer services");
//        return CustomerMapper.toCustomerEntryDto(savedCustomer);
//
//    }

    public CustomerResponseDto createCustomer(CustomerEntryDto customerEntryDto){
        CustomerEntity customerEntity = CustomerMapper.toCustomerEntity(customerEntryDto);

        StateEntity state = stateRepo.findById(customerEntryDto.getStateCode())
                .orElseThrow(() -> new RuntimeException("Invalid state code"));
        customerEntity.setState(state);

        CityEntity city = cityRepo.findById(customerEntryDto.getCityId())
                .orElseThrow(() -> new RuntimeException("Invalid city id"));
        customerEntity.setCity(city);

        AreaEntity area = areaRepo.findById(customerEntryDto.getAreaId())
                .orElseThrow(() -> new RuntimeException("Invalid area id"));
        customerEntity.setArea(area);
        CustomerEntity savedCustomer = customerRepo.save(customerEntity);
        System.out.println("hello from create customer services");
//        -------------------------------------------------------------------------------------
        System.out.println("stateCode: " + customerEntryDto.getStateCode());
        System.out.println("cityId: " + customerEntryDto.getCityId());
        System.out.println("areaId: " + customerEntryDto.getAreaId());

        return CustomerMapper.toCustomerResponseDto(savedCustomer);

    }

    public List<CityDto> getAllCities(){
        List<CityEntity> cities = cityRepo.findAllWithStateAndAreas();
        return cities.stream().map(city -> {
            CityDto cityDto  = new CityDto();
            cityDto.setCityId(city.getCityId());
            cityDto.setCityName(city.getCityName());
            cityDto.setStateName(city.getState().getState());
            List<String> areaNames = city.getAreaEntityList().stream()
                    .map(AreaEntity::getArea)
                    .collect(Collectors.toList());
            cityDto.setAreaNames(areaNames);
            return cityDto;
        }).collect(Collectors.toList());
    }

    public CustomerResponseDto getCustomerById(Integer id)
    {


        List<Object[]> result = customerRepo.getCustomerFullViewById(id);
        if(result.isEmpty())
        {
            throw new RuntimeException("Customer not found");
        }
        Object[] row = result.get(0);

        CustomerResponseDto customerResponseDto = new CustomerResponseDto();
        customerResponseDto.setId((Integer)row[0]);
        customerResponseDto.setName((String) row[1]);
        customerResponseDto.setAddress((String) row[2]);
        customerResponseDto.setMobile((String) row[3]);
        customerResponseDto.setTitle((String) row[4]);
        customerResponseDto.setMobile((String) row[5]);
        customerResponseDto.setStateCode((Integer) row[6]);
        customerResponseDto.setStateName((String) row[7]);
        customerResponseDto.setAreaId((Integer) row[8]);
        customerResponseDto.setAreaName((String) row[9]);
        customerResponseDto.setCityId((Integer) row[10]);
        customerResponseDto.setCityName((String) row[11]);
//        customerResponseDto.setName((String) row[1]);


//        CustomerEntity customer = customerRepo.findById(id)
//                .orElseThrow(() -> new RuntimeException("Customer not found"));

//        return CustomerMapper.toCustomerResponseDto(customer);
            return customerResponseDto;
    }


}
