using System;

using AppKit;
using Foundation;

namespace ConnectFour
{
    interface Winner
    {
        //find winner in column c going up starting from (r,c)
        bool straightup(int r, int c);
        //find winner in column c going down starting from (r,c)
        bool straightdown(int r, int c);
        //find a winner in row r going left starting from (r,c)
        bool left(int r, int c);
        //find a winner in row r going right starting from (r,c)
        bool right(int r, int c);
        //find a winner in diagonal left going up starting from (r,c)
        bool diagleftup(int r, int c);
        //find a winner in diagonal right going down starting from(r, c)
        bool diagrightdown(int r, int c);
        //find a winner in diagonal left going down starting from(r, c)
        bool diagleftdown(int r, int c);
        //find a winner in diagonal right going up starting from(r, c)
        bool diagrightup(int r, int c);
        //return true if there is winner this function should use the previous one
        bool winner(int r, int c);
    }

    public partial class ViewController : NSViewController, Winner
    {
        //Declares the 6x7 grid for the game.
        NSButton[,] grid;

        //Tracks the size of each column.
        int x0, x1, x2, x3, x4, x5, x6;

        //Tracks stats of players
        int xWins, oWins, connectFourO, connectFourX, totalGames;
        double winrateX, winrateO;


        //Images are stored here for convenience
        NSImage imageX = NSImage.ImageNamed("imageX");
        NSImage imageO = NSImage.ImageNamed("imageO");

        //Cascader will make the scrolling "animation"
        public void Cascader(int x, int y)
        {
            if (PlayerTurnField.StringValue.Equals("X") && grid[x, y].Image == null)
            {
                grid[x, y].Image = imageX;
            }

            else if(PlayerTurnField.StringValue.Equals("O") && grid[x, y].Image == null)
            {
                grid[x, y].Image = imageO;
            } 
        }

        public ViewController(IntPtr handle) : base(handle)
        {
            
        }

