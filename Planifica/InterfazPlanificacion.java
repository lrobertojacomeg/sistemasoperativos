/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planifica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InterfazPlanificacion extends JFrame {

    private JComboBox<String> algoritmosComboBox;
    private JButton ejecutarButton;
    private JTextField quantumField;
    private JPanel panelSimulacion;
    private JTextArea outputArea;
ArrayList<Proceso> procesos = new ArrayList<>();
    public InterfazPlanificacion() {
        setTitle("Simulación de Planificación de Procesos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel de selección de algoritmos
        JPanel panelSeleccion = new JPanel();
        panelSeleccion.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel labelAlgoritmo = new JLabel("Seleccionar Algoritmo:");
        algoritmosComboBox = new JComboBox<>(new String[]{"FCFS", "SJF", "Round Robin", "Prioridad"});

        JLabel labelQuantum = new JLabel("Quantum (para Round Robin):");
        quantumField = new JTextField("3");  // Valor por defecto para Round Robin

        ejecutarButton = new JButton("Ejecutar");

        panelSeleccion.add(labelAlgoritmo);
        panelSeleccion.add(algoritmosComboBox);
        panelSeleccion.add(labelQuantum);
        panelSeleccion.add(quantumField);
        panelSeleccion.add(ejecutarButton);

        add(panelSeleccion, BorderLayout.NORTH);

        // Panel de simulación (área donde los procesos se visualizarán)
        panelSimulacion = new JPanel() {
            
            @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int x = 50;
            int y = 50;
            int width = 100;
            g.setColor(Color.WHITE); 
            g.fillRect(0, 0, 1024, 800); 
            for (Proceso proceso : procesos) {
                g.setColor(Color.BLUE);
                g.fillRect(x, y, proceso.getDuracion() * 10, 50);
                g.setColor(Color.WHITE);
                g.drawString(proceso.getId(), x + 10, y + 30);
                x += proceso.getDuracion() * 10 + 10;
            }
        }

        };
        panelSimulacion.setBackground(Color.WHITE);
        panelSimulacion.setPreferredSize(new Dimension(800, 300));

        add(panelSimulacion, BorderLayout.CENTER);

        // Área de output
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setPreferredSize(new Dimension(800, 150));

        add(scrollPane, BorderLayout.SOUTH);

        // Acción del botón "Ejecutar"
        ejecutarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutarAlgoritmo();
            }
        });
    }

    private void ejecutarAlgoritmo() {
        String algoritmoSeleccionado = (String) algoritmosComboBox.getSelectedItem();
        int quantum = Integer.parseInt(quantumField.getText());

        // Limpia el área de salida y la simulación gráfica
        outputArea.setText("");
        panelSimulacion.repaint();

        // Simulación de procesos para el algoritmo seleccionado
        procesos.clear();
        procesos.add(new Proceso("P1", 3, 3));
        procesos.add(new Proceso("P2", 2, 4));
        procesos.add(new Proceso("P3", 1, 2));
        procesos.add(new Proceso("P4", 0, 5));

        switch (algoritmoSeleccionado) {
            case "FCFS":
                FCFS fcfs = new FCFS(procesos);
                fcfs.ejecutar();
                outputArea.append("Ejecución con FCFS completada.\n");
                break;

            case "SJF":
                SJF sjf = new SJF(procesos);
                sjf.ejecutar();
                outputArea.append("Ejecución con SJF completada.\n");
                break;

            case "Round Robin":
                RoundRobin rr = new RoundRobin(procesos, quantum);
                rr.ejecutar();
                outputArea.append("Ejecución con Round Robin completada.\n");
                break;

            case "Prioridad":
                ArrayList<ProcesoPrioridad> procesosConPrioridad = new ArrayList<>();
                procesosConPrioridad.add(new ProcesoPrioridad("P1", 0, 8, 1));
                procesosConPrioridad.add(new ProcesoPrioridad("P2", 1, 4, 3));
                procesosConPrioridad.add(new ProcesoPrioridad("P3", 2, 9, 2));
                procesosConPrioridad.add(new ProcesoPrioridad("P4", 3, 5, 4));

                Prioridad prioridad = new Prioridad(procesosConPrioridad);
                prioridad.ejecutar();
                outputArea.append("Ejecución con Prioridad completada.\n");
                break;
        }

        // Aquí podrías actualizar la visualización de la ejecución
        panelSimulacion.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfazPlanificacion().setVisible(true);
            }
        });
    }
}

