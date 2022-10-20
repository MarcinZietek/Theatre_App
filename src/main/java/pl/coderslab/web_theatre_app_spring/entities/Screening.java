package pl.coderslab.web_theatre_app_spring.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "screenings")
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp startTime;

    @OneToMany
    @JoinColumn(name = "screening_id")
    private List<ReservedSeat> reservedSeats = new ArrayList<>();

}
