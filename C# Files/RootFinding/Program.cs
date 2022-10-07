using System.Reflection.Metadata.Ecma335;
using System.Security.Cryptography.X509Certificates;
using System.Transactions;
using System.IO;
using System;

public class Program
{

    // Functions to find the root
    public double tolerance = Math.Pow(10, -8);
    public int maxIterations = 100;

    // Delegate allows to pass functions onto other functions.
    public delegate double Equation(double x);
    
    public double eq1(double x)
    {       
        return ((1 / 6) * Math.Pow(x, 6)) - ((18 / 5) * Math.Pow(x, 5)) + ((103 / 4) * Math.Pow(x, 4)) - (58 * Math.Pow(x, 3)) - (52 * Math.Pow(x, 2)) + (192 * x) - (4352 / 15);
    }
    public double eq2(double x)
    {
        return (Math.Pow(x, 3)) + (1.75 * Math.Pow(x, 2)) - (0.485 * x) - 0.030;
    }
    public double eq3(double x)
    {
        return (Math.Pow(x, 2) / 4) + x * Math.Sin(x) - 1;
    }
    public double eq4(double x)
    {
        return (-(1 / 4) * Math.Pow(x, 3)) + ((5 / 4) * x);
    }
    public double eq5(double x)
    {
        return double.Epsilon + Math.Cos(x) + 1;
    }

    public double eq6(double x)
    {
        return Math.Pow(x, 3) - 4 * Math.Pow(x, 2) + 3 * x - 1;
    }

    public double eq7(double x)
    {
        return  Math.Pow(double.Epsilon, x) * (1 - 2 * Math.Cos(x));
    }

    // Derivatives of the functions
    public double eq1d(double x)
    {
        return (Math.Pow(x, 5)) - ((18 / 5) * Math.Pow(x, 4)) + ((103 / 4) * Math.Pow(x, 3)) - (58 * Math.Pow(x, 2)) - (52 * x) + 192;
    }
    public double eq2d(double x)
    {
        return (3 * Math.Pow(x, 2)) + (3.5 * x) - 0.485;
    }
    public double eq3d(double x)
    {
        return (Math.Pow(x, 2) / 2) + Math.Sin(x) + x * Math.Cos(x);
    }
    public double eq4d(double x)
    {
        return (-(3 / 4) * Math.Pow(x, 2)) + 5 / 4;
    }
    public double eq5d(double x)
    {
        return Math.Sin(x);
    }

    public double eq6d(double x)
    {
        return 3 * Math.Pow(x, 2) - 8 * x + 3;
    }

    public double eq7d(double x)
    {
        return Math.Pow(double.Epsilon, x) * (Math.Sin(x) - 2 * Math.Cos(x));
    }
    
    //Bisection Method
    public double Bisection(Equation f, double a, double b)
    {
        double c = 0;
        int i = 0;
        while (i < maxIterations)
        {
            c = (a + b) / 2;
            if (Math.Abs(f(c)) < tolerance)
            {
                return c;
            }
            else if (f(a) * f(c) < 0)
            {
                b = c;
            }
            else
            {
                a = c;
            }
            i++;
        }
        return c;
    }

    //Newton Method
    public double Newton(Equation f, Equation fd, double x0)
    {
        int i = 0;
        double h = f(x0) / fd(x0);
        while (Math.Abs(h) >= tolerance && i < maxIterations)
        {
            h = f(x0) / fd(x0);
            x0 = x0 - h;
            i++;
        }
        return x0;
    }

    //Secant Method
    public double Secant(Equation f, double x0, double x1)
    {
        int i = 0;
        double x2 = 0;
        while (i < maxIterations)
        {
            x2 = x1 - (f(x1) * (x1 - x0)) / (f(x1) - f(x0));
            if (Math.Abs(f(x2)) <= tolerance)
            {
                return x2;
            }
            x0 = x1;
            x1 = x2;
            i++;
        }
        return x2;
    }

