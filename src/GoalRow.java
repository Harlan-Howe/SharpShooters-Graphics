import java.awt.*;

public class GoalRow
{
    public static final String STAR_STRING = "★"; // or use "?" if emojiis aren't working for you.
    //    private static Image icons = new Image[9];
    private int[] valuesToMatch;
    private Die[] dicePlacedInRow;
    private int reward;
    private int numSlotsFilled;

    private static final int SLOT_SPACING = 10;
    private static final int SLOT_SIZE = 40;
    private static final Font SLOT_FONT = new Font("Ariel",Font.BOLD, 32);
    private static final Font REWARD_FONT = new Font("Ariel",Font.BOLD, 24);
    private static final Color[] wildColors = {Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.CYAN, new Color(255,128,0)};


    public GoalRow(int[] valuesToMatch, int reward)
    {
        this.valuesToMatch = valuesToMatch;
        this.dicePlacedInRow = new Die[this.valuesToMatch.length]; // starts filled with null values.
        this.reward = reward;
        this.numSlotsFilled = 0;
    }

    public int getReward() {return reward;}



    public void drawRowAt(Graphics g, int x, int y)
    {
        for (int i = 0; i< valuesToMatch.length; i++)
        {
            if (reward >=0)
                g.setColor(Color.WHITE);
            else
                g.setColor(Color.BLACK);
            g.fillRoundRect(x+(SLOT_SPACING+SLOT_SIZE)*i,y,SLOT_SIZE,SLOT_SIZE,3,3);
            g.setColor(Color.BLACK);
            g.drawRoundRect(x+(SLOT_SPACING+SLOT_SIZE) *i,y,SLOT_SIZE,SLOT_SIZE,3,3);
            g.setFont(SLOT_FONT);

            if (valuesToMatch[i] < 7)
            {
                if (reward >=0)
                    g.setColor(Color.BLACK);
                else
                    g.setColor(Color.WHITE);
                g.drawString(""+ valuesToMatch[i], x+(SLOT_SPACING+SLOT_SIZE)*i+8,y+32);
            }
            else
            {
                g.setColor(wildColors[(valuesToMatch[i]-7)%6]);
                //g.drawString(""+(char)(58+ valuesToMatch[i]), x+(SLOT_SPACING+SLOT_SIZE)*i+8, y+32);
                g.drawString(STAR_STRING, x+(SLOT_SPACING+SLOT_SIZE)*i+4, y+32);
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


        return 0;
    }

    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        for (Die d:dicePlacedInRow)
        {
            if (d == null)
                break;
            builder.append(d);
            builder.append("\t");
        }
        builder.append("\n");
        for (int v: valuesToMatch)
        {
            builder.append("_");
            builder.append(v);
            builder.append("_\t");
        }
        builder.append("--> reward: ");
        builder.append(reward);
        return builder.toString();
    }

}
