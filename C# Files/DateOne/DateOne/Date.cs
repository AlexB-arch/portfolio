using System;

class Date
{
    //Attributes
    private int day, month, year;

    //Properties
    public int Day
    {
        get { return day; }

        set
        {
            //Prints error message if day is out of range.
            if (value < 1 || value > 31)
                Console.WriteLine("Invalid day");

            else
                day = value;
        }

    }

    public int Month
    {
        get { return month; }

        set
        {
            //Prints error message if month is out of range.
            if (value < 1 || value > 12)
                Console.WriteLine("Invalid month");

            else
                month = value;
        }

    }

    public int Year
    {
        get { return year; }

        set
        {
            //Converts the year to string and evaluate length.
            if (Convert.ToString(value).Length < 4)
                Console.WriteLine("Year must be 4 digits");

            else
                year = value;
        }
    }

    //Date Format methods.
    public string DisplayUSFormat()
    {
        //Converts the year to string and evaluate length.
        if (Convert.ToString(Year).Length < 4)
            return "Invalid date";

        else
            return Month.ToString("D2") + "/" + Day.ToString("D2") + "/" + Year.ToString("D4");
    }

    public string DisplayIntlFormat()
    {
        //Converts the year to string and evaluate length.
        if (Convert.ToString(Year).Length < 4)
            return "Invalid date";

        else
            return Year.ToString("D4") + "-" + Month.ToString("D2") + "-" + Day.ToString("D2");
    }

    //Default Constructor
    public Date()
    {
        //Left empty on purpose
    }

    //Constructor with month/day/year format.
    public Date(int Month, int Day, int Year)
    {
        //Prints error message if day is out of range.
        if ( Day < 1 || Day > 31)
            Console.WriteLine("Invalid day");

        //Prints error message if month is out of range.
        if (Month < 1 || Month > 12)
            Console.WriteLine("Invalid month");

        //Converts the year to string and evaluate length.
        if (Convert.ToString(Year).Length < 4)
            Console.WriteLine("Year must be 4 digits");

        /*This text only outputs if the values are assigned
         * through the constructor parameters, not the properties.
         */
        
    }

    public static bool operator == (Date a, Date b)
    {
        if ((a.Year == b.Year) && (a.Month== b.Month) && (a.Day == b.Day))
            return true;

        return false;
    }

    public static bool operator !=(Date a, Date b)
    {
        if (a.Year != b.Year && a.Month != b.Month && a.Day != b.Day)
            return true;

        return false;
    }

    public static bool operator < (Date a, Date b)
    {
        if (a.Year < b.Year)
            return true;

        else if (a.Year == b.Year && a.Month < b.Month)
            return true;

        else if (a.Year == b.Year && a.Month == b.Month && a.Day < b.Day && (a.Day > 31 || a.Day < 1))
            return true;

        return false;
    }

    public static bool operator > (Date a, Date b)
    {
        if (a.Year > b.Year)
            return true;

        else if (a.Year == b.Year && a.Month > b.Month)
            return true;

        else if (a.Year == b.Year && a.Month == b.Month && a.Day > b.Day && (a.Day > 31 || a.Day < 1))
            return true;

        return false;
    }

    public static bool operator >= (Date a, Date b)
    {
        if (a.Year >= b.Year && a.Month >= b.Month && a.Day >= b.Day)
            return true;

        else if (a.Month >= b.Month)
            return a.Month >= b.Month;

        else if (a.Day >= b.Day)
            return a.Day >= b.Day;

        else
            return false;
    }

    public static bool operator <= (Date a, Date b)
    {
        if (a.Year <= b.Year)
            return a.Year <= b.Year;

        else if (a.Month <= b.Month)
            return a.Month <= b.Month;

        else if (a.Day <= b.Day)
            return a.Day <= b.Day;

        else
            return false;
    }

    public override bool Equals(Object obj)
    {
        return false;
    }

    public override int GetHashCode()
    {
        return 0;
    }
}