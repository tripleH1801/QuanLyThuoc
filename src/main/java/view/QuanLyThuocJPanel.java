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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.Map.Entry;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import controller.DocTien;
import controller.NhanVienRightClickPopUp;
import controller.QuanLyThuocRightClick;
import dao.DAO_CT_HoaDonBan;
import dao.DAO_CongDung;
import dao.DAO_HoaDonBan;
import dao.DAO_KhachHang;
import dao.DAO_Thuoc;
import entity.Thuoc;

/**
 *
 * @author HoangPC
 */
public class QuanLyThuocJPanel extends javax.swing.JPanel implements ActionListener, MouseListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<Thuoc, Integer> mapThuoc;
	private Set<Entry<Thuoc, Integer>> setThuoc;
	private List<Entry<Thuoc, Integer>> listThuoc;
	private DefaultTableModel modelSP;
	private QuanLyThuocRightClick popUp;

	private int trang;
	private DAO_Thuoc daoThuoc;
	private DAO_CongDung daoCongDung;
	private int countDSThuoc;
	private float flag;
	private double tongTien = 0;
	private Vector<String> vecNhomCongDung;
	private Vector<String> vecCongDung;
	private int rowHD;

	public QuanLyThuocJPanel() {
//		docTien = new DocTien();
		daoThuoc = new DAO_Thuoc();
		daoCongDung = new DAO_CongDung();
		rowHD = -1;
		trang = 1;
		listThuoc = new ArrayList<Map.Entry<Thuoc, Integer>>();
		mapThuoc = new LinkedHashMap<>();
		listThuoc = new ArrayList<>();
		countDSThuoc = 0;
		countDSThuoc = daoThuoc.getCountThuocBan();
		initComponents();
	}

	public QuanLyThuocJPanel(String a) {
		daoThuoc = new DAO_Thuoc();
		daoCongDung = new DAO_CongDung();
		rowHD = -1;
		trang = 1;
		listThuoc = new ArrayList<Map.Entry<Thuoc, Integer>>();
		mapThuoc = new LinkedHashMap<>();
		listThuoc = new ArrayList<>();
		countDSThuoc = 0;
		countDSThuoc = daoThuoc.getCountThuocBan();
		initComponents();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		pnHeader = new javax.swing.JPanel();
		lblHeader = new javax.swing.JLabel();
		pnBody = new javax.swing.JPanel();
		pnThongTin = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tblDanhSachThuoc = new javax.swing.JTable();
		btnSkipPrevius = new javax.swing.JButton();
		btnNextPrevius = new javax.swing.JButton();
		txtSoTrang = new javax.swing.JLabel();
		btnNextForward = new javax.swing.JButton();
		btnSkipForward = new javax.swing.JButton();
		jSeparator2 = new javax.swing.JSeparator();
		jLabel5 = new javax.swing.JLabel();
		Jpanel = new javax.swing.JPanel();
		jPanel1 = new javax.swing.JPanel();
		btnNgungKinhDoanh = new javax.swing.JButton();
		btnChitiet = new javax.swing.JButton();
		btnSua = new javax.swing.JButton();
		btnXoatrang = new javax.swing.JButton();
		jSeparator1 = new javax.swing.JSeparator();
		jLabel4 = new javax.swing.JLabel();
		pnTimKiemNangCao = new javax.swing.JPanel();
		jLabel10 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		jcbNhomCongDung = new javax.swing.JComboBox<>();
		jcbCongDung = new javax.swing.JComboBox<>();
		jPanel10 = new javax.swing.JPanel();
		jcbDVT = new javax.swing.JComboBox<>();
		jLabel14 = new javax.swing.JLabel();
		jcbNuocSX = new javax.swing.JComboBox<>();
		jLabel15 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jcbDangBC = new javax.swing.JComboBox<>();
		jSeparator3 = new javax.swing.JSeparator();
		jSeparator4 = new javax.swing.JSeparator();
		jSeparator5 = new javax.swing.JSeparator();
		jLabel13 = new javax.swing.JLabel();
		txtTimKiemHoatChat = new javax.swing.JTextField();
		txtTimKiemTen = new javax.swing.JTextField();

		pnHeader.setBackground(new java.awt.Color(1, 128, 145));

		lblHeader.setBackground(new java.awt.Color(29, 53, 87));
		lblHeader.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
		lblHeader.setForeground(new java.awt.Color(255, 255, 255));
		lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblHeader.setText("Quản lý thuốc");

		javax.swing.GroupLayout pnHeaderLayout = new javax.swing.GroupLayout(pnHeader);
		pnHeader.setLayout(pnHeaderLayout);
		pnHeaderLayout.setHorizontalGroup(
				pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lblHeader,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		pnHeaderLayout.setVerticalGroup(pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(lblHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE));

		pnBody.setBackground(new java.awt.Color(255, 0, 0));

		pnThongTin.setBackground(new java.awt.Color(255, 255, 255));

		jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

		tblDanhSachThuoc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		tblDanhSachThuoc.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Tên Thuốc", "Thành phần", "Dạng bào chế", "ĐVT", "Hàm lượng", "Nước sản xuất",
				"Trạng thái", "Nhóm công dụng", "Công dụng", "Hạn sử dụng", "Giá (VNĐ)", "Số lượng" }) {
			Class[] types = new Class[] { java.lang.String.class, java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class,
					java.lang.Integer.class };
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false,
					false, false };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		tblDanhSachThuoc.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
		tblDanhSachThuoc.setGridColor(new java.awt.Color(204, 204, 204));
		tblDanhSachThuoc.setRowHeight(34);
		tblDanhSachThuoc.setSelectionBackground(new java.awt.Color(1, 128, 145));
		tblDanhSachThuoc.setShowGrid(true);
		tblDanhSachThuoc.getTableHeader().setReorderingAllowed(false);
		jScrollPane1.setViewportView(tblDanhSachThuoc);
		if (tblDanhSachThuoc.getColumnModel().getColumnCount() > 0) {
			tblDanhSachThuoc.getColumnModel().getColumn(0).setResizable(false);
			tblDanhSachThuoc.getColumnModel().getColumn(0).setPreferredWidth(220);
			tblDanhSachThuoc.getColumnModel().getColumn(1).setResizable(false);
			tblDanhSachThuoc.getColumnModel().getColumn(1).setPreferredWidth(250);
			tblDanhSachThuoc.getColumnModel().getColumn(2).setResizable(false);
			tblDanhSachThuoc.getColumnModel().getColumn(2).setPreferredWidth(180);
			tblDanhSachThuoc.getColumnModel().getColumn(3).setResizable(false);
			tblDanhSachThuoc.getColumnModel().getColumn(3).setPreferredWidth(100);
			tblDanhSachThuoc.getColumnModel().getColumn(4).setResizable(false);
			tblDanhSachThuoc.getColumnModel().getColumn(4).setPreferredWidth(100);
			tblDanhSachThuoc.getColumnModel().getColumn(5).setResizable(false);
			tblDanhSachThuoc.getColumnModel().getColumn(5).setPreferredWidth(130);
			tblDanhSachThuoc.getColumnModel().getColumn(6).setResizable(false);
			tblDanhSachThuoc.getColumnModel().getColumn(6).setPreferredWidth(130);
			tblDanhSachThuoc.getColumnModel().getColumn(7).setResizable(false);
			tblDanhSachThuoc.getColumnModel().getColumn(7).setPreferredWidth(170);
			tblDanhSachThuoc.getColumnModel().getColumn(8).setResizable(false);
			tblDanhSachThuoc.getColumnModel().getColumn(8).setPreferredWidth(170);
			tblDanhSachThuoc.getColumnModel().getColumn(9).setResizable(false);
			tblDanhSachThuoc.getColumnModel().getColumn(9).setPreferredWidth(100);
			tblDanhSachThuoc.getColumnModel().getColumn(10).setResizable(false);
			tblDanhSachThuoc.getColumnModel().getColumn(10).setPreferredWidth(80);
			tblDanhSachThuoc.getColumnModel().getColumn(11).setResizable(false);
			tblDanhSachThuoc.getColumnModel().getColumn(11).setPreferredWidth(80);
		}

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

		jSeparator2.setForeground(new java.awt.Color(29, 53, 87));

		jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		jLabel5.setForeground(new java.awt.Color(29, 53, 87));
		jLabel5.setText("Danh sách thuốc");

		javax.swing.GroupLayout pnThongTinLayout = new javax.swing.GroupLayout(pnThongTin);
		pnThongTin.setLayout(pnThongTinLayout);
		pnThongTinLayout.setHorizontalGroup(pnThongTinLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongTinLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jScrollPane1)
								.addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
										pnThongTinLayout.createSequentialGroup().addGroup(pnThongTinLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(pnThongTinLayout.createSequentialGroup()
														.addComponent(btnSkipPrevius,
																javax.swing.GroupLayout.PREFERRED_SIZE, 50,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(btnNextPrevius,
																javax.swing.GroupLayout.PREFERRED_SIZE, 50,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(txtSoTrang,
																javax.swing.GroupLayout.PREFERRED_SIZE, 52,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(btnNextForward,
																javax.swing.GroupLayout.PREFERRED_SIZE, 50,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(btnSkipForward,
																javax.swing.GroupLayout.PREFERRED_SIZE, 50,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(jLabel5)).addGap(0, 996, Short.MAX_VALUE)))
						.addContainerGap()));
		pnThongTinLayout.setVerticalGroup(pnThongTinLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnThongTinLayout.createSequentialGroup().addGap(0, 0, 0).addComponent(jLabel5)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(btnSkipForward, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNextForward, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSkipPrevius, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNextPrevius, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtSoTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));

		Jpanel.setBackground(new java.awt.Color(255, 255, 255));
		Jpanel.setVerifyInputWhenFocusTarget(false);

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));

		btnNgungKinhDoanh.setBackground(new java.awt.Color(204, 204, 204));
		btnNgungKinhDoanh.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		btnNgungKinhDoanh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/forbidden.png"))); // NOI18N
		btnNgungKinhDoanh.setText("Ngừng bán");
		btnNgungKinhDoanh.setToolTipText("Đổi trạng thái kinh doanh");
		btnNgungKinhDoanh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		btnChitiet.setBackground(new java.awt.Color(204, 204, 204));
		btnChitiet.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		btnChitiet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/list.png"))); // NOI18N
		btnChitiet.setText("Chi tiết");
		btnChitiet.setToolTipText("Chi tiết thuốc");
		btnChitiet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnChitiet.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				btnChitietMousePressed(evt);
			}
		});

		btnSua.setBackground(new java.awt.Color(204, 204, 204));
		btnSua.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh.png"))); // NOI18N
		btnSua.setText("Sửa");
		btnSua.setToolTipText("Sửa thôngt tin thuốc");
		btnSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		btnXoatrang.setBackground(new java.awt.Color(204, 204, 204));
		btnXoatrang.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		btnXoatrang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh (1).png"))); // NOI18N
		btnXoatrang.setText("Làm mới");
		btnXoatrang.setToolTipText("Làm mới mục");
		btnXoatrang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addComponent(btnNgungKinhDoanh)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btnChitiet)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btnSua)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btnXoatrang,
								javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(btnNgungKinhDoanh).addComponent(btnChitiet).addComponent(btnSua)
				.addComponent(btnXoatrang));

		jSeparator1.setForeground(new java.awt.Color(29, 53, 87));

		jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		jLabel4.setForeground(new java.awt.Color(29, 53, 87));
		jLabel4.setText("Quản lý thuốc");

		pnTimKiemNangCao.setBackground(new java.awt.Color(255, 255, 255));

		jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		jLabel10.setText("Tên thuốc:");
		jLabel10.setMaximumSize(new java.awt.Dimension(84, 17));
		jLabel10.setMinimumSize(new java.awt.Dimension(84, 17));
		jLabel10.setPreferredSize(new java.awt.Dimension(84, 17));

		jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		jLabel12.setText("Hoạt chất:");
		jLabel12.setMaximumSize(new java.awt.Dimension(74, 17));
		jLabel12.setMinimumSize(new java.awt.Dimension(74, 17));
		jLabel12.setPreferredSize(new java.awt.Dimension(74, 17));

		jcbNhomCongDung.setBackground(new java.awt.Color(153, 153, 153));
		jcbNhomCongDung.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N

		jcbCongDung.setBackground(new java.awt.Color(153, 153, 153));
		jcbCongDung.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
		jcbCongDung.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));

		jPanel10.setBackground(new java.awt.Color(255, 255, 255));

		jcbDVT.setBackground(new java.awt.Color(153, 153, 153));
		jcbDVT.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N

		jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		jLabel14.setText("Nước SX:");

		jcbNuocSX.setBackground(new java.awt.Color(153, 153, 153));
		jcbNuocSX.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N

		jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		jLabel15.setText("ĐVT:");
		jLabel15.setMaximumSize(new java.awt.Dimension(74, 17));
		jLabel15.setMinimumSize(new java.awt.Dimension(74, 17));
		jLabel15.setPreferredSize(new java.awt.Dimension(74, 17));

		javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
		jPanel10.setLayout(jPanel10Layout);
		jPanel10Layout.setHorizontalGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel10Layout.createSequentialGroup()
						.addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 74,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jcbDVT, 0, 225, Short.MAX_VALUE).addGap(18, 18, 18).addComponent(jLabel14)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jcbNuocSX, 0, 238, Short.MAX_VALUE)));
		jPanel10Layout.setVerticalGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
						.addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
										jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jcbDVT, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
										jPanel10Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
												.addComponent(jcbNuocSX, javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))
						.addGap(0, 0, Short.MAX_VALUE)));

		jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		jLabel7.setText("N.công dụng:");

		jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		jLabel9.setText("Dạng BC:");
		jLabel9.setMaximumSize(new java.awt.Dimension(84, 17));
		jLabel9.setMinimumSize(new java.awt.Dimension(84, 17));
		jLabel9.setPreferredSize(new java.awt.Dimension(84, 17));

		jcbDangBC.setBackground(new java.awt.Color(153, 153, 153));
		jcbDangBC.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N

		jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		jLabel13.setText("Công dụng:");

		txtTimKiemHoatChat.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

		txtTimKiemTen.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

		javax.swing.GroupLayout pnTimKiemNangCaoLayout = new javax.swing.GroupLayout(pnTimKiemNangCao);
		pnTimKiemNangCao.setLayout(pnTimKiemNangCaoLayout);
		pnTimKiemNangCaoLayout.setHorizontalGroup(pnTimKiemNangCaoLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnTimKiemNangCaoLayout.createSequentialGroup().addContainerGap()
						.addGroup(pnTimKiemNangCaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jSeparator3).addComponent(jSeparator4)
								.addGroup(pnTimKiemNangCaoLayout.createSequentialGroup().addComponent(jLabel7)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jcbNhomCongDung, 0, 547, Short.MAX_VALUE).addGap(18, 18, 18)
										.addComponent(jLabel13)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jcbCongDung, 0, 547, Short.MAX_VALUE))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										pnTimKiemNangCaoLayout.createSequentialGroup()
												.addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(txtTimKiemTen).addGap(18, 18, 18)
												.addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 74,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(txtTimKiemHoatChat))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										pnTimKiemNangCaoLayout.createSequentialGroup()
												.addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jcbDangBC, 0, 548, Short.MAX_VALUE).addGap(18, 18, 18)
												.addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addContainerGap()));
		pnTimKiemNangCaoLayout.setVerticalGroup(pnTimKiemNangCaoLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnTimKiemNangCaoLayout.createSequentialGroup()
						.addGroup(pnTimKiemNangCaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTimKiemHoatChat, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTimKiemTen, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 5,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addGroup(pnTimKiemNangCaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jcbNhomCongDung, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jcbCongDung, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 5,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addGroup(pnTimKiemNangCaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(pnTimKiemNangCaoLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jcbDangBC, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jSeparator3,
								javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)));

		javax.swing.GroupLayout JpanelLayout = new javax.swing.GroupLayout(Jpanel);
		Jpanel.setLayout(JpanelLayout);
		JpanelLayout.setHorizontalGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(pnTimKiemNangCao, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(JpanelLayout.createSequentialGroup().addContainerGap().addGroup(JpanelLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jSeparator1)
						.addGroup(JpanelLayout.createSequentialGroup()
								.addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 133,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 1147, Short.MAX_VALUE))
						.addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		JpanelLayout.setVerticalGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(JpanelLayout.createSequentialGroup().addContainerGap().addComponent(jLabel4)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addComponent(pnTimKiemNangCao, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		javax.swing.GroupLayout pnBodyLayout = new javax.swing.GroupLayout(pnBody);
		pnBody.setLayout(pnBodyLayout);
		pnBodyLayout.setHorizontalGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(Jpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(pnThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE));
		pnBodyLayout
				.setVerticalGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBodyLayout.createSequentialGroup()
								.addComponent(Jpanel, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, 0).addComponent(pnThongTin, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(pnHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(pnBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(pnHeader, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0).addComponent(pnBody, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

//		===============================CODE==========================
		taoNutChucNang();
		modelSP = (DefaultTableModel) tblDanhSachThuoc.getModel();
		
		btnSkipPrevius.addActionListener(this);
		btnNextPrevius.addActionListener(this);
		btnNextForward.addActionListener(this);
		btnSkipForward.addActionListener(this);

		jcbCongDung.addActionListener(this);
		jcbNhomCongDung.addActionListener(this);
		jcbDangBC.addActionListener(this);
		jcbDVT.addActionListener(this);
		jcbNuocSX.addActionListener(this);
		btnNgungKinhDoanh.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoatrang.addActionListener(this);
		
		txtTimKiemHoatChat.addKeyListener(this);
		txtTimKiemTen.addKeyListener(this);
		
		tblDanhSachThuoc.addMouseListener(this);

//		=====================================================================
		Thread th1 = new Thread(() -> {
			loadNhomCongDung("");
		});
		Thread th2 = new Thread(() -> {
			loadJcombo();
		});
		dataToTBSP();
		th1.start();
		th2.start();
	}
	
	private void loadJcombo() {
		jcbDangBC.addItem("Tất cả");
		jcbDVT.addItem("Tất cả");

		ArrayList<String> listItemp;
		listItemp = new ArrayList<String>();
		listItemp = daoThuoc.getDVT();
		for (String Itemp : listItemp) {
			jcbDVT.addItem(Itemp);
		}
		listItemp = daoThuoc.getDBC();
		for (String Itemp : listItemp) {
			jcbDangBC.addItem(Itemp);
		}
		listItemp = daoThuoc.getNuocSX();
		jcbNuocSX.addItem("Tất cả");
		for (String Itemp : listItemp) {
			jcbNuocSX.addItem(Itemp);
		}
	}
	
	private void loadNhomCongDung(String key) {
		vecNhomCongDung = daoCongDung.getAllNhomCongDung(key);
		if (vecNhomCongDung.size() == 1) {
			JOptionPane.showMessageDialog(null, "Lỗi khi đọc danh sách Nhóm công dụng!");
			return;
		}
		DefaultComboBoxModel<String> md = new DefaultComboBoxModel<String>(vecNhomCongDung);
		jcbNhomCongDung.setModel(md);
	}

	public boolean dataToTBSP() {
		String cd = "Tất cả";
		String nhomcd = "Tất cả";
		String dangBC = "Tất cả";
		String dvt = "Tất cả";
		String nuoc = "Tất cả";
		boolean ktra = false;
		try {
			cd = jcbCongDung.getSelectedItem().toString();
		} catch (Exception e) {
		}
		try {
			nhomcd = jcbNhomCongDung.getSelectedItem().toString();
		} catch (Exception e) {
		}
		try {
			dangBC = jcbDangBC.getSelectedItem().toString();
		} catch (Exception e) {
		}
		try {
			dvt = jcbDVT.getSelectedItem().toString();
		} catch (Exception e) {
		}
		try {
			nuoc = jcbNuocSX.getSelectedItem().toString();
		} catch (Exception e) {
		}

		mapThuoc = daoThuoc.timThuocByAllTxt(trang, txtTimKiemTen.getText(), txtTimKiemHoatChat.getText(), nhomcd,
				dangBC, dvt, cd, nuoc);

		countDSThuoc = daoThuoc.getCountThuocTimTrongDatabase(txtTimKiemTen.getText(), txtTimKiemHoatChat.getText(), nhomcd, dangBC,
				dvt, cd, nuoc);
		setThuoc = mapThuoc.entrySet();
		listThuoc = new ArrayList<>(setThuoc);
		if (listThuoc.size() > 0) {

			ktra = true;
			tblDanhSachThuoc.clearSelection();
			txtSoTrang.setText(String.valueOf(trang));
			modelSP.getDataVector().removeAllElements();
			modelSP.fireTableDataChanged();
			new Thread(() -> {
				listThuoc.forEach(entry -> {
					Thuoc thuoc = entry.getKey();

					modelSP.addRow(new Object[] { thuoc.getTenThuoc(), thuoc.getThanhPhan(), thuoc.getDangBaoChe(),
							thuoc.getDonViTinh(), thuoc.getHamLuong(), thuoc.getNuocSanXuat(),
							thuoc.isTrangThaiKD() == true ? "Đang kinh doanh" : "Ngừng kinh doanh",
							thuoc.getCongDung().getNhomCongDung(), thuoc.getCongDung().getCongDung(), thuoc.getHanSuDung(),
							Math.round(thuoc.getGiaBan()), entry.getValue() });
				});
			}).start();
		}
		return ktra;
	}

	protected void xoaTrang() {
		int c = JOptionPane.showConfirmDialog(null, "Bạn muốn àm mới lại mục quản lý thuốc ?", "Thông báo",
				JOptionPane.YES_NO_OPTION);
		if (c == JOptionPane.YES_OPTION) {
			txtTimKiemTen.setText("");
			txtTimKiemHoatChat.setText("");
			jcbDangBC.setSelectedIndex(0);
			jcbDVT.setSelectedIndex(0);
			jcbNhomCongDung.setSelectedIndex(0);
			jcbNuocSX.setSelectedIndex(0);
			countDSThuoc = daoThuoc.getCountAllThuoc();
			dataToTBSP();
		}
	}

	private void btnChitietMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnChitietMousePressed
		int row = tblDanhSachThuoc.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn thuốc cần xem chi tiết!");
			return;
		}
		xemChiTiet();
	}

	public void suaThuoc() {
		int r = tblDanhSachThuoc.getSelectedRow();
		if (r < 0) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn thuốc cần sửa");
			return;
		}
		Set<Entry<Thuoc, Integer>> setThuoc = mapThuoc.entrySet();
		List<Entry<Thuoc, Integer>> listThuoc = new ArrayList<>(setThuoc);
		Thuoc T = listThuoc.get(r).getKey();
		new SuaThongTinThuocJPanel(T.getMaThuoc(), this).setVisible(true);
	}

	public void ngungKinhDoanh() {
		int row = tblDanhSachThuoc.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn thuốc cần ngừng kinh doanh (kinh doanh lại)");
			return;
		}

		Set<Entry<Thuoc, Integer>> setThuoc = mapThuoc.entrySet();
		List<Entry<Thuoc, Integer>> listThuoc = new ArrayList<>(setThuoc);
		Thuoc t = listThuoc.get(row).getKey();
		if (t.isTrangThaiKD()) {
			int n = JOptionPane.showConfirmDialog(null,
					"<html>Bạn có muốn ngừng kinh doanh thuốc <b>'" + t.getTenThuoc() + "'</b> không?</html>",
					"Thông báo", JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				if (daoThuoc.setNgungKinhDoanh(t)) {
					JOptionPane.showMessageDialog(null,
							"<html>Thuốc <b>" + t.getTenThuoc() + "</b> đã ngừng kinh doanh</html>");
					tblDanhSachThuoc.setValueAt("Ngừng kinh doanh", row, 6);
					return;

				}

			}
		} else {
			int n = JOptionPane.showConfirmDialog(null,
					"<html>Bạn có muốn kinh doanh lại thuốc <b>'" + t.getTenThuoc() + "'</b> không?</html>",
					"Thông báo", JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				if (daoThuoc.setNgungKinhDoanh(t)) {
					JOptionPane.showMessageDialog(null,
							"<html>Thuốc <b>'" + t.getTenThuoc() + "'</b> đã được kinh doanh lại</html>");
					tblDanhSachThuoc.setValueAt("Đang kinh doanh", row, 6);
					return;

				}

			}
		}
	}
	
	private void loadCongDung(String loaiCongDung) {
		if (loaiCongDung.equals("")
				|| loaiCongDung.equalsIgnoreCase("Tất cả")) {
			vecCongDung = new Vector<>();
			vecCongDung.add("Tất cả");
			DefaultComboBoxModel<String> md = new DefaultComboBoxModel<String>(vecCongDung);
			jcbCongDung.setModel(md);
			return;
		}
		vecCongDung = daoCongDung.getAllCongDung(loaiCongDung);
		DefaultComboBoxModel<String> md = new DefaultComboBoxModel<String>(vecCongDung);
		jcbCongDung.setModel(md);
	}

	private void taoNutChucNang() {
		Action f5Action = new AbstractAction("") {
			@Override
			public void actionPerformed(ActionEvent e) {
				xoaTrang();
			}
		};
		String key5 = "help";
		btnXoatrang.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0), key5);
		btnXoatrang.getActionMap().put(key5, f5Action);
	}

	// -------------------------------------Action--------------------------------------------------
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o.equals(jcbNhomCongDung)) {
			loadCongDung(jcbNhomCongDung.getSelectedItem().toString());
		}
		if (o.equals(jcbCongDung) || o.equals(jcbDangBC) || o.equals(jcbDVT) || o.equals(jcbNuocSX)|| o.equals(jcbNhomCongDung)) {

			if ((jcbCongDung.getItemCount() > 1) && (jcbDangBC.getItemCount() > 1) && (jcbDVT.getItemCount() > 1) && (jcbNuocSX.getItemCount() > 1)) {
				trang = 1;
				if (!dataToTBSP()) {
					modelSP.getDataVector().removeAllElements();
					modelSP.fireTableDataChanged();
				}
				txtSoTrang.setText(String.valueOf(trang));
			}
		}
		else if (o.equals(btnSkipPrevius)) {
			if (trang > 1) {
				trang = 1;
				dataToTBSP();
			}
		}
		else if (o.equals(btnNextPrevius)) {
			if (trang > 1) {
				trang -= 1;
				dataToTBSP();
			}
		}
		else if (o.equals(btnNextForward)) {
			countDSThuoc = daoThuoc.getCountThuocTimCoNuocsx(txtTimKiemTen.getText(), txtTimKiemHoatChat.getText(),
					jcbNhomCongDung.getSelectedItem().toString(), jcbDangBC.getSelectedItem().toString(),
					jcbDVT.getSelectedItem().toString(), jcbCongDung.getSelectedItem().toString(), jcbNuocSX.getSelectedItem().toString());
			flag = (float) countDSThuoc / 20;
			System.out.println("1467 so trang co the co : " + flag);
			if (trang < (int) Math.ceil(flag)) {
				trang += 1;
				if (!dataToTBSP())
					trang--;
			}
		}
		else if (o.equals(btnSkipForward)) {
			countDSThuoc = daoThuoc.getCountThuocTimCoNuocsx(txtTimKiemTen.getText(), txtTimKiemHoatChat.getText(),
					jcbNhomCongDung.getSelectedItem().toString(), jcbDangBC.getSelectedItem().toString(),
					jcbDVT.getSelectedItem().toString(), jcbCongDung.getSelectedItem().toString(), jcbNuocSX.getSelectedItem().toString());
			flag = (float) countDSThuoc / 20;
			System.out.println("1467 so trang co the co : " + flag);
			if (trang < (int) Math.ceil(flag)) {
				trang = (int) Math.ceil(flag);
				dataToTBSP();
			}
		}
		else if(o.equals(btnNgungKinhDoanh)) {
			ngungKinhDoanh();
		}
		else if(o.equals(btnXoatrang)) {
			xoaTrang();
		}
		else if(o.equals(btnSua)) {
			suaThuoc();
		}

	}

	// -------------------------------------Mouse-----------------------------------------------------
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getSource().equals(tblDanhSachThuoc)) {
			int r = tblDanhSachThuoc.getSelectedRow();
			if (r >= 0) {
				if (tblDanhSachThuoc.getValueAt(r, 6).toString().equals("Đang kinh doanh")) {
					btnNgungKinhDoanh.setText("Ngừng bán");
					btnNgungKinhDoanh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/forbidden.png")));
				} else {
					btnNgungKinhDoanh.setText("Bán lại");
					btnNgungKinhDoanh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pills.png")));
				}
			}
			JTable table = (JTable) e.getSource();
			Point point = e.getPoint();
			int row = table.rowAtPoint(point);
			if (e.getClickCount() == 2 && row != -1) {//row co the sai
				xemChiTiet();
			}
			
			if (SwingUtilities.isRightMouseButton(e)) {
				row = tblDanhSachThuoc.rowAtPoint(e.getPoint());
				if (row >= 0 && r < tblDanhSachThuoc.getRowCount()) {
					if (tblDanhSachThuoc.getValueAt(r, 6).toString().equals("Đang kinh doanh")) {
						btnNgungKinhDoanh.setText("Ngừng bán");
						btnNgungKinhDoanh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/forbidden.png")));
					} else {
						btnNgungKinhDoanh.setText("Bán lại");
						btnNgungKinhDoanh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pills.png")));
					}
					tblDanhSachThuoc.setRowSelectionInterval(row, row);
					popUp = new QuanLyThuocRightClick(btnNgungKinhDoanh.getText(), this);
				} else {
					tblDanhSachThuoc.clearSelection();
				}
				row = tblDanhSachThuoc.getSelectedRow();
				if (row < 0)
					return;
				else {
					popUp.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		}
	}

	public void xemChiTiet() {
		int r = tblDanhSachThuoc.getSelectedRow();
		if (r == -1) {
			JOptionPane.showMessageDialog(null, "Chưa chọn thuốc!");
		} else {
			Set<Entry<Thuoc, Integer>> setThuoc = mapThuoc.entrySet();
			List<Entry<Thuoc, Integer>> listThuoc = new ArrayList<>(setThuoc);
			Thuoc T = listThuoc.get(r).getKey();
			new ChiTietThuocJframe(T.getMaThuoc()).setVisible(true);
		}
	}

	// -----------------------------key----------------------------
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getSource().equals(tblDanhSachThuoc)) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				tblDanhSachThuoc.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
						.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
				tblDanhSachThuoc.getActionMap().put("Enter", new AbstractAction() {
					@Override
					public void actionPerformed(ActionEvent ae) {
						int r = tblDanhSachThuoc.getSelectedRow();
						if (r >= 0) {
							xemChiTiet();
						}
					}
				});
			} else if (e.getKeyCode() == KeyEvent.VK_DELETE) {
				int r = tblDanhSachThuoc.getSelectedRow();
				if (r >= 0) {
					ngungKinhDoanh();
				}
			} else if (e.getKeyCode() == KeyEvent.VK_S) {
				int r = tblDanhSachThuoc.getSelectedRow();
				if (r >= 0) {
					suaThuoc();
				}
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getSource().equals(txtTimKiemTen) || e.getSource().equals(txtTimKiemHoatChat)) {
			trang = 1;
			if (!dataToTBSP()) {
				modelSP.getDataVector().removeAllElements();
				modelSP.fireTableDataChanged();
			}
			txtSoTrang.setText(String.valueOf(trang));
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	private javax.swing.JPanel Jpanel;
	private javax.swing.JButton btnChitiet;
	private javax.swing.JButton btnNextForward;
	private javax.swing.JButton btnNextPrevius;
	private javax.swing.JButton btnNgungKinhDoanh;
	private javax.swing.JButton btnSkipForward;
	private javax.swing.JButton btnSkipPrevius;
	private javax.swing.JButton btnSua;
	private javax.swing.JButton btnXoatrang;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel10;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JSeparator jSeparator3;
	private javax.swing.JSeparator jSeparator4;
	private javax.swing.JSeparator jSeparator5;
	private javax.swing.JComboBox<String> jcbCongDung;
	private javax.swing.JComboBox<String> jcbDVT;
	private javax.swing.JComboBox<String> jcbDangBC;
	private javax.swing.JComboBox<String> jcbNhomCongDung;
	private javax.swing.JComboBox<String> jcbNuocSX;
	private javax.swing.JLabel lblHeader;
	private javax.swing.JPanel pnBody;
	private javax.swing.JPanel pnHeader;
	private javax.swing.JPanel pnThongTin;
	private javax.swing.JPanel pnTimKiemNangCao;
	private javax.swing.JTable tblDanhSachThuoc;
	private javax.swing.JLabel txtSoTrang;
	private javax.swing.JTextField txtTimKiemHoatChat;
	private javax.swing.JTextField txtTimKiemTen;

}
