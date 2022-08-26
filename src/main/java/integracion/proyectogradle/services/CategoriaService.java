package integracion.proyectogradle.services;

import integracion.proyectogradle.dao.ICategoriaDAO;
import integracion.proyectogradle.entity.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements ICategoriaService{
    @Autowired
    private ICategoriaDAO categoriaDAO;
    @Override
    public List<Categoria> findAll() {
        return categoriaDAO.findAll();
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        return categoriaDAO.findById(id);
    }

    @Override
    public void delete(Long id) {
        categoriaDAO.deleteById(id);
    }

    @Override
    public Categoria save(Categoria e){
        return categoriaDAO.save(e);
    }

}
