package com.intern.springproject.hotel.repositorys;

import com.intern.springproject.hotel.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    Optional<Object> findByIdHotel(Integer idHotel);

    Optional<Object> findByIdRoom(Integer idRoom);

    Optional<Object> findByIdPerson(Integer idPerson);

    Optional<Object> findByDay(Integer day);
    Optional<Object> findByMonth(Integer month);
    Optional<Object> findByYear(Integer year);

    Optional<Object> findByPeriod(Integer period);
}
