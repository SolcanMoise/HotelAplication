package com.intern.springproject.hotel.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer number;

    @Column
    private Integer price;

    @Column
    private Integer idHotel;

    @Column
    private Boolean available;

    public Integer getId() {
        return id;
    }

    public Room setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getNumber() {
        return number;
    }

    public Room setNumber(Integer number) {
        this.number = number;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public Room setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public Integer getIdHotel() {
        return idHotel;
    }

    public Room setIdHotel(Integer idHotel) {
        this.idHotel = idHotel;
        return this;
    }

    public Boolean getAvailable() {
        return available;
    }

    public Room setAvailable(Boolean available) {
        this.available = available;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return id.equals(room.id) &&
                Objects.equals(number, room.number) &&
                Objects.equals(price, room.price) &&
                Objects.equals(idHotel, room.idHotel) &&
                Objects.equals(available, room.available);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, price, idHotel, available);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Room.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("number=" + number)
                .add("price=" + price)
                .add("idHotel=" + idHotel)
                .add("available=" + available)
                .toString();
    }
}
