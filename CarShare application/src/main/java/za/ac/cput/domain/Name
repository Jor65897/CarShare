package za.ac.cput.domain;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
@Entity
public class Name implements Serializable {
    @Id
    private String firstName;
    private String middleName;
    private String lastName;
    protected Name() {}
    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }
    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getLastName() {
        return lastName;
    }
    @Override
    public boolean equals(Object nameObject) {
        if (this == nameObject) return true;
        if (nameObject == null || getClass() != nameObject.getClass()) return false;
        Name name = (Name) nameObject;
        return Objects.equals(firstName, name.firstName) &&
                Objects.equals(middleName, name.middleName) &&
                Objects.equals(lastName, name.lastName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName);
    }
    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
