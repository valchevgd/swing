package dualmodestopwatch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DualModeStopwatch extends JFrame {

    JLabel runningTimeLabel = new JLabel();
    JTextField runningTimeTextField = new JTextField();

    JLabel totalTimeLabel = new JLabel();
    JTextField totalTimeTextField = new JTextField();

    JButton startStopButton = new JButton();
    JButton resetButton = new JButton();
    JButton exitButton = new JButton();

    public static void main(String[] args) {
        new DualModeStopwatch().show();
    }

    public DualModeStopwatch() {
        setTitle("Stopwatch");
        setResizable(false);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evn) {
                exitForm(evn);
            }
        });

        getContentPane().setLayout(new GridBagLayout());


        GridBagConstraints gridConstraints;

        runningTimeLabel.setText("Running Time:");
        runningTimeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        gridConstraints.insets = new Insets(10, 25, 0, 0);
        getContentPane().add(runningTimeLabel, gridConstraints);

        runningTimeTextField.setPreferredSize(new Dimension(150, 50));
        runningTimeTextField.setEditable(false);
        runningTimeTextField.setBackground(Color.WHITE);
        runningTimeTextField.setForeground(Color.BLUE);
        runningTimeTextField.setText("00:00:00");
        runningTimeTextField.setHorizontalAlignment(SwingConstants.CENTER);
        runningTimeTextField.setFont(new Font("Arial", Font.BOLD, 24));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 1;
        gridConstraints.gridwidth = 2;
        gridConstraints.insets = new Insets(0, 10, 0, 10);
        getContentPane().add(runningTimeTextField, gridConstraints);

        totalTimeLabel.setText("Total Time:");
        totalTimeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 2;
        gridConstraints.insets = new Insets(10, 10, 0, 10);
        getContentPane().add(totalTimeLabel, gridConstraints);

        totalTimeTextField.setPreferredSize(new Dimension(150, 50));
        totalTimeTextField.setEditable(false);
        totalTimeTextField.setBackground(Color.WHITE);
        totalTimeTextField.setForeground(Color.RED);
        totalTimeTextField.setText("00:00:00");
        totalTimeTextField.setHorizontalAlignment(SwingConstants.CENTER);
        totalTimeTextField.setFont(new Font("Arial", Font.BOLD, 24));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 3;
        gridConstraints.gridwidth = 2;
        gridConstraints.insets = new Insets(0, 10, 15, 10);
        getContentPane().add(totalTimeTextField, gridConstraints);

        startStopButton.setText("Start");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 4;
        getContentPane().add(startStopButton, gridConstraints);
        startStopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startStopButtonActionPerformed(e);
            }
        });

        resetButton.setText("Reset");
        resetButton.setEnabled(false);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 4;
        gridConstraints.insets = new Insets(0, 0, 0, 25);
        getContentPane().add(resetButton, gridConstraints);
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetButtonActionPerformed(e);
            }
        });

        exitButton.setText("Exit");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 5;
        gridConstraints.insets = new Insets(10, 0, 10, 25);
        getContentPane().add(exitButton, gridConstraints);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitButtonActionPerformed(e);
            }
        });

        pack();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setBounds(
                (int) (0.5 * (screenSize.width - getWidth())),
                (int) (0.5 * (screenSize.height - getHeight())),
                getWidth(),
                getHeight()
        );
    }

    private void exitForm(WindowEvent e) {
        System.exit(0);
    }

    private void startStopButtonActionPerformed(ActionEvent e) {
    }

    private void resetButtonActionPerformed(ActionEvent e) {
    }

    private void exitButtonActionPerformed(ActionEvent e) {
    }
}
