using System;

abstract class Shape
{
    //Attribute to be inherited only within the class.
    protected string color;

    //Base Class methods and properties.
    public abstract string getColor();
    public abstract void setColor(string color);
    public abstract void move(params double[] moves);
    public abstract double area();
    public abstract double perimeter();
    public abstract string render();
}

class Box : Shape
{
    //Native attributes for a Box shape.
    //Coordinate points
    double top, bottom, left, right;

    //Methods native to the Box shape.
    //Get/Set methods for top, bottom, left, and right are coordinates, not size.
    public double getTop()
    {
        return top;
    }

    public void setTop(double top)
    {
        this.top = top;
    }

    public double getBottom()
    {
        return bottom;
    }

    public void setBottom(double bottom)
    {
        this.bottom = bottom;
    }

    public double getLeft()
    {
        return left;
    }

    public void setLeft(double left)
    {
        this.left = left;
    }

    public double getRight()
    {
        return right;
    }

    public void setRight(double right)
    {
        this.right = right;
    }

    //Inherited methods.
    public override string getColor()
    {
        return color;
    }

    public override void setColor(string color)
    {
        this.color = color;
    }

    //Sets new coordinates for the box shape.
    public override void move(params double[] moves)
    {
            left += moves[0];
            top += moves[0];
            right += moves[1];
            bottom += moves[1];
    }

    //Calculates the surface area of a box.
    public override double area()
    {
        //Reduces the points to width and height only.
        double width = left - right;
        double height = top - bottom;

        return height * width;
    }

    //Calculates the perimeter of a box.
    public override double perimeter()
    {
        //Reduces the points to width and height only.
        double width = left - right;
        double height = top - bottom;

        return 2 * (height + width);
    }

    //Returns the shape's information.
    public override string render()
    {
        return "Box(" + color + "," + left + "," + top + "," + right + "," + bottom + ")";
    }

    //Constructors
    public Box()
    {
        //Default. Left empty on purpose.
    }

    public Box(string color, double left, double top, double right, double bottom)
    {
        setColor(color);
        setLeft(left);
        setTop(top);
        setRight(right);
        setBottom(bottom);
    }
}

class Circle : Shape
{
    //Native class attributes.
    double X, Y, radius;

    //Native class methods.
    public double getCenterX()
    {
        return X;
    }

    public double getCenterY()
    {
        return Y;
    }

    public double getRadius()
    {
        return radius;
    }

    public void setCenterX(double X)
    {
        this.X = X;
    }

    public void setCenterY(double Y)
    {
        this.Y = Y;
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    //Inherited methods.
    public override string getColor()
    {
        return color;
    }

    public override void setColor(string color)
    {
        this.color = color;
    }

    public override void move(params double[] moves)
    {
            X += moves[0];
            Y += moves[1];
    }

    //Calculates area of a circle as A = pi * radius^2
    public override double area()
    {
        return Math.PI * Math.Pow(radius, 2);
    }

    public override double perimeter()
    {
        return 2 * Math.PI * radius;
    }

    public override string render()
    {
        return "Circle(" + color + "," + X + "," + Y + "," + radius + ")";
    }

    //Constructors
    public Circle()
    {
        //Default. Left empty on purpose.
    }

    public Circle(string color, double X, double Y, double radius)
    {
        setColor(color);
        setCenterX(X);
        setCenterY(Y);
        setRadius(radius);
    }
}

class Triangle : Shape
{
    //Native Attributes
    double X1, X2, X3, Y1, Y2, Y3;

    //Native Methods
    public double getCornerX1()
    {
        return X1;
    }

    public double getCornerX2()
    {
        return X2;
    }

    public double getCornerX3()
    {
        return X3;
    }

    public double getCornerY1()
    {
        return Y1;
    }

    public double getCornerY2()
    {
        return Y2;
    }

    public double getCornerY3()
    {
        return Y3;
    }

    public void setCornerX1(double X1)
    {
        this.X1 = X1;
    }

    public void setCornerX2(double X2)
    {
        this.X2 = X2;
    }

    public void setCornerX3(double X3)
    {
        this.X3 = X3;
    }

    public void setCornerY1(double Y1)
    {
        this.Y1 = Y1;
    }

