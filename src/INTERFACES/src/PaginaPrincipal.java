import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class PaginaPrincipal extends JFrame {
	
	public PaginaPrincipal() { 
		
		//Configuracion de la ventana principal
		setTitle("Predictor de precios de viviendas");
		setSize(900, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); //Centrar la ventana
		
		//Panel Principal
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(10,10));
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));	
		panel.setBackground(new Color(255,255,255));	
		panel.setBorder(new CompoundBorder(
				new LineBorder(new Color(70, 130, 180), 3, true), // borde azul con esquinas redondeadas
	            new EmptyBorder(15, 15, 15, 15) // padding interno
	    ));
	    
		//Panel para los textos de bienvenida
	    JPanel textoPanel = new JPanel();
	    textoPanel.setLayout(new BoxLayout(textoPanel, BoxLayout.Y_AXIS));
	    textoPanel.setBackground(new Color(255,255,255));
	    
	    //Etiqueta de bienvenida principal
	    JLabel bienvenidaTitulo = new JLabel("Bienvenido al Predictor de Precios de Viviendas.");
	    bienvenidaTitulo.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar horizontalmente
	    bienvenidaTitulo.setFont(new Font("Serif", Font.BOLD, 16));
	    
	    //Etiqueta de descripción
	    JLabel bienvenidaDesc = new JLabel("Este sistema te permite estimar el precio de una vivienda de manera rápida y sencilla.");
	    bienvenidaDesc.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar horizontalmente
	    bienvenidaDesc.setFont(new Font("Arial", Font.BOLD, 14));
	    
	    //Agregar las etiquetas al panel vertical
	    textoPanel.add(bienvenidaTitulo);
	    textoPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre las etiquetas
	    textoPanel.add(bienvenidaDesc);

	    //Agregar el panel de texto al panel principal
	    panel.add(textoPanel, BorderLayout.CENTER);
		
		//Boton principal
		JButton calcularBtn = new JButton ("Calcular precio de vivienda");
		calcularBtn.setFont(new Font("Arial", Font.BOLD, 16));
		calcularBtn.setBackground(new Color(70, 130, 180)); 
		calcularBtn.setForeground(Color.WHITE);
		calcularBtn.setFocusPainted(false);
	    calcularBtn.setPreferredSize(new Dimension(300, 50));
		panel.add(calcularBtn, BorderLayout.SOUTH);
		
		//Accion del boton
		calcularBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Aqui abrimos la siguiente interfaz para calcular precios
				try {
					CalculadoraPrecios ventanaCalculo = new CalculadoraPrecios();
					ventanaCalculo.setVisible(true); //Muestra la venta 
					dispose(); //Cierra la ventana actual
				}catch (Exception ex) {
					ex.printStackTrace();
				}
			}	
		});
		add(panel);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new PaginaPrincipal().setVisible(true);			
			}	
		});
	}
}
