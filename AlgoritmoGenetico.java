// Linda Candela Paz
// 42.379.854
// VINFO13378

import java.util.Random;

public class AlgoritmoGenetico {

    public static void main(String[] args) {
        int longitudCadena = 20; // Longitud de la cadena
        int iteraciones = 0;    // Contador de iteraciones
        Random random = new Random();
        
        // Cadena inicial
        int[] cadenaPrincipal = generarCadenaAleatoria(longitudCadena, random);
        int valorPrincipal = evaluarFuncion(cadenaPrincipal);

        // Objetivo: Cadena óptima con todos los bits en 1
        int[] cadenaOptima = new int[longitudCadena];
        for (int i = 0; i < longitudCadena; i++) {
            cadenaOptima[i] = 1;
        }
        int valorOptimo = evaluarFuncion(cadenaOptima);

        System.out.println("Iniciando el algoritmo genético...");
        System.out.println("Objetivo: encontrar una cadena con el valor máximo H(x) = " + valorOptimo + "\n");

        // Ciclo hasta encontrar la solución óptima
        while (valorPrincipal < valorOptimo) {
            iteraciones++;

            // Generar nueva cadena aleatoria
            int[] nuevaCadena = generarCadenaAleatoria(longitudCadena, random);

            // Cruzar cadenas
            int[] cadenaResultante = cruzarCadenas(cadenaPrincipal, nuevaCadena);

            // Evaluar la nueva cadena
            int valorResultante = evaluarFuncion(cadenaResultante);

            // Mostrar cadenas aptas
            if (valorResultante > valorPrincipal) {
                System.out.println("Iteración " + iteraciones + ":");
                System.out.println("- Cadena principal actual (la mejor hasta ahora): ");
                mostrarCadena(cadenaPrincipal);
                System.out.println("- Nueva cadena generada aleatoriamente: ");
                mostrarCadena(nuevaCadena);
                System.out.println("- Resultado después del cruce (cadena evaluada): ");
                mostrarCadena(cadenaResultante);
                System.out.println("  * Valor de H(x) para esta cadena: " + valorResultante);
                System.out.println("  * Actualizando la cadena principal con esta nueva cadena.\n");

                // Actualizar la cadena principal
                cadenaPrincipal = cadenaResultante;
                valorPrincipal = valorResultante;
            }
        }

        // Resultado final
        System.out.println("¡Cadena óptima alcanzada después de " + iteraciones + " iteraciones!");
        System.out.println("Resultado final:");
        System.out.print("- Cadena óptima: ");
        mostrarCadena(cadenaPrincipal);
        System.out.println("- Valor de H(x): " + valorPrincipal);
    }

    // Generar una cadena aleatoria de bits (0 y 1)
    public static int[] generarCadenaAleatoria(int longitud, Random random) {
        int[] cadena = new int[longitud];
        for (int i = 0; i < longitud; i++) {
            cadena[i] = random.nextInt(2); // 0 o 1
        }
        return cadena;
    }

    // Evaluar la función H(x) = Σ(x * 2)
    public static int evaluarFuncion(int[] cadena) {
        int suma = 0;
        for (int x : cadena) {
            suma += x * 2;
        }
        return suma;
    }

    // Realizar el cruce entre dos cadenas
    public static int[] cruzarCadenas(int[] cadena1, int[] cadena2) {
        int[] resultante = new int[cadena1.length];
        for (int i = 0; i < cadena1.length; i++) {
            resultante[i] = (cadena1[i] == cadena2[i]) ? 1 : 0;
        }
        return resultante;
    }

    // Mostrar una cadena en la consola
    public static void mostrarCadena(int[] cadena) {
        for (int bit : cadena) {
            System.out.print(bit + " ");
        }
        System.out.println();
    }
}
