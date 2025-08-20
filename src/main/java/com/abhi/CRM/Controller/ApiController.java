package com.abhi.CRM.Controller;

import com.abhi.CRM.Dtos.AreaDto;
import com.abhi.CRM.Dtos.CityDto;
import com.abhi.CRM.Dtos.CustomerDto.CustomerEntryDto;
import com.abhi.CRM.Dtos.CustomerDto.CustomerResponseDto;
import com.abhi.CRM.Model.LocationEntites.AreaEntity;
import com.abhi.CRM.Model.LocationEntites.CityEntity;
import com.abhi.CRM.Repository.AreaRepo;
import com.abhi.CRM.Repository.CityRepo;
import com.abhi.CRM.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    CustomerService customerService;
    @Autowired
    AreaRepo areaRepo;
    @Autowired
    CityRepo cityRepo;


//    @GetMapping("/cities")
//    public ResponseEntity<List<CityDto>> getCities(){
//        return   ResponseEntity.ok(customerService.getAllCities());
//    }
//    @GetMapping("/areas")
//    public List<AreaEntity> getAreas(@RequestParam int cityId){
//        return customerService.getAreaByCity(cityId);
//    }

    @PostMapping("/customers")
    public ResponseEntity<CustomerResponseDto> createCustomer(@RequestBody CustomerEntryDto input) {
        CustomerResponseDto customerResponseDto = customerService.createCustomer(input);
        return ResponseEntity.ok(customerResponseDto);
    }

    // ✅ GET by id (optional)
    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerResponseDto> getCustomer(@PathVariable Integer id) {
        CustomerResponseDto response = customerService.getCustomerById(id);
        return ResponseEntity.ok(response);
    }



    @GetMapping("/cities")
    public List<CityDto> getCities(@RequestParam("stateCode") Integer stateCode){
        List<CityEntity> cities = cityRepo.findByState_Code(stateCode);
        return cities.stream()
                .map(city -> new CityDto(city.getCityId(), city.getCityName()))
                .collect(Collectors.toList());
    }
    @GetMapping("/areas")
    public List<AreaDto> getAreasByCity(@RequestParam("cityId") Integer cityId) {
        List<AreaEntity> areas = areaRepo.findByCity_CityId(cityId);
        return areas.stream()
                .map(area -> new AreaDto(area.getAreaId(), area.getArea()))
                .collect(Collectors.toList());
    }

}
