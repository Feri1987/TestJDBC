package net.jnile;

import java.util.List;

public class Contact {

    private Long id;

    private String firstName;

    private String lastName;

    private List<ContactDetails> contactDetailsList;

    /*
    *
    *
    *
    *
    *
    * */

    public List<ContactDetails> getContactDetailsList() {
        return contactDetailsList;
    }

    public void setContactDetailsList(List<ContactDetails> contactDetailsList) {
        this.contactDetailsList = contactDetailsList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /*
    *
    *
    *
    *
    * */

    public Contact(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Contact() {
    }

    /*
    *
    *
    *
    *
    *
    *
    * */

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactDetailsList=" + contactDetailsList +
                '}';
    }
}
