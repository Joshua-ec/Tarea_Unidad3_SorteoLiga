package Principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Modelo.Equipo;
import Logica.Sorteador;
import Excepciones.EtapaInvalidaException;

public class MainSorteo {
    public static void main(String[] args) {
        // Uso de try-with-resources para cerrar el Scanner automaticamente
        try (Scanner sn = new Scanner(System.in)) {
            Sorteador sorteador = new Sorteador();
            List<Equipo> listaEquipos = new ArrayList<>();

            System.out.println("--- GESTOR DE TORNEOS UPS ---");
            System.out.print("Ingrese la etapa (octavos, cuartos, semifinales): ");
            String etapa = sn.nextLine().toLowerCase();

            // Validacion con nuestra excepcion propia
            int cantidad = obtenerCantidadEquipos(etapa);

            System.out.println("Cargando sorteo para " + cantidad + " equipos...");
            for (int i = 0; i < cantidad; i++) {
                System.out.print("Nombre equipo " + (i + 1) + ": ");
                listaEquipos.add(new Equipo(sn.nextLine()));
            }

            System.out.println("\n--- ENFRENTAMIENTOS ALEATORIOS ---");
            sorteador.sortearEtapa(listaEquipos);

        } catch (EtapaInvalidaException e) {
            System.err.println("Error de validacion: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ocurrio un error inesperado.");
        }
    }

    // Metodo auxiliar para validar la etapa
    private static int obtenerCantidadEquipos(String etapa) throws EtapaInvalidaException {
        return switch (etapa) {
            case "octavos" -> 16;
            case "cuartos" -> 8;
            case "semifinales" -> 4;
            default -> throw new EtapaInvalidaException("La etapa '" + etapa + "' no es valida para este torneo.");
        };
    }
}