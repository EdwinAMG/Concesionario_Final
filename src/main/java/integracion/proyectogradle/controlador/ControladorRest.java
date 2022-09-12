package integracion.proyectogradle.controlador;

import integracion.proyectogradle.entity.*;
import integracion.proyectogradle.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/concesionario")
public class ControladorRest {
    //---PERSONAS---//
    @Autowired
    private IPersonaService personaService;
    @Autowired
    private IAsesorService asesorService;
    @Autowired
    private ITecnicoService tecnicoService;
    @Autowired
    private IClienteService clienteService;

    @GetMapping("/personas")
    public List<Persona> findAllPerson(){
        return personaService.findAll();
    }
    @GetMapping("personas/asesores")
    public List<Asesor> findAllAdvisers(){
        return asesorService.findAll();
    }
    @GetMapping("personas/tecnicos")
    public List<Tecnico> findAllTechnicians(){
        return tecnicoService.findAll();
    }
    @GetMapping("personas/clientes")
    public List<Cliente> findAllClients(){
        return clienteService.findAll();
    }

    @GetMapping("personas/{id}")
    public Persona findByIdPerson(@PathVariable Long id){
        return personaService.findById(id).orElse(null);
    }
    @GetMapping("personas/asesores/{id}")
    public Asesor findByIdAdvisers(@PathVariable Long id){
        return asesorService.findById(id).orElse(null);
    }
    @GetMapping("personas/tecnicos/{id}")
    public Tecnico findByIdTechnicians(@PathVariable Long id){
        return tecnicoService.findById(id).orElse(null);
    }
    @GetMapping("personas/clientes/{id}")
    public Cliente findByIdClients(@PathVariable Long id){
        return clienteService.findById(id).orElse(null);
    }

    @GetMapping("personas/asesores/mayorSal") //Asesores que ganan más de 2000000
    public List<Asesor> findGreater2MAdvisers() {
        List<Asesor> advisers = new ArrayList<Asesor>();
        for (Asesor a: asesorService.findAll()){
            if(a.getSalario()>2000000)
                advisers.add(findByIdAdvisers(a.getId_persona()));
        } return advisers;
    }
    @GetMapping("personas/tecnicos/mayorSal") //Tecnicos que ganan más de 2000000
    public List<Tecnico> findGreater2MTechnicians() {
        List<Tecnico> technicians = new ArrayList<Tecnico>();
        for (Tecnico t: tecnicoService.findAll()){
            if(t.getSalario()>2000000)
                technicians.add(findByIdTechnicians(t.getId_persona()));
        } return technicians;
    }

    @DeleteMapping("personas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable Long id){
        personaService.delete(id);
    }
    @DeleteMapping("personas/asesores/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAdvisers(@PathVariable Long id){
        asesorService.delete(id);
    }
    @DeleteMapping("personas/tecnicos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTechnicians(@PathVariable Long id){
        tecnicoService.delete(id);
    }
    @DeleteMapping("personas/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClients(@PathVariable Long id){
        clienteService.delete(id);
    }

    @PostMapping("personas")
    @ResponseStatus(HttpStatus.CREATED)
    public Persona createPerson(@RequestBody Persona persona){
        return personaService.save(persona);
    }
    @PostMapping("personas/asesores")
    @ResponseStatus(HttpStatus.CREATED)
    public Asesor createAdvisers(@RequestBody Asesor asesor){
        return asesorService.save(asesor);
    }
    @PostMapping("personas/tecnicos")
    @ResponseStatus(HttpStatus.CREATED)
    public Tecnico createTechnicians(@RequestBody Tecnico tecnico){
        return tecnicoService.save(tecnico);
    }
    @PostMapping("personas/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente createClients(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }

    @PutMapping("personas/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Persona updatePerson(@PathVariable Long id, @RequestBody Persona persona) {
        Persona changePerson=personaService.findById(id).orElse(null);
        changePerson.setNombrecompleto(persona.getNombrecompleto());
        changePerson.setFechanacimiento(persona.getFechanacimiento());
        changePerson.setNick(persona.getNick());
        changePerson.setTelefono(persona.getTelefono());
        changePerson.setEmail(persona.getEmail());
        changePerson.setDireccion(persona.getDireccion());
        changePerson.setPersona_type(persona.getPersona_type());
        return personaService.save(changePerson);
    }
    @PutMapping("personas/{id}/persona_type")
    @ResponseStatus(HttpStatus.CREATED)
    public Persona updateTypePerson(@PathVariable Long id, @RequestBody Persona persona) {
        Persona changePerson=personaService.findById(id).orElse(null);
        changePerson.setPersona_type(persona.getPersona_type());
        return personaService.save(changePerson);
    }

    @PutMapping("personas/asesores/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Asesor updateAdvisers(@PathVariable Long id, @RequestBody Asesor asesor) {
        Asesor changeAdvisers=asesorService.findById(id).orElse(null);
        changeAdvisers.setComision(asesor.getComision());
        changeAdvisers.setGestionesactivas(asesor.getGestionesactivas());
        changeAdvisers.setGestionescompletadas(asesor.getGestionescompletadas());
        changeAdvisers.setSalario(asesor.getSalario());
        return asesorService.save(changeAdvisers);
    }
    @PutMapping("personas/tecnicos/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Tecnico updateTechnicians(@PathVariable Long id, @RequestBody Tecnico tecnico) {
        Tecnico changeTechnicians=tecnicoService.findById(id).orElse(null);
        changeTechnicians.setEspecialidad(tecnico.getEspecialidad());
        changeTechnicians.setExperiencia(tecnico.getExperiencia());
        changeTechnicians.setSalario(tecnico.getSalario());
        changeTechnicians.setVehiculosreparados(tecnico.getVehiculosreparados());
        return tecnicoService.save(changeTechnicians);
    }
    @PutMapping("personas/clientes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente updateClients(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente changeClients=clienteService.findById(id).orElse(null);
        changeClients.setCompras(cliente.getCompras());
        changeClients.setTipo(cliente.getTipo());
        return clienteService.save(changeClients);
    }

    //---VEHICULOS---//
    @Autowired
    private IVehiculoService vehiculoService;

    @GetMapping("/vehiculos")
    public List<Vehiculo> finaAllVehiculos(){
        return vehiculoService.findAll();
    }

    @GetMapping("/vehiculos/{id}")
    public Vehiculo findByIdVehiculo(@PathVariable Long id){
        return vehiculoService.findById(id).orElse(null);
    }

    @DeleteMapping("vehiculos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVehicles(@PathVariable Long id){
        vehiculoService.delete(id);
    }

    @PostMapping("/vehiculos")
    @ResponseStatus(HttpStatus.CREATED)
    public Vehiculo createVehicles(@RequestBody Vehiculo vehiculo){
        return vehiculoService.save(vehiculo);
    }

    @PutMapping("/vehiculos/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Vehiculo updateClients(@PathVariable Long id, @RequestBody Vehiculo vehiculo) {
        Vehiculo changeVehicles=vehiculoService.findById(id).orElse(null);
        changeVehicles.setMatricula(vehiculo.getMatricula());
        changeVehicles.setMarca(vehiculo.getMarca());
        changeVehicles.setModelo(vehiculo.getModelo());
        changeVehicles.setVehiculo_type(vehiculo.getVehiculo_type());
        return vehiculoService.save(changeVehicles);
    }

}