package dao;

import database.DBconnection;
import model.Rutina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RutinaDAO {

    public ArrayList<Rutina> listarRutinas() {

        ArrayList<Rutina> rutinas = new ArrayList<>();

        String sql = "SELECT * FROM rutina";

        try {
            Connection connection = DBconnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Rutina rutina = new Rutina(
                        resultSet.getInt("id_rutina"),
                        resultSet.getString("nombre"),
                        resultSet.getString("objetivo"),
                        resultSet.getDate("fecha_creacion").toLocalDate()
                );

                rutinas.add(rutina);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar rutinas");
            System.out.println(e.getMessage());
        }

        return rutinas;
    }

    public void mostrarEjerciciosDeRutina(int idRutina) {

        String sql = """
            SELECT r.nombre AS rutina,
                   e.nombre AS ejercicio,
                   e.grupo_muscular,
                   re.series,
                   re.repeticiones,
                   re.orden
            FROM rutina r
            JOIN rutina_ejercicio re ON r.id_rutina = re.id_rutina
            JOIN ejercicio e ON re.id_ejercicio = e.id_ejercicio
            WHERE r.id_rutina = ?
            ORDER BY re.orden
            """;

        try {
            Connection connection = DBconnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, idRutina);

            ResultSet resultSet = preparedStatement.executeQuery();

            boolean hayResultados = false;

            while (resultSet.next()) {

                if (!hayResultados) {
                    System.out.println("\nRutina: " + resultSet.getString("rutina"));
                    System.out.println("--- Ejercicios ---");
                    hayResultados = true;
                }

                System.out.println(
                        resultSet.getInt("orden") + ". " +
                                resultSet.getString("ejercicio") +
                                " | " + resultSet.getString("grupo_muscular") +
                                " | " + resultSet.getInt("series") +
                                "x" + resultSet.getInt("repeticiones")
                );
            }

            if (!hayResultados) {
                System.out.println("No se ha encontrado ninguna rutina con ese id o no tiene ejercicios.");
            }

        } catch (SQLException e) {
            System.out.println("Error al mostrar ejercicios de la rutina");
            System.out.println(e.getMessage());
        }
    }

    
}
