-- SQL Data Inserts for DB_FitX
-- Generado sin la librería Faker para mantener la compatibilidad

USE DB_FitX;

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------------------------------
-- TipoUsuario
-- Cantidad: moderado (3 tipos fijos)
-- ----------------------------------------------------
INSERT INTO TipoUsuario (id, nombre) VALUES
                                         (1, 'Administrador'),
                                         (2, 'Nutricionista'),
                                         (3, 'Cliente');

-- ----------------------------------------------------
-- Usuario
-- Cantidad: moderado (~30 registros)
-- Datos: Diversos nombres, correos, fechas, estados.
-- ----------------------------------------------------
INSERT INTO Usuario (id, id_tipo_usuario, nombre_usuario, dni, nombres, apellidos, correo, contraseña, fecha_inscripcion, estado, telefono) VALUES
                                                                                                                                                (1, 1, 'admin_fitx', '11111111', 'Ana', 'García Pérez', 'ana.garcia@fitx.com', 'pass123', '2024-01-15', 'Activo', '987654321'),
                                                                                                                                                (2, 2, 'nutri_pro', '22222222', 'Carlos', 'Martínez López', 'carlos.m@fitx.com', 'pass123', '2024-02-20', 'Activo', '987123456'),
                                                                                                                                                (3, 3, 'usuario_fit', '33333333', 'María', 'Fernández Ruiz', 'maria.f@example.com', 'pass123', '2024-03-01', 'Activo', '987987654'),
                                                                                                                                                (4, 3, 'vidasana', '44444444', 'Juan', 'González Torres', 'juan.g@example.com', 'pass123', '2024-04-10', 'Activo', '987543210'),
                                                                                                                                                (5, 3, 'gymlover', '55555555', 'Sofía', 'Ramírez Castro', 'sofia.r@example.com', 'pass123', '2024-05-05', 'Inactivo', '987012345'),
                                                                                                                                                (6, 3, 'saludable', '66666666', 'Pedro', 'Díaz Soto', 'pedro.d@example.com', 'pass123', '2024-06-12', 'Activo', '987678901'),
                                                                                                                                                (7, 3, 'fitlife', '77777777', 'Laura', 'Blanco Vargas', 'laura.b@example.com', 'pass123', '2024-07-18', 'Activo', '987345678'),
                                                                                                                                                (8, 3, 'sportygal', '88888888', 'Diego', 'Moreno Gil', 'diego.m@example.com', 'pass123', '2024-08-25', 'Activo', '987890123'),
                                                                                                                                                (9, 3, 'comeresvida', '99999999', 'Elena', 'Romero Núñez', 'elena.r@example.com', 'pass123', '2024-09-02', 'Inactivo', '987567890'),
                                                                                                                                                (10, 3, 'chefnutri', '10101010', 'Pablo', 'Cruz Molina', 'pablo.c@example.com', 'pass123', '2024-10-10', 'Activo', '987234567'),
                                                                                                                                                (11, 3, 'healthyhabits', '11223344', 'Lucía', 'Ortega Cano', 'lucia.o@example.com', 'pass123', '2024-11-15', 'Activo', '987789012'),
                                                                                                                                                (12, 3, 'runnersoul', '12345678', 'Miguel', 'Delgado Vega', 'miguel.d@example.com', 'pass123', '2024-12-01', 'Activo', '987456789'),
                                                                                                                                                (13, 3, 'yogagirl', '87654321', 'Paula', 'Sánchez Bravo', 'paula.s@example.com', 'pass123', '2025-01-05', 'Activo', '987109876'),
                                                                                                                                                (14, 3, 'fitnesstime', '13579246', 'Javier', 'Herrera Montes', 'javier.h@example.com', 'pass123', '2025-01-20', 'Activo', '987654321'),
                                                                                                                                                (15, 3, 'eatclean', '24680135', 'Andrea', 'Ruiz Pardo', 'andrea.r@example.com', 'pass123', '2025-02-10', 'Activo', '987321098'),
                                                                                                                                                (16, 3, 'vidasana2', '98765432', 'Ricardo', 'Castillo Luna', 'ricardo.c@example.com', 'pass123', '2025-02-28', 'Activo', '987908765'),
                                                                                                                                                (17, 3, 'healthyfoodie', '10293847', 'Silvia', 'Guerrero Ríos', 'silvia.g@example.com', 'pass123', '2025-03-05', 'Inactivo', '987564738'),
                                                                                                                                                (18, 3, 'sportlover', '39485761', 'Raúl', 'Ortiz Peña', 'raul.o@example.com', 'pass123', '2025-03-15', 'Activo', '987236547'),
                                                                                                                                                (19, 3, 'nutriguru', '56789012', 'Marta', 'Prieto Ramos', 'marta.p@example.com', 'pass123', '2025-03-22', 'Activo', '987891234'),
                                                                                                                                                (20, 3, 'wellnesspath', '72839401', 'Sergio', 'Gómez Vidal', 'sergio.g@example.com', 'pass123', '2025-04-01', 'Activo', '987459876'),
                                                                                                                                                (21, 3, 'fitandhealthy', '12345670', 'Isabel', 'Serrano Bravo', 'isabel.s@example.com', 'pass123', '2025-04-10', 'Activo', '987123987'),
                                                                                                                                                (22, 3, 'powerup', '09876543', 'Daniel', 'Iglesias Cano', 'daniel.i@example.com', 'pass123', '2025-04-18', 'Activo', '987678123'),
                                                                                                                                                (23, 3, 'greenlife', '54321098', 'Cristina', 'Moreno Gil', 'cristina.m@example.com', 'pass123', '2025-05-01', 'Activo', '987345098'),
                                                                                                                                                (24, 3, 'bodygoals', '67890123', 'Roberto', 'Vega Díaz', 'roberto.v@example.com', 'pass123', '2025-05-08', 'Inactivo', '987901234'),
                                                                                                                                                (25, 3, 'eatwell', '01234567', 'Eva', 'Castro Luna', 'eva.c@example.com', 'pass123', '2025-05-15', 'Activo', '987567123'),
                                                                                                                                                (26, 3, 'nutrivida', '12345679', 'Fernando', 'Ruiz Pardo', 'fernando.r@example.com', 'pass123', '2025-05-20', 'Activo', '987234567'),
                                                                                                                                                (27, 3, 'trainhard', '98765430', 'Beatriz', 'Gómez Vidal', 'beatriz.g@example.com', 'pass123', '2025-05-25', 'Activo', '987890543'),
                                                                                                                                                (28, 3, 'healthcoach', '10987654', 'Manuel', 'Pérez García', 'manuel.p@fitx.com', 'pass123', '2025-06-01', 'Activo', '987456789'),
                                                                                                                                                (29, 3, 'dietplan', '23456789', 'Virginia', 'Soto Díaz', 'virginia.s@example.com', 'pass123', '2025-06-05', 'Activo', '987123456'),
                                                                                                                                                (30, 3, 'sportynutri', '34567890', 'Jorge', 'López García', 'jorge.l@fitx.com', 'pass123', '2025-06-10', 'Activo', '987654321');

-- ----------------------------------------------------
-- PerfilNutricional
-- Cantidad: moderado (~30 registros)
-- Datos: Diferentes pesos, tallas, sexos, niveles de actividad.
-- ----------------------------------------------------
INSERT INTO PerfilNutricional (id, id_usuario, peso, fecha_nacimiento, sexo, talla, nivel_actividad) VALUES
                                                                                                         (1, 1, 75.00, '1990-05-10', 'M', 1.75, 'Activo'),
                                                                                                         (2, 2, 68.50, '1985-08-22', 'F', 1.68, 'Moderadamente activo'),
                                                                                                         (3, 3, 62.00, '1995-03-12', 'F', 1.63, 'Enfocado en pérdida de peso'),
                                                                                                         (4, 4, 80.00, '1988-11-01', 'M', 1.80, 'Muy Activo'),
                                                                                                         (5, 5, 55.50, '1998-01-20', 'F', 1.58, 'Sedentario'),
                                                                                                         (6, 6, 70.00, '1993-07-03', 'M', 1.72, 'Enfocado en ganancia muscular'),
                                                                                                         (7, 7, 60.50, '1996-02-14', 'F', 1.60, 'Moderadamente activo'),
                                                                                                         (8, 8, 85.00, '1983-09-28', 'M', 1.85, 'Muy Activo'),
                                                                                                         (9, 9, 58.00, '1999-04-05', 'F', 1.65, 'Sedentario'),
                                                                                                         (10, 10, 72.50, '1991-06-19', 'M', 1.77, 'Activo'),
                                                                                                         (11, 11, 63.00, '1994-10-10', 'F', 1.66, 'Enfocado en pérdida de peso'),
                                                                                                         (12, 12, 78.00, '1987-03-08', 'M', 1.79, 'Activo'),
                                                                                                         (13, 13, 59.00, '1997-12-01', 'F', 1.61, 'Moderadamente activo'),
                                                                                                         (14, 14, 82.00, '1989-02-20', 'M', 1.83, 'Muy Activo'),
                                                                                                         (15, 15, 56.00, '1998-09-11', 'F', 1.59, 'Sedentario'),
                                                                                                         (16, 16, 73.00, '1992-04-25', 'M', 1.76, 'Enfocado en ganancia muscular'),
                                                                                                         (17, 17, 61.00, '1995-07-30', 'F', 1.64, 'Moderadamente activo'),
                                                                                                         (18, 18, 86.00, '1984-11-18', 'M', 1.86, 'Muy Activo'),
                                                                                                         (19, 19, 57.00, '1999-05-15', 'F', 1.62, 'Sedentario'),
                                                                                                         (20, 20, 71.00, '1990-08-07', 'M', 1.74, 'Activo'),
                                                                                                         (21, 21, 64.00, '1993-01-01', 'F', 1.67, 'Enfocado en pérdida de peso'),
                                                                                                         (22, 22, 79.00, '1986-06-23', 'M', 1.78, 'Activo'),
                                                                                                         (23, 23, 60.00, '1996-09-09', 'F', 1.60, 'Moderadamente activo'),
                                                                                                         (24, 24, 84.00, '1982-12-12', 'M', 1.84, 'Muy Activo'),
                                                                                                         (25, 25, 54.00, '1997-01-25', 'F', 1.57, 'Sedentario'),
                                                                                                         (26, 26, 76.00, '1991-03-03', 'M', 1.77, 'Enfocado en ganancia muscular'),
                                                                                                         (27, 27, 65.00, '1994-05-05', 'F', 1.68, 'Moderadamente activo'),
                                                                                                         (28, 28, 88.00, '1981-10-10', 'M', 1.88, 'Muy Activo'),
                                                                                                         (29, 29, 53.00, '1998-02-02', 'F', 1.56, 'Sedentario'),
                                                                                                         (30, 30, 74.00, '1989-07-07', 'M', 1.73, 'Activo');

