import java.awt.*;

public class GoalBoard
{
    public static final int TOP_MARGIN = 80;
    public static final int LEFT_MARGIN = 30;
    private GoalRow[] myRows;
    private static final int numRows = 6;
    private int VERTICAL_SPACING = 60;

    public GoalBoard()
    {
        myRows = new GoalRow[numRows];
        initializeRows();
    }

    /**
     * Randomly creates new rows for this board, in various styles.
     */
    public void initializeRows()
    {
        // values 1-6 correspond to normal dice, and values 7+ will be wild cards. We want each row to have its own
        //     wild card value (or in the case of the Full House, two wild card values). So this tracks which wild
        //     card value to use next.
        int nextWildVal = 7;

        for (int i=0; i<numRows; i++)
        {
            double rnd = Math.random();
            if (rnd < 0.7) // All the same ---------------------------
            {
                int count = (int)(Math.random()*5+2);
                int which = (int)(Math.random()*7+1);
                if (which == 7)  // wild card
                {
                    which = nextWildVal;
                    nextWildVal++;
                }
                int[] slotValues = new int[count];
                for (int j = 0; j<count; j++)
                    slotValues[j] = which;
                int reward = 10 * count;
                if (which > 6)
                    reward += 10;
                if (Math.random()<0.16)
                    reward *= -1;
                myRows[i] = new GoalRow(slotValues,reward);
            }
            else if (rnd < 0.8) //  Full House -----------------------
            {
                int which1 = (int)(Math.random()*7+1);
                if (which1 == 7) // wild card
                {
                    which1 = nextWildVal;
                    nextWildVal++;
                }
                int which2 = (int)(Math.random()*7+1);
                if (which2 == 7) // wild card
                {
                    which2 = nextWildVal;
                    nextWildVal++;
                }
                int[] slotValues = {which1, which1, which1, which2, which2};
                myRows[i] = new GoalRow(slotValues, 70);
            }
            else if (rnd < 0.9)  // Small Straight  -------------------
            {
                int[] slotValues = {1,2,3,4,5};
                myRows[i] = new GoalRow(slotValues, 90);
            }
            else // --------------- Large Straight --------------------
            {
                int[] slotValues = {1,2,3,4,5,6};
                myRows[i] = new GoalRow(slotValues, 100);
            }
        }
    }

    public void drawSelf(Graphics g)
    {
        for (int i = 0; i<numRows; i++)
        {
            myRows[i].drawRowAt(g, LEFT_MARGIN, TOP_MARGIN + VERTICAL_SPACING * i);
        }
    }

    /**
     * the user has clicked on the screen; we are determining whether they clicked in one of this Board's GoalRows.
     * @param xPixels - the x position within the panel of the mouse click
     * @param yPixels - the y position within the panel of the mouse click
     * @return - which row did this click fall in, or -1 if it did not click any of them.
     */
    public int whichRowWasClicked(int xPixels, int yPixels)
    {
        if (yPixels<TOP_MARGIN || xPixels<LEFT_MARGIN || yPixels > TOP_MARGIN+numRows*VERTICAL_SPACING)
            return -1;
        return (yPixels-(TOP_MARGIN-10)) / VERTICAL_SPACING;
    }


    /**
     * @return - whether none of the GoalRows in this board have a reward remaining.
     */
    public boolean allRewardsAreClaimed()
    {
        // TODO - Recommended: you write this.
        return false; // replace this with your code.
    }

    // ==========THE FOLLOWING ARE METHODS THAT JUST DELEGATE GOALROW METHOD REQUESTS TO A PARTICULAR ROW. =============

    /**
     * checks whether it would be legal if the user attempted to add the given die to the row at the given index.
     * @param d - the candidate die
     * @param row - the index of the row to which we might wish to add the die
     * @return - whether this would be a legal move, from the row's perspective.
     */
    public boolean addingDieToRowIsLegal(Die d, int row)
    {
        return myRows[row].dieIsLegalAddition(d);
    }

    /**
     * (Assuming this is a legal move) Adds the given die to the row at the given index, and if this completes that row,
     * returns the reward.
     * @param d - the die to add
     * @param row - the index of the row to which to add the die
     * @return - the reward for completing the row, or zero if the row is incomplete.
     */
    public int addDieToRow(Die d, int row)
    {
        return myRows[row].addDie(d);
    }

    /**
     * checks whether the row at the given index has all its slots filled in.
     * @param row - the index of the row in question
     * @return - whether this row is filled in.
     */
    public boolean rowIsFull(int row)
    {
        return myRows[row].isFull();
    }

    /**
     * gets the reward for the row at the given index
     * @param row - the index of the row in question
     * @return - the reward for this row.
     */
    public int rewardForRow(int row)
    {
        return myRows[row].getReward();
    }

    public  String toString()
    {
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<myRows.length; i++)
        {
            builder.append(i);
            builder.append("\n");
            builder.append(myRows[i].toString());
            builder.append("\n------------------------------------------------------------------------\n");
        }
        return builder.toString();
    }
}
