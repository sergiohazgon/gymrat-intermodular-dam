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

    public void insertarEjercicioRutina(int idRutina, int idEjercicio,
                                        int series, int repeticiones, int orden) {

        String sqlActualizarOrdenes = """
            UPDATE rutina_ejercicio
            SET orden = orden + 1
            WHERE id_rutina = ?
            AND orden >= ?
            """;

        String sqlInsertar = """
            INSERT INTO rutina_ejercicio (id_rutina, id_ejercicio, series, repeticiones, orden)
            VALUES (?, ?, ?, ?, ?)
            """;

        try {
            Connection connection = DBconnection.getConnection();

            PreparedStatement preparedStatementActualizar = connection.prepareStatement(sqlActualizarOrdenes);

            preparedStatementActualizar.setInt(1, idRutina);
            preparedStatementActualizar.setInt(2, orden);

            preparedStatementActualizar.executeUpdate();

            PreparedStatement preparedStatementInsertar= connection.prepareStatement(sqlInsertar);

            preparedStatementInsertar.setInt(1, idRutina);
            preparedStatementInsertar.setInt(2, idEjercicio);
            preparedStatementInsertar.setInt(3, series);
            preparedStatementInsertar.setInt(4, repeticiones);
            preparedStatementInsertar.setInt(5, orden);

            preparedStatementInsertar.executeUpdate();

            System.out.println("Ejercicio añadido correctamente a la rutina.");

        } catch (SQLException e) {
            System.out.println("Error al añadir ejercicio a la rutina.");
            System.out.println(e.getMessage());
        }
    }

    public void eliminarEjercicioDeRutinaPorOrden(int idRutina, int orden) {

        String sqlBuscar = """
            SELECT e.nombre
            FROM rutina_ejercicio re
            JOIN ejercicio e ON re.id_ejercicio = e.id_ejercicio
            WHERE re.id_rutina = ?
            AND re.orden = ?
            """;

        String sqlDelete = """
            DELETE FROM rutina_ejercicio
            WHERE id_rutina = ?
            AND orden = ?
            """;

        try {
            Connection connection = DBconnection.getConnection();

            PreparedStatement preparedStatementBuscar = connection.prepareStatement(sqlBuscar);
            preparedStatementBuscar.setInt(1, idRutina);
            preparedStatementBuscar.setInt(2, orden);

            ResultSet resultSet = preparedStatementBuscar.executeQuery();

            if (resultSet.next()) {

                String nombreEjercicio = resultSet.getString("nombre");

                PreparedStatement preparedStatementDelete = connection.prepareStatement(sqlDelete);
                preparedStatementDelete.setInt(1, idRutina);
                preparedStatementDelete.setInt(2, orden);

                preparedStatementDelete.executeUpdate();

                System.out.println("Ejercicio " + nombreEjercicio + " eliminado correctamente.");

                reordenarRutina(idRutina);

            } else {
                System.out.println("No existe ningún ejercicio con ese orden en la rutina.");
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar ejercicio.");
            System.out.println(e.getMessage());
        }
    }

    public void reordenarRutina(int idRutina) {

        String sqlSelect = """
            SELECT id_ejercicio
            FROM rutina_ejercicio
            WHERE id_rutina = ?
            ORDER BY orden
            """;

        String sqlUpdate = """
            UPDATE rutina_ejercicio
            SET orden = ?
            WHERE id_rutina = ?
            AND id_ejercicio = ?
            """;

        try {
            Connection connection = DBconnection.getConnection();

            PreparedStatement preparedStatementSelected = connection.prepareStatement(sqlSelect);
            preparedStatementSelected.setInt(1, idRutina);

            ResultSet rs = preparedStatementSelected.executeQuery();

            int nuevoOrden = 1;

            while (rs.next()) {

                int idEjercicio = rs.getInt("id_ejercicio");

                PreparedStatement preparedStatementUpdate = connection.prepareStatement(sqlUpdate);
                preparedStatementUpdate.setInt(1, nuevoOrden);
                preparedStatementUpdate.setInt(2, idRutina);
                preparedStatementUpdate.setInt(3, idEjercicio);

                preparedStatementUpdate.executeUpdate();

                nuevoOrden++;
            }

        } catch (SQLException e) {
            System.out.println("Error al reordenar la rutina.");
            System.out.println(e.getMessage());
        }
    }
}