    //Muller's Method
    public double Muller(Equation f, double x0, double x1, double x2)
    {
        int i = 0;
        double h0 = x1 - x0;
        double h1 = x2 - x1;
        double delta0 = (f(x1) - f(x0)) / h0;
        double delta1 = (f(x2) - f(x1)) / h1;
        double d = (delta1 - delta0) / (h1 + h0);
        double b = delta1 + h1 * d;
        double D = Math.Sqrt(Math.Pow(b, 2) - 4 * f(x2) * d);
        double E = Math.Abs(b - D) < Math.Abs(b + D) ? b + D : b - D;
        double h = -2 * f(x2) / E;
        double x3 = x2 + h;
        while (i < maxIterations)
        {
            if (Math.Abs(f(x3)) <= tolerance)
            {
                return x3;
            }
            x0 = x1;
            x1 = x2;
            x2 = x3;
            h0 = x1 - x0;
            h1 = x2 - x1;
            delta0 = (f(x1) - f(x0)) / h0;
            delta1 = (f(x2) - f(x1)) / h1;
            d = (delta1 - delta0) / (h1 + h0);
            b = delta1 + h1 * d;
            D = Math.Sqrt(Math.Pow(b, 2) - 4 * f(x2) * d);
            E = Math.Abs(b - D) < Math.Abs(b + D) ? b + D : b - D;
            h = -2 * f(x2) / E;
            x3 = x2 + h;
            i++;
        }

        return x3;
    }

    //Inverse Quadratic Interpolation Method
    public double InverseQuadratic(Equation f, double x0, double x1, double x2)
    {
        double h0 = x1 - x0;
        double h1 = x2 - x1;
        double delta0 = (f(x1) - f(x0)) / h0;
        double delta1 = (f(x2) - f(x1)) / h1;
        double d = (delta1 - delta0) / (h1 + h0);
        double b = delta1 + h1 * d;
        double D = Math.Sqrt(Math.Pow(b, 2) - 4 * f(x2) * d);
        double E = Math.Abs(b - D) < Math.Abs(b + D) ? b + D : b - D;
        double h = -2 * f(x2) / E;
        double x3 = x2 + h;
        return x3;
    }

    //False Position Method
    public double FalsePosition(Equation f, double x0, double x1)
    {
        int i = 0;
        double x2 = 0;
        while (i < maxIterations)
        {
            x2 = x1 - (f(x1) * (x1 - x0)) / (f(x1) - f(x0));
            if (Math.Abs(f(x2)) <= tolerance)
            {
                return x2;
            }
            if (f(x0) * f(x2) < 0)
            {
                x1 = x2;
            }
            else
            {
                x0 = x2;
            }
            i++;
        }
        return x2;
    }

