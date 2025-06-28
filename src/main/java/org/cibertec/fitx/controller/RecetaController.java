package org.cibertec.fitx.controller;

import jakarta.servlet.http.HttpSession;
import org.cibertec.fitx.dto.EtiquetaDTO;
import org.cibertec.fitx.dto.InsumoDTO;
import org.cibertec.fitx.dto.RecetaDTO;
import org.cibertec.fitx.dto.UsuarioDTO;
import org.cibertec.fitx.entity.InsumoEntity;
import org.cibertec.fitx.entity.UsuarioEntity;
import org.cibertec.fitx.service.InsumoService;
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

    // 2. Obtener un insumo por ID
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

//    // 3. Crear nuevo insumo
//    @PostMapping
//    public ResponseEntity<String> crearInsumo(@RequestBody InsumoEntity insumo) {
//        try {
//            insumo.setEstado("Activo");
//            insumoService.guardar(insumo);
//            return ResponseEntity.status(HttpStatus.CREATED).build();
//        } catch (DataIntegrityViolationException e) {
//            System.err.println("Error de integridad de datos al crear insumo: " + e.getMessage());
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body("Error al crear insumo: Verifique los datos. Posiblemente el nombre ya existe o hay datos inválidos.");
//        } catch (Exception e) {
//            System.err.println("Error inesperado al crear insumo: " + e.getMessage());
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Ocurrió un error interno al crear el insumo. Inténtelo de nuevo más tarde.");
//        }
//    }
//
//    // 4. Editar insumo
//    @PutMapping("/{id}")
//    public ResponseEntity<String> editarInsumo(@PathVariable Integer id, @RequestBody InsumoEntity insumo) {
//        try {
//            insumo.setEstado("Activo");
//            InsumoEntity actualEntity = insumoService.buscarPorId(id);
//
//            if (actualEntity == null) {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                        .body("Insumo con ID " + id + " no encontrado.");
//            }
//
//            actualEntity.setNombre(insumo.getNombre());
//            actualEntity.setEstado("Activo");
//            actualEntity.setTipoInsumo(insumo.getTipoInsumo());
//            actualEntity.setUnidadMedida(insumo.getUnidadMedida());
//
//            insumoService.guardar(actualEntity);
//            return ResponseEntity.noContent().build();
//        } catch (DataIntegrityViolationException e) {
//            System.err.println("Error de integridad de datos al editar insumo: " + e.getMessage());
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body("Error al editar insumo: Verifique los datos. Posiblemente el nombre ya existe o hay datos inválidos.");
//        } catch (Exception e) {
//            System.err.println("Error inesperado al editar insumo: " + e.getMessage());
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Ocurrió un error interno al editar el insumo. Inténtelo de nuevo más tarde.");
//        }
//    }
//
//    // 5. Eliminar insumo
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> eliminarInsumo(@PathVariable Integer id) {
//        try {
//            InsumoEntity insumoExistente = insumoService.buscarPorId(id);
//            if (insumoExistente == null) {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                        .body("Insumo con ID " + id + " no encontrado para eliminar.");
//            }
//
//            insumoService.eliminar(id);
//
//            return ResponseEntity.noContent().build();
//        } catch (Exception e) {
//            System.err.println("Error inesperado al eliminar insumo: " + e.getMessage());
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Ocurrió un error interno al eliminar el insumo. Inténtelo de nuevo más tarde.");
//        }
//    }
}