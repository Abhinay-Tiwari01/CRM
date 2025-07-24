package com.abhi.CRM.Controller;

import com.abhi.CRM.Dtos.AreaDto;
import com.abhi.CRM.Dtos.CityDto;
import com.abhi.CRM.Model.AreaEntity;
import com.abhi.CRM.Model.CityEntity;
import com.abhi.CRM.Repository.AreaRepo;
import com.abhi.CRM.Repository.CityRepo;
import com.abhi.CRM.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
