/**
 * @author Ricardo Rodríguez
 * @version 1
 * Clase que simula la calculadora.
 * fecha_creación = 14/02/2025
 * fecha_modificación = 19/02/2025
 */

public class Calculadora
{
    private static Calculadora instancia;
    private Stack<Double> stack;
    private Stack<Character> stack_char;
    private String[] caracteres;

    /**
     * @param stack Stack para datos tipo double.
     * @param stack_char Stack para carácteres.
    */

    private Calculadora(String opcion)
    {
        ListFactory<Double> listFactory = new ListFactory<>();
        ListFactory<Character> listFactory_char = new ListFactory<>();
        Stack<Double> stack1 = null;
        Stack<Character> stack2 = null;

        if (opcion.equals("1"))
        {
            stack1 = StackFactory.createStack(StackFactory.StackType.ARRAY_LIST, null, null);
            stack2 = StackFactory.createStack(StackFactory.StackType.ARRAY_LIST, null, null);
        }
        else if (opcion.equals("2"))
        {
            stack1 = StackFactory.createStack(StackFactory.StackType.VECTOR, null, null);
            stack2 = StackFactory.createStack(StackFactory.StackType.VECTOR, null, null);
        }
        else if (opcion.equals("3"))
        {
            stack1 = StackFactory.createStack(StackFactory.StackType.LINKED_LIST, listFactory, ListFactory.ListType.SINGLE_LINKED);
            stack2 = StackFactory.createStack(StackFactory.StackType.LINKED_LIST, listFactory_char, ListFactory.ListType.SINGLE_LINKED);
        }
        else if (opcion.equals("4"))
        {
            stack1 = StackFactory.createStack(StackFactory.StackType.LINKED_LIST, listFactory, ListFactory.ListType.DOUBLE_LINKED);
            stack2 = StackFactory.createStack(StackFactory.StackType.LINKED_LIST, listFactory_char, ListFactory.ListType.DOUBLE_LINKED);
        }

        this.stack = stack1;
        this.stack_char = stack2;
        caracteres = null;
    }

    /**
     * @param stack Stack para datos tipo double.
     * @param stack_char Stack para carácteres.
    */

    public static Calculadora Instancia(String opcion)
    {
        if (instancia == null) 
        {
            instancia = new Calculadora(opcion);
        }
        return instancia;
    }

    /**
     * @param ecuacion Ecuación en formato infix.
     * @return Devuelve la ecuación en formato Postfix.
    */

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
                throw new IllegalArgumentException("Se detectó un caracter que no debería de estar.");
            }

        }
        while (!stack_char.isEmpty())
        {
            resultado = resultado + " " + stack_char.pop();
        }
        
        return resultado;
    }

    /**
     * @param token El operador.
     * @return El orden de operación.
    */

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

    /**
     * @param operador Operador.
     * @param a Segundo operando.
     * @param b Primer operando.
     * @return Devuelve el resultado de la operación.
    */

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

    /**
     * @param ecuación Operación a resolver.
     * @return Devuelve el resultado de la operación.
    */
    
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
            throw new IllegalArgumentException("La ecuación está mal escrita.");
        }        
    }
}

