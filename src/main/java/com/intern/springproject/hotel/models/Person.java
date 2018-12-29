package com.intern.springproject.hotel.models;


import javax.persistence.*;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * @Entity is a JPA annotation to make this object ready for storage in a JPA-based data store.
 * @Table annotation allows as to specify the details of the table that will be used to persist
 *        the entity in the database.
 * @Id  annotation marks a field as a primary key field. When a primary key field is defined
 *      the primary key value is automatically injected into that field by ObjectDB.
 * @GeneratedValue annotation specifies that primary key is automatically allocated by ObjectDB
 * @Column is used to specify the mapped column for a persistent property or field.
 */

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "nameOfPerson")
    private String name;

    @Column(name = "surnameOfPerson")
    private String surname;

    @Column(name = "CNP")
    private Integer cnp;

    @Column(name = "telephoneNumber")
    private Integer telephoneNumber;

    public Integer getId() {
        return id;
    }

    public Person setId(Integer id) {
        Objects.requireNonNull(id,"Id must not be null");
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        Objects.requireNonNull(name,"Name must not be null");
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Person setSurname(String surname) {
        Objects.requireNonNull(surname,"Surname must not be null");
        this.surname = surname;
        return this;
    }

    public Integer getCnp() {
        return cnp;
    }

    public Person setCnp(Integer cnp) {
        Objects.requireNonNull(cnp,"CNP must not be null");
        this.cnp = cnp;
        return this;
    }

    public Integer getTelephoneNumber() {
        return telephoneNumber;
    }

    public Person setTelephoneNumber(Integer telephoneNumber) {
        Objects.requireNonNull(telephoneNumber,"Telephone number must not be null");
        this.telephoneNumber = telephoneNumber;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return id.equals(person.id) &&
                Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(cnp, person.cnp) &&
                Objects.equals(telephoneNumber, person.telephoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, cnp, telephoneNumber);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("surname='" + surname + "'")
                .add("cnp=" + cnp)
                .add("telephoneNumber=" + telephoneNumber)
                .toString();
    }


    /**
     * Method that evaluates each local fields for null
     * @return - if find a field null it return true, false otherwise.
     */
    public Boolean isNull() {
        return (this.id == null || this.name == null || this.surname == null
                || this.cnp == null || this.telephoneNumber == null);
    }
}
