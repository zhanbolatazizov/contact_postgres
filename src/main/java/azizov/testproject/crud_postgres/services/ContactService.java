package azizov.testproject.crud_postgres.services;


import azizov.testproject.crud_postgres.dtos.ContactCreateDTO;
import azizov.testproject.crud_postgres.dtos.ContactDTO;
import azizov.testproject.crud_postgres.dtos.ContactUpdateDTO;
import azizov.testproject.crud_postgres.models.Contact;
import azizov.testproject.crud_postgres.repositories.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {

    private final ContactRepo contactRepository;

    @Autowired
    public ContactService(ContactRepo contactRepository) {
        this.contactRepository = contactRepository;
    }

    //get

    public ContactDTO findById(Long id) {
        Contact contact = contactRepository.findById(id).orElse(null);
        return mapToContactDTO(contact);
    }

    public List<ContactDTO> getAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        return contacts.stream()
                .map(this::mapToContactDTO)
                .collect(Collectors.toList());
    }

    public ContactDTO findContactByNumber(String phoneNumber) {
        Contact contact = contactRepository.findContactByFirstNumberOrSecondNumber(phoneNumber, phoneNumber);
        return mapToContactDTO(contact);
    }

    //create

    public ContactDTO createContact(ContactCreateDTO contactCreateDTO) {
        Contact contact = new Contact();
        contact.setName(contactCreateDTO.getName());
        contact.setFirstNumber(contactCreateDTO.getFirstNumber());
        contact.setSecondNumber(contactCreateDTO.getSecondNumber());
        contact.setCreatedDate(LocalDateTime.now());
        Contact savedContact = contactRepository.save(contact);
        return mapToContactDTO(savedContact);
    }

    //update

    public ContactDTO updateContactById(Long id, ContactUpdateDTO contactUpdateDTO) {
        Contact existingContact = contactRepository.findById(id).orElse(null);
        if (existingContact == null) {
            return null; // Handle not found case
        }
        existingContact.setName(contactUpdateDTO.getName());
        Contact updatedContact = contactRepository.save(existingContact);
        return mapToContactDTO(updatedContact);
    }

    public ContactDTO updateContactByNumber(String phoneNumber, ContactUpdateDTO contactUpdateDTO) {
        Contact existingContact = contactRepository.findContactByFirstNumberOrSecondNumber(phoneNumber, phoneNumber);
        if (existingContact == null) {
            return null; // Handle not found case
        }
        existingContact.setName(contactUpdateDTO.getName());
        Contact updatedContact = contactRepository.save(existingContact);
        return mapToContactDTO(updatedContact);
    }

    //delete

    public void deleteContactById(Long id) {
        contactRepository.deleteById(id);
    }

    public void deleteContactByNumber(String phoneNumber) {
        Contact existingContact = contactRepository.findContactByFirstNumberOrSecondNumber(phoneNumber, phoneNumber);
        if (existingContact != null) {
            contactRepository.delete(existingContact);
        }
    }
    private ContactDTO mapToContactDTO(Contact contact) {
        if (contact != null) {
            ContactDTO dto = new ContactDTO();
            dto.setId(contact.getId());
            dto.setName(contact.getName());
            dto.setFirstNumber(contact.getFirstNumber());
            dto.setSecondNumber(contact.getSecondNumber());
            dto.setCreatedDate(contact.getCreatedDate());
            return dto;
        }
        return null;
    }

}
