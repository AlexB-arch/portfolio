using System;

using AppKit;
using Foundation;

namespace InterfaceTest
{
    public partial class ViewController : NSViewController
    {
        public ViewController(IntPtr handle) : base(handle)
        {
        }

        public override void ViewDidLoad()
        {
            base.ViewDidLoad();

            // Do any additional setup after loading the view.
            textField.StringValue = "";
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

        partial void buttponOneClick(Foundation.NSObject sender)
        {
            if (textField.StringValue == "")
                textField.StringValue = "Hello World";

            else
                textField.StringValue = "";
        }
    }
}
