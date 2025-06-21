package org.cibertec.fitx.controller;

import org.cibertec.fitx.dto.TipoInsumoDTO;
import org.cibertec.fitx.entity.TipoInsumoEntity;
import org.cibertec.fitx.service.TipoInsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tiposInsumo")
@CrossOrigin(origins = "*")
public class TipoInsumoController {

    private final TipoInsumoService tipoInsumoService;

    @Autowired
    public TipoInsumoController(TipoInsumoService tipoInsumoService) {
        this.tipoInsumoService = tipoInsumoService;
    }

    // 1. Obtener todos los tipoInsumos
    @GetMapping({"/", ""})
    public ResponseEntity<List<TipoInsumoDTO>> listarTipoInsumos() {
        try {
            List<TipoInsumoDTO> tipoInsumos = tipoInsumoService.listarTipoInsumoDTO();
            return ResponseEntity.ok(tipoInsumos);
        } catch (Exception e) {
            System.err.println("Error inesperado al listar tipoInsumos: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    // 2. Obtener un tipoInsumo por ID
    @GetMapping("/{id}")
    public ResponseEntity<TipoInsumoDTO> obtenerTipoInsumo(@PathVariable Integer id) {
        try {
            TipoInsumoDTO tipoInsumoDto = tipoInsumoService.buscarTipoInsumoDtoPorId(id);
            return tipoInsumoDto != null ? ResponseEntity.ok(tipoInsumoDto) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            System.err.println("Error inesperado al obtener tipoInsumo por ID: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    // 3. Crear nueva tipoInsumo
    @PostMapping
    public ResponseEntity<String> crearTipoInsumo(@RequestBody TipoInsumoEntity tipoInsumo) {
        try {
            tipoInsumoService.guardar(tipoInsumo);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (DataIntegrityViolationException e) {
            System.err.println("Error de integridad de datos al crear tipoInsumo: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al crear tipoInsumo: Verifique los datos. Posiblemente el nombre ya existe o hay datos inválidos.");
        } catch (Exception e) {
            System.err.println("Error inesperado al crear tipoInsumo: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocurrió un error interno al crear el tipoInsumo. Inténtelo de nuevo más tarde.");
        }
    }

    // 4. Editar tipoInsumo
    @PutMapping("/{id}")
    public ResponseEntity<String> editarTipoInsumo(@PathVariable Integer id, @RequestBody TipoInsumoEntity tipoInsumo) {
        try {
            TipoInsumoEntity actualEntity = tipoInsumoService.buscarPorId(id);

            if (actualEntity == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("TipoInsumo con ID " + id + " no encontrado.");
            }

            actualEntity.setNombre(tipoInsumo.getNombre());
            tipoInsumoService.guardar(actualEntity);
            return ResponseEntity.noContent().build();
        } catch (DataIntegrityViolationException e) {
            System.err.println("Error de integridad de datos al editar tipoInsumo: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al editar tipoInsumo: Verifique los datos. Posiblemente el nombre ya existe o hay datos inválidos.");
        } catch (Exception e) {
            System.err.println("Error inesperado al editar tipoInsumo: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocurrió un error interno al editar el tipoInsumo. Inténtelo de nuevo más tarde.");
        }
    }

    // 5. Eliminar tipoInsumo
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTipoInsumo(@PathVariable Integer id) {
        try {
            TipoInsumoEntity tipoInsumoExistente = tipoInsumoService.buscarPorId(id);
            if (tipoInsumoExistente == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("TipoInsumo con ID " + id + " no encontrado para eliminar.");
            }

            tipoInsumoService.eliminar(id);

            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            System.err.println("Error inesperado al eliminar tipoInsumo: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocurrió un error interno al eliminar el tipoInsumo. Inténtelo de nuevo más tarde.");
        }
    }
}