package gm.contactos.Services;

import gm.contactos.Repository.ContactoRepository;
import gm.contactos.models.Contacto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoServiceImpl implements ContactoService {

    private final ContactoRepository contactoRepository;
    public ContactoServiceImpl(ContactoRepository contactoRepository) {
        this.contactoRepository = contactoRepository;
    }

    @Override
    public List<Contacto> findAll() {
        return contactoRepository.findAll();
    }

    @Override
    public Contacto findById(Integer id) {
        return contactoRepository.findById(id).orElse(null);
    }

    @Override
    public Contacto findByNombre(String nombre) {
        return contactoRepository.findByNombre(nombre);
    }

    @Override
    public Contacto findByCelular(String celular) {
        return contactoRepository.findByCelular(celular);
    }

    @Override
    public Contacto findByEmail(String email) {
        return contactoRepository.findByEmail(email);
    }

    @Override
    public void save(Contacto contacto) {
        contactoRepository.save(contacto);
    }

    @Override
    public void deleteById(Integer id) {
        contactoRepository.deleteById(id);
    }

    @Override
    public void deleteByNombre(String nombre) {
        contactoRepository.delete(findByNombre(nombre));
    }

    @Override
    public void deleteByCelular(String celular) {
        contactoRepository.delete(findByCelular(celular));
    }

    @Override
    public void deleteByEmail(String email) {
        contactoRepository.delete(findByEmail(email));
    }
}
