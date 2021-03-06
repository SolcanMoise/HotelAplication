package com.intern.springproject.hotel.controllers;

import com.intern.springproject.hotel.models.Person;
import com.intern.springproject.hotel.models.Reservation;
import com.intern.springproject.hotel.repositorys.PersonRepository;
import com.intern.springproject.hotel.repositorys.ReservationRepository;
import com.intern.springproject.hotel.repositorys.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @RestController indicates that the data returned by each method will be written straight into the
 * repository body instead of rendering a template.
 * The personRepository and reservationRepository is injected by constructor into the ClientController.
 */

@RestController
@RequestMapping("/client")
public class ClientController {

    private static final Logger log = LoggerFactory.getLogger(ClientController.class);

    private PersonRepository personRepository;
    private ReservationRepository reservationRepository;
    private RoomRepository roomRepository;

    @Autowired
    public ClientController(PersonRepository personRepository, ReservationRepository reservationRepository, RoomRepository roomRepository) {
        this.personRepository = personRepository;
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
    }




    // .............. Add a new Person ........... ...............
    @PostMapping("/newPerson")
    void addNewPerson(@RequestBody Person person) throws DuplicateKeyException {
        try{
            log.info("Try to add new " + person + " in database");
            personRepository.save(person);
        }
        catch (DuplicateKeyException e){
            log.warn("Unable to save " + person + " in database. Already exist.");
            throw e;
        }
    }

    // .............. Add a new Reservation ......................
    @PostMapping("/newReservation")
    void addNewReservation(@RequestBody Reservation reservation) throws DuplicateKeyException{
        try {
            log.info("Try to add new " + reservation + " in database");
            reservationRepository.save(reservation);
        }
        catch (DuplicateKeyException e){
            log.warn("Unable to save " + reservation + " in database. Already exist.");
            throw e;
        }

    }

}