    public static void Main()
    {

        Program p = new Program();


        string path = Environment.GetFolderPath(Environment.SpecialFolder.Desktop) + "\\Roots.txt";

        // Print out the results into a file on your desktop folder.
        using (StreamWriter sw = new StreamWriter(path))
        {

            //Bisection Method
            sw.WriteLine("Bisection Method: \n");
            sw.WriteLine(p.Bisection(p.eq1, 7.8, 8.4));
            sw.WriteLine(p.Bisection(p.eq2, 0, 0.5));
            sw.WriteLine(p.Bisection(p.eq3, 3, 5));
            sw.WriteLine(p.Bisection(p.eq4, 1, 3));
            sw.WriteLine(p.Bisection(p.eq5, -2, 0));
            sw.WriteLine(p.Bisection(p.eq6, -1, 0));
            sw.WriteLine(p.Bisection(p.eq6, 2, 3));
            sw.WriteLine(p.Bisection(p.eq7, -1.25, -0.75));
            sw.WriteLine("-------------------------------");


            //Newton Method
            sw.WriteLine("\nNewton's Method: \n");
            sw.WriteLine(p.Newton(p.eq1, p.eq1d, 7));
            sw.WriteLine(p.Newton(p.eq2, p.eq2d, 0));
            sw.WriteLine(p.Newton(p.eq3, p.eq3d, 3));
            sw.WriteLine(p.Newton(p.eq4, p.eq4d, 1));
            sw.WriteLine(p.Newton(p.eq5, p.eq5d, -4));
            sw.WriteLine(p.Newton(p.eq6, p.eq6d, -0.5));
            sw.WriteLine(p.Newton(p.eq6, p.eq6d, 2.5));
            sw.WriteLine(p.Newton(p.eq7, p.eq7d, -1));
            sw.WriteLine("-------------------------------");

            //Secant Method
            sw.WriteLine("\nSecant Method:\n");
            sw.WriteLine(p.Secant(p.eq1, 7, 7.5));
            sw.WriteLine(p.Secant(p.eq2, 0, 0.5));
            sw.WriteLine(p.Secant(p.eq3, 3, 5));
            sw.WriteLine(p.Secant(p.eq4, 1, 3));
            sw.WriteLine(p.Secant(p.eq5, -2, 0));
            sw.WriteLine(p.Secant(p.eq6, -1, 0));
            sw.WriteLine(p.Secant(p.eq6, 2, 3));
            sw.WriteLine(p.Secant(p.eq7, -1.25, -0.75));
            sw.WriteLine("-------------------------------");

            //Muller's Method
            sw.WriteLine("\nMuller's Method:\n");
            sw.WriteLine(p.Muller(p.eq1, 7, 7.5, 7.75));
            sw.WriteLine(p.Muller(p.eq2, 0, 0.5, 0.2));
            sw.WriteLine(p.Muller(p.eq3, 3, 5, 4));
            sw.WriteLine(p.Muller(p.eq4, 1, 3, 2));
            sw.WriteLine(p.Muller(p.eq5, -2, 0, -1));
            sw.WriteLine(p.Muller(p.eq6, -1, 0, -0.5));
            sw.WriteLine(p.Muller(p.eq6, 2, 3, 2.5));
            sw.WriteLine(p.Muller(p.eq7, -1.25, -0.75, -1));
            sw.WriteLine("-------------------------------");

            //Inverse Quadratic Interpolation Method
            sw.WriteLine("\nInverse Quadratic Interpolation:");
            sw.WriteLine(p.InverseQuadratic(p.eq1, 7, 7.5, 7.75));
            sw.WriteLine(p.InverseQuadratic(p.eq2, 0, 0.5, 0.2));
            sw.WriteLine(p.InverseQuadratic(p.eq3, 3, 5, 4));
            sw.WriteLine(p.InverseQuadratic(p.eq4, 1, 3, 2));
            sw.WriteLine(p.InverseQuadratic(p.eq5, -2, 0, -1));
            sw.WriteLine(p.InverseQuadratic(p.eq6, -1, 0, -0.5));
            sw.WriteLine(p.InverseQuadratic(p.eq6, 2, 3, 2.5));
            sw.WriteLine(p.InverseQuadratic(p.eq7, -1.25, -0.75, -1));
            sw.WriteLine("-------------------------------");

            //False Position Method
            sw.WriteLine("\nFalse Position Method:\n");
            sw.WriteLine(p.FalsePosition(p.eq1, 7, 7.5));
            sw.WriteLine(p.FalsePosition(p.eq2, 0, 0.5));
            sw.WriteLine(p.FalsePosition(p.eq3, 3, 5));
            sw.WriteLine(p.FalsePosition(p.eq4, 1, 3));
            sw.WriteLine(p.FalsePosition(p.eq5, -2, 0));
            sw.WriteLine(p.FalsePosition(p.eq6, -1, 0));
            sw.WriteLine(p.FalsePosition(p.eq6, 2, 3));
            sw.WriteLine(p.FalsePosition(p.eq7, -1.25, -0.75));

        }
    }
}