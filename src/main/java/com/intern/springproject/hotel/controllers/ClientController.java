package com.intern.springproject.hotel.controllers;

import com.intern.springproject.hotel.models.Person;
import com.intern.springproject.hotel.models.Reservation;
import com.intern.springproject.hotel.repositorys.PersonRepository;
import com.intern.springproject.hotel.repositorys.ReservationRepository;
import com.intern.springproject.hotel.repositorys.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    void addNewPerson(@RequestBody Person person){
        if(!personRepository.findByCnp(person.getCnp()).isPresent()){
            log.info("Save new person with CNP: " + person.getCnp() + " in database");
            personRepository.save(person);
        }
        else {
            log.warn("Unable to save person with CNP: " + person.getCnp() + " in database. Already exist!");
        }
    }

    // .............. Add a new Reservation ......................
    @PostMapping("/newReservation")
    void addNewReservation(@RequestBody Reservation reservation){
        if(!isDuplicateReservation(reservation))
        {
            log.info("Save new reservation with id: "+ reservation.getId() + " in database");
            reservationRepository.save(reservation);
        }
        else{
            log.warn("Unable to save reservation with id: " + reservation.getId() + " in database. It already exist!");
        }

    }

    private Boolean isDuplicateReservation(Reservation reservation) {
        return reservationRepository.findByIdPerson(reservation.getIdPerson()).isPresent() &&
                reservationRepository.findByIdHotel(reservation.getIdHotel()).isPresent() &&
                reservationRepository.findByIdRoom(reservation.getIdRoom()).isPresent() &&
                reservationRepository.findByDay(reservation.getDay()).isPresent() &&
                reservationRepository.findByMonth(reservation.getMonth()).isPresent() &&
                reservationRepository.findByYear(reservation.getYear()).isPresent() &&
                reservationRepository.findByPeriod(reservation.getPeriod()).isPresent();
    }


}