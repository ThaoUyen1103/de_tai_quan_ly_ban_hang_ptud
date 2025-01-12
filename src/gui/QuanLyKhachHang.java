package gui;

import entity.KhachHang;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;



import dao.KhachHangDAO;

public class QuanLyKhachHang extends javax.swing.JPanel {
	private KhachHangDAO khachHang_DAO = new KhachHangDAO();
    private boolean isThemActive = false;
    private boolean isSuaActive = false;
    private ButtonGroup group_rd = new ButtonGroup();

    public QuanLyKhachHang() {
        initComponents();
        group_gioiTinh();
        designTable();
        tblDanhSachKhachHang();
    }

    private void designTable() {
        tbl_danhSachKhachHang.getTableHeader().setFont(new java.awt.Font("Calibri", 0, 12));
        tbl_danhSachKhachHang.getTableHeader().setOpaque(false);
        tbl_danhSachKhachHang.getTableHeader().setBackground(new Color(198, 226, 255));
        tbl_danhSachKhachHang.getTableHeader().setForeground(new Color(16,54,103));
        tbl_danhSachKhachHang.setDefaultEditor(Object.class, null);
        tbl_danhSachKhachHang.setRowHeight(30);
    }

    private void isThemKhachHangClicked(boolean check) {
        isThemActive = check;
        isSuaActive = !check;

        if (isThemActive) {
            btn_them.setText("Huỷ");
            btn_capNhat.setEnabled(false);
        } else if (isSuaActive) {
            btn_capNhat.setText("Huỷ");
            btn_them.setEnabled(false);
        }

        btn_luu.setEnabled(true);
        isInputActive(true);
    }

    private void huyThaoTac() {
        isSuaActive = false;
        isThemActive = false;
        btn_them.setText("Thêm");
        btn_capNhat.setText("Cập nhật");
        btn_them.setEnabled(true);
        btn_capNhat.setEnabled(true);
        btn_luu.setEnabled(false);
        isInputActive(false);
    }

    private void isInputActive(boolean check) {
        txt_email.setEditable(check);
        txt_hoTen.setEditable(check);
        txt_soDienThoai.setEditable(check);
        rb_gioiTinhNam.setEnabled(check);
        rb_gioiTinhNu.setEnabled(check);
    }

    private void clearInput() {
        txt_email.setText("");
        txt_hoTen.setText("");
        txt_soDienThoai.setText("");
    }

    private void group_gioiTinh() {
        group_rd.add(rb_gioiTinhNam);
        group_rd.add(rb_gioiTinhNu);
        rb_gioiTinhNam.setSelected(true);
    }

    private void tblDanhSachKhachHang() {
        clearTable();
        ArrayList<KhachHang> listKhachHang = khachHang_DAO.getAllKhachHang();
        DefaultTableModel dtm = (DefaultTableModel) tbl_danhSachKhachHang.getModel();

        for (KhachHang kh : listKhachHang) {
            String gioiTinh = "Nam";
            if (kh.getGioiTinh()) {
                gioiTinh = "Nữ";
            }

            Object[] dataRow = {kh.getMaKhachHang(), kh.getHoVaTen(), kh.getEmail(), kh.getSdt(), gioiTinh};
            dtm.addRow(dataRow);
        }
    }

    private void clearTable() {
        DefaultTableModel dtm = (DefaultTableModel) tbl_danhSachKhachHang.getModel();
        dtm.setRowCount(0);
  }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_2 = new javax.swing.JPanel();
        scr_1 = new javax.swing.JScrollPane();
        tbl_danhSachKhachHang = new javax.swing.JTable();
        pnl_3 = new javax.swing.JPanel();
        lbl_hoTen = new javax.swing.JLabel();
        txt_hoTen = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        lbl_email = new javax.swing.JLabel();
        lbl_gioiTinh = new javax.swing.JLabel();
        txt_soDienThoai = new javax.swing.JTextField();
        lbl_soDienThoai = new javax.swing.JLabel();
        rb_gioiTinhNam = new javax.swing.JRadioButton();
        rb_gioiTinhNu = new javax.swing.JRadioButton();
        btn_them = new javax.swing.JButton();
        btn_capNhat = new javax.swing.JButton();
        btn_luu = new javax.swing.JButton();
        lbl_timKiem = new javax.swing.JLabel();
        txt_timKiem = new javax.swing.JTextField();
        btn_tim = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setPreferredSize(new java.awt.Dimension(1124, 768));

        pnl_2.setBackground(new java.awt.Color(255, 255, 255));
        pnl_2.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách khách hàng"));

