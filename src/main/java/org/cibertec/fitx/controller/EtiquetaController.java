package org.cibertec.fitx.controller;

import jakarta.servlet.http.HttpSession;
import org.cibertec.fitx.dto.EtiquetaDTO;
import org.cibertec.fitx.dto.EtiquetaMinDTO;
import org.cibertec.fitx.dto.UsuarioDTO;
import org.cibertec.fitx.entity.EtiquetaEntity;
import org.cibertec.fitx.entity.UsuarioEntity;
import org.cibertec.fitx.service.EtiquetaService;
import org.cibertec.fitx.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/etiquetas")
@CrossOrigin(origins = "*")
public class EtiquetaController {

    private final EtiquetaService etiquetaService; // Mejor usar inyección por constructor
    private final UsuarioService usuarioService;

    @Autowired
    public EtiquetaController(EtiquetaService etiquetaService, UsuarioService usuarioService) {
        this.etiquetaService = etiquetaService;
        this.usuarioService = usuarioService;
    }

    // 1. Obtener todas las etiquetas (usuario + globales)
    @GetMapping({"/", ""})
    public ResponseEntity<List<EtiquetaDTO>> listarEtiquetas(HttpSession session) {
        try {
            UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
            List<EtiquetaDTO> etiquetas = (usuario.getRolId() == 1) ? etiquetaService.listarTodas() : etiquetaService.listarPorUsuario(usuario.getId());
            for (EtiquetaDTO dto : etiquetas) {
                boolean editable = usuario.getRolId() == 1 || dto.getUsuarioId().equals(usuario.getId());
                dto.setEditable(editable);
            }
            return ResponseEntity.ok(etiquetas);
        } catch (Exception e) {
            System.err.println("Error inesperado al listar etiquetas: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping({"/listarMinDTO", ""})
    public ResponseEntity<List<EtiquetaMinDTO>> listarEtiquetasMinDTO(HttpSession session) {
        try {
            UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
            List<EtiquetaMinDTO> etiquetasMinDto = new ArrayList<>();
            List<EtiquetaDTO> etiquetas = (usuario.getRolId() == 1) ? etiquetaService.listarTodas() : etiquetaService.listarPorUsuario(usuario.getId());
            for (EtiquetaDTO dto : etiquetas) {
                EtiquetaMinDTO e = new EtiquetaMinDTO();
                e.setId(dto.getId());
                e.setNombre(dto.getNombre());
                e.setColor(dto.getColor());
                etiquetasMinDto.add(e);
            }
            return ResponseEntity.ok(etiquetasMinDto);
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
    public ResponseEntity<String> crearEtiqueta(@RequestBody EtiquetaEntity etiqueta, HttpSession session) {
        try {
            etiqueta.setEstado("Activo");
            Integer usuarioId = ((UsuarioDTO) session.getAttribute("usuario")).getId();
            etiqueta.setUsuario(usuarioService.buscarPorId(usuarioId));

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