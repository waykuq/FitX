package org.cibertec.fitx.controller;

import jakarta.servlet.http.HttpSession;
import org.cibertec.fitx.dto.RecetaDTO;
import org.cibertec.fitx.dto.UsuarioDTO;
import org.cibertec.fitx.entity.RecetaEntity;
import org.cibertec.fitx.service.RecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recetas")
@CrossOrigin(origins = "*")
public class RecetaController {

    private final RecetaService recetaService;

    @Autowired
    public RecetaController(RecetaService recetaService) {
        this.recetaService = recetaService;
    }

    // 1. Obtener todos las recetas
    @GetMapping({"/", ""})
    public ResponseEntity<List<RecetaDTO>> listarRecetas(HttpSession session) {
        try {
            UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
            List<RecetaDTO> recetas = (usuario.getRolId() == 1) ? recetaService.listarRecetaDTO() : recetaService.listarPorUsuarioDTO(usuario.getId());
//            List<RecetaDTO> recetas = recetaService.listarPorUsuarioDTO(usuario.getId());

            for (RecetaDTO dto : recetas) {
                boolean editable = usuario.getRolId() == 1 || dto.getUsuarioId().equals(usuario.getId());
                dto.setEditable(editable);
            }

            return ResponseEntity.ok(recetas);
        } catch (Exception e) {
            System.err.println("Error inesperado al listar recetas: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    // 2. Obtener una receta por ID
    @GetMapping("/{id}")
    public ResponseEntity<RecetaDTO> obtenerReceta(@PathVariable Integer id, HttpSession session) {
        try {
            RecetaDTO recetaDto = recetaService.buscarRecetaDtoPorId(id);

            UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
            boolean editable = usuario.getRolId() == 1 || recetaDto.getUsuarioId().equals(usuario.getId());
            recetaDto.setEditable(editable);

            return recetaDto != null ? ResponseEntity.ok(recetaDto) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            System.err.println("Error inesperado al obtener receta por ID: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    // 3. Crear nueva receta
    @PostMapping
    public ResponseEntity<String> crearReceta(@RequestBody RecetaDTO recetaDTO, HttpSession session) {
        try {
            UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
            recetaDTO.setId(null);
            recetaDTO.setUsuarioId(usuario.getId());
            recetaService.guardarReceta(recetaDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (DataIntegrityViolationException e) {
            System.err.println("Error de integridad de datos al crear receta: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al crear receta: Verifique los datos. Posiblemente el nombre ya existe o hay datos inválidos.");
        } catch (Exception e) {
            System.err.println("Error inesperado al crear receta: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocurrió un error interno al crear el receta. Inténtelo de nuevo más tarde.");
        }
    }

    // 4. Editar receta
    @PutMapping("/{id}")
    public ResponseEntity<String> editarReceta(@PathVariable Integer id, @RequestBody RecetaDTO recetaDTO, HttpSession session) {
        try {
            recetaDTO.setId(id);
            recetaService.guardarReceta(recetaDTO);
            return ResponseEntity.noContent().build();
        } catch (DataIntegrityViolationException e) {
            System.err.println("Error de integridad de datos al editar receta: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al editar receta: Verifique los datos.");
        } catch (Exception e) {
            System.err.println("Error inesperado al editar receta: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocurrió un error interno al editar la receta. Inténtelo de nuevo más tarde.");
        }
    }

    // 5. Eliminar receta
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarReceta(@PathVariable Integer id) {
        try {
            RecetaEntity recetaExistente = recetaService.buscarPorId(id);
            if (recetaExistente == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Receta con ID " + id + " no encontrada para eliminar.");
            }

            recetaService.eliminar(id);

            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            System.err.println("Error inesperado al eliminar la receta: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocurrió un error interno al eliminar la receta. Inténtelo de nuevo más tarde.");
        }
    }
}