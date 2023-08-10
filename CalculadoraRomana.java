import java.util.Scanner;

public class CalculadoraRomana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número romano: ");
        String numeroRomano = scanner.nextLine();

        try {
            int numeroEntero = convertirRomanoANumeroEntero(numeroRomano);
            System.out.println("El número entero equivalente es: " + numeroEntero);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }

    public static int convertirRomanoANumeroEntero(String numeroRomano) {
        int resultado = 0;
        int prevValor = 0;
        int repeticiones = 1;
        boolean permitidoRepetir = true;

        for (int i = numeroRomano.length() - 1; i >= 0; i--) {
            char caracter = numeroRomano.charAt(i);
            int valor = obtenerValorCaracterRomano(caracter);

            if (valor < prevValor) {
                if (repeticiones > 1 || !permitidoRepetir) {
                    throw new IllegalArgumentException("Número romano inválido: " + numeroRomano);
                }
                resultado -= valor;
                repeticiones = 1;
            } else {
                if (valor == prevValor) {
                    repeticiones++;
                    if ((valor == 1 || valor == 10 || valor == 100 || valor == 1000) && repeticiones > 3) {
                        throw new IllegalArgumentException("Número romano inválido: " + numeroRomano);
                    } else if ((valor == 5 || valor == 50 || valor == 500) && repeticiones > 1) {
                        throw new IllegalArgumentException("Número romano inválido: " + numeroRomano);
                    }
                    if (valor == 5 || valor == 50 || valor == 500) {
                        permitidoRepetir = false;
                    }
                } else {
                    repeticiones = 1;
                    permitidoRepetir = true;
                }
                resultado += valor;
            }

            prevValor = valor;
        }

        return resultado;
    }

    public static int obtenerValorCaracterRomano(char caracter) {
        switch (caracter) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new IllegalArgumentException("Caracter romano inválido: " + caracter);
        }
    }
}
