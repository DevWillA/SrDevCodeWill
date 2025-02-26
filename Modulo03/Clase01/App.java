public package Modulo03.Clase01;

class App {

    public static void main(String[] args) throws Exception {
        var array = new int[5];
        var num = 5;

        try {
            array[num] = 10;
            System.out.println(array[num]);

            var denominador = 0;
            array[0] /= denominador;

            System.out.println(array[num]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
        catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


        
    }
}