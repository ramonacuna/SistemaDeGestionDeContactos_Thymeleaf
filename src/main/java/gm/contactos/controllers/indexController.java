package gm.contactos.controllers;

import gm.contactos.Services.ContactoService;
import gm.contactos.models.Contacto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class indexController {
    private final ContactoService contactoService;
    private final Logger log = LoggerFactory.getLogger(indexController.class);

    public indexController(ContactoService contactoService) {
        this.contactoService = contactoService;
    }

    @GetMapping("/")
    public String iniciar(ModelMap model) {
        List<Contacto> contactos = contactoService.findAll();
        contactos.forEach(contacto -> log.info(contacto.toString()));
        model.put("contactos",contactos);
        return "index";
    }

    @GetMapping("/agregar")
    public String mostrarAgregar(ModelMap model) {
        model.addAttribute("contactoForm", new Contacto());
        return "agregar";
    }

    @PostMapping ("/agregar")
    public  String agregar(@ModelAttribute("contactoForm") Contacto contacto) {
        log.info("Agregando contacto: {}", contacto);
        contactoService.save(contacto);
        return "redirect:/";
    }
}
