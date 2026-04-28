package dao;

import database.DBconnection;
import model.Ejercicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EjercicioDAO {

    public ArrayList<Ejercicio> listarEjercicios() {

        ArrayList<Ejercicio> ejercicios = new ArrayList<>();

        String sql = "SELECT * FROM ejercicio";

        try {
            Connection connection = DBconnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Ejercicio ejercicio = new Ejercicio(
                        resultSet.getInt("id_ejercicio"),
                        resultSet.getString("nombre"),
                        resultSet.getString("grupo_muscular"),
                        resultSet.getString("descripcion"),
                        resultSet.getString("url_video")
                );

                ejercicios.add(ejercicio);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar ejercicios");
            System.out.println(e.getMessage());
        }

        return ejercicios;
    }

    public ArrayList<Ejercicio> buscarPorGrupoMuscular(String grupoMuscular) {

        ArrayList<Ejercicio> ejercicios = new ArrayList<>();

        String sql = "SELECT * FROM ejercicio WHERE grupo_muscular = ?";

        try {
            Connection connection = DBconnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, grupoMuscular);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Ejercicio ejercicio = new Ejercicio(
                        resultSet.getInt("id_ejercicio"),
                        resultSet.getString("nombre"),
                        resultSet.getString("grupo_muscular"),
                        resultSet.getString("descripcion"),
                        resultSet.getString("url_video")
                );

                ejercicios.add(ejercicio);
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar ejercicios");
            System.out.println(e.getMessage());
        }

        return ejercicios;
    }


}
