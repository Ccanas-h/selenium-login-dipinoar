import com.knf.dev.model.Role;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RoleTest {

    @Test
    public void testGetId() {
        // Crear una instancia de Role
        Role role = new Role("Admin");
        
        // Establecer un ID
        role.setId(1L);
        
        // Verificar el ID
        assertEquals(1L, role.getId());
    }
    
    @Test
    public void testGetName() {
        // Crear una instancia de Role
        Role role = new Role("Admin");
        
        // Verificar el nombre
        assertEquals("Admin", role.getName());
    }
    
    @Test
    public void testSetName() {
        // Crear una instancia de Role
        Role role = new Role();
        
        // Establecer el nombre
        role.setName("User");
        
        // Verificar el nombre
        assertEquals("User", role.getName());
    }
}
