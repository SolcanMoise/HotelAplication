package com.intern.springproject.hotel.models;


import javax.persistence.*;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private Integer idPerson;

    @Column
    private Integer idHotel;

    @Column
    private Integer idRoom;

    @Column
    private Integer day;

    @Column
    private Integer month;

    @Column
    private Integer year;

    @Column
    private Integer period;

    public Integer getId() {
        return id;
    }

    public Reservation setId(Integer id) {
        Objects.requireNonNull(id, "Id must not be null");
        this.id = id;
        return this;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public Reservation setIdPerson(Integer idPerson) {
        Objects.requireNonNull(idPerson, "idPerson must not be null");
        this.idPerson = idPerson;
        return this;
    }

    public Integer getIdHotel() {
        return idHotel;
    }

    public Reservation setIdHotel(Integer idHotel) {
        Objects.requireNonNull(idHotel, "idHotel must not be null");
        this.idHotel = idHotel;
        return this;
    }

    public Integer getIdRoom() {
        return idRoom;
    }

    public Reservation setIdRoom(Integer idRoom) {
        Objects.requireNonNull(idRoom, "idRoom must not be null");
        this.idRoom = idRoom;
        return this;
    }

    public Integer getDay() {
        return day;
    }

    public Reservation setDay(Integer day) {
        Objects.requireNonNull(day, "Day of reservation must not be null");
        this.day = day;
        return this;
    }

    public Integer getMonth() {
        return month;
    }

    public Reservation setMonth(Integer month) {
        Objects.requireNonNull(month, "Month of reservation must not be null");
        this.month = month;
        return this;
    }

    public Integer getPeriod() {
        return period;
    }

    public Reservation setPeriod(Integer period) {
        Objects.requireNonNull(period, "Period of reservation must not be null");
        this.period = period;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public Reservation setYear(Integer year) {
        Objects.requireNonNull(year, "Year of reservation must not be null");
        this.year = year;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation)) return false;
        Reservation that = (Reservation) o;
        return id.equals(that.id) &&
                Objects.equals(idPerson, that.idPerson) &&
                Objects.equals(idHotel, that.idHotel) &&
                Objects.equals(idRoom, that.idRoom) &&
                Objects.equals(day, that.day) &&
                Objects.equals(month, that.month) &&
                Objects.equals(year, that.year) &&
                Objects.equals(period, that.period);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idPerson, idHotel, idRoom, day, month, year, period);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Reservation.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("idPerson=" + idPerson)
                .add("idHotel=" + idHotel)
                .add("idRoom=" + idRoom)
                .add("day=" + day)
                .add("month=" + month)
                .add("year=" + year)
                .add("period=" + period)
                .toString();
    }
}
