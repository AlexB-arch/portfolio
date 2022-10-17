// Do not use namespace
class Car
{

   //Declare all attributes here.
    private int idNumber;
    private string make;
    private string model;
    private string color;
    private double value;

    //Declare methods here.
    public int getIdNumber()
    {
        return idNumber;
    }
    public void setIdNumber(int id)
    {
        idNumber = id;
    }
    public string getMake()
    {
        return make;
    }
    public void setMake(string new_make)
    {
        make = new_make;
    }
    public string getColor()
    {
        return color;
    }
    public void setColor(string new_color)
    {
        color = new_color;
    }
    public string getModel()
    {
        return model;
    }
    public void setModel(string new_model)
    {
        model = new_model;
    }
    public double getValue()
    {
        return value;
    }
    public void setValue(double new_value)
    {
        value = new_value; 
    }

    // Default constructor.
    public Car()
    {
        
    }

    //Create another constructor as described below here (Step 3).
    public Car(int car_number, string car_make, string car_model, string car_color, double car_value)
    {
        setIdNumber(car_number);
        setMake(car_make);
        setModel(car_model);
        setColor(car_color);
        setValue(car_value);
    }

    // When finished save this file as Car.cs
}