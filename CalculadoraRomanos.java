import java.util.Scanner;

public class CalculadoraRomanos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número romano a convertir: ");
        String numeroRomano = scanner.nextLine();

        try {
            int numeroEntero = convertirRomanoANumeroEntero(numeroRomano);
            System.out.println("Número entero equivalente: " + numeroEntero);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }

    public static int convertirRomanoANumeroEntero(String numeroRomano) {
        int resultado = 0;
        int repeticionesI = 0;
        int repeticionesX = 0;
        int repeticionesC = 0;
        int repeticionesM = 0;

        for (int i = numeroRomano.length() - 1; i >= 0; i--) {
            char caracter = numeroRomano.charAt(i);
            int valor = obtenerValorCaracterRomano(caracter);

            switch (valor) {
                case 1:
                    repeticionesI++;
                    if (repeticionesI > 3) {
                        throw new IllegalArgumentException("Número inválido, demasiadas repeticiones de I.");
                    }
                    break;
                case 10:
                    repeticionesX++;
                    if (repeticionesX > 3) {
                        throw new IllegalArgumentException("Número inválido, demasiadas repeticiones de X.");
                    }
                    break;
                case 100:
                    repeticionesC++;
                    if (repeticionesC > 3) {
                        throw new IllegalArgumentException("Número inválido, demasiadas repeticiones de C.");
                    }
                    break;
                case 1000:
                    repeticionesM++;
                    if (repeticionesM > 3) {
                        throw new IllegalArgumentException("Número inválido, demasiadas repeticiones de M.");
                    }
                    break;
                case 5:
                case 50:
                case 500:
                    throw new IllegalArgumentException("Número inválido, no se permiten repeticiones de V, L o D.");
                default:
                    if (valor > 100 && repeticionesI > 0) {
                        throw new IllegalArgumentException("Número inválido, I no puede preceder a números mayores a 100.");
                    }
                    if (valor > 1000 && repeticionesX > 0) {
                        throw new IllegalArgumentException("Número inválido, X no puede preceder a números mayores a 1000.");
                    }
            }

            resultado += valor;
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
                throw new IllegalArgumentException("Carácter romano inválido: " + caracter);
        }
    }
}
