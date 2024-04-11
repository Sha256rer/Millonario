package ventana;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class MainW extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					MainW frame = new MainW();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainW() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 600, 437, 317);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton button1 = new JButton("1. 10 Créditos");
		button1.setFont(new Font("JetBrainsMono NF", Font.BOLD, 16));
		button1.setForeground(new Color(255, 128, 64));
		button1.setIcon(null);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LanzarDialogo();
			}
		});
		button1.setContentAreaFilled(false);
		button1.setFocusPainted(false);
		button1.setBorderPainted(false);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(131)
					.addComponent(button1, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
					.addGap(108))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addContainerGap(312, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(89)
					.addComponent(btnNewButton)
					.addGap(90)
					.addComponent(button1, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
					.addGap(36))
		);
		contentPane.setLayout(gl_contentPane);
	}
	private void LanzarDialogo() {
		String[] s = {"a", "b", "c", "d"};
		PreguntaC preg = new PreguntaC("Test", s, 1);
		Pregunta p = new Pregunta(this, true, preg);
		p.setVisible(true);
	}
	
}
