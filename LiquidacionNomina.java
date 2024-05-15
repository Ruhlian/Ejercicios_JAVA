import java.util.Scanner;

public class LiquidacionNomina {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nIngrese los datos del empleado:");
        System.out.print("Nombres: ");
        String nombres = scanner.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine();
        System.out.print("Documento: ");
        String documento = scanner.nextLine();
        System.out.print("Días trabajados: ");
        int diasTrabajados = scanner.nextInt();
        scanner.nextLine(); 

        double salarioBasico = 1300000; 
        double subsidioTransporte = 164000; 
        double salarioDevengado = calcularSalarioDevengado(salarioBasico, diasTrabajados, subsidioTransporte);
        double totalBruto = salarioDevengado + subsidioTransporte;

        double descuentos = calcularDescuentos(salarioDevengado);
        double vlrNetoPagar = totalBruto - descuentos;

        System.out.println("\nLiquidación de nómina para: " + nombres + " " + apellidos);
        System.out.println("Documento: " + documento);
        System.out.println("Total bruto: $" + totalBruto);
        System.out.println("Descuentos: $" + descuentos);
        System.out.println("Valor neto a pagar: $" + vlrNetoPagar);
        scanner.close();
    }

    public static double calcularSalarioDevengado(double salarioBasico, int diasTrabajados, double subsidioTransporte) {
        return salarioBasico * (diasTrabajados / 26.0) + subsidioTransporte;
    }

    public static double calcularDescuentos(double salarioDevengado) {
        double salud = salarioDevengado * 0.04;
        double pension = salarioDevengado * 0.04; 
        return salud + pension;
    }
}
