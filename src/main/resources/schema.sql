-- DROP DATABASE IF EXISTS DB_FitX;
-- CREATE DATABASE IF NOT EXISTS DB_FitX;
-- USE DB_FitX;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS RecetaDetalle;
DROP TABLE IF EXISTS ValorNutricional;
DROP TABLE IF EXISTS RecetaEtiqueta;
DROP TABLE IF EXISTS MenuReceta;
DROP TABLE IF EXISTS RecetaFavorita;
DROP TABLE IF EXISTS Receta;
DROP TABLE IF EXISTS Menu;
DROP TABLE IF EXISTS Etiqueta;
DROP TABLE IF EXISTS Insumo;
DROP TABLE IF EXISTS TipoInsumo;
DROP TABLE IF EXISTS UnidadMedida;
DROP TABLE IF EXISTS PerfilNutricional;
DROP TABLE IF EXISTS Suscripcion;
DROP TABLE IF EXISTS Usuario;
DROP TABLE IF EXISTS TipoUsuario;

SET FOREIGN_KEY_CHECKS = 1;

-- Tipo de Usuario
CREATE TABLE TipoUsuario (
                             id INT PRIMARY KEY AUTO_INCREMENT,
                             nombre VARCHAR(50) NOT NULL -- ADMIN, CLIENTE
    -- estado ENUM('Activo', 'Inactivo') DEFAULT 'Activo'
);


-- Usuario
CREATE TABLE Usuario (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         id_tipo_usuario INT NOT NULL,
                         nombre_usuario VARCHAR(50) NOT NULL,
                         dni VARCHAR(8) NOT NULL UNIQUE,
                         nombres VARCHAR(100) NOT NULL,
                         apellidos VARCHAR(100) NOT NULL,
                         correo VARCHAR(100) NOT NULL UNIQUE,
                         contraseña VARCHAR(100) NOT NULL,
                         fecha_inscripcion DATE NOT NULL,
                         estado ENUM('Activo', 'Inactivo') DEFAULT 'Activo',
                         telefono VARCHAR(15) NULL,
                         FOREIGN KEY (id_tipo_usuario) REFERENCES TipoUsuario(id) ON DELETE CASCADE
);

-- Perfil Nutricional
CREATE TABLE PerfilNutricional (
                                   id INT PRIMARY KEY AUTO_INCREMENT,
                                   id_usuario INT NOT NULL,
                                   peso DECIMAL(5,2) NOT NULL,
                                   fecha_nacimiento DATE NOT NULL,
                                   sexo ENUM('M', 'F') NOT NULL,
                                   talla DECIMAL(5,2) NOT NULL,
                                   nivel_actividad ENUM('Sedentario', 'Moderadamente activo', 'Activo', 'Muy Activo', 'Enfocado en pérdida de peso', 'Enfocado en ganancia muscular') NOT NULL,
    -- estado ENUM('Activo', 'Inactivo') DEFAULT 'Activo',
                                   FOREIGN KEY (id_usuario) REFERENCES Usuario(id) ON DELETE CASCADE
);

-- Suscripción
CREATE TABLE Suscripcion (
                             id INT PRIMARY KEY AUTO_INCREMENT,
                             id_usuario INT NOT NULL,
                             fecha_inicio DATE NOT NULL,
                             fecha_fin DATE NOT NULL,
                             precio DECIMAL(10,2) NOT NULL,
                             estado ENUM('Activo', 'Inactivo', 'Cancelado') DEFAULT 'Activo',
                             FOREIGN KEY (id_usuario) REFERENCES Usuario(id) ON DELETE CASCADE
);

-- Menú
CREATE TABLE Menu (
                      id INT PRIMARY KEY AUTO_INCREMENT,
                      id_usuario INT NOT NULL,
                      nombre VARCHAR(100) NOT NULL,
                      descripcion TEXT,
                      fecha_creacion DATE NOT NULL,
                      fecha_ejecucion DATE NOT NULL,
                      estado ENUM('Activo', 'Inactivo') DEFAULT 'Activo',
                      FOREIGN KEY (id_usuario) REFERENCES Usuario(id) ON DELETE CASCADE
);

-- Unidad de Medida
CREATE TABLE UnidadMedida (
                              id INT PRIMARY KEY AUTO_INCREMENT,
                              nombre VARCHAR(50) NOT NULL,
                              simbolo VARCHAR(10) NOT NULL
);

