package com.intern.springproject.hotel.repositorys;

import com.intern.springproject.hotel.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
}
