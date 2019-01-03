package com.intern.springproject.hotel.controllers;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.LinkedList;
import java.util.List;

import com.intern.springproject.hotel.models.Hotel;
import com.intern.springproject.hotel.models.Person;
import com.intern.springproject.hotel.models.Reservation;
import com.intern.springproject.hotel.models.Room;
import com.intern.springproject.hotel.repositorys.HotelRepository;
import com.intern.springproject.hotel.repositorys.PersonRepository;
import com.intern.springproject.hotel.repositorys.ReservationRepository;
import com.intern.springproject.hotel.repositorys.RoomRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

public class AdministratorControllerTest {


    private HotelRepository hotelRepository ;
    private RoomRepository roomRepository;
    private PersonRepository personRepository;
    private ReservationRepository reservationRepository;
    private Hotel hotel;
    private Room room;
    private Person person;
    private Reservation reservation;

    @Captor
    ArgumentCaptor<Hotel> hotelArgumentCaptor;
    @Captor
    ArgumentCaptor<Room> roomArgumentCaptor;

    @Mock
    AdministratorController administratorController;

    @Before
    public void setUp(){
        administratorController = new AdministratorController(hotelRepository, roomRepository, personRepository, reservationRepository);
        initMocks(this);
    }

    /**
     * @see AdministratorController
     * Test addNewHotel() method
     */
    @Test
    public void AddNewHotelTest(){
        doNothing().when(administratorController).addNewHotel(any(Hotel.class));
        hotel = createHotel();
        administratorController.addNewHotel(hotel);
        verify(administratorController,times(1)).addNewHotel(hotel);
    }

    @Test(expected = DuplicateKeyException.class)
    public void addNewHotelThrowsException(){

        hotel = createHotel();
        doThrow(new DuplicateKeyException("Duplicate entity")).when(administratorController).addNewHotel(hotel);
        try {
            administratorController.addNewHotel(hotel);
            fail("DuplicateKeyException not thrown.");
        } catch (DuplicateKeyException e) {
            throw e;
        }
    }

    @Test
    public void addNewHotelArgumentCaptor(){
        hotel = createHotel();
        administratorController.addNewHotel(hotel);
        verify(administratorController,times(1)).addNewHotel(hotelArgumentCaptor.capture());
        assertEquals(hotel,hotelArgumentCaptor.getValue());
    }

    private Hotel createHotel(){
        return new Hotel().setId(1).setName("Ramada").setAdress("Cluj Napoca, 223344").setTelephoneNumber(2345);
    }


    /**
     * @see AdministratorController
     * Test addNewRoom() method
     */

    @Test
    public void addNewRoomTest(){
        doNothing().when(administratorController).addNewRoom(any(Room.class));
        room = createRoom();
        administratorController.addNewRoom(room);
        verify(administratorController,times(1)).addNewRoom(room);
    }

    @Test(expected = DuplicateKeyException.class)
    public void addNewRoomThrowException(){
        doThrow(new DuplicateKeyException("Duplicate entity")).when(administratorController).addNewRoom(any(Room.class));
        room = createRoom();
        try {
            administratorController.addNewRoom(room);
            fail("DuplicateKeyException not thrown");
        } catch (DuplicateKeyException e) {
            throw e;
        }

    }

    @Test
    public void addNewRoomArgumentCaptor(){
        room = createRoom();
        administratorController.addNewRoom(room);
        verify(administratorController,times(1)).addNewRoom(roomArgumentCaptor.capture());
        assertEquals(room, roomArgumentCaptor.getValue());
    }

   private Room createRoom(){
        return new Room().setId(1).setIdHotel(1).setNumber(303).setPrice(200).setAvailable(Boolean.TRUE);
   }

    /**
     * @see AdministratorController
     * Test getAllHotels() method
     */

    @Test
    public void getAllHotelsSuccessfulTest(){
        hotel = createHotel();
        List<Hotel> hotels = new LinkedList<>();
        hotels.add(hotel);

        when(administratorController.getAllHotels()).thenReturn(hotels);
        administratorController.getAllHotels();
        verify(administratorController,times(1)).getAllHotels();
        assertEquals(hotels, administratorController.getAllHotels());
    }

    /**
     * @see AdministratorController
     * Test getAllRooms() method
     */

    @Test
    public void getAllRoomsSuccessfulTest(){
        room = createRoom();
        List<Room> rooms = new LinkedList<>();
        rooms.add(room);

        when(administratorController.getAllRooms()).thenReturn(rooms);
        administratorController.getAllRooms();
        verify(administratorController,times(1)).getAllRooms();
        assertEquals(rooms, administratorController.getAllRooms());
    }

    /**
     * @see AdministratorController
     * Test getAllPersons() method
     */

    @Test
    public void getAllPersonsSuccessfulTest(){
        person = createPerson();
        List<Person> persons = new LinkedList<>();
        persons.add(person);

        when(administratorController.getAllPersons()).thenReturn(persons);
        administratorController.getAllPersons();
        verify(administratorController,times(1)).getAllPersons();
        assertEquals(persons, administratorController.getAllPersons());
    }

    // create a person object
    private Person createPerson(){
        return new Person().setId(1).setName("Name").setSurname("Surname").setCnp(222).setTelephoneNumber(322);
    }

    /**
     * @see AdministratorController
     * Test getAllHotels() method
     */

    @Test
    public void getAllReservationsSuccessfulTest(){
        reservation = createReservation();
        List<Reservation> reservations = new LinkedList<>();
        reservations.add(reservation);

        when(administratorController.getAllReservations()).thenReturn(reservations);
        administratorController.getAllReservations();
        verify(administratorController,times(1)).getAllReservations();
        assertEquals(reservations, administratorController.getAllReservations());
    }

    // create a reservation object
    Reservation createReservation(){
        return new Reservation().setId(1).setIdHotel(1).setIdRoom(303).setIdPerson(1)
                                .setDay(2).setMonth(3).setYear(2018).setPeriod(2);
    }

}