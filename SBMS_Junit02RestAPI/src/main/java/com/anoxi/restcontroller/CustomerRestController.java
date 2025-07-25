package com.anoxi.restcontroller;

import com.anoxi.dto.Customer;
import com.anoxi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<String> saveCustomer(@RequestBody Customer customer){

        boolean isSaved = customerService.saveCustomer(customer);

        if (isSaved){
            return new ResponseEntity<>("Customer Saved", HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>("Customer not saved", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
