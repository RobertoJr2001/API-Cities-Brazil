package com.apicities.citiesapi.Repository;

import com.apicities.citiesapi.Entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
