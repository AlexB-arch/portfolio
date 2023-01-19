// WARNING
//
// This file has been generated automatically by Visual Studio to store outlets and
// actions made in the UI designer. If it is removed, they will be lost.
// Manual changes to this file may not be handled correctly.
//
using Foundation;
using System.CodeDom.Compiler;

namespace InterfaceTest
{
	[Register ("ViewController")]
	partial class ViewController
	{
		[Outlet]
		AppKit.NSButton buttonOne { get; set; }

		[Outlet]
		AppKit.NSTextFieldCell textField { get; set; }

		[Action ("buttponOneClick:")]
		partial void buttponOneClick (Foundation.NSObject sender);
		
		void ReleaseDesignerOutlets ()
		{
			if (textField != null) {
				textField.Dispose ();
				textField = null;
			}

			if (buttonOne != null) {
				buttonOne.Dispose ();
				buttonOne = null;
			}
		}
	}
}
