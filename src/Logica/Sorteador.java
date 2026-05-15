package Logica;

import Modelo.Equipo;
import Modelo.Partido;
import java.util.Collections;
import java.util.List;

public class Sorteador {

    public void sortearEtapa(List<Equipo> equipos) {
        Collections.shuffle(equipos); // Sorteo aleatorio inicial [cite: 30]
        ejecutarSorteoRecursivo(equipos);
    }

    private void ejecutarSorteoRecursivo(List<Equipo> lista) {
        // Caso Base: El sorteo termina cuando quedan menos de 2 equipos [cite: 33]
        if (lista.size() < 2) {
            return;
        }

        // Subproblema: Sacar una pareja y procesarla
        Equipo e1 = lista.remove(0);
        Equipo e2 = lista.remove(0);

        Partido partido = new Partido(e1, e2);
        System.out.println(partido);

        // Llamada Recursiva 
        ejecutarSorteoRecursivo(lista);
    }
}