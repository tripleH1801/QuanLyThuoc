/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import controller.KhachHangRightClickPopUp;
import dao.DAO_DiaChi;
import dao.DAO_KhachHang;
import entity.KhachHang;

/**
 *
 * @author HoangPC
 */
public class QuanLyKhachHangPanel extends javax.swing.JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVerstonUID = 1L;
	private gui_Chinh gui;
	private KhachHangRightClickPopUp popUp;
	private boolean trangThaiGoi;
	@SuppressWarnings("unused")
	private BanThuocJPanel banThuocPanel;
	@SuppressWarnings("unused")
	private ThemKhachHangJframe themKhPn;
	private DefaultTableModel model;
	private DAO_KhachHang daoKhachHang;
	private int row;
	private DAO_DiaChi DAO_DiaChi;
	private Vector<String> vecTinhTP;
	private List<KhachHang> listKH;

	/**
	 * Creates new form pnKhachHang
	 */
	public QuanLyKhachHangPanel(gui_Chinh gui, boolean trangThaiGoi) { // true khi duoc goi tu 1 'jpanel khac'

		this.gui = gui;
		this.trangThaiGoi = trangThaiGoi;
		initComponents();
		btnTroVe.setVisible(trangThaiGoi);
		themKhPn = new ThemKhachHangJframe(this, trangThaiGoi);
		loadTinh();
	}

	public QuanLyKhachHangPanel(gui_Chinh gui, boolean trangThaiGoi, BanThuocJPanel banThuocPn) { // true khi duoc goi
																									// tu 1 'jpanel
																									// khac'

		this.gui = gui;
		this.trangThaiGoi = trangThaiGoi;
		initComponents();
		btnTroVe.setVisible(trangThaiGoi);
		banThuocPanel = banThuocPn;
	}

	public QuanLyKhachHangPanel() {
		initComponents();
	}

	private void initComponents() {

		pnHeader = new javax.swing.JPanel();
		lblHeader = new javax.swing.JLabel();
		pnBody = new javax.swing.JPanel();
		pnMenu = new javax.swing.JPanel();
		jPanel8 = new javax.swing.JPanel();
		btnXoaTrang = new javax.swing.JButton();
		btnSua = new javax.swing.JButton();
		btnXoa = new javax.swing.JButton();
		btnThem = new javax.swing.JButton();
		jPanel6 = new javax.swing.JPanel();
		btnTim = new javax.swing.JButton();
		txtTim = new javax.swing.JTextField();
		lblTimSDT = new javax.swing.JLabel();
		jcbTimGioiTinh = new javax.swing.JComboBox<>();
		jSeparator1 = new javax.swing.JSeparator();
		jLabel2 = new javax.swing.JLabel();
		jSeparator2 = new javax.swing.JSeparator();
		txtTimTen = new javax.swing.JTextField();
		lblTimSDT1 = new javax.swing.JLabel();
		pnSua = new javax.swing.JPanel();
		jPanel1 = new javax.swing.JPanel();
		txtTen = new javax.swing.JTextField();
		txtSDT = new javax.swing.JTextField();
		lblTenKH = new javax.swing.JLabel();
		lblSDT = new javax.swing.JLabel();
		jcbGioiTinh = new javax.swing.JComboBox<>();
		lblSDT1 = new javax.swing.JLabel();
		jPanel4 = new javax.swing.JPanel();
		lblDC = new javax.swing.JLabel();
		lblMa1 = new javax.swing.JLabel();
		txtMa = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jcbTinh = new javax.swing.JComboBox<>();
		jcbHuyen = new javax.swing.JComboBox<>();
		jcbXa = new javax.swing.JComboBox<>();
		btnDong = new javax.swing.JButton();
		btnXacNhan = new javax.swing.JButton();
		pnTable = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tblKH = new javax.swing.JTable();
		btnSkipPrevius = new javax.swing.JButton();
		btnNextPrevius = new javax.swing.JButton();
		txtSoTrang = new javax.swing.JLabel();
		btnNextForward = new javax.swing.JButton();
		btnSkipForward = new javax.swing.JButton();
		btnTroVe = new javax.swing.JButton();
		jSeparator3 = new javax.swing.JSeparator();
		jLabel3 = new javax.swing.JLabel();

		setPreferredSize(new java.awt.Dimension(980, 725));

		pnHeader.setBackground(new java.awt.Color(1, 128, 145));
		pnHeader.setPreferredSize(new java.awt.Dimension(980, 108));

		lblHeader.setBackground(new java.awt.Color(255, 255, 255));
		lblHeader.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
		lblHeader.setForeground(new java.awt.Color(255, 255, 255));
		lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblHeader.setText("Quản lý khách hàng");

		javax.swing.GroupLayout pnHeaderLayout = new javax.swing.GroupLayout(pnHeader);
		pnHeader.setLayout(pnHeaderLayout);
		pnHeaderLayout.setHorizontalGroup(
				pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lblHeader,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		pnHeaderLayout.setVerticalGroup(
				pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lblHeader,
						javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE));

		pnBody.setBackground(new java.awt.Color(102, 102, 255));

		pnMenu.setBackground(new java.awt.Color(255, 255, 255));

		jPanel8.setBackground(new java.awt.Color(255, 255, 255));

		btnXoaTrang.setBackground(new java.awt.Color(204, 204, 204));
		btnXoaTrang.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
		btnXoaTrang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh (1).png"))); // NOI18N
		btnXoaTrang.setText("Làm mới");
		btnXoaTrang.setToolTipText("Làm mới mục");
		btnXoaTrang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		btnSua.setBackground(new java.awt.Color(204, 204, 204));
		btnSua.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
		btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh.png"))); // NOI18N
		btnSua.setText("Sửa");
		btnSua.setToolTipText("Sửa thông tin khách hàng");
		btnSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnSua.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSuaActionPerformed(evt);
			}
		});

		btnXoa.setBackground(new java.awt.Color(204, 204, 204));
		btnXoa.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
		btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete-user.png"))); // NOI18N
		btnXoa.setText("Xóa");
		btnXoa.setToolTipText("Xóa khách hàng");
		btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		btnThem.setBackground(new java.awt.Color(204, 204, 204));
		btnThem.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
		btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sign-up.png"))); // NOI18N
		btnThem.setText("Thêm");
		btnThem.setToolTipText("Thêm  khách hàng mới");
		btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnThem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThemActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
		jPanel8.setLayout(jPanel8Layout);
		jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel8Layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(6, 6, 6)
						.addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(6, 6, 6)
						.addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btnXoaTrang)
						.addContainerGap()));
		jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addComponent(btnXoaTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
						javax.swing.GroupLayout.PREFERRED_SIZE));

		jPanel6.setBackground(new java.awt.Color(255, 255, 255));

		btnTim.setBackground(new java.awt.Color(204, 204, 204));
		btnTim.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
		btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/find.png"))); // NOI18N
		btnTim.setToolTipText("Tìm theo sdt Khách hàng");
		btnTim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnTim.setPreferredSize(new java.awt.Dimension(71, 34));

		txtTim.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		txtTim.setToolTipText("Nhập sdt Khách hàng cần tìm");
		txtTim.setPreferredSize(new java.awt.Dimension(7, 30));

		lblTimSDT.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		lblTimSDT.setForeground(new java.awt.Color(29, 53, 87));
		lblTimSDT.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		lblTimSDT.setText("Tìm SĐT:");

		jcbTimGioiTinh.setBackground(new java.awt.Color(153, 153, 153));
		jcbTimGioiTinh.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		jcbTimGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giới tính", "Nam", "Nữ" }));
		jcbTimGioiTinh.setToolTipText("Tìm theo Giới tính");

		jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		jLabel2.setForeground(new java.awt.Color(29, 53, 87));
		jLabel2.setText("Tìm kiếm");

		txtTimTen.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		txtTimTen.setToolTipText("Nhập sdt Khách hàng cần tìm");
		txtTimTen.setPreferredSize(new java.awt.Dimension(7, 30));

		lblTimSDT1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		lblTimSDT1.setForeground(new java.awt.Color(29, 53, 87));
		lblTimSDT1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		lblTimSDT1.setText("Tìm tên:");

		javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
		jPanel6.setLayout(jPanel6Layout);
		jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jSeparator1).addComponent(jSeparator2)
				.addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel6Layout.createSequentialGroup().addComponent(jLabel2).addGap(0, 0,
								Short.MAX_VALUE))
						.addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblTimSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 67,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTimSDT1, javax.swing.GroupLayout.PREFERRED_SIZE, 67,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel6Layout.createSequentialGroup()
												.addComponent(txtTimTen, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(jcbTimGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE,
														128, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(jPanel6Layout.createSequentialGroup()
												.addComponent(txtTim, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)))))
						.addContainerGap()));
		jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel6Layout.createSequentialGroup().addGap(6, 6, 6).addComponent(jLabel2)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(1, 1, 1)
								.addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(lblTimSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(txtTimTen, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(lblTimSDT1, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jcbTimGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(0, 0, 0).addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

		pnSua.setBackground(new java.awt.Color(255, 255, 255));
		pnSua.setLayout(new java.awt.GridLayout(1, 0));

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));

		txtTen.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		txtTen.setToolTipText("Tên Khách hàng");
		txtTen.setPreferredSize(new java.awt.Dimension(7, 30));

		txtSDT.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		txtSDT.setToolTipText("Số điện thoại Khách hàng");
		txtSDT.setMinimumSize(new java.awt.Dimension(7, 30));
		txtSDT.setPreferredSize(new java.awt.Dimension(7, 30));

		lblTenKH.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		lblTenKH.setForeground(new java.awt.Color(29, 53, 87));
		lblTenKH.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		lblTenKH.setText("Tên :");
		lblTenKH.setMaximumSize(new java.awt.Dimension(67, 17));
		lblTenKH.setMinimumSize(new java.awt.Dimension(67, 17));
		lblTenKH.setPreferredSize(new java.awt.Dimension(67, 22));

		lblSDT.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		lblSDT.setForeground(new java.awt.Color(29, 53, 87));
		lblSDT.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		lblSDT.setText("SĐT:");
		lblSDT.setMaximumSize(new java.awt.Dimension(67, 17));
		lblSDT.setMinimumSize(new java.awt.Dimension(67, 17));
		lblSDT.setPreferredSize(new java.awt.Dimension(67, 22));

		jcbGioiTinh.setBackground(new java.awt.Color(153, 153, 153));
		jcbGioiTinh.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		jcbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
		jcbGioiTinh.setToolTipText("Giới tính");

		lblSDT1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		lblSDT1.setForeground(new java.awt.Color(29, 53, 87));
		lblSDT1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		lblSDT1.setText("Giới tính:");
		lblSDT1.setPreferredSize(new java.awt.Dimension(53, 22));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(0, 0, 0)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(lblTenKH, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblSDT, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 206,
												Short.MAX_VALUE)
										.addGap(18, 18, 18)
										.addComponent(lblSDT1, javax.swing.GroupLayout.DEFAULT_SIZE, 71,
												Short.MAX_VALUE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jcbGioiTinh, 0, 101, Short.MAX_VALUE))
								.addComponent(txtTen, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTenKH, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(lblSDT, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jcbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(lblSDT1, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))));

		pnSua.add(jPanel1);

		jPanel4.setBackground(new java.awt.Color(255, 255, 255));

		lblDC.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		lblDC.setForeground(new java.awt.Color(29, 53, 87));
		lblDC.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		lblDC.setText("Địa chỉ:");
		lblDC.setPreferredSize(new java.awt.Dimension(50, 22));

		lblMa1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		lblMa1.setForeground(new java.awt.Color(29, 53, 87));
		lblMa1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		lblMa1.setText("Mã:");
		lblMa1.setPreferredSize(new java.awt.Dimension(50, 22));

		txtMa.setEditable(false);
		txtMa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		txtMa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
		txtMa.setToolTipText("Mã Khách hàng");
		txtMa.setBorder(null);
		txtMa.setFocusable(false);
		txtMa.setPreferredSize(new java.awt.Dimension(7, 30));

		jcbTinh.setBackground(new java.awt.Color(153, 153, 153));
		jcbTinh.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
		jcbTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tỉnh/Thành phố" }));
		jcbTinh.setToolTipText("");

		jcbHuyen.setBackground(new java.awt.Color(153, 153, 153));
		jcbHuyen.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
		jcbHuyen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quận/huyện" }));

		jcbXa.setBackground(new java.awt.Color(153, 153, 153));
		jcbXa.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
		jcbXa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Phường/Xã" }));

		btnDong.setBackground(new java.awt.Color(204, 204, 204));
		btnDong.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		btnDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/denied.png"))); // NOI18N
		btnDong.setText("Đóng");
		btnDong.setToolTipText("Đóng bảng Sửa khách hàng");
		btnDong.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDongActionPerformed(evt);
			}
		});

		btnXacNhan.setBackground(new java.awt.Color(204, 204, 204));
		btnXacNhan.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		btnXacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/management.png"))); // NOI18N
		btnXacNhan.setText("Xác nhận");
		btnXacNhan.setToolTipText("Cập nhật lại Khách hàng");
		btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnXacNhanActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel4Layout.createSequentialGroup()
								.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 471,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE))
						.addGroup(jPanel4Layout.createSequentialGroup().addContainerGap()
								.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel4Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
												.addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(
														btnDong, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(lblDC, javax.swing.GroupLayout.DEFAULT_SIZE, 53,
														Short.MAX_VALUE)
												.addComponent(
														lblMa1, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(jPanel4Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(jPanel4Layout.createSequentialGroup()
																.addComponent(jcbTinh, 0,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jcbHuyen, 0,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jcbXa, 0,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE))
														.addComponent(txtMa, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))))))
						.addContainerGap()));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup()
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblMa1, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(lblDC, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jcbTinh).addComponent(jcbHuyen).addComponent(jcbXa))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(btnXacNhan, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
								.addComponent(btnDong, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel1)));

		pnSua.add(jPanel4);

		javax.swing.GroupLayout pnMenuLayout = new javax.swing.GroupLayout(pnMenu);
		pnMenu.setLayout(pnMenuLayout);
		pnMenuLayout.setHorizontalGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnMenuLayout.createSequentialGroup().addContainerGap()
						.addGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(pnSua, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		pnMenuLayout.setVerticalGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnMenuLayout.createSequentialGroup()
						.addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(pnSua, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0).addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

		pnSua.setVisible(false);

		pnTable.setBackground(new java.awt.Color(255, 255, 255));

		tblKH.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
		tblKH.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null } }, new String[] { "Tên khách hàng",
						"Mã khách hàng", "Giới tính", "SĐT", "Tỉnh/TP", "Quận/Huyện", "Phường/Xã" }) {
			Class[] types = new Class[] { java.lang.String.class, java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class };
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		tblKH.setRowHeight(34);
		tblKH.setSelectionBackground(new java.awt.Color(1, 128, 145));
		tblKH.getTableHeader().setReorderingAllowed(false);
		tblKH.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				tblKHMouseReleased(evt);
			}
		});
		jScrollPane1.setViewportView(tblKH);
		if (tblKH.getColumnModel().getColumnCount() > 0) {
			tblKH.getColumnModel().getColumn(0).setResizable(false);
			tblKH.getColumnModel().getColumn(0).setPreferredWidth(150);
			tblKH.getColumnModel().getColumn(1).setResizable(false);
			tblKH.getColumnModel().getColumn(1).setPreferredWidth(5);
			tblKH.getColumnModel().getColumn(2).setResizable(false);
			tblKH.getColumnModel().getColumn(2).setPreferredWidth(30);
			tblKH.getColumnModel().getColumn(3).setResizable(false);
			tblKH.getColumnModel().getColumn(3).setPreferredWidth(30);
			tblKH.getColumnModel().getColumn(4).setResizable(false);
			tblKH.getColumnModel().getColumn(4).setPreferredWidth(80);
			tblKH.getColumnModel().getColumn(5).setResizable(false);
			tblKH.getColumnModel().getColumn(5).setPreferredWidth(80);
			tblKH.getColumnModel().getColumn(6).setResizable(false);
			tblKH.getColumnModel().getColumn(6).setPreferredWidth(80);
		}
		tblKH.getTableHeader().setFont(new java.awt.Font("Arial", 0, 14));

		btnSkipPrevius.setBackground(new java.awt.Color(204, 204, 204));
		btnSkipPrevius.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/img/baseline_skip_previous_white_24dp.png"))); // NOI18N
		btnSkipPrevius.setToolTipText("Trang đầu");
		btnSkipPrevius.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnSkipPrevius.setPreferredSize(new java.awt.Dimension(40, 30));

		btnNextPrevius.setBackground(new java.awt.Color(204, 204, 204));
		btnNextPrevius
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/baseline_fast_rewind_white_24dp.png"))); // NOI18N
		btnNextPrevius.setToolTipText("Trang trước");
		btnNextPrevius.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnNextPrevius.setPreferredSize(new java.awt.Dimension(40, 30));

		txtSoTrang.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
		txtSoTrang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		txtSoTrang.setText("0");

		btnNextForward.setBackground(new java.awt.Color(204, 204, 204));
		btnNextForward.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/img/baseline_fast_forward_white_24dp.png"))); // NOI18N
		btnNextForward.setToolTipText("Trang sau");
		btnNextForward.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnNextForward.setPreferredSize(new java.awt.Dimension(40, 30));

		btnSkipForward.setBackground(new java.awt.Color(204, 204, 204));
		btnSkipForward
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/baseline_skip_next_white_24dp.png"))); // NOI18N
		btnSkipForward.setToolTipText("Trang cuối");
		btnSkipForward.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnSkipForward.setPreferredSize(new java.awt.Dimension(40, 30));

		btnTroVe.setBackground(new java.awt.Color(204, 204, 204));
		btnTroVe.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
		btnTroVe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pharmacy.png"))); // NOI18N
		btnTroVe.setText("Trở về");
		btnTroVe.setToolTipText("Trở về Cửa hàng");
		btnTroVe.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnTroVeActionPerformed(evt);
			}
		});

		jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		jLabel3.setForeground(new java.awt.Color(29, 53, 87));
		jLabel3.setText("Danh sách khách hàng");

		javax.swing.GroupLayout pnTableLayout = new javax.swing.GroupLayout(pnTable);
		pnTable.setLayout(pnTableLayout);
		pnTableLayout.setHorizontalGroup(pnTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTableLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(pnTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
										pnTableLayout.createSequentialGroup()
												.addComponent(btnSkipPrevius, javax.swing.GroupLayout.PREFERRED_SIZE,
														50, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(btnNextPrevius, javax.swing.GroupLayout.PREFERRED_SIZE,
														50, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(txtSoTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 52,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(btnNextForward, javax.swing.GroupLayout.PREFERRED_SIZE,
														50, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(btnSkipForward, javax.swing.GroupLayout.PREFERRED_SIZE,
														50, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnTroVe, javax.swing.GroupLayout.PREFERRED_SIZE, 159,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
										pnTableLayout.createSequentialGroup().addGap(16, 16, 16).addComponent(jLabel3)
												.addGap(0, 0, Short.MAX_VALUE))
								.addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
						.addContainerGap()));
		pnTableLayout.setVerticalGroup(pnTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnTableLayout.createSequentialGroup().addContainerGap().addComponent(jLabel3)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pnTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(btnTroVe, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(pnTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(btnNextForward, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.PREFERRED_SIZE, 33,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txtSoTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNextPrevius, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(btnSkipPrevius, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(btnSkipForward, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));

		btnTroVe.setVisible(false);

		javax.swing.GroupLayout pnBodyLayout = new javax.swing.GroupLayout(pnBody);
		pnBody.setLayout(pnBodyLayout);
		pnBodyLayout.setHorizontalGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnBodyLayout.createSequentialGroup()
						.addGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(pnTable, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(pnMenu, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addGap(0, 0, 0)));
		pnBodyLayout.setVerticalGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnBodyLayout.createSequentialGroup()
						.addComponent(pnMenu, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0).addComponent(pnTable, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addComponent(pnHeader, javax.swing.GroupLayout.Alignment.LEADING,
								javax.swing.GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE)
						.addComponent(pnBody, javax.swing.GroupLayout.Alignment.LEADING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
				.addGap(0, 0, 0)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(pnHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0).addComponent(pnBody, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

//        ============================================code==============================================
		model = (DefaultTableModel) tblKH.getModel();
		daoKhachHang = new DAO_KhachHang();
		DAO_DiaChi = new DAO_DiaChi();
		listKH = daoKhachHang.getAllKH();
		countDS = listKH.size();
		docDuLieuLenModel();

		btnNextForward.addActionListener(this);
		btnSkipForward.addActionListener(this);
		btnNextPrevius.addActionListener(this);
		btnSkipPrevius.addActionListener(this);

		btnTim.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.setNumRows(0);
				KhachHang kh = daoKhachHang.timKHTheoSDT(txtTim.getText().trim());
				if (kh != null) {
					model.addRow(new Object[] { kh.getTenKhachHang(), kh.getMaKhachHang(),
							kh.isGioiTinh() == true ? "Nữ" : "Nam", kh.getSoDienThoai(), kh.getDiaChi().getTinhTP(),
							kh.getDiaChi().getQuanHuyen(), kh.getDiaChi().getPhuongXa()

					});

				} else {
					JOptionPane.showMessageDialog(null, "Không tồn tại khách hàng");
					return;
				}

			}
		});
		btnXoaTrang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				docDuLieuLenModel();
				jcbGioiTinh.setSelectedIndex(0);
				txtTim.selectAll();
				txtTim.requestFocus();
			}
		});
		
		jcbGioiTinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiem();
			}
		});
		
		btnSua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				hienGDSua();

			}

		});
		
		btnXoa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int row = tblKH.getSelectedRow();
				if (row < 0) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng cần xóa");
					return;
				}
				KhachHang kh = daoKhachHang.timKHTheoMa((String) tblKH.getValueAt(row, 1));
				if (daoKhachHang.xoaKH(kh)) {
					int n = JOptionPane.showConfirmDialog(null,
							"Bạn có muốn xóa khách hàng " + kh.getTenKhachHang() + " không?");
					if (n == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "Xóa khách hàng thành công!!!");
						docDuLieuLenModel();
						return;
					}

				}
				JOptionPane.showMessageDialog(null, "Xóa khách hàng thất bại!!!");
				return;

			}
		});

		jcbTimGioiTinh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				xoaKH();
			}
		});
		
		txtTimTen.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				timKiem();
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});

		if (trangThaiGoi)
			tblKH.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent mouseEvent) {
					JTable table = (JTable) mouseEvent.getSource();
					Point point = mouseEvent.getPoint();
					int row = table.rowAtPoint(point);

					if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
						int c = JOptionPane.showConfirmDialog(null,
								"Bạn muốn chọn khách hàng " + table.getValueAt(row, 0).toString() + " ?",
								"Thông báo", JOptionPane.YES_NO_OPTION);
						if (c == JOptionPane.YES_OPTION) {
							gui.chuyenTuKhachHangDenBanThuoc(" " + table.getValueAt(row, 0).toString(),
									" " + table.getValueAt(row, 3).toString(), " " + table.getValueAt(row, 4).toString()
											+ " - " + table.getValueAt(row, 5).toString());
							tblKH.clearSelection();
						}
					}
				}
			});
	}
	
	private void timKiem() {
		String ten = txtTimTen.getText();
		int gioiTinh = jcbTimGioiTinh.getSelectedIndex();
		
		listKH = daoKhachHang.getKhachHangByAll(ten, gioiTinh);
		countDS = listKH.size();
		model.getDataVector().removeAllElements();
		if (listKH.size() == 0) {
			model.fireTableDataChanged();
			return;
		} else {
			listKH.forEach(t -> {
				KhachHang kh = t;
				model.addRow(new Object[] { kh.getTenKhachHang(), kh.getMaKhachHang(),
						kh.isGioiTinh() == false ? "Nữ" : "Nam", kh.getSoDienThoai(), kh.getDiaChi().getTinhTP(),
						kh.getDiaChi().getQuanHuyen(), kh.getDiaChi().getPhuongXa() });
			});
		}
	}

	public void xoaKH() {
		int n = jcbTimGioiTinh.getSelectedIndex();
		if (n == 0) {
			docDuLieuLenModel();
			return;
		}
		List<KhachHang> list = new ArrayList<KhachHang>();
		if (n == 1)
			list = daoKhachHang.getKHTheoGioiTinh(1);
		else
			list = daoKhachHang.getKHTheoGioiTinh(0);
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
		list.forEach(t -> {

			model.addRow(new Object[] { t.getTenKhachHang(), t.getMaKhachHang(), t.isGioiTinh() == false ? "Nữ" : "Nam",
					t.getSoDienThoai(), t.getDiaChi().getTinhTP(), t.getDiaChi().getQuanHuyen(),
					t.getDiaChi().getPhuongXa() });
			tblKH.clearSelection();
		});
	}

	protected void docDuLieuLenTXT() {
		row = tblKH.getSelectedRow();
		if (row >= 0) {
			txtMa.setText((String) tblKH.getValueAt(row, 1));
			txtTen.setText((String) tblKH.getValueAt(row, 0));
			txtSDT.setText((String) tblKH.getValueAt(row, 3));
			jcbGioiTinh.setSelectedIndex(tblKH.getValueAt(row, 2).toString() == "Nam" ? 0 : 1);
			jcbTinh.setSelectedItem(tblKH.getValueAt(row, 4));
			jcbHuyen.setSelectedItem(tblKH.getValueAt(row, 5));
			jcbXa.setSelectedItem(tblKH.getValueAt(row, 6));

		}

	}

	private void docDuLieuLenModel() {
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
		listKH = daoKhachHang.getAllKH();
		for (int i = (trang - 1) * 20; i < trang * 20; i++) {
			try {
				KhachHang kh = listKH.get(i);
				model.addRow(new Object[] { kh.getTenKhachHang(), kh.getMaKhachHang(),
						kh.isGioiTinh() == false ? "Nữ" : "Nam", kh.getSoDienThoai(), kh.getDiaChi().getTinhTP(),
						kh.getDiaChi().getQuanHuyen(), kh.getDiaChi().getPhuongXa() });
			} catch (Exception e) {
			}
		}
		txtSoTrang.setText(String.valueOf(trang));
		tblKH.clearSelection();

	}

	private void tblKHMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblKHMouseReleased
		if (pnSua.isVisible())
			docDuLieuLenTXT();
		popUp = new KhachHangRightClickPopUp(btnXoa.getText(), this);
		if (SwingUtilities.isRightMouseButton(evt)) {
			int r = tblKH.rowAtPoint(evt.getPoint());
			if (r >= 0 && r < tblKH.getRowCount()) {
				tblKH.setRowSelectionInterval(r, r);
			} else {
				tblKH.clearSelection();
			}
			int rowselect = tblKH.getSelectedRow();
			if (rowselect < 0)
				return;
			else {
				popUp.show(evt.getComponent(), evt.getX(), evt.getY());
			}

		}
	}// GEN-LAST:event_tblKHMouseReleased

	private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSuaActionPerformed
		pnSua.setVisible(true);
		btnSua.setEnabled(false);
	}// GEN-LAST:event_btnSuaActionPerformed

