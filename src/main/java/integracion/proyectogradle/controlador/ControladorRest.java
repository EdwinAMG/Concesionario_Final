package integracion.proyectogradle.controlador;

import integracion.proyectogradle.entity.Asesor;
import integracion.proyectogradle.entity.Cliente;
import integracion.proyectogradle.entity.Tecnico;
import integracion.proyectogradle.services.IAsesorService;
import integracion.proyectogradle.services.ITecnicoService;
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
    @Autowired
    private ITecnicoService tecnicoService;

    @Autowired
    private ITecnicoService clienteService;

    @GetMapping("/asesores")
    public List<Asesor> findAllAdvisers(){
        return asesorService.findAll();
    }
    @GetMapping("/tecnicos")
    public List<Tecnico> findAllTechnicians(){
        return tecnicoService.findAll();
    }
    @GetMapping("/clientes")
    public List<Cliente> findAllClients(){
        return clienteService.findAll();
    }

    @GetMapping("/asesores/{id}")
    public Asesor findByIdAdvisers(@PathVariable Long id){
        return asesorService.findById(id).orElse(null);
    }
    @GetMapping("/tecnicos/{id}")
    public Tecnico findByIdTechnicians(@PathVariable Long id){
        return tecnicoService.findById(id).orElse(null);
    }
    @GetMapping("/clientes/{id}")
    public Tecnico findByIdClients(@PathVariable Long id){
        return clienteService.findById(id).orElse(null);
    }

    @GetMapping("/asesores/mayorSal") //Asesores que ganan más de 2000000
    public List<Asesor> findGreater2MAdvisers() {
        List<Asesor> advisers = new ArrayList<Asesor>();
        for (Asesor a: asesorService.findAll()){
            if(a.getSalario()>2000000)
                advisers.add(findByIdAdvisers(a.getId_persona()));
        }
        return advisers;
    }
    @GetMapping("/tecnicos/mayorSal") //Tecnicos que ganan más de 2000000
    public List<Tecnico> findGreater2MTechnicians() {
        List<Tecnico> technicians = new ArrayList<Tecnico>();
        for (Tecnico t: tecnicoService.findAll()){
            if(t.getSalario()>2000000)
                technicians.add(findByIdTechnicians(t.getId_persona()));
        }
        return technicians;
    }

    @DeleteMapping("asesores/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAdvisers(@PathVariable Long id){
        asesorService.delete(id);
    }
    @DeleteMapping("tecnicos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTechnicians(@PathVariable Long id){
        tecnicoService.delete(id);
    }
    @DeleteMapping("clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClients(@PathVariable Long id){
        tecnicoService.delete(id);
    }

    @PostMapping("/asesores")
    @ResponseStatus(HttpStatus.CREATED)
    public Asesor createAdvisers(@RequestBody Asesor asesor){
        return asesorService.save(asesor);
    }
    @PostMapping("/tecnicos")
    @ResponseStatus(HttpStatus.CREATED)
    public Tecnico createTechnicians(@RequestBody Tecnico tecnico){
        return tecnicoService.save(tecnico);
    }
    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente createClients(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }

    @PutMapping("/asesores/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Asesor updateAdvisers(@PathVariable Long id, @RequestBody Asesor asesor) {
        Asesor changeAdvisers=asesorService.findById(id).orElse(null);
        changeAdvisers.setComision(asesor.getComision());
        changeAdvisers.setGestionesactivas(asesor.getGestionesactivas());
        changeAdvisers.setGestionescompletadas(asesor.getGestionescompletadas());
        changeAdvisers.setSalario(asesor.getSalario());
        return asesorService.save(changeAdvisers);
    }
    @PutMapping("/tecnicos/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Tecnico updateTechnicians(@PathVariable Long id, @RequestBody Tecnico tecnico) {
        Tecnico changeTechnicians=tecnicoService.findById(id).orElse(null);
        changeTechnicians.setEspecialidad(tecnico.getEspecialidad());
        changeTechnicians.setExperiencia(tecnico.getExperiencia());
        changeTechnicians.setSalario(tecnico.getSalario());
        changeTechnicians.setVehiculosreparados(tecnico.getVehiculosreparados());
        return tecnicoService.save(changeTechnicians);
    }
    @PutMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente updateClients(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente changeClients=clienteService.findById(id).orElse(null);
        changeClients.setCompras(cliente.getCompras());
        changeClients.setTipo(cliente.getTipo());
        return clienteService.save(changeClients);
    }

}