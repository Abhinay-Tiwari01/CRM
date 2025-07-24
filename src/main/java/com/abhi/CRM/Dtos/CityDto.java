package com.abhi.CRM.Dtos;

import java.util.List;

public class CityDto {
    private int cityId;
    private String cityName;
    private String stateName;
    private List<String> areaNames;

    public CityDto(int cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public CityDto() {

    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public List<String> getAreaNames() {
        return areaNames;
    }

    public void setAreaNames(List<String> areaNames) {
        this.areaNames = areaNames;
    }
}
