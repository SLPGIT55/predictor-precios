
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraPrecios extends JFrame {
	
	private JTextField superficie;
	private JSpinner habitaciones;
	private JSpinner baños;
	private JCheckBox garaje;
	private JComboBox ubicacion;
	private JLabel resultado;

    public CalculadoraPrecios() {
        // Configuración básica de la ventana
        setTitle("Calculadora de Precios de Viviendas");
        setSize(900, 500);
        setLocationRelativeTo(null); // Centrar ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // No cerrar toda la app al cerrar
        getContentPane().setBackground(Color.WHITE);
        
        //Panel principal 
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        //Ubicacion
        panel.add(new JLabel("Ubicación:"));
        ubicacion = new JComboBox<>(new String[]{"Centro", "Suburbio", "Campo"});
        panel.add(ubicacion);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        
        //Superficie
        panel.add(new JLabel("Superficie en m^2:"));
        superficie = new JTextField();
        panel.add(superficie);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        
        //Habitaciones
        panel.add(new JLabel("Número de habitaciones:"));
        habitaciones = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        panel.add(habitaciones);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        
        //Baños
        panel.add(new JLabel("Número de baños:"));
        baños = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        panel.add(baños);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        
        //Garaje
        garaje = new JCheckBox("¿Tiene garaje?");
        panel.add(garaje);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        
        //Boton de volver
        JButton volverBtn = new JButton("Volver a la pagina principal");
        volverBtn.setFont(new Font("Arial", Font.PLAIN, 14));
        volverBtn.setBackground(Color.LIGHT_GRAY);
        volverBtn.setFocusPainted(false);
        panel.add(volverBtn);
        
    	//Botón de calcular
        JButton calcularBtn = new JButton("Calcular Precio");
        calcularBtn.setBackground(new Color(70, 130, 180));
        calcularBtn.setForeground(Color.WHITE);
        calcularBtn.setFocusPainted(false);
        calcularBtn.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(calcularBtn);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        
        panel.add(volverBtn);
        panel.add(Box.createRigidArea(new Dimension(0, 15))); // espacio vertical
        panel.add(calcularBtn);
        
        //Resultado
        resultado = new JLabel("El resultado aparecerá aquí");
        resultado.setFont(new Font("Arial", Font.BOLD, 16));
        resultado.setForeground(new Color(70, 130, 180));
        resultado.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(resultado);
        
        add(panel);
        
        //Volver a la pagina principal
        volverBtn.addActionListener(e -> {
            PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
            paginaPrincipal.setVisible(true);
            dispose();
        });
        //Acción de calcular con el boton
        calcularBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarResultado();
            }
        });
    }
    
    private void mostrarResultado() {
    	// Simulando cálculo
        resultado.setText("Calculando...");
        SwingUtilities.invokeLater(() -> {
            try {
                Thread.sleep(1000); // Simular tiempo de cálculo
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            // Generar un resultado simulado
            double precio = 50000 + (Integer)habitaciones.getValue() * 20000 +
                    (Integer)baños.getValue() * 10000 +
                    Integer.parseInt(superficie.getText()) * 500 +
                    (garaje.isSelected() ? 15000 : 0);

            resultado.setText(String.format("Precio estimado: %.2f €", precio));
        });
    }
  

    public static void main(String[] args) {
        // Probar la ventana de forma independiente
        SwingUtilities.invokeLater(() -> new CalculadoraPrecios().setVisible(true));
    }
}

