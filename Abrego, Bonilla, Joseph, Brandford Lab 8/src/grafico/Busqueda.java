package grafico;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Busqueda extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextArea textArea;
    
    // Estructura de datos para almacenar información
    private Map<String, String[]> datosGuardados; // Usamos un mapa donde la clave es la cédula y el valor es un array con [sexo, carrera, elegibilidad]

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Busqueda frame = new Busqueda();
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
    public Busqueda() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 606, 457);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Búsqueda");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setBounds(300, 11, 92, 28);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Ingresar cédula:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(35, 48, 123, 17);
        contentPane.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(139, 48, 123, 17);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("Buscar");
        btnNewButton.setBounds(300, 47, 89, 23);
        contentPane.add(btnNewButton);

        JLabel lblNewLabel_1_1 = new JLabel("Carrera:");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1_1.setBounds(35, 134, 123, 17);
        contentPane.add(lblNewLabel_1_1);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"Femenino", "Masculino", "Otro"}));
        comboBox.setBounds(139, 91, 132, 17);
        contentPane.add(comboBox);

        JLabel lblNewLabel_1_1_1 = new JLabel("Sexo:");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1_1_1.setBounds(35, 89, 123, 17);
        contentPane.add(lblNewLabel_1_1_1);

        JComboBox<String> comboBox_1 = new JComboBox<>();
        comboBox_1.setModel(new DefaultComboBoxModel<>(new String[] {"Ingeniería Civil", "Ingeniería Eléctrica", "Ingeniería Industrial", "Ingeniería en Sistemas", "Ingeniería Mecánica", "Ingeniería Marítima"}));
        comboBox_1.setBounds(139, 133, 132, 17);
        contentPane.add(comboBox_1);

        JButton btnBuscarBecado = new JButton("Buscar becado");
        btnBuscarBecado.setBounds(300, 106, 139, 23);
        contentPane.add(btnBuscarBecado);

        textArea = new JTextArea();
        textArea.setBounds(35, 180, 500, 200);
        contentPane.add(textArea);

        // Inicialización de la estructura de datos
        datosGuardados = new HashMap<>();
        // Ejemplo de datos guardados
        datosGuardados.put("1234567890", new String[]{"Femenino", "Ingeniería Civil", "Elegible para beca"});
        datosGuardados.put("0987654321", new String[]{"Masculino", "Ingeniería en Sistemas", "No elegible para beca"});

        // Adding action listeners for the buttons
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cedula = textField.getText();
                // Buscar en los datos guardados
                if (datosGuardados.containsKey(cedula)) {
                    String[] datos = datosGuardados.get(cedula);
                    String resultado = "Cédula: " + cedula + "\nSexo: " + datos[0] + "\nCarrera: " + datos[1] + "\nElegibilidad: " + datos[2];
                    textArea.setText(resultado);
                } else {
                    textArea.setText("No se encontraron datos para la cédula ingresada.");
                }
            }
        });

        btnBuscarBecado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cedula = textField.getText();
                // Buscar en los datos guardados
                if (datosGuardados.containsKey(cedula)) {
                    String[] datos = datosGuardados.get(cedula);
                    String resultado = "Cédula: " + cedula + "\nSexo: " + datos[0] + "\nCarrera: " + datos[1] + "\nElegibilidad: " + datos[2];
                    textArea.setText(resultado);
                } else {
                    textArea.setText("No se encontraron datos para la cédula ingresada.");
                }
            }
        });
    }
}
