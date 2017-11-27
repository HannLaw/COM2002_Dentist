import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntroScreen {
    private JButton secretaryButton;
    private JPanel panel1;
    private JButton dentistButton;
    private JButton hygienistButton;

    public IntroScreen() {
        secretaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        SecretaryPage sFrame = new SecretaryPage();
                    }
                });
            }
        });
        dentistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        PartnerPage dFrame = new PartnerPage();
                    }
                });
            }
        });
        hygienistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        PartnerPage hFrame = new PartnerPage();
                    }
                });
            }
        });
    }
}
