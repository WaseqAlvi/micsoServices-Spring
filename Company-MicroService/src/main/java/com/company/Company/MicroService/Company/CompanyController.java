package com.company.Company.MicroService.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;
    @Autowired

    CompanyRepository companyRepository;
    @GetMapping
    public ResponseEntity<List<Company>> allCompany(){


        return ResponseEntity.ok(companyService.allCompany());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCompanyById(@PathVariable long id){


        Company company=companyService.getCompanyById(id);


        if (company==null)
            return new ResponseEntity<>("Company not found brother",HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(company);
    }

    @PostMapping
    public ResponseEntity<Void> createCompany(@RequestBody Company company){

        companyService.createCompany(company);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editCompany(@PathVariable long id, @RequestBody Company company){

        boolean flag=companyService.editCompany(id,company);
        if(!flag){
            return new ResponseEntity<>(String.format("No company with id=%s found",id),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(String.format("company with id=%s Edited",id),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable long id){

        boolean flag=companyService.deleteCompany(id);
        if(!flag){
            return new ResponseEntity<>(String.format("No company with id=%s found",id),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(String.format("company with id=%s deleted",id),HttpStatus.ACCEPTED);



    }
}