        tbl_danhSachKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên khách hàng", "Email", "Số điện thoại", "Giới tính"
            }
        ));
        tbl_danhSachKhachHang.setRowHeight(30);
        tbl_danhSachKhachHang.setShowGrid(false);
        tbl_danhSachKhachHang.setShowHorizontalLines(true);
        tbl_danhSachKhachHang.setShowVerticalLines(true);
        tbl_danhSachKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_danhSachKhachHangMouseClicked(evt);
            }
        });
        scr_1.setViewportView(tbl_danhSachKhachHang);

        javax.swing.GroupLayout pnl_2Layout = new javax.swing.GroupLayout(pnl_2);
        pnl_2.setLayout(pnl_2Layout);
        pnl_2Layout.setHorizontalGroup(
            pnl_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scr_1)
                .addContainerGap())
        );
        pnl_2Layout.setVerticalGroup(
            pnl_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scr_1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl_3.setBackground(new java.awt.Color(255, 255, 255));
        pnl_3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N

        lbl_hoTen.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lbl_hoTen.setText("Họ tên:");

        txt_hoTen.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txt_hoTen.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_hoTen.setEditable(false);

        txt_email.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txt_email.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_email.setEditable(false);

        lbl_email.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lbl_email.setText("Email:");

        lbl_gioiTinh.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lbl_gioiTinh.setText("Giới tính:");

        txt_soDienThoai.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txt_soDienThoai.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_soDienThoai.setEditable(false);

        lbl_soDienThoai.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lbl_soDienThoai.setText("Số điện thoại:");

        rb_gioiTinhNam.setText("Nam");
        rb_gioiTinhNam.setEnabled(false);

        rb_gioiTinhNu.setText("Nữ");
        rb_gioiTinhNu.setEnabled(false);

        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Approve.png"))); // NOI18N
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_capNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        btn_capNhat.setText("Cập nhật");
        btn_capNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capNhatActionPerformed(evt);
            }
        });

        btn_luu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Upload.png"))); // NOI18N
        btn_luu.setText("Lưu");
        btn_luu.setEnabled(false);
        btn_luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luuActionPerformed(evt);
            }
        });

        lbl_timKiem.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lbl_timKiem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_timKiem.setText("Tìm theo tên khách hàng:");
        lbl_timKiem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txt_timKiem.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        btn_tim.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btn_tim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        btn_tim.setText("Tìm");
        btn_tim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_timMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_3Layout = new javax.swing.GroupLayout(pnl_3);
        pnl_3.setLayout(pnl_3Layout);
        pnl_3Layout.setHorizontalGroup(
            pnl_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnl_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_3Layout.createSequentialGroup()
                        .addGroup(pnl_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_timKiem)
                            .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 845, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addComponent(btn_tim, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_3Layout.createSequentialGroup()
                        .addGroup(pnl_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_soDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_soDienThoai)
                            .addComponent(txt_hoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_hoTen))
                        .addGap(15, 15, 15)
                        .addGroup(pnl_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_email)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_3Layout.createSequentialGroup()
                                .addGroup(pnl_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_gioiTinh)
                                    .addGroup(pnl_3Layout.createSequentialGroup()
                                        .addComponent(rb_gioiTinhNam)
                                        .addGap(41, 41, 41)
                                        .addComponent(rb_gioiTinhNu)))
                                .addGap(15, 15, 15)
                                .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addComponent(btn_capNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                .addComponent(btn_luu, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(44, 44, 44))
        );
        pnl_3Layout.setVerticalGroup(
            pnl_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_3Layout.createSequentialGroup()
                .addComponent(lbl_timKiem)
                .addGap(0, 0, 0)
                .addGroup(pnl_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tim, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnl_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbl_hoTen)
                        .addGap(2, 2, 2)
                        .addComponent(txt_hoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_soDienThoai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_soDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_3Layout.createSequentialGroup()
                        .addGroup(pnl_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lbl_gioiTinh)
                                .addGap(2, 2, 2)
                                .addGroup(pnl_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rb_gioiTinhNam)
                                    .addComponent(rb_gioiTinhNu))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnl_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_capNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_luu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)))
                        .addGroup(pnl_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnl_3Layout.createSequentialGroup()
                                .addComponent(lbl_email)
                                .addGap(36, 36, 36))
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

   private void tbl_danhSachKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_danhSachKhachHangMouseClicked
        // TODO add your handling code here:
        String id = (String) tbl_danhSachKhachHang.getValueAt(tbl_danhSachKhachHang.getSelectedRow(), 0);
        KhachHang khachHang = khachHang_DAO.getKhachHangById(id);
        if (khachHang == null) {
            System.out.println("Khong tim thay kh");
           return;
        }
       thongTinKhachHang(khachHang);
    }
   //GEN-LAST:event_tbl_danhSachKhachHangMouseClicked

   private void btn_timMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_timMouseClicked
       // TODO add your handling code here:
        if (txt_timKiem.getText().equals("")) {
            tblDanhSachKhachHang();
       } else {
            tblDanhSachKhachHangTheoTen();
        }
    }//GEN-LAST:event_btn_timMouseClicked

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        if (btn_them.getText().equals("Thêm")) {
            isThemKhachHangClicked(true);
            clearInput();
        } else if (btn_them.getText().equals("Huỷ")) {
            clearInput();
            huyThaoTac();
       }
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_capNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capNhatActionPerformed
        // TODO add your handling code here:
        if (tbl_danhSachKhachHang.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn dữ liệu để cập nhật");
            return;
        }

        if (btn_capNhat.getText().equals("Cập nhật")) {
            isThemKhachHangClicked(false);
        } else if (btn_capNhat.getText().equals("Huỷ")) {
            clearInput();
            huyThaoTac();
        }
   }//GEN-LAST:event_btn_capNhatActionPerformed

    private void btn_luuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luuActionPerformed
        // TODO add your handling code here:
        if (isThemActive) {
            themKhachHang();
       } else if (isSuaActive) {
            capNhatKhachHang();
        }
    }//GEN-LAST:event_btn_luuActionPerformed

    private void tblDanhSachKhachHangTheoTen() {
        String tenKhachHang = txt_timKiem.getText();
       clearTable();
        ArrayList<KhachHang> listKhachHang = khachHang_DAO.getKhachHangByName(tenKhachHang);
        DefaultTableModel dtm = (DefaultTableModel) tbl_danhSachKhachHang.getModel();

        for (KhachHang kh : listKhachHang) {
            String gioiTinh = "Nam";
           if (kh.getGioiTinh()) {
               gioiTinh = "Nữ";
           }

           Object[] dataRow = {kh.getMaKhachHang(), kh.getHoVaTen(), kh.getEmail(), kh.getSdt(), gioiTinh};
            dtm.addRow(dataRow);
        }
    }

    private boolean validateData() {
        if (txt_email.getText().equals("") || txt_soDienThoai.getText().equals("") || txt_hoTen.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
            return false;
        }

        return true;
    }

    private void themKhachHang() {
        if (!validateData()) {
            return;
       }

       String hoVaTen = txt_hoTen.getText();
       String email = txt_email.getText();
       String sdt = txt_soDienThoai.getText();
       boolean gioiTinh = false;
        if (rb_gioiTinhNu.isSelected()) {
            gioiTinh = true;
       }

       KhachHang khachHang = new KhachHang(hoVaTen, email, sdt, gioiTinh);

        if (khachHang_DAO.addKhachHang(khachHang) != -1) {
            JOptionPane.showMessageDialog(null, "Thêm thành công");
            tblDanhSachKhachHang();
            clearInput();
            huyThaoTac();
            return;
        }

       JOptionPane.showMessageDialog(null, "Thêm thất bại");
    }

    private void capNhatKhachHang() {
        if (!validateData()) {
           return;
        }

       KhachHang khachHang = khachHang_DAO.getKhachHangById((String) tbl_danhSachKhachHang.getValueAt(tbl_danhSachKhachHang.getSelectedRow(), 0));
        khachHang.setEmail(txt_email.getText());
        khachHang.setHoVaTen(txt_hoTen.getText());
        khachHang.setSdt(txt_soDienThoai.getText());
        boolean gioiTinh = rb_gioiTinhNu.isSelected();
        khachHang.setGioiTinh(gioiTinh);

        if (khachHang_DAO.updateKhachHang(khachHang) != -1) {
           JOptionPane.showMessageDialog(null, "Cập nhật thành công");
           tblDanhSachKhachHang();
            clearInput();
            huyThaoTac();
            return;
       }

       JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
    }


    
    private void thongTinKhachHang(KhachHang khachHang) {
        txt_email.setText(khachHang.getEmail());
        txt_hoTen.setText(khachHang.getHoVaTen());
        txt_soDienThoai.setText(khachHang.getSdt());
        if (khachHang.getGioiTinh()) {
            rb_gioiTinhNu.setSelected(true);
        } else {
            rb_gioiTinhNam.setSelected(true);
        }
    }
    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {
        if (tbl_danhSachKhachHang.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn dữ liệu để xoá");
            return;
        }

        String maKhachHang = tbl_danhSachKhachHang.getValueAt(tbl_danhSachKhachHang.getSelectedRow(), 0).toString();
        if (khachHang_DAO.xoaKhachHang(maKhachHang) != -1) {
            if (khachHang_DAO.xoaKhachHang(maKhachHang) == -1) {
                JOptionPane.showMessageDialog(null, "xoá thất bại");
                return;
            }
            JOptionPane.showMessageDialog(null, "Xoá thành công");
            tblDanhSachKhachHang();
            clearInput();
            return;
        };

        JOptionPane.showMessageDialog(null, "Xoá thất bại");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_capNhat;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JButton btn_luu;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_tim;
    private javax.swing.JPanel pnl_2;
    private javax.swing.JPanel pnl_3;
    private javax.swing.JScrollPane scr_1;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_gioiTinh;
    private javax.swing.JLabel lbl_hoTen;
    private javax.swing.JLabel lbl_soDienThoai;
    private javax.swing.JLabel lbl_timKiem;
    private javax.swing.JRadioButton rb_gioiTinhNam;
    private javax.swing.JRadioButton rb_gioiTinhNu;
    private javax.swing.JTable tbl_danhSachKhachHang;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_hoTen;
    private javax.swing.JTextField txt_soDienThoai;
    private javax.swing.JTextField txt_timKiem;
    // End of variables declaration//GEN-END:variables
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
       } catch (ClassNotFoundException ex) {
          java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       //</editor-fold>
    }
}
