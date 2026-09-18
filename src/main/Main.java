package main;

import dao.jugadorDAO;
import daoimpl.Jugadordaoimpl;
import model.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== INICIANDO PRUEBA DE INSTANCIACIÓN Y DAO ===");

        jugadorDAO jugadorDAO = new jugadordaoimpl();

        try {
            Jugador arqueroNuevo = new Arquero(null, "Emiliano Martínez", 1, true);
            Jugador delanteroNuevo = new Delantero(null, "Lionel Messi", 1, false);

            System.out.println("\n--- [PASO 1] Insertando jugadores en MySQL ---");
            jugadorDAO.insertar(arqueroNuevo);
            System.out.println("Guardado con exito: " + arqueroNuevo.getNombre() + " | ID asignado: " + arqueroNuevo.getId());

            jugadorDAO.insertar(delanteroNuevo);
            System.out.println("Guardado con exito: " + delanteroNuevo.getNombre() + " | ID asignado: " + delanteroNuevo.getId());

            System.out.println("\n--- [PASO 2] Buscando jugador por ID desde la BDD ---");
            Jugador jugadorRecuperado = jugadorDAO.buscarPorId(delanteroNuevo.getId());
            if (jugadorRecuperado != null) {
                System.out.println("Recuperado de BDD: " + jugadorRecuperado.getNombre());
                System.out.println("Tipo de clase real devuelta: " + jugadorRecuperado.getClass().getSimpleName());
                System.out.println("Es ubicacion 'ST' valida?: " + jugadorRecuperado.esUbicacionValida("ST"));
            }

            System.out.println("\n--- [PASO 3] Listando todos los jugadores en la BDD ---");
            List<Jugador> jugadores = jugadorDAO.listarTodos();
            for (Jugador j : jugadores) {
                System.out.println("-> ID: " + j.getId() + " | Nombre: " + j.getNombre() + " | Clase: " + j.getClass().getSimpleName());
            }

            System.out.println("\n=== PRUEBA FINALIZADA CON ÉXITO SIN ERRORES ===");

        } catch (Exception e) {
            System.err.println("Error durante la ejecución del DAO: " + e.getMessage());
            e.printStackTrace();
        }
    }
}