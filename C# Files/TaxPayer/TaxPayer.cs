using System;

class TaxPayer
{
    //Global attributes for the tax payer class.
    string ssn;
    double yrGrInc = 0, taxOwed = 0;

    public TaxPayer(string social, double income)
    {
        ssn = social;
        yrGrInc = income;
    }

    //Returns yearly income based on user input.
    public double getGrossIncome()
    {
        return yrGrInc;
    }

    //Calculates taxes based on yearly income input.
    public double getTaxOwed()
    {
        const double under30k = 0.15;
        const double over30k = 0.28;

        if (yrGrInc < 30000)
        {
            taxOwed = yrGrInc * under30k;
        }

        if (yrGrInc >= 30000)
        {
            taxOwed = yrGrInc * over30k;
        }
        return taxOwed;
    }

    //Prints tax information for the constructed tax payer.
    public void print()
    {
        
        Console.WriteLine("SSN: {0}", ssn);
        Console.WriteLine("Income: ${0}", getGrossIncome().ToString("F2"));
        Console.Write("Tax owed: ${0}", getTaxOwed().ToString("F2"));
    }
}