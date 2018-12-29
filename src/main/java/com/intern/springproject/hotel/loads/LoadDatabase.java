package com.intern.springproject.hotel.loads;

import com.intern.springproject.hotel.models.Hotel;
import com.intern.springproject.hotel.models.Room;
import com.intern.springproject.hotel.repositorys.HotelRepository;
import com.intern.springproject.hotel.repositorys.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring boot will run all @CommandLineRunner beans once the application context is loaded.
 * This runner will request a copy of the HotelRepository and RoomRepository created.
 * @Slf4j is a Lombok annotation to create a Slf4j-based LoggerFactory as log, allowing as to
 *          this newly created hotels and rooms.
 */

@Configuration
@Slf4j
class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabaseHotel(HotelRepository hotelRepository){
        return args -> {
            log.info("Preloading " + hotelRepository.save(new Hotel().setName("Grand Hotel Italia").setId(1).setAdress("Cluj-Napoca 2233445").setTelephoneNumber(756463)));
        };
    }

    @Bean
    CommandLineRunner initDatabaseRoom(RoomRepository roomRepository){
        return args -> {
          log.info("Preloading " + roomRepository.save(new Room().setId(1).setNumber(303).setIdHotel(1).setPrice(300).setAvailable(Boolean.TRUE)));
        };
    }
}
