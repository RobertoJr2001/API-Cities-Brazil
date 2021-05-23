package com.apicities.citiesapi.Resource;

import com.apicities.citiesapi.Entity.Country;
import com.apicities.citiesapi.Repository.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryResource {

    private final CountryRepository repository;

    public CountryResource(CountryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("countries")
    public Page<Country> countries(Pageable page) {
        return repository.findAll(page);
    }
}
