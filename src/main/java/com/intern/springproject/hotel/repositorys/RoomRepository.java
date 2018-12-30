package com.intern.springproject.hotel.repositorys;

import com.intern.springproject.hotel.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {

}
