package za.ac.cput.factory;

import za.ac.cput.domain.User;
import za.ac.cput.domain.Name;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Address;

public class UserFactory {

    public static User createUser(String userID, Name name, Contact contact, Address address, Boolean license, String role, String picture, Boolean verified) {
        return new User.Builder()
                .setUserID(userID)
                .setName(name)
                .setContact(contact)
                .setAddress(address)
                .setLicense(license)
                .setRole(role)
                .setPicture(picture)
                .setVerified(verified)
                .build();
    }

    public static User copyUser(User user) {
        return new User.Builder()
                .copy(user)
                .build();
    }
}
