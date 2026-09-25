import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SharpShooterFrame extends JFrame implements ActionListener
{
    private SharpShooterPanel guiMainPanel;
    private JLabel messageLabel;
    private JButton rollButton, passButton;
    private SharpShooterGame referee;


    public SharpShooterFrame(SharpShooterPanel panel)
    {
        super("Sharp Shooters");
        guiMainPanel = panel;
        setSize(800,800);
        setResizable(false);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(guiMainPanel,BorderLayout.CENTER);
        JPanel northPanel = new JPanel(new FlowLayout());
        messageLabel = new JLabel("Welcome to Sharp Shooters.");
        northPanel.add(messageLabel);
        getContentPane().add(northPanel, BorderLayout.NORTH);

        JPanel southPanel = new JPanel(new FlowLayout());
        rollButton = new JButton("Roll all Dice");
        rollButton.addActionListener(this);
        passButton = new JButton("End Turn");
        passButton.addActionListener(this);
        southPanel.add(rollButton);
        southPanel.add(passButton);
        getContentPane().add(southPanel,BorderLayout.SOUTH);

        referee = null;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setReferee(SharpShooterGame ref)
    {
        referee = ref;
    }

    public void setMessage(String message)
    {
        messageLabel.setText(message);
        repaint();
    }

    public void setRollButtonEnabled(boolean b) {rollButton.setEnabled(b);}
    public void enableRollButton(){setRollButtonEnabled(true);}
    public void disableRollButton(){setRollButtonEnabled(false);}
    public boolean rollButtonIsEnabled(){return rollButton.isEnabled();}

    public void setPassButtonEnabled(boolean b) {passButton.setEnabled(b);}
    public void enablePassButton(){setPassButtonEnabled(true);}
    public void disablePassButton(){setPassButtonEnabled(false);}
    public boolean passButtonIsEnabled(){return passButton.isEnabled();}

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == rollButton)
            referee.handleRollButtonPress();
        else if (e.getSource() == passButton)
            referee.handleEndTurnButtonPress();
    }
}
