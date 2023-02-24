import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.DecimalFormat;

public class CalculadoraPrestamos {
    public static void main(String[] args) {
        // Crea un objeto Scanner para leer las entradas del usuario
        Scanner input = new Scanner(System.in);
        try {
            // Leer el tipo de cliente
            System.out.println("Bienvenido(a) a la calculadora de préstamos, por favor leer las siguientes instrucciones.\n");
            System.out.println("Tipos de clientes:\n");
            System.out.println("Tipo A1, A2: Crédito otorgado con un descuento del 2%.");
            System.out.println("Tipo B: Crédito ordinario basado en cuotas establecidas.");
            System.out.println("Tipo C: Crédito denegado.\n");
            System.out.print("Ingrese el tipo de cliente (A1, A2, B, C): ");
            String tipoCliente = input.next().toUpperCase();

            double descuento = 0;
            if (tipoCliente.equals("A1") || tipoCliente.equals("A2")) {
                descuento = 0.02;
            } else if (tipoCliente.equals("C")) {
                System.out.println("Crédito denegado.");
                return;
            }

            // Leer el monto del préstamo
            System.out.print("Ingrese el monto del préstamo: ");
            double MontoPrestamo = input.nextDouble();

            // Lee la tasa de interés
            System.out.print("Ingrese la tasa de interés: ");
            float TasaInteres = input.nextFloat();

            // Leer el número de años
            System.out.print("Introduzca el número de años: ");
            int CantidadAnios = input.nextInt();

            // Calcular el pago mensual
            // La fórmula es la siguiente:
            // PagoMensual = (MontoPrestamo - MontoPrestamo * descuento) * TasaInteres / (1 - 1 / Math.pow(1 + TasaInteres, CantidadAnios * 12));
            double PagoMensual = (MontoPrestamo - MontoPrestamo * descuento) * (TasaInteres/12) / (1 - 1 / Math.pow(1 + TasaInteres, CantidadAnios * 12));

            // Calcular el pago total
            // La fórmula es la siguiente:
            // PagoTotal = PagoMensual * CantidadAnios * 12;
            double PagoTotal = PagoMensual * CantidadAnios * 12;

            // Calcular el monto del descuento
            double MontoDescuento = MontoPrestamo * descuento;

            // Crear un objeto DecimalFormat
            DecimalFormat decimalFormat = new DecimalFormat("###,###.##");

            // Salida del pago mensual
            System.out.println("Mensualidad: ₡" + decimalFormat.format(PagoMensual));

            // Salida del pago total
            System.out.println("Pago total: ₡" + decimalFormat.format(PagoTotal));

            // Salida del monto del descuento si corresponde
            if (descuento > 0) {
                System.out.println("Monto del descuento: ₡" + decimalFormat.format(MontoDescuento));
            }

         } catch (InputMismatchException e) {
            // Manejar la excepción InputMismatchException
            // Si el usuario ingresa una entrada que no es un número, se lanzará esta excepción
            System.out.println("Entrada inválida. Por favor, solamente inserte números.");
        } catch (Exception e) {
            // Manejar cualquier otra excepción que pueda generarse
            System.out.println("Se ha producido un error. Inténtalo de nuevo.");
        } finally {
            // Cerramos el objeto Scanner para evitar fugas de recursos
            input.close();
        }
    }
}