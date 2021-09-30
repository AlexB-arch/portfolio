using System;

using AppKit;
using Foundation;

namespace SimpleCalculator
{
    public partial class ViewController : NSViewController
    {
        //Default string values for the display.
        string topHalf, bottomHalf;
        const string dash = "\n-------------\n";
        string[] segment;
        int SIZE, segmentIndex;

        public ViewController(IntPtr handle) : base(handle)
        {
        }

        public override void ViewDidLoad()
        {
            base.ViewDidLoad();

            //The display is set to align text to the right through Xcode.
            display.StringValue = dash;
        }

        public override NSObject RepresentedObject
        {
            get
            {
                return base.RepresentedObject;
            }
            set
            {
                base.RepresentedObject = value;
                // Update the view, if already loaded.
            }
        }

        //Methods

        //All Clear Button.
        partial void allClear(NSObject sender)
        {
            if (display.StringValue != dash)
            {
                topHalf = "";
                bottomHalf = "";
                display.StringValue = dash;
            }

            else
                display.StringValue = dash;
        }

        partial void decimalPoint(NSObject sender)
        {
            
            if (topHalf == "")
            {
                topHalf = "0.";
            }

           
            else
                topHalf = topHalf + ".";

            display.StringValue = topHalf + dash;
        }

        partial void positiveNegative(NSObject sender)
        {
            //If there is no numbers prior to the plus sign, default to add a 0, then the sign.
            if (topHalf == "")
            {
                topHalf = "-"+ "0";
            }

            //Else, just add plus sign to the end.
            else
                topHalf = topHalf + "-";

            display.StringValue = topHalf + dash;
        }

        //This section will comprise of the number keys and display interactions.
        partial void one(NSObject sender)
        {
            //If the string is empty, insert number.
            if (topHalf == "")
            {
                topHalf = "1";
            }

            //Else, keep adding numbers to the end.
            else
                topHalf = topHalf + "1";

            display.StringValue = topHalf + dash;
        }

        partial void two(NSObject sender)
        {
            //If the string is empty, insert number.
            if (topHalf == "")
            {
                topHalf = "2";
            }

            //Else, keep adding numbers to the end.
            else
                topHalf = topHalf + "2";

            display.StringValue = topHalf + dash;
        }

        partial void three(NSObject sender)
        {
            //If the string is empty, insert number.
            if (topHalf == "")
            {
                topHalf = "3";
            }

            //Else, keep adding numbers to the end.
            else
                topHalf = topHalf + "3";

            display.StringValue = topHalf + dash;
        }

        partial void four(NSObject sender)
        {
            //If the string is empty, insert number.
            if (topHalf == "")
            {
                topHalf = "4";
            }

            //Else, keep adding numbers to the end.
            else
                topHalf = topHalf + "4";

            display.StringValue = topHalf + dash;
        }

        partial void five(NSObject sender)
        {
            //If the string is empty, insert number.
            if (topHalf == "")
            {
                topHalf = "5";
            }

            //Else, keep adding numbers to the end.
            else
                topHalf = topHalf + "5";

            display.StringValue = topHalf + dash;
        }

        partial void six(NSObject sender)
        {
            //If the string is empty, insert number.
            if (topHalf == "")
            {
                topHalf = "6";
            }

            //Else, keep adding numbers to the end.
            else
                topHalf = topHalf + "6";

            display.StringValue = topHalf + dash;
        }

        partial void seven(NSObject sender)
        {
            //If the string is empty, insert number.
            if (topHalf == "")
            {
                topHalf = "7";
            }

            //Else, keep adding numbers to the end.
            else
                topHalf = topHalf + "7";

            display.StringValue = topHalf + dash;
        }

        partial void eight(NSObject sender)
        {
            //If the string is empty, insert number.
            if (topHalf == "")
            {
                topHalf = "8";
            }

            //Else, keep adding numbers to the end.
            else
                topHalf = topHalf + "8";

            display.StringValue = topHalf + dash;
        }

        partial void nine(NSObject sender)
        {
            //If the string is empty, insert number.
            if (topHalf == "")
            {
                topHalf = "9";
            }

            //Else, keep adding numbers to the end.
            else
                topHalf = topHalf + "9";

            display.StringValue = topHalf + dash;
        }

        partial void zero(NSObject sender)
        {
            //If the string is empty, insert number.
            if (topHalf == "")
            {
                topHalf = "0";
            }

            //Else, keep adding numbers to the end.
            else
                topHalf = topHalf + "0";

            display.StringValue = topHalf + dash;
        }

        //Lastly, code what the operators will do.
        partial void plus(NSObject sender)
        {
            //If there is no numbers prior to the plus sign, default to add a 0, then the sign.
            if (topHalf == "")
            {
                topHalf = "0" + "+";
            }

            //Else, just add plus sign to the end.
            else
                topHalf = topHalf + "+";

            display.StringValue = topHalf + dash;

            segment = topHalf.Split('+');
        }

        partial void minus(NSObject sender)
        {
            //If there is no numbers prior to the minus sign, default to add a 0, then the sign.
            if (topHalf == "")
            {
                topHalf = "0" + "-";
            }

            //Else, just add plus minus to the end.
            else
                topHalf = topHalf + "-";

            display.StringValue = topHalf + dash;
        }

        partial void divide(NSObject sender)
        {
            //If there is no numbers prior to the division sign, default to add a 0, then the sign.
            if (topHalf == "")
            {
                topHalf = "0" + "/";
            }

            //Else, just add division sign to the end.
            else
                topHalf = topHalf + "/";

            display.StringValue = topHalf + dash;
        }

        partial void multiply(NSObject sender)
        {
            //If there is no numbers prior to the multiplication sign, default to add a 0, then the sign.
            if (topHalf == "")
            {
                topHalf = "0" + "*";
            }

            //Else, just add multiplication sign to the end.
            else
                topHalf = topHalf + "*";

            display.StringValue = topHalf + dash;

            
        }

        partial void equals(NSObject sender)
        {
            segment = topHalf.Split('*', '/', '+', '-');
            bottomHalf = segment.ToString();
            
            //Equals will populate the bottom half after the method calculates the top half
           /* if (bottomHalf == "")
            {
               
            }

            //Else, just add plus sign to the end.
            else
                bottomHalf = //method.

            display.StringValue = topHalf + dash + bottomHalf;*/

            /* NOTE: follow the standard PEMDAS order of operations.
                From left to right:
                * Multiplication
                / Division
                % Remainder
                + Addision
                - Substraction
            Scan the string until you hit an operator, then scan the other side
            until you find the next operator. */

        }
    }
}
