package za.ac.cput.service;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Name;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    private static Name name;
    private static Contact contact;
    private static Address address;

    private static User user = UserFactory.createUser("216273293",
            name,
            contact,
            address,
            true,
            "Admin",
            "Kabo.jpeg",
            true);
    @Test
    void create(){
        User createUser = userService.create(user);
    }
    @Test
    void read(){
        String readUser = userService.read(user.getUserID());
        assertNotNull(readUser);
        System.out.println(readUser);
    }
    @Test
    void update(){
        User newUser = new User.Builder()
                .copyUser(user)
                .setUserID("222273293")
                .buildUser();
        User updatedUser = userService.update(newUser);
        assertNotNull(updatedUser);
        System.out.println(updatedUser);
    }
    @Test
    void delete(){
        userService.delete();
    }
}
