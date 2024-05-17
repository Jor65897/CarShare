package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.util.Helper;

public class AddressFactory {

    public static Address createAddress(String addressId, String userId, int streetNumber, String streetName, String suburb, int postalCode) {
        if (!Helper.isValidAddressId(addressId)||!Helper.isValidUserId(userId)||!Helper.isValidStreetNumber(streetNumber)
                ||!Helper.isValidStreetName(streetName)||!Helper.isValidSuburb(suburb)||!Helper.isValidPostalCode(postalCode)) {
            throw new IllegalArgumentException("Invalid address ID");
        }
        return new Address.Builder()
                .setAddressId(addressId)
                .setUserId(userId)
                .setStreetNumber(streetNumber)
                .setStreetName(streetName)
                .setSuburb(suburb)
                .setPostalCode(postalCode)
                .build();
    }
}

