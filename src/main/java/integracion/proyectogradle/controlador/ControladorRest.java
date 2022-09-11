package integracion.proyectogradle.controlador;

import integracion.proyectogradle.entity.Asesor;
import integracion.proyectogradle.services.IAsesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/concesionario")
public class ControladorRest {
    @Autowired
    private IAsesorService asesorService;

    @GetMapping("/asesores")
    public List<Asesor> findAll(){
        return asesorService.findAll();
    }

    @GetMapping("/asesores/mayorSal") //Asesores que ganan más de 2000000
    public List<Asesor> findGreaterThat2M() {
        List<Asesor> asesors = new ArrayList<Asesor>();
        for (Asesor a: asesorService.findAll()){
            if(a.getSalario()>2000000)
                asesors.add(findById(a.getId_persona()));
        }
        return asesors;
    }

    @GetMapping("/asesores/{id}") //permite encontrar registros por un atributo de la entidad (en este caso categoría) suministrado por parámetro
    public Asesor findById(@PathVariable Long id){
        return asesorService.findById(id).orElse(null);
    }

    @DeleteMapping("asesores/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        asesorService.delete(id);
    }

    @PostMapping("/asesores")
    @ResponseStatus(HttpStatus.CREATED)
    public Asesor create(@RequestBody Asesor asesor){
        return asesorService.save(asesor);
    }

    @PutMapping("/asesores/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Asesor update(@PathVariable Long id, @RequestBody Asesor asesor) {
        Asesor cambiar=asesorService.findById(id).orElse(null);
        cambiar.setComision(asesor.getComision());
        cambiar.setGestionesactivas(asesor.getGestionesactivas());
        cambiar.setGestionescompletadas(asesor.getGestionescompletadas());
        cambiar.setSalario(asesor.getSalario());
        return asesorService.save(cambiar);
    }

}
