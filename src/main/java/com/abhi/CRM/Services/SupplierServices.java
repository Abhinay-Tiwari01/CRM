package com.abhi.CRM.Services;

import com.abhi.CRM.Dtos.SupplierDto.SupplierEntryDto;
import com.abhi.CRM.Dtos.SupplierDto.SupplierResponseDto;
import com.abhi.CRM.Mapper.SupplierMapper;
import com.abhi.CRM.Model.EntryEntites.SupplierEntity;
import com.abhi.CRM.Model.LocationEntites.AreaEntity;
import com.abhi.CRM.Model.LocationEntites.CityEntity;
import com.abhi.CRM.Model.LocationEntites.StateEntity;
import com.abhi.CRM.Repository.AreaRepo;
import com.abhi.CRM.Repository.CityRepo;
import com.abhi.CRM.Repository.StateRepo;
import com.abhi.CRM.Repository.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SupplierServices {

    @Autowired
    SupplierRepo supplierRepo;
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


    public SupplierResponseDto createSupplier(SupplierEntryDto supplierEntryDto) {

        SupplierEntity supplierEntity = SupplierMapper.toSupplierEntity(supplierEntryDto);

        StateEntity state = stateRepo.findById(supplierEntryDto.getStateCode())
                .orElseThrow(() -> new RuntimeException("Invalid state code"));
        supplierEntity.setState(state);

        CityEntity city = cityRepo.findById(supplierEntryDto.getCityId())
                .orElseThrow(() -> new RuntimeException("Invalid city id"));
        supplierEntity.setCity(city);

        AreaEntity area = areaRepo.findById(supplierEntryDto.getAreaId())
                .orElseThrow(() -> new RuntimeException("Invalid area id"));
        supplierEntity.setArea(area);
        SupplierEntity savedSupplier = supplierRepo.save(supplierEntity);
        System.out.println("hello from create customer services");
//        -------------------------------------------------------------------------------------
        System.out.println("stateCode: " + supplierEntryDto.getStateCode());
        System.out.println("cityId: " + supplierEntryDto.getCityId());
        System.out.println("areaId: " + supplierEntryDto.getAreaId());

        return SupplierMapper.toSupplierResponseDto(savedSupplier);
    }
}
