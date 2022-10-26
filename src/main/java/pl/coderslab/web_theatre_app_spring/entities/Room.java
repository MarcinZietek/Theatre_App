package pl.coderslab.web_theatre_app_spring.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomName;
    private int noSeats;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "room_screening", joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "screenning_id"))
    private Set<Screening> screenings;

    @ManyToMany
    @JoinTable(name = "room_seat",
        joinColumns = {@JoinColumn(name = "fk_room")},
        inverseJoinColumns = {@JoinColumn(name = "fk_seat")})
    private Set<Seat> seats = new HashSet<>();
}
