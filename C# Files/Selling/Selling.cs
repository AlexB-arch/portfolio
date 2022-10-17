using System;
class SalespersonDemo
{
    public static void Main()
    {
        RealEstateSalesperson diane = new RealEstateSalesperson("Diane", "Kendall", 0.06);
        GirlScout mandy = new GirlScout("Mandy", "Hernandez");
        diane.SalesSpeech();
        mandy.SalesSpeech();
        diane.MakeSale(100000);
        diane.MakeSale(150000);
        mandy.MakeSale(2);
        mandy.MakeSale(10);
        mandy.MakeSale(4);
        Console.WriteLine("{0} sold {1} worth of real estate",
           diane.GetName(), diane.TotalValueSold.ToString("C0"));
        Console.WriteLine("At {0}%, the total commission earned is {1}",
           diane.CommissionRate * 100,
           diane.TotalCommissionEarned.ToString("C"));
        Console.WriteLine();
        Console.WriteLine("{0} sold {1} boxes of cookies",
           mandy.GetName(), mandy.TotalBoxes);

    }
}