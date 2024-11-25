# Algoritmo Genético - Trabajo Práctico 4

Este programa es una implementación de un algoritmo genético básico en **Java**. El objetivo es encontrar una cadena de bits (0s y 1s) óptima, donde todos los bits sean 1s. A continuación, te explico cómo funciona.

## Descripción del Código

1. **Cadena Inicial**  
   Se genera una cadena aleatoria de 20 bits como punto de partida. Cada bit puede ser un 0 o un 1.

2. **Evaluación de la Cadena**  
   Se usa la función `H(x) = Σ(x * 2)` para evaluar cuán buena es la cadena. Básicamente, suma el doble del valor de cada bit.

3. **Cadena Óptima**  
   La cadena óptima es aquella en la que todos los bits son 1s. La evaluación para esta cadena alcanza el valor máximo posible (40 en este caso).

4. **Proceso Evolutivo**  
   - En cada iteración, se genera una **nueva cadena aleatoria**.  
   - Luego, se realiza un **cruce** entre la cadena principal y la nueva cadena, generando una cadena "hija".  
   - Si la cadena resultante tiene un valor mayor que la cadena principal, se actualiza como la nueva cadena principal.

5. **Parada del Algoritmo**  
   El proceso se repite hasta que la cadena principal se vuelve idéntica a la cadena óptima, es decir, cuando todos los bits son 1s.

6. **Salida por Consola**  
   En cada mejora de la cadena, se imprimen los detalles:
   - La cadena principal antes de cruzarse.
   - La nueva cadena generada.
   - La cadena resultante tras el cruce.
   - El valor de evaluación `H(x)` de la cadena resultante.  
   Al final, se muestra cuántas iteraciones fueron necesarias para alcanzar la cadena óptima.

## Cómo Ejecutarlo

1. Asegurate de tener Java instalado en tu máquina.
2. Copiá el código en un archivo llamado `AlgoritmoGenetico.java`.
3. Compilalo con el comando:
   ```bash
   javac AlgoritmoGenetico.java
