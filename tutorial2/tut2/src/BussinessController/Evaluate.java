package BussinessController;

import java.util.Scanner;
import java.util.Stack;

public class Evaluate
{
    public static double evaluate(String expression)
    {
        char[] tokens = expression.toCharArray();

        
        Stack<Double> values = new Stack<Double>();

      
        Stack<Character> ops = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++)
        {
            if (tokens[i] >= '0' && tokens[i] <= '9')
            {
                StringBuffer sbuf = new StringBuffer();
                
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9' || tokens[i]=='.')
                    {
                		sbuf.append(tokens[i++]);
                		if(i>=tokens.length)
                			break;
                    }
                i--;
                values.push(Double.parseDouble(sbuf.toString()));
               
            }

            else if (tokens[i] == '(')
                ops.push(tokens[i]);

            else if (tokens[i] == ')')
            {
                while (ops.peek() != '(')
                  values.push(perform(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }

            else if (tokens[i] == '+' || tokens[i] == '-' ||
                     tokens[i] == '*' || tokens[i] == '/')
            {
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                  values.push(perform(ops.pop(), values.pop(), values.pop()));
                ops.push(tokens[i]);
            }
        }

        while (!ops.empty())
            values.push((double) perform(ops.pop(), values.pop(), values.pop()));
        return values.pop();
    }

    public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

 
    public static Double perform(char op, double b, double a)
    {
        switch (op)
        {
        case '+':
            return add(a,b);
        case '-':
            return subtract(a,b);
        case '*':
            return multiply(a,b);
        case '/':
            if (b == 0)
                throw new
                UnsupportedOperationException("Cannot divide by zero");
            return divide(a,b);
        }
        return 0.0;
    }

	public static Double divide(double a, double b) {
		// TODO Auto-generated method stub
		return a/b;
	}

	public static Double multiply(double a, double b) {
		// TODO Auto-generated method stub
		return a*b;
	}

	public static Double subtract(double a, double b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	public static Double add(double a, double b) {
		// TODO Auto-generated method stub
		
		return a+b;
	}
	

}