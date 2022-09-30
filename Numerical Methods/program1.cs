public class Program
{

    // Functions to find the root
    public double tolerance = Math.Pow(10, -8);

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
        return Double.Epsilon + Math.Cos(x) + 1;
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

    //Bisection Method
    public double Bisection(Equation f, double a, double b, int maxIter)
    {

        if (f(a) * f(b) >= 0)
        {
            Console.WriteLine("You have not assumed right a and b");
            return 0;
        }

        double c = a;
        for (int i = 0; i < maxIter; i++)
        {
            c = (a + b) / 2;

            if (f(c) == 0.0)
                break;

            else if (f(c) * f(a) < 0)
                b = c;
            else
                a = c;
        }

        return c;
    }

    //Newton Method
    public double Newton(double x, Equation eq, Equation eqd, int maxIter)
    {

        for (int i = 0; i < maxIter; i++)
        {
            double h = eq(x) / eqd(x);

            if (Math.Abs(h) <= tolerance)
                break;

            x = x - h;
        }

        return x;
    }

    //Secant Method
    public double Secant(Equation f, double x0, double x1, int maxIter)
    {
        double x2 = 0;
        for (int i = 0; i < maxIter; i++)
        {
            x2 = x1 - (f(x1) * (x1 - x0)) / (f(x1) - f(x0));
            x0 = x1;
            x1 = x2;
        }

        return x2;
    }

    //Muller's Method
    public double Muller(Equation f, double x0, double x1, double x2, int maxIter)
    {
        // Calculating the initial quadratic
        double h0 = x1 - x0;
        double h1 = x2 - x1;
        double delta0 = (f(x1) - f(x0)) / h0;
        double delta1 = (f(x2) - f(x1)) / h1;
        double d = (delta1 - delta0) / (h1 + h0);
        
        double b = delta1 + h1 * d;
        double D = Math.Sqrt(Math.Pow(b, 2) - 4 * f(x2) * d);
        double E;
        if (Math.Abs(b - D) < Math.Abs(b + D))
            E = b + D;
        else
            E = b - D;
        double h = -2 * f(x2) / E;
        double x3 = x2 + h;

        for (int i = 0; i < maxIter; i++)
        {
            if (Math.Abs(h) < tolerance)
                break;

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
            if (Math.Abs(b - D) < Math.Abs(b + D))
                E = b + D;
            else
                E = b - D;
            h = -2 * f(x2) / E;
            x3 = x2 + h;
        }

        return x3;
    }

    //Inverse Quadratic Interpolation Method
    public double InverseQuadratic(Equation f, double a, double b, double c, int maxIter)
    {
        double x = 0;
        for (int i = 0; i < maxIter; i++)
        {
            double fa = f(a);
            double fb = f(b);
            double fc = f(c);
            double s = (fa * Math.Pow(c, 2) * (b - c)) + (fb * Math.Pow(c, 2) * (c - a)) + (fc * Math.Pow(b, 2) * (a - b));
            double t = (fa * (b - c) * (Math.Pow(c, 2) - Math.Pow(b, 2))) + (fb * (c - a) * (Math.Pow(c, 2) - Math.Pow(a, 2))) + (fc * (a - b) * (Math.Pow(b, 2) - Math.Pow(a, 2)));
            x = (c - ((Math.Pow(c, 2) - Math.Pow(b, 2)) * (fb - fc)) / (2 * t));
            if (Math.Abs(x - c) < tolerance)
                break;
            a = b;
            b = c;
            c = x;
        }

        return x;
    }

    //False Position Method
    public double FalsePosition(double f, double a, double b, int maxIter)
    {

        string message = "False Position Method: ";

        // Local variables
        double c = a;

        for (int i = 0; i < maxIter; i++)
        {
            c = (a * f(b) - b * f(a)) / (f(b) - f(a));

            if (f(c) == 0.0)
                break;

            else if (f(c) * f(a) < 0)
                b = c;
            else
                a = c;
        }

        return message + c;
    }
    public void Main()
    {

        //Bisection Method
        Console.WriteLine(Bisection(eq1, 7.8, 8.4, 100));
        Console.WriteLine(Bisection(eq2, 0, 0.5, 100));
        Console.WriteLine(Bisection(eq3, 3, 5, 100));
        Console.WriteLine(Bisection(eq4, 1, 3, 100));
        Console.WriteLine(Bisection(eq5, -2, 0, 100));

        //Newton Method
        Console.WriteLine(Newton(7, eq1, eq1d, 100));
        Console.WriteLine(Newton(0, eq2, eq2d, 100));
        Console.WriteLine(Newton(3, eq3, eq3d, 100));
        Console.WriteLine(Newton(1, eq4, eq4d, 100));
        Console.WriteLine(Newton(-4, eq5, eq5d, 100));

        //Secant Method
        Console.WriteLine(Secant(eq1, 7, 7.5, 100));
        Console.WriteLine(Secant(eq2, 0, 1, 100));
        Console.WriteLine(Secant(eq3, 3, 4, 100));
        Console.WriteLine(Secant(eq4, 1, 2, 100));
        Console.WriteLine(Secant(eq5, -4, -3, 100));

        //Muller's Method
        Console.WriteLine(Muller(eq1, 7.8, 8.4, 100));
        Console.WriteLine(Muller(eq2, 0, 0.5, 100));
        Console.WriteLine(Muller(eq3, 3, 5, 100));
        Console.WriteLine(Muller(eq4, 1, 3, 100));
        Console.WriteLine(Muller(eq5, -2, 0, 100));

        //Inverse Quadratic Interpolation Method
        Console.WriteLine(InverseQuadratic(eq1, 7, 7.5, 7.75, 100));
        Console.WriteLine(InverseQuadratic(eq2, 0, 1, 0.5, 100));
        Console.WriteLine(InverseQuadratic(eq3, 3, 4, 5, 100));
        Console.WriteLine(InverseQuadratic(eq4, 1, 2, 3, 100));
        Console.WriteLine(InverseQuadratic(eq5, -4, -3, -2, 100));

        //False Position Method
        Console.WriteLine(FalsePosition(eq1, 7.8, 8.4, 100));
        Console.WriteLine(FalsePosition(eq2, 0, 0.5, 100));
        Console.WriteLine(FalsePosition(eq3, 3, 5, 100));
        Console.WriteLine(FalsePosition(eq4, 1, 3, 100));
        Console.WriteLine(FalsePosition(eq5, -2, 0, 100));

    }
}