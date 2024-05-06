package deliverySystem.views.deliveryman;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;

public class DeliveryManView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JMenuItem mntmNewMenuItem;
    private JMenuItem mntmNewMenuItem_2;
    private JMenuItem mntmNewMenuItem_3;

    public DeliveryManView() {
    	setTitle("Delivery Man");
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 577, 538);
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setPaint(new GradientPaint(0, 0, Color.decode("#212f40"), getWidth(), getHeight(), Color.decode("#141c26")));
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.dispose();
            }
        };
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 561, 26);
        contentPane.add(menuBar);
        
        JMenu mnNewMenu = new JMenu("File");
        menuBar.add(mnNewMenu);
        
        mntmNewMenuItem = new JMenuItem("Exit");
        mnNewMenu.add(mntmNewMenuItem);
        
        JMenu mnNewMenu_1 = new JMenu("Delivery");
        menuBar.add(mnNewMenu_1);
        
        mntmNewMenuItem_2 = new JMenuItem("Accept Deliveries");
        mnNewMenu_1.add(mntmNewMenuItem_2);
        
        mntmNewMenuItem_3 = new JMenuItem("End Deliveries");
        mnNewMenu_1.add(mntmNewMenuItem_3);
    }

    public JMenuItem getMntmNewMenuItem() {
        return mntmNewMenuItem;
    }

   

    public JMenuItem getMntmNewMenuItem_2() {
        return mntmNewMenuItem_2;
    }

    public JMenuItem getMntmNewMenuItem_3() {
        return mntmNewMenuItem_3;
    }
}
