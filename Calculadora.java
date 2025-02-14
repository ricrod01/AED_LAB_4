public class Calculadora
{
    private Stack<Double> stack;
    private String[] caracteres;

    public Calculadora(String ecuacion)
    {
        this.stack = new StackVector<>();
        this.caracteres = ecuacion.split("\\s+");
    }

    private String Traductor(String ecuacion)
    {
        return "jj";
    }

    private static boolean esOperador(String token)
    {
        return token.equals("+") || token.equals("-") || token.equals("*") 
        || token.equals("/") || token.equals("%");
    }

    private static double Operar(String operador, double a, double b)
    {
        switch (operador)
        {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return b / a;
            case "%": return a % b;
            default: throw new IllegalArgumentException("Operador inválido: " + operador);
        }
    }
    
    public double Resultado()
    {
        double a;
        double b;
        double resultado;
        for (int i = 0; i <= caracteres.length - 1; i++)
        {
            String car = this.caracteres[i];
            System.out.println(car);

            if (esOperador(car))
            {
                try
                {
                    a = stack.pop();
                    b = stack.pop();
                    System.out.println(a);
                } 
                catch (Exception e)
                {
                    return -1;
                }

                resultado = Operar(car, a, b);
                stack.push(resultado);
            } else
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

