// WARNING
//
// This file has been generated automatically by Visual Studio to store outlets and
// actions made in the UI designer. If it is removed, they will be lost.
// Manual changes to this file may not be handled correctly.
//
using Foundation;
using System.CodeDom.Compiler;

namespace TicTacToe
{
	[Register ("ViewController")]
	partial class ViewController
	{
		[Outlet]
		AppKit.NSButton box00 { get; set; }

		[Outlet]
		AppKit.NSButton box01 { get; set; }

		[Outlet]
		AppKit.NSButton box02 { get; set; }

		[Outlet]
		AppKit.NSButton box10 { get; set; }

		[Outlet]
		AppKit.NSButton box11 { get; set; }

		[Outlet]
		AppKit.NSButton box12 { get; set; }

		[Outlet]
		AppKit.NSButton box20 { get; set; }

		[Outlet]
		AppKit.NSButton box21 { get; set; }

		[Outlet]
		AppKit.NSButton box22 { get; set; }

		[Outlet]
		AppKit.NSTextField MatchOutcome { get; set; }

		[Outlet]
		AppKit.NSTextField OWinrate { get; set; }

		[Outlet]
		AppKit.NSTextField PlayerTurn { get; set; }

		[Outlet]
		AppKit.NSTextField XWinrate { get; set; }

		[Action ("Box00:")]
		partial void Box00 (Foundation.NSObject sender);

		[Action ("Box01:")]
		partial void Box01 (Foundation.NSObject sender);

		[Action ("Box02:")]
		partial void Box02 (Foundation.NSObject sender);

		[Action ("Box10:")]
		partial void Box10 (Foundation.NSObject sender);

		[Action ("Box11:")]
		partial void Box11 (Foundation.NSObject sender);

		[Action ("Box12:")]
		partial void Box12 (Foundation.NSObject sender);

		[Action ("Box20:")]
		partial void Box20 (Foundation.NSObject sender);

		[Action ("Box21:")]
		partial void Box21 (Foundation.NSObject sender);

		[Action ("Box22:")]
		partial void Box22 (Foundation.NSObject sender);

		[Action ("image_Click:")]
		partial void image_Click (Foundation.NSObject sender);

		[Action ("PlayAgainButton:")]
		partial void PlayAgainButton (Foundation.NSObject sender);

		[Action ("ResetButton:")]
		partial void ResetButton (Foundation.NSObject sender);
		
		void ReleaseDesignerOutlets ()
		{
			if (MatchOutcome != null) {
				MatchOutcome.Dispose ();
				MatchOutcome = null;
			}

			if (OWinrate != null) {
				OWinrate.Dispose ();
				OWinrate = null;
			}

			if (PlayerTurn != null) {
				PlayerTurn.Dispose ();
				PlayerTurn = null;
			}

			if (XWinrate != null) {
				XWinrate.Dispose ();
				XWinrate = null;
			}

			if (box00 != null) {
				box00.Dispose ();
				box00 = null;
			}

			if (box01 != null) {
				box01.Dispose ();
				box01 = null;
			}

			if (box02 != null) {
				box02.Dispose ();
				box02 = null;
			}

			if (box10 != null) {
				box10.Dispose ();
				box10 = null;
			}

			if (box11 != null) {
				box11.Dispose ();
				box11 = null;
			}

			if (box12 != null) {
				box12.Dispose ();
				box12 = null;
			}

			if (box20 != null) {
				box20.Dispose ();
				box20 = null;
			}

			if (box21 != null) {
				box21.Dispose ();
				box21 = null;
			}

			if (box22 != null) {
				box22.Dispose ();
				box22 = null;
			}
		}
	}
}
