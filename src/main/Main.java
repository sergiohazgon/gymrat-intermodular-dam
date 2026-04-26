package main;

import dao.RutinaDAO;
import database.DBconnection;
import dao.EjercicioDAO;
import model.Ejercicio;
import model.Rutina;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DBconnection.getConnection();
        EjercicioDAO ejercicioDAO = new EjercicioDAO();
        RutinaDAO rutinaDAO = new RutinaDAO();

        Scanner sc = new Scanner(System.in);
        int opcion;


        do {
            System.out.println("\n===== GYMRAT =====");
            System.out.println("1. Ver ejercicios");
            System.out.println("2. Buscar ejercicios por músculo");
            System.out.println("3. Ver rutinas");
            System.out.println("4. Ver ejercicios de una rutina");
            System.out.println("5. Crear rutina");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.println("\n--- Ejercicios disponibles ---");

                    for (Ejercicio ejercicio : ejercicioDAO.listarEjercicios()) {
                        System.out.println(ejercicio);
                    }
                    break;

                case 2:
                    System.out.print("Introduce grupo muscular: ");
                    String grupo = sc.nextLine();

                    System.out.println("\n--- Resultados ---");

                    for (Ejercicio ejercicio : ejercicioDAO.buscarPorGrupoMuscular(grupo)) {
                        System.out.println(ejercicio);
                    }

                    break;

                case 3:
                    System.out.println("\n--- Rutinas disponibles ---");

                    for (Rutina rutina : rutinaDAO.listarRutinas()) {
                        System.out.println(rutina);
                    }
                    break;

                case 4:
                    System.out.print("Introduce el id de la rutina: ");
                    int idRutina = sc.nextInt();
                    sc.nextLine();

                    rutinaDAO.mostrarEjerciciosDeRutina(idRutina);
                    break;

                case 5:
                    System.out.println("Crear rutina...");
                    break;

                case 6:
                    System.out.println("Saliendo de GymRat...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 6);

        sc.close();
    }
}

