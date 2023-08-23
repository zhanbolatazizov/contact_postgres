package azizov.testproject.crud_postgres.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(name = "first_number")
    private String firstNumber;
    @Column(name = "second_number")
    private String secondNumber;
    @Column(name = "created_date")
    private LocalDateTime createdDate;


}
