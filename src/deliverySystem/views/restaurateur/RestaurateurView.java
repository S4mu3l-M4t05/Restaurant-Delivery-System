package deliverySystem.views.restaurateur;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class RestaurateurView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem exitMenuItem;
    private JMenu orderMenu;
    private JMenuItem acceptOrderMenuItem;
    private JMenuItem orderReadyMenuItem;

    public RestaurateurView() {
        setTitle("Restaurateur");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 673, 693);
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

        menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 657, 26);
        contentPane.add(menuBar);

        fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(exitMenuItem);

        orderMenu = new JMenu("Order");
        menuBar.add(orderMenu);

        acceptOrderMenuItem = new JMenuItem("Accept Order");
        orderMenu.add(acceptOrderMenuItem);

        orderReadyMenuItem = new JMenuItem("Order Ready");
        orderMenu.add(orderReadyMenuItem);
    }



	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public JMenu getFileMenu() {
		return fileMenu;
	}

	public void setFileMenu(JMenu fileMenu) {
		this.fileMenu = fileMenu;
	}

	public JMenuItem getExitMenuItem() {
		return exitMenuItem;
	}

	public void setExitMenuItem(JMenuItem exitMenuItem) {
		this.exitMenuItem = exitMenuItem;
	}

	public JMenu getOrderMenu() {
		return orderMenu;
	}

	public void setOrderMenu(JMenu orderMenu) {
		this.orderMenu = orderMenu;
	}

	public JMenuItem getAcceptOrderMenuItem() {
		return acceptOrderMenuItem;
	}

	public void setAcceptOrderMenuItem(JMenuItem acceptOrderMenuItem) {
		this.acceptOrderMenuItem = acceptOrderMenuItem;
	}

	public JMenuItem getOrderReadyMenuItem() {
		return orderReadyMenuItem;
	}

	public void setOrderReadyMenuItem(JMenuItem orderReadyMenuItem) {
		this.orderReadyMenuItem = orderReadyMenuItem;
	}

}
