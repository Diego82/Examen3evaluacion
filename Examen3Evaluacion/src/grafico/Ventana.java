package grafico;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class Ventana {

	private JFrame frame;
	private JTextField textFieldPais;
	private JTextField txtInterprete;
	private JTextField txtCancion;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelIzquierdo = new JPanel();
		panelIzquierdo.setLayout(new GridLayout(0, 1, 0, 0));
		frame.getContentPane().add(panelIzquierdo, BorderLayout.WEST);
		
		
		JButton btnNewButton = new JButton("New button");
		panelIzquierdo.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panelIzquierdo.add(btnNewButton_1);
		
		JPanel panelInferior = new JPanel();
		panelInferior.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(panelInferior, BorderLayout.SOUTH);
		panelInferior.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel labelParticipantes = new JLabel("Participante 1 de 27");
		panelInferior.add(labelParticipantes);
		
		JPanel panelCentral = new JPanel();
		frame.getContentPane().add(panelCentral, BorderLayout.CENTER);
		
		JLabel labelPais = new JLabel("Pais:");
		
		JLabel labelInterprete = new JLabel("Interprete:");
		
		JLabel labelCancion = new JLabel("Cancion:");
		
		JLabel labelPuntuacion = new JLabel("Puntuacion:");
		
		textFieldPais = new JTextField();
		textFieldPais.setColumns(10);
		
		txtInterprete = new JTextField();
		txtInterprete.setColumns(10);
		
		txtCancion = new JTextField();
		txtCancion.setText("");
		txtCancion.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout gl_panelCentral = new GroupLayout(panelCentral);
		gl_panelCentral.setHorizontalGroup(
			gl_panelCentral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCentral.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
						.addComponent(labelPuntuacion)
						.addComponent(labelCancion)
						.addComponent(labelInterprete)
						.addComponent(labelPais))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCentral.createSequentialGroup()
							.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
								.addComponent(txtInterprete, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
								.addComponent(txtCancion, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(36))
						.addGroup(gl_panelCentral.createSequentialGroup()
							.addComponent(textFieldPais, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_panelCentral.setVerticalGroup(
			gl_panelCentral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCentral.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelPais)
						.addComponent(textFieldPais, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelInterprete)
						.addComponent(txtInterprete, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelCancion)
						.addComponent(txtCancion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelPuntuacion)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		panelCentral.setLayout(gl_panelCentral);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnDatosEurovision = new JMenu("Datos Eurovision");
		menuBar.add(mnDatosEurovision);
		
		JMenuItem itemCargarBBDD = new JMenuItem("Cargar Base de Datos");
		mnDatosEurovision.add(itemCargarBBDD);
		
		JMenuItem itemGuardarBBDD = new JMenuItem("Guardar  Base de Datos");
		mnDatosEurovision.add(itemGuardarBBDD);
		
		JMenuItem itemSalir = new JMenuItem("Salir");
		mnDatosEurovision.add(itemSalir);
		
		JMenu menuPais = new JMenu("Pais");
		menuBar.add(menuPais);
		
		JMenuItem itemAnterior = new JMenuItem("Anterior");
		menuPais.add(itemAnterior);
		
		JMenuItem itemSiguiente = new JMenuItem("siguiente");
		menuPais.add(itemSiguiente);
		
		JMenu menuGanador = new JMenu("Ganador");
		menuBar.add(menuGanador);
		
		JMenuItem mntmMostrar = new JMenuItem("Mostrar");
		menuGanador.add(mntmMostrar);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue);
		
		JMenu menuAyuda = new JMenu("Ayuda");
		menuBar.add(menuAyuda);
		
		JMenuItem itemAcercade = new JMenuItem("Acerca de...");
		menuAyuda.add(itemAcercade);
	}
}
