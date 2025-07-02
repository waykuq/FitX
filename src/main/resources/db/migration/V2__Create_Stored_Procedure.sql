-- ------------------------------------------------
-- Store Procedures

DROP PROCEDURE IF EXISTS sp_obtener_valor_nutricional_receta;

DELIMITER $$

CREATE PROCEDURE sp_obtener_valor_nutricional_receta(IN id_receta INT)
BEGIN
    SELECT
        R.id AS receta_id,
        (SUM(COALESCE(VN.calorias, 0) * UM.factor_conversion) * R.peso_porcion) / (100 * COUNT(RD.id_insumo)) AS calorias,
        (SUM(COALESCE(VN.proteinas, 0) * UM.factor_conversion) * R.peso_porcion) / (100 * COUNT(RD.id_insumo)) AS proteinas,
        (SUM(COALESCE(VN.grasas, 0) * UM.factor_conversion) * R.peso_porcion) / (100 * COUNT(RD.id_insumo)) AS grasas,
        (SUM(COALESCE(VN.carbohidratos, 0) * UM.factor_conversion) * R.peso_porcion) / (100 * COUNT(RD.id_insumo)) AS carbohidratos,
        CASE
            WHEN COUNT(VN.id) = COUNT(RD.id_insumo) THEN 1
            ELSE 0
            END AS valor_nutricional_completo
    FROM Receta R
             JOIN RecetaDetalle RD ON R.id = RD.id_receta
             JOIN Insumo I ON I.id = RD.id_insumo
             LEFT JOIN ValorNutricional VN ON I.id = VN.id
             JOIN UnidadMedida UM ON UM.id = VN.id_unidad_medida
    WHERE R.id = id_receta
    GROUP BY R.id
    ORDER BY R.id;
END$$

DELIMITER ;