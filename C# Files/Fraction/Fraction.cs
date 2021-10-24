using System;
class Fraction
{
    private int whole;
    private int numerator;
    private int denominator;


    //Default constructor.
    public Fraction()
    {

    }

    //Constructor that accepts numerator and denominator.
    public Fraction(int numerator, int denominator)
    {
        if (denominator == 0)
            Console.WriteLine("");

        this.numerator = numerator;
        this.denominator = denominator;
    }


    //Constructor that accepts numerator, denominator, and whole.
    public Fraction(int who, int num, int den)
    {
        whole = who;
        numerator = num;
        denominator = den;
    }

    //Calculates greatest common divisor (GCD)
    int GCD(int a, int b)
    {
        if (b == 0)
            return a;

        return GCD(b, a % b);
    }

    public void Reduce()
    {
        if (denominator != 0)
        {
            whole += numerator / denominator;

            if (numerator % denominator != 0)
            {
                numerator = numerator % denominator;
            }
        }

        /*if(numerator > 0 && denominator == 0)
        {
            whole += numerator;
        }*/

    }

    // Add the two given Fractions, return the result as a new Fraction.
    public static Fraction operator +(Fraction a, Fraction b)
    {
        Fraction c = new Fraction();

        if (a.whole > 0 || b.whole > 0)
        {
            //Check and convert mixed fractions
            if (a.whole > 0 && b.whole == 0)
            {
                a.numerator = (a.whole * a.denominator) + a.numerator;
            }

            if (a.whole == 0 && b.whole > 0)
            {
                b.numerator = (b.whole * b.denominator) + b.numerator;
            }
        }

        //Easiest way to find the sum is (ad + bc) / (b)(d)
        //Step 1:
        c.numerator = (a.numerator * b.denominator) + (a.denominator * b.numerator);

        //Step 2:
        c.denominator = a.denominator * b.denominator;

        //Step 3:
        c.Reduce();
        
        return c;
    }

    // Subtract b from a, return the result as a new Fraction (reduced, of course)
    public static Fraction operator -(Fraction a, Fraction b)
    {
        Fraction c = new Fraction();

        if (a.whole > 0 || b.whole > 0)
        {
            c.whole = a.whole * b.whole;

            //Check and convert mixed fractions
            if(a.whole > 0 && b.whole == 0)
            {
                c.numerator = (a.whole * a.denominator) - a.numerator;
            }

            if(a.whole == 0 && b.whole > 0)
            {
                c.numerator = (b.whole * b.denominator) - b.numerator;
            }
        }

        if (a.denominator != b.denominator)
        {
            //Easiest way to find substraction is (ad - bc) / (b)(d)
            //Step 1:

            c.numerator = (a.numerator * b.denominator) - (a.denominator * b.numerator);

            //Step 2:
            c.denominator = a.denominator * b.denominator;


            //Step 3:
            c.Reduce();
        }

        if (a.denominator == b.denominator)
        {
            //Step 1:
            c.numerator = (a.numerator - b.numerator)/ b.denominator;

            //Step 2:
            c.Reduce();
        }

        return c;
    }

    // Multiply the two given Fractions, return the result as a new Fraction (reduced, of course)
    public static Fraction operator *(Fraction a, Fraction b)
    {
        Fraction c = new Fraction();

        if (a.whole > 0 || b.whole > 0)
        {
            if (a.whole != 0 && b.whole > 0)
                c.whole = a.whole * b.whole;

            if (a.whole > 0 && b.whole != 0)
                c.whole = a.whole * b.whole;
        }

        //Step 1:
        c.numerator = a.numerator * b.numerator;

        //Step 2:
        c.denominator = a.denominator * b.denominator;

        //Step 3:
        c.Reduce();

        
        //Simply further.
        int simp = c.GCD(c.numerator, c.denominator);

        if (c.numerator / simp != 0 && c.numerator != 0)
        {
            if(simp == 0)
            {
                c.numerator = c.numerator / c.denominator;
            }

            else
                c.numerator /= simp;
        }

        if (c.denominator / simp != 0)
            c.denominator /= simp;

        return c;
    }

    // Divide given Fractions (a/b), return the result as a new Fraction (reduced, of course)
    // You may assume that b will be a non-zero value
    public static Fraction operator /(Fraction a, Fraction b)
    {
        Fraction c = new Fraction();

        if (a.whole > 0 || b.whole > 0)
        {
            if(a.whole != 0 && b.whole > 0)
                c.whole = a.whole / b.whole;

            if (a.whole > 0 && b.whole != 0)
                c.whole = a.whole / b.whole;
        }

        //Step 1:
        c.numerator = a.numerator * b.denominator;

        //Step 2:
        c.denominator = a.denominator * b.numerator;

        //Step 3:
        c.Reduce();

        //Simply further.
        int simp = c.GCD(c.numerator, c.denominator);

        if (c.numerator / simp != 0 && c.numerator != 0)
        {
            if (simp == 0)
            {
                c.numerator = c.numerator / c.denominator;
            }

            else
                c.numerator /= simp;
        }

        if (c.denominator / simp != 0)
            c.denominator /= simp;

        return c;
    }

    //Prints out the fraction as Whole Numerator/Denominator.
    public string Display()
    {
        if (whole > 0 && numerator >= denominator)
        {
            return whole.ToString();
        }

        else if (whole > 0 && numerator != denominator)
        {
            return whole.ToString() + " " + numerator.ToString() + "/" + denominator.ToString();
        }

        else if(whole > 0 && numerator == 0)
        {
            return whole.ToString();
        }

        else if (whole == 0 && numerator > denominator && denominator != 0)
        {
            return (numerator / denominator).ToString();
        }

        else
            return numerator.ToString() + "/" + denominator.ToString();
    }
}
