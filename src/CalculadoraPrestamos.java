import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraPrestamos {
    public static void main(String[] args) {
        // Crea un objeto Scanner para leer las entradas del usuario
                Scanner input = new Scanner(System.in);
        try {
            // Leer el monto del préstamo
            System.out.print("Ingrese el monto del préstamo: ");
            long MontoPrestamo = input.nextLong();

            // Lee la tasa de interés
            System.out.print("Ingrese la tasa de interés: ");
            double TasaInteres = input.nextDouble();

            // Leer el número de años
            System.out.print("Introduzca el número de años: ");
            int CantidadAnios = input.nextInt();

            // Calcular el pago mensual
            // La fórmula es la siguiente:
            // PagoMensual = MontoPrestamo * TasaInteres / (1 - 1 / Math.pow(1 + TasaInteres, CantidadAnios * 12));
            double PagoMensual = MontoPrestamo * TasaInteres / (1 - 1 / Math.pow(1 + TasaInteres, CantidadAnios * 12));

            // Calcular el pago total
            // La fórmula es la siguiente:
            // PagoTotal = PagoMensual * CantidadAnios * 12;
            double PagoTotal = PagoMensual * CantidadAnios * 12;

            // Salida del pago mensual
            System.out.println("Mensualidad: " + PagoMensual);

            // Salida del pago total
            System.out.println("Pago total: " + PagoTotal);
        } catch (InputMismatchException e) {
            // Manejar la excepción InputMismatchException
            // Si el usuario ingresa una entrada que no es un número, se lanzará esta excepción
            System.out.println("Entrada inválida. Por favor, solamente inserte números.");
        } catch (Exception e) {
            // Manejar cualquier otra excepción que pueda generarse
            System.out.println("Se ha producido un error. Inténtalo de nuevo.");
        } finally {
            // Cierre el objeto Scanner para evitar fugas de recursos
            input.close();
        }
    }
}