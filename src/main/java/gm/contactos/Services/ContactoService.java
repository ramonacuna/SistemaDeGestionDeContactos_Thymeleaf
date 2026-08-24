package gm.contactos.Services;

import gm.contactos.models.Contacto;

import java.util.List;

public interface ContactoService {
    List<Contacto> findAll();
    Contacto findById(Integer id);
    Contacto findByNombre(String nombre);
    Contacto findByCelular(String celular);
    Contacto findByEmail(String email);
    void save(Contacto contacto);
    void deleteById(Integer id);
    void deleteByNombre(String nombre);
    void deleteByCelular(String celular);
    void deleteByEmail(String email);



}
