
package com.rolexapp.rolexreclamosapp;

import com.rolexapp.rolexreclamosapp.interfaces.IReclamos;
import com.rolexapp.rolexreclamosapp.models.Reclamos;
import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class reclamoTest {
    
    
    @Autowired
    private IReclamos reclamosRepository;
    
    @Test
    @Rollback(false)
    public void testguardarReclamo(){
        Reclamos reclamos = new Reclamos("pedro", "curi", "pedro@gmail.com", 900052692, "av isidro", "no llega el peddido", "nuevo");
   
        Reclamos  reclamosGuardado =reclamosRepository.save(reclamos);
        
        assertNotNull(reclamosGuardado);
    }
    @Test
    public void buscarCliente(){
        String nombre ="alan";
        Reclamos reclamos =reclamosRepository.findBynomClie(nombre);
        assertThat(reclamos.getNomClie()).isEqualTo(nombre);
    }
    
    /*@Test
    public void buscarCliente(){
        String nomClie = "kevin";
        Reclamos reclamos = reclamosRepository.findByNombreCliente(nomClie);        
        assertThat(reclamos.getNomClie()).isEqualTo(nomClie);
    }*/

   
    
}
