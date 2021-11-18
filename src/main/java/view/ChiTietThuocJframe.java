/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JLabel;

import controller.ClassGetImg;
import dao.DAO_CongDung;
import dao.DAO_Thuoc;
import entity.CongDung;
import entity.Thuoc;

/**
 *
 * @author HoangPC
 */
public class ChiTietThuocJframe extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DAO_Thuoc daoThuoc = new DAO_Thuoc();
	DAO_CongDung dao_CongDung = new DAO_CongDung();

	/**
	 * Creates new form ChiTietThuocJframe
	 */
	// getmaThuoc lay thong tin
	public ChiTietThuocJframe(String maThuoc) {
		initComponents();
		setLocationRelativeTo(null);
		docThongTinThuocLenFrame(maThuoc);
	}

	private void docThongTinThuocLenFrame(String maThuoc) {
		Thuoc t = daoThuoc.getThuocTheoMa(maThuoc);
		txtMaThuoc.setText("" + maThuoc);
		txtTrangThaiKD.setText(t.isTrangThaiKD() == true ? "Đang kinh doanh" : "Ngừng kinh doanh");
		;
		txtTenThuoc.setText(t.getTenThuoc());
		CongDung cd = dao_CongDung.getNhomCongDungByMathuoc(t.getMaThuoc());
		if (cd != null) {
			txtNhomCongDung.setText("<html>"+cd.getNhomCongDung()+"</html>");
			txtCongDung.setText("<html>"+cd.getCongDung()+"</html>");
		}
		txtQuyCachDongGoi.setText(t.getQuyCachDongGoi());
		txtHoatChat.setText("<html>"+t.getThanhPhan()+"</html>");
		txtSoDK.setText(t.getSoDK());
		txtDVT.setText(t.getDonViTinh());
		txtVat.setText(String.valueOf(t.getThueVAT()));
		txtSoDK.setText(t.getSoDK());
		txtSLTon.setText("" + t.tongSoLuong());
		txtDangBaoChe.setText("<html>"+t.getDangBaoChe()+"</html>");
		txtNongDo.setText(t.getHamLuong());
		txtHangSX.setText("<html>"+t.getcTySanXuat()+"</html>");
		txtNuocSX.setText(t.getNuocSanXuat());
		txtGia.setText(String.valueOf(t.getGiaBan()));
		ClassGetImg imgClass = new ClassGetImg();
		imgClass.setImgChiTiet(lblHinh, "/thuocImg/" + maThuoc);
	}

	public ChiTietThuocJframe() {
		initComponents();
		setLocationRelativeTo(null);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblMaThuoc = new javax.swing.JLabel();
        lblTenHC = new javax.swing.JLabel();
        txtSoDK = new javax.swing.JTextField();
        lblQCDG2 = new javax.swing.JLabel();
        lblQCDG6 = new javax.swing.JLabel();
        txtNongDo = new javax.swing.JTextField();
        lblQCDG = new javax.swing.JLabel();
        txtQuyCachDongGoi = new javax.swing.JTextField();
        lblQCDG7 = new javax.swing.JLabel();
        txtVat = new javax.swing.JTextField();
        lblQCDG5 = new javax.swing.JLabel();
        lblQCDG4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        lblMaThuoc1 = new javax.swing.JLabel();
        lblTenHC1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        lblQCDG8 = new javax.swing.JLabel();
        txtSLTon = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        lblQCDG10 = new javax.swing.JLabel();
        txtDVT = new javax.swing.JTextField();
        lblGia = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        btnDong = new javax.swing.JButton();
        lblTenHC2 = new javax.swing.JLabel();
        txtDangBaoChe = new javax.swing.JLabel();
        txtNhomCongDung = new javax.swing.JLabel();
        txtMaThuoc = new javax.swing.JLabel();
        txtCongDung = new javax.swing.JLabel();
        txtHoatChat = new javax.swing.JLabel();
        txtHangSX = new javax.swing.JLabel();
        txtNuocSX = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblHinh = new javax.swing.JLabel();
        txtTenThuoc = new javax.swing.JTextField();
        txtTrangThaiKD = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chi tiết thuốc");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(1, 128, 145));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Chi tiết thuốc");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1161, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        lblMaThuoc.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        lblMaThuoc.setText("Số ĐK:");
        lblMaThuoc.setMaximumSize(new java.awt.Dimension(102, 18));
        lblMaThuoc.setMinimumSize(new java.awt.Dimension(102, 18));
        lblMaThuoc.setPreferredSize(new java.awt.Dimension(102, 18));

        lblTenHC.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        lblTenHC.setText("Hoạt chất:");
        lblTenHC.setMaximumSize(new java.awt.Dimension(102, 18));
        lblTenHC.setMinimumSize(new java.awt.Dimension(102, 18));
        lblTenHC.setPreferredSize(new java.awt.Dimension(102, 18));

        txtSoDK.setEditable(false);
        txtSoDK.setBackground(new java.awt.Color(255, 255, 255));
        txtSoDK.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        txtSoDK.setBorder(null);
        txtSoDK.setPreferredSize(new java.awt.Dimension(334, 17));

        lblQCDG2.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        lblQCDG2.setText("Dạng bào chế:");
        lblQCDG2.setMaximumSize(new java.awt.Dimension(102, 18));
        lblQCDG2.setMinimumSize(new java.awt.Dimension(102, 18));
        lblQCDG2.setPreferredSize(new java.awt.Dimension(102, 18));

        lblQCDG6.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        lblQCDG6.setText("Hàm lượng:");
        lblQCDG6.setMaximumSize(new java.awt.Dimension(102, 18));
        lblQCDG6.setMinimumSize(new java.awt.Dimension(102, 18));
        lblQCDG6.setPreferredSize(new java.awt.Dimension(102, 18));

        txtNongDo.setEditable(false);
        txtNongDo.setBackground(new java.awt.Color(255, 255, 255));
        txtNongDo.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        txtNongDo.setBorder(null);
        txtNongDo.setPreferredSize(new java.awt.Dimension(334, 17));

        lblQCDG.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        lblQCDG.setText("QC đóng gói:");
        lblQCDG.setMaximumSize(new java.awt.Dimension(102, 18));
        lblQCDG.setMinimumSize(new java.awt.Dimension(102, 18));
        lblQCDG.setPreferredSize(new java.awt.Dimension(102, 18));

        txtQuyCachDongGoi.setEditable(false);
        txtQuyCachDongGoi.setBackground(new java.awt.Color(255, 255, 255));
        txtQuyCachDongGoi.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        txtQuyCachDongGoi.setBorder(null);
        txtQuyCachDongGoi.setPreferredSize(new java.awt.Dimension(334, 17));

        lblQCDG7.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        lblQCDG7.setText("VAT(%):");
        lblQCDG7.setMaximumSize(new java.awt.Dimension(102, 18));
        lblQCDG7.setMinimumSize(new java.awt.Dimension(102, 18));
        lblQCDG7.setPreferredSize(new java.awt.Dimension(102, 18));

        txtVat.setEditable(false);
        txtVat.setBackground(new java.awt.Color(255, 255, 255));
        txtVat.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        txtVat.setBorder(null);
        txtVat.setPreferredSize(new java.awt.Dimension(334, 17));

        lblQCDG5.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        lblQCDG5.setText("Nước sản xuất:");

        lblQCDG4.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        lblQCDG4.setText("Hãng sản xuất:");
        lblQCDG4.setMaximumSize(new java.awt.Dimension(102, 18));
        lblQCDG4.setMinimumSize(new java.awt.Dimension(102, 18));
        lblQCDG4.setPreferredSize(new java.awt.Dimension(102, 18));

        lblMaThuoc1.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        lblMaThuoc1.setText("Mã thuốc:");
        lblMaThuoc1.setMaximumSize(new java.awt.Dimension(102, 18));
        lblMaThuoc1.setMinimumSize(new java.awt.Dimension(102, 18));
        lblMaThuoc1.setPreferredSize(new java.awt.Dimension(102, 18));

        lblTenHC1.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        lblTenHC1.setText("Nhóm thuốc:");
        lblTenHC1.setMaximumSize(new java.awt.Dimension(102, 18));
        lblTenHC1.setMinimumSize(new java.awt.Dimension(102, 18));
        lblTenHC1.setPreferredSize(new java.awt.Dimension(102, 18));

        lblQCDG8.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        lblQCDG8.setText("Tồn:");
        lblQCDG8.setMaximumSize(new java.awt.Dimension(102, 18));
        lblQCDG8.setMinimumSize(new java.awt.Dimension(102, 18));
        lblQCDG8.setPreferredSize(new java.awt.Dimension(102, 18));

        txtSLTon.setEditable(false);
        txtSLTon.setBackground(new java.awt.Color(255, 255, 255));
        txtSLTon.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtSLTon.setBorder(null);
        txtSLTon.setFocusable(false);
        txtSLTon.setPreferredSize(new java.awt.Dimension(334, 17));

        lblQCDG10.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        lblQCDG10.setText("ĐVT:");
        lblQCDG10.setMaximumSize(new java.awt.Dimension(102, 18));
        lblQCDG10.setMinimumSize(new java.awt.Dimension(102, 18));
        lblQCDG10.setPreferredSize(new java.awt.Dimension(102, 18));

        txtDVT.setEditable(false);
        txtDVT.setBackground(new java.awt.Color(255, 255, 255));
        txtDVT.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDVT.setBorder(null);
        txtDVT.setFocusable(false);
        txtDVT.setPreferredSize(new java.awt.Dimension(334, 17));

        lblGia.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        lblGia.setText("Giá bán:");
        lblGia.setMaximumSize(new java.awt.Dimension(102, 18));
        lblGia.setMinimumSize(new java.awt.Dimension(102, 18));
        lblGia.setName(""); // NOI18N
        lblGia.setPreferredSize(new java.awt.Dimension(102, 18));

        txtGia.setEditable(false);
        txtGia.setBackground(new java.awt.Color(255, 255, 255));
        txtGia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtGia.setBorder(null);
        txtGia.setFocusable(false);
        txtGia.setPreferredSize(new java.awt.Dimension(334, 17));

        btnDong.setBackground(new java.awt.Color(153, 153, 153));
        btnDong.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tick .png"))); // NOI18N
        btnDong.setText("Đóng");
        btnDong.setToolTipText("Đóng chi tiết thuốc");
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        lblTenHC2.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        lblTenHC2.setText("Công dụng:");
        lblTenHC2.setMaximumSize(new java.awt.Dimension(102, 18));
        lblTenHC2.setMinimumSize(new java.awt.Dimension(102, 18));
        lblTenHC2.setPreferredSize(new java.awt.Dimension(102, 18));

        txtDangBaoChe.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtMaThuoc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtCongDung.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtHoatChat.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtHangSX.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtNuocSX.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(lblMaThuoc1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblMaThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSoDK, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(lblQCDG2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDangBaoChe, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblQCDG6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtNongDo, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                    .addComponent(jSeparator3)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblQCDG, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtQuyCachDongGoi, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTenHC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtHoatChat, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator4)
                    .addComponent(jSeparator5)
                    .addComponent(jSeparator6)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblQCDG10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDVT, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lblQCDG4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtHangSX, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator7)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(lblGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lblQCDG5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNuocSX, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblQCDG8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSLTon, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lblQCDG7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(txtVat, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(lblTenHC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNhomCongDung, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTenHC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCongDung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDong)))
                .addGap(20, 20, 20))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtSoDK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMaThuoc1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lblMaThuoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMaThuoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenHC1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTenHC2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNhomCongDung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCongDung, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtQuyCachDongGoi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTenHC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHoatChat, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                    .addComponent(lblQCDG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblQCDG6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNongDo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblQCDG2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDangBaoChe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSLTon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblQCDG8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtVat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblQCDG7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblQCDG4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblQCDG10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDVT, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                    .addComponent(txtHangSX, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblQCDG5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNuocSX, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)))
                .addGap(35, 35, 35)
                .addComponent(btnDong, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lblHinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/image.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHinh, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );

        txtTenThuoc.setEditable(false);
        txtTenThuoc.setBackground(new java.awt.Color(255, 255, 255));
        txtTenThuoc.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        txtTenThuoc.setForeground(new java.awt.Color(0, 153, 255));
        txtTenThuoc.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTenThuoc.setToolTipText("");
        txtTenThuoc.setBorder(null);

        txtTrangThaiKD.setEditable(false);
        txtTrangThaiKD.setBackground(new java.awt.Color(255, 255, 255));
        txtTrangThaiKD.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        txtTrangThaiKD.setForeground(new java.awt.Color(255, 0, 0));
        txtTrangThaiKD.setText("Ngừng kinh doanh");
        txtTrangThaiKD.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTenThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 963, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTrangThaiKD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtTrangThaiKD, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(txtTenThuoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

		pack();

	}// </editor-fold>//GEN-END:initComponents

	private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDongActionPerformed
		ChiTietThuocJframe.setDefaultLookAndFeelDecorated(true);
		dispose();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(ChiTietThuocJframe.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ChiTietThuocJframe.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ChiTietThuocJframe.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ChiTietThuocJframe.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ChiTietThuocJframe().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnDong;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JSeparator jSeparator3;
	private javax.swing.JSeparator jSeparator4;
	private javax.swing.JSeparator jSeparator5;
	private javax.swing.JSeparator jSeparator6;
	private javax.swing.JSeparator jSeparator7;
	private javax.swing.JLabel lblGia;
	private javax.swing.JLabel lblHinh;
	private javax.swing.JLabel lblMaThuoc;
	private javax.swing.JLabel lblMaThuoc1;
	private javax.swing.JLabel lblQCDG;
	private javax.swing.JLabel lblQCDG10;
	private javax.swing.JLabel lblQCDG2;
	private javax.swing.JLabel lblQCDG4;
	private javax.swing.JLabel lblQCDG5;
	private javax.swing.JLabel lblQCDG6;
	private javax.swing.JLabel lblQCDG7;
	private javax.swing.JLabel lblQCDG8;
	private javax.swing.JLabel lblTenHC;
	private javax.swing.JLabel lblTenHC1;
	private javax.swing.JLabel lblTenHC2;
	private JLabel txtCongDung;
	private javax.swing.JTextField txtDVT;
	private JLabel txtDangBaoChe;
	private javax.swing.JTextField txtGia;
	private JLabel txtHangSX;
	private JLabel txtHoatChat;
	private JLabel txtMaThuoc;
	private JLabel txtNhomCongDung;
	private javax.swing.JTextField txtNongDo;
	private JLabel txtNuocSX;
	private javax.swing.JTextField txtQuyCachDongGoi;
	private javax.swing.JTextField txtSLTon;
	private javax.swing.JTextField txtSoDK;
	private javax.swing.JTextField txtTenThuoc;
	private javax.swing.JTextField txtTrangThaiKD;
	private javax.swing.JTextField txtVat;
	// End of variables declaration//GEN-END:variables
}
