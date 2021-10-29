// WARNING
//
// This file has been generated automatically by Visual Studio to store outlets and
// actions made in the UI designer. If it is removed, they will be lost.
// Manual changes to this file may not be handled correctly.
//
using Foundation;
using System.CodeDom.Compiler;

namespace SimpleCalculator
{
	[Register ("ViewController")]
	partial class ViewController
	{
		[Outlet]
		AppKit.NSTextField display { get; set; }

		[Action ("allClear:")]
		partial void allClear (Foundation.NSObject sender);

		[Action ("decimalPoint:")]
		partial void decimalPoint (Foundation.NSObject sender);

		[Action ("divide:")]
		partial void divide (Foundation.NSObject sender);

		[Action ("eight:")]
		partial void eight (Foundation.NSObject sender);

		[Action ("equals:")]
		partial void equals (Foundation.NSObject sender);

		[Action ("five:")]
		partial void five (Foundation.NSObject sender);

		[Action ("four:")]
		partial void four (Foundation.NSObject sender);

		[Action ("minus:")]
		partial void minus (Foundation.NSObject sender);

		[Action ("multiply:")]
		partial void multiply (Foundation.NSObject sender);

		[Action ("nine:")]
		partial void nine (Foundation.NSObject sender);

		[Action ("one:")]
		partial void one (Foundation.NSObject sender);

		[Action ("percent:")]
		partial void percent (Foundation.NSObject sender);

		[Action ("plus:")]
		partial void plus (Foundation.NSObject sender);

		[Action ("positiveNegative:")]
		partial void positiveNegative (Foundation.NSObject sender);

		[Action ("seven:")]
		partial void seven (Foundation.NSObject sender);

		[Action ("six:")]
		partial void six (Foundation.NSObject sender);

		[Action ("three:")]
		partial void three (Foundation.NSObject sender);

		[Action ("two:")]
		partial void two (Foundation.NSObject sender);

		[Action ("zero:")]
		partial void zero (Foundation.NSObject sender);
		
		void ReleaseDesignerOutlets ()
		{
			if (display != null) {
				display.Dispose ();
				display = null;
			}
		}
	}
}
