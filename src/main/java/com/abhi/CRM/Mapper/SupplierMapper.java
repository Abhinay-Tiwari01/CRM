package com.abhi.CRM.Mapper;

import com.abhi.CRM.Dtos.SupplierDto.SupplierEntryDto;
import com.abhi.CRM.Dtos.SupplierDto.SupplierResponseDto;
import com.abhi.CRM.Model.SupplierEntity;

public class SupplierMapper
{
    public static SupplierEntity toSupplierEntity(SupplierEntryDto supplierEntryDto)
    {
        SupplierEntity supplierEntity = new SupplierEntity();
        supplierEntity.setName(supplierEntryDto.getName());
        supplierEntity.setAddress(supplierEntryDto.getAddress());
        supplierEntity.setMobile(supplierEntryDto.getMobile());
        supplierEntity.setTitle(supplierEntryDto.getTitle());
        return supplierEntity;
    }

    public static SupplierEntryDto toSupplierEntryDto(SupplierEntity supplierEntity)
    {
        SupplierEntryDto supplierEntryDto=new SupplierEntryDto();
        supplierEntryDto.setTitle(supplierEntity.getTitle());
        supplierEntryDto.setName(supplierEntity.getName());
        supplierEntryDto.setAddress(supplierEntity.getAddress());
        supplierEntryDto.setMobile(supplierEntity.getMobile());
        supplierEntryDto.setCityId(supplierEntity.getCity().getCityId());
        supplierEntryDto.setAreaId(supplierEntity.getArea().getAreaId());
        supplierEntryDto.setStateCode(supplierEntity.getState().getCode());
        return supplierEntryDto;
    }

    public static SupplierResponseDto toSupplierResponseDto(SupplierEntity supplierEntity)
    {

        SupplierResponseDto supplierResponseDto=new SupplierResponseDto();
        supplierResponseDto.setId(supplierEntity.getId());
        supplierResponseDto.setTitle(supplierEntity.getTitle());
        supplierResponseDto.setName(supplierEntity.getName());
        supplierResponseDto.setAddress(supplierEntity.getAddress());
        supplierResponseDto.setMobile(supplierEntity.getMobile());

        supplierResponseDto.setStateCode(supplierEntity.getState().getCode());
        supplierResponseDto.setStateName(supplierEntity.getState().getState());

        supplierResponseDto.setCityId(supplierEntity.getCity().getCityId());
        supplierResponseDto.setCityName(supplierEntity.getCity().getCityName());

        supplierResponseDto.setAreaId(supplierEntity.getArea().getAreaId());
        supplierResponseDto.setAreaName(supplierEntity.getArea().getArea());

        return supplierResponseDto;
    }
}
