package azizov.testproject.crud_postgres.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ContactDTO {

    private Long id;
    private String name;
    private String firstNumber;
    private String secondNumber;
    private LocalDateTime createdDate;



}
