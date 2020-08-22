package stopwatch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;

public class Stopwatch extends JFrame {

    JButton startButton = new JButton();
    JButton stopButton = new JButton();
    JButton exitButton = new JButton();
    JButton clearButton = new JButton();

    JLabel startLabel = new JLabel();
    JLabel stopLabel = new JLabel();
    JLabel elapsedLabel = new JLabel();

    JTextField startTextField = new JTextField();
    JTextField stopTextField = new JTextField();
    JTextField elapsedTextField = new JTextField();

    long startTime;
    long stopTime;
    long currentTime;
    double elapsedTime;

    Timer timer;

    public static void main(String[] args) {
        new Stopwatch().show();
    }

    public Stopwatch() {
        setTitle("stopwatch.Stopwatch Application");

        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                exitForm(e);
            }
        });

        getContentPane().setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        startButton.setText("Start Timing");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        getContentPane().add(startButton, gridBagConstraints);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButtonActionPerformed(e);
            }
        });

        stopButton.setText("Stop Timing");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        getContentPane().add(stopButton, gridBagConstraints);
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopButtonActionPerformed(e);
            }
        });
        stopButton.setEnabled(false);

        exitButton.setText("Exit");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        getContentPane().add(exitButton, gridBagConstraints);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitButtonActionPerformed(e);
            }
        });

        startLabel.setText("Start Time");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        getContentPane().add(startLabel, gridBagConstraints);

        stopLabel.setText("Stop Time");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        getContentPane().add(stopLabel, gridBagConstraints);

        elapsedLabel.setText("Elapsed Time (sec)");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        getContentPane().add(elapsedLabel, gridBagConstraints);

        startTextField.setText("");
        startTextField.setColumns(15);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        getContentPane().add(startTextField, gridBagConstraints);

        stopTextField.setText("");
        stopTextField.setColumns(15);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        getContentPane().add(stopTextField, gridBagConstraints);

        elapsedTextField.setText("");
        elapsedTextField.setColumns(15);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        getContentPane().add(elapsedTextField, gridBagConstraints);

        getContentPane().setBackground(new Color(229,187,173));

        clearButton.setText("Clear");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        getContentPane().add(clearButton, gridBagConstraints);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearButtonActionPerformed(e);
            }
        });
        clearButton.setEnabled(false);

        pack();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(
                (int) (0.5 * (screenSize.width - getWidth())),
                (int) (0.5 * (screenSize.height - getHeight())),
                getWidth(),
                getHeight()
        );
    }

    private void startButtonActionPerformed(ActionEvent e) {
        startTime = System.currentTimeMillis();
        startTextField.setText(String.valueOf(startTime));
        stopTextField.setText("");
        elapsedTextField.setText("");
        startButton.setEnabled(false);
        stopButton.setEnabled(true);
        clearButton.setEnabled(false);

        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                currentTime = System.currentTimeMillis();
                stopTextField.setText(String.valueOf(currentTime));
                elapsedTime = (currentTime - startTime) / 1000.0;
                elapsedTextField.setText(String.valueOf(elapsedTime));
            }
        }, 1000, 1000);
    }

    private void stopButtonActionPerformed(ActionEvent e) {
        stopTime = System.currentTimeMillis();
        stopTextField.setText(String.valueOf(stopTime));
        elapsedTime = (stopTime - startTime) / 1000.0;
        elapsedTextField.setText(String.valueOf(elapsedTime));
        startButton.setEnabled(true);
        stopButton.setEnabled(false);
        clearButton.setEnabled(true);
        timer.cancel();
    }

    private void exitButtonActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    private void exitForm(WindowEvent e) {
        System.exit(0);
    }

    private void clearButtonActionPerformed(ActionEvent e) {
        startTextField.setText("");
        stopTextField.setText("");
        elapsedTextField.setText("");
    }
}
