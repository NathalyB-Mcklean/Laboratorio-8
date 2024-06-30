package grafico;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Busqueda extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;

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

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Femenino", "Masculino", "Otro"}));
        comboBox.setBounds(139, 91, 132, 17);
        contentPane.add(comboBox);

        JLabel lblNewLabel_1_1_1 = new JLabel("Sexo:");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1_1_1.setBounds(35, 89, 123, 17);
        contentPane.add(lblNewLabel_1_1_1);

        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Ingeniería Civil", "Ingeniería Eléctrica", "Ingeniería Industrial", "Ingeniería en Sistemas", "Ingeniería Mecánica", "Ingeniería Marítima"}));
        comboBox_1.setBounds(139, 133, 132, 17);
        contentPane.add(comboBox_1);

        JButton btnBuscarBecado = new JButton("Buscar becado");
        btnBuscarBecado.setBounds(300, 106, 139, 23);
        contentPane.add(btnBuscarBecado);

        // Adding action listeners for the buttons
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cedula = textField.getText();
                String sexo = comboBox.getSelectedItem().toString();
                String carrera = comboBox_1.getSelectedItem().toString();
                // Add your search logic here
                JOptionPane.showMessageDialog(null, "Buscar: \nCédula: " + cedula + "\nSexo: " + sexo + "\nCarrera: " + carrera);
            }
        });

        btnBuscarBecado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cedula = textField.getText();
                String sexo = comboBox.getSelectedItem().toString();
                String carrera = comboBox_1.getSelectedItem().toString();
                // Add your search logic for "Buscar becado" here
                JOptionPane.showMessageDialog(null, "Buscar becado: \nCédula: " + cedula + "\nSexo: " + sexo + "\nCarrera: " + carrera);
            }
        });
    }
}
