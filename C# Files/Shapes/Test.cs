using System;

class TestShape
{
    public static void Main(string[] args)
    {
        int count = 0;
        double[] pts = { 1, 1, 7, 2, 3, 5, 6, 8, 4, 3 };
        Shape[] list = new Shape[100];

        list[count++] = new Box("BLUE", 0, 1, 1, 0);
        list[count++] = new Box("CYAN", 2, 9, 4, 3);
        list[count++] = new Circle("WHITE", 5, 5, 3);
        list[count++] = new Triangle("BLACK", 1, 1, 5, 1, 3, 3);
        list[count++] = new Polygon("GREEN", pts, 5);

        double distance = 0;
        double area = 0;
        string str = "";

        for (int i = 0; i < count; i++)
        {
            distance += list[i].perimeter();
            area += list[i].area();
            str += list[i].render();
            str += "\n";
        }

        for (int i = 0; i < count; i++)
        {
            list[i].move(10, 10);
            str += list[i].render();
            str += "\n";
        }

        Console.WriteLine("distance: {0:F4} area: {1:F4}", distance, area);
        Console.WriteLine("{0}", str);
    }
}