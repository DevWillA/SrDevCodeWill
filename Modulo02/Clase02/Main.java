public class Main {

    public static void main(String[] args) {
        Employee empleado1 = new Employee("Rafa", 11123, 2300000);
        Employee empleado2 = new Employee("Juan", 11124, 1200000);
        Employee empleado3 = new Employee("Juan", 11124, 1200000);
        Manager gerente1 = new Manager("Mary", 11125, 24000000, "DEV");
        System.out.println(empleado1.toString());

        empleado1.increaseSalary(12);

        System.out.println(empleado1.toString());

        empleado1.setSalary(0);

        System.out.println(empleado1.toString());

        System.out.println(empleado1.hashCode());
        System.out.println(empleado2.hashCode());

        System.out.println(empleado1.equals(empleado2));

        System.out.println(gerente1.toString());

        System.out.println(empleado2 == empleado3);

    }


}
