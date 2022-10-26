package pl.coderslab.web_theatre_app_spring.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private char rowLetter;
    private int number;

    @ManyToMany(mappedBy = "seats")
    private Set<Room> rooms = new HashSet<>();

}
