package com.webflux.demowebflux.controller;

import com.webflux.demowebflux.entity.Employee;
import com.webflux.demowebflux.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employee")
     Mono<Employee> createEmployee(@RequestBody Employee emp) {
        return employeeRepository.save(emp);
    }

    @GetMapping("/employees")
    Flux<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
    
  


    @PutMapping("/employee/{id}")
    private Mono<Employee> updateEmployee(@PathVariable("id") Long id,
                                  @RequestBody Employee emp) {
        return employeeRepository.findById(id).flatMap(emp1 -> {
            emp.setId(id);
            return employeeRepository.save(emp);
        }).switchIfEmpty(Mono.empty());
    }

    @DeleteMapping("/employee/{id}")
    Mono<Void> deleteById(@PathVariable("id") Long id) {
        return employeeRepository.findById(id).flatMap(p ->
                employeeRepository.deleteById(p.getId()));
    }
}
