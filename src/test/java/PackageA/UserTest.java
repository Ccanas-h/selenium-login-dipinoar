 import com.knf.dev.model.Role;
import com.knf.dev.model.User;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        List<Role> roles = new ArrayList<>();
        roles.add(new Role("ROLE_USER"));
        this.user = new User("cristobal", "canas", "cristobal.canas@example.com", "password", roles);
        this.user.setId(1L);
    }


    @Test
    public void testGettersAndSetters() {
        assertNotNull(user.getId());
        assertEquals("cristobal", user.getFirstName());
        assertEquals("canas", user.getLastName());
        assertEquals("cristobal.canas@example.com", user.getEmail());
        assertEquals("password", user.getPassword());
        assertNotNull(user.getRoles());

        user.setFirstName("Jane");
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.com");
        user.setPassword("newpassword");
        List<Role> newRoles = new ArrayList<>();
        newRoles.add(new Role("ROLE_ADMIN"));
        user.setRoles(newRoles);

        assertEquals("Jane", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals("jane.doe@example.com", user.getEmail());
        assertEquals("newpassword", user.getPassword());
        assertEquals(1, user.getRoles().size());
    }

}
 