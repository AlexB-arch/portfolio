using System;

class Student
{
    //Attributes
    private int id;
    private string name;
    private string hairColor;

    //Constructor
    public Student()
    {
        Console.WriteLine("Student Constructor");
    }

    //Propieties.
    public int Id
    {
        get
        {
            return id;
        }
        set
        {
            id = value;
        }
    }
    public string Name
    {
        get
        {
            return name;
        }
        set
        {
            name = value;
        }
    }
    public string Hair
    {
        get
        {
            return hairColor;
        }
        set
        {
            hairColor = value;
        }
    }
    public void greeting()
    {
        Console.WriteLine("Hello {0}", name);
    }
}

//Derived classes are typed like this.
class ComputerScienceStudent : Student
{

    //Derived constructor.
    public ComputerScienceStudent()
    {
        Console.WriteLine("CompSci student constructor");
    }
}

    class Program
{
    static void Main(string[] args)
    {
        Student firstStudent = new Student();
        firstStudent.Name = "Lucian";
        firstStudent.greeting();

        ComputerScienceStudent Alex = new ComputerScienceStudent();
            Alex.Name = "Obviously Alex";
            Alex.greeting();
    }
}