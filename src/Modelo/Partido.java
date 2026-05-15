package Modelo;

/**
 * Clase que representa un enfrentamiento entre dos equipos.
 */
public class Partido {
    private Equipo local;
    private Equipo visitante;

    public Partido(Equipo local, Equipo visitante) {
        this.local = local;
        this.visitante = visitante;
    }

    @Override
    public String toString() {
        return "PARTIDO: " + local.getNombre() + " vs " + visitante.getNombre();
    }
}