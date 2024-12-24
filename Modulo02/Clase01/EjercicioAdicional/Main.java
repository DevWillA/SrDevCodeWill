//Crea una lista de estudiantes.
//Muestra la información de todos los estudiantes.
//Indica si están aprobados o no.



package EjercicioAdicional;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante1 = new Estudiante("Juan", 20, 3.5);
        Estudiante estudiante2 = new Estudiante("Pedro", 21, 3.0);
        Estudiante estudiante3 = new Estudiante("Maria", 19, 2.5);
        Estudiante estudiante4 = new Estudiante("Luis", 18, 2.0);

        System.out.println("Estudiantes:");
        estudiante1.mostrarDetalles();
        System.out.println("El estudiante aprobo: "+estudiante1.esAprobado());
        estudiante2.mostrarDetalles();
        System.out.println("El estudiante aprobo: "+estudiante2.esAprobado());
        estudiante3.mostrarDetalles();
        System.out.println("El estudiante aprobo: "+estudiante3.esAprobado());
        estudiante4.mostrarDetalles();
        System.out.println("El estudiante aprobo: "+estudiante4.esAprobado());
     
    }

}
