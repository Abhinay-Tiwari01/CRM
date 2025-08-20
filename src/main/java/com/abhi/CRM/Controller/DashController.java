package com.abhi.CRM.Controller;

import com.abhi.CRM.Dtos.CustomerDto.CustomerEntryDto;
import com.abhi.CRM.Dtos.LocationDto.CityAreaDto;
import com.abhi.CRM.Dtos.SupplierDto.SupplierEntryDto;
import com.abhi.CRM.Model.LocationEntites.AreaEntity;
import com.abhi.CRM.Model.LocationEntites.CityEntity;
import com.abhi.CRM.Model.LocationEntites.StateEntity;
import com.abhi.CRM.Repository.AreaRepo;
import com.abhi.CRM.Repository.CityRepo;
import com.abhi.CRM.Repository.StateRepo;
import com.abhi.CRM.Services.CustomerService;
import com.abhi.CRM.Services.SupplierServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DashController {

    @Autowired
    CustomerService customerService;
    @Autowired
    SupplierServices supplierServices;
    @Autowired
    StateRepo stateRepo;
    @Autowired
    CityRepo cityRepo;
    @Autowired
    AreaRepo areaRepo;

//    ===================================Customer And Supplier Entry and product entry===========================================

    @GetMapping(value ="/customerEntry" )//this will show the form when url hit
    public String showCustomerEntry(Model model)
    {
        List<StateEntity> states = stateRepo.findAll();
        model.addAttribute("state",states);//find all states From state entry
        System.out.println(states);
        model.addAttribute("customer", new CustomerEntryDto());
        return "customerEntry";
    }

    @PostMapping(value = "/customerEntry")// this will handle the submission after url hiting
    public String customerEnt(@ModelAttribute CustomerEntryDto customerEntryDto){
        customerService.createCustomer(customerEntryDto);
        return "redirect:/customerEntry";
    }

    @GetMapping(value ="/supplierEntry" )//this will show the form when url hit
    public String showSupplierEntry(Model model)
    {
        List<StateEntity> states = stateRepo.findAll();
        model.addAttribute("state",states);//find all states From state entry
        System.out.println(states);
        model.addAttribute("supplier", new SupplierEntryDto());
        return "supplierEntry";
    }

    @PostMapping(value = "/supplierEntry")// this will handle the submission after url hiting
    public String supplierEnt(@ModelAttribute SupplierEntryDto supplierEntryDto){
        supplierServices.createSupplier(supplierEntryDto);
        return "redirect:/supplierEntry";
    }

    @GetMapping("/saveProduct")
    public String showSavedProduct(){
        return "productEntry";
    }
    @PostMapping("/saveProduct")
    public String saveProduct()
    {
        return "redirect:/productEntry";
    }





//    ===================================State City ARea COde===========================================

    @GetMapping("/saveCityArea")
    public String showSaveCityArea(Model model){
        List<StateEntity> stateList = stateRepo.findAll();
        List<CityEntity> cityAreaList = cityRepo.findAllWithStateAndAreas();
        model.addAttribute("state", stateList);
        model.addAttribute("cityAreaList",cityAreaList); // Join with Area as needed
        model.addAttribute("cityArea", new CityAreaDto());
        return "stateCityAreaEntry";
    }
    @PostMapping("/saveCityArea")
    public String saveCityArea(@ModelAttribute CityAreaDto cityAreaDto){
        StateEntity state = stateRepo.findById(cityAreaDto.getStateCode()).orElseThrow();

        CityEntity city = new CityEntity();
        city.setCityName(cityAreaDto.getCity());
        city.setState(state);
        city=cityRepo.save(city);

        AreaEntity areaEntity = new AreaEntity();
        areaEntity.setArea(cityAreaDto.getAreaName());
        areaEntity.setCity(city);
        areaRepo.save(areaEntity);

        return "redirect:/saveCityArea";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        cityRepo.deleteById(id);
        return "redirect:/saveCityArea";
    }
//    @GetMapping("/edit/{id}")
//    public String editAreaCity(@PathVariable Integer id){
//        cityRepo
//    }


}
