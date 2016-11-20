package swingworkerdemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingWorkerDemoMain extends JApplet {
    private JButton jbtComputeWithSwingWorker = new JButton("Compute");
    private JTextField jftLimit1 = new JTextField(8);
    private JTextField jftResult1 = new JTextField(6);
    private JButton jbtCompute = new JButton("Compute");
    private JTextField jftLimit2 = new JTextField(8);
    private JTextField jftResult2 = new JTextField(6);

    public SwingWorkerDemoMain() {
        JPanel panel1 = new JPanel(new GridLayout(2, 1));
        panel1.setBorder(BorderFactory.createTitledBorder("Using SwingWorker"));

        JPanel panel11 = new JPanel();
        panel11.add(new JLabel("The number of prime numbers <= "));
        panel11.add(jftLimit1);
        panel11.add(new JLabel("is"));
        panel11.add(jftResult1);

        JPanel panel12 = new JPanel();
        panel12.add(jbtComputeWithSwingWorker);
        panel1.add(panel11);
        panel1.add(panel12);

        JPanel panel2 = new JPanel(new GridLayout(2, 1));
        panel2.setBorder(BorderFactory.createTitledBorder("Without Using SwingWorker"));
        JPanel panel121 = new JPanel();
        panel121.add(new JLabel("The number of prime numbers <= "));
        panel121.add(jftLimit2);
        panel121.add(new JLabel("is"));
        panel121.add(jftResult2);

        JPanel panel122 = new JPanel();
        panel122.add(jbtCompute);
        panel122.add(panel121);
        panel122.add(panel122);

        setLayout(new GridLayout(1, 2));
        add(panel1);
        add(panel2);

        jbtComputeWithSwingWorker.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ComputePrime(Integer.parseInt(jftLimit1.getText()), jftResult1).execute();
            }
        });

        jbtComputeWithSwingWorker.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int count = ComputePrime.getNumberOfPrimes (Integer.parseInt(jftLimit2.getText()));
                jftResult2.setText(count + "");
            }
        });
    }

    static class ComputePrime extends SwingWorker<Integer, Object> {
        private int limit;
        private JTextField result;
        
        public ComputePrime(int limit, JTextField result) {
            this.limit = limit;
            this.result = result;
        }

        protected Integer doInBackground() {
            return getNumberOfPrimes(limit);
        }

        protected void done() {
            try {
                result.setText(get().toString());
            } catch (Exception ex) {
                result.setText(ex.getMessage());
            }
        }

        public static int getNumberOfPrimes(int limit) {
            int count = 0;
            int number = 2;

            while (number <= limit) {
                if (isPrime(number)) {
                    count++;
                }
                number++;
            }
            return count;
        }

        private static boolean isPrime(int number) {
            for (int divisor = 2; divisor <= number / 2; divisor++) {
                if (number % divisor == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
