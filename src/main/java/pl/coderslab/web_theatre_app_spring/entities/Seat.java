package pl.coderslab.web_theatre_app_spring.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private char rowLetter;
    private int number;

//    @OneToOne
//    @JoinColumn(name = "seat_id")
//    private ReservedSeat reservedSeats;

}
