package MainFrame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class test {

    private JComponent ui = null;
    private JButton[][] buttonArray = new JButton[10][5];
    JLabel output = new JLabel("Click a button");

    test() {
        initUI();
    }
 
    private void findButton(Object c) {
        for (int x = 0; x < buttonArray.length; x++) {
            for (int y = 0; y < buttonArray[0].length; y++) {
                if (c.equals(buttonArray[x][y])) {
                    output.setText(x + "," + y + " clicked");
                    return;
                }
            }
        }
    }

    public void initUI() {
        if (ui != null) {
            return;
        }

        ui = new JPanel(new BorderLayout(4, 4));
        ui.setBorder(new EmptyBorder(4, 4, 4, 4));

        ActionListener buttonListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                findButton(e.getSource());
            }
        };

        JPanel buttonPanel = new JPanel(new GridLayout(0, 10, 2, 2));
        ui.add(buttonPanel, BorderLayout.CENTER);
        BufferedImage bi = new BufferedImage(20, 20, BufferedImage.TYPE_INT_ARGB);
        ImageIcon ii = new ImageIcon(bi);
        Insets margin = new Insets(0, 0, 0, 0);
        for (int y = 0; y < buttonArray[0].length; y++) {
            for (int x = 0; x < buttonArray.length; x++) {
                JButton b = new JButton();
                buttonArray[x][y] = b;
                b.setMargin(margin);
                b.setIcon(ii);
                b.addActionListener(buttonListener);
                buttonPanel.add(b);
            }
        }

        output.setFont(output.getFont().deriveFont(20f));
        ui.add(output, BorderLayout.PAGE_END);
    }

    public JComponent getUI() {
        return ui;
    }

	/*
	 * public static void main(String[] args) { Runnable r = new Runnable() {
	 * 
	 * @Override public void run() { try {
	 * UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch
	 * (Exception useDefault) { } test o = new test();
	 * 
	 * JFrame f = new JFrame(o.getClass().getSimpleName());
	 * f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	 * f.setLocationByPlatform(true);
	 * 
	 * f.setContentPane(o.getUI()); f.pack(); f.setMinimumSize(f.getSize());
	 * 
	 * f.setVisible(true); } }; SwingUtilities.invokeLater(r); }
	 */
}