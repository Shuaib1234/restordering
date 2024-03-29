/* Customer.java
  Entity for the Customer
   Author: Sinovuyo Mlanjeni (219220387)
    Date: 05 August 2022
 */
package za.ac.cput.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.AdminLogin;
import za.ac.cput.domain.Customer;
import za.ac.cput.service.ICustomerService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("restaurant/customer")
@Slf4j
public class CustomerController {
    private final ICustomerService customerService;

    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping("save")
    public ResponseEntity<Customer> save(@Valid @RequestBody Customer customer){
        log.info("Save Request: {}", customer);
        Customer insert = customerService.save(customer);
        return ResponseEntity.ok(insert);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Optional<Customer>> findById(@PathVariable String id){
        log.info("Read Request: {}", id);
        Optional<Customer> find = customerService.findById(id);
        return ResponseEntity.ok(find);
    }

    @DeleteMapping("delete-customer")
    public ResponseEntity<Void>delete(Customer customer) {
        log.info("Delete request{}", customer);
        this.customerService.delete(customer);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id){
        log.info("Delete request: {}", id);
        this.customerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Customer>>findAll(){
        List<Customer> restaurantList=this.customerService.findAll();
        return ResponseEntity.ok(restaurantList);

    }

}
