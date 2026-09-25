public class SharpShooterRunner
{
    static void main()
    {
        GoalBoard board = new GoalBoard();
        Die[] dice = new Die[5];

        int[] scores = {0, 0};

        SharpShooterPanel mainGuiPanel = new SharpShooterPanel(board, dice, scores);
        SharpShooterFrame window = new SharpShooterFrame(mainGuiPanel);

        SharpShooterGame referee = new SharpShooterGame(dice, board, scores, mainGuiPanel, window);

        mainGuiPanel.setReferee(referee);
        window.setReferee(referee);

        window.setVisible(true);
    }


}