    public void setCornerY2(double Y2)
    {
        this.Y2 = Y2;
    }

    public void setCornerY3(double Y3)
    {
        this.Y3 = Y3;
    }

    //Inherited Methods.
    public override string getColor()
    {
        return color;
    }

    public override void setColor(string color)
    {
        this.color = color;
    }

    public override void move(params double[] moves)
    {
            X1 += moves[0];
            Y1 += moves[1];
            X2 += moves[0];
            Y2 += moves[1];
            X3 += moves[0];
            Y3 += moves[1];
    }

    public override double area()
    {
        double Area;

        Area = Math.Abs((X1 - X3) * (Y2 - Y1) - (X1 - X2) * (Y3 - Y1))/2;

        return Area;
    }

    public override double perimeter()
    {
        double AB, BC, CA;

        AB = (Math.Pow(X3 - X2, 2) + Math.Pow(Y1 - Y3, 2));
        BC = (Math.Pow(X2 - X1, 2) + Math.Pow(Y3 - Y2, 2));
        CA = (Math.Pow(X1 - X3, 2) + Math.Pow(Y2 - Y1, 2));


        return (AB + BC + CA);
    }

    public override string render()
    {
        return "Triangle(" + color + "," + X1 + "," + X2 + "," + X3 + "," + Y1 + "," + Y2 + "," + Y3 + ")";
    }

    //Constructors.
    public Triangle()
    {
        //Left empty on purpose.
    }

    public Triangle(string color, double X1, double X2, double X3, double Y1, double Y2, double Y3)
    {
        setColor(color);
        setCornerX1(X1);
        setCornerX2(X2);
        setCornerY3(Y3);
    }
}

class Polygon : Shape
{
    //Native attributes.
    double[] X, Y;
    int numPoints;

    //Native Methods.
    public int getNumpoints()
    {
        return numPoints;
    }

    public void setNumPoints(int value)
    {
        numPoints = value;
    }

    public double getVertexX(int i)
    {
        return X[i];
    }

    public double getVertexY(int i)
    {
        return Y[i];
    }

    public void setVertexX(int index, double points)
    {
        X[index] = points;
    }

    public void setVertexY(int index, double points)
    {
        Y[index] = points;
    }

    //Inherited Methods.
    public override string getColor()
    {
        return color;
    }

    public override void setColor(string color)
    {
        this.color = color;
    }

    public override double area()
    {
        //A= 1/2 The sum of (x[i]y[i]+1)-(x[i]+1y[i])
        double A = 0;

        for (int i = 0; i < numPoints - 1; i++)
        {
            A += X[i] * Y[i + 1] - (Y[i] * X[i + 1]);
        }

        A += X[X.Length - 1] * Y[0] - (Y[Y.Length - 1] * X[0]);

        return Math.Abs(A/2);
    }

    public override double perimeter()
    {
        double P = 0;

        for (int i = 0; i < numPoints - 1; i++)
        {
            P += Math.Sqrt(Math.Pow(X[i + 1] - X[i], 2) + Math.Pow(Y[i + 1] - Y[i], 2));
        }

        P += Math.Sqrt(Math.Pow(X[X.Length - 1] - Y[0], 2) + Math.Pow(Y[Y.Length - 1] - X[0], 2));

        return P;
    }

    public override void move(params double[] moves)
    {
        for(int i = 0; i < X.Length; i++)
        {
            X[i] += moves[0];   
        }

        for (int j = 0; j < Y.Length; j++)
        {
            Y[j] += moves[1];
        }
    }

    public override string render()
    {
        string output = "Polygon(" + color + "," + numPoints;

        for(int i = 0; i < numPoints; i++)
        {
           output += "," + getVertexX(i) + "," + getVertexY(i);
        }

        output += ")";

        return output;
    }

    //Constructors
    public Polygon()
    {
        //Left empty on purpose.
    }

    public Polygon(string color, double[] points, int numPoints)
    {
        setColor(color);
        setNumPoints(numPoints);
        X = new double[numPoints];
        Y = new double[numPoints];

        for (int i = 0; i < numPoints; i++)
        {
            setVertexX(i, points[2 * i]);
            setVertexY(i, points[2 * i + 1]);
        }
    }
}