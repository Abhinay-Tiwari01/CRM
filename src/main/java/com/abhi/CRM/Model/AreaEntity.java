package com.abhi.CRM.Model;
import jakarta.persistence.*;

@Entity
public class AreaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Area_Id")
    private int id;
    @Column(name = "Area_Name")
    private String area;

    @ManyToOne
    @JoinColumn(name = "City_Id")
    private CityEntity city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }
}
