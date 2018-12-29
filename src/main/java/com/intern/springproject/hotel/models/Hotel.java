package com.intern.springproject.hotel.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    private String adress;

    @Column
    private Integer telephoneNumber;

    public Integer getId() {
        return id;
    }

    public Hotel setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Hotel setName(String name) {
        this.name = name;
        return this;
    }

    public String getAdress() {
        return adress;
    }

    public Hotel setAdress(String adress) {
        this.adress = adress;
        return this;
    }

    public Integer getTelephoneNumber() {
        return telephoneNumber;
    }

    public Hotel setTelephoneNumber(Integer telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hotel)) return false;
        Hotel hotel = (Hotel) o;
        return id.equals(hotel.id) &&
                Objects.equals(name, hotel.name) &&
                Objects.equals(adress, hotel.adress) &&
                Objects.equals(telephoneNumber, hotel.telephoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, adress, telephoneNumber);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Hotel.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("adress='" + adress + "'")
                .add("telephoneNumber=" + telephoneNumber)
                .toString();
    }
}
