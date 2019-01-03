package com.intern.springproject.hotel.controllers;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import com.intern.springproject.hotel.models.Person;
import com.intern.springproject.hotel.models.Reservation;
import com.intern.springproject.hotel.repositorys.ReservationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.DuplicateKeyException;

public class ClientControllerTest {

    Person person;
    Reservation reservation;

    @Mock
    ClientController clientController;

    @Captor
    ArgumentCaptor<Person> personArgumentCaptor;
    @Captor
    ArgumentCaptor<Reservation> reservationArgumentCaptor;

    @Before
    public void setup(){
        initMocks(this);
    }

    // ........ Tests for addNewPerson() method ............
    @Test
    public void addNewPersonTest(){
        doNothing().when(clientController).addNewPerson(any(Person.class));
        person = createPerson();
        clientController.addNewPerson(person);
        // verify the interaction to the method
        verify(clientController).addNewPerson(person);
        // verify number of calls
        verify(clientController,times(1)).addNewPerson(any(Person.class));
    }

    @Test(expected = DuplicateKeyException.class)
    public void addNewPersonThrowsException(){
        person = createPerson();
        doThrow(new DuplicateKeyException("Duplicate entity")).when(clientController).addNewPerson(any(Person.class));
        try {
            clientController.addNewPerson(person); // we expected a DuplicateKeyException here
            verify(clientController,times(1)).addNewPerson(person); // verify that method has called
            fail("DuplicateKeyException not thrown"); // Fail when no exception is thrown
        } catch (Exception e) {
            throw e;
        }
    }

    @Test
    public void addNewPersonArgumentCaptor(){
        person = createPerson();
        clientController.addNewPerson(person);
        verify(clientController,times(1)).addNewPerson(personArgumentCaptor.capture());
        assertEquals(person, personArgumentCaptor.getAllValues().get(0));
    }

    // create a person object
    Person createPerson(){
        return new Person().setName("Name").setSurname("Surname").setId(1).setCnp(12343).setTelephoneNumber(7543);
    }


    // ................ Tests for addNewReservation() method ...............

    @Test
    public void addNewReservationTest(){
        reservation = createReservation();
        doNothing().when(clientController).addNewReservation(any(Reservation.class));
        clientController.addNewReservation(reservation);
        verify(clientController).addNewReservation(any(Reservation.class));
        verify(clientController,times(1)).addNewReservation(any(Reservation.class));
    }

    @Test(expected = DuplicateKeyException.class)
    public void addNewReservationThrowException(){
        reservation = createReservation();
        doThrow(new DuplicateKeyException("Duplicate entity")).when(clientController).addNewReservation(any(Reservation.class));
        try {
            clientController.addNewReservation(reservation);
            fail("DuplicateKeyException not thrown");
        } catch (DuplicateKeyException e) {
            throw e;
        }
    }

    @Test
    public void addNewReservationArgumentCaptor(){
        reservation = createReservation();
        clientController.addNewReservation(reservation);
        verify(clientController,times(1)).addNewReservation(reservationArgumentCaptor.capture());
        assertEquals(reservation,reservationArgumentCaptor.getAllValues().get(0));
    }

    // create a reservation object
    Reservation createReservation(){
        return new Reservation().setId(1).setIdHotel(1).setIdRoom(303).setIdPerson(1)
                .setDay(2).setMonth(3).setYear(2018).setPeriod(2);
    }
}