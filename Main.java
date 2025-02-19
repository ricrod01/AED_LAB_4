/**
 * @author Ricardo Rodríguez
 * @version 1
 * Clase principal.
 * fecha_creación = 14/02/2025
 * fecha_modificación = 18/02/2025
 */

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
                ListFactory<Double> listFactory = new ListFactory<>();
                ListFactory<Character> listFactory_char = new ListFactory<>();
                Stack<Double> stack1 = null;
                Stack<Character> stack2 = null;
                boolean flag = true;
                boolean flag2 = false;
                int opcion = 1;

                while (flag)
                {
                    if (opcion == 1)
                    {
                        stack1 = StackFactory.createStack(StackFactory.StackType.ARRAY_LIST, null, null);
                        stack2 = StackFactory.createStack(StackFactory.StackType.ARRAY_LIST, null, null);
                        flag2 = true;
                    }
                    else if (opcion == 2)
                    {
                        stack1 = StackFactory.createStack(StackFactory.StackType.VECTOR, null, null);
                        stack2 = StackFactory.createStack(StackFactory.StackType.VECTOR, null, null);
                        flag2 = true;
                    }
                    else if (opcion == 3)
                    {
                        stack1 = StackFactory.createStack(StackFactory.StackType.LINKED_LIST, listFactory, ListFactory.ListType.SINGLE_LINKED);
                        stack2 = StackFactory.createStack(StackFactory.StackType.LINKED_LIST, listFactory_char, ListFactory.ListType.SINGLE_LINKED);
                        flag2 = true;
                    }
                    else if (opcion == 4)
                    {
                        stack1 = StackFactory.createStack(StackFactory.StackType.LINKED_LIST, listFactory, ListFactory.ListType.DOUBLE_LINKED);
                        stack2 = StackFactory.createStack(StackFactory.StackType.LINKED_LIST, listFactory_char, ListFactory.ListType.DOUBLE_LINKED);
                        flag2 = true;
                    }
                    else if (opcion == 5)
                    {
                        System.out.println("Adiós");
                        flag = false;
                    }
                    else
                    {
                        System.out.println("Opción incorrecta.");
                    }
                }

                if (flag2 = true)
                {
                    Calculadora calc_array_list = new Calculadora(stack1, stack2);
                    System.out.println(calc_array_list.Resultado(linea));
                }
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