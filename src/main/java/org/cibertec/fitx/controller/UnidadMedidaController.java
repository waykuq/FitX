package org.cibertec.fitx.controller;

import org.cibertec.fitx.dto.UnidadMedidaDTO;
import org.cibertec.fitx.entity.UnidadMedidaEntity;
import org.cibertec.fitx.service.UnidadMedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/unidadesMedida")
@CrossOrigin(origins = "*")
public class UnidadMedidaController {

    private final UnidadMedidaService unidadMedidaService;

    @Autowired
    public UnidadMedidaController(UnidadMedidaService unidadMedidaService) {
        this.unidadMedidaService = unidadMedidaService;
    }

    // 1. Obtener todos los unidadesMedida
    @GetMapping({"/", ""})
    public ResponseEntity<List<UnidadMedidaDTO>> listarUnidadMedidas() {
        try {
            List<UnidadMedidaDTO> unidadesMedida = unidadMedidaService.listarUnidadMedidaDTO();
            return ResponseEntity.ok(unidadesMedida);
        } catch (Exception e) {
            System.err.println("Error inesperado al listar unidadesMedida: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    // 2. Obtener un unidadMedida por ID
    @GetMapping("/{id}")
    public ResponseEntity<UnidadMedidaDTO> obtenerUnidadMedida(@PathVariable Integer id) {
        try {
            UnidadMedidaDTO unidadMedidaDto = unidadMedidaService.buscarUnidadMedidaDtoPorId(id);
            return unidadMedidaDto != null ? ResponseEntity.ok(unidadMedidaDto) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            System.err.println("Error inesperado al obtener unidadMedida por ID: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    // 3. Crear nueva unidadMedida
    @PostMapping
    public ResponseEntity<String> crearUnidadMedida(@RequestBody UnidadMedidaEntity unidadMedida) {
        try {
            unidadMedidaService.guardar(unidadMedida);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (DataIntegrityViolationException e) {
            System.err.println("Error de integridad de datos al crear unidadMedida: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al crear unidadMedida: Verifique los datos. Posiblemente el nombre ya existe o hay datos inválidos.");
        } catch (Exception e) {
            System.err.println("Error inesperado al crear unidadMedida: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocurrió un error interno al crear el unidadMedida. Inténtelo de nuevo más tarde.");
        }
    }

    // 4. Editar unidadMedida
    @PutMapping("/{id}")
    public ResponseEntity<String> editarUnidadMedida(@PathVariable Integer id, @RequestBody UnidadMedidaEntity unidadMedida) {
        try {
            UnidadMedidaEntity actualEntity = unidadMedidaService.buscarPorId(id);

            if (actualEntity == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("UnidadMedida con ID " + id + " no encontrado.");
            }
            actualEntity.setNombre(unidadMedida.getNombre());
            actualEntity.setSimbolo(unidadMedida.getSimbolo());
            unidadMedidaService.guardar(actualEntity);

            return ResponseEntity.noContent().build();
        } catch (DataIntegrityViolationException e) {
            System.err.println("Error de integridad de datos al editar unidadMedida: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al editar unidadMedida: Verifique los datos. Posiblemente el nombre ya existe o hay datos inválidos.");
        } catch (Exception e) {
            System.err.println("Error inesperado al editar unidadMedida: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocurrió un error interno al editar el unidadMedida. Inténtelo de nuevo más tarde.");
        }
    }

    // 5. Eliminar unidadMedida
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUnidadMedida(@PathVariable Integer id) {
        try {
            UnidadMedidaEntity unidadMedidaExistente = unidadMedidaService.buscarPorId(id);
            if (unidadMedidaExistente == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("UnidadMedida con ID " + id + " no encontrado para eliminar.");
            }

            unidadMedidaService.eliminar(id);

            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            System.err.println("Error inesperado al eliminar unidadMedida: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocurrió un error interno al eliminar el unidadMedida. Inténtelo de nuevo más tarde.");
        }
    }
}