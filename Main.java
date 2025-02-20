/**
 * @author Ricardo Rodríguez
 * @version 1
 * Clase principal.
 * fecha_creación = 14/02/2025
 * fecha_modificación = 19/02/2025
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class Main
{
    public static void main(String[] args)
    {
        String ruta = "Ecuacion.txt";
        String linea = null;
        Scanner sc = new Scanner(System.in);

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

                while (flag)
                {
                    System.out.println("\n¿Qué tipo de Stack desea usar?");
                    System.out.println("1) ArrayList");
                    System.out.println("2) Vector");
                    System.out.println("3) Lista simplemente enlazada");
                    System.out.println("4) Lista doblemente enlazada");
                    System.out.println("5) Salir del progrma");
                    String opcion = sc.nextLine();

                    if (opcion.equals("1"))
                    {
                        stack1 = StackFactory.createStack(StackFactory.StackType.ARRAY_LIST, null, null);
                        stack2 = StackFactory.createStack(StackFactory.StackType.ARRAY_LIST, null, null);
                        flag2 = true;
                        flag = false;
                    }
                    else if (opcion.equals("2"))
                    {
                        stack1 = StackFactory.createStack(StackFactory.StackType.VECTOR, null, null);
                        stack2 = StackFactory.createStack(StackFactory.StackType.VECTOR, null, null);
                        flag2 = true;
                        flag = false;
                    }
                    else if (opcion.equals("3"))
                    {
                        stack1 = StackFactory.createStack(StackFactory.StackType.LINKED_LIST, listFactory, ListFactory.ListType.SINGLE_LINKED);
                        stack2 = StackFactory.createStack(StackFactory.StackType.LINKED_LIST, listFactory_char, ListFactory.ListType.SINGLE_LINKED);
                        flag2 = true;
                        flag = false;
                    }
                    else if (opcion.equals("4"))
                    {
                        stack1 = StackFactory.createStack(StackFactory.StackType.LINKED_LIST, listFactory, ListFactory.ListType.DOUBLE_LINKED);
                        stack2 = StackFactory.createStack(StackFactory.StackType.LINKED_LIST, listFactory_char, ListFactory.ListType.DOUBLE_LINKED);
                        flag2 = true;
                        flag = false;
                    }
                    else if (opcion.equals("5"))
                    {
                        System.out.println("Adiós");
                        flag = false;
                    }
                    else
                    {
                        System.out.println("Opción incorrecta.");
                    }
                }

                if (flag2)
                {
                    Calculadora calculadora = Calculadora.Instancia(stack1, stack2);
                    System.out.println(calculadora.Resultado(linea));
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