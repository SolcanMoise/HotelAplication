package com.intern.springproject.hotel.repositorys;

import com.intern.springproject.hotel.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 *      Spring data makes the process of working with entities a lot easier by merely defining repository
 * interface. These comes with a set of pre-defined methods and allow the possibility of adding custom
 * methods in each interface.
 */

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Optional<Object> findByName(String name);

    Optional<Object> findByCnp(Integer cnp);
}
