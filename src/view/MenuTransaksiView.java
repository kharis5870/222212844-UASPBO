/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import db.Koneksi;
import controller.TransaksiController;
import java.awt.HeadlessException;
import model.Transaksi;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MenuModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Kharis
 */
public final class MenuTransaksiView extends javax.swing.JFrame {
    private final TransaksiController transaksiController;
    private final DefaultTableModel model;

    /**
     * Creates new form menu_makanan
     */
    public MenuTransaksiView() {
        initComponents();
        transaksiController = new TransaksiController();
        model = new DefaultTableModel();
        setupTableModel();
        refreshTable();
        refreshCombo();
    }

    private void setupTableModel() {
        model.setColumnIdentifiers(new String[] {
                "ID Transaksi", "Nama Pelanggan", "ID Menu", "Tanggal",
                "Nama Menu", "Harga", "Jumlah Beli", "Total Bayar"
        });
        table_transaksi.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        text_id_transaksi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        text_nama_pelanggan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        combo_id_menu = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_transaksi = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btn_update = new javax.swing.JButton();
        btn_input = new javax.swing.JButton();
        btn_cetak_laporan = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        btn_menu_kantin = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        text_jml_beli = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        text_total_bayar = new javax.swing.JTextField();
        text_tanggal = new com.toedter.calendar.JDateChooser();
        btn_registrasi = new javax.swing.JButton();
        btn_chat_server = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TRANSAKSI");

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel2.setText("ID Transaksi");

        text_id_transaksi.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        text_id_transaksi.setEnabled(false);
        text_id_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_id_transaksiActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel3.setText("Nama Pelanggan");

        text_nama_pelanggan.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        text_nama_pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_nama_pelangganActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel5.setText("Tanggal");

        combo_id_menu.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N

        table_transaksi.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null }
                },
                new String[] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }));
        table_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_transaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_transaksi);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_update.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        btn_update.setText("UPDATE");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_input.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        btn_input.setText("INPUT");
        btn_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inputActionPerformed(evt);
            }
        });

        btn_cetak_laporan.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        btn_cetak_laporan.setText("CETAK LAPORAN");
        btn_cetak_laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetak_laporanActionPerformed(evt);
            }
        });

        btn_delete.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        btn_delete.setText("DELETE");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btn_input, javax.swing.GroupLayout.PREFERRED_SIZE, 117,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 117,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 117,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_cetak_laporan, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btn_input, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_cetak_laporan, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(20, Short.MAX_VALUE)));

        btn_logout.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        btn_logout.setText("LOGOUT");
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        btn_menu_kantin.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        btn_menu_kantin.setText("LIHAT MENU");
        btn_menu_kantin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_menu_kantinActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel6.setText("ID Menu");

        jLabel4.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel4.setText("Jumlah Beli");

        text_jml_beli.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        text_jml_beli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_jml_beliActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel7.setText("Total Bayar");

        text_total_bayar.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        text_total_bayar.setEnabled(false);
        text_total_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_total_bayarActionPerformed(evt);
            }
        });

        text_tanggal.setToolTipText("");
        text_tanggal.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N

        btn_registrasi.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        btn_registrasi.setText("MENU REGISTRASI");
        btn_registrasi.setEnabled(false);
        btn_registrasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrasiActionPerformed(evt);
            }
        });

        btn_chat_server.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        btn_chat_server.setText("CHAT");
        btn_chat_server.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chat_serverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(6, 6, 6)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(text_nama_pelanggan,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 416,
                                                                Short.MAX_VALUE)
                                                        .addComponent(text_id_transaksi)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
                                                                .createSequentialGroup()
                                                                .addComponent(jLabel5,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 182,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(jLabel6,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 182,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(combo_id_menu,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 238,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btn_menu_kantin,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 172,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(text_jml_beli)
                                                        .addComponent(text_total_bayar)
                                                        .addComponent(text_tanggal,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(btn_registrasi)
                                                                .addGap(322, 322, 322)
                                                                .addComponent(btn_logout,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 105,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(btn_chat_server,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 128,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btn_logout)
                                        .addComponent(btn_registrasi))
                                .addGap(5, 5, 5)
                                .addComponent(btn_chat_server, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(text_id_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(4, 4, 4)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(text_nama_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btn_menu_kantin, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(combo_id_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel6)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(text_tanggal, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 35,
                                                Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(text_jml_beli, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(text_total_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void text_id_transaksiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_text_id_transaksiActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_text_id_transaksiActionPerformed

    private void text_nama_pelangganActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_text_nama_pelangganActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_text_nama_pelangganActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        try {
            Transaksi tran = new Transaksi();
            tran.setId_transaksi(Integer.parseInt(text_id_transaksi.getText()));
            tran.setNama_pelanggan(text_nama_pelanggan.getText());
            String[] menuData = combo_id_menu.getSelectedItem().toString().split(":");
            tran.setId_menu(Integer.parseInt(menuData[0]));
            tran.setNama_menu(menuData[1]);
            tran.setHarga(Integer.parseInt(menuData[2]));
            tran.setJumlah_beli(Integer.parseInt(text_jml_beli.getText()));

            // Mengatur tanggal transaksi
            tran.setTanggal(LocalDate.now().toString());

            // Menghitung total bayar
            int harga = tran.getHarga();
            int jumlahBeli = tran.getJumlah_beli();
            int totalBayar = harga * jumlahBeli;
            tran.setTotal_bayar(totalBayar);
            text_total_bayar.setText(Integer.toString(totalBayar));

            transaksiController.updateTransaksi(tran);

            refreshTable();
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }// GEN-LAST:event_btn_updateActionPerformed

    private void btn_inputActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_inputActionPerformed
        // TODO add your handling code here:
        try {
            Transaksi tran = new Transaksi();
            tran.setNama_pelanggan(text_nama_pelanggan.getText());
            String[] menuData = combo_id_menu.getSelectedItem().toString().split(":");
            tran.setId_menu(Integer.parseInt(menuData[0]));
            tran.setNama_menu(menuData[1]);
            tran.setHarga(Integer.parseInt(menuData[2]));
            tran.setJumlah_beli(Integer.parseInt(text_jml_beli.getText()));

            // Mengatur tanggal transaksi
            tran.setTanggal(LocalDate.now().toString());

            // Menghitung total bayar
            int harga = tran.getHarga();
            int jumlahBeli = tran.getJumlah_beli();
            int totalBayar = harga * jumlahBeli;
            tran.setTotal_bayar(totalBayar);

            int pilihan = JOptionPane.showConfirmDialog(null,
                    "Tanggal: " + tran.getTanggal() +
                            "\nNama Pelanggan: " + tran.getNama_pelanggan() +
                            "\nPembelian : " + tran.getJumlah_beli() + " " + tran.getNama_menu() +
                            "\nTotal Bayar: " + tran.getTotal_bayar() + "\n",
                    "Tambahkan Transaksi?",
                    JOptionPane.YES_NO_OPTION);

            if (pilihan == JOptionPane.YES_OPTION) {
                transaksiController.insertTransaksi(tran);
                refreshTable();
            } else {
                refreshTable();
            }
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }// GEN-LAST:event_btn_inputActionPerformed

    private void btn_cetak_laporanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_cetak_laporanActionPerformed
        // TODO add your handling code here:
        try {
            String namaFile = "src/laporan/laporan_transaksi.jasper";
            JasperPrint jp = JasperFillManager.fillReport(new FileInputStream(namaFile), null, Koneksi.connectDB());
            JasperViewer.viewReport(jp, false);
        } catch (FileNotFoundException | JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }// GEN-LAST:event_btn_cetak_laporanActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        try {
            int id_transaksi = Integer.parseInt(text_id_transaksi.getText());
            transaksiController.deleteTransaksi(id_transaksi);
            refreshTable();
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }// GEN-LAST:event_btn_deleteActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_logoutActionPerformed
        // TODO add your handling code here:
        LoginView l = new LoginView();
        l.setVisible(true);
        this.setVisible(false);
    }// GEN-LAST:event_btn_logoutActionPerformed

    private void text_jml_beliActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_text_jml_beliActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_text_jml_beliActionPerformed

    private void text_total_bayarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_text_total_bayarActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_text_total_bayarActionPerformed

    private void table_transaksiMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_table_transaksiMouseClicked
        // TODO add your handling code here:
        int selectedRow = table_transaksi.getSelectedRow();

        if (selectedRow != -1) {
            text_id_transaksi.setText(table_transaksi.getValueAt(selectedRow, 0).toString());
            text_nama_pelanggan.setText(table_transaksi.getValueAt(selectedRow, 1).toString());
            text_jml_beli.setText(table_transaksi.getValueAt(selectedRow, 6).toString());
            text_total_bayar.setText(table_transaksi.getValueAt(selectedRow, 7).toString());

            String idMenu = table_transaksi.getValueAt(selectedRow, 2).toString();
            String namaMenu = table_transaksi.getValueAt(selectedRow, 4).toString();
            String harga = table_transaksi.getValueAt(selectedRow, 5).toString();

            combo_id_menu.setSelectedItem(idMenu + ":" + namaMenu + ":" + harga);
        }
    }// GEN-LAST:event_table_transaksiMouseClicked

    private void btn_menu_kantinActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_menu_kantinActionPerformed
        // TODO add your handling code here:
        MenuKantinView menu = new MenuKantinView();
        menu.setVisible(true);
        this.setVisible(false);
        menu.btn_delete.setEnabled(true);
        menu.btn_input.setEnabled(true);
        menu.btn_update.setEnabled(true);
        menu.btn_transaksi1.setEnabled(true);
    }// GEN-LAST:event_btn_menu_kantinActionPerformed

    private void btn_registrasiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_registrasiActionPerformed
        // TODO add your handling code here:
        MenuRegistrasiView reg = new MenuRegistrasiView();
        reg.setVisible(true);
        this.setVisible(false);
    }// GEN-LAST:event_btn_registrasiActionPerformed

    private void btn_chat_serverActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_chat_serverActionPerformed
        // TODO add your handling code here:
        ServerView chat = ServerView.getInstance();
        chat.setVisible(true);
    }// GEN-LAST:event_btn_chat_serverActionPerformed

    private void refreshTable() {
        try {
            List<Transaksi> transaksiList = transaksiController.getAllTransaksi();
            DefaultTableModel Model = (DefaultTableModel) table_transaksi.getModel();
            Model.setRowCount(0); // Clear the table

            for (Transaksi tran : transaksiList) {
                Object[] row = {
                        tran.getId_transaksi(),
                        tran.getNama_pelanggan(),
                        tran.getId_menu(),
                        tran.getTanggal(),
                        tran.getNama_menu(),
                        tran.getHarga(),
                        tran.getJumlah_beli(),
                        tran.getTotal_bayar()
                };
                Model.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void refreshCombo() {
        try {
            combo_id_menu.removeAllItems();
            List<MenuModel> menuList = transaksiController.getAllMenu();
            for (MenuModel menu : menuList) {
                combo_id_menu.addItem(menu.getId_menu() + ":" + menu.getNama_menu() + ":" + menu.getHarga());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // </editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MenuTransaksiView().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_cetak_laporan;
    public javax.swing.JButton btn_chat_server;
    public javax.swing.JButton btn_delete;
    public javax.swing.JButton btn_input;
    public javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_menu_kantin;
    public javax.swing.JButton btn_registrasi;
    public javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> combo_id_menu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_transaksi;
    private javax.swing.JTextField text_id_transaksi;
    private javax.swing.JTextField text_jml_beli;
    private javax.swing.JTextField text_nama_pelanggan;
    private com.toedter.calendar.JDateChooser text_tanggal;
    private javax.swing.JTextField text_total_bayar;
    // End of variables declaration//GEN-END:variables
}
