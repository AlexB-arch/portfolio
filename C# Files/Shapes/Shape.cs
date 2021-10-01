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
        left = moves[0];
        top = moves[1];
        right = moves[2];
        bottom = moves[3];
    }

    //Calculates the surface area of a box.
    public override double area()
    {
        //Reduces the points to width and height only.
        double width = right - left;
        double height = top - bottom;

        return height * width;
    }

    //Calculates the perimeter of a box.
    public override double perimeter()
    {
        //Reduces the points to width and height only.
        double width = right - left;
        double height = top - bottom;

        return (2 * width) + (2 * height);
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

    public override void move(params double[] moves)
    {
        X = moves[0];
        Y = moves[1];
        radius = moves[2];
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

    //Calculates area of a circle as A = pi * radius^2
    public override double area()
    {
        return Math.PI * (radius * radius);
    }

    public override double perimeter()
    {
        return 0;
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
        //Left empty on purpose.
    }

    public override double area()
    {
        return 0;
    }

    public override double perimeter()
    {
        return 0;
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
        setCornerX3(X3);
        setCornerY1(Y1);
        setCornerY2(Y2);
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

    public double getVertexX(int index)
    {
        return X[index];
    }

    public double getVertexY(int index)
    {
        return Y[index];
    }

    public void setVertexX(int index, double x)
    {
        X[index] = x;
    }

    public void setVertexY(int index, double y)
    {
        Y[index] = y;
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
        return 0;
    }

    public override double perimeter()
    {
        return 0;
    }

    public override void move(params double[] moves)
    {
        //Blank for testing.
    }

    public override string render()
    {
        return "";
    }

    //Constructors
    public Polygon()
    {
        //Left empty on purpose.
    }

    public Polygon(string color, double[] points, int numPoints)
    {
        setColor(color);
        this.numPoints = numPoints;
        X = new double[numPoints];
        Y = new double[numPoints];
    }
}