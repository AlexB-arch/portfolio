using System;

public abstract class Salesperson
{
    //Parent class attributes.
    private string first;
    private string last;

    //Default constructor.
    public Salesperson()
    {
    
    }

    //Concatenates both strings to print full name.
    public string GetName()
    {
        return first + " " + last;
    }

    //Sets first name.
    public void setFirst(string value)
    {
        first = value;
    }

    //Sets last name.
    public void setLast(string value)
    {
        last = value;
    }
}

//Interfaces to be used by different sales people.
public interface ISellable
{
    void SalesSpeech();
    void MakeSale(int sale);
}

//Child classes can only use one parent class, but many interfaces.
public class RealEstateSalesperson : Salesperson, ISellable
{
    //Local attributes to track Realtor's sales.
    public int TotalValueSold = 0;
    public double CommissionRate = 0;
    public double TotalCommissionEarned = 0;

    //Local constructor.
    public RealEstateSalesperson(string firstName, string lastName, double rate)
    {
        //Sets full name using both setters, and gets the commission rate from user input.
        setFirst(firstName);
        setLast(lastName);
        CommissionRate = rate;
    }

    //Interfaces do not require override.
    public void SalesSpeech()
    {
        Console.WriteLine("This property will double in value in the next ten years\n" +
            "Buy it now or regret it forever.\n");
    }

    //Adds total every time method is called, then calculates commission.
    public void MakeSale(int amount)
    {
        TotalValueSold += amount;
        TotalCommissionEarned = CommissionRate * TotalValueSold;
    }
}

//Child classes can only use one parent class, but many interfaces.
public class GirlScout : Salesperson, ISellable
{
    //Local attribute to calculate boxes sold.
    public int TotalBoxes = 0;

    //Local constructor.
    public GirlScout(string firstName, string lastName)
    {
        //Sets full name using both setters.
        setFirst(firstName);
        setLast(lastName);
    }

    //Interfaces do not require override.
    public void SalesSpeech()
    {
        Console.WriteLine("Would you like to buy some cookies?\n" +
            "They are delicious and they help us go to camp.\n");
    }

    public void MakeSale(int amount)
    {
        //Adds total every time method is called.
        TotalBoxes += amount;     
    }
}