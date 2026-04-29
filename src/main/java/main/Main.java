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
            System.out.println("5. Añadir ejercicios a una rutina");
            System.out.println("6. Eliminar ejercicio de una rutina");
            System.out.println("7. Crear rutina");
            System.out.println("8. Salir");
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
                    System.out.println("\n--- Rutinas disponibles ---");
                    for (Rutina rutina : rutinaDAO.listarRutinas()) {
                        System.out.println(rutina);
                    }


                    System.out.print("Introduce el id de la rutina: ");
                    int idRutinaInsertar = sc.nextInt();
                    sc.nextLine();

                    String continuar;

                    do {
                    System.out.println("\n--- Ejercicios disponibles ---");
                    for (Ejercicio ejercicio : ejercicioDAO.listarEjercicios()) {
                        System.out.println(ejercicio);
                    }

                    System.out.print("Introduce el id del ejercicio: ");
                    int idEjercicioAgregar = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Series: ");
                    int series = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Repeticiones: ");
                    int repeticiones = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Orden en la rutina: ");
                    int orden = sc.nextInt();
                    sc.nextLine();

                    rutinaDAO.insertarEjercicioRutina(
                            idRutinaInsertar,
                            idEjercicioAgregar,
                            series,
                            repeticiones,
                            orden
                    );
                    System.out.print("¿Quieres añadir otro ejercicio a esta rutina? (si/no): ");
                    continuar = sc.nextLine().toLowerCase();

            } while (continuar.equalsIgnoreCase("si"));

                    break;

                case 6:
                    System.out.println("\n--- Rutinas disponibles ---");
                    for (Rutina rutina : rutinaDAO.listarRutinas()) {
                        System.out.println(rutina);
                    }

                    System.out.print("Introduce el id de la rutina: ");
                    int idRutinaEliminar = sc.nextInt();
                    sc.nextLine();

                    rutinaDAO.mostrarEjerciciosDeRutina(idRutinaEliminar);

                    System.out.print("Introduce el número de orden del ejercicio que quieres eliminar: ");
                    int ordenEliminar = sc.nextInt();
                    sc.nextLine();

                    rutinaDAO.eliminarEjercicioDeRutinaPorOrden(idRutinaEliminar, ordenEliminar);

                    break;

                case 7:

                    System.out.println("\n--- Crear rutina ---");

                    System.out.print("Nombre de la rutina: ");
                    String nombreRutina = sc.nextLine();

                    System.out.print("Objetivo: ");
                    String objetivoRutina = sc.nextLine();

                    rutinaDAO.crearRutina(nombreRutina, objetivoRutina);

                    break;

                case 8:
                    System.out.println("Saliendo de GymRat...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 8);

        sc.close();
    }
}

