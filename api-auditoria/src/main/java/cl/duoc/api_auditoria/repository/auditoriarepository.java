package cl.duoc.api_auditoria.repository;

import cl.duoc.api_auditoria.model.Auditoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface auditoriarepository extends JpaRepository<Auditoria, Long> {

    List<Auditoria> findByComponenteId(Long componenteId);

    List<Auditoria> findByFechaRegistroBetween(LocalDateTime inicio, LocalDateTime fin);
}