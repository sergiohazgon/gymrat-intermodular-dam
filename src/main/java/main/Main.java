package main;

import dao.RutinaDAO;
import database.DBconnection;
import dao.EjercicioDAO;
import model.Ejercicio;
import model.Rutina;


import java.util.ArrayList;
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
            System.out.println("8. Eliminar rutina");
            System.out.println("9. Salir");
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
                    ArrayList<Rutina> rutinas = rutinaDAO.listarRutinas();

                    System.out.println("--- Rutinas disponibles ---");

                    for (int i = 0; i < rutinas.size(); i++) {
                        System.out.println((i + 1) + ". " + rutinas.get(i).getNombre());
                    }

                    System.out.print("Elige una rutina: ");
                    opcion = sc.nextInt();
                    sc.nextLine();

                    if (opcion < 1 || opcion > rutinas.size()) {
                        System.out.println("Opción inválida");
                        break;
                    }

                    int idRutina = rutinas.get(opcion - 1).getIdRutina();

                    rutinaDAO.mostrarEjerciciosDeRutina(idRutina);

                    break;

                case 5:

                    ArrayList<Rutina> rutinasInsertar = rutinaDAO.listarRutinas();

                    System.out.println("\n--- Rutinas disponibles ---");

                    for (int i = 0; i < rutinasInsertar.size(); i++) {
                        System.out.println((i + 1) + ". " + rutinasInsertar.get(i).getNombre());
                    }

                    System.out.print("Elige una rutina: ");
                    opcion = sc.nextInt();
                    sc.nextLine();

                    if (opcion < 1 || opcion > rutinasInsertar.size()) {
                        System.out.println("Opción inválida");
                        break;
                    }

                    int idRutinaInsertar = rutinasInsertar.get(opcion - 1).getIdRutina();

                    String continuar;

                    do {
                        System.out.println("\n--- Ejercicios disponibles ---");

                        ArrayList<Ejercicio> ejercicios = ejercicioDAO.listarEjercicios();

                        for (Ejercicio ejercicio : ejercicios) {
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
                        do {
                            System.out.print("¿Quieres añadir otro ejercicio a esta rutina? (si/no): ");
                            continuar = sc.nextLine().toLowerCase();

                            if (!continuar.equals("si") && !continuar.equals("no")) {
                                System.out.println("Introduce 'si' o 'no'");
                            }

                        } while (!continuar.equals("si") && !continuar.equals("no"));

                    } while (continuar.equals("si"));
                    break;

                case 6:

                    ArrayList<Rutina> rutinasEliminarEjercicio = rutinaDAO.listarRutinas();

                    System.out.println("\n--- Rutinas disponibles ---");

                    for (int i = 0; i < rutinasEliminarEjercicio.size(); i++) {
                        System.out.println((i + 1) + ". " + rutinasEliminarEjercicio.get(i).getNombre());
                    }

                    System.out.print("Elige una rutina: ");
                    opcion = sc.nextInt();
                    sc.nextLine();

                    if (opcion < 1 || opcion > rutinasEliminarEjercicio.size()) {
                        System.out.println("Opción inválida");
                        break;
                    }

                    int idRutinaEliminar = rutinasEliminarEjercicio.get(opcion - 1).getIdRutina();

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

                    ArrayList<Rutina> rutinasEliminar = rutinaDAO.listarRutinas();

                    System.out.println("\n--- Rutinas disponibles ---");

                    for (int i = 0; i < rutinasEliminar.size(); i++) {
                        System.out.println((i + 1) + ". " + rutinasEliminar.get(i).getNombre());
                    }

                    System.out.print("Elige una rutina a eliminar: ");
                    opcion = sc.nextInt();
                    sc.nextLine();

                    if (opcion < 1 || opcion > rutinasEliminar.size()) {
                        System.out.println("Opción inválida");
                        break;
                    }

                    idRutinaEliminar = rutinasEliminar.get(opcion - 1).getIdRutina();

                    rutinaDAO.eliminarRutina(idRutinaEliminar);

                    break;

                case 9:
                    System.out.println("Saliendo de GymRat...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 9);

        sc.close();
    }
}

