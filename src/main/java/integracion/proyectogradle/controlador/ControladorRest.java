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
    @Autowired
    private INuevoService nuevoService;
    @Autowired
    private IUsadoService usadoService;


    @GetMapping("/vehiculos")
    public List<Vehiculo> findAllVehicles(){
        return vehiculoService.findAll();
    }
    @GetMapping("/vehiculos/nuevos")
    public List<Nuevo> findAllVehiclesNews(){
        return nuevoService.findAll();
    }
    @GetMapping("/vehiculos/usados")
    public List<Usado> findAllVehiclesUsed(){
        return usadoService.findAll();
    }

    @GetMapping("/vehiculos/{id}")
    public Vehiculo findByIdVehicles(@PathVariable Long id){
        return vehiculoService.findById(id).orElse(null);
    }
    @GetMapping("/vehiculos/nuevos/{id}")
    public Nuevo findByIdVehiclesNews(@PathVariable Long id){
        return nuevoService.findById(id).orElse(null);
    }
    @GetMapping("/vehiculos/usados/{id}")
    public Usado findByIdVehiclesUsed(@PathVariable Long id){
        return usadoService.findById(id).orElse(null);
    }

    @GetMapping("vehiculos/nuevos/mayorValor") //Vehiculos Nuevos que cuestan más de 250M
    public List<Nuevo> findGreater250MNews() {
        List<Nuevo> newsGreater = new ArrayList<Nuevo>();
        for (Nuevo n: nuevoService.findAll()){
            if(n.getValorventa()>250000000)
                newsGreater.add(findByIdVehiclesNews(n.getId_vehiculo()));
        } return newsGreater;
    }
    @GetMapping("vehiculos/nuevos/menorValor") //Vehiculos Nuevos que cuestan menos de 200M
    public List<Nuevo> findSmaller200MNews() {
        List<Nuevo> newsSmaller = new ArrayList<Nuevo>();
        for (Nuevo n: nuevoService.findAll()){
            if(n.getValorventa()<200000000)
                newsSmaller.add(findByIdVehiclesNews(n.getId_vehiculo()));
        } return newsSmaller;
    }
    @GetMapping("vehiculos/usados/menorRenta/{valorrenta}") //Vehiculos Usados que se rentan por menos de un valor X
    public List<Usado> findSmallerUsed(@PathVariable Double valorrenta) {
        List<Usado> usedSmaller = new ArrayList<Usado>();
        for (Usado u: usadoService.findAll()){
            if(u.getValorrenta()<valorrenta)
                usedSmaller.add(findByIdVehiclesUsed(u.getId_vehiculo()));
        } return usedSmaller;
    }

    @DeleteMapping("vehiculos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVehicles(@PathVariable Long id){
        vehiculoService.delete(id);
    }
    @DeleteMapping("vehiculos/nuevos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVehiclesNews(@PathVariable Long id){
        nuevoService.delete(id);
    }
    @DeleteMapping("vehiculos/usados/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVehiclesUsed(@PathVariable Long id){
        usadoService.delete(id);
    }

    @PostMapping("/vehiculos")
    @ResponseStatus(HttpStatus.CREATED)
    public Vehiculo createVehicles(@RequestBody Vehiculo vehiculo){
        return vehiculoService.save(vehiculo);
    }
    @PostMapping("/vehiculos/nuevos")
    @ResponseStatus(HttpStatus.CREATED)
    public Nuevo createVehicles(@RequestBody Nuevo nuevo){
        return nuevoService.save(nuevo);
    }
    @PostMapping("/vehiculos/usados")
    @ResponseStatus(HttpStatus.CREATED)
    public Usado createVehicles(@RequestBody Usado usado){
        return usadoService.save(usado);
    }

    @PutMapping("/vehiculos/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Vehiculo updateVehicles(@PathVariable Long id, @RequestBody Vehiculo vehiculo) {
        Vehiculo changeVehicles=vehiculoService.findById(id).orElse(null);
        changeVehicles.setMatricula(vehiculo.getMatricula());
        changeVehicles.setMarca(vehiculo.getMarca());
        changeVehicles.setModelo(vehiculo.getModelo());
        changeVehicles.setVehiculo_type(vehiculo.getVehiculo_type());
        return vehiculoService.save(changeVehicles);
    }
    @PutMapping("/vehiculos/nuevos/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Nuevo updateVehiclesNews(@PathVariable Long id, @RequestBody Nuevo nuevo) {
        Nuevo changeVehiclesNews=nuevoService.findById(id).orElse(null);
        changeVehiclesNews.setColor(nuevo.getColor());
        changeVehiclesNews.setProcedencia(nuevo.getProcedencia());
        changeVehiclesNews.setPropietario(nuevo.getPropietario());
        changeVehiclesNews.setValorventa(nuevo.getValorventa());
        changeVehiclesNews.setGarantia(nuevo.getGarantia());
        return nuevoService.save(changeVehiclesNews);
    }
    @PutMapping("/vehiculos/usados/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Usado updateVehiclesUsed(@PathVariable Long id, @RequestBody Usado usado) {
        Usado changeVehiclesUsed=usadoService.findById(id).orElse(null);
        changeVehiclesUsed.setKilometraje(usado.getKilometraje());
        changeVehiclesUsed.setValorrenta(usado.getValorrenta());
        changeVehiclesUsed.setEstado(usado.getEstado());
        return usadoService.save(changeVehiclesUsed);
    }

    //---VENTA---//
    @Autowired
    private IVentaService ventaService;

    @GetMapping("/ventas")
    public List<Venta> findAllSales(){
        return ventaService.findAll();
    }

    @GetMapping("/ventas/{id}")
    public Venta findByIdSale(@PathVariable Long id){
        return ventaService.findById(id).orElse(null);
    }

    @GetMapping("ventas/mayorValor") //Ventas que superan los de 200M
    public List<Venta> findGreater200MSales() {
        List<Venta> salesGreater = new ArrayList<Venta>();
        for (Venta v: ventaService.findAll()){
            if(v.getValor()>250000000)
                salesGreater.add(findByIdSale(v.getId_venta()));
        } return salesGreater;
    }

    @DeleteMapping("ventas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSales(@PathVariable Long id){
        ventaService.delete(id);
    }

    @PostMapping("/ventas")
    @ResponseStatus(HttpStatus.CREATED)
    public Venta createSales(@RequestBody Venta venta){
        return ventaService.save(venta);
    }

    @PutMapping("/ventas/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Venta updateSales(@PathVariable Long id, @RequestBody Venta venta) {
        Venta changeSales=ventaService.findById(id).orElse(null);
        changeSales.setAsesor_id_persona(venta.getAsesor_id_persona());
        changeSales.setCliente_id_persona(venta.getCliente_id_persona());
        changeSales.setNuevo_id_vehiculo(venta.getNuevo_id_vehiculo());
        changeSales.setFecha(venta.getFecha());
        changeSales.setTipotransaccion(venta.getTipotransaccion());
        changeSales.setCuotas(venta.getCuotas());
        changeSales.setValor(venta.getValor());
        changeSales.setEstado(venta.getEstado());
        return ventaService.save(changeSales);
    }

    //---SERVICIO---//
    @Autowired
    private IServicioService servicioService;

    @GetMapping("/servicios")
    public List<Servicio> findAllServices(){
        return servicioService.findAll();
    }

    @GetMapping("/servicios/{id}")
    public Servicio findByIdService(@PathVariable Long id){
        return servicioService.findById(id).orElse(null);
    }

    @GetMapping("servicios/mayorValor") //Ventas que superan los de 2M
    public List<Servicio> findGreater2MServices() {
        List<Servicio> servicesGreater = new ArrayList<Servicio>();
        for (Servicio s: servicioService.findAll()){
            if(s.getValorservicio()>2000000)
                servicesGreater.add(findByIdService(s.getId_servicio()));
        } return servicesGreater;
    }

    @DeleteMapping("servicios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteServices(@PathVariable Long id){
        servicioService.delete(id);
    }

    @PostMapping("/servicios")
    @ResponseStatus(HttpStatus.CREATED)
    public Servicio createServices(@RequestBody Servicio servicio){
        return servicioService.save(servicio);
    }

    @PutMapping("/servicios/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Servicio updateServices(@PathVariable Long id, @RequestBody Servicio servicio) {
        Servicio changeServices=servicioService.findById(id).orElse(null);
        changeServices.setUsado_id_vehiculo(servicio.getUsado_id_vehiculo());
        changeServices.setCliente_id_persona(servicio.getCliente_id_persona());
        changeServices.setTecnico_id_persona(servicio.getTecnico_id_persona());
        changeServices.setFechainicio(servicio.getFechainicio());
        changeServices.setFechafinalizacion(servicio.getFechafinalizacion());
        changeServices.setTiposervicio(servicio.getTiposervicio());
        changeServices.setValorservicio(servicio.getValorservicio());
        changeServices.setObservaciones(servicio.getObservaciones());
        return servicioService.save(changeServices);
    }

}