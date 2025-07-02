package org.cibertec.fitx.controller;

import org.cibertec.fitx.dto.InsumoDTO;
import org.cibertec.fitx.entity.InsumoEntity;
import org.cibertec.fitx.service.InsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/insumos")
@CrossOrigin(origins = "*")
public class InsumoController {

    private final InsumoService insumoService;

    @Autowired
    public InsumoController(InsumoService insumoService) {
        this.insumoService = insumoService;
    }

    // 1. Obtener todos los insumos
    @GetMapping({"/", ""})
    public ResponseEntity<List<InsumoDTO>> listarInsumos() {
        try {
            List<InsumoDTO> insumos = insumoService.listarInsumoDTO();
            return ResponseEntity.ok(insumos);
        } catch (Exception e) {
            System.err.println("Error inesperado al listar insumos: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    // 2. Obtener un insumo por ID
    @GetMapping("/{id}")
    public ResponseEntity<InsumoDTO> obtenerInsumo(@PathVariable Integer id) {
        try {
            InsumoDTO insumoDto = insumoService.buscarInsumoDtoPorId(id);
            return insumoDto != null ? ResponseEntity.ok(insumoDto) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            System.err.println("Error inesperado al obtener insumo por ID: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    // 3. Crear nuevo insumo
    @PostMapping
    public ResponseEntity<String> crearInsumo(@RequestBody InsumoDTO insumoDto) {
        try {
            insumoService.guardarInsumoDTO(insumoDto);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (DataIntegrityViolationException e) {
            System.err.println("Error de integridad de datos al crear insumo: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al crear insumo: Verifique los datos. Posiblemente el nombre ya existe o hay datos inválidos.");
        } catch (Exception e) {
            System.err.println("Error inesperado al crear insumo: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocurrió un error interno al crear el insumo. Inténtelo de nuevo más tarde.");
        }
    }

    // 4. Editar insumo
    @PutMapping("/{id}")
    public ResponseEntity<String> editarInsumo(@PathVariable Integer id, @RequestBody InsumoDTO insumoDto) {
        try {
            InsumoEntity actualEntity = insumoService.buscarPorId(id);

            if (actualEntity == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Insumo con ID " + id + " no encontrado.");
            }

            insumoService.guardarInsumoDTO(insumoDto);
            return ResponseEntity.noContent().build();
        } catch (DataIntegrityViolationException e) {
            System.err.println("Error de integridad de datos al editar insumo: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al editar insumo: Verifique los datos. Posiblemente el nombre ya existe o hay datos inválidos.");
        } catch (Exception e) {
            System.err.println("Error inesperado al editar insumo: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocurrió un error interno al editar el insumo. Inténtelo de nuevo más tarde.");
        }
    }

    // 5. Eliminar insumo
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarInsumo(@PathVariable Integer id) {
        try {
            InsumoEntity insumoExistente = insumoService.buscarPorId(id);
            if (insumoExistente == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Insumo con ID " + id + " no encontrado para eliminar.");
            }

            insumoService.eliminar(id);

            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            System.err.println("Error inesperado al eliminar insumo: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocurrió un error interno al eliminar el insumo. Inténtelo de nuevo más tarde.");
        }
    }
}