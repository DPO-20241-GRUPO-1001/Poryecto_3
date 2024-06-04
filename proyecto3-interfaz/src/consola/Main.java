package consola;

public class Main {
    public static void main(String[] args) {
        ConsolaAdministrador consolaAdmin = new ConsolaAdministrador("NombreDeLaClasePasarela", "ruta/al/archivo/datos.txt");
        consolaAdmin.mostrarMenuPrincipal();
    }
}
