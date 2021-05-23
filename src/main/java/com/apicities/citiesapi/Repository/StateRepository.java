package com.apicities.citiesapi.Repository;

import com.apicities.citiesapi.Entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