-- ----------------------------------------------------
-- Suscripcion
-- Cantidad: moderado (~30 registros)
-- Datos: Precios 20 (año pasado) y 25 (año actual), diferentes estados.
-- ----------------------------------------------------
INSERT INTO Suscripcion (id, id_usuario, fecha_inicio, fecha_fin, precio, estado) VALUES
                                                                                      (1, 1, '2024-01-15', '2025-01-15', 20.00, 'Activo'),
                                                                                      (2, 2, '2024-02-20', '2025-02-20', 20.00, 'Activo'),
                                                                                      (3, 3, '2024-03-01', '2025-03-01', 20.00, 'Activo'),
                                                                                      (4, 4, '2024-04-10', '2025-04-10', 20.00, 'Inactivo'),
                                                                                      (5, 5, '2024-05-05', '2025-05-05', 20.00, 'Cancelado'),
                                                                                      (6, 6, '2024-06-12', '2025-06-12', 20.00, 'Activo'),
                                                                                      (7, 7, '2024-07-18', '2025-07-18', 20.00, 'Activo'),
                                                                                      (8, 8, '2024-08-25', '2025-08-25', 20.00, 'Activo'),
                                                                                      (9, 9, '2024-09-02', '2025-09-02', 20.00, 'Inactivo'),
                                                                                      (10, 10, '2024-10-10', '2025-10-10', 20.00, 'Activo'),
                                                                                      (11, 11, '2024-11-15', '2025-11-15', 20.00, 'Activo'),
                                                                                      (12, 12, '2024-12-01', '2025-12-01', 20.00, 'Activo'),
                                                                                      (13, 13, '2025-01-05', '2026-01-05', 25.00, 'Activo'),
                                                                                      (14, 14, '2025-01-20', '2026-01-20', 25.00, 'Activo'),
                                                                                      (15, 15, '2025-02-10', '2026-02-10', 25.00, 'Activo'),
                                                                                      (16, 16, '2025-02-28', '2026-02-28', 25.00, 'Activo'),
                                                                                      (17, 17, '2025-03-05', '2026-03-05', 25.00, 'Inactivo'),
                                                                                      (18, 18, '2025-03-15', '2026-03-15', 25.00, 'Activo'),
                                                                                      (19, 19, '2025-03-22', '2026-03-22', 25.00, 'Activo'),
                                                                                      (20, 20, '2025-04-01', '2026-04-01', 25.00, 'Activo'),
                                                                                      (21, 21, '2025-04-10', '2026-04-10', 25.00, 'Activo'),
                                                                                      (22, 22, '2025-04-18', '2026-04-18', 25.00, 'Activo'),
                                                                                      (23, 23, '2025-05-01', '2026-05-01', 25.00, 'Activo'),
                                                                                      (24, 24, '2025-05-08', '2026-05-08', 25.00, 'Inactivo'),
                                                                                      (25, 25, '2025-05-15', '2026-05-15', 25.00, 'Activo'),
                                                                                      (26, 26, '2025-05-20', '2026-05-20', 25.00, 'Activo'),
                                                                                      (27, 27, '2025-05-25', '2026-05-25', 25.00, 'Activo'),
                                                                                      (28, 28, '2025-06-01', '2026-06-01', 25.00, 'Activo'),
                                                                                      (29, 29, '2025-06-05', '2026-06-05', 25.00, 'Activo'),
                                                                                      (30, 30, '2025-06-10', '2026-06-10', 25.00, 'Activo');

-- ----------------------------------------------------
-- Menu
-- Cantidad: moderado (~30 registros)
-- Datos: Descripciones HTML, fechas variadas.
-- ----------------------------------------------------
INSERT INTO Menu (id, id_usuario, nombre, descripcion, fecha_creacion, fecha_ejecucion, estado) VALUES
                                                                                                    (1, 1, 'Menú Semanal Equilibrado', '<h2>Menú Semanal Equilibrado</h2><p>Este menú está diseñado para ofrecer una dieta equilibrada y nutritiva para toda la semana. Incluye opciones para desayuno, almuerzo y cena, con un enfoque en proteínas magras, carbohidratos complejos y grasas saludables.</p><ul><li><strong>Lunes:</strong> Desayuno ligero, Almuerzo con pollo y vegetales, Cena con pescado.</li><li><strong>Martes:</strong> Desayuno energético, Almuerzo vegetariano, Cena con carne magra.</li><li><strong>Miércoles:</strong> Desayuno proteico, Almuerzo con legumbres, Cena con ensalada.</li></ul><p>Ideal para el mantenimiento del peso y el bienestar general.</p>', '2024-01-20', '2024-01-27', 'Activo'),
                                                                                                    (2, 2, 'Menú Keto para un Mes', '<h2>Menú Keto para un Mes</h2><p>Un plan de comidas completo para seguir una dieta cetogénica estricta durante un mes. Este menú minimiza los carbohidratos y maximiza las grasas saludables para inducir la cetosis.</p><ul><li><strong>Semana 1:</strong> Introducción a la cetosis, énfasis en aguacate y aceite de coco.</li><li><strong>Semana 2:</strong> Incorporación de más carnes rojas y quesos.</li><li><strong>Semana 3:</strong> Variedad con pescados grasos y frutos secos.</li></ul><p>Consulte a su nutricionista antes de iniciar esta dieta.</p>', '2024-02-25', '2024-03-25', 'Activo'),
                                                                                                    (3, 3, 'Menú de Pérdida de Peso - 1500 Kcal', '<h2>Menú de Pérdida de Peso - 1500 Kcal</h2><p>Este menú diario de 1500 calorías está diseñado para ayudarte a alcanzar tus objetivos de pérdida de peso de forma sostenible y sin pasar hambre.</p><p>Se enfoca en porciones controladas y alimentos de bajo índice glucémico.</p>', '2024-03-05', '2024-03-12', 'Activo'),
                                                                                                    (4, 4, 'Menú Vegano Sostenible', '<h2>Menú Vegano Sostenible</h2><p>Descubre un menú delicioso y 100% vegano, pensado para minimizar tu huella de carbono y maximizar los nutrientes esenciales. Recetas a base de plantas frescas y de temporada.</p>', '2024-04-15', '2024-04-22', 'Activo'),
                                                                                                    (5, 5, 'Menú para Ganancia Muscular', '<h2>Menú para Ganancia Muscular</h2><p>Un plan de comidas con alto contenido proteico y calorías controladas para apoyar el crecimiento muscular y la recuperación post-entrenamiento. Ideal para atletas.</p>', '2024-05-10', '2024-05-17', 'Inactivo'),
                                                                                                    (6, 6, 'Menú Sin Gluten Diario', '<h2>Menú Sin Gluten Diario</h2><p>Disfruta de comidas deliciosas y completamente libres de gluten. Este menú es perfecto para personas con sensibilidad al gluten o celiaquía.</p>', '2024-06-20', '2024-06-27', 'Activo'),
                                                                                                    (7, 7, 'Menú Rápido y Saludable', '<h2>Menú Rápido y Saludable</h2><p>Comidas nutritivas que puedes preparar en menos de 30 minutos. Ideal para personas con un estilo de vida ajetreado.</p>', '2024-07-25', '2024-08-01', 'Activo'),
                                                                                                    (8, 8, 'Menú para Deportistas de Resistencia', '<h2>Menú para Deportistas de Resistencia</h2><p>Optimiza tu rendimiento con este menú rico en carbohidratos complejos y electrolitos. Ideal para corredores, ciclistas y nadadores.</p>', '2024-08-30', '2024-09-06', 'Activo'),
                                                                                                    (9, 9, 'Menú de Desintoxicación', '<h2>Menú de Desintoxicación</h2><p>Un plan de 3 días para limpiar el organismo a base de zumos, caldos y ensaladas ligeras. Consulta siempre a un profesional.</p>', '2024-09-10', '2024-09-13', 'Inactivo'),
                                                                                                    (10, 10, 'Menú para Control de Diabetes', '<h2>Menú para Control de Diabetes</h2><p>Opciones de comidas con bajo índice glucémico para ayudar a controlar los niveles de azúcar en sangre. Desarrollado con guías nutricionales específicas.</p>', '2024-10-15', '2024-10-22', 'Activo'),
                                                                                                    (11, 11, 'Menú para Embarazadas', '<h2>Menú para Embarazadas</h2><p>Recetas nutritivas y seguras para cada trimestre del embarazo, asegurando el aporte de vitaminas y minerales esenciales para la madre y el bebé.</p>', '2024-11-20', '2024-11-27', 'Activo'),
                                                                                                    (12, 12, 'Menú Antiinflamatorio', '<h2>Menú Antiinflamatorio</h2><p>Un plan de alimentación centrado en alimentos que reducen la inflamación, como frutas, verduras, pescado azul y aceite de oliva.</p>', '2024-12-05', '2024-12-12', 'Activo'),
                                                                                                    (13, 13, 'Menú para Niños Saludables', '<h2>Menú para Niños Saludables</h2><p>Ideas de comidas divertidas y nutritivas para los más pequeños, con opciones variadas para desayuno, almuerzo y merienda.</p>', '2025-01-10', '2025-01-17', 'Activo'),
                                                                                                    (14, 14, 'Menú para Vegetales de Estación', '<h2>Menú para Vegetales de Estación</h2><p>Aprovecha al máximo los productos frescos de temporada con este menú que celebra la diversidad de vegetales disponibles.</p>', '2025-01-25', '2025-02-01', 'Activo'),
                                                                                                    (15, 15, 'Menú de Bajo Colesterol', '<h2>Menú de Bajo Colesterol</h2><p>Recetas deliciosas que te ayudarán a mantener tus niveles de colesterol bajo control, con un enfoque en fibras y grasas insaturadas.</p>', '2025-02-15', '2025-02-22', 'Activo'),
                                                                                                    (16, 16, 'Menú Mediterráneo', '<h2>Menú Mediterráneo</h2><p>Inspirado en la dieta mediterránea, este menú es rico en aceite de oliva, pescado, verduras y legumbres, promoviendo la salud cardiovascular.</p>', '2025-03-01', '2025-03-08', 'Activo'),
                                                                                                    (17, 17, 'Menú para Alergias Alimentarias', '<h2>Menú para Alergias Alimentarias</h2><p>Opciones seguras y deliciosas para personas con alergias comunes como lácteos, frutos secos o mariscos. Siempre revisar etiquetas.</p>', '2025-03-10', '2025-03-17', 'Inactivo'),
                                                                                                    (18, 18, 'Menú de Recetas Exóticas', '<h2>Menú de Recetas Exóticas</h2><p>Explora sabores del mundo con este menú que incluye platos de Asia, África y América Latina, para una experiencia culinaria diferente.</p>', '2025-03-20', '2025-03-27', 'Activo'),
                                                                                                    (19, 19, 'Menú para Celiacos', '<h2>Menú para Celiacos</h2><p>Comidas 100% libres de gluten, preparadas con ingredientes seguros para personas con enfermedad celíaca. Incluye opciones para todas las comidas.</p>', '2025-04-05', '2025-04-12', 'Activo'),
                                                                                                    (20, 20, 'Menú Post-Entrenamiento', '<h2>Menú Post-Entrenamiento</h2><p>Alimentos clave para la recuperación muscular y la reposición de energía después de un entrenamiento intenso. Rápido y eficaz.</p>', '2025-04-15', '2025-04-22', 'Activo'),
                                                                                                    (21, 21, 'Menú para el Hígado Graso', '<h2>Menú para el Hígado Graso</h2><p>Dieta específica para reducir la acumulación de grasa en el hígado, con un enfoque en alimentos bajos en grasa y azúcares simples.</p>', '2025-04-25', '2025-05-02', 'Activo'),
                                                                                                    (22, 22, 'Menú para Corazón Saludable', '<h2>Menú para Corazón Saludable</h2><p>Recetas que promueven la salud cardiovascular, ricas en ácidos grasos Omega-3, fibra y antioxidantes.</p>', '2025-05-01', '2025-05-08', 'Activo'),
                                                                                                    (23, 23, 'Menú de Comida Reconfortante Saludable', '<h2>Menú de Comida Reconfortante Saludable</h2><p>Disfruta de tus platos favoritos en versiones más saludables, sin sacrificar el sabor. Ideal para días fríos.</p>', '2025-05-10', '2025-05-17', 'Activo'),
                                                                                                    (24, 24, 'Menú para Deportistas de Fuerza', '<h2>Menú para Deportistas de Fuerza</h2><p>Optimiza tu fuerza y masa muscular con este menú de alta densidad calórica y proteica, diseñado para levantar pesas.</p>', '2025-05-20', '2025-05-27', 'Inactivo'),
                                                                                                    (25, 25, 'Menú para el Cerebro', '<h2>Menú para el Cerebro</h2><p>Alimentos que potencian la función cerebral, la memoria y la concentración, como frutos secos, pescado azul y verduras de hoja verde.</p>', '2025-05-25', '2025-06-01', 'Activo'),
                                                                                                    (26, 26, 'Menú para la Piel Radiante', '<h2>Menú para la Piel Radiante</h2><p>Recetas ricas en antioxidantes, vitaminas C y E, y grasas saludables para una piel luminosa y sana.</p>', '2025-06-01', '2025-06-08', 'Activo'),
                                                                                                    (27, 27, 'Menú para el Verano', '<h2>Menú para el Verano</h2><p>Comidas frescas, ligeras y refrescantes perfectas para los días calurosos, con énfasis en frutas y verduras de temporada.</p>', '2025-06-05', '2025-06-12', 'Activo'),
                                                                                                    (28, 28, 'Menú de Comida Casera', '<h2>Menú de Comida Casera</h2><p>Platos tradicionales y reconfortantes, preparados con ingredientes frescos y sencillos para toda la familia.</p>', '2025-06-10', '2025-06-17', 'Activo'),
                                                                                                    (29, 29, 'Menú para el Estrés', '<h2>Menú para el Estrés</h2><p>Alimentos que ayudan a reducir el estrés y la ansiedad, promoviendo la relajación y el bienestar mental.</p>', '2025-06-15', '2025-06-22', 'Activo'),
                                                                                                    (30, 30, 'Menú de Celebración Saludable', '<h2>Menú de Celebración Saludable</h2><p>Opciones deliciosas y saludables para ocasiones especiales, para disfrutar sin culpas.</p>', '2025-06-18', '2025-06-25', 'Activo');

