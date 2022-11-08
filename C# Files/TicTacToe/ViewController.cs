using System;

using AppKit;
using Foundation;

namespace TicTacToe
{

    public class Player
    {
        public int win;
        public double winrate;
        public bool victory = false;
    }

    public partial class ViewController : NSViewController
    {
        int player, totalGames;
        string[] players = { "player1", "player2" }; //This array allows me to pick a player at random in the beggining of the game.
        string[,] grid = new string[3, 3];
        NSImage imageX = NSImage.ImageNamed("logoX");
        NSImage imageO = NSImage.ImageNamed("cato");
        


        //Creates players to facilitate score keeping.
        Player P1 = new Player();
        Player P2 = new Player();

        public ViewController(IntPtr handle) : base(handle)
        {
        }

        public override void ViewDidLoad()
        {
            base.ViewDidLoad();

            // Do any additional setup after loading the view.
            //Random player picker on first game.
            //---------------------------------------------------
            Random rnd = new Random();
            player = rnd.Next(players.Length);
            totalGames = 1;

            if (player == 0)
                PlayerTurn.StringValue = "X";

            else
                PlayerTurn.StringValue = "O";
            //---------------------------------------------------
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

        //Play Again button will increase the number of games on every press.
        //Reset will return everything to blank.
        //-------------------------------------------------------------------
        partial void PlayAgainButton(NSObject sender)
        {
            totalGames += 1;
            grid = new string[3, 3];

            P1.winrate = Convert.ToDouble(P1.win / totalGames);
            P2.winrate = Convert.ToDouble(P2.win / totalGames);

            box00.Image = null;
            box01.Image = null;
            box02.Image = null;
            box10.Image = null;
            box11.Image = null;
            box12.Image = null;
            box20.Image = null;
            box21.Image = null;
            box22.Image = null;
        }

        partial void ResetButton(NSObject sender)
        {
            totalGames = 1;
            grid = new string[3, 3];
            P1.win = 0;
            P2.win = 0;
            P1.winrate = 0;
            P2.winrate = 0;

            box00.Image = null;
            box01.Image = null;
            box02.Image = null;
            box10.Image = null;
            box11.Image = null;
            box12.Image = null;
            box20.Image = null;
            box21.Image = null;
            box22.Image = null;
        }
        //-------------------------------------------------------------------

        /*All the buttons are located here.
        In order to make the buttons display the picture, they must be both an ACTION, and an OUTLET.
        in the interface builder.
        Additionally, the boxes are named in reference to a 3x3 grid.
        --------------------------------------------------------*/
        partial void Box00(NSObject sender)
        {
            
            if (PlayerTurn.StringValue.Equals("X"))
            {
                box00.Image = NSImage.ImageNamed("logoX");
                player = 1;
                PlayerTurn.StringValue = "O";
                grid[0, 0] = "X";
            }

            else
            {
                box00.Image = NSImage.ImageNamed("cato");
                player = 0;
                PlayerTurn.StringValue = "X";
                grid[0, 0] = "O";
            }
        }

        partial void Box10(NSObject sender)
        {
            if (PlayerTurn.StringValue.Equals("X"))
            {
                box10.Image = NSImage.ImageNamed("logoX");
                player = 1;
                PlayerTurn.StringValue = "O";
                grid[1, 0] = "X";
            }

            else
            {
                box10.Image = NSImage.ImageNamed("cato");
                player = 0;
                PlayerTurn.StringValue = "X";
                grid[1, 0] = "O";
            }
        }

        partial void Box20(NSObject sender)
        {
            if (PlayerTurn.StringValue.Equals("X"))
            {
                box20.Image = NSImage.ImageNamed("logoX");
                player = 1;
                PlayerTurn.StringValue = "O";
                grid[2, 0] = "X";
            }

            else
            {
                box20.Image = NSImage.ImageNamed("cato");
                player = 0;
                PlayerTurn.StringValue = "X";
                grid[2, 0] = "O";
            }
        }

        partial void Box01(NSObject sender)
        {
            if (PlayerTurn.StringValue.Equals("X"))
            {
                box01.Image = NSImage.ImageNamed("logoX");
                player = 1;
                PlayerTurn.StringValue = "O";
                grid[0, 1] = "X";
            }

            else
            {
                box01.Image = NSImage.ImageNamed("cato");
                player = 0;
                PlayerTurn.StringValue = "X";
                grid[0, 1] = "O";
            }
        }

        partial void Box11(NSObject sender)
        {
            if (PlayerTurn.StringValue.Equals("X"))
            {
                box11.Image = NSImage.ImageNamed("logoX");
                player = 1;
                PlayerTurn.StringValue = "O";
                grid[1, 1] = "X";
            }

            else
            {
                box11.Image = NSImage.ImageNamed("cato");
                player = 0;
                PlayerTurn.StringValue = "X";
                grid[1, 1] = "O";
            }
        }

        partial void Box21(NSObject sender)
        {
            if (PlayerTurn.StringValue.Equals("X"))
            {
                box21.Image = NSImage.ImageNamed("logoX");
                player = 1;
                PlayerTurn.StringValue = "O";
                grid[2, 1] = "X";
            }

            else
            {
                box21.Image = NSImage.ImageNamed("cato");
                player = 0;
                PlayerTurn.StringValue = "X";
                grid[2, 1] = "O";
            }
        }

        partial void Box02(NSObject sender)
        {
            if (PlayerTurn.StringValue.Equals("X"))
            {
                box02.Image = NSImage.ImageNamed("logoX");
                player = 1;
                PlayerTurn.StringValue = "O";
                grid[0, 2] = "X";
            }

            else
            {
                box02.Image = NSImage.ImageNamed("cato");
                player = 0;
                PlayerTurn.StringValue = "X";
                grid[0, 2] = "O";
            }
        }

        partial void Box12(NSObject sender)
        {
            if (PlayerTurn.StringValue.Equals("X"))
            {
                box12.Image = NSImage.ImageNamed("logoX");
                player = 1;
                PlayerTurn.StringValue = "O";
                grid[1, 2] = "X";
            }

            else
            {
                box12.Image = NSImage.ImageNamed("cato");
                player = 0;
                PlayerTurn.StringValue = "X";
                grid[1, 2] = "O";
            }
        }

        partial void Box22(NSObject sender)
        {
            if (PlayerTurn.StringValue.Equals("X"))
            {
                box22.Image = NSImage.ImageNamed("logoX");
                player = 1;
                PlayerTurn.StringValue = "O";
                grid[2, 2] = "X";
            }

            else
            {
                box22.Image = NSImage.ImageNamed("cato");
                player = 0;
                PlayerTurn.StringValue = "X";
                grid[2, 2] = "O";
            }
        }
        //-----------------------------------------------------------
        //Uses the 3x3 grid to track scores.
        public bool WinningCondition()
        {
                if (PlayerTurn.StringValue.Equals("X"))
                {
                    //Horizontal Coordinates
                    if (grid[0, 0].Equals(PlayerTurn.StringValue) && grid[1, 0].Equals(PlayerTurn.StringValue) && grid[2, 0].Equals(PlayerTurn.StringValue))
                    return true;

                    else if (grid[0, 1].Equals(PlayerTurn.StringValue) && grid[1, 1].Equals(PlayerTurn.StringValue) && grid[2, 1].Equals(PlayerTurn.StringValue))
                        return true;

                    else if (grid[0, 2].Equals(PlayerTurn.StringValue) && grid[1, 2].Equals(PlayerTurn.StringValue) && grid[2, 2].Equals(PlayerTurn.StringValue))
                        return true;

                //Vertical Coordinates
                    else if (grid[0, 0].Equals(PlayerTurn.StringValue) && grid[0, 1].Equals(PlayerTurn.StringValue) && grid[0, 2].Equals(PlayerTurn.StringValue))
                        return true;

                    else if (grid[1, 0].Equals(PlayerTurn.StringValue) && grid[1, 1].Equals(PlayerTurn.StringValue) && grid[1, 2].Equals(PlayerTurn.StringValue))
                        return true;

                    else if (grid[2, 0].Equals("X") && grid[2, 1].Equals("X") && grid[2, 2].Equals("X"))
                        return true;

                //Diagonal Coordinates.
                    else if (grid[0, 0].Equals("X") && grid[1, 1].Equals("X") && grid[2, 2].Equals("X"))
                        return true;

                    else if (grid[0, 2].Equals("X") && grid[1, 1].Equals("X") && grid[2, 0].Equals("X"))
                        return true;
                }


            if (PlayerTurn.StringValue.Equals("O"))
            {
                //Horizontal Coordinates
                if (grid[0, 0].Equals("O") && grid[1, 0].Equals("O") && grid[2, 0].Equals("O"))
                    return true;

                else if (grid[0, 1].Equals("O") && grid[1, 1].Equals("O") && grid[2, 1].Equals("O"))
                    return true;

                else if (grid[0, 2].Equals("O") && grid[1, 2].Equals("O") && grid[2, 2].Equals("O"))
                    return true;

                //Vertical Coordinates
                else if (grid[0, 0].Equals("O") && grid[0, 1].Equals("O") && grid[0, 2].Equals("O"))
                    return true;

                else if (grid[1, 0].Equals("O") && grid[1, 1].Equals("O") && grid[1, 2].Equals("O"))
                    return true;

                else if (grid[2, 0].Equals("O") && grid[2, 1].Equals("O") && grid[2, 2].Equals("O"))
                    return true;

                //Diagonal Coordinates.
                else if (grid[0, 0].Equals("O") && grid[1, 1].Equals("O") && grid[2, 2].Equals("O"))
                    return true;

                else if (grid[0, 2].Equals("O") && grid[1, 1].Equals("O") && grid[2, 0].Equals("O"))
                    return true;
            }

            return false;                
        }
        //------------------------------------------------------------------
        public void EndGame()
        {
            
            if(P1.victory == true)
            {
                MatchOutcome.StringValue = "X wins!";
                P1.win += 1;
                P1.winrate = Convert.ToDouble(P1.win / totalGames);

                //Labels
                XWinrate.StringValue = "X Winrate: " + P1.winrate.ToString("P") + "%";
                OWinrate.StringValue = "O Winrate: " + P2.winrate.ToString("P") + "%";
            }

            if(P2.victory == true)
            {
                MatchOutcome.StringValue = "O wins!";
                P2.win += 1;
                P2.winrate = Convert.ToDouble(P2.win / totalGames);

                //Labels
                XWinrate.StringValue = "X Winrate: " + P1.winrate.ToString() + "%";
                OWinrate.StringValue = "O Winrate: " + P2.winrate.ToString() + "%";
            }
        }
    }
}
