/**
 * @author Ricardo Rodríguez
 * @version 1
 * Clase que simula la calculadora.
 * fecha_creación = 14/02/2025
 * fecha_modificación = 18/02/2025
 */

public class Calculadora
{
    private static Calculadora instancia;
    private Stack<Double> stack;
    private Stack<Character> stack_char;
    private String[] caracteres;

    public Calculadora(Stack<Double> stack, Stack<Character> stack_char)
    {
        this.stack = stack;
        this.stack_char = stack_char;
        caracteres = null;
    }

    public static Calculadora Instancia(Stack<Double> stack, Stack<Character> stack_char)
    {
        if (instancia == null) 
        {
            instancia = new Calculadora(stack, stack_char);
        }
        return instancia;
    }


    public String Traductor(String ecuacion)
    {
        String resultado = "";
        
        for (int i = 0; i < ecuacion.length(); i++)
        {
            char car = ecuacion.charAt(i);
            
            if (Character.isLetterOrDigit(car))
            {
                resultado += car;
                if (i + 1 < ecuacion.length() && !Character.isLetterOrDigit(ecuacion.charAt(i + 1)))
                {
                    resultado = resultado + " ";
                }
            }
            else if (car == '(') 
            {
                stack_char.push(car);
            }
            else if (car == ')')
            {
                while (!stack_char.isEmpty() && stack_char.peek() != '(')
                {
                    resultado = resultado + stack_char.pop() + " ";
                }
                if (!stack_char.isEmpty() && stack_char.peek() == '(')
                {
                    stack_char.pop();
                }
            }
            else if (esOperador(String.valueOf(car)) > 0)
            {
                while (!stack_char.isEmpty() && esOperador(String.valueOf(stack_char.peek())) > 0 && esOperador(String.valueOf(stack_char.peek())) >= esOperador(String.valueOf(car)))
                {
                    resultado = resultado + stack_char.pop() + " ";
                }
                stack_char.push(car);
            }
            else if (car == ' ') 
            {
                continue;
            }
            else
            {
                //errror
            }

        }
        while (!stack_char.isEmpty())
        {
            resultado = resultado + stack_char.pop();
        }
        
        return resultado;
    }

    public int esOperador(String token)
    {
        if (token.equals("+") || token.equals("-"))
        {
            return 1;
        }
        else if (token.equals("*") || token.equals("/") || token.equals("%"))
        {
            return 2;
        }
        else if (token.equals("^"))
        {
            return 3;
        }
        else
        {
            return -1;
        }
    }

    public double Operar(String operador, double a, double b)
    {
        switch (operador)
        {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return b / a;
            case "%": return b % a;
            case "^": return Math.pow(b, a);
            default: throw new IllegalArgumentException("Operador inválido: " + operador);
        }
    }
    
    public double Resultado(String ecuacion)
    {
        String ecuacion_pre = Traductor(ecuacion);
        caracteres = ecuacion_pre.split("\\s+");

        double a;
        double b;
        double resultado;
        for (int i = 0; i <= caracteres.length - 1; i++)
        {
            String car = this.caracteres[i];

            if (esOperador(car) > 0)
            {
                try
                {
                    a = stack.pop();
                    b = stack.pop();
                } 
                catch (Exception e)
                {
                    return -1;
                }
                resultado = Operar(car, a, b);
                stack.push(resultado);
            } 
            else
            {
                stack.push(Double.parseDouble(car));
            }
        }
        if (stack.size() == 1)
        {
            return stack.pop();
        }
        else
        {
            return -1;
        }        
    }
}

