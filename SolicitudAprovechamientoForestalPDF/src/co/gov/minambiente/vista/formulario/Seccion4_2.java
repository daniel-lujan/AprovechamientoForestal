package co.gov.minambiente.vista.formulario;

import co.gov.minambiente.controlador.ControladorSolicitud;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Natalia García
 */
public class Seccion4_2 extends javax.swing.JFrame {

    private ControladorSolicitud controlador;

    public Seccion4_2(ControladorSolicitud controlador) {
        initComponents();
        this.controlador = controlador;
        this.setLocationRelativeTo(null);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                volverAlMenu();
            }
        });
    }

    private void volverAlMenu(){
        if (JOptionPane.showConfirmDialog(null, "Si vuelve al menú principal, perderá los datos diligenciados. ¿Está seguro?") == 0) {
            this.dispose();
            controlador.mostrarPrincipal();
        }
    }
    
    private Object[] getRowPlane(int row){
        Object[] array = new Object[3];
        array[0] = (short)tblPlanas.getValueAt(row, 0);
        array[1] = tblPlanas.getValueAt(row, 1);
        array[2] = tblPlanas.getValueAt(row, 2);
        return array;
    }
    
    private Object[] getRowGeographic(int row){
        Object[] array = new Object[5];
        ArrayList latitude = new ArrayList();
        latitude.add((String)tblGeograficas.getValueAt(row, 1));
        latitude.add((String)tblGeograficas.getValueAt(row, 2));
        latitude.add((String)tblGeograficas.getValueAt(row, 3));
        ArrayList longitude = new ArrayList();
        longitude.add((String)tblGeograficas.getValueAt(row, 4));
        longitude.add((String)tblGeograficas.getValueAt(row, 5));
        longitude.add((String)tblGeograficas.getValueAt(row, 6));
        array[0] = latitude;
        array[1] = longitude;
        array[2] = (double)tblGeograficas.getValueAt(row, 7);
        array[3] = (String)jTextField1.getText();
        array[4] = (short)tblGeograficas.getValueAt(row,0);
        return array;
    }
   
    private boolean geoTableRowIsEmpty(int row){
        return (String)tblGeograficas.getValueAt(row, 1) == null &&
                (String)tblGeograficas.getValueAt(row,2) == null &&
                (String)tblGeograficas.getValueAt(row,3) == null &&
                (String)tblGeograficas.getValueAt(row,4) == null &&
                (String)tblGeograficas.getValueAt(row,5) == null &&
                (String)tblGeograficas.getValueAt(row,6) == null &&
                (String)tblGeograficas.getValueAt(row,7) == null;
    }
    
    private LinkedList<Object[]> getInfoList(){
        LinkedList<Object[]> list = new LinkedList();
        Object[] row;
        if (cblCoordenadasPlanas.isSelected()){
            for (int i = 0; i < 12; i++){
                row = getRowPlane(i);
                if (row[1] == null || row[2] == null){
                    break;
                }
                list.add(row);
            }
        } else if (cblCoordenadasGeograficas.isSelected()) {
            for (int i = 0; i < 12; i++){
                if (!geoTableRowIsEmpty(i)){
                    row = getRowGeographic(i);
                    list.add(row);
                } else{
                    break;
                }
            }
        }
        System.out.println("LIST: "+list);
        return list;
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblGeograficas = new javax.swing.JTable();
        btnSiguiente = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPlanas = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel34 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cblCoordenadasPlanas = new javax.swing.JRadioButton();
        cblCoordenadasGeograficas = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btnPrincipal = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel1.setText("4. Información general del predio");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel2.setText("4.2. Coordenadas del área objeto de la solicitud: ");

        jLabel4.setText("Tipo de coordenadas:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Coordenadas planas", "Coordenadas geográficas" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        jLabel13.setText("Nota: Para los aprovechamientos naturales domésticos del bosque natural, de árboles aislados y el manejo sostenible doméstico de la");
        jLabel13.setToolTipText("");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Punto", "Grados", "Minutos", "Segundos", "Grados", "Minutos", "Segundos", "Altitud"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel15.setText("Coordenadas Planas");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Punto", "X", "Y"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel16.setText("Coordenadas Geográficas");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel17.setText("Longitud");
        jPanel1.add(jLabel17);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel18.setText("Latitud");
        jPanel2.add(jLabel18);

        jLabel14.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        jLabel14.setText("Diligencie el listado de coordenadas según sea el caso:");

        jLabel20.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        jLabel20.setText("flora y fauna silvestre y de los productos forestales no maderables, la autoridad forestal competente en la visita, tomará las coordenadas");

        jLabel21.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        jLabel21.setText("Para los aprovechamientos forestales persistentes y únicos de bosque natual, y para el manejo pesistente de la flora silvestre y los");
        jLabel21.setToolTipText("");

        jLabel23.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        jLabel23.setText("productos forestales no maderables, se deberá señalar:");

        jLabel22.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        jLabel22.setText("En caso de seleccionar coordenadas planas, las mismas deberán corresponder al Origen único CTM-12, conforme a lo establecido en la");
        jLabel22.setToolTipText("");

        jLabel24.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        jLabel24.setText("Resolución 471 de 2020, modificada por la Resolución 529 de 2020, proferida por el Instituto Geográfico Agustín Codazzi, y para las");

        jLabel25.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        jLabel25.setText("planas o geográficas respectivas.");

        jLabel28.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        jLabel28.setText("coordenadas geográficas utilizar el sistema de coordenadas Magna-Sirgas.");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1057, 653));

        jPanel5.setToolTipText("");

        jLabel19.setFont(new java.awt.Font("Arial Narrow", 2, 13)); // NOI18N
        jLabel19.setText("Nota: Para los aprovechamientos naturales domésticos del bosque natural, de árboles aislados y el manejo sostenible doméstico de la flora y fauna silvestre y de los");
        jLabel19.setToolTipText("");

        jLabel38.setFont(new java.awt.Font("Arial Narrow", 2, 13)); // NOI18N
        jLabel38.setText("Magna-Sirgas.");
        jLabel38.setToolTipText("");

        tblGeograficas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Short((short) 1), null, null, null, null, null, null, null},
                { new Short((short) 2), null, null, null, null, null, null, null},
                { new Short((short) 3), null, null, null, null, null, null, null},
                { new Short((short) 4), null, null, null, null, null, null, null},
                { new Short((short) 5), null, null, null, null, null, null, null},
                { new Short((short) 6), null, null, null, null, null, null, null},
                { new Short((short) 7), null, null, null, null, null, null, null},
                { new Short((short) 8), null, null, null, null, null, null, null},
                { new Short((short) 9), null, null, null, null, null, null, null},
                { new Short((short) 10), null, null, null, null, null, null, null},
                { new Short((short) 11), null, null, null, null, null, null, null},
                { new Short((short) 12), null, null, null, null, null, null, null}
            },
            new String [] {
                "Punto", "Grados", "Minutos", "Segundos", "Grados", "Minutos", "Segundos", "Altitud"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Short.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGeograficas.setEnabled(false);
        jScrollPane3.setViewportView(tblGeograficas);

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSiguienteMouseClicked(evt);
            }
        });

        btnAnterior.setText("Anterior");
        btnAnterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAnteriorMouseClicked(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel26.setText("Coordenadas Planas");

        tblPlanas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Short((short) 1), null, null},
                { new Short((short) 2), null, null},
                { new Short((short) 3), null, null},
                { new Short((short) 4), null, null},
                { new Short((short) 5), null, null},
                { new Short((short) 6), null, null},
                { new Short((short) 7), null, null},
                { new Short((short) 8), null, null},
                { new Short((short) 9), null, null},
                { new Short((short) 10), null, null},
                { new Short((short) 11), null, null},
                { new Short((short) 12), null, null}
            },
            new String [] {
                "Punto", "X", "Y"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Short.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPlanas.setEnabled(false);
        jScrollPane4.setViewportView(tblPlanas);

        jLabel31.setFont(new java.awt.Font("Arial Narrow", 2, 13)); // NOI18N
        jLabel31.setText("Diligencie el listado de coordenadas según sea el caso:");

        jLabel32.setFont(new java.awt.Font("Arial Narrow", 2, 13)); // NOI18N
        jLabel32.setText("productos forestales no maderables, la autoridad forestal competente en la visita, tomará las coordenadas planas o geográficas respectivas.");

        jLabel27.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel27.setText("Coordenadas Geográficas");

        jLabel33.setFont(new java.awt.Font("Arial Narrow", 2, 13)); // NOI18N
        jLabel33.setText("Para los aprovechamientos forestales persistentes y únicos de bosque natual, y para el manejo pesistente de la flora silvestre y los productos forestales no maderables,");
        jLabel33.setToolTipText("");

        jLabel34.setFont(new java.awt.Font("Arial Narrow", 2, 13)); // NOI18N
        jLabel34.setText("se deberá señalar:");

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel5.setText("4.2. Coordenadas del área objeto de la solicitud: ");

        jLabel35.setFont(new java.awt.Font("Arial Narrow", 2, 13)); // NOI18N
        jLabel35.setText("En caso de seleccionar coordenadas planas, las mismas deberán corresponder al Origen único CTM-12, conforme a lo establecido en la Resolución 471 de 2020,");
        jLabel35.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Tipo de coordenadas:");

        jLabel36.setFont(new java.awt.Font("Arial Narrow", 2, 13)); // NOI18N
        jLabel36.setText("modificada por la Resolución 529 de 2020, proferida por el Instituto Geográfico Agustín Codazzi, y para las coordenadas geográficas utilizar el sistema de coordenadas");
        jLabel36.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel3.setText("4. Información general del predio");

        buttonGroup3.add(cblCoordenadasPlanas);
        cblCoordenadasPlanas.setText("Coordenadas Planas");
        cblCoordenadasPlanas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cblCoordenadasPlanasActionPerformed(evt);
            }
        });

        buttonGroup3.add(cblCoordenadasGeograficas);
        cblCoordenadasGeograficas.setText("Coordenadas Geográficas");
        cblCoordenadasGeograficas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cblCoordenadasGeograficasActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Longitud");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Latitud");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Origen: ");

        jTextField1.setEnabled(false);

        btnPrincipal.setText("Volver a la ventana principal");
        btnPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrincipalMouseClicked(evt);
            }
        });
        btnPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrincipalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel3))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel5))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33)))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel6)
                .addGap(67, 67, 67)
                .addComponent(cblCoordenadasPlanas)
                .addGap(10, 10, 10)
                .addComponent(cblCoordenadasGeograficas))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel31))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jLabel26)
                .addGap(380, 380, 380)
                .addComponent(jLabel27))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(570, 570, 570)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(590, 590, 590)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnAnterior)
                        .addGap(17, 17, 17)
                        .addComponent(btnPrincipal))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel19)))
                .addComponent(btnSiguiente))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel33))
                .addGap(2, 2, 2)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel6))
                    .addComponent(cblCoordenadasPlanas)
                    .addComponent(cblCoordenadasGeograficas))
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel35)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(jLabel31)
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27))
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAnterior)
                                    .addComponent(btnPrincipal)))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(btnSiguiente))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void cblCoordenadasGeograficasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cblCoordenadasGeograficasActionPerformed
        setEnabledSection4_2(false);
        setEnabledSection4_2_1(true);
    }//GEN-LAST:event_cblCoordenadasGeograficasActionPerformed

    private void cblCoordenadasPlanasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cblCoordenadasPlanasActionPerformed
        setEnabledSection4_2(true);
        setEnabledSection4_2_1(false);
    }//GEN-LAST:event_cblCoordenadasPlanasActionPerformed

    private void btnAnteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnteriorMouseClicked
        this.setVisible(false);
        this.controlador.mostrarSeccion4_1();
    }//GEN-LAST:event_btnAnteriorMouseClicked

    private void btnSiguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSiguienteMouseClicked
         if (this.controlador.guardarInformacionSeccion4_2(getInfoList())){
            this.setVisible(false);
            this.controlador.mostrarSeccion5_1();
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese todos los datos solicitados.","INFO", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSiguienteMouseClicked

    private void btnPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrincipalMouseClicked
        int opcion = JOptionPane.showConfirmDialog(null, "Toda la información escrita previamente se eliminará", "¿Está seguro?", JOptionPane.YES_NO_OPTION);
        if(opcion == 0){
            this.setVisible(false);
            controlador.mostrarPrincipal();
        } 
    }//GEN-LAST:event_btnPrincipalMouseClicked

    private void btnPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrincipalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrincipalActionPerformed
    private void setEnabledSection4_2(boolean state) {
        tblPlanas.setEnabled(state);
        jTextField1.setEnabled(!state);
    }

    private void setEnabledSection4_2_1(boolean state) {
        tblGeograficas.setEnabled(state);
        jTextField1.setEnabled(state);
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnPrincipal;
    public javax.swing.JButton btnSiguiente;
    private javax.swing.ButtonGroup buttonGroup3;
    public javax.swing.JRadioButton cblCoordenadasGeograficas;
    public javax.swing.JRadioButton cblCoordenadasPlanas;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    public javax.swing.JTable tblGeograficas;
    public javax.swing.JTable tblPlanas;
    // End of variables declaration//GEN-END:variables
}
