package main;

import database.DBconnection;
import model.Ejercicio;
import model.Rutina;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DBconnection.getConnection();
        Scanner sc = new Scanner(System.in);
        int opcion;


        do {
            System.out.println("\n===== GYMRAT =====");
            System.out.println("1. Ver ejercicios");
            System.out.println("2. Buscar ejercicios por músculo");
            System.out.println("3. Ver rutinas");
            System.out.println("4. Crear rutina");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.println("Mostrando ejercicios...");
                    break;

                case 2:
                    System.out.println("Buscar por músculo...");
                    break;

                case 3:
                    System.out.println("Mostrando rutinas...");
                    break;

                case 4:
                    System.out.println("Crear rutina...");
                    break;

                case 5:
                    System.out.println("Saliendo de GymRat...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);

        sc.close();
    }
}

