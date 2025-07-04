# 🥗 FITX

**FITX** es una aplicación diseñada para fomentar una alimentación equilibrada, gestionando los valores nutricionales según las metas personales de cada usuario.

---

## ✨ Características

- 📋 Gestión de contenidos:
    - Menús
    - Recetas
    - Insumos (ingredientes)
    - Etiquetas (clasificación de recetas)
    - Tipos de insumo
    - Unidades de medida

- 🧮 Cálculo nutricional:
    - Requerimientos personalizados según:
        - Edad
        - Sexo
        - Talla
        - Peso
        - Estilo de vida
    - Valor nutricional de recetas y menús en función al peso de las raciones

- 🧠 Fuente de datos:
    - Base de datos del Centro Nacional de Alimentación y Nutrición (INS Perú)

---

## 🚀 Endpoint

/web/login

---

## ⚙️ Configuración

### Archivo `application.properties`

Actualiza la línea 13 con:

```properties
spring.sql.init.mode=always
```
---
## Usuarios de prueba

| Rol     | Correo            | Contraseña |
|---------|-------------------|------------|
| Usuario | usuario@fitx.com  | usuario    |
| Admin   | admin@fitx.com    | admin      |