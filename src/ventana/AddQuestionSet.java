package ventana;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import java.awt.Label;

public class AddQuestionSet extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtpreg;
	private ListaPreguntas q;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Label errores;
	private int contador;
	private JButton btn1;
	private JButton btn2;
	private JRadioButton btn3;
	private JRadioButton btn4;
	private JRadioButton btn5;
	private JRadioButton btn6;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddQuestionSet frame = new AddQuestionSet();
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
	public AddQuestionSet() {
		contador = -1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(300, 168, 124, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(93, 169, 117, 17);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(93, 107, 117, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(300, 107, 124, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Opcion A");
		lblNewLabel.setBounds(24, 110, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblOpcionB = new JLabel("Opcion B");
		lblOpcionB.setBounds(24, 171, 46, 14);
		contentPane.add(lblOpcionB);
		
		JLabel lblOpcionD = new JLabel("Opcion D");
		lblOpcionD.setBounds(244, 171, 46, 14);
		contentPane.add(lblOpcionD);
		
		JLabel lblOpcionC = new JLabel("Opcion C");
		lblOpcionC.setBounds(244, 110, 46, 14);
		contentPane.add(lblOpcionC);
		
		txtpreg = new JTextField();
		txtpreg.setToolTipText("Introduce una pregunta...");
		txtpreg.setBounds(24, 20, 168, 54);
		contentPane.add(txtpreg);
		txtpreg.setColumns(10);
		
		btn1 = new JButton("Back");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GetPrev();
				contador--;
			}
		});
		btn1.setBounds(206, 227, 89, 23);
		contentPane.add(btn1);
		
		btn2 = new JButton("Next");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NextWindow();
				contador++;
			}
		});
		btn2.setBounds(324, 227, 89, 23);
		contentPane.add(btn2);
		
		btn3 = new JRadioButton("C");
		btn3.setToolTipText("3");
		buttonGroup.add(btn3);
		btn3.setBounds(269, 20, 33, 23);
		contentPane.add(btn3);
		
		btn4 = new JRadioButton("A");
		btn4.setToolTipText("1");
		buttonGroup.add(btn4);
		btn4.setBounds(234, 20, 33, 23);
		contentPane.add(btn4);
		
		btn5 = new JRadioButton("B");
		btn5.setToolTipText("2");
		buttonGroup.add(btn5);
		btn5.setBounds(234, 51, 33, 23);
		contentPane.add(btn5);
		
		btn6 = new JRadioButton("D");
		btn6.setToolTipText("4");
		buttonGroup.add(btn6);
		btn6.setBounds(269, 51, 40, 23);
		contentPane.add(btn6);
		
		JLabel lblNewLabel_1 = new JLabel("Selecciona la correcta");
		lblNewLabel_1.setBounds(310, 20, 114, 48);
		contentPane.add(lblNewLabel_1);
		
		errores = new Label("");
		errores.setBounds(42, 211, 96, 22);
		contentPane.add(errores);
	}

	
	private void NextWindow() {
		if(checkSelected()==0) {
			errores.setText("No correcta");
			throw new Error("No correcta");
		}
		if(textField.getText().isBlank()) {
			errores.setText("Textr vacio");
			throw new Error("TextF vacio");
		}
		if(textField_1.getText().isBlank()) {
			throw new Error("TextF vacio");
		}
		if(textField_2.getText().isBlank()) {
			throw new Error("TextF vacio");
		}
		if(textField_3.getText().isBlank()) {
			throw new Error("TextF vacio");
		}
		if(txtpreg.getText().isBlank()) {
			throw new Error("TextF vacio");
		}
		if(q==null) {
			this.q = new ListaPreguntas();
		}
		String[] respuestas = {textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText()};
		q.addPreg(new PreguntaC(txtpreg.getText(), respuestas ,checkSelected()));
		textField.setText(null);
		textField_1.setText(null);
		textField_2.setText(null);
		textField_3.setText(null);
		txtpreg.setText(null);
		getSelected().setSelected(false);
		System.out.println(contador);
	}
	private int checkSelected() {
		
		for(Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			if(button.isSelected()) {
			return 	Integer.parseInt(button.getToolTipText());
				}
			}
		return 0;
	}
	private void setSelected(PreguntaC c) {
		
		for(Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			if(c.getCorrecta()==Integer.parseInt(button.getToolTipText())) {
				button.setSelected(true);
				}
			}

	}
	private JRadioButton getSelected() {
		switch(checkSelected()) {
		case 1:
			return btn3;
		case 2:
			return btn4;
		case 3:
			return btn5;
		case 4:
			return btn6;
		default: 
			return null;
			
		}
	}
	private void GetPrev() {
		
		textField.setText(null);
		textField_1.setText(null);
		textField_2.setText(null);
		textField_3.setText(null);
		txtpreg.setText(null);
		getSelected().setSelected(false);
		if(contador<0) {
			throw new Error("No hay mas atras");
		}
		PreguntaC curr =  q.getPregunta(contador);
		txtpreg.setText(curr.getPregunta());
		textField.setText(curr.getRespuesta(0));
		textField_1.setText(curr.getRespuesta(1));
		textField_2.setText(curr.getRespuesta(2));
		textField_3.setText(curr.getRespuesta(3));
		setSelected(curr);
	}
}
