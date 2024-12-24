public class Main{
    public static void main(String[] args) {
        Book libro = new Book();
        Book libro2 = new Book("Cien Años de soledad", "Gabriel Garcia Marquez", 1967, "Narrativa");
        Book libro3 = new Book("Don Quijote de la mancha", "Miguel de Cervantes", 1605, "Novela", false);
        libro.title = "El aro";
        libro3.getBook();
        libro3.returnBook();
        libro3.getBook();

        System.out.println("************************************");
        libro.showInfo();
        System.out.println("************************************");
        libro2.showInfo();
        System.out.println("************************************");
        libro3.showInfo();
        System.out.println("************************************");
    }
}
