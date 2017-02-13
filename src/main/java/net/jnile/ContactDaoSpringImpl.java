package net.jnile;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ContactDaoSpringImpl implements ContactDao {

    private JdbcTemplate jdbcTemplate;

    private final static String SQL_INSERT = "INSERT INTO contact_table(first_name, last_name) VALUES (?, ?)";

    private final static String SQL_SELECT_1 = "SELECT *, cdt.id AS cdt_id, cdt.mobile_phone AS ctd_mobile_phone FROM contact_table AS ct LEFT JOIN contact_details_table AS cdt ON ct.id = cdt.id_contact WHERE ct.id = ?";

    @Override
    public void save(Contact contact) {

        jdbcTemplate.update(SQL_INSERT, contact.getFirstName(), contact.getLastName());

    }

    @Override
    public Contact getContactById(long id) {


        Contact query = jdbcTemplate.query(SQL_SELECT_1, new Object[]{id}, resultSet -> {

            Contact contact = null;

            Map<Long, Contact> contactMap = new HashMap<>();

            while (resultSet.next()) {

                long id1 = resultSet.getLong("id");
                contact = contactMap.get(id1);

                if (contact == null) {
                    contact = new Contact();

                    contact.setId(resultSet.getLong("id"));
                    contact.setFirstName(resultSet.getString("first_name"));
                    contact.setLastName(resultSet.getString("last_name"));
                    contact.setContactDetailsList(new ArrayList<>());
                }

                Long cdt_id = resultSet.getLong("cdt_id");
                if (cdt_id != null) {

                    ContactDetails contactDetails = new ContactDetails();
                    contactDetails.setId(resultSet.getLong("cdt_id"));
                    contactDetails.setMobilePhone(resultSet.getString("ctd_mobile_phone"));

                    contact.getContactDetailsList().add(contactDetails);
                }

                contactMap.put(id1, contact);
            }

            return contact;
        });

        return query;
    }


    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
