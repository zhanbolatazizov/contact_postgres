package azizov.testproject.crud_postgres.repositories;

import azizov.testproject.crud_postgres.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<Contact, Long> {
    Contact findContactByFirstNumberOrSecondNumber(String phoneNumber, String phoneNumber1);
}
