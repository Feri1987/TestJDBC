package net.jnile;

public class ContactDetails {

    private Long id;

    private String mobilePhone;

    /*
    *
    *
    *
    *
    *
    *
    *
    * */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /*
    *
    *
    *
    *
    * */

    @Override
    public String toString() {
        return "ContactDetails{" +
                "id=" + id +
                ", mobilePhone='" + mobilePhone + '\'' +
                '}';
    }
}