        public override void ViewDidLoad()
        {
            base.ViewDidLoad();

            //Moves will be tracked in a 6x7 grid.
            //interpret the grid below from an upside down perspetive.
            grid = new NSButton[,]
            {
                {x0y0, x0y1, x0y2, x0y3, x0y4, x0y5, x0y6},
                {x1y0, x1y1, x1y2, x1y3, x1y4, x1y5, x1y6},
                {x2y0, x2y1, x2y2, x2y3, x2y4 ,x2y5, x2y6},
                {x3y0, x3y1, x3y2, x3y3, x3y4, x3y5, x3y6},
                {x4y0, x4y1, x4y2, x4y3, x4y4, x4y5, x4y6}, 
                //-----------------------------------------
                {x5y0, x5y1, x5y2, x5y3, x5y4, x5y5, x5y6}
                //-----------------------------------------
                //Row of clickable tiles.
            };

            // Do any additional setup after loading the view.
            PlayerTurnField.StringValue = "X";
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

        //Interface implementation starts here

        //find winner in column c going up starting from (r,c)
        public bool straightup(int r, int c)
        {
            if(r > 5)
            {
                return false;
            }

            if (grid[r, c].Equals(imageX))
            {
                connectFourX += 1;

                if (connectFourX == 4)
                {
                    OutcomeField.StringValue = "Winner: X";
                    return true;
                }
            }

            else if (grid[r, c].Equals(imageO))
            {
                connectFourO += 1;

                if (connectFourO == 4)
                {
                    OutcomeField.StringValue = "Winner: O";
                    return true;
                }
            }

            return straightup(r + 1, c);
        }

        //find winner in column c going down starting from (r,c)
        public bool straightdown(int r, int c)
        {
            if (r < 0)
            {
                return false;
            }

            if (grid[r, c].Equals(imageX))
            {
                connectFourX += 1;

                if (connectFourX == 4)
                {
                    OutcomeField.StringValue = "Winner: X";
                    return true;
                }
            }

            else if (grid[r, c].Equals(imageO))
            {
                connectFourO += 1;

                if (connectFourO == 4)
                {
                    OutcomeField.StringValue = "Winner: O";
                    return true;
                }
            }

            return straightdown(r - 1, c);
        }

        //find a winner in row r going left starting from (r,c)
        public bool left(int r, int c)
        {
            if (c < 0)
            {
                return false;
            }

            if (grid[r, c].Equals(imageX))
            {
                connectFourX += 1;

                if (connectFourX == 4)
                {
                    OutcomeField.StringValue = "Winner: X";
                    return true;
                }
            }

            else if (grid[r, c].Equals(imageO))
            {
                connectFourO += 1;

                if (connectFourO == 4)
                {
                    OutcomeField.StringValue = "Winner: O";
                    return true;
                }
            }

            return left(r, c - 1);
        }

        //find a winner in row r going right starting from (r,c)
        public bool right(int r, int c)
        {
            if (c > 6)
            {
                return false;
            }

            if (grid[r, c].Equals(imageX))
            {
                connectFourX += 1;

                if (connectFourX == 4)
                {
                    OutcomeField.StringValue = "Winner: X";
                    return true;
                }
            }

            else if (grid[r, c].Equals(imageO))
            {
                connectFourO += 1;

                if (connectFourO == 4)
                {
                    OutcomeField.StringValue = "Winner: O";
                    return true;
                }
            }

            return right(r, c + 1);
        }

        //find a winner in diagonal left going up starting from (r,c)
        public bool diagleftup(int r, int c)
        {
            if (r > 5 || c < 0)
            {
                return false;
            }

            if (grid[r, c].Equals(imageX))
            {
                connectFourX += 1;

                if (connectFourX == 4)
                {
                    OutcomeField.StringValue = "Winner: X";
                    return true;
                }
            }

            else if (grid[r, c].Equals(imageO))
            {
                connectFourO += 1;

                if (connectFourO == 4)
                {
                    OutcomeField.StringValue = "Winner: O";
                    return true;
                }
            }

            return diagleftup(r + 1, c - 1);
        }

        //find a winner in diagonal right going down starting from(r, c)
        public bool diagrightdown(int r, int c)
        {
            if (r < 0 || c > 6)
            {
                return false;
            }

            if (grid[r, c].Equals(imageX))
            {
                connectFourX += 1;

                if (connectFourX == 4)
                {
                    OutcomeField.StringValue = "Winner: X";
                    return true;
                }
            }

            else if (grid[r, c].Equals(imageO))
            {
                connectFourO += 1;

                if (connectFourO == 4)
                {
                    OutcomeField.StringValue = "Winner: O";
                    return true;
                }
            }

            return diagrightdown(r - 1, c + 1);
        }

        //find a winner in diagonal left going down starting from(r, c)
        public bool diagleftdown(int r, int c)
        {
            if (r < 0 || c < 0)
            {
                return false;
            }

            if (grid[r, c].Equals(imageX))
            {
                connectFourX += 1;

                if (connectFourX == 4)
                {
                    OutcomeField.StringValue = "Winner: X";
                    return true;
                }
            }

            else if (grid[r, c].Equals(imageO))
            {
                connectFourO += 1;

                if (connectFourO == 4)
                {
                    OutcomeField.StringValue = "Winner: O";
                    return true;
                }
            }

            return diagleftdown(r - 1, c - 1);
        }

        //find a winner in diagonal right going up starting from(r, c)
        public bool diagrightup(int r, int c)
        {
            if (r > 5 || c > 6)
            {
                return false;
            }

            if (grid[r, c].Equals(imageX))
            {
                connectFourX += 1;

                if (connectFourX == 4)
                {
                    OutcomeField.StringValue = "Winner: X";
                    return true;
                }
            }

            else if (grid[r, c].Equals(imageO))
            {
                connectFourO += 1;

                if (connectFourO == 4)
                {
                    OutcomeField.StringValue = "Winner: O";
                    return true;
                }
            }

            return diagrightup(r + 1, c + 1);
        }

        //return true if there is winner this function should use the previous ones
        public bool winner(int r, int c)
        {
            if (straightdown(r, c).Equals(true))
                return true;

            if (straightup(r, c).Equals(true))
                return true;

            if (right(r, c).Equals(true))
                return true;

            if (left(r, c).Equals(true))
                return true;

            if (diagleftdown(r, c).Equals(true))
                return true;

            if (diagleftup(r, c).Equals(true))
                return true;

            if (diagrightdown(r, c).Equals(true))
                return true;

            if (diagrightup(r, c).Equals(true))
                return true;

            else
                return false;
        }

        //Buttons start here.
        //Only the top tiles hav input, and the input will cascade down to a free tile.
        partial void X5Y0(NSObject sender)
        {
            
            if (PlayerTurnField.StringValue.Equals("X"))
            {
                Cascader(x0, 0);
                x0 += 1;
                PlayerTurnField.StringValue = "O";
            }

            else if (PlayerTurnField.StringValue.Equals("O"))
            {
                Cascader(x0, 0);
                x0 += 1;
                PlayerTurnField.StringValue = "X";
            }

            winner(0, 0);

            if (x0 > 5)
                x0 = 0;
            
        }

        partial void X5Y1(NSObject sender)
        {
            if (PlayerTurnField.StringValue.Equals("X"))
            {
                Cascader(x1, 1);
                x1 += 1;
                PlayerTurnField.StringValue = "O";
            }

            else if (PlayerTurnField.StringValue.Equals("O"))
            {
                Cascader(x1, 1);
                x1 += 1;
                PlayerTurnField.StringValue = "X";
            }

            winner(0, 1);

            if (x1 > 5)
                x1 = 0;
        }

        partial void X5Y2(NSObject sender)
        {
            if (PlayerTurnField.StringValue.Equals("X"))
            {
                Cascader(x2, 2);
                x2 += 1;
                PlayerTurnField.StringValue = "O";
            }

            else if (PlayerTurnField.StringValue.Equals("O"))
            {
                Cascader(x2, 2);
                x2 += 1;
                PlayerTurnField.StringValue = "X";
            }

            winner(0, 2);

            if (x2 > 5)
                x2 = 0;
        }

        partial void X5Y3(NSObject sender)
        {
            if (PlayerTurnField.StringValue.Equals("X"))
            {
                Cascader(x3, 3);
                x3 += 1;
                PlayerTurnField.StringValue = "O";
            }

            else if (PlayerTurnField.StringValue.Equals("O"))
            {
                Cascader(x3, 3);
                x3 += 1;
                PlayerTurnField.StringValue = "X";
            }

            winner(0, 3);

            if (x3 > 5)
                x3 = 0;
        }

        partial void X5Y4(NSObject sender)
        {
            if (PlayerTurnField.StringValue.Equals("X"))
            {
                Cascader(x4, 4);
                x4 += 1;
                PlayerTurnField.StringValue = "O";
            }

            else if (PlayerTurnField.StringValue.Equals("O"))
            {
                Cascader(x4, 4);
                x4 += 1;
                PlayerTurnField.StringValue = "X";
            }

            winner(0, 4);

            if (x4 > 5)
                x4 = 0;
        }

        partial void X5Y5(NSObject sender)
        {
            if (PlayerTurnField.StringValue.Equals("X"))
            {
                Cascader(x5, 5);
                x5 += 1;
                PlayerTurnField.StringValue = "O";
            }

            else if (PlayerTurnField.StringValue.Equals("O"))
            {
                Cascader(x5, 5);
                x5 += 1;
                PlayerTurnField.StringValue = "X";
            }

            winner(0, 5);
            if (x5 > 5)
                x5 = 0;
        }

        partial void X5Y6(NSObject sender)
        {
            if (PlayerTurnField.StringValue.Equals("X"))
            {
                Cascader(x6, 6);
                x6 += 1;
                PlayerTurnField.StringValue = "O";
            }

            else if (PlayerTurnField.StringValue.Equals("O"))
            {
                Cascader(x6, 6);
                x6 += 1;
                PlayerTurnField.StringValue = "X";
            }

            winner(0, 6);

            if (x6 > 5)
                x6 = 0;
        }

        partial void PlayAgainButton(NSObject sender)
        {
            totalGames += 1;
            OutcomeField.StringValue = "";
            connectFourO = 0;
            connectFourX = 0;
            ViewDidLoad();
        }

        partial void ResetButton(NSObject sender)
        {
            totalGames = 1;
            grid = null;
            connectFourX = 0;
            connectFourO = 0;
            winrateO = 0;
            winrateX = 0;
            oWins = 0;
            xWins = 0;

            ViewDidLoad();

            OutcomeField.StringValue = "";
        }
    }
}
