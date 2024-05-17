package za.ac.cput.repository;

import za.ac.cput.domain.Contact;

import java.util.HashMap;
import java.util.Map;

public class ContactRepository implements IContactRepository {
    private static ContactRepository repository = null;
    private Map<String, Contact> contactDB;

    private ContactRepository() {
        contactDB = new HashMap<>();
    }

    public static ContactRepository getRepository() {
        if (repository == null) {
            repository = new ContactRepository();
        }
        return repository;
    }

    @Override
    public Contact create(Contact contact) {
        if (contactDB.containsKey(contact.getContactId())) {
            return null;
        }
        contactDB.put(contact.getContactId(), contact);
        return contact;
    }

    @Override
    public Contact read(String contactId) {
        return contactDB.get(contactId);
    }

    @Override
    public Contact update(Contact contact) {
        if (contactDB.containsKey(contact.getContactId())) {
            contactDB.put(contact.getContactId(), contact);
            return contact;
        }
        return null;
    }

    @Override
    public boolean delete(String contactId) {
        Contact contact = contactDB.remove(contactId);
        return contact != null;
    }
}
