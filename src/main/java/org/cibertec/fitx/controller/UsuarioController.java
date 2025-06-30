package org.cibertec.fitx.controller;

import jakarta.servlet.http.HttpSession;
import org.cibertec.fitx.dto.UsuarioDTO;
import org.cibertec.fitx.entity.UsuarioEntity;
import org.cibertec.fitx.helper.SesionHelper;
import org.cibertec.fitx.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final SesionHelper sesionHelper;
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService, SesionHelper sesionHelper) {
        this.usuarioService = usuarioService;
        this.sesionHelper = sesionHelper;
    }

//    // 1. Obtener todos los usuarios
//    @GetMapping({"/", ""})
//    public ResponseEntity<List<UsuarioDTO>> listarUsuarios(HttpSession session) {
//        try {
//            UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
//            List<UsuarioDTO> usuarios = (usuario.getRolId() == 1) ? usuarioService.listarTodas() : usuarioService.listarPorUsuario(usuario.getId());
//            for (UsuarioDTO dto : usuarios) {
//                boolean editable = usuario.getRolId() == 1 || dto.getUsuarioId().equals(usuario.getId());
//                dto.setEditable(editable);
//            }
//            return ResponseEntity.ok(usuarios);
//        } catch (Exception e) {
//            System.err.println("Error inesperado al listar usuarios: " + e.getMessage());
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(null);
//        }
//    }
//
//    @GetMapping({"/listarMinDTO", ""})
//    public ResponseEntity<List<UsuarioMinDTO>> listarUsuariosMinDTO(HttpSession session) {
//        try {
//            UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
//            List<UsuarioMinDTO> usuariosMinDto = new ArrayList<>();
//            List<UsuarioDTO> usuarios = (usuario.getRolId() == 1) ? usuarioService.listarTodas() : usuarioService.listarPorUsuario(usuario.getId());
//            for (UsuarioDTO dto : usuarios) {
//                UsuarioMinDTO e = new UsuarioMinDTO();
//                e.setId(dto.getId());
//                e.setNombre(dto.getNombre());
//                e.setColor(dto.getColor());
//                usuariosMinDto.add(e);
//            }
//            return ResponseEntity.ok(usuariosMinDto);
//        } catch (Exception e) {
//            System.err.println("Error inesperado al listar usuarios: " + e.getMessage());
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(null);
//        }
//    }

    // 2. Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obtenerUsuario(@PathVariable Integer id, HttpSession session) {
        try {
            UsuarioDTO usuarioSesion = sesionHelper.obtenerUsuario(session);
            return usuarioSesion != null ? ResponseEntity.ok(usuarioSesion) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            System.err.println("Error inesperado al obtener usuario por ID: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    // 3. Crear nuevo usuario
    @PostMapping
    public ResponseEntity<String> crearUsuario(@RequestBody UsuarioDTO usuario, HttpSession session) {
        try {
            Integer id = usuarioService.guardarUsuarioDTO(usuario);
            sesionHelper.postRegistroUsuario( usuarioService.buscarUsuarioDtoPorId(id), session );
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (DataIntegrityViolationException e) {
            System.err.println("Error de integridad de datos al crear usuario: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al crear usuario: Verifique los datos. Posiblemente el nombre ya existe o hay datos inválidos.");
        } catch (Exception e) {
            System.err.println("Error inesperado al crear usuario: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocurrió un error interno al crear la usuario. Inténtelo de nuevo más tarde.");
        }
    }

    // 4. Editar usuario
    @PutMapping("/{id}")
    public ResponseEntity<String> editarUsuario(@PathVariable Integer id, @RequestBody UsuarioEntity usuario) {
        try {
            UsuarioEntity actualEntity = usuarioService.buscarPorId(id);

            if (actualEntity == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Usuario con ID " + id + " no encontrada.");
            }
//
//            actualEntity.setNombre(usuario.getNombre());
//            actualEntity.setColor(usuario.getColor());

            usuarioService.guardar(actualEntity);
            return ResponseEntity.noContent().build();
        } catch (DataIntegrityViolationException e) {
            System.err.println("Error de integridad de datos al editar usuario: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al editar usuario: Verifique los datos. Posiblemente el nombre ya existe o hay datos inválidos.");
        } catch (Exception e) {
            System.err.println("Error inesperado al editar usuario: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocurrió un error interno al editar la usuario. Inténtelo de nuevo más tarde.");
        }
    }

//    // 5. Eliminar usuario
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> eliminarUsuario(@PathVariable Integer id) {
//        try {
//            UsuarioEntity usuarioExistente = usuarioService.buscarPorId(id);
//            if (usuarioExistente == null) {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                        .body("Usuario con ID " + id + " no encontrada para eliminar.");
//            }
//
//            usuarioService.eliminar(id);
//
//            return ResponseEntity.noContent().build();
//        } catch (Exception e) {
//            System.err.println("Error inesperado al eliminar usuario: " + e.getMessage());
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Ocurrió un error interno al eliminar la usuario. Inténtelo de nuevo más tarde.");
//        }
//    }
}