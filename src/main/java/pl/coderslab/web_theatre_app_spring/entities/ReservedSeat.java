package pl.coderslab.web_theatre_app_spring.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "reserved_seat")
public class ReservedSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