//	public void thaoTacKhiSua() {
//		pnSua.setVisible(true);
//		int row = tblKH.getSelectedRow();
//		if (row == -1 || !pnSua.isVisible())
//			return;
//		docDuLieuLenTXT();
//		btnSua.setEnabled(false);
//	}

	private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDongActionPerformed
		pnSua.setVisible(false);
		btnSua.setEnabled(true);
	}// GEN-LAST:event_btnDongActionPerformed

	private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXacNhanActionPerformed
		if (!kiemTra()) {
			return;
		}
		row = tblKH.getSelectedRow();
		int c = JOptionPane.showConfirmDialog(null,
				"Cập nhật lại thông tin của '" + tblKH.getValueAt(row, 0).toString() + "' ?", "Thông báo",
				JOptionPane.YES_NO_OPTION);
		if (c == JOptionPane.NO_OPTION)
			return;

		KhachHang kh = new KhachHang(tblKH.getValueAt(row, 1).toString(), txtTen.getText().trim(),
				jcbGioiTinh.getSelectedIndex() == 0 ? false : true, txtSDT.getText().trim(),
				DAO_DiaChi.timDiaChiTheoMa(DAO_DiaChi.getMaDCTheoTinhHuyenXa(jcbTinh.getSelectedItem().toString(),
						jcbHuyen.getSelectedItem().toString(), jcbXa.getSelectedItem().toString())),
				true);
		KhachHang khKiemTra = daoKhachHang.get1KhachHang(kh.getSoDienThoai());
		if (khKiemTra != null) {
			if (khKiemTra.isTrangThai() && !khKiemTra.getMaKhachHang().equals(kh.getMaKhachHang())
					&& khKiemTra.getSoDienThoai().equals(kh.getSoDienThoai())) {
				JOptionPane.showMessageDialog(null,
						"<html>Số điện thoại trùng với khách hàng khác!<br>Vui lòng kiểm tra lại!</html>");
				return;
			}
		}

		if (daoKhachHang.suaKH(kh, jcbTinh.getSelectedItem().toString(), jcbHuyen.getSelectedItem().toString(),
				jcbXa.getSelectedItem().toString())) {
			JOptionPane.showMessageDialog(null, "Cập nhật khách hàng thành công");
			docDuLieuLenModel();
//			return;
		} else {
			JOptionPane.showMessageDialog(null, "Cập nhật khách hàng không thành công");
//			return;
		}
