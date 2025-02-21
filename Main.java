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
                boolean flag = true;
                boolean flag2 = false;
                String opcion = null;

                while (flag)
                {
                    System.out.println("\n¿Qué tipo de Stack desea usar?");
                    System.out.println("1) ArrayList");
                    System.out.println("2) Vector");
                    System.out.println("3) Lista simplemente enlazada");
                    System.out.println("4) Lista doblemente enlazada");
                    System.out.println("5) Salir del progrma");
                    opcion = sc.nextLine();

                    if (opcion.equals("1") || opcion.equals("2") || opcion.equals("3") || opcion.equals("4"))
                    {
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
                    Calculadora calculadora = Calculadora.Instancia(opcion);
                    System.out.println("El resultado obtenido es: " + calculadora.Resultado(linea));
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