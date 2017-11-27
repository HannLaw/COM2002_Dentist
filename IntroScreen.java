import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntroScreen {
    private JButton secretaryButton;
    public JPanel splashScreen;
    private JButton dentistButton;
    private JButton hygienistButton;

    public IntroScreen() {

        secretaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        JFrame frame1 = new JFrame("SecretaryPage");
                        frame1.setContentPane(new SecretaryPage().secPagePanel);
                        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame1.pack();
                        frame1.setVisible(true);
                        System.out.println("Pressed sec button");
                    }
                });
            }
        });
        dentistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        JFrame frame2 = new JFrame("DentistPage");
                        frame2.setContentPane(new PartnerPage().partPagePanel);
                        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame2.pack();
                        frame2.setVisible(true);
                        System.out.println("Pressed dent button");
                    }
                });
            }
        });
        hygienistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        JFrame frame3 = new JFrame("HygienistPage");
                        frame3.setContentPane((new PartnerPage().partPagePanel));
                        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame3.pack();
                        frame3.setVisible(true);
                        System.out.println("Pressed hyg button");
                    }
                });
            }
        });
    }
}
