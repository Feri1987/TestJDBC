package net.jnile;

public interface ContactDao {

    void save(Contact contact);

    Contact getContactById(long id);

}
