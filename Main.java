import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase principal que lee una ecuación desde un archivo y la evalúa utilizando una calculadora.
 */
class Main
{
    private static Calculadora calculadora;

    /**
     * Método principal del programa.
     * Lee una expresión matemática desde un archivo y la evalúa usando la clase Calculadora.
     *
     * @param args Argumentos de la línea de comandos (no utilizados en este programa).
     */

    public static void main(String[] args)
    {
        String ruta = "Ecuacion.txt";
        String linea = null;

/**
         * Intenta abrir y leer la primera línea del archivo especificado.
         * Si el archivo no existe o no se puede leer, se captura la excepción.
         */

        try (BufferedReader lector = new BufferedReader(new FileReader(ruta)))
        {
            linea = lector.readLine();
            if(linea != null)
            {
                Calculadora calculadora = new Calculadora(linea);
                System.out.println(calculadora.Resultado());
            }
            else
            {
                System.out.println("Archivo vacío.");
            }
        }
        catch (IOException e)
        {
            System.err.println("No se pudo leer el archivo. " + e.getMessage());
        }
    }
}