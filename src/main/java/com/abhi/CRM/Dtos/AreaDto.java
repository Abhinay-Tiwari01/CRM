package com.abhi.CRM.Dtos;

public class AreaDto {
    private Integer areaId;
    private String area;

    public AreaDto(Integer areaId, String area) {
        this.areaId = areaId;
        this.area = area;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