-- Receta
CREATE TABLE Receta (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        id_usuario INT NOT NULL,
                        fecha_creacion DATE NOT NULL,
                        nombre VARCHAR(100) NOT NULL,
                        porciones INT NOT NULL,
                        peso_porcion DECIMAL(5,2) NOT NULL,
                        id_unidad_medida INT NOT NULL,
                        tiempo_estimado TIME, -- en minutos
                        estado ENUM('Activo', 'Inactivo') DEFAULT 'Activo',
                        foto TEXT,
                        descripcion TEXT,
                        FOREIGN KEY (id_usuario) REFERENCES Usuario(id),
                        FOREIGN KEY (id_unidad_medida) REFERENCES UnidadMedida(id) ON DELETE CASCADE
);

-- Menú-Receta (relación N:M)
CREATE TABLE MenuReceta (
                            id_menu INT NOT NULL,
                            id_receta INT NOT NULL,
                            porciones INT NOT NULL,
                            PRIMARY KEY (id_menu, id_receta),
                            FOREIGN KEY (id_menu) REFERENCES Menu(id) ON DELETE CASCADE,
                            FOREIGN KEY (id_receta) REFERENCES Receta(id) ON DELETE CASCADE
);

-- Receta Favorita
CREATE TABLE RecetaFavorita (
                                id INT PRIMARY KEY AUTO_INCREMENT,
                                id_receta INT NOT NULL,
                                id_usuario INT NOT NULL,
                                fecha_agregado DATETIME NOT NULL,
                                FOREIGN KEY (id_receta) REFERENCES Receta(id) ON DELETE CASCADE,
                                FOREIGN KEY (id_usuario) REFERENCES Usuario(id) ON DELETE CASCADE,
                                UNIQUE KEY unique_user_recipe (id_usuario, id_receta)
);

-- Etiqueta
CREATE TABLE Etiqueta (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          id_usuario INT NOT NULL,
                          nombre VARCHAR(100) NOT NULL,
                          color VARCHAR(6), -- Color en formato hexadecimal
                          estado ENUM('Activo', 'Inactivo') DEFAULT 'Activo',
                          FOREIGN KEY (id_usuario) REFERENCES Usuario(id) ON DELETE CASCADE
);

-- Receta-Etiqueta (relación N:M)
CREATE TABLE RecetaEtiqueta (
                                id_etiqueta INT NOT NULL,
                                id_receta INT NOT NULL,
                                PRIMARY KEY (id_etiqueta, id_receta),
                                FOREIGN KEY (id_etiqueta) REFERENCES Etiqueta(id) ON DELETE CASCADE,
                                FOREIGN KEY (id_receta) REFERENCES Receta(id) ON DELETE CASCADE
);

-- Tipo de Insumo
CREATE TABLE TipoInsumo (
                            id INT PRIMARY KEY AUTO_INCREMENT,
                            nombre VARCHAR(50) NOT NULL
);

-- Insumo
CREATE TABLE Insumo (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        id_unidad_medida INT NOT NULL,
                        id_tipo_insumo INT NOT NULL,
                        nombre VARCHAR(100) NOT NULL,
                        estado ENUM('Activo', 'Inactivo') DEFAULT 'Activo',
                        FOREIGN KEY (id_unidad_medida) REFERENCES UnidadMedida(id),
                        FOREIGN KEY (id_tipo_insumo) REFERENCES TipoInsumo(id)
);

-- Receta Detalle
CREATE TABLE RecetaDetalle (
                               id INT PRIMARY KEY AUTO_INCREMENT,
                               id_receta INT NOT NULL,
                               id_insumo INT NOT NULL,
                               id_unidad_medida INT NOT NULL,
                               cantidad DECIMAL(8,2) NOT NULL,
                               estado ENUM('Activo', 'Inactivo') DEFAULT 'Activo', -- Activo, Inactivo
                               FOREIGN KEY (id_receta) REFERENCES Receta(id) ON DELETE CASCADE,
                               FOREIGN KEY (id_insumo) REFERENCES Insumo(id),
                               FOREIGN KEY (id_unidad_medida) REFERENCES UnidadMedida(id)
);

-- Valor Nutricional
CREATE TABLE ValorNutricional (
                                  id INT PRIMARY KEY AUTO_INCREMENT,
                                  id_insumo INT NOT NULL,
                                  id_unidad_medida INT NOT NULL,
                                  cantidad DECIMAL(10,2) NOT NULL,
                                  calorias DECIMAL(10,2) NOT NULL,
                                  proteinas DECIMAL(10,2) NOT NULL,
                                  grasas DECIMAL(10,2) NOT NULL,
                                  carbohidratos DECIMAL(10,2) NOT NULL,
                                  FOREIGN KEY (id_insumo) REFERENCES Insumo(id) ON DELETE CASCADE,
                                  FOREIGN KEY (id_unidad_medida) REFERENCES UnidadMedida(id)
);