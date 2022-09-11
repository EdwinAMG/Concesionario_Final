package integracion.proyectogradle.services;

import integracion.proyectogradle.dao.IAsesorDao;
import integracion.proyectogradle.entity.Asesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsesorService implements IAsesorService{

    @Autowired
    private IAsesorDao asesorDao;

    @Override
    public List<Asesor> findAll() {
        return asesorDao.findAll();
    }

    @Override
    public Optional<Asesor> findById(Long id) {
        return asesorDao.findById(id);
    }

    @Override
    public void delete(Long id) {
        asesorDao.deleteById(id);
    }

    @Override
    public Asesor save(Asesor a) {
        return asesorDao.save(a);
    }

}

