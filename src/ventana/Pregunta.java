package ventana;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JLayeredPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.SwingConstants;

public class Pregunta extends JDialog {
	private PreguntaC preg;
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private int Answer;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton btnNewButton;
	private boolean enabled = true;


	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 * 
	 * Para el futuro: arreglar para cambiar la puta fumada esta
	 * por toggle buttons y quiter la mierda de radio buttons q
	 * he montado con los buttons
	 */
	public Pregunta(JFrame f, boolean l, PreguntaC p) {
		super(f, l);
		this.preg = p;
		setBounds(100, 100, 800, 550);
		getContentPane().setBackground(new Color(0, 0, 0));
		getContentPane().setLayout(null);
		JRadioButton btn1 = new JRadioButton("1");
		btn1.setBounds(111, 221, 42, 26);
		btn1.setVisible(false);
		btn1.setEnabled(false);
		buttonGroup.add(btn1);
		
		JRadioButton btn2 = new JRadioButton("2");
		btn2.setBounds(52, 218, 43, 32);
		btn2.setVisible(false);
		btn2.setEnabled(false);
		buttonGroup.add(btn2);
		
		JRadioButton btn3 = new JRadioButton("3");
		btn3.setBounds(965, 220, 39, 28);
		btn3.setVisible(false);
		btn3.setEnabled(false);
		buttonGroup.add(btn3);
		
		JRadioButton btn4 = new JRadioButton("4");
		btn4.setBounds(1004, 214, 48, 41);
		btn4.setVisible(false);
		btn4.setEnabled(false);
		buttonGroup.add(btn4);
		
		button1 = new JButton("");
		
		button1.setForeground(new Color(255, 255, 255));
		button1.setIcon(new ImageIcon(Pregunta.class.getResource("/ventana/resources/pregunta3.png")));
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(enabled) {
				Changebutton(button1);
				btn1.setSelected(true);
				}
			}
		});
		button1.setBounds(55, 62, 300, 88);
		getContentPane().add(button1);
		
		button2 = new JButton("New button");
		button2.setForeground(new Color(255, 255, 255));
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(enabled) {
				Changebutton(button2);
				btn2.setSelected(true);
				}
			}
		});
		button2.setIcon(new ImageIcon(Pregunta.class.getResource("/ventana/resources/pregunta3.png")));
		button2.setBounds(445, 62, 300, 88);
		getContentPane().add(button2);
		
		button3 = new JButton("New button");
		button3.setForeground(new Color(255, 255, 255));
		button3.setIcon(new ImageIcon(Pregunta.class.getResource("/ventana/resources/pregunta3.png")));
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(enabled) {
					Changebutton(button3);
					btn3.setSelected(true);
				}
				
			}
		});
		button3.setBounds(37, 290, 340, 57);
		getContentPane().add(button3);
		
		button4 = new JButton("New button");
		button4.setForeground(new Color(255, 255, 255));
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(enabled) {
					Changebutton(button4);
					btn4.setSelected(true);
				}
			
			}
		});
		button4.setIcon(new ImageIcon(Pregunta.class.getResource("/ventana/resources/pregunta3.png")));
		button4.setBounds(445, 274, 300, 88);
		getContentPane().add(button4);
		button4.setContentAreaFilled(false);
		button4.setFocusPainted(false);
		button4.setBorderPainted(false);
		button3.setContentAreaFilled(false);
		button3.setFocusPainted(false);
		button3.setBorderPainted(false);
		button2.setContentAreaFilled(false);
		button2.setFocusPainted(false);
		button2.setBorderPainted(false);
		button1.setContentAreaFilled(false);
		button1.setFocusPainted(false);
		button1.setBorderPainted(false);
		button1.setHorizontalTextPosition(JButton.CENTER);
		button2.setHorizontalTextPosition(JButton.CENTER);
		button2.setVerticalTextPosition(JButton.CENTER);
		button3.setHorizontalTextPosition(JButton.CENTER);
		button3.setVerticalTextPosition(JButton.CENTER);
		button4.setHorizontalTextPosition(JButton.CENTER);
		button4.setVerticalTextPosition(JButton.CENTER);
		
		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkRight();
				btnNewButton.setEnabled(false);
				enabled = false;
				
			}
		});
		btnNewButton.setBounds(301, 418, 205, 32);
		getContentPane().add(btnNewButton);
		contentPanel.add(btn2);
		contentPanel.add(btn1);
		contentPanel.add(btn3);
		contentPanel.add(btn4);
		
	}
	
	private int checkSelected() {
		for(Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			if(button.isSelected()) {
			return 	Integer.parseInt(button.getText());
				}
			}
		return 0;
	}
	
	private JButton Returnb() {
		switch(checkSelected()) {
		case 1: 
			return button1;
		case 2:
			return button2;
		case 3:
			return button3;
		case 4:
			return button4;
		default:
			return null;
		}
		
	}
	private JButton Returnb(int n) {
		switch(n) {
		case 1: 
			return button1;
		case 2:
			return button2;
		case 3:
			return button3;
		case 4:
			return button4;
		default:
			return null;
		}
		
	}
	private void Changebutton(JButton j) {
		
		if(Returnb()!=null) {
			if(Returnb()!=j) {
				Returnb().setIcon(new ImageIcon(Pregunta.class.getResource("/ventana/resources/pregunta3.png")));
				j.setIcon(new ImageIcon(Pregunta.class.getResource("/ventana/resources/pregunta3highlight.png")));
			}
			else {
				j.setIcon(new ImageIcon(Pregunta.class.getResource("/ventana/resources/pregunta3highlight.png")));
			}
		}
		else {
			j.setIcon(new ImageIcon(Pregunta.class.getResource("/ventana/resources/pregunta3highlight.png")));
		}
	}
	private void checkRight() {
			Answer = checkSelected();
				 if(Answer==(preg.getCorrecta())) {
					Returnb().setIcon(new ImageIcon(Pregunta.class.getResource("/ventana/resources/pregunta3right.png")));
					
					
				 }
				 else {
					Returnb().setIcon(new ImageIcon(Pregunta.class.getResource("/ventana/resources/pregunta3wrong.png")));
					Returnb((preg.getCorrecta())).setIcon(new ImageIcon(Pregunta.class.getResource("/ventana/resources/pregunta3right.png")));
					System.out.println("Devolver 0 a ListaPreguntas");
				 }
			}
	}

