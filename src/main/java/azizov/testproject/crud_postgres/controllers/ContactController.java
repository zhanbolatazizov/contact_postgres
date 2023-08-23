package azizov.testproject.crud_postgres.controllers;

import azizov.testproject.crud_postgres.dtos.ContactCreateDTO;
import azizov.testproject.crud_postgres.dtos.ContactDTO;
import azizov.testproject.crud_postgres.dtos.ContactUpdateDTO;
import azizov.testproject.crud_postgres.services.ContactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }
    //get all contacts
    @GetMapping
    public List<ContactDTO> getAllContacts() {
        return contactService.getAllContacts();
    }
    //get contact by id
    @GetMapping("/{id}")
    public ContactDTO getContactById(@PathVariable Long id) {
        return contactService.findById(id);
    }
    //get contact by number
    @GetMapping("/number/{phoneNumber}")
    public ContactDTO findContactByNumber(@PathVariable String phoneNumber) {
        return contactService.findContactByNumber(phoneNumber);
    }
    //create new contact
    @PostMapping
    public ContactDTO createContact(@RequestBody ContactCreateDTO contactCreateDTO) {
        return contactService.createContact(contactCreateDTO);
    }
    //edit contact by id
    @PutMapping("/{id}")
    public ContactDTO updateContactById(@PathVariable Long id, @RequestBody ContactUpdateDTO contactUpdateDTO) {
        return contactService.updateContactById(id, contactUpdateDTO);
    }
    //edit contact by name
    @PutMapping("/number/{phoneNumber}")
    public ContactDTO updateContactByNumber(@PathVariable String phoneNumber, @RequestBody ContactUpdateDTO contactUpdateDTO) {
        return contactService.updateContactByNumber(phoneNumber, contactUpdateDTO);
    }
    //delete contact by id
    @DeleteMapping("/{id}")
    public void deleteContactById(@PathVariable Long id) {
        contactService.deleteContactById(id);
    }
    //delete contact by number
    @DeleteMapping("/number/{phoneNumber}")
    public void deleteContactByNumber(@PathVariable String phoneNumber) {
        contactService.deleteContactByNumber(phoneNumber);
    }

}
