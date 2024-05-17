package za.ac.cput.util;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;

import java.util.regex.Pattern;

public class Helper {

    // Regular expression for validating email addresses
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    // validating contact ID
    public static boolean isValidContactId(String contactId) {
        return contactId != null && !contactId.trim().isEmpty();
    }

    //validating email
    public static boolean isValidEmail(String email) {
        return email != null && Pattern.matches(EMAIL_PATTERN, email);
    }

    //To validate mobile number
    public static boolean isValidMobileNo(int mobileNo) {

        return String.valueOf(mobileNo).matches("\\d{10}");
    }

    // To validate address ID
    public static boolean isValidAddressId(String addressId) {
        return addressId != null && !addressId.trim().isEmpty();
    }

    // To validate user ID
    public static boolean isValidUserId(String userId) {
        return userId != null && !userId.trim().isEmpty();
    }

    // To validate street number
    public static boolean isValidStreetNumber(int streetNumber) {
        return streetNumber > 0;
    }

    // To validate street name
    public static boolean isValidStreetName(String streetName) {
        return streetName != null && !streetName.trim().isEmpty();
    }

    // To validate suburb
    public static boolean isValidSuburb(String suburb) {
        return suburb != null && !suburb.trim().isEmpty();
    }

    //To validate postal code
    public static boolean isValidPostalCode(int postalCode) {
        // must be 5 digits
        return String.valueOf(postalCode).matches("\\d{5}");
    }

    // Validating Contact object
    public static boolean validateContact(Contact contact) {
        return isValidContactId(contact.getContactId()) &&
                isValidEmail(contact.getEmail()) &&
                isValidMobileNo(contact.getMobileNo());
    }

    // Validating Address object
    public static boolean validateAddress(Address address) {
        return isValidAddressId(address.getAddressId()) &&
                isValidUserId(address.getUserId()) &&
                isValidStreetNumber(address.getStreetNumber()) &&
                isValidStreetName(address.getStreetName()) &&
                isValidSuburb(address.getSuburb()) &&
                isValidPostalCode(address.getPostalCode());
    }
}

