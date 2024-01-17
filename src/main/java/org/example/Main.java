package org.example;

import net.sf.jasperreports.engine.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            // Cargar el controlador JDBC y establecer la conexión con la base de datos
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/republica_casa", "root", "password");

            // Compilar informe principal
            JasperReport jasperReport = JasperCompileManager.compileReport("src/main/resources/Blank_A4_2.jrxml");

            // Obtener datos de la base de datos para los subreportes
            List<CentroData> centroDataList = obtenerDatosCentros(connection);
            List<MedicosData> medicosDataList = obtenerDatosMedicos(connection);
            List<UrgenciasData> urgenciasDataList = obtenerDatosUrgencias(connection);

            // Crear parámetros
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("CentroDataList", centroDataList);
            parameters.put("MedicosDataList", medicosDataList);
            parameters.put("UrgenciasDataList", urgenciasDataList);

            // Rellenar informe con datos y parámetros
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);

            // Puedes exportar el informe si lo necesitas
            JasperExportManager.exportReportToPdfFile(jasperPrint, "InformePrincipal.pdf");

            System.out.println("Informe compilado y generado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Métodos de obtención de datos
    private static List<CentroData> obtenerDatosCentros(Connection connection) throws JRException, SQLException {
        List<CentroData> centros = new ArrayList<>();
        String query = "SELECT * FROM centros";
        try (ResultSet resultSet = connection.createStatement().executeQuery(query)) {
            while (resultSet.next()) {
                CentroData centro = new CentroData(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("provincia"),
                        resultSet.getString("municipio"),
                        resultSet.getString("localidad"),
                        resultSet.getString("cp"),
                        resultSet.getString("calle")
                );
                centros.add(centro);
            }
        }
        return centros;
    }

    private static List<MedicosData> obtenerDatosMedicos(Connection connection) throws JRException, SQLException {
        List<MedicosData> medicos = new ArrayList<>();
        String query = "SELECT * FROM medicos";
        try (ResultSet resultSet = connection.createStatement().executeQuery(query)) {
            while (resultSet.next()) {
                MedicosData medico = new MedicosData(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("especialidad"),
                        resultSet.getInt("centro_id")
                );
                medicos.add(medico);
            }
        }
        return medicos;
    }

    private static List<UrgenciasData> obtenerDatosUrgencias(Connection connection) throws JRException, SQLException {
        List<UrgenciasData> urgencias = new ArrayList<>();
        String query = "SELECT * FROM urgencias";
        try (ResultSet resultSet = connection.createStatement().executeQuery(query)) {
            while (resultSet.next()) {
                UrgenciasData urgencia = new UrgenciasData(
                        resultSet.getInt("id"),
                        resultSet.getString("razon"),
                        resultSet.getInt("cantidad"),
                        resultSet.getInt("centro_id")
                );
                urgencias.add(urgencia);
            }
        }
        return urgencias;
    }
}
