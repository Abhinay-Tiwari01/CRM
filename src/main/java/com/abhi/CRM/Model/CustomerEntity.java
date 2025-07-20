package com.abhi.CRM.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Customer_Details")

public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Cust_id")
    private Integer id;

    @Column(name = "Cust_Name")
    private String name;

    @Column(name = "Cust_Address")
    private String address;
    @Column(name = "Cust_Mobile")
    private String mobile;
    @Column(name = "cust_title")
    private String title;

//    @Column(name = "state")
    @ManyToOne
    @JoinColumn(name = "State_id")
    private StateEntity state;

//    @Column(name = "city")
    @ManyToOne
    @JoinColumn(name = "City_Id")
    private CityEntity city;

//    @Column(name = "area")
    @ManyToOne
    @JoinColumn(name = "Area_Id")
    private AreaEntity area;

    public CustomerEntity(Integer id, String name, String address, String mobile, String title, StateEntity state, CityEntity city, AreaEntity area) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
        this.title = title;
        this.state = state;
        this.city = city;
        this.area = area;
    }

    public CustomerEntity() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public StateEntity getState() {
        return state;
    }

    public void setState(StateEntity state) {
        this.state = state;
    }

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }

    public AreaEntity getArea() {
        return area;
    }

    public void setArea(AreaEntity area) {
        this.area = area;
    }
}
