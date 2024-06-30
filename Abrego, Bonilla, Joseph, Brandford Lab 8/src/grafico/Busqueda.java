package grafico;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import logica.Estudiantes;
import java.awt.SystemColor;
import javax.swing.JOptionPane;

public class Busqueda extends JFrame {

    public static final long serialVersionUID = 1L;
    public JPanel contentPane;
    public JTextField textField;
    public JTextArea textAreaBecados;
    public JComboBox<String> comboBoxCarreras;
    public JComboBox<String> comboBoxSexo;
    public JButton btnBsquedaDeBecados;
    public JLabel lblResultadosDeLa;
    public JButton btnFormulario;
    public JButton btnReportes;

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

    public Busqueda() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 707, 568);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.activeCaption);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblBusqueda = new JLabel("Búsqueda");
        lblBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblBusqueda.setBounds(289, 26, 149, 46);
        contentPane.add(lblBusqueda);

        JLabel lblNewLabel_1_1_1 = new JLabel("Cédula:");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1_1.setBounds(46, 102, 95, 22);
        contentPane.add(lblNewLabel_1_1_1);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField.setColumns(10);
        textField.setBounds(141, 103, 153, 19);
        contentPane.add(textField);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(379, 110, 235, 286); // Adjusted size to fit the area properly
        contentPane.add(scrollPane);

        textAreaBecados = new JTextArea();
        scrollPane.setViewportView(textAreaBecados);

        JButton btnMostrarB = new JButton("Mostrar Búsqueda");
        btnMostrarB.setBackground(SystemColor.textHighlightText);
        btnMostrarB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cedula = textField.getText().trim();
                Estudiantes encontrado = buscarEstudiantePorCedula(cedula);
                if (encontrado != null) {
                    textAreaBecados.setText("Nombre: " + encontrado.getNombre() + "\n"
                            + "Cédula: " + encontrado.getCedula() + "\n"
                            + "Carrera: " + encontrado.getCarrera() + "\n"
                            + "Índice Académico: " + encontrado.getIndiceAcademico() + "\n"
                            + "Sexo: " + encontrado.getSexo());
                } else {
                    textAreaBecados.setText("");
                    JOptionPane.showMessageDialog(null, "No se encontró ningún estudiante con esa cédula.");
                }
            }
        });

        btnMostrarB.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnMostrarB.setBounds(65, 149, 184, 34);
        contentPane.add(btnMostrarB);

        comboBoxCarreras = new JComboBox<String>();
        comboBoxCarreras.setModel(new DefaultComboBoxModel<String>(new String[] { "Ingeniería Civil", "Ingeniería Eléctrica",
                "Ingeniería Industrial", "Ingeniería en Sistemas", "Ingeniería Mecánica", "Ingeniería Marítima" }));
        comboBoxCarreras.setSelectedIndex(-1);
        comboBoxCarreras.setBounds(141, 212, 153, 21);
        contentPane.add(comboBoxCarreras);

        JLabel lblNewLabel_1_1 = new JLabel("Carrera:");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1.setBounds(46, 208, 95, 22);
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_1_2 = new JLabel("Sexo:");
        lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1_2.setBounds(46, 270, 95, 22);
        contentPane.add(lblNewLabel_1_1_2);

        comboBoxSexo = new JComboBox<String>();
        comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Femenino", "Otro"}));
        comboBoxSexo.setSelectedIndex(-1);
        comboBoxSexo.setBounds(141, 274, 153, 21);
        contentPane.add(comboBoxSexo);

        btnBsquedaDeBecados = new JButton("Búsqueda de becados");
        btnBsquedaDeBecados.setBackground(SystemColor.textHighlightText);
        btnBsquedaDeBecados.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String carrera = (String) comboBoxCarreras.getSelectedItem();
                String sexo = (String) comboBoxSexo.getSelectedItem();
                ArrayList<Estudiantes> estudiantesBecados = buscarEstudiantesPorCarreraYSexo(carrera, sexo);
                if (estudiantesBecados.isEmpty()) {
                    textAreaBecados.setText("");
                    JOptionPane.showMessageDialog(null, "No se encontraron estudiantes becados con los datos ingresados.");
                } else {
                    mostrarEstudiantesBecados(estudiantesBecados);
                }
            }
        });
        btnBsquedaDeBecados.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnBsquedaDeBecados.setBounds(65, 336, 207, 34);
        contentPane.add(btnBsquedaDeBecados);

        lblResultadosDeLa = new JLabel("Resultados de la búsqueda:");
        lblResultadosDeLa.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblResultadosDeLa.setBounds(379, 78, 235, 46);
        contentPane.add(lblResultadosDeLa);

        btnFormulario = new JButton("Formulario");
        btnFormulario.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnFormulario.setBackground(SystemColor.textHighlightText);
        btnFormulario.setBounds(65, 427, 207, 34);
        contentPane.add(btnFormulario);

        btnReportes = new JButton("Reportes");
        btnReportes.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnReportes.setBackground(SystemColor.textHighlightText);
        btnReportes.setBounds(397, 427, 207, 34);
        contentPane.add(btnReportes);

        btnReportes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Reportes reportes = new Reportes();
                reportes.setVisible(true);
            }
        });

        btnFormulario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Formulario formulario = new Formulario();
                formulario.setVisible(true);
            }
        });
    }

    public Estudiantes buscarEstudiantePorCedula(String cedula) {
        for (Estudiantes estudiante : Formulario.estudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                return estudiante;
            }
        }
        return null;
    }

    public ArrayList<Estudiantes> buscarEstudiantesPorCarreraYSexo(String carrera, String sexo) {
        ArrayList<Estudiantes> estudiantesBecados = new ArrayList<>();

        for (Estudiantes estudiante : Formulario.estudiantes) {
            if (estudiante.getIndiceAcademico() >= 2.0 && estudiante.getCarrera().equals(carrera)
                    && estudiante.getSexo().equals(sexo)) {
                estudiantesBecados.add(estudiante);
            }
        }

        return estudiantesBecados;
    }

    public void mostrarEstudiantesBecados(ArrayList<Estudiantes> estudiantes) {
        StringBuilder sb = new StringBuilder();
        for (Estudiantes estudiante : estudiantes) {
            sb.append("Nombre: ").append(estudiante.getNombre()).append("\n")
                    .append("Cédula: ").append(estudiante.getCedula()).append("\n")
                    .append("Carrera: ").append(estudiante.getCarrera()).append("\n")
                    .append("Índice Académico: ").append(estudiante.getIndiceAcademico()).append("\n")
                    .append("Sexo: ").append(estudiante.getSexo()).append("\n\n");
        }
        textAreaBecados.setText(sb.toString());
    }
}

