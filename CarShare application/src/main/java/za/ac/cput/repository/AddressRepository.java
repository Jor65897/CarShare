package za.ac.cput.repository;

import za.ac.cput.domain.Address;

import java.util.HashMap;
import java.util.Map;

public class AddressRepository implements IAddressRepository {
    private static AddressRepository repository = null;
    private Map<String, Address> addressDB;

    private AddressRepository() {
        addressDB = new HashMap<>();
    }

    public static AddressRepository getRepository() {
        if (repository == null) {
            repository = new AddressRepository();
        }
        return repository;
    }

    @Override
    public Address create(Address address) {
        if (addressDB.containsKey(address.getAddressId())) {
            return null;
        }
        addressDB.put(address.getAddressId(), address);
        return address;
    }

    @Override
    public Address read(String addressId) {
        return addressDB.get(addressId);
    }

    @Override
    public Address update(Address address) {
        if (addressDB.containsKey(address.getAddressId())) {
            addressDB.put(address.getAddressId(), address);
            return address;
        }
        return null;
    }

    @Override
    public boolean delete(String addressId) {
        Address address = addressDB.remove(addressId);
        return address != null;
    }
}

