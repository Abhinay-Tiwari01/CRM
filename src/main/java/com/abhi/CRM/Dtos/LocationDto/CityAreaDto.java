package com.abhi.CRM.Dtos.LocationDto;

public class CityAreaDto {
    private Integer stateCode;
    private String city;
    private String areaName;

    public CityAreaDto() {

    }

    public Integer getStateCode() {
        return stateCode;
    }

    public void setStateCode(Integer stateCode) {
        this.stateCode = stateCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public CityAreaDto(Integer stateCode, String city) {
        this.stateCode = stateCode;
        this.city = city;

    }
}
