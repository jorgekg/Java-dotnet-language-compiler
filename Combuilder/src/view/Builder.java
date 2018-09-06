package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class Builder {

	private JFrame frmBuilder;

	public Builder() {
		initialize();
		this.frmBuilder.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBuilder = new JFrame();
		frmBuilder.setTitle("ComBuilder");
		frmBuilder.setBounds(100, 100, 731, 474);
		frmBuilder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBuilder.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmBuilder.getContentPane().add(panel, BorderLayout.WEST);
		
		JButton btnNewctrl = new JButton("New [ctrl + n]");
		panel.add(btnNewctrl);
		
		JPanel panel_1 = new JPanel();
		frmBuilder.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JTextPane textPane = new JTextPane();
		frmBuilder.getContentPane().add(textPane, BorderLayout.CENTER);
	}

}
