import javax.swing.*;

public class SharpShooterGame
{
    private Die[] dice;
    private GoalBoard board;
    private int[] playerScores;

    private SharpShooterPanel GUI;
    private SharpShooterFrame window;

    private int whoseTurn;
    private static final int PLAYER_1 = 0;
    private static final int PLAYER_2 = 1;

    private int gameState;
    private static final int STATE_WAITING_FOR_INITIAL_ROLL = 0;
    private static final int STATE_WAITING_ON_USER_CHOICES = 1;
    private boolean user_has_placed_a_die;


    public SharpShooterGame(Die[] theDice,
                            GoalBoard theBoard,
                            int[] theScores,
                            SharpShooterPanel theGUI,
                            SharpShooterFrame theWindow)
    {
        dice = theDice;
        board = theBoard;
        playerScores = theScores;
        GUI = theGUI;
        window = theWindow;
    }

    /**
     * popup a dialog box with the given title and message and wait for the user to click "ok". This might be used for
     * a "Game Over" event, but could also be used if the player still has MoveOptions but none are legal, such as when
     * trying to get checkers off the bar, but the points are blocked.
     * @param title - a string to place in the title bar of the popup dialog
     * @param message - a string to place in the body of the popup dialog
     */
    public void displayPopupWindow(String title, String message)
    {
        JOptionPane.showMessageDialog(GUI, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * checks to see whether any of the dice on the board can legally be placed in any row.
     * @return - whether a legal move exists.
     */
    public boolean canAnyDieBePlaced()
    {
        //TODO - Recommended: you write this.
        return true; // replace this code with yours
    }


    /**
     * determines whether there are no more rewards to be collected.
     */
    public boolean checkWhetherBoardIsCompletelyFilled()
    {
        return board.allRewardsAreClaimed();
    }

    /**
     * Here is where you might end the game OR end this turn and regenerate the board.
     * If you decide to end the game, I recommend using the displayPopupWindow() method,
     * above and then System.exit(0).
     */
    public void respondToFilledCard()
    {
        // TODO - Recommended: write this method.
        System.out.println("I'm responding to a filled card.");
    }

    /**
     * if the user has rolled the dice at least once, and there is a die here, select the given die while deselecting
     * all others.
     * @param whichDie - the index of the location in the list of dice that the user has clicked. Note: there may
     *                 not be a die here (it could be null).
     */
    public void userClickedDie(int whichDie)
    {
        // TODO - Required: You write this.
        GUI.repaint();
    }

    /**
     * the user just pressed the roll button. If the player hasn't rolled yet, then you should wind
     * up with five new dice. If the user has already placed at least one die since the last roll, just
     * re-roll the remaining dice. Reset the game state and whether user has placed a die, as appropriate.
     */
    public void handleRollButtonPress()
    {
        System.out.println("The user pressed Roll Button.");
        // TODO - Required: you write this.

        GUI.repaint();
    }

    /**
     * if the player has rolled at least once, and has either placed a die since the last roll or there are no legal
     * moves, end this turn -> deselect all dice, change which player this is, change the state of the game to wait for
     * the user to click roll, and update the window message to tell the new user to roll.
     */
    public void handleEndTurnButtonPress()
    {
        System.out.println("The user pressed the End Turn Button.");
        // TODO - Required: you write this.

        GUI.repaint();
    }

    /**
     * if the user has one of the dice selected, check whether this is a legal move. If so, make the move and update the
     * game.
     * @param whichRow - the index of the row we wish to place this die.
     */
    public void handleUserClickedRowInGoalBoard(int whichRow)
    {
        System.out.println("The user just clicked row "+whichRow+" in the GoalBoard.");
        // TODO - Required: you write this.

        // Check whether a die is selected, and if so, would this make a legal move.

        // If so...
        //      • remove the selected die from the "dice" on the board,
        //      • deselect it,
        //      • add it to the given row
        //      • add the resulting reward (if any) to the player's score.
        //      • check whether this completes this card
        //      • Update the state of the game, a decision which may depend on:
        //          - is the game over?
        //          - has the player run out of dice?
        //          - should the player be allowed to place another die?
        //          - should the player be allowed to roll the dice again?

        GUI.repaint();
    }


}
