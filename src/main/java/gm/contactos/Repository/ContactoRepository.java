package gm.contactos.Repository;

import gm.contactos.models.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoRepository  extends JpaRepository<Contacto, Integer> {
    Contacto findByNombre(String nombre);
    Contacto findByEmail(String email);
    Contacto findByCelular(String celular);
}
