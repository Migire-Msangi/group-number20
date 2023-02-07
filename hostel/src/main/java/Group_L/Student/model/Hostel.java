package Group_L.Student.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hostel_room")
public class Hostel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "block_number")
    private String hostelName;
    @Column(name = "Student_name")
    private String studentFullName;
    @Column(name = "Room_number")
    private String room;

    @Column(name = "Room_capacity")
    private String capacity;

    @Column(name = "Room_price")
    private String price;
}




