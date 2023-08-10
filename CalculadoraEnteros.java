import java.util.Scanner;

public class CalculadoraEnteros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número natural (entre 1 y 3999): ");
        int numeroNatural = scanner.nextInt();

        if (numeroNatural < 1 || numeroNatural > 3999) {
            System.out.println("Número fuera de rango.");
        } else {
            String numeroRomano = convertirNumeroNaturalARomano(numeroNatural);
            System.out.println("El número romano equivalente es: " + numeroRomano);
        }

        scanner.close();
    }

    public static String convertirNumeroNaturalARomano(int numeroNatural) {
        String[] unidadesRomanas = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] decenasRomanas = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] centenasRomanas = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] millaresRomanos = {"", "M", "MM", "MMM"};

        String unidad = unidadesRomanas[numeroNatural % 10];
        numeroNatural /= 10;
        String decena = decenasRomanas[numeroNatural % 10];
        numeroNatural /= 10;
        String centena = centenasRomanas[numeroNatural % 10];
        numeroNatural /= 10;
        String millar = millaresRomanos[numeroNatural % 10];

        return millar + centena + decena + unidad;
    }
}
