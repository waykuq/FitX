//package org.cibertec.fitx.controller;
//
//import org.cibertec.fitx.dto.EtiquetaDTO; // Importa el DTO de Etiqueta
//import org.cibertec.fitx.entity.EtiquetaEntity; // Se sigue usando para el request body de POST/PUT
//import org.cibertec.fitx.service.EtiquetaService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/etiquetas")
//@CrossOrigin(origins = "*") // Permite peticiones AJAX desde frontend local o remoto
//public class EtiquetaController {
//
//    @Autowired
//    private EtiquetaService etiquetaService;
//
//    // 1. Obtener todas las etiquetas (usuario + globales) como DTOs
//    @GetMapping({"/", ""})
//    public ResponseEntity<List<EtiquetaDTO>> listarEtiquetas(@RequestParam Integer usuarioId) {
//        List<EtiquetaDTO> etiquetas = etiquetaService.listarPorUsuario(usuarioId);
//        return ResponseEntity.ok(etiquetas);
//    }
//
//    // 2. Obtener una etiqueta por ID como DTO
//    @GetMapping("/{id}")
//    public ResponseEntity<EtiquetaDTO> obtenerEtiqueta(@PathVariable Integer id) {
//        // Asumiendo que el servicio ahora tiene un método para buscar y mapear a DTO
//        EtiquetaDTO etiquetaDto = etiquetaService.buscarEtiquetaDtoPorId(id);
//        return etiquetaDto != null ? ResponseEntity.ok(etiquetaDto) : ResponseEntity.notFound().build();
//    }
//
//    // 3. Crear nueva etiqueta (recibe Entity, devuelve DTO)
//    @PostMapping
//    public ResponseEntity<Void> crearEtiqueta(@RequestBody EtiquetaEntity etiqueta) {
//        etiqueta.setEstado("Activo");
//        etiquetaService.guardar(etiqueta);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }
//
//    // 4. Editar etiqueta (recibe Entity, devuelve DTO)
//    @PutMapping("/{id}")
//    public ResponseEntity<Void> editarEtiqueta(@PathVariable Integer id, @RequestBody EtiquetaEntity etiqueta) {
//        EtiquetaEntity actualEntity = etiquetaService.buscarPorId(id); // Buscar la entidad existente
//
//        if (actualEntity == null) return ResponseEntity.notFound().build();
//
//        actualEntity.setNombre(etiqueta.getNombre());
//        actualEntity.setColor(etiqueta.getColor());
//        etiquetaService.guardar(actualEntity);
//
//        return ResponseEntity.noContent().build();
//    }
//
//    // 5. Eliminar etiqueta (no cambia, ya que no devuelve un cuerpo)
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> eliminarEtiqueta(@PathVariable Integer id) {
//        etiquetaService.eliminar(id);
//        return ResponseEntity.noContent().build();
//    }
//}

package org.cibertec.fitx.controller;

import org.cibertec.fitx.dto.EtiquetaDTO;
import org.cibertec.fitx.entity.EtiquetaEntity;
import org.cibertec.fitx.service.EtiquetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etiquetas")
@CrossOrigin(origins = "*")
public class EtiquetaController {

    private final EtiquetaService etiquetaService; // Mejor usar inyección por constructor

    @Autowired
    public EtiquetaController(EtiquetaService etiquetaService) {
        this.etiquetaService = etiquetaService;
    }

    // 1. Obtener todas las etiquetas (usuario + globales)
    @GetMapping({"/", ""})
    public ResponseEntity<List<EtiquetaDTO>> listarEtiquetas(@RequestParam(required = false) Integer usuarioId) {
        try {
            List<EtiquetaDTO> etiquetas = etiquetaService.listarPorUsuario(usuarioId);
            return ResponseEntity.ok(etiquetas);
        } catch (Exception e) {
            System.err.println("Error inesperado al listar etiquetas: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    // 2. Obtener una etiqueta por ID
    @GetMapping("/{id}")
    public ResponseEntity<EtiquetaDTO> obtenerEtiqueta(@PathVariable Integer id) {
        try {
            EtiquetaDTO etiquetaDto = etiquetaService.buscarEtiquetaDtoPorId(id);
            return etiquetaDto != null ? ResponseEntity.ok(etiquetaDto) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            System.err.println("Error inesperado al obtener etiqueta por ID: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    // 3. Crear nueva etiqueta
    @PostMapping
    public ResponseEntity<String> crearEtiqueta(@RequestBody EtiquetaEntity etiqueta) {
        try {
            etiqueta.setEstado("Activo");
            etiquetaService.guardar(etiqueta);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (DataIntegrityViolationException e) {
            System.err.println("Error de integridad de datos al crear etiqueta: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al crear etiqueta: Verifique los datos. Posiblemente el nombre ya existe o hay datos inválidos.");
        } catch (Exception e) {
            System.err.println("Error inesperado al crear etiqueta: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocurrió un error interno al crear la etiqueta. Inténtelo de nuevo más tarde.");
        }
    }

    // 4. Editar etiqueta
    @PutMapping("/{id}")
    public ResponseEntity<String> editarEtiqueta(@PathVariable Integer id, @RequestBody EtiquetaEntity etiqueta) {
        try {
            EtiquetaEntity actualEntity = etiquetaService.buscarPorId(id);

            if (actualEntity == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Etiqueta con ID " + id + " no encontrada.");
            }

            actualEntity.setNombre(etiqueta.getNombre());
            actualEntity.setColor(etiqueta.getColor());

            etiquetaService.guardar(actualEntity);
            return ResponseEntity.noContent().build();
        } catch (DataIntegrityViolationException e) {
            System.err.println("Error de integridad de datos al editar etiqueta: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al editar etiqueta: Verifique los datos. Posiblemente el nombre ya existe o hay datos inválidos.");
        } catch (Exception e) {
            System.err.println("Error inesperado al editar etiqueta: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocurrió un error interno al editar la etiqueta. Inténtelo de nuevo más tarde.");
        }
    }

    // 5. Eliminar etiqueta
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEtiqueta(@PathVariable Integer id) {
        try {
            EtiquetaEntity etiquetaExistente = etiquetaService.buscarPorId(id);
            if (etiquetaExistente == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Etiqueta con ID " + id + " no encontrada para eliminar.");
            }

            etiquetaService.eliminar(id);

            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            System.err.println("Error inesperado al eliminar etiqueta: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocurrió un error interno al eliminar la etiqueta. Inténtelo de nuevo más tarde.");
        }
    }
}