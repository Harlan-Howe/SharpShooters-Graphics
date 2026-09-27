import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SharpShooterPanel extends JPanel implements MouseListener
{
    public static final int LEFT_DIE_MARGIN = 30;
    public static final int DIE_SPACING = 45;
    public static final int TOP_DIE_MARGIN = 10;
    public static final int DIE_SIZE = 40;
    private static final Font SCORE_FONT = new Font("Times New Roman", Font.PLAIN, 36);

    private GoalBoard board;
    private Die[] dice;
    private int[] scores;
    private SharpShooterGame referee;

    public SharpShooterPanel(GoalBoard theBoard, Die[] theDice, int[] theScores)
    {
        super();
        setBackground(new Color(255,200,0));
        board = theBoard;
        dice = theDice;
        scores = theScores;
        addMouseListener(this);

    }

    public void setReferee(SharpShooterGame ref)
    {
        referee = ref;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);


        board.drawSelf(g);

        for (int i = 0; i< dice.length; i++)
        {
            if (dice[i] != null)
                dice[i].drawSelfAt(g, LEFT_DIE_MARGIN + DIE_SPACING *i, TOP_DIE_MARGIN, DIE_SIZE);
            else
            {
                g.setColor(Color.DARK_GRAY);
                Stroke plain = ((Graphics2D)g).getStroke();
                float[] pattern = {4.0f, 5.0f};
                Stroke dotted = new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f, pattern, 0);
                ((Graphics2D)g).setStroke(dotted);
                g.drawRect(LEFT_DIE_MARGIN + 5 + DIE_SPACING*i, TOP_DIE_MARGIN+5, DIE_SIZE-10, DIE_SIZE-10);
                ((Graphics2D)g).setStroke(plain);
            }
        }

        for (int i = 0; i < 2; i++)
        {
            g.setColor(Color.BLACK);
            g.setFont(SCORE_FONT);
            g.drawString("Player "+(i+1)+" Score: "+scores[i], 20, 475+i*50);
        }
    }

    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        for (Die d: dice)
        {
            if (d == null)
                builder.append("---");
            else
                builder.append(d.toString());
            builder.append("\t");
        }
        builder.append("\n------------------------------------------------------------------------\n");
        builder.append(board.toString());
        builder.append("Player 0 Score: "+scores[0]+"\n");
        builder.append("Player 1 Score: "+scores[1]);

        return builder.toString();
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        if (e.getY()>=TOP_DIE_MARGIN && e.getY() <= TOP_DIE_MARGIN+DIE_SIZE && e.getX() > LEFT_DIE_MARGIN)
        {
            int which = (e.getX() - LEFT_DIE_MARGIN)/DIE_SPACING;
            int frac = (e.getX() - LEFT_DIE_MARGIN)%DIE_SPACING;
            if (which < 5 && frac < DIE_SIZE)
                referee.userClickedDie(which);
        }
        else
        {
            int whichRow = board.whichRowWasClicked(e.getX(), e.getY());
            if (whichRow != -1)
                referee.handleUserClickedRowInGoalBoard(whichRow);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }
}
