package com.apicities.citiesapi.Resource;

import com.apicities.citiesapi.Entity.Country;
import com.apicities.citiesapi.Repository.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("countries")
public class CountryResource {

    private final CountryRepository repository;

    public CountryResource(CountryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<Country> countries(Pageable page) {
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity GetById(@PathVariable Long id) {
        Optional<Country> optional = repository.findById(id);

        return (optional.isEmpty()) ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(optional.get());
    }
}
