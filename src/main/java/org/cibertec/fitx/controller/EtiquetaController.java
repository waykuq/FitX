package org.cibertec.fitx.controller;

import org.cibertec.fitx.entity.EtiquetaEntity;
import org.cibertec.fitx.service.EtiquetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etiquetas")
@CrossOrigin(origins = "*") // permite peticiones AJAX desde frontend local o remoto
public class EtiquetaController {

    @Autowired
    private EtiquetaService etiquetaService;

    // 1. Obtener todas las etiquetas (usuario + globales)
    @GetMapping({"/", ""})
    public List<EtiquetaEntity> listarEtiquetas(@RequestParam Integer usuarioId) {
        return etiquetaService.listarPorUsuario(usuarioId);
    }

    // 2. Obtener una etiqueta por ID
    @GetMapping("/{id}")
    public ResponseEntity<EtiquetaEntity> obtenerEtiqueta(@PathVariable Integer id) {
        EtiquetaEntity etiqueta = etiquetaService.buscarPorId(id);
        return etiqueta != null ? ResponseEntity.ok(etiqueta) : ResponseEntity.notFound().build();
    }

    // 3. Crear nueva etiqueta
    @PostMapping
    public ResponseEntity<EtiquetaEntity> crearEtiqueta(@RequestBody EtiquetaEntity etiqueta) {
        EtiquetaEntity nueva = etiquetaService.guardarGet(etiqueta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    // 4. Editar etiqueta
    @PutMapping("/{id}")
    public ResponseEntity<EtiquetaEntity> editarEtiqueta(@PathVariable Integer id, @RequestBody EtiquetaEntity etiqueta) {
        EtiquetaEntity actual = etiquetaService.buscarPorId(id);
        if (actual == null) return ResponseEntity.notFound().build();

        actual.setNombre(etiqueta.getNombre());
        actual.setColor(etiqueta.getColor());
        actual.setUsuario(etiqueta.getUsuario());

        EtiquetaEntity actualizada = etiquetaService.guardarGet(actual);
        return ResponseEntity.ok(actualizada);
    }

    // 5. Eliminar etiqueta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEtiqueta(@PathVariable Integer id) {
        etiquetaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

