package integracion.proyectogradle.services;

import integracion.proyectogradle.dao.IPersonaDao;
import integracion.proyectogradle.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    private IPersonaDao personaDao;

    @Override
    public List<Persona> findAll() {
        return personaDao.findAll();
    }

    @Override
    public Optional<Persona> findById(Long id) {
        return personaDao.findById(id);
    }

    @Override
    public void delete(Long id) {
        personaDao.deleteById(id);
    }

    @Override
    public Persona save(Persona p) {
        return personaDao.save(p);
    }

}

