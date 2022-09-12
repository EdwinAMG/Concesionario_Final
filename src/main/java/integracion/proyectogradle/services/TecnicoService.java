package integracion.proyectogradle.services;

import integracion.proyectogradle.dao.ITecnicoDao;
import integracion.proyectogradle.entity.Tecnico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService implements ITecnicoService{

    @Autowired
    private ITecnicoDao tecnicoDao;

    @Override
    public List<Tecnico> findAll() {
        return tecnicoDao.findAll();
    }

    @Override
    public Optional<Tecnico> findById(Long id) {
        return tecnicoDao.findById(id);
    }

    @Override
    public void delete(Long id) {
        tecnicoDao.deleteById(id);
    }

    @Override
    public Tecnico save(Tecnico a) {
        return tecnicoDao.save(a);
    }

}

