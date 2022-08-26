package integracion.proyectogradle.controlador;

import integracion.proyectogradle.entity.Categoria;
import integracion.proyectogradle.services.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControladorRest {
    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping("/categoria")
    public List<Categoria> findAll(){
        return categoriaService.findAll();
    }
    @GetMapping("/categoria/{id}") //permite encontrar registros por un atributo de la entidad (en este caso categoría) suministrado por parámetro
    public Categoria findAll(@PathVariable Long id){
        return categoriaService.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        categoriaService.delete(id);
    }

    @PostMapping("/categoria")
    public Categoria create(@RequestBody Categoria categoria){
        return categoriaService.save(categoria);
    }

    @PutMapping("/categoria/{id}")
    public Categoria update(@PathVariable Long id, @RequestBody Categoria categoria){ //NOTA: IMPLEMENTAR EL MÉTODO PARA VALIDAR DATOS QUE NO EXISTAN.
        Categoria actual=categoriaService.findById(id).orElse(null);
        actual.setDescripcion(categoria.getDescripcion());
        actual.setEstado(categoria.getEstado());
        return categoriaService.save(actual);
    }

    //ejemplo

}