-- ----------------------------------------------------
-- UnidadMedida
-- Cantidad: moderado (~8-10 tipos fijos, luego aleatorios si se pide más)
-- ----------------------------------------------------
INSERT INTO UnidadMedida (id, nombre, simbolo) VALUES
                                                   (1, 'gramos', 'g'),
                                                   (2, 'kilogramos', 'kg'),
                                                   (3, 'mililitros', 'ml'),
                                                   (4, 'litros', 'L'),
                                                   (5, 'cucharadas', 'cda'),
                                                   (6, 'cucharaditas', 'cdta'),
                                                   (7, 'tazas', 'tz'),
                                                   (8, 'unidades', 'und'),
                                                   (9, 'pizcas', 'pz'),
                                                   (10, 'onzas', 'oz');

-- ----------------------------------------------------
-- Receta
-- Cantidad: moderado (~30 registros)
-- Datos: Descripciones HTML con pasos, variedad de nombres y tiempos.
-- ----------------------------------------------------
INSERT INTO Receta (id, id_usuario, fecha_creacion, nombre, porciones, peso_porcion, id_unidad_medida, tiempo_estimado, estado, foto, descripcion) VALUES
                                                                                                                                                       (1, 1, '2024-01-22', 'Salmón al Horno con Espárragos', 2, 250.00, 1, '00:30:00', 'Activo', 'https://example.com/salmon.jpg',
                                                                                                                                                        '<h2>Salmón al Horno con Espárragos</h2>
                                                                                                                                                        <p>Una receta sencilla y saludable, perfecta para una cena rápida.</p>
                                                                                                                                                        <ol>
                                                                                                                                                            <li><strong>Paso 1:</strong> Precalentar el horno a 200°C (400°F).</li>
                                                                                                                                                            <li><strong>Paso 2:</strong> Colocar los filetes de salmón y los espárragos en una bandeja para hornear.</li>
                                                                                                                                                            <li><strong>Paso 3:</strong> Rociar con aceite de oliva, sal, pimienta y jugo de limón.</li>
                                                                                                                                                            <li><strong>Paso 4:</strong> Hornear durante 12-15 minutos, o hasta que el salmón esté cocido.</li>
                                                                                                                                                        </ol>'),
                                                                                                                                                       (2, 2, '2024-02-01', 'Ensalada de Quinoa y Aguacate', 4, 200.50, 1, '00:20:00', 'Activo', 'https://example.com/quinoa.jpg',
                                                                                                                                                        '<h2>Ensalada de Quinoa y Aguacate</h2>
                                                                                                                                                        <p>Una ensalada refrescante y nutritiva, ideal para el almuerzo.</p>
                                                                                                                                                        <ol>
                                                                                                                                                            <li><strong>Paso 1:</strong> Cocinar la quinoa según las instrucciones del paquete y dejar enfriar.</li>
                                                                                                                                                            <li><strong>Paso 2:</strong> Picar tomate, pepino, cebolla roja y aguacate en cubos pequeños.</li>
                                                                                                                                                            <li><strong>Paso 3:</strong> En un bol grande, combinar la quinoa enfriada con los vegetales picados.</li>
                                                                                                                                                            <li><strong>Paso 4:</strong> Aderezar con jugo de limón, aceite de oliva, sal y cilantro picado. Mezclar bien.</li>
                                                                                                                                                        </ol>'),
                                                                                                                                                       (3, 3, '2024-03-10', 'Batido Verde Detox', 1, 300.00, 3, '00:05:00', 'Activo', 'https://example.com/batido.jpg',
                                                                                                                                                        '<h2>Batido Verde Detox</h2>
                                                                                                                                                        <p>Un batido lleno de nutrientes para empezar el día con energía o como merienda.</p>
                                                                                                                                                        <ol>
                                                                                                                                                            <li><strong>Paso 1:</strong> Colocar 1 taza de espinacas, 1/2 manzana verde, 1/2 plátano y 1/2 taza de agua/leche vegetal en la licuadora.</li>
                                                                                                                                                            <li><strong>Paso 2:</strong> Añadir una cucharadita de jengibre rallado (opcional).</li>
                                                                                                                                                            <li><strong>Paso 3:</strong> Licuar hasta obtener una consistencia suave.</li>
                                                                                                                                                            <li><strong>Paso 4:</strong> Servir inmediatamente.</li>
                                                                                                                                                        </ol>'),
                                                                                                                                                       (4, 4, '2024-04-01', 'Curry de Garbanzos Vegano', 4, 350.00, 1, '00:45:00', 'Activo', 'https://example.com/curry.jpg',
                                                                                                                                                        '<h2>Curry de Garbanzos Vegano</h2>
                                                                                                                                                        <p>Un plato reconfortante y lleno de sabor, perfecto para una comida principal.</p>
                                                                                                                                                        <ol>
                                                                                                                                                            <li><strong>Paso 1:</strong> Sofreír cebolla y ajo en aceite de coco en una olla grande.</li>
                                                                                                                                                            <li><strong>Paso 2:</strong> Añadir jengibre rallado, pasta de curry y cocinar por un minuto.</li>
                                                                                                                                                            <li><strong>Paso 3:</strong> Incorporar garbanzos, tomate triturado y leche de coco. Llevar a ebullición.</li>
                                                                                                                                                            <li><strong>Paso 4:</strong> Reducir el fuego y cocinar a fuego lento durante 20-25 minutos.</li>
                                                                                                                                                            <li><strong>Paso 5:</strong> Añadir espinacas frescas al final hasta que se marchiten. Servir con arroz integral.</li>
                                                                                                                                                        </ol>'),
                                                                                                                                                       (5, 5, '2024-05-18', 'Pechuga de Pollo Rellena', 2, 280.00, 1, '00:40:00', 'Inactivo', 'https://example.com/pollo.jpg',
                                                                                                                                                        '<h2>Pechuga de Pollo Rellena</h2>
                                                                                                                                                        <p>Una opción elegante y deliciosa, ideal para una cena especial.</p>
                                                                                                                                                        <ol>
                                                                                                                                                            <li><strong>Paso 1:</strong> Abrir las pechugas de pollo por la mitad sin cortarlas completamente.</li>
                                                                                                                                                            <li><strong>Paso 2:</strong> Rellenar con queso bajo en grasa y espinacas salteadas.</li>
                                                                                                                                                            <li><strong>Paso 3:</strong> Cerrar con palillos y dorar en una sartén.</li>
                                                                                                                                                            <li><strong>Paso 4:</strong> Terminar de cocinar en el horno precalentado a 180°C (350°F) por 20 minutos.</li>
                                                                                                                                                        </ol>'),
                                                                                                                                                       (6, 6, '2024-06-05', 'Tortitas de Avena sin Gluten', 3, 100.00, 1, '00:25:00', 'Activo', 'https://example.com/tortitas.jpg',
                                                                                                                                                        '<h2>Tortitas de Avena sin Gluten</h2>
                                                                                                                                                        <p>Un desayuno o merienda saludable y apto para celíacos.</p>
                                                                                                                                                        <ol>
                                                                                                                                                            <li><strong>Paso 1:</strong> Mezclar 1 taza de avena sin gluten, 1 huevo, 1/2 taza de leche vegetal y 1 cdta. de polvo para hornear.</li>
                                                                                                                                                            <li><strong>Paso 2:</strong> Dejar reposar la mezcla por 5 minutos.</li>
                                                                                                                                                            <li><strong>Paso 3:</strong> Calentar una sartén antiadherente con un poco de aceite de coco.</li>
                                                                                                                                                            <li><strong>Paso 4:</strong> Verter porciones de la mezcla y cocinar hasta que doren por ambos lados.</li>
                                                                                                                                                        </ol>'),
                                                                                                                                                       (7, 7, '2024-07-01', 'Sopa de Lentejas y Verduras', 6, 300.00, 3, '01:00:00', 'Activo', 'https://example.com/lentejas.jpg',
                                                                                                                                                        '<h2>Sopa de Lentejas y Verduras</h2>
                                                                                                                                                        <p>Una sopa nutritiva y reconfortante, perfecta para días fríos.</p>
                                                                                                                                                        <ol>
                                                                                                                                                            <li><strong>Paso 1:</strong> Remojar las lentejas por al menos 30 minutos (opcional).</li>
                                                                                                                                                            <li><strong>Paso 2:</strong> Sofreír cebolla, zanahoria y apio picados en una olla grande.</li>
                                                                                                                                                            <li><strong>Paso 3:</strong> Añadir las lentejas escurridas, caldo de verduras y especias al gusto.</li>
                                                                                                                                                            <li><strong>Paso 4:</strong> Cocinar a fuego lento por 45-60 minutos, hasta que las lentejas estén tiernas.</li>
                                                                                                                                                        </ol>'),
                                                                                                                                                       (8, 8, '2024-08-12', 'Bocadillos de Proteína Energéticos', 8, 50.00, 8, '00:15:00', 'Activo', 'https://example.com/bocadillos.jpg',
                                                                                                                                                        '<h2>Bocadillos de Proteína Energéticos</h2>
                                                                                                                                                        <p>Snacks fáciles de preparar y perfectos para antes o después del ejercicio.</p>
                                                                                                                                                        <ol>
                                                                                                                                                            <li><strong>Paso 1:</strong> En un bol, mezclar 1 taza de avena, 1/2 taza de mantequilla de cacahuete, 1/4 taza de miel y 1/4 taza de proteína en polvo.</li>
                                                                                                                                                            <li><strong>Paso 2:</strong> Opcional: añadir chips de chocolate negro o frutos secos picados.</li>
                                                                                                                                                            <li><strong>Paso 3:</strong> Formar pequeñas bolitas con la mezcla.</li>
                                                                                                                                                            <li><strong>Paso 4:</strong> Refrigerar por al menos 30 minutos antes de consumir.</li>
                                                                                                                                                        </ol>'),
                                                                                                                                                       (9, 9, '2024-09-08', 'Smoothie Bowl de Frutos Rojos', 1, 400.00, 3, '00:10:00', 'Inactivo', 'https://example.com/smoothie.jpg',
                                                                                                                                                        '<h2>Smoothie Bowl de Frutos Rojos</h2>
                                                                                                                                                        <p>Un desayuno o postre refrescante y lleno de antioxidantes.</p>
                                                                                                                                                        <ol>
                                                                                                                                                            <li><strong>Paso 1:</strong> Congelar plátanos y frutos rojos la noche anterior.</li>
                                                                                                                                                            <li><strong>Paso 2:</strong> Licuar 1 plátano congelado, 1 taza de frutos rojos congelados y 1/2 taza de leche vegetal hasta obtener una consistencia espesa.</li>
                                                                                                                                                            <li><strong>Paso 3:</strong> Verter en un bol y decorar con granola, semillas de chía o más frutos rojos.</li>
                                                                                                                                                        </ol>'),
                                                                                                                                                       (10, 10, '2024-10-02', 'Tacos de Pescado con Salsa de Yogur', 4, 180.00, 1, '00:35:00', 'Activo', 'https://example.com/tacos.jpg',
                                                                                                                                                        '<h2>Tacos de Pescado con Salsa de Yogur</h2>
                                                                                                                                                        <p>Una opción de tacos más ligera y saludable, perfecta para una cena divertida.</p>
                                                                                                                                                        <ol>
                                                                                                                                                            <li><strong>Paso 1:</strong> Sazonar filetes de pescado blanco con comino, pimentón, sal y pimienta.</li>
                                                                                                                                                            <li><strong>Paso 2:</strong> Cocinar el pescado en una sartén con un poco de aceite hasta que esté cocido y se desmenuce fácilmente.</li>
                                                                                                                                                            <li><strong>Paso 3:</strong> Preparar la salsa mezclando yogur griego natural, jugo de limón, cilantro picado y un toque de ajo en polvo.</li>
                                                                                                                                                            <li><strong>Paso 4:</strong> Calentar las tortillas de maíz. Rellenar con el pescado, repollo rallado, y la salsa de yogur.</li>
                                                                                                                                                        </ol>'),
                                                                                                                                                       (11, 11, '2024-11-10', 'Muffins de Calabacín y Zanahoria', 12, 60.00, 1, '00:45:00', 'Activo', 'https://example.com/muffins.jpg',
                                                                                                                                                        '<h2>Muffins de Calabacín y Zanahoria</h2>
                                                                                                                                                        <p>Una forma deliciosa de incorporar verduras a tu dieta en un dulce. Ideal para meriendas o desayunos.</p>
                                                                                                                                                        <ol>
                                                                                                                                                            <li><strong>Paso 1:</strong> Precalentar el horno a 180°C (350°F) y preparar un molde para muffins.</li>
                                                                                                                                                            <li><strong>Paso 2:</strong> En un bol, mezclar harina de trigo integral, azúcar moreno, canela, nuez moscada, bicarbonato de sodio y sal.</li>
                                                                                                                                                            <li><strong>Paso 3:</strong> En otro bol, batir huevos, aceite de coco derretido, leche vegetal y extracto de vainilla.</li>
                                                                                                                                                            <li><strong>Paso 4:</strong> Incorporar el calabacín rallado y la zanahoria rallada a la mezcla húmeda.</li>
                                                                                                                                                            <li><strong>Paso 5:</strong> Verter la mezcla húmeda en los ingredientes secos y mezclar solo hasta combinar.</li>
                                                                                                                                                            <li><strong>Paso 6:</strong> Llenar los moldes de muffins y hornear por 20-25 minutos, o hasta que un palillo salga limpio.</li>
                                                                                                                                                        </ol>'),
                                                                                                                                                       (12, 12, '2024-12-01', 'Arroz Integral con Champiñones', 3, 280.00, 1, '00:35:00', 'Activo', 'https://example.com/arrozchampi.jpg',
                                                                                                                                                        '<h2>Arroz Integral con Champiñones</h2>
                                                                                                                                                        <p>Un acompañamiento saludable y sabroso que complementa cualquier plato principal.</p>
                                                                                                                                                        <ol>
                                                                                                                                                            <li><strong>Paso 1:</strong> Cocinar el arroz integral según las instrucciones del paquete.</li>
                                                                                                                                                            <li><strong>Paso 2:</strong> Mientras el arroz se cocina, saltear cebolla y ajo picados en una sartén con aceite de oliva.</li>
                                                                                                                                                            <li><strong>Paso 3:</strong> Añadir los champiñones laminados y cocinar hasta que estén dorados.</li>
                                                                                                                                                            <li><strong>Paso 4:</strong> Incorporar el arroz cocido a la sartén con los champiñones, mezclar bien.</li>
                                                                                                                                                            <li><strong>Paso 5:</strong> Sazonar con sal, pimienta y perejil fresco picado.</li>
                                                                                                                                                        </ol>'),
                                                                                                                                                       (13, 13, '2025-01-08', 'Mini Pizzas de Berenjena', 4, 150.00, 8, '00:25:00', 'Activo', 'https://example.com/berenjena.jpg',
                                                                                                                                                        '<h2>Mini Pizzas de Berenjena</h2>
                                                                                                                                                        <p>Una alternativa baja en carbohidratos a la pizza tradicional, ¡deliciosa y fácil!</p>
                                                                                                                                                        <ol>
                                                                                                                                                            <li><strong>Paso 1:</strong> Cortar una berenjena grande en rodajas de 1 cm de grosor.</li>
                                                                                                                                                            <li><strong>Paso 2:</strong> Colocar las rodajas en una bandeja para hornear, rociar con aceite de oliva y sal, y hornear por 10 minutos.</li>
                                                                                                                                                            <li><strong>Paso 3:</strong> Retirar del horno, cubrir cada rodaja con salsa de tomate, queso mozzarella bajo en grasa y tus toppings favoritos (ej. pimiento, champiñones).</li>
                                                                                                                                                            <li><strong>Paso 4:</strong> Hornear nuevamente por 8-10 minutos, o hasta que el queso se derrita y burbujee.</li>
                                                                                                                                                        </ol>'),
                                                                                                                                                       (14, 14, '2025-01-30', 'Sopa Fría de Pepino y Yogur', 2, 280.00, 3, '00:15:00', 'Activo', 'https://example.com/sopapepino.jpg',
                                                                                                                                                        '<h2>Sopa Fría de Pepino y Yogur</h2>
                                                                                                                                                        <p>Refrescante y ligera, ideal para los días calurosos de verano.</p>
                                                                                                                                                        <ol>
                                                                                                                                                            <li><strong>Paso 1:</strong> Pelar y picar un pepino grande.</li>
                                                                                                                                                            <li><strong>Paso 2:</strong> En una licuadora, combinar el pepino picado con 1 taza de yogur griego natural, 1/2 diente de ajo, jugo de limón, menta fresca y un chorrito de agua.</li>
                                                                                                                                                            <li><strong>Paso 3:</strong> Licuar hasta obtener una consistencia suave.</li>
                                                                                                                                                            <li><strong>Paso 4:</strong> Sazonar con sal y pimienta al gusto. Refrigerar por al menos 30 minutos antes de servir.</li>
                                                                                                                                                        </ol>'),
                                                                                                                                                       (15, 15, '2025-02-20', 'Wrap de Lechuga con Pollo y Verduras', 2, 220.00, 1, '00:20:00', 'Activo', 'https://example.com/wraplechuga.jpg',
                                                                                                                                                        '<h2>Wrap de Lechuga con Pollo y Verduras</h2>
                                                                                                                                                        <p>Una opción de almuerzo baja en carbohidratos y alta en proteínas.</p>
                                                                                                                                                        <ol>
                                                                                                                                                            <li><strong>Paso 1:</strong> Cocinar y desmenuzar pechuga de pollo.</li>
                                                                                                                                                            <li><strong>Paso 2:</strong> Picar finamente zanahoria, pepino y pimiento.</li>
                                                                                                                                                            <li><strong>Paso 3:</strong> En un bol, mezclar el pollo desmenuzado con los vegetales picados y una cucharada de mayonesa ligera o yogur griego.</li>
                                                                                                                                                            <li><strong>Paso 4:</strong> Usar hojas grandes de lechuga (romana o iceberg) como "wraps" y rellenar con la mezcla de pollo.</li>
                                                                                                                                                        </ol>'),
                                                                                                                                                       (16, 16, '2025-03-05', 'Bol de Avena y Frutos Secos', 1, 200.00, 1, '00:10:00', 'Activo', 'https://example.com/avenafrutos.jpg',
                                                                                                                                                        '<h2>Bol de Avena y Frutos Secos</h2>
                                                                                                                                                        <p>Un desayuno nutritivo y saciante para comenzar el día con energía.</p>
                                                                                                                                                        <ol>
                                                                                                                                                            <li><strong>Paso 1:</strong> Cocinar 1/2 taza de avena con 1 taza de agua o leche vegetal según las instrucciones.</li>
                                                                                                                                                            <li><strong>Paso 2:</strong> Una vez cocida, añadir 1/4 taza de frutos secos picados (almendras, nueces) y 1 cucharada de semillas de chía.</li>
                                                                                                                                                            <li><strong>Paso 3:</strong> Endulzar con un poco de miel o sirope de arce al gusto.</li>
                                                                                                                                                            <li><strong>Paso 4:</strong> Decorar con bayas frescas o rodajas de plátano antes de servir.</li>
                                                                                                                                                        </ol>'),
                                                                                                                                                       (17, 17, '2025-03-12', 'Bolas Energéticas de Dátiles y Coco', 10, 30.00, 8, '00:15:00', 'Inactivo', 'https://example.com/bolasdatiles.jpg',
                                                                                                                                                        '<h2>Bolas Energéticas de Dátiles y Coco</h2>
                                                                                                                                                        <p>Snacks saludables y sin hornear, perfectos para un impulso de energía.</p>
                                                                                                                                                        <ol>
                                                                                                                                                            <li><strong>Paso 1:</strong> En un procesador de alimentos, combinar 1 taza de dátiles deshuesados, 1/2 taza de avena, 1/4 taza de coco rallado y 1 cucharada de mantequilla de cacahuete.</li>
                                                                                                                                                            <li><strong>Paso 2:</strong> Procesar hasta que la mezcla se una y sea pegajosa.</li>
                                                                                                                                                            <li><strong>Paso 3:</strong> Formar pequeñas bolitas con la mezcla.</li>
                                                                                                                                                            <li><strong>Paso 4:</strong> Opcional: rebozar las bolitas en más coco rallado, cacao en polvo o semillas de sésamo.</li>
                                                                                                                                                            <li><strong>Paso 5:</strong> Refrigerar por al menos 30 minutos antes de consumir.</li>
                                                                                                                                                        </ol>'),
                                                                                                                                                       (18, 18, '2025-04-01', 'Tallarines de Calabacín con Pesto', 2, 260.00, 1, '00:20:00', 'Activo', 'https://example.com/tallarinescalabacin.jpg',
                                                                                                                                                        '<h2>Tallarines de Calabacín con Pesto</h2>
                                                                                                                                                        <p>Una alternativa ligera y fresca a la pasta tradicional, llena de sabor.</p>
                                                                                                                                                        <ol>
                                                                                                                                                            <li><strong>Paso 1:</strong> Con un espiralizador o pelador de juliana, crear "tallarines" de calabacín.</li>
                                                                                                                                                            <li><strong>Paso 2:</strong> En una sartén grande, saltear ligeramente los tallarines de calabacín con un poco de aceite de oliva por 2-3 minutos, solo hasta que estén tiernos pero aún crujientes.</li>
                                                                                                                                                            <li><strong>Paso 3:</strong> Retirar del fuego y mezclar con pesto casero o comprado.</li>
                                                                                                                                                            <li><strong>Paso 4:</strong> Opcional: Añadir tomates cherry cortados por la mitad y piñones tostados.</li>
                                                                                                                                                        </ol>'),
                                                                                                                                                       (19, 19, '2025-04-10', 'Hamburguesas de Lentejas Caseras', 4, 180.00, 1, '00:45:00', 'Activo', 'https://example.com/hamburguesalentejas.jpg',
                                                                                                                                                        '<h2>Hamburguesas de Lentejas Caseras</h2>
                                                                                                                                                        <p>Una opción vegana y saludable para tus hamburguesas, ricas en fibra y proteína.</p>
                                                                                                                                                        <ol>
                                                                                                                                                            <li><strong>Paso 1:</strong> Cocinar las lentejas hasta que estén blandas y luego escurrirlas bien.</li>
                                                                                                                                                            <li><strong>Paso 2:</strong> En un bol, machacar las lentejas cocidas (no completamente, dejar algunos trozos).</li>
                                                                                                                                                            <li><strong>Paso 3:</strong> Sofreír cebolla, ajo y pimiento picados. Añadirlos a las lentejas junto con pan rallado, especias (comino, pimentón) y un poco de perejil fresco.</li>
                                                                                                                                                            <li><strong>Paso 4:</strong> Mezclar bien y formar las hamburguesas.</li>
                                                                                                                                                            <li><strong>Paso 5:</strong> Cocinar en una sartén con un poco de aceite hasta que estén doradas por ambos lados, o hornear.</li>
                                                                                                                                                        </ol>'),
                                                                                                                                                       (20, 20, '2025-05-01', 'Pollo Tailandés con Verduras', 2, 350.00, 1, '00:30:00', 'Activo', 'https://example.com/pollotailandes.jpg',
                                                                                                                                                        '<h2>Pollo Tailandés con Verduras</h2>
                                                                                                                                                        <p>Un plato exótico y lleno de sabor, con la combinación perfecta de dulce, salado y picante.</p>
                                                                                                                                                        <ol>
                                                                                                                                                            <li><strong>Paso 1:</strong> Cortar el pollo en tiras y saltear en un wok o sartén grande con un poco de aceite de sésamo.</li>
                                                                                                                                                            <li><strong>Paso 2:</strong> Cuando el pollo esté casi cocido, añadir vegetales como brócoli, pimientos, zanahorias y guisantes.</li>
                                                                                                                                                            <li><strong>Paso 3:</strong> Preparar la salsa mezclando leche de coco, salsa de soja (o tamari), pasta de curry rojo y un toque de miel o sirope de arce.</li>
                                                                                                                                                            <li><strong>Paso 4:</strong> Verter la salsa sobre el pollo y las verduras, cocinar a fuego lento hasta que las verduras estén tiernas y la salsa espese.</li>
                                                                                                                                                            <li><strong>Paso 5:</strong> Servir caliente con arroz jazmín o arroz integral.</li>
                                                                                                                                                        </ol>'),
                                                                                                                                                       (21, 21, '2025-05-05', 'Tostadas de Aguacate y Huevo Poché', 1, 200.00, 1, '00:15:00', 'Activo', 'https://example.com/tostadasaguacate.jpg',
                                                                                                                                                        '<h2>Tostadas de Aguacate y Huevo Poché</h2>
                                                                                                                                                        <p>Un desayuno o brunch clásico, nutritivo y delicioso.</p>
                                                                                                                                                        <ol>
                                                                                                                                                            <li><strong>Paso 1:</strong> Tostar 1 o 2 rebanadas de pan integral.</li>
                                                                                                                                                            <li><strong>Paso 2:</strong> Mientras tanto, machacar medio aguacate con un tenedor y sazonar con sal, pimienta y un chorrito de limón.</li>
                                                                                                                                                            <li><strong>Paso 3:</strong> Pochar un huevo: Hervir agua en una olla, reducir el fuego a un hervor suave. Cascar el huevo en una taza, crear un remolino en el agua y deslizar el huevo con cuidado. Cocinar por 3-4 minutos.</li>
                                                                                                                                                            <li><strong>Paso 4:</strong> Untar el aguacate sobre las tostadas y colocar el huevo poché encima.</li>
                                                                                                                                                            <li><strong>Paso 5:</strong> Espolvorear con hojuelas de chile o sésamo (opcional).</li>
                                                                                                                                                        </ol>'),
                                                                                                                                                       (22, 22, '2025-05-12', 'Sopa Cremosa de Calabaza', 4, 300.00, 3, '00:40:00', 'Activo', 'https://example.com/sopacalabaza.jpg',
                                                                                                                                                        '<h2>Sopa Cremosa de Calabaza</h2>
                                                                                                                                                        <p>Una sopa reconfortante y nutritiva, perfecta para los días frescos.</p>
                                                                                                                                                        <ol>
                                                                                                                                                            <li><strong>Paso 1:</strong> Picar calabaza, zanahoria, cebolla y ajo.</li>
                                                                                                                                                            <li><strong>Paso 2:</strong> Sofreír la cebolla y el ajo en una olla con un poco de aceite de oliva.</li>
                                                                                                                                                            <li><strong>Paso 3:</strong> Añadir la calabaza y la zanahoria, cocinar por unos minutos.</li>
                                                                                                                                                            <li><strong>Paso 4:</strong> Cubrir con caldo de verduras y cocinar hasta que las verduras estén muy tiernas.</li>
                                                                                                                                                            <li><strong>Paso 5:</strong> Retirar del fuego, triturar con una batidora de mano hasta obtener una crema suave.</li>
                                                                                                                                                            <li><strong>Paso 6:</strong> Regresar al fuego, añadir un toque de leche o crema ligera, ajustar sazón y servir.</li>
                                                                                                                                                        </ol>'),
                                                                                                                                                       (23, 23, '2025-05-18', 'Ensalada Caprese con Reducción Balsámica', 2, 220.00, 1, '00:10:00', 'Activo', 'https://example.com/caprese.jpg',
                                                                                                                                                        '<h2>Ensalada Caprese con Reducción Balsámica</h2>
                                                                                                                                                        <p>Un clásico italiano fresco y lleno de sabor, ideal como entrante o guarnición.</p>
                                                                                                                                                        <ol>
                                                                                                                                                            <li><strong>Paso 1:</strong> Cortar tomates maduros y mozzarella fresca en rodajas uniformes.</li>
                                                                                                                                                            <li><strong>Paso 2:</strong> Alternar las rodajas de tomate y mozzarella con hojas de albahaca fresca en un plato.</li>
                                                                                                                                                            <li><strong>Paso 3:</strong> Para la reducción balsámica: Cocinar vinagre balsámico a fuego lento hasta que espese y se reduzca a la mitad.</li>
                                                                                                                                                            <li><strong>Paso 4:</strong> Rociar la ensalada con aceite de oliva virgen extra y la reducción balsámica.</li>
                                                                                                                                                            <li><strong>Paso 5:</strong> Sazonar con sal y pimienta recién molida.</li>
                                                                                                                                                        </ol>'),
                                                                                                                                                       (24, 24, '2025-05-25', 'Pescado Blanco en Papillote con Limón y Hierbas', 2, 280.00, 1, '00:30:00', 'Inactivo', 'https://example.com/papillote.jpg',
                                                                                                                                                        '<h2>Pescado Blanco en Papillote con Limón y Hierbas</h2>
                                                                                                                                                        <p>Una forma saludable y sabrosa de cocinar pescado, que sella los jugos y sabores.</p>
                                                                                                                                                        <ol>
                                                                                                                                                            <li><strong>Paso 1:</strong> Precalentar el horno a 200°C (400°F).</li>
                                                                                                                                                            <li><strong>Paso 2:</strong> Preparar dos trozos grandes de papel de horno o papel de aluminio.</li>
                                                                                                                                                            <li><strong>Paso 3:</strong> Colocar un filete de pescado blanco (merluza, bacalao) en el centro de cada papel.</li>
                                                                                                                                                            <li><strong>Paso 4:</strong> Añadir rodajas de limón, ramas de tomillo y romero, sal y pimienta. Opcional: verduras cortadas finas.</li>
                                                                                                                                                            <li><strong>Paso 5:</strong> Cerrar el papel formando un paquete hermético.</li>
                                                                                                                                                            <li><strong>Paso 6:</strong> Hornear durante 15-20 minutos, o hasta que el pescado esté cocido. Servir directamente en el paquete.</li>
                                                                                                                                                        </ol>'),
                                                                                                                                                       (25, 25, '2025-06-01', 'Tortilla de Claras con Champiñones', 1, 150.00, 1, '00:10:00', 'Activo', 'https://example.com/tortillaclaras.jpg',
                                                                                                                                                        '<h2>Tortilla de Claras con Champiñones</h2>
                                                                                                                                                        <p>Un desayuno o cena ligera y alta en proteínas, ideal para la recuperación.</p>
                                                                                                                                                        <ol>
                                                                                                                                                            <li><strong>Paso 1:</strong> Batir claras de huevo con una pizca de sal y pimienta.</li>
                                                                                                                                                            <li><strong>Paso 2:</strong> Saltear champiñones laminados en una sartén antiadherente con un poco de aceite.</li>
                                                                                                                                                            <li><strong>Paso 3:</strong> Verter las claras batidas sobre los champiñones en la sartén.</li>
                                                                                                                                                            <li><strong>Paso 4:</strong> Cocinar a fuego medio-bajo hasta que la tortilla esté cuajada por un lado, luego doblar por la mitad y cocinar por un minuto más.</li>
                                                                                                                                                            <li><strong>Paso 5:</strong> Servir con un poco de perejil fresco picado.</li>
                                                                                                                                                        </ol>'),
                                                                                                                                                       (26, 26, '2025-06-05', 'Ensalada Griega Saludable', 3, 280.00, 1, '00:15:00', 'Activo', 'https://example.com/ensaladagriega.jpg',
                                                                                                                                                        '<h2>Ensalada Griega Saludable</h2>
                                                                                                                                                        <p>Una explosión de frescura mediterránea, perfecta para cualquier momento del día.</p>
                                                                                                                                                        <ol>
                                                                                                                                                            <li><strong>Paso 1:</strong> Picar tomate, pepino, cebolla roja y pimiento verde en cubos.</li>
                                                                                                                                                            <li><strong>Paso 2:</strong> Combinar los vegetales en un bol grande.</li>
                                                                                                                                                            <li><strong>Paso 3:</strong> Añadir aceitunas Kalamata y dados de queso feta bajo en grasa.</li>
                                                                                                                                                            <li><strong>Paso 4:</strong> Aderezar con aceite de oliva virgen extra, orégano seco, sal y pimienta. Mezclar suavemente.</li>
                                                                                                                                                        </ol>'),
                                                                                                                                                       (27, 27, '2025-06-10', 'Brochetas de Pollo y Verduras a la Parrilla', 4, 250.00, 1, '00:25:00', 'Activo', 'https://example.com/brochetas.jpg',
                                                                                                                                                        '<h2>Brochetas de Pollo y Verduras a la Parrilla</h2>
                                                                                                                                                        <p>Una opción colorida y sabrosa para una comida ligera o una barbacoa.</p>
                                                                                                                                                        <ol>
                                                                                                                                                            <li><strong>Paso 1:</strong> Cortar pechuga de pollo en cubos y verduras como pimientos, cebolla y calabacín en trozos similares.</li>
                                                                                                                                                            <li><strong>Paso 2:</strong> Ensartar alternadamente el pollo y las verduras en brochetas.</li>
                                                                                                                                                            <li><strong>Paso 3:</strong> Marinar las brochetas con aceite de oliva, jugo de limón, ajo picado, orégano, sal y pimienta por al menos 20 minutos.</li>
                                                                                                                                                            <li><strong>Paso 4:</strong> Cocinar las brochetas en una parrilla caliente o sartén a la plancha hasta que el pollo esté cocido y las verduras tiernas y ligeramente carbonizadas.</li>
                                                                                                                                                        </ol>'),
                                                                                                                                                       (28, 28, '2025-06-12', 'Gazpacho Andaluz Ligero', 6, 350.00, 3, '00:20:00', 'Activo', 'https://example.com/gazpacho.jpg',
                                                                                                                                                        '<h2>Gazpacho Andaluz Ligero</h2>
                                                                                                                                                        <p>Un clásico de la cocina española, refrescante y nutritivo, perfecto para el verano.</p>
                                                                                                                                                        <ol>
                                                                                                                                                            <li><strong>Paso 1:</strong> Lavar y picar tomates maduros, pepino, pimiento verde, cebolla y un diente de ajo.</li>
                                                                                                                                                            <li><strong>Paso 2:</strong> Colocar todas las verduras en una batidora o licuadora.</li>
                                                                                                                                                            <li><strong>Paso 3:</strong> Añadir un poco de agua fría, vinagre de Jerez (o manzana), aceite de oliva virgen extra, sal y pimienta al gusto.</li>
                                                                                                                                                            <li><strong>Paso 4:</strong> Triturar hasta obtener una sopa muy fina y homogénea. Si es necesario, pasar por un colador fino.</li>
                                                                                                                                                            <li><strong>Paso 5:</strong> Refrigerar por al menos 2 horas antes de servir. Se puede acompañar con picatostes y verduras picadas.</li>
                                                                                                                                                        </ol>'),
                                                                                                                                                       (29, 29, '2025-06-15', 'Desayuno de Yogur Griego con Frutas y Granola', 1, 280.00, 1, '00:05:00', 'Activo', 'https://example.com/yogurgriego.jpg',
                                                                                                                                                        '<h2>Desayuno de Yogur Griego con Frutas y Granola</h2>
                                                                                                                                                        <p>Un desayuno rápido, delicioso y completo para empezar el día con vitalidad.</p>
                                                                                                                                                        <ol>
                                                                                                                                                            <li><strong>Paso 1:</strong> En un bol, colocar una porción generosa de yogur griego natural.</li>
                                                                                                                                                            <li><strong>Paso 2:</strong> Añadir frutas frescas picadas como fresas, arándanos, plátano o kiwi.</li>
                                                                                                                                                            <li><strong>Paso 3:</strong> Espolvorear con granola y un chorrito de miel o sirope de arce si se desea un toque dulce.</li>
                                                                                                                                                            <li><strong>Paso 4:</strong> Servir inmediatamente.</li>
                                                                                                                                                        </ol>'),
                                                                                                                                                       (30, 30, '2025-06-19', 'Mini Quiches de Espinacas y Queso Cottage', 6, 120.00, 8, '00:40:00', 'Activo', 'https://example.com/miniquiches.jpg',
                                                                                                                                                        '<h2>Mini Quiches de Espinacas y Queso Cottage</h2>
                                                                                                                                                        <p>Perfectas para un brunch, merienda o como entrante saludable.</p>
                                                                                                                                                        <ol>
                                                                                                                                                            <li><strong>Paso 1:</strong> Precalentar el horno a 180°C (350°F). Engrasar un molde para muffins.</li>
                                                                                                                                                            <li><strong>Paso 2:</strong> En una sartén, saltear espinacas frescas picadas hasta que se reduzcan. Escurrir el exceso de líquido.</li>
                                                                                                                                                            <li><strong>Paso 3:</strong> En un bol, batir huevos con queso cottage bajo en grasa, sal, pimienta y nuez moscada.</li>
                                                                                                                                                            <li><strong>Paso 4:</strong> Incorporar las espinacas salteadas a la mezcla de huevo.</li>
                                                                                                                                                            <li><strong>Paso 5:</strong> Verter la mezcla en los moldes de muffins.</li>
                                                                                                                                                            <li><strong>Paso 6:</strong> Hornear por 20-25 minutos, o hasta que estén doradas y firmes.</li>
                                                                                                                                                        </ol>');

-- ----------------------------------------------------
-- MenuReceta (Relación N:M)
-- Cantidad: moderado (~60 registros para reflejar complejidad)
-- Datos: Cada menú con múltiples recetas, porciones de 1 a 10.
-- ----------------------------------------------------
INSERT INTO MenuReceta (id_menu, id_receta, porciones) VALUES
                                                           (1, 1, 2), (1, 2, 4), (1, 3, 1), (1, 6, 3), (1, 8, 2),
                                                           (2, 1, 2), (2, 5, 2), (2, 8, 3), (2, 10, 4), (2, 12, 3), (2, 17, 5),
                                                           (3, 2, 2), (3, 3, 1), (3, 7, 2), (3, 9, 1), (3, 11, 2),
                                                           (4, 4, 4), (4, 7, 3), (4, 11, 4), (4, 15, 2),
                                                           (5, 5, 3), (5, 8, 4), (5, 10, 2), (5, 12, 2),
                                                           (6, 6, 2), (6, 11, 3), (6, 13, 2), (6, 15, 3), (6, 19, 4),
                                                           (7, 1, 2), (7, 3, 1), (7, 5, 2), (7, 7, 3),
                                                           (8, 8, 4), (8, 10, 3), (8, 12, 2), (8, 14, 2),
                                                           (9, 3, 1), (9, 9, 1), (9, 14, 1),
                                                           (10, 2, 3), (10, 4, 2), (10, 10, 4), (10, 16, 2),
                                                           (11, 1, 2), (11, 3, 1), (11, 11, 2), (11, 13, 3),
                                                           (12, 2, 2), (12, 6, 3), (12, 12, 2), (12, 16, 3),
                                                           (13, 3, 1), (13, 9, 1), (13, 15, 2), (13, 21, 1),
                                                           (14, 4, 3), (14, 7, 2), (14, 14, 2), (14, 18, 3),
                                                           (15, 5, 2), (15, 10, 2), (15, 16, 2), (15, 22, 2),
                                                           (16, 1, 3), (16, 2, 4), (16, 13, 2), (16, 23, 2),
                                                           (17, 6, 2), (17, 11, 3), (17, 19, 4), (17, 24, 2),
                                                           (18, 4, 4), (18, 10, 3), (18, 18, 2), (18, 20, 2),
                                                           (19, 6, 2), (19, 11, 3), (19, 19, 4), (19, 25, 1),
                                                           (20, 1, 2), (20, 8, 3), (20, 12, 2), (20, 20, 2);


-- ----------------------------------------------------
-- RecetaFavorita
-- Cantidad: moderado (~60 registros)
-- Datos: Algunos usuarios con muchas recetas favoritas, algunos con pocas.
-- Algunas recetas muy favoritas.
-- ----------------------------------------------------
INSERT INTO RecetaFavorita (id, id_receta, id_usuario, fecha_agregado) VALUES
                                                                           (1, 1, 3, '2024-04-05 10:00:00'),
                                                                           (2, 2, 3, '2024-04-06 11:30:00'),
                                                                           (3, 3, 3, '2024-04-07 12:00:00'), -- Usuario 3 con varias
                                                                           (4, 1, 4, '2024-05-10 09:15:00'),
                                                                           (5, 5, 4, '2024-05-11 13:00:00'),
                                                                           (6, 6, 6, '2024-06-25 14:00:00'),
                                                                           (7, 7, 7, '2024-07-02 10:30:00'),
                                                                           (8, 8, 8, '2024-08-15 16:00:00'),
                                                                           (9, 10, 10, '2024-10-05 11:00:00'),
                                                                           (10, 11, 11, '2024-11-20 08:00:00'),
                                                                           (11, 12, 12, '2024-12-05 17:30:00'),
                                                                           (12, 13, 13, '2025-01-10 12:45:00'),
                                                                           (13, 14, 14, '2025-01-31 09:00:00'),
                                                                           (14, 15, 15, '2025-02-25 15:00:00'),
                                                                           (15, 16, 16, '2025-03-02 10:00:00'),
                                                                           (16, 18, 18, '2025-04-05 11:45:00'),
                                                                           (17, 19, 19, '2025-04-12 13:00:00'),
                                                                           (18, 20, 20, '2025-05-02 09:30:00'),
                                                                           (19, 21, 21, '2025-05-06 10:00:00'),
                                                                           (20, 22, 22, '2025-05-15 14:00:00'),
                                                                           (21, 23, 23, '2025-05-20 16:00:00'),
                                                                           (22, 25, 25, '2025-06-02 08:30:00'),
                                                                           (23, 26, 26, '2025-06-06 10:00:00'),
                                                                           (24, 27, 27, '2025-06-11 11:30:00'),
                                                                           (25, 28, 28, '2025-06-13 12:00:00'),
                                                                           (26, 29, 29, '2025-06-16 13:00:00'),
                                                                           (27, 30, 30, '2025-06-20 09:00:00'),
                                                                           (28, 1, 5, '2025-01-01 08:00:00'), -- Receta 1 muy favorita
                                                                           (29, 1, 7, '2025-02-01 09:00:00'),
                                                                           (30, 1, 9, '2025-03-01 10:00:00'),
                                                                           (31, 1, 11, '2025-04-01 11:00:00'),
                                                                           (32, 1, 13, '2025-05-01 12:00:00'),
                                                                           (33, 2, 5, '2025-01-02 08:15:00'), -- Receta 2 muy favorita
                                                                           (34, 2, 9, '2025-03-02 10:15:00'),
                                                                           (35, 2, 15, '2025-04-02 11:15:00'),
                                                                           (36, 3, 5, '2025-01-03 08:30:00'), -- Receta 3 muy favorita
                                                                           (37, 3, 10, '2025-02-03 09:30:00'),
                                                                           (38, 3, 12, '2025-03-03 10:30:00'),
                                                                           (39, 4, 1, '2024-04-02 08:45:00'),
                                                                           (40, 4, 2, '2024-05-02 09:45:00'),
                                                                           (41, 4, 3, '2024-06-02 10:45:00'),
                                                                           (42, 5, 1, '2024-05-20 09:00:00'),
                                                                           (43, 5, 2, '2024-06-20 10:00:00'),
                                                                           (44, 6, 1, '2024-06-26 09:15:00'),
                                                                           (45, 6, 2, '2024-07-26 10:15:00'),
                                                                           (46, 7, 1, '2024-07-03 09:30:00'),
                                                                           (47, 7, 2, '2024-08-03 10:30:00'),
                                                                           (48, 8, 1, '2024-08-16 09:45:00'),
                                                                           (49, 8, 2, '2024-09-16 10:45:00'),
                                                                           (50, 9, 1, '2024-09-09 10:00:00'),
                                                                           (51, 9, 2, '2024-10-09 11:00:00'),
                                                                           (52, 10, 1, '2024-10-03 10:15:00'),
                                                                           (53, 10, 2, '2024-11-03 11:15:00'),
                                                                           (54, 11, 1, '2024-11-11 10:30:00'),
                                                                           (55, 11, 2, '2024-12-11 11:30:00'),
                                                                           (56, 12, 1, '2024-12-02 10:45:00'),
                                                                           (57, 12, 2, '2025-01-02 11:45:00'),
                                                                           (58, 13, 1, '2025-01-11 11:00:00'),
                                                                           (59, 13, 2, '2025-02-11 12:00:00'),
                                                                           (60, 14, 1, '2025-02-01 11:15:00');

-- ----------------------------------------------------
-- Etiqueta
-- Cantidad: moderado (~15-20 registros)
-- Datos: Nombres y colores variados, incluye los ENUM.
-- ----------------------------------------------------
INSERT INTO Etiqueta (id, id_usuario, nombre, color, estado) VALUES
                                                                 (1, 1, 'Vegetariano', '4CAF50', 'Activo'),
                                                                 (2, 1, 'Vegano', '008000', 'Activo'),
                                                                 (3, 2, 'Sin Gluten', 'FFC107', 'Activo'),
                                                                 (4, 2, 'Alto en Proteínas', '2196F3', 'Activo'),
                                                                 (5, 3, 'Bajo en Carbohidratos', 'F44336', 'Activo'),
                                                                 (6, 3, 'Desayuno', 'FFEB3B', 'Activo'),
                                                                 (7, 4, 'Almuerzo', '8BC34A', 'Activo'),
                                                                 (8, 4, 'Cena', '9C27B0', 'Activo'),
                                                                 (9, 5, 'Postre', 'E91E63', 'Inactivo'),
                                                                 (10, 5, 'Snack', 'FF9800', 'Activo'),
                                                                 (11, 6, 'Dieta Keto', '607D8B', 'Activo'),
                                                                 (12, 7, 'Rápido', '03A9F4', 'Activo'),
                                                                 (13, 8, 'Antiinflamatorio', 'CDDC39', 'Activo'),
                                                                 (14, 9, 'Detox', '795548', 'Inactivo'),
                                                                 (15, 10, 'Para Niños', 'FFEB3B', 'Activo'),
                                                                 (16, 11, 'Mediterráneo', '00BCD4', 'Activo'),
                                                                 (17, 12, 'Confort Food', '7B1FA2', 'Activo'),
                                                                 (18, 13, 'Picante', 'E57373', 'Activo'),
                                                                 (19, 14, 'Tropical', '8BC34A', 'Activo'),
                                                                 (20, 15, 'Energético', 'FFD700', 'Activo');

-- ----------------------------------------------------
-- RecetaEtiqueta (Relación N:M)
-- Cantidad: moderado (~60 registros para reflejar complejidad)
-- Datos: Cada receta con varias etiquetas y viceversa.
-- ----------------------------------------------------
INSERT INTO RecetaEtiqueta (id_etiqueta, id_receta) VALUES
                                                        (1, 2), (1, 4), (1, 7), (1, 13), (1, 18), (1, 26),
                                                        (2, 4), (2, 7), (2, 9), (2, 19),
                                                        (3, 1), (3, 6), (3, 11), (3, 19), (3, 24),
                                                        (4, 1), (4, 5), (4, 8), (4, 10), (4, 16), (4, 20), (4, 25), (4, 27),
                                                        (5, 5), (5, 15), (5, 24),
                                                        (6, 3), (6, 6), (6, 9), (6, 11), (6, 16), (6, 21), (6, 25), (6, 29),
                                                        (7, 1), (7, 5), (7, 10), (7, 15), (7, 20), (7, 27), (7, 28),
                                                        (8, 1), (8, 5), (8, 10), (8, 15), (8, 20), (8, 24), (8, 27),
                                                        (9, 9), (9, 17),
                                                        (10, 3), (10, 8), (10, 17), (10, 29),
                                                        (11, 1), (11, 5), (11, 10), (11, 15),
                                                        (12, 2), (12, 3), (12, 7), (12, 8), (12, 14), (12, 17), (12, 21), (12, 23),
                                                        (13, 2), (13, 7), (13, 12), (13, 14), (13, 22), (13, 26),
                                                        (14, 3), (14, 9), (14, 14),
                                                        (15, 13), (15, 23),
                                                        (16, 2), (16, 16), (16, 26),
                                                        (17, 7), (17, 17), (17, 22),
                                                        (18, 10), (18, 18), (18, 20),
                                                        (19, 4), (19, 19),
                                                        (20, 8), (20, 20);

-- ----------------------------------------------------
-- TipoInsumo
-- Cantidad: moderado (~8 tipos fijos)
-- ----------------------------------------------------
INSERT INTO TipoInsumo (id, nombre) VALUES
                                        (1, 'Fruta'),
                                        (2, 'Verdura'),
                                        (3, 'Proteína'),
                                        (4, 'Lácteo'),
                                        (5, 'Grano'),
                                        (6, 'Especia'),
                                        (7, 'Aceite'),
                                        (8, 'Edulcorante');

-- ----------------------------------------------------
-- Insumo
-- Cantidad: moderado (~60 registros)
-- Datos: Nombres variados, combinaciones lógicas de unidades y tipos.
-- ----------------------------------------------------
INSERT INTO Insumo (id, id_unidad_medida, id_tipo_insumo, nombre, estado) VALUES
                                                                              (1, 1, 3, 'Pechuga de Pollo', 'Activo'),
                                                                              (2, 1, 3, 'Salmón', 'Activo'),
                                                                              (3, 1, 5, 'Quinoa', 'Activo'),
                                                                              (4, 1, 2, 'Espinacas', 'Activo'),
                                                                              (5, 8, 1, 'Aguacate', 'Activo'),
                                                                              (6, 1, 2, 'Tomate', 'Activo'),
                                                                              (7, 1, 2, 'Pepino', 'Activo'),
                                                                              (8, 1, 2, 'Cebolla', 'Activo'),
                                                                              (9, 1, 6, 'Ajo', 'Activo'),
                                                                              (10, 4, 4, 'Leche de Almendras', 'Activo'),
                                                                              (11, 1, 2, 'Calabacín', 'Activo'),
                                                                              (12, 1, 2, 'Zanahoria', 'Activo'),
                                                                              (13, 1, 5, 'Avena', 'Activo'),
                                                                              (14, 8, 1, 'Plátano', 'Activo'),
                                                                              (15, 1, 7, 'Aceite de Oliva', 'Activo'),
                                                                              (16, 1, 6, 'Pimienta Negra', 'Activo'),
                                                                              (17, 1, 6, 'Sal Marina', 'Activo'),
                                                                              (18, 1, 3, 'Garbanzos (cocidos)', 'Activo'),
                                                                              (19, 1, 4, 'Yogur Griego', 'Activo'),
                                                                              (20, 1, 2, 'Brócoli', 'Activo'),
                                                                              (21, 1, 2, 'Pimiento Rojo', 'Activo'),
                                                                              (22, 1, 2, 'Champiñones', 'Activo'),
                                                                              (23, 1, 8, 'Miel', 'Activo'),
                                                                              (24, 1, 3, 'Huevo', 'Activo'),
                                                                              (25, 1, 4, 'Queso Mozzarella', 'Activo'),
                                                                              (26, 1, 2, 'Lechuga Romana', 'Activo'),
                                                                              (27, 1, 1, 'Limón', 'Activo'),
                                                                              (28, 1, 6, 'Jengibre', 'Activo'),
                                                                              (29, 1, 5, 'Lentejas (secas)', 'Activo'),
                                                                              (30, 1, 7, 'Aceite de Coco', 'Activo'),
                                                                              (31, 1, 8, 'Azúcar Morena', 'Activo'),
                                                                              (32, 1, 6, 'Canela', 'Activo'),
                                                                              (33, 1, 6, 'Polvo para hornear', 'Activo'),
                                                                              (34, 1, 3, 'Carne Picada Magra', 'Activo'),
                                                                              (35, 1, 5, 'Arroz Integral', 'Activo'),
                                                                              (36, 1, 1, 'Manzana Verde', 'Activo'),
                                                                              (37, 1, 6, 'Cilantro', 'Activo'),
                                                                              (38, 1, 4, 'Leche de Coco', 'Activo'),
                                                                              (39, 1, 6, 'Pasta de Curry', 'Activo'),
                                                                              (40, 1, 3, 'Atún enlatado', 'Activo'),
                                                                              (41, 1, 5, 'Pan Integral', 'Activo'),
                                                                              (42, 1, 6, 'Albahaca Fresca', 'Activo'),
                                                                              (43, 1, 1, 'Fresas', 'Activo'),
                                                                              (44, 1, 1, 'Arándanos', 'Activo'),
                                                                              (45, 1, 5, 'Granola', 'Activo'),
                                                                              (46, 1, 3, 'Tofu Firme', 'Activo'),
                                                                              (47, 1, 2, 'Espárragos', 'Activo'),
                                                                              (48, 1, 6, 'Orégano', 'Activo'),
                                                                              (49, 1, 6, 'Tomillo', 'Activo'),
                                                                              (50, 1, 6, 'Romero', 'Activo'),
                                                                              (51, 1, 4, 'Queso Feta', 'Activo'),
                                                                              (52, 1, 2, 'Aceitunas Kalamata', 'Activo'),
                                                                              (53, 1, 6, 'Vinagre Balsámico', 'Activo'),
                                                                              (54, 1, 6, 'Nuez Moscada', 'Activo'),
                                                                              (55, 1, 6, 'Comino', 'Activo'),
                                                                              (56, 1, 8, 'Dátiles', 'Activo'),
                                                                              (57, 1, 7, 'Mantequilla de Cacahuete', 'Activo'),
                                                                              (58, 1, 5, 'Coco Rallado', 'Activo'),
                                                                              (59, 1, 6, 'Semillas de Chía', 'Activo'),
                                                                              (60, 1, 3, 'Pescado Blanco', 'Activo');

-- ----------------------------------------------------
-- RecetaDetalle
-- Cantidad: moderado (~90 registros para reflejar composición de recetas)
-- Datos: Cantidades variadas para insumos en recetas.
-- ----------------------------------------------------
INSERT INTO RecetaDetalle (id, id_receta, id_insumo, id_unidad_medida, cantidad, estado) VALUES
                                                                                             (1, 1, 2, 1, 200.00, 'Activo'), (2, 1, 47, 1, 150.00, 'Activo'), (3, 1, 15, 5, 2.00, 'Activo'),
                                                                                             (4, 2, 3, 7, 1.00, 'Activo'), (5, 2, 5, 8, 1.00, 'Activo'), (6, 2, 6, 8, 2.00, 'Activo'), (7, 2, 7, 8, 0.50, 'Activo'),
                                                                                             (8, 3, 4, 7, 1.00, 'Activo'), (9, 3, 14, 8, 1.00, 'Activo'), (10, 3, 36, 8, 0.50, 'Activo'), (11, 3, 28, 6, 1.00, 'Activo'),
                                                                                             (12, 4, 18, 1, 400.00, 'Activo'), (13, 4, 8, 8, 1.00, 'Activo'), (14, 4, 9, 8, 2.00, 'Activo'), (15, 4, 39, 6, 1.00, 'Activo'),
                                                                                             (16, 5, 1, 1, 300.00, 'Activo'), (17, 5, 25, 1, 50.00, 'Activo'), (18, 5, 4, 1, 100.00, 'Activo'),
                                                                                             (19, 6, 13, 7, 1.00, 'Activo'), (20, 6, 24, 8, 1.00, 'Activo'), (21, 6, 10, 7, 0.50, 'Activo'),
                                                                                             (22, 7, 29, 7, 1.00, 'Activo'), (23, 7, 8, 8, 1.00, 'Activo'), (24, 7, 12, 8, 2.00, 'Activo'),
                                                                                             (25, 8, 13, 7, 1.00, 'Activo'), (26, 8, 57, 7, 0.50, 'Activo'), (27, 8, 23, 5, 0.25, 'Activo'),
                                                                                             (28, 9, 14, 8, 1.00, 'Activo'), (29, 9, 44, 7, 1.00, 'Activo'), (30, 9, 10, 7, 0.50, 'Activo'),
                                                                                             (31, 10, 60, 1, 300.00, 'Activo'), (32, 10, 19, 7, 1.00, 'Activo'), (33, 10, 37, 5, 2.00, 'Activo'),
                                                                                             (34, 11, 11, 1, 150.00, 'Activo'), (35, 11, 12, 1, 150.00, 'Activo'), (36, 11, 13, 7, 1.00, 'Activo'),
                                                                                             (37, 12, 35, 7, 1.00, 'Activo'), (38, 12, 22, 1, 200.00, 'Activo'), (39, 12, 8, 8, 0.50, 'Activo'),
                                                                                             (40, 13, 11, 8, 1.00, 'Activo'), (41, 13, 6, 8, 1.00, 'Activo'), (42, 13, 25, 1, 50.00, 'Activo'),
                                                                                             (43, 14, 7, 8, 1.00, 'Activo'), (44, 14, 19, 7, 0.50, 'Activo'), (45, 14, 9, 8, 0.25, 'Activo'),
                                                                                             (46, 15, 1, 1, 200.00, 'Activo'), (47, 15, 26, 8, 4.00, 'Activo'), (48, 15, 12, 1, 50.00, 'Activo'),
                                                                                             (49, 16, 13, 7, 0.50, 'Activo'), (50, 16, 45, 7, 0.25, 'Activo'), (51, 16, 43, 1, 50.00, 'Activo'),
                                                                                             (52, 17, 56, 1, 100.00, 'Activo'), (53, 17, 13, 1, 50.00, 'Activo'), (54, 17, 58, 1, 25.00, 'Activo'),
                                                                                             (55, 18, 11, 8, 1.00, 'Activo'), (56, 18, 42, 5, 2.00, 'Activo'), (57, 18, 6, 8, 1.00, 'Activo'),
                                                                                             (58, 19, 29, 7, 1.00, 'Activo'), (59, 19, 8, 8, 1.00, 'Activo'), (60, 19, 21, 8, 0.50, 'Activo'),
                                                                                             (61, 20, 1, 1, 250.00, 'Activo'), (62, 20, 20, 1, 150.00, 'Activo'), (63, 20, 38, 7, 0.50, 'Activo'),
                                                                                             (64, 21, 5, 8, 1.00, 'Activo'), (65, 21, 24, 8, 1.00, 'Activo'), (66, 21, 41, 8, 1.00, 'Activo'),
                                                                                             (67, 22, 2, 8, 0.75, 'Activo'), (68, 22, 12, 8, 1.00, 'Activo'), (69, 22, 8, 8, 0.50, 'Activo'),
                                                                                             (70, 23, 6, 8, 2.00, 'Activo'), (71, 23, 25, 1, 100.00, 'Activo'), (72, 23, 42, 5, 1.00, 'Activo'),
                                                                                             (73, 24, 60, 1, 200.00, 'Activo'), (74, 24, 27, 8, 1.00, 'Activo'), (75, 24, 49, 5, 1.00, 'Activo'),
                                                                                             (76, 25, 24, 8, 3.00, 'Activo'), (77, 25, 22, 1, 100.00, 'Activo'), (78, 25, 15, 6, 1.00, 'Activo'),
                                                                                             (79, 26, 6, 8, 2.00, 'Activo'), (80, 26, 7, 8, 1.00, 'Activo'), (81, 26, 51, 1, 50.00, 'Activo'),
                                                                                             (82, 27, 1, 1, 200.00, 'Activo'), (83, 27, 21, 8, 1.00, 'Activo'), (84, 27, 8, 8, 0.50, 'Activo'),
                                                                                             (85, 28, 6, 8, 3.00, 'Activo'), (86, 28, 7, 8, 1.00, 'Activo'), (87, 28, 8, 8, 0.50, 'Activo'),
                                                                                             (88, 29, 19, 7, 0.50, 'Activo'), (89, 29, 43, 1, 100.00, 'Activo'), (90, 29, 45, 1, 50.00, 'Activo');

-- ----------------------------------------------------
-- ValorNutricional
-- Cantidad: moderado (~60 registros)
-- Datos: Valores nutricionales variados y realistas.
-- ----------------------------------------------------
INSERT INTO ValorNutricional (id, id_insumo, id_unidad_medida, cantidad, calorias, proteinas, grasas, carbohidratos) VALUES
                                                                                                                         (1, 1, 1, 100.00, 165.00, 31.00, 3.60, 0.00), -- Pollo
                                                                                                                         (2, 2, 1, 100.00, 208.00, 20.00, 13.00, 0.00), -- Salmón
                                                                                                                         (3, 3, 1, 100.00, 120.00, 4.40, 1.90, 21.30), -- Quinoa
                                                                                                                         (4, 4, 1, 100.00, 23.00, 2.90, 0.40, 3.60), -- Espinacas
                                                                                                                         (5, 5, 8, 1.00, 160.00, 2.00, 14.70, 8.50), -- Aguacate (por unidad)
                                                                                                                         (6, 6, 1, 100.00, 18.00, 0.90, 0.20, 3.90), -- Tomate
                                                                                                                         (7, 7, 1, 100.00, 15.00, 0.70, 0.10, 3.60), -- Pepino
                                                                                                                         (8, 8, 1, 100.00, 40.00, 1.10, 0.10, 9.30), -- Cebolla
                                                                                                                         (9, 9, 1, 100.00, 149.00, 6.40, 0.50, 33.10), -- Ajo
                                                                                                                         (10, 10, 3, 100.00, 13.00, 0.50, 1.10, 0.00), -- Leche de Almendras
                                                                                                                         (11, 11, 1, 100.00, 17.00, 1.20, 0.30, 3.60), -- Calabacín
                                                                                                                         (12, 12, 1, 100.00, 41.00, 0.90, 0.20, 9.60), -- Zanahoria
                                                                                                                         (13, 13, 1, 100.00, 389.00, 16.90, 6.90, 66.30), -- Avena
                                                                                                                         (14, 14, 8, 1.00, 105.00, 1.30, 0.40, 27.00), -- Plátano (por unidad)
                                                                                                                         (15, 15, 3, 100.00, 884.00, 0.00, 100.00, 0.00), -- Aceite de Oliva
                                                                                                                         (16, 18, 1, 100.00, 164.00, 8.90, 2.60, 27.40), -- Garbanzos
                                                                                                                         (17, 19, 1, 100.00, 59.00, 10.00, 0.40, 3.60), -- Yogur Griego
                                                                                                                         (18, 20, 1, 100.00, 34.00, 2.80, 0.40, 6.60), -- Brócoli
                                                                                                                         (19, 21, 1, 100.00, 31.00, 0.90, 0.30, 6.00), -- Pimiento Rojo
                                                                                                                         (20, 22, 1, 100.00, 22.00, 3.10, 0.30, 3.30), -- Champiñones
                                                                                                                         (21, 23, 1, 100.00, 304.00, 0.30, 0.00, 82.40), -- Miel
                                                                                                                         (22, 24, 8, 1.00, 78.00, 6.30, 5.30, 0.60), -- Huevo (por unidad)
                                                                                                                         (23, 25, 1, 100.00, 280.00, 28.00, 17.00, 2.20), -- Queso Mozzarella
                                                                                                                         (24, 26, 1, 100.00, 15.00, 1.20, 0.20, 2.90), -- Lechuga
                                                                                                                         (25, 27, 8, 1.00, 29.00, 1.10, 0.30, 9.00), -- Limón (por unidad)
                                                                                                                         (26, 28, 1, 100.00, 80.00, 1.80, 0.80, 17.70), -- Jengibre
                                                                                                                         (27, 29, 1, 100.00, 116.00, 9.00, 0.40, 20.10), -- Lentejas
                                                                                                                         (28, 30, 3, 100.00, 890.00, 0.00, 100.00, 0.00), -- Aceite de Coco
                                                                                                                         (29, 31, 1, 100.00, 377.00, 0.00, 0.00, 97.40), -- Azúcar Morena
                                                                                                                         (30, 35, 1, 100.00, 111.00, 2.60, 0.90, 23.00), -- Arroz Integral
                                                                                                                         (31, 36, 8, 1.00, 95.00, 0.50, 0.30, 25.00), -- Manzana Verde (por unidad)
                                                                                                                         (32, 43, 1, 100.00, 32.00, 0.70, 0.30, 7.70), -- Fresas
                                                                                                                         (33, 44, 1, 100.00, 57.00, 0.70, 0.30, 14.50), -- Arándanos
                                                                                                                         (34, 45, 1, 100.00, 471.00, 11.00, 20.00, 64.00), -- Granola
                                                                                                                         (35, 46, 1, 100.00, 145.00, 16.00, 8.00, 3.00), -- Tofu
                                                                                                                         (36, 47, 1, 100.00, 20.00, 2.20, 0.20, 3.70), -- Espárragos
                                                                                                                         (37, 51, 1, 100.00, 264.00, 14.00, 21.00, 4.10), -- Queso Feta
                                                                                                                         (38, 52, 1, 100.00, 115.00, 0.80, 10.70, 6.30), -- Aceitunas Kalamata
                                                                                                                         (39, 56, 1, 100.00, 282.00, 2.50, 0.40, 75.00), -- Dátiles
                                                                                                                         (40, 57, 1, 100.00, 588.00, 24.00, 50.00, 20.00), -- Mantequilla de Cacahuete
                                                                                                                         (41, 58, 1, 100.00, 660.00, 7.00, 64.00, 24.00), -- Coco Rallado
                                                                                                                         (42, 59, 1, 100.00, 486.00, 17.00, 31.00, 42.00), -- Semillas de Chía
                                                                                                                         (43, 60, 1, 100.00, 89.00, 19.00, 1.40, 0.00); -- Pescado Blanco

SET FOREIGN_KEY_CHECKS = 1;