package ejercicio1;

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
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ventana {

	private JFrame frame;
	private JTextField txtPais;
	private JTextField txtInterprete;
	private JTextField txtCancion;
	private JTextField txtPuntuacion;
	private JLabel labelParticipantes;
	private JFileChooser fileChooser;
	private File fileSelected;
	private List<Concursante> listaConcursantes;
	private int posicion=0;
	

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
		frame.setTitle("Ejercicio 1");
		
		JPanel panelIzquierdo = new JPanel();
		panelIzquierdo.setLayout(new GridLayout(0, 1, 0, 0));
		frame.add(panelIzquierdo, BorderLayout.WEST);
			
		JButton botonAnterior = new JButton("Anterior");
		botonAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("A la entrada posicion vale "+posicion);
				if (posicion==0){
					JOptionPane.showMessageDialog(frame, "Estas en el primer registro", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					txtPais.setText(listaConcursantes.get(posicion).getPais());
					txtCancion.setText(listaConcursantes.get(posicion).getCancion());
					txtInterprete.setText(listaConcursantes.get(posicion).getInterprete());
					txtPuntuacion.setText(Integer.toString(listaConcursantes.get(posicion).getPuntuacion()));

					posicion--;
					labelParticipantes.setText("Participante "+(posicion+1)+"de "+listaConcursantes.size());

				}
				System.out.println(posicion);
			}
		});
		panelIzquierdo.add(botonAnterior);
		
		JButton botonSiguiente = new JButton("Siguiente");
		botonSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println("A la entrada posicion vale "+posicion);

				if (posicion==listaConcursantes.size()-1){
					JOptionPane.showMessageDialog(frame, "Estas en el ultimo registro", "Error", JOptionPane.ERROR_MESSAGE);
				}
					
				else {
					txtPais.setText(listaConcursantes.get(posicion).getPais());
					txtCancion.setText(listaConcursantes.get(posicion).getCancion());
					txtInterprete.setText(listaConcursantes.get(posicion).getInterprete());
					txtPuntuacion.setText(Integer.toString(listaConcursantes.get(posicion).getPuntuacion()));

					posicion++;
					labelParticipantes.setText("Participante "+(posicion+1)+"de "+listaConcursantes.size());

				}
				System.out.println(posicion);
			}
		});
		panelIzquierdo.add(botonSiguiente);
		
		JPanel panelInferior = new JPanel();
		panelInferior.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(panelInferior, BorderLayout.SOUTH);
		panelInferior.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		labelParticipantes = new JLabel("Registro");
		panelInferior.add(labelParticipantes);
		
		JPanel panelCentral = new JPanel();
		frame.getContentPane().add(panelCentral, BorderLayout.CENTER);
		
		JLabel lblPais = new JLabel("Pais:");
		
		JLabel lblInterprete = new JLabel("Interprete:");
		
		JLabel lblCancion = new JLabel("Cancion:");
		
		JLabel lblPuntuacion = new JLabel("Puntuacion:");
		
		txtPais = new JTextField();
		txtPais.setColumns(10);
		
		txtInterprete = new JTextField();
		txtInterprete.setColumns(10);
		
		txtCancion = new JTextField();
		txtCancion.setColumns(10);
		
		txtPuntuacion = new JTextField();
		txtPuntuacion.setColumns(10);
		GroupLayout gl_panelCentral = new GroupLayout(panelCentral);
		gl_panelCentral.setHorizontalGroup(
			gl_panelCentral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCentral.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPais)
						.addComponent(lblInterprete)
						.addComponent(lblCancion)
						.addComponent(lblPuntuacion))
					.addGap(22)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
						.addComponent(txtPuntuacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCancion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtInterprete, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPais, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(113, Short.MAX_VALUE))
		);
		gl_panelCentral.setVerticalGroup(
			gl_panelCentral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCentral.createSequentialGroup()
					.addGap(42)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPais)
						.addComponent(txtPais, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblInterprete)
						.addComponent(txtInterprete, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCancion)
						.addComponent(txtCancion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblPuntuacion)
						.addComponent(txtPuntuacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(68, Short.MAX_VALUE))
		);
		panelCentral.setLayout(gl_panelCentral);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnDatosEurovision = new JMenu("Datos Eurovision");
		menuBar.add(mnDatosEurovision);
		
		JMenuItem itemCargarBBDD = new JMenuItem("Cargar Base de Datos");
		itemCargarBBDD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//utilizamos el fileChooser que hemos creado antes para recoger si se ha abierto un archivo o no
				fileChooser = new JFileChooser();
				int valor = fileChooser.showOpenDialog(frame);

				//Si abrimos el archivo entramos en este if y guardamos lo recogido en un nuevo archivo
				//y empezamos a operar con el
				if (valor == fileChooser.APPROVE_OPTION) {
					fileSelected = fileChooser.getSelectedFile();
					
					//Ahora empezamos a leer el archivo con Scanner
					try (Scanner in = new Scanner(fileSelected);){
						
						listaConcursantes = new ArrayList<Concursante>();
						String linealeida;
						while(in.hasNextLine()){
							linealeida = in.nextLine();
							String[] campos = linealeida.split(";");
							listaConcursantes.add(new Concursante(campos[0], campos[1], campos[2], Integer.parseInt(campos[3])));
						}
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				txtPais.setText(listaConcursantes.get(0).getPais());
				txtCancion.setText(listaConcursantes.get(0).getCancion());
				txtInterprete.setText(listaConcursantes.get(0).getInterprete());
				txtPuntuacion.setText(Integer.toString(listaConcursantes.get(0).getPuntuacion()));
				
			}
		});
		mnDatosEurovision.add(itemCargarBBDD);
		
		JMenuItem itemGuardarBBDD = new JMenuItem("Guardar Base de Datos");
		itemGuardarBBDD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				fileChooser = new JFileChooser();
				int valor = fileChooser.showSaveDialog(frame);
				if (valor == fileChooser.APPROVE_OPTION) {
					File newFile = fileChooser.getSelectedFile();
					try (PrintWriter out = new PrintWriter(new FileOutputStream(newFile));){
						String pais, cancion, interprete;
						int puntuacion;
						String lineaLeida = "País;Canción;Intérprete;Puntos";
						out.println(lineaLeida);
						for (int i = 0; i < listaConcursantes.size(); i++) {
							pais = listaConcursantes.get(i).getPais();
							cancion = listaConcursantes.get(i).getCancion();
							interprete = listaConcursantes.get(i).getInterprete();
							puntuacion = listaConcursantes.get(i).getPuntuacion();
							lineaLeida = pais+";"+cancion+";"+interprete+";"+puntuacion;
							out.println(lineaLeida);
						}
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		mnDatosEurovision.add(itemGuardarBBDD);
		
		JMenuItem itemSalir = new JMenuItem("Salir");
		itemSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(-1);
			}
		});
		mnDatosEurovision.add(itemSalir);
		
		JMenu menuPais = new JMenu("Pais");
		menuBar.add(menuPais);
		
		JMenuItem itemAnterior = new JMenuItem("Anterior");
		itemAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (posicion==0)
					JOptionPane.showMessageDialog(frame, "Estas en el primer registro", "Error", JOptionPane.ERROR_MESSAGE);
				else {
					txtPais.setText(listaConcursantes.get(posicion).getPais());
					txtCancion.setText(listaConcursantes.get(posicion).getCancion());
					txtInterprete.setText(listaConcursantes.get(posicion).getInterprete());
					txtPuntuacion.setText(Integer.toString(listaConcursantes.get(posicion).getPuntuacion()));
					posicion--;
				}
				System.out.println(posicion);
			}
		});
		menuPais.add(itemAnterior);
		
		JMenuItem itemSiguiente = new JMenuItem("Siguiente");
		itemSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (posicion==listaConcursantes.size()-1)
					JOptionPane.showMessageDialog(frame, "Estas en el ultimo registro", "Error", JOptionPane.ERROR_MESSAGE);
				else {
					txtPais.setText(listaConcursantes.get(posicion).getPais());
					txtCancion.setText(listaConcursantes.get(posicion).getCancion());
					txtInterprete.setText(listaConcursantes.get(posicion).getInterprete());
					txtPuntuacion.setText(Integer.toString(listaConcursantes.get(posicion).getPuntuacion()));
					posicion++;
				}
				System.out.println(posicion);
			}
		});
		menuPais.add(itemSiguiente);
		
		JMenu menuGanador = new JMenu("Ganador");
		menuBar.add(menuGanador);
		
		JMenuItem mntmMostrar = new JMenuItem("Mostrar");
		mntmMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String mensaje;
				int pos=0;
				for (int i = 0; i < listaConcursantes.size(); i++) {
					if (listaConcursantes.get(i).getPuntuacion()>listaConcursantes.get(i+1).getPuntuacion()) {
						pos = i;
					}
				}
				mensaje = "El ganador es:\n"+listaConcursantes.get(pos);
								JOptionPane.showMessageDialog(frame, mensaje, "Ganador", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		menuGanador.add(mntmMostrar);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue);
		
		JMenu menuAyuda = new JMenu("Ayuda");
		menuBar.add(menuAyuda);
		
		JMenuItem itemAcercade = new JMenuItem("Acerca de...");
		menuAyuda.add(itemAcercade);
	}
}
