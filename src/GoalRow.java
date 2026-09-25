import java.awt.*;

public class GoalRow
{
//    private static Image icons = new Image[9];
    private int[] diceToMatch;
    private Die[] dicePlacedInRow;
    private int reward;
    private int numSlotsFilled;

    private static final int SLOT_SPACING = 10;
    private static final int SLOT_SIZE = 40;
    private static final Font SLOT_FONT = new Font("Ariel",Font.BOLD, 32);
    private static final Font REWARD_FONT = new Font("Ariel",Font.BOLD, 24);
    private static final Color[] wildColors = {Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA};


    public GoalRow(int[] diceToMatch, int reward)
    {
        this.diceToMatch = diceToMatch;
        this.dicePlacedInRow = new Die[this.diceToMatch.length]; // starts filled with null values.
        this.reward = reward;
        this.numSlotsFilled = 0;
    }

    public int getReward() {return reward;}



    public void drawRowAt(Graphics g, int x, int y)
    {
        for (int i=0; i<diceToMatch.length; i++)
        {
            if (reward >=0)
                g.setColor(Color.WHITE);
            else
                g.setColor(Color.BLACK);
            g.fillRoundRect(x+(SLOT_SPACING+SLOT_SIZE)*i,y,SLOT_SIZE,SLOT_SIZE,3,3);
            g.setColor(Color.BLACK);
            g.drawRoundRect(x+(SLOT_SPACING+SLOT_SIZE) *i,y,SLOT_SIZE,SLOT_SIZE,3,3);
            g.setFont(SLOT_FONT);

            if (diceToMatch[i] < 7)
            {
                if (reward >=0)
                    g.setColor(Color.BLACK);
                else
                    g.setColor(Color.WHITE);
                g.drawString(""+diceToMatch[i], x+(SLOT_SPACING+SLOT_SIZE)*i+8,y+32);
            }
            else
            {
                g.setColor(wildColors[(diceToMatch[i]-7)%4]);
                g.drawString(""+(char)(58+diceToMatch[i]), x+(SLOT_SPACING+SLOT_SIZE)*i+8, y+32);
            }
        }
        if (reward != 0)
        {
            if (reward > 0)
                g.setColor(new Color(200, 255, 200));
            else
                g.setColor(Color.BLACK);
            g.fillOval(x + 8 * (SLOT_SPACING + SLOT_SIZE), y - 10, SLOT_SIZE + 20, SLOT_SIZE + 20);
            if (reward > 0)
                g.setColor(Color.BLACK);
            else
                g.setColor(Color.WHITE);
            g.setFont(REWARD_FONT);
            int string_width = g.getFontMetrics(REWARD_FONT).stringWidth(""+reward);

            g.drawString("" + reward,
                         x + 8 * (SLOT_SPACING + SLOT_SIZE) + (SLOT_SIZE +20)/2 - string_width/2,
                         y -10 + (SLOT_SIZE+20)/2 + 9);
        }
        for (int i=0; i<numSlotsFilled; i++)
        {
            dicePlacedInRow[i].drawSelfAt(g,x+(SLOT_SPACING+SLOT_SIZE)*i,y,40);
        }
    }

    /**
     * indicates whether all the slots in the dicePlacedInRow are filled with actual (non-null) dice.
     * @return - whether we have filled in this row.
     */
    public boolean isFull()
    {
        // TODO - Recommended: You write this.

        return false; // replace this with your code.
    }

    /**
     * determines whether the given die is of a value that can be placed at the next spot on this row... does it match
     * the next slot (and is there a next slot?
     * @param d - a die
     * @return - whether this die could be placed here.
     * Note: does not actually place the die.
     */
    public boolean dieIsLegalAddition(Die d)
    {
        //TODO - Required: You write this.

        return false; // replace this with your code.
    }

    /**
     * adds die to the list of dice placed on this goal; if this fills up the row, returns the reward. (Assumes this is
     * a legal move.) If this is placing the die on a wild card, replaces all instances of that wild card with the
     * value of this die.
     * @param d - the die to place
     * @return - the reward for this row if this completes the row, or zero. Resets the reward to zero.
     */
    public int addDie(Die d)
    {


        // TODO - Required: You write this.

        if (this.isFull())
            return reward;
        return 0;
    }

}
