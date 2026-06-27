package cl.duoc.api_auditoria.Controller;

import cl.duoc.api_auditoria.model.Auditoria;
import cl.duoc.api_auditoria.service.AuditoriaService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/auditorias")
public class AuditoriaController {

    private final AuditoriaService service;

    public AuditoriaController(AuditoriaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Auditoria> obtenerTodas() {
        return service.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Auditoria buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/componente/{id}")
    public List<Auditoria> buscarPorComponente(@PathVariable Long id) {
        return service.buscarPorComponente(id);
    }

    @GetMapping("/rango")
    public List<Auditoria> buscarPorRango(
            @RequestParam String inicio,
            @RequestParam String fin) {

        return service.buscarPorRangoFechas(
                LocalDateTime.parse(inicio),
                LocalDateTime.parse(fin)
        );
    }

    @PostMapping
    public Auditoria guardar(@RequestBody Auditoria auditoria) {
        return service.guardar(auditoria);
    }
}