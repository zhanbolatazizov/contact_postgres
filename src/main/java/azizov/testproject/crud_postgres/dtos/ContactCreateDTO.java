package azizov.testproject.crud_postgres.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactCreateDTO {

    private String name;
    private String firstNumber;
    private String secondNumber;
}
