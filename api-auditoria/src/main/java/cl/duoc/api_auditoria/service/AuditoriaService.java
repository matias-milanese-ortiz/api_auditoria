package cl.duoc.api_auditoria.service;

import cl.duoc.api_auditoria.model.Auditoria;
import cl.duoc.api_auditoria.repository.auditoriarepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuditoriaService {

    private final auditoriarepository repository;

    public AuditoriaService(auditoriarepository repository) {
        this.repository = repository;
    }

    public List<Auditoria> obtenerTodas() {
        return repository.findAll();
    }

    public Auditoria buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Auditoria> buscarPorComponente(Long componenteId) {
        return repository.findByComponenteId(componenteId);
    }

    public List<Auditoria> buscarPorRangoFechas(LocalDateTime inicio, LocalDateTime fin) {
        return repository.findByFechaRegistroBetween(inicio, fin);
    }

    public Auditoria guardar(Auditoria auditoria) {
        return repository.save(auditoria);
    }
}
