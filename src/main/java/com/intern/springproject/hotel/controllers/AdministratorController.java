package com.intern.springproject.hotel.controllers;

import java.util.List;

import com.intern.springproject.hotel.models.Hotel;
import com.intern.springproject.hotel.models.Person;
import com.intern.springproject.hotel.models.Reservation;
import com.intern.springproject.hotel.models.Room;
import com.intern.springproject.hotel.repositorys.HotelRepository;
import com.intern.springproject.hotel.repositorys.PersonRepository;
import com.intern.springproject.hotel.repositorys.ReservationRepository;
import com.intern.springproject.hotel.repositorys.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdministratorController {

    private static final Logger log = LoggerFactory.getLogger(AdministratorController.class);

    private HotelRepository hotelRepository;
    private RoomRepository roomRepository;
    private PersonRepository personRepository;
    private ReservationRepository reservationRepository;

    @Autowired
    AdministratorController(HotelRepository hotelRepository, RoomRepository roomRepository,
                            PersonRepository personRepository, ReservationRepository reservationRepository) {
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
        this.personRepository = personRepository;
        this.reservationRepository = reservationRepository;
    }

    @PostMapping("/newHotel")
    void addNewHotel(@RequestBody @Validated Hotel hotel)throws DuplicateKeyException {
        try{
            log.info("Try to add new " + hotel + " in database");
            hotelRepository.save(hotel);
        }
        catch (DuplicateKeyException e){
            log.warn("Unable to save " + hotel + "in database. Already exist");
            throw e;
        }
    }

    @PostMapping("/newRoom")
    void addNewRoom(@RequestBody @Validated Room room) throws DuplicateKeyException {
        try {
            log.info("Try to add new " + room +" in database");
            roomRepository.save(room);
        }
        catch (DuplicateKeyException e){
            log.warn("Unable to save " + room + " in database. Already exist");
            throw e;
        }
    }

    @GetMapping("/viewAllHotels")
    List<Hotel> getAllHotels(){
        return hotelRepository.findAll();
    }

    @GetMapping("/viewAllRooms")
    List<Room> getAllRooms () {
        return roomRepository.findAll();
    }

    @GetMapping("/viewAllPersons")
    List<Person> getAllPersons(){
        return personRepository.findAll();
    }

    @GetMapping("/viewAllReservations")
    List<Reservation> getAllReservations(){
        return reservationRepository.findAll();
    }



}
