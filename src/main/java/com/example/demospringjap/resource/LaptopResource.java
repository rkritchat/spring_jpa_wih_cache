package com.example.demospringjap.resource;

import com.example.demospringjap.model.Laptop;
import com.example.demospringjap.repositories.LaptopRepository;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/laptop")
public class LaptopResource {

    private LaptopRepository laptopRepository;

    public LaptopResource(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @PutMapping
    public String addLaptop(@RequestBody Laptop laptop) {
        laptopRepository.save(laptop);
        return "Done";
    }
}
