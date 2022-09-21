using System;

public class assignment1
{

    //Bisection Method
    public void Bisection(double a, double b, double tol, int maxIter)
    {
        double fa = f(a);
        double fb = f(b);
        double c = 0;
        double fc = 0;
        double error = 0;
        int iter = 0;

        if (fa * fb > 0)
        {
            Console.WriteLine("No root in this interval");
        }
        else
        {
            while (iter < maxIter)
            {
                c = (a + b) / 2;
                fc = f(c);
                error = Math.Abs(b - a) / 2;
                if (error < tol)
                {
                    Console.WriteLine("Root found at " + c);
                    break;
                }
                else
                {
                    if (fa * fc < 0)
                    {
                        b = c;
                        fb = fc;
                    }
                    else
                    {
                        a = c;
                        fa = fc;
                    }
                }
                iter++;
            }
        }
    }

    //Newton-Raphson Method
    public void NewtonRaphson(double x0, double tol, int maxIter)
    {
        double x1 = 0;
        double error = 0;
        int iter = 0;

        while (iter < maxIter)
        {
            x1 = x0 - f(x0) / df(x0);
            error = Math.Abs(x1 - x0);
            if (error < tol)
            {
                Console.WriteLine("Root found at " + x1);
                break;
            }
            else
            {
                x0 = x1;
            }
            iter++;
        }
    }
    
    //Secant Method
    public void Secant(double x0, double x1, double tol, int maxIter)
    {
        double x2 = 0;
        double error = 0;
        int iter = 0;

        while (iter < maxIter)
        {
            x2 = x1 - f(x1) * (x1 - x0) / (f(x1) - f(x0));
            error = Math.Abs(x2 - x1);
            if (error < tol)
            {
                Console.WriteLine("Root found at " + x2);
                break;
            }
            else
            {
                x0 = x1;
                x1 = x2;
            }
            iter++;
        }
    }

    //Muller's Method
    public void Muller(double x0, double x1, double x2, double tol, int maxIter)
    {
        double x3 = 0;
        double error = 0;
        int iter = 0;

        while (iter < maxIter)
        {
            x3 = x2 - (Math.Pow(x2 - x1, 2) * f(x2) - Math.Pow(x2 - x0, 2) * f(x2)) / (2 * (x2 - x1) * f(x2) - 2 * (x2 - x0) * f(x2));
            error = Math.Abs(x3 - x2);
            if (error < tol)
            {
                Console.WriteLine("Root found at " + x3);
                break;
            }
            else
            {
                x0 = x1;
                x1 = x2;
                x2 = x3;
            }
            iter++;
        }
    }

    //Inverse Quadratic iteration
    public void InverseQuadratic(double x0, double x1, double x2, double tol, int maxIter)
    {
        double x3 = 0;
        double error = 0;
        int iter = 0;

        while (iter < maxIter)
        {
            x3 = x2 - (Math.Pow(x2 - x1, 2) * f(x2) - Math.Pow(x2 - x0, 2) * f(x2)) / (2 * (x2 - x1) * f(x2) - 2 * (x2 - x0) * f(x2));
            error = Math.Abs(x3 - x2);
            if (error < tol)
            {
                Console.WriteLine("Root found at " + x3);
                break;
            }
            else
            {
                x0 = x1;
                x1 = x2;
                x2 = x3;
            }
            iter++;
        }
    }

    //Bracketed Secant Method
    public void BracketedSecant(double x0, double x1, double tol, int maxIter)
    {
        double x2 = 0;
        double error = 0;
        int iter = 0;

        while (iter < maxIter)
        {
            x2 = x1 - f(x1) * (x1 - x0) / (f(x1) - f(x0));
            error = Math.Abs(x2 - x1);
            if (error < tol)
            {
                Console.WriteLine("Root found at " + x2);
                break;
            }
            else
            {
                x0 = x1;
                x1 = x2;
            }
            iter++;
        }
    }
    
    public static void Main()
    {

    }
}