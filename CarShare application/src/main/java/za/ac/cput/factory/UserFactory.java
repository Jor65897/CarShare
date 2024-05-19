package za.ac.cput.factory; 
import za.ac.cput.domain.User;
import za.ac.cput.domain.Name;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Address;
import za.ac.cput.util.Helper; 
public class UserFactory {

    public static User createUser(String userID, Name name,
                                  Contact contact, Address address,
                                  Boolean license, String role,
                                  String picture, Boolean verified) {

        if(Helper.isNullOrEmpty(userID) ||
        Helper.isNullOrEmpty(name) ||
        Helper.isNullOrEmpty(contact) ||
        Helper.isNullOrEmpty(address) ||
        Helper.isNullOrEmpty(license) ||
        Helper.isNullOrEmpty(role) ||
        Helper.isNullOrEmpty(picture) ||
        Helper.isNullOrEmpty(verified))
            return null;

        return new User.Builder()
                .setUserID(userID)
                .setName(name)
                .setContact(contact)
                .setAddress(address)
                .setLicense(license)
                .setRole(role)
                .setPicture(picture)
                .setVerified(verified)
                .buildUser();
    }

}
