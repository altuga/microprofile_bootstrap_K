package com.kodcu.boot;


import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.*;

@Entity
@Table(name = "Doctor")
@NamedQuery(name = "Doctor.findAll", query = "SELECT d FROM Doctor d")
@NamedQuery(name = "Doctor.findDoctor", query = "SELECT d FROM Doctor d WHERE "
        + "d.name = :name ")
public class Doctor {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;

    @JsonbProperty("ad")
    public String name;
    public String surname;

    public String sayHello() {
        return "say Hello" ;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