//		pnSua.setVisible(false);
//		btnSua.setEnabled(true);
	}// GEN-LAST:event_btnXacNhanActionPerformed

	private void btnTroVeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTroVeActionPerformed
		// lam lenh xoa trang de reset lai panel
		gui.chuyenTuKhachHangDenBanThuoc("", "", "");
	}// GEN-LAST:event_btnTroVeActionPerformed

	private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThemActionPerformed
		new ThemKhachHangJframe(this, trangThaiGoi).setVisible(true);
		docDuLieuLenModel();
	}// GEN-LAST:event_btnThemActionPerformed

	public void chuyenTuKhachHangDenBanThuocBangThem(String ten, String sdt, String dc) {
		System.out.println(ten + "   " + sdt + "   " + dc);
		gui.chuyenTuKhachHangDenBanThuoc(ten, sdt, dc);
	}

	private boolean kiemTra() {
		String ten = txtTen.getText();
		if (ten.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "<html><b>Tên khách hàng</b> không được bỏ trống!</html>");
			txtTen.requestFocus();
			return false;
		}
		if (!ten.matches(
				"^([A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀẾỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪỬỮỰỲỴÝỶỸàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽếềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]*\\s*)+$")) {
			JOptionPane.showMessageDialog(this, "<html><b>Tên khách hàng</b> không được số và kí tự đặc biệt!</html>");
			txtTen.selectAll();
			return false;

		}
		String sdt = txtSDT.getText();
		if (sdt.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "<html><b>Số điện thoại</b> không được bỏ trống!</html>");
			txtSDT.requestFocus();
			return false;
		} else if (!sdt.matches(
				"(^(03)[2-9]\\d{7})|(^(07)[06-9]\\d{7})|(^(08)[1-5]\\d{7})|(^(056)\\d{7})|(^(058)\\d{7})|(^(059)\\d{7})|(^(09)[0-46-9]\\d{7})")) {
			JOptionPane.showMessageDialog(this,
					"<html><b>Số điện thoại</b> không có thực!<br>Vui lòng kiểm tra lại</html>");
			txtSDT.selectAll();
			txtSDT.requestFocus();
			return false;
		}
		if (jcbXa.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "<html>Mời chọn <b>địa chỉ</b> của khách hàng!</html>");
			return false;
		}
		return true;
	}

	private void loadTinh() {
		vecTinhTP = DAO_DiaChi.getAllTinh();
		if (vecTinhTP.size() == 1) {
			JOptionPane.showMessageDialog(null, "Lỗi khi đọc danh sách tỉnh!");
			return;
		}
		DefaultComboBoxModel<String> md = new DefaultComboBoxModel<String>(vecTinhTP);
		jcbTinh.setModel(md);
	}

	public void hienGDSua() {
		pnSua.setVisible(true);
		btnSua.setEnabled(false);
		if (row < 0) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng cần sửa");
			return;
		}
		jcbTinh.addActionListener(new ActionListener() {

			private Vector<String> vecQuanHuyen;
			private Vector<String> vecPhuongXa;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (jcbTinh.getSelectedItem().toString().equalsIgnoreCase("Tỉnh/Thành phố")) {
					vecQuanHuyen = new Vector<String>();
					vecQuanHuyen.add("Quận/Huyện");
					DefaultComboBoxModel<String> mdQuan = new DefaultComboBoxModel<>(vecQuanHuyen);
					jcbHuyen.setModel(mdQuan);
					vecPhuongXa = new Vector<String>();
					vecPhuongXa.add("Phường/Xã");
					DefaultComboBoxModel<String> mdPhuong = new DefaultComboBoxModel<>(vecPhuongXa);
					jcbXa.setModel(mdPhuong);
					return;
				}
				vecQuanHuyen = DAO_DiaChi.getAllHuyenTheoTinh(jcbTinh.getSelectedItem().toString());
				DefaultComboBoxModel<String> mdQuanHuyen = new DefaultComboBoxModel<>(vecQuanHuyen);
				jcbHuyen.setModel(mdQuanHuyen);
			}
		});
		jcbHuyen.addActionListener(new ActionListener() {

			private Vector<String> vecPhuongXa;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (jcbHuyen.getSelectedItem().toString().equalsIgnoreCase("Quận/Huyện")) {
					vecPhuongXa = new Vector<String>();
					vecPhuongXa.add("Phường/Xã");
					DefaultComboBoxModel<String> mdPhuong = new DefaultComboBoxModel<>(vecPhuongXa);
					jcbXa.setModel(mdPhuong);
					return;
				}
				vecPhuongXa = DAO_DiaChi.getAllPhuongXaTheoTinhVaHuyen(jcbTinh.getSelectedItem().toString(),
						jcbHuyen.getSelectedItem().toString());
				DefaultComboBoxModel<String> mdPhuong = new DefaultComboBoxModel<>(vecPhuongXa);
				jcbXa.setModel(mdPhuong);
			}
		});

		docDuLieuLenTXT();
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnDong;
	private javax.swing.JButton btnNextForward;
	private javax.swing.JButton btnNextPrevius;
	private javax.swing.JButton btnSkipForward;
	private javax.swing.JButton btnSkipPrevius;
	private javax.swing.JButton btnSua;
	private javax.swing.JButton btnThem;
	private javax.swing.JButton btnXoa;
	private javax.swing.JButton btnTim;
	private javax.swing.JButton btnTroVe;
	private javax.swing.JButton btnXacNhan;
	private javax.swing.JButton btnXoaTrang;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JPanel jPanel8;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JSeparator jSeparator3;
	private javax.swing.JComboBox<String> jcbGioiTinh;
	private javax.swing.JComboBox<String> jcbHuyen;
	private javax.swing.JComboBox<String> jcbTimGioiTinh;
	private javax.swing.JComboBox<String> jcbTinh;
	private javax.swing.JComboBox<String> jcbXa;
	private javax.swing.JLabel lblDC;
	private javax.swing.JLabel lblHeader;
	private javax.swing.JLabel lblMa1;
	private javax.swing.JLabel lblSDT;
	private javax.swing.JLabel lblSDT1;
	private javax.swing.JLabel lblTenKH;
	private javax.swing.JLabel lblTimSDT;
	private javax.swing.JLabel lblTimSDT1;
	private javax.swing.JPanel pnBody;
	private javax.swing.JPanel pnHeader;
	private javax.swing.JPanel pnMenu;
	private javax.swing.JPanel pnSua;
	private javax.swing.JPanel pnTable;
	private javax.swing.JTable tblKH;
	private javax.swing.JTextField txtMa;
	private javax.swing.JTextField txtSDT;
	private javax.swing.JLabel txtSoTrang;
	private javax.swing.JTextField txtTen;
	private javax.swing.JTextField txtTim;
	private javax.swing.JTextField txtTimTen;
	private int trang = 1;
	private float flag;
	private int countDS;
	// End of variables declaration//GEN-END:variables

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btnSkipPrevius)) {
			if (trang > 1) {
				trang = 1;
				docDuLieuLenModel();
			}
		}
		if (obj.equals(btnNextPrevius)) {
			if (trang > 1) {
				trang -= 1;
				docDuLieuLenModel();
			}
		}
		if (obj.equals(btnNextForward)) {
			flag = (float) countDS / 20;
			if (trang < (int) Math.ceil(flag)) {
				trang += 1;
				docDuLieuLenModel();
			}
		}
		if (obj.equals(btnSkipForward)) {
			flag = (float) countDS / 20;
			if (trang < (int) Math.ceil(flag)) {
				trang = (int) Math.ceil(flag);
				docDuLieuLenModel();
			}
		}
	}
}
