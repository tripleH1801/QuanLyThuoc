/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dialog.ModalityType;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import connect.Connect;
import controller.DocTien;
import controller.MyEntry;
import controller.RightClickPopUp;
import dao.DAO_CT_HoaDonBan;
import dao.DAO_CongDung;
import dao.DAO_HoaDonBan;
import dao.DAO_KhachHang;
import dao.DAO_NhanVien;
import dao.DAO_Thuoc;
import entity.CT_HoaDonBan;
import entity.HoaDonBan;
import entity.KhachHang;
import entity.Thuoc;

/**
 *
 * @author HoangPC
 */
public class BanThuocJPanel extends javax.swing.JPanel implements ActionListener, KeyListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private gui_Chinh gui;
	private String maNV;
	private RightClickPopUp popSP;
	private DefaultTableModel modelSP;
	private DefaultTableModel modelHD;

	private Map<Thuoc, Integer> mapThuoc;
	private Set<Entry<Thuoc, Integer>> setThuoc;
	private List<Entry<Thuoc, Integer>> listThuoc;

	private ArrayList<Entry<Thuoc, Integer>> listChonThuoc;
	private int trang;
	private DAO_Thuoc dao_BanThuoc;
	private DAO_KhachHang dao_KhachHang;
	private DAO_HoaDonBan dao_HoaDonBan;
	private DAO_CT_HoaDonBan dao_CTHoaDon;
	private DAO_CongDung daoCongDung;
	private DAO_NhanVien daoNhanVien;
	private int countDSThuoc;
	private float flag;
	private double tongTien = 0;
	private Vector<String> vecNhomCongDung;
	private Vector<String> vecCongDung;
	private int rowHD;
	private DocTien docTien;

	/**
	 * Creates new form ChangeJPanel
	 */
	public BanThuocJPanel(gui_Chinh gui, String ten, String ma) {
		try {
			Connect.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		docTien = new DocTien();
		dao_BanThuoc = new DAO_Thuoc();
		dao_KhachHang = new DAO_KhachHang();
		dao_HoaDonBan = new DAO_HoaDonBan();
		dao_CTHoaDon = new DAO_CT_HoaDonBan();
		daoCongDung = new DAO_CongDung();
		daoNhanVien = new DAO_NhanVien();
		rowHD = -1;
		trang = 1;
		listThuoc = new ArrayList<Map.Entry<Thuoc, Integer>>();
		listChonThuoc = new ArrayList<Entry<Thuoc, Integer>>();
		mapThuoc = new LinkedHashMap<>();
		listThuoc = new ArrayList<>();
		countDSThuoc = 0;
		countDSThuoc = dao_BanThuoc.getCountThuocBan();
		initComponents();
		this.maNV = gui.getMaNV();
		this.gui = gui;
		maNV = ma;

	}

	public BanThuocJPanel() {
		initComponents();
	}

	private void initComponents() {

		jdialogThemThuoc = new javax.swing.JDialog();
		jPanel8 = new javax.swing.JPanel();
		txtLoaiDialog = new javax.swing.JLabel();
		txtTenThuocDialog = new javax.swing.JLabel();
		txtSoLuongDialog = new javax.swing.JSpinner();
		btnThemDialog = new javax.swing.JButton();
		jLabel12 = new javax.swing.JLabel();
		pnHeader1 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		pnBody = new javax.swing.JPanel();
		pnChonSp = new javax.swing.JPanel();
		jPanel7 = new javax.swing.JPanel();
		pnTimKiemNangCao2 = new javax.swing.JPanel();
		jLabel15 = new javax.swing.JLabel();
		txtTimKiemTen = new javax.swing.JTextField();
		jLabel16 = new javax.swing.JLabel();
		txtTimKiemHoatChat = new javax.swing.JTextField();
		jLabel17 = new javax.swing.JLabel();
		jcbDangBC = new javax.swing.JComboBox<>();
		jcbDVT = new javax.swing.JComboBox<>();
		jLabel18 = new javax.swing.JLabel();
		pnKH = new javax.swing.JPanel();
		jcbNhomCongDung = new javax.swing.JComboBox<>();
		jLabel7 = new javax.swing.JLabel();
		jLabel13 = new javax.swing.JLabel();
		jcbCongDung = new javax.swing.JComboBox<>();
		jPanel1 = new javax.swing.JPanel();
		btnThanhToan = new javax.swing.JButton();
		cbkXuatIn = new javax.swing.JCheckBox();
		btnXemHD = new javax.swing.JButton();
		btnHuyHD = new javax.swing.JButton();
		jPanel3 = new javax.swing.JPanel();
		lblTienNhan4 = new javax.swing.JLabel();
		txtTongHDThue = new javax.swing.JTextField();
		txtTienBangChu = new javax.swing.JLabel();
		jPanel6 = new javax.swing.JPanel();
		txtTenKH = new javax.swing.JTextField();
		lblTenKH = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		jLabel5 = new javax.swing.JLabel();
		txtTimSDT = new javax.swing.JTextField();
		btnTim = new javax.swing.JButton();
		btnThemKH = new javax.swing.JButton();
		lblDC = new javax.swing.JLabel();
		jSeparator5 = new javax.swing.JSeparator();
		jSeparator2 = new javax.swing.JSeparator();
		txtSDT = new javax.swing.JTextField();
		jPanel11 = new javax.swing.JPanel();
		lblTienNhan = new javax.swing.JLabel();
		txtTienNhan = new javax.swing.JTextField();
		lblTienNhan2 = new javax.swing.JLabel();
		txtTienTra = new javax.swing.JTextField();
		jPanel5 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tblSP = new javax.swing.JTable();
		jPanel10 = new javax.swing.JPanel();
		btnSkipPrevius = new javax.swing.JButton();
		btnNextPrevius = new javax.swing.JButton();
		txtSoTrang = new javax.swing.JTextField();
		btnNextForward = new javax.swing.JButton();
		jPanel4 = new javax.swing.JPanel();
		btnChiTiet = new javax.swing.JButton();
		txtSoLuongSP = new javax.swing.JTextField();
		btnThem = new javax.swing.JButton();
		btnSkipForward = new javax.swing.JButton();
		btnLamMoiTimKiem = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		tblDonHang = new javax.swing.JTable();
		jSeparator6 = new javax.swing.JSeparator();
		jPanel9 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jPanel12 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();

		jdialogThemThuoc.setTitle("Thêm thuốc");
		jdialogThemThuoc.setBackground(new java.awt.Color(255, 255, 255));
		jdialogThemThuoc.setMinimumSize(new java.awt.Dimension(355, 150));
		jdialogThemThuoc.setResizable(false);

		jPanel8.setBackground(new java.awt.Color(255, 255, 255));
		jPanel8.setMinimumSize(new java.awt.Dimension(344, 103));

		txtLoaiDialog.setFont(new java.awt.Font("Arial", 1, 14));
		txtLoaiDialog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		txtLoaiDialog.setText("Thêm thuốc vào giỏ");

		txtTenThuocDialog.setFont(new java.awt.Font("Arial", 0, 13));

		txtSoLuongDialog.setFont(new java.awt.Font("Arial", 0, 14));
		txtSoLuongDialog.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

		btnThemDialog.setFont(new java.awt.Font("Arial", 0, 14));
		btnThemDialog.setText("Thêm vào giỏ");

		jLabel12.setText("Số lượng:");

		javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
		jPanel8.setLayout(jPanel8Layout);
		jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(txtLoaiDialog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addGroup(jPanel8Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(txtTenThuocDialog, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel8Layout.createSequentialGroup()
								.addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(txtSoLuongDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 127,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18).addComponent(btnThemDialog, javax.swing.GroupLayout.PREFERRED_SIZE,
										121, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));
		jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel8Layout.createSequentialGroup()
						.addComponent(txtLoaiDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(txtTenThuocDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(btnThemDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txtSoLuongDialog, javax.swing.GroupLayout.DEFAULT_SIZE, 30,
												Short.MAX_VALUE)))
						.addGap(14, 14, 14)));

		javax.swing.GroupLayout jdialogThemThuocLayout = new javax.swing.GroupLayout(jdialogThemThuoc.getContentPane());
		jdialogThemThuoc.getContentPane().setLayout(jdialogThemThuocLayout);
		jdialogThemThuocLayout.setHorizontalGroup(
				jdialogThemThuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
						jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE));
		jdialogThemThuocLayout
				.setVerticalGroup(jdialogThemThuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));

		jdialogThemThuoc.setLocationRelativeTo(null);
		jdialogThemThuoc.setModalityType(ModalityType.APPLICATION_MODAL);

		setBackground(new java.awt.Color(255, 255, 255));

		pnHeader1.setBackground(new java.awt.Color(1, 128, 145));
		pnHeader1.setForeground(new java.awt.Color(255, 255, 255));

		jLabel2.setFont(new java.awt.Font("Arial", 1, 24));
		jLabel2.setForeground(new java.awt.Color(255, 255, 255));
		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel2.setText("Cửa hàng");

		javax.swing.GroupLayout pnHeader1Layout = new javax.swing.GroupLayout(pnHeader1);
		pnHeader1.setLayout(pnHeader1Layout);
		pnHeader1Layout.setHorizontalGroup(
				pnHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel2,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		pnHeader1Layout.setVerticalGroup(pnHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE));

		pnBody.setBackground(new java.awt.Color(255, 255, 255));

		pnChonSp.setBackground(new java.awt.Color(255, 255, 255));

		jPanel7.setBackground(new java.awt.Color(255, 255, 255));

		pnTimKiemNangCao2.setBackground(new java.awt.Color(255, 255, 255));

		jLabel15.setFont(new java.awt.Font("Arial", 0, 14));
		jLabel15.setText("Tên thuốc:");
		jLabel15.setMaximumSize(new java.awt.Dimension(84, 17));
		jLabel15.setMinimumSize(new java.awt.Dimension(84, 17));
		jLabel15.setPreferredSize(new java.awt.Dimension(84, 17));

		txtTimKiemTen.setFont(new java.awt.Font("Arial", 0, 14));

		jLabel16.setFont(new java.awt.Font("Arial", 0, 14));
		jLabel16.setText("Hoạt chất:");
		jLabel16.setMaximumSize(new java.awt.Dimension(74, 17));
		jLabel16.setMinimumSize(new java.awt.Dimension(74, 17));
		jLabel16.setPreferredSize(new java.awt.Dimension(74, 17));

		txtTimKiemHoatChat.setFont(new java.awt.Font("Arial", 0, 14));

		jLabel17.setFont(new java.awt.Font("Arial", 0, 14));
		jLabel17.setText("Dạng BC:");
		jLabel17.setMaximumSize(new java.awt.Dimension(84, 17));
		jLabel17.setMinimumSize(new java.awt.Dimension(84, 17));
		jLabel17.setPreferredSize(new java.awt.Dimension(84, 17));

		jcbDangBC.setBackground(new java.awt.Color(153, 153, 153));
		jcbDangBC.setFont(new java.awt.Font("Arial", 1, 13));
		jcbDangBC.setMaximumSize(new java.awt.Dimension(284, 32767));
		jcbDangBC.setMinimumSize(new java.awt.Dimension(284, 22));
		jcbDangBC.setPreferredSize(new java.awt.Dimension(284, 22));

		jcbDVT.setBackground(new java.awt.Color(153, 153, 153));
		jcbDVT.setFont(new java.awt.Font("Arial", 1, 13));
		jcbDVT.setMaximumSize(new java.awt.Dimension(284, 32767));
		jcbDVT.setMinimumSize(new java.awt.Dimension(284, 22));
		jcbDVT.setPreferredSize(new java.awt.Dimension(284, 22));

		jLabel18.setFont(new java.awt.Font("Arial", 0, 14));
		jLabel18.setText("ĐVT:");
		jLabel18.setMaximumSize(new java.awt.Dimension(84, 17));
		jLabel18.setMinimumSize(new java.awt.Dimension(84, 17));
		jLabel18.setPreferredSize(new java.awt.Dimension(84, 17));

		javax.swing.GroupLayout pnTimKiemNangCao2Layout = new javax.swing.GroupLayout(pnTimKiemNangCao2);
		pnTimKiemNangCao2.setLayout(pnTimKiemNangCao2Layout);
		pnTimKiemNangCao2Layout.setHorizontalGroup(pnTimKiemNangCao2Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnTimKiemNangCao2Layout.createSequentialGroup().addContainerGap()
						.addGroup(pnTimKiemNangCao2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										pnTimKiemNangCao2Layout.createSequentialGroup()
												.addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(txtTimKiemTen).addGap(18, 18, 18)
												.addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 74,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(txtTimKiemHoatChat))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										pnTimKiemNangCao2Layout.createSequentialGroup()
												.addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jcbDangBC, 0, 326, Short.MAX_VALUE).addGap(18, 18, 18)
												.addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 76,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jcbDVT, 0, 325, Short.MAX_VALUE)))
						.addContainerGap()));
		pnTimKiemNangCao2Layout.setVerticalGroup(pnTimKiemNangCao2Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnTimKiemNangCao2Layout.createSequentialGroup().addGroup(pnTimKiemNangCao2Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTimKiemTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTimKiemHoatChat, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
								javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(8, 8, 8)
						.addGroup(pnTimKiemNangCao2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(pnTimKiemNangCao2Layout.createSequentialGroup().addGap(1, 1, 1)
										.addGroup(pnTimKiemNangCao2Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(pnTimKiemNangCao2Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jcbDangBC, javax.swing.GroupLayout.PREFERRED_SIZE,
																28, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE,
																28, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(jcbDVT, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addGap(0, 0, 0)));

		javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
		jPanel7.setLayout(jPanel7Layout);
		jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel7Layout.createSequentialGroup().addComponent(pnTimKiemNangCao2,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(0, 0, 0)));
		jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(pnTimKiemNangCao2, javax.swing.GroupLayout.PREFERRED_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));

		javax.swing.GroupLayout pnChonSpLayout = new javax.swing.GroupLayout(pnChonSp);
		pnChonSp.setLayout(pnChonSpLayout);
		pnChonSpLayout.setHorizontalGroup(
				pnChonSpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel7,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		pnChonSpLayout.setVerticalGroup(pnChonSpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnChonSpLayout.createSequentialGroup().addGap(0, 0, 0)
						.addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)));

		pnKH.setBackground(new java.awt.Color(255, 255, 255));
		pnKH.setPreferredSize(new java.awt.Dimension(477, 621));

		jcbNhomCongDung.setBackground(new java.awt.Color(153, 153, 153));
		jcbNhomCongDung.setFont(new java.awt.Font("Arial", 1, 13));
		jcbNhomCongDung.setMaximumSize(new java.awt.Dimension(284, 32767));

		jLabel7.setFont(new java.awt.Font("Arial", 0, 14));
		jLabel7.setText("N.công dụng:");

		jLabel13.setFont(new java.awt.Font("Arial", 0, 14));
		jLabel13.setText("Công dụng:");

		jcbCongDung.setBackground(new java.awt.Color(153, 153, 153));
		jcbCongDung.setFont(new java.awt.Font("Arial", 1, 13));
		jcbCongDung.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
		jcbCongDung.setMaximumSize(new java.awt.Dimension(284, 32767));
		jcbCongDung.setMinimumSize(new java.awt.Dimension(284, 22));
		jcbCongDung.setPreferredSize(new java.awt.Dimension(284, 22));

		javax.swing.GroupLayout pnKHLayout = new javax.swing.GroupLayout(pnKH);
		pnKH.setLayout(pnKHLayout);
		pnKHLayout.setHorizontalGroup(pnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnKHLayout.createSequentialGroup()
						.addGroup(pnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jcbCongDung, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jcbNhomCongDung, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addContainerGap()));
		pnKHLayout.setVerticalGroup(pnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnKHLayout.createSequentialGroup().addGap(0, 0, 0)
						.addGroup(pnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jcbNhomCongDung, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(8, 8, 8)
						.addGroup(pnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jcbCongDung, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));

		btnThanhToan.setBackground(new java.awt.Color(204, 204, 204));
		btnThanhToan.setFont(new java.awt.Font("Arial", 1, 16));
		btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/money.png")));
		btnThanhToan.setText("Thanh toán");
		btnThanhToan.setToolTipText("Thanh toán");
		btnThanhToan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		cbkXuatIn.setBackground(new java.awt.Color(255, 255, 255));
		cbkXuatIn.setFont(new java.awt.Font("Arial", 1, 16));
		cbkXuatIn.setText("Xuất In");
		cbkXuatIn.setToolTipText("Xuất file khi thanh toán");
		cbkXuatIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		cbkXuatIn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

		btnXemHD.setBackground(new java.awt.Color(204, 204, 204));
		btnXemHD.setFont(new java.awt.Font("Arial", 1, 16));
		btnXemHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png")));
		btnXemHD.setToolTipText("Xem chi tiết hóa đơn");
		btnXemHD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		btnHuyHD.setBackground(new java.awt.Color(204, 204, 204));
		btnHuyHD.setFont(new java.awt.Font("Arial", 1, 16));
		btnHuyHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/forbidden.png")));
		btnHuyHD.setText("Hủy đơn");
		btnHuyHD.setToolTipText("Hủy hóa đơn");
		btnHuyHD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btnHuyHD)
						.addGap(18, 18, 18).addComponent(btnXemHD)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(cbkXuatIn)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(btnThanhToan).addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel1Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addGroup(jPanel1Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(btnHuyHD)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(btnThanhToan).addComponent(cbkXuatIn))
								.addComponent(btnXemHD)).addGap(0, 0, 0)));

		jPanel3.setBackground(new java.awt.Color(255, 255, 255));

		lblTienNhan4.setFont(new java.awt.Font("Arial", 1, 14));
		lblTienNhan4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		lblTienNhan4.setText("Tổng HĐ (Có VAT):");

		txtTongHDThue.setEditable(false);
		txtTongHDThue.setBackground(new java.awt.Color(255, 255, 255));
		txtTongHDThue.setFont(new java.awt.Font("Arial", 1, 18));
		txtTongHDThue.setForeground(new java.awt.Color(255, 0, 0));
		txtTongHDThue.setHorizontalAlignment(javax.swing.JTextField.LEFT);
		txtTongHDThue.setBorder(null);
		txtTongHDThue.setFocusable(false);
		txtTongHDThue.setName("");

		txtTienBangChu.setFont(new java.awt.Font("Arial", 3, 14));
		txtTienBangChu.setForeground(new java.awt.Color(255, 0, 0));

		jPanel6.setBackground(new java.awt.Color(255, 255, 255));

		txtTenKH.setEditable(false);
		txtTenKH.setBackground(new java.awt.Color(255, 255, 255));
		txtTenKH.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		txtTenKH.setBorder(null);
		txtTenKH.setDisabledTextColor(new java.awt.Color(255, 255, 255));
		txtTenKH.setName("");
		txtTenKH.setPreferredSize(new java.awt.Dimension(7, 30));

		lblTenKH.setFont(new java.awt.Font("Arial", 0, 14));
		lblTenKH.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		lblTenKH.setText("Tên KH:");

		jPanel2.setBackground(new java.awt.Color(255, 255, 255));

		jLabel5.setFont(new java.awt.Font("Arial", 0, 14));
		jLabel5.setText("Tìm SĐT:");

		txtTimSDT.setFont(new java.awt.Font("Arial", 0, 14));

		btnTim.setBackground(new java.awt.Color(204, 204, 204));
		btnTim.setFont(new java.awt.Font("Segoe UI", 1, 14));
		btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/find.png")));
		btnTim.setToolTipText("Tìm khách hàng đã có");
		btnTim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		btnThemKH.setBackground(new java.awt.Color(204, 204, 204));
		btnThemKH.setFont(new java.awt.Font("Segoe UI", 1, 14));
		btnThemKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sign-up.png")));
		btnThemKH.setText("Thêm KH");
		btnThemKH.setToolTipText("Thêm mới khách hàng");
		btnThemKH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnThemKH.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThemKHActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel5)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(txtTimSDT)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btnTim,
								javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(8, 8, 8).addComponent(btnThemKH)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel2Layout.createSequentialGroup().addGap(0, 0, 0)
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
												jPanel2Layout.createSequentialGroup()
														.addComponent(btnThemKH, javax.swing.GroupLayout.PREFERRED_SIZE,
																30, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(0, 0, Short.MAX_VALUE))
										.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
												jPanel2Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
														.addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE,
																30, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(txtTimSDT, javax.swing.GroupLayout.Alignment.LEADING))
								.addGap(0, 0, 0)));

		lblDC.setFont(new java.awt.Font("Arial", 0, 14));
		lblDC.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		lblDC.setText("SĐT:");

		txtSDT.setEditable(false);
		txtSDT.setBackground(new java.awt.Color(255, 255, 255));
		txtSDT.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		txtSDT.setBorder(null);
		txtSDT.setDisabledTextColor(new java.awt.Color(0, 0, 0));
		txtSDT.setFocusable(false);
		txtSDT.setName("");
		txtSDT.setPreferredSize(new java.awt.Dimension(7, 30));

		javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
		jPanel6.setLayout(jPanel6Layout);
		jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel6Layout.createSequentialGroup()
								.addComponent(lblTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 56,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(13, 13, 13)
								.addComponent(txtTenKH, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(lblDC).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(jSeparator5).addComponent(jSeparator2)).addContainerGap()));
		jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel6Layout.createSequentialGroup().addGap(0, 0, 0)
						.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 5,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblDC, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 21,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(3, 3, 3).addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel3Layout.createSequentialGroup()
								.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel3Layout.createSequentialGroup().addComponent(lblTienNhan4)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(txtTongHDThue))
										.addComponent(txtTienBangChu, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap()))));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addGap(0, 0, 0)
						.addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel3Layout.createSequentialGroup().addGap(1, 1, 1).addComponent(
										lblTienNhan4, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(txtTongHDThue, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(txtTienBangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 21,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		jPanel11.setBackground(new java.awt.Color(255, 255, 255));

		lblTienNhan.setFont(new java.awt.Font("Arial", 1, 14));
		lblTienNhan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		lblTienNhan.setText("Tiền nhận:");
		lblTienNhan.setMaximumSize(new java.awt.Dimension(126, 17));
		lblTienNhan.setMinimumSize(new java.awt.Dimension(126, 17));
		lblTienNhan.setPreferredSize(new java.awt.Dimension(126, 17));

		txtTienNhan.setFont(new java.awt.Font("Arial", 1, 16));
		txtTienNhan.setHorizontalAlignment(javax.swing.JTextField.LEFT);
		txtTienNhan.setToolTipText("Tiền khách hàng trả");
		txtTienNhan.setName("");

		lblTienNhan2.setFont(new java.awt.Font("Arial", 1, 14));
		lblTienNhan2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		lblTienNhan2.setText("Tiền trả lại:");
		lblTienNhan2.setMaximumSize(new java.awt.Dimension(126, 17));
		lblTienNhan2.setMinimumSize(new java.awt.Dimension(126, 17));
		lblTienNhan2.setPreferredSize(new java.awt.Dimension(126, 17));

		txtTienTra.setEditable(false);
		txtTienTra.setBackground(new java.awt.Color(255, 255, 255));
		txtTienTra.setFont(new java.awt.Font("Arial", 1, 16));
		txtTienTra.setHorizontalAlignment(javax.swing.JTextField.LEFT);
		txtTienTra.setBorder(null);
		txtTienTra.setFocusable(false);
		txtTienTra.setName("");

		javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
		jPanel11.setLayout(jPanel11Layout);
		jPanel11Layout.setHorizontalGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel11Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(lblTienNhan, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblTienNhan2, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(txtTienTra).addComponent(txtTienNhan))
						.addContainerGap()));
		jPanel11Layout.setVerticalGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel11Layout.createSequentialGroup().addGap(0, 0, 0)
						.addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(txtTienNhan).addComponent(lblTienNhan,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblTienNhan2, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTienTra, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(16, Short.MAX_VALUE)));

		jPanel5.setBackground(new java.awt.Color(255, 255, 255));
		jPanel5.setMinimumSize(new java.awt.Dimension(745, 612));

		jScrollPane1.setAutoscrolls(true);

		tblSP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		tblSP.setFont(new java.awt.Font("Arial", 0, 14));
		tblSP.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Tên thuốc", "Thành phần", "Dạng BC", "ĐVT", "Hàm lượng", "Nhóm công dụng", "Công dụng",
				"Hạn sử dụng", "Giá (VNĐ)", "SL" }) {
			Class[] types = new Class[] { java.lang.String.class, java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.Double.class, java.lang.Integer.class };
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		tblSP.setAutoscrolls(false);
		tblSP.setGridColor(new java.awt.Color(245, 245, 245));
		tblSP.setRowHeight(30);
		tblSP.setSelectionBackground(new java.awt.Color(1, 128, 145));
		tblSP.getTableHeader().setReorderingAllowed(false);
		tblSP.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				tblSPMouseReleased(evt);
			}
		});
		jScrollPane1.setViewportView(tblSP);
		if (tblSP.getColumnModel().getColumnCount() > 0) {
			tblSP.getColumnModel().getColumn(0).setResizable(false);
			tblSP.getColumnModel().getColumn(0).setPreferredWidth(180);
			tblSP.getColumnModel().getColumn(1).setResizable(false);
			tblSP.getColumnModel().getColumn(1).setPreferredWidth(180);
			tblSP.getColumnModel().getColumn(2).setResizable(false);
			tblSP.getColumnModel().getColumn(2).setPreferredWidth(180);
			tblSP.getColumnModel().getColumn(3).setResizable(false);
			tblSP.getColumnModel().getColumn(3).setPreferredWidth(100);
			tblSP.getColumnModel().getColumn(4).setResizable(false);
			tblSP.getColumnModel().getColumn(4).setPreferredWidth(90);
			tblSP.getColumnModel().getColumn(5).setResizable(false);
			tblSP.getColumnModel().getColumn(5).setPreferredWidth(180);
			tblSP.getColumnModel().getColumn(6).setResizable(false);
			tblSP.getColumnModel().getColumn(6).setPreferredWidth(150);
			tblSP.getColumnModel().getColumn(7).setResizable(false);
			tblSP.getColumnModel().getColumn(7).setPreferredWidth(100);
			tblSP.getColumnModel().getColumn(8).setResizable(false);
			tblSP.getColumnModel().getColumn(8).setPreferredWidth(100);
			tblSP.getColumnModel().getColumn(9).setResizable(false);
			tblSP.getColumnModel().getColumn(9).setPreferredWidth(100);
		}
		tblSP.getTableHeader().setFont(new java.awt.Font("Arial", 0, 14));

		jPanel10.setBackground(new java.awt.Color(255, 255, 255));

		btnSkipPrevius.setBackground(new java.awt.Color(204, 204, 204));
		btnSkipPrevius.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/img/baseline_skip_previous_white_24dp.png")));
		btnSkipPrevius.setToolTipText("Trang đầu");
		btnSkipPrevius.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnSkipPrevius.setPreferredSize(new java.awt.Dimension(40, 30));

		btnNextPrevius.setBackground(new java.awt.Color(204, 204, 204));
		btnNextPrevius
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/baseline_fast_rewind_white_24dp.png")));
		btnNextPrevius.setToolTipText("Trang trước");
		btnNextPrevius.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnNextPrevius.setPreferredSize(new java.awt.Dimension(40, 30));

		txtSoTrang.setEditable(false);
		txtSoTrang.setBackground(new java.awt.Color(255, 255, 255));
		txtSoTrang.setFont(new java.awt.Font("Arial", 1, 18));
		txtSoTrang.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtSoTrang.setText("0");
		txtSoTrang.setBorder(null);
		txtSoTrang.setFocusable(false);

		btnNextForward.setBackground(new java.awt.Color(204, 204, 204));
		btnNextForward.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/img/baseline_fast_forward_white_24dp.png")));
		btnNextForward.setToolTipText("Trang sau");
		btnNextForward.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnNextForward.setPreferredSize(new java.awt.Dimension(40, 30));

		jPanel4.setBackground(new java.awt.Color(255, 255, 255));

		btnChiTiet.setBackground(new java.awt.Color(204, 204, 204));
		btnChiTiet.setFont(new java.awt.Font("Arial", 1, 16));
		btnChiTiet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/list.png")));
		btnChiTiet.setText("Chi tiết");
		btnChiTiet.setToolTipText("Xem chi tiết thuốc");
		btnChiTiet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel4Layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnChiTiet).addContainerGap()));
		jPanel4Layout.setVerticalGroup(
				jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(btnChiTiet));

		txtSoLuongSP.setFont(new java.awt.Font("Arial", 1, 16));
		txtSoLuongSP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtSoLuongSP.setText("0");
		txtSoLuongSP.setToolTipText("Lượng thuốc mua");

		btnThem.setBackground(new java.awt.Color(204, 204, 204));
		btnThem.setFont(new java.awt.Font("Arial", 1, 16));
		btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buy-online.png")));
		btnThem.setText("Thêm");
		btnThem.setToolTipText("Thêm thuốc vào giỏ hàng");
		btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		btnSkipForward.setBackground(new java.awt.Color(204, 204, 204));
		btnSkipForward
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/baseline_skip_next_white_24dp.png")));
		btnSkipForward.setToolTipText("Trang cuối");
		btnSkipForward.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnSkipForward.setPreferredSize(new java.awt.Dimension(40, 30));

		btnLamMoiTimKiem.setBackground(new java.awt.Color(204, 204, 204));
		btnLamMoiTimKiem.setFont(new java.awt.Font("Arial", 1, 16));
		btnLamMoiTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh.png")));
		btnLamMoiTimKiem.setText("Làm mới tìm kiếm");
		btnLamMoiTimKiem.setToolTipText("Làm mới thanh tìm kiếm và danh sách thuốc");
		btnLamMoiTimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
		jPanel10.setLayout(jPanel10Layout);
		jPanel10Layout
				.setHorizontalGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
								.addComponent(btnSkipPrevius, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnNextPrevius, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(txtSoTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 52,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnNextForward, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(btnSkipForward, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(40, 40, 40)
								.addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(txtSoLuongSP, javax.swing.GroupLayout.PREFERRED_SIZE, 52,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnThem)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnLamMoiTimKiem)));
		jPanel10Layout.setVerticalGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel10Layout.createSequentialGroup().addGap(0, 0, 0).addGroup(jPanel10Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addComponent(txtSoTrang, javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(btnNextPrevius, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(btnSkipPrevius, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
						.addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addComponent(btnNextForward, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
								.addComponent(btnSkipForward, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(txtSoLuongSP, javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnLamMoiTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))));

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane1).addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup()
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel10,
								javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)));

		tblDonHang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		tblDonHang.setFont(new java.awt.Font("Arial", 0, 14));
		tblDonHang.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Tên thuốc", "Hàm lượng", "Giá (VNĐ)", "VAT", "Số lượng", "Thành tiền" }) {
			Class[] types = new Class[] { java.lang.String.class, java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.Integer.class, java.lang.String.class };
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		tblDonHang.setGridColor(new java.awt.Color(245, 245, 245));
		tblDonHang.setRowHeight(30);
		tblDonHang.setSelectionBackground(new java.awt.Color(1, 128, 145));
		tblDonHang.getTableHeader().setReorderingAllowed(false);
		tblDonHang.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				tblDonHangMouseReleased(evt);
			}
		});
		jScrollPane2.setViewportView(tblDonHang);
		if (tblDonHang.getColumnModel().getColumnCount() > 0) {
			tblDonHang.getColumnModel().getColumn(0).setResizable(false);
			tblDonHang.getColumnModel().getColumn(0).setPreferredWidth(310);
			tblDonHang.getColumnModel().getColumn(1).setResizable(false);
			tblDonHang.getColumnModel().getColumn(1).setPreferredWidth(170);
			tblDonHang.getColumnModel().getColumn(2).setResizable(false);
			tblDonHang.getColumnModel().getColumn(2).setPreferredWidth(100);
			tblDonHang.getColumnModel().getColumn(3).setResizable(false);
			tblDonHang.getColumnModel().getColumn(3).setPreferredWidth(70);
			tblDonHang.getColumnModel().getColumn(4).setResizable(false);
			tblDonHang.getColumnModel().getColumn(4).setPreferredWidth(70);
			tblDonHang.getColumnModel().getColumn(5).setResizable(false);
			tblDonHang.getColumnModel().getColumn(5).setPreferredWidth(130);
		}

		jLabel1.setFont(new java.awt.Font("Arial", 1, 20));
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("Giỏ hàng");

		javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
		jPanel9.setLayout(jPanel9Layout);
		jPanel9Layout.setHorizontalGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel9Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(jLabel1)));

		jLabel3.setFont(new java.awt.Font("Arial", 1, 20));
		jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel3.setText("Thông tin hóa đơn");

		javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
		jPanel12.setLayout(jPanel12Layout);
		jPanel12Layout.setHorizontalGroup(
				jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel3,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		jPanel12Layout.setVerticalGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel12Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(jLabel3)));

		javax.swing.GroupLayout pnBodyLayout = new javax.swing.GroupLayout(pnBody);
		pnBody.setLayout(pnBodyLayout);
		pnBodyLayout.setHorizontalGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addGroup(pnBodyLayout.createSequentialGroup().addGroup(pnBodyLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(pnChonSp, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(pnBodyLayout.createSequentialGroup().addContainerGap().addComponent(jScrollPane2)))
						.addGap(0, 0, 0)
						.addGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pnBodyLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
										.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(pnKH, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
								.addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
				.addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING));
		pnBodyLayout.setVerticalGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnBodyLayout.createSequentialGroup()
						.addGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(pnChonSp, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(pnKH, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 320, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pnBodyLayout.createSequentialGroup()
										.addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
						.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(pnBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(pnHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(pnHeader1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(pnBody, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(0, 0, 0)));

		// Bat su kien =========================================
		modelSP = (DefaultTableModel) tblSP.getModel();
		modelHD = (DefaultTableModel) tblDonHang.getModel();

		btnSkipPrevius.addActionListener(this);
		btnNextPrevius.addActionListener(this);
		btnNextForward.addActionListener(this);
		btnSkipForward.addActionListener(this);
		btnThem.addActionListener(this);
		btnTim.addActionListener(this);
		txtTimSDT.addKeyListener(this);
		tblSP.addMouseListener(this);
		txtSoLuongSP.addKeyListener(this);
		btnHuyHD.addActionListener(this);
		txtTienNhan.addKeyListener(this);
		btnThanhToan.addActionListener(this);
		btnThemDialog.addActionListener(this);
		txtSoLuongDialog.addKeyListener(this);
		txtTimKiemTen.addKeyListener(this);
		txtTimKiemHoatChat.addKeyListener(this);
		tblDonHang.addMouseListener(this);
		jcbCongDung.addActionListener(this);
		jcbNhomCongDung.addActionListener(this);
		jcbDangBC.addActionListener(this);
		jcbDVT.addActionListener(this);
		btnChiTiet.addActionListener(this);
		btnXemHD.addActionListener(this);

		txtSoLuongSP.addMouseListener(this);
		btnLamMoiTimKiem.addActionListener(this);

		// do du lieu ======================================================
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

	private void btnThemKHActionPerformed(java.awt.event.ActionEvent evt) {
		gui.chuyenTuBanThuocDenKH(this);
	}

	public void xemChiTiet() {
		if (rowSP == -1) {
			if (rowHD == -1) {
				JOptionPane.showMessageDialog(null, "Mời chọn thuốc cần xem chi tiết!");
				return;
			}
			Thuoc T = listChonThuoc.get(rowHD).getKey();
			new ChiTietThuocJframe(T.getMaThuoc()).setVisible(true);
		} else {
			Set<Entry<Thuoc, Integer>> setThuoc = mapThuoc.entrySet();
			List<Entry<Thuoc, Integer>> listThuoc = new ArrayList<>(setThuoc);
			Thuoc T = listThuoc.get(rowSP).getKey();
			new ChiTietThuocJframe(T.getMaThuoc()).setVisible(true);
		}
	}

	private void tblSPMouseReleased(java.awt.event.MouseEvent evt) {
		popSP = new RightClickPopUp("btdsthuoc", this);
		if (SwingUtilities.isRightMouseButton(evt)) {
			int r = tblSP.rowAtPoint(evt.getPoint());
			if (r >= 0 && r < tblSP.getRowCount()) {
				tblSP.setRowSelectionInterval(r, r);
			} else {
				tblSP.clearSelection();
			}
			int rowselect = tblSP.getSelectedRow();
			if (rowselect < 0)
				return;
			else {
				txtSoLuongDialog.setValue(0);
				popSP.show(evt.getComponent(), evt.getX(), evt.getY());
			}

		}
	}

	private void tblDonHangMouseReleased(java.awt.event.MouseEvent evt) {
		popSP = new RightClickPopUp("bthd", this);
		if (SwingUtilities.isRightMouseButton(evt)) {
			int r = tblDonHang.rowAtPoint(evt.getPoint());
			if (r >= 0 && r < tblDonHang.getRowCount()) {
				tblDonHang.setRowSelectionInterval(r, r);
			} else {
				tblDonHang.clearSelection();
			}
			int rowselect = tblDonHang.getSelectedRow();
			if (rowselect < 0)
				return;
			else {
				popSP.show(evt.getComponent(), evt.getX(), evt.getY());
			}

		}
	}

	public void getTtKhJframe(String ten, String sdt, String dc) {
		txtTenKH.setText(ten);
		txtSDT.setText(sdt);
	}

	public void showDialogThem() {
		jdialogThemThuoc.setVisible(true);
	}

	public void doiVaShowDialog() {
		jdialogThemThuoc.setTitle("Đổi số lượng");
		txtLoaiDialog.setText("Đổi số lượng");
		btnThemDialog.setText("Đổi");
		jdialogThemThuoc.setVisible(true);
	}

	// Ham thuc thi =========================================================
	private void loadJcombo() {
		jcbDangBC.addItem("Tất cả");
		jcbDVT.addItem("Tất cả");

		ArrayList<String> listItemp;
		listItemp = new ArrayList<String>();
		listItemp = dao_BanThuoc.getDVT();
		for (String Itemp : listItemp) {
			jcbDVT.addItem(Itemp);
		}
		listItemp = dao_BanThuoc.getDBC();
		for (String Itemp : listItemp) {
			jcbDangBC.addItem(Itemp);
		}
	}

	private int getIndexListThuoc(String maThuoc, List<String> list) {
		if (list.contains(maThuoc)) {
			return list.indexOf(maThuoc);
		} else
			return -1;
	}

	private boolean dataToTBSP() {
		String cd = "Tất cả";
		String nhomcd = "Tất cả";
		String dangBC = "Tất cả";
		String dvt = "Tất cả";
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
		mapThuoc = dao_BanThuoc.getDSBan(trang, txtTimKiemTen.getText(), txtTimKiemHoatChat.getText(), nhomcd, dangBC,
				dvt, cd);

		countDSThuoc = dao_BanThuoc.getCountThuocTim(txtTimKiemTen.getText(), txtTimKiemHoatChat.getText(), nhomcd,
				dangBC, dvt, cd);
		setThuoc = mapThuoc.entrySet();
		listThuoc = new ArrayList<>(setThuoc);
		if (listThuoc.size() > 0) {

			ktra = true;
			rowSP = -1;
			tblSP.clearSelection();
			txtSoTrang.setText(String.valueOf(trang));
			modelSP.getDataVector().removeAllElements();
			modelSP.fireTableDataChanged();

			List<String> listMa = new ArrayList<String>();
			listChonThuoc.forEach(t -> {
				listMa.add(t.getKey().getMaThuoc());
			});
			new Thread(() -> {
				listThuoc.forEach(entry -> {
					Thuoc thuoc = entry.getKey();

					if (listMa.contains(entry.getKey().getMaThuoc())) {
						int index = listMa.indexOf(entry.getKey().getMaThuoc());
						int SL = listChonThuoc.get(index).getValue();

						modelSP.addRow(new Object[] { thuoc.getTenThuoc(), thuoc.getThanhPhan(), thuoc.getDangBaoChe(),
								thuoc.getDonViTinh(), thuoc.getHamLuong(), thuoc.getCongDung().getNhomCongDung(),
								thuoc.getCongDung().getCongDung(), thuoc.getHanSuDung(), Math.round(thuoc.getGiaBan()),
								entry.getValue() - SL });
					} else {
						modelSP.addRow(new Object[] { thuoc.getTenThuoc(), thuoc.getThanhPhan(), thuoc.getDangBaoChe(),
								thuoc.getDonViTinh(), thuoc.getHamLuong(), thuoc.getCongDung().getNhomCongDung(),
								thuoc.getCongDung().getCongDung(), thuoc.getHanSuDung(), Math.round(thuoc.getGiaBan()),
								entry.getValue() });

					}
				});
			}).start();
		}
		return ktra;
	}

	private void dataToTBHD() {
		modelHD.setRowCount(0);
		modelHD.getDataVector().removeAllElements();
		modelHD.fireTableDataChanged();
		new Thread(() -> {
			listChonThuoc.forEach(entry -> {
				Thuoc thuoc = entry.getKey();
				modelHD.addRow(new Object[] { thuoc.getTenThuoc(), thuoc.getHamLuong(), thuoc.getGiaBan(),
						Math.round(thuoc.getThueVAT() * 100) + "%", entry.getValue(),
						Math.round(entry.getValue() * (thuoc.getGiaBan() * (1 + thuoc.getThueVAT()))) });
			});
			tblDonHang.clearSelection();
		}).start();
	}

	private void chonThuoc(int soLuongSP) {

		tongTien = 0;
		if (rowSP != -1) {
			if (txtSoLuongSP.getText().equals("")) {
				JOptionPane.showInternalMessageDialog(null, "Chưa chọn số lượng thuốc");
			} else {
				if (soLuongSP <= 0) {
					JOptionPane.showInternalMessageDialog(null, "Số lượng thuốc phải > 0");
					txtSoLuongSP.requestFocus();
					txtSoLuongSP.selectAll();
				} else {
					Thuoc T = listThuoc.get(rowSP).getKey();
					if (Integer.parseInt(tblSP.getValueAt(rowSP, 9).toString()) < soLuongSP) {
						JOptionPane.showMessageDialog(null, "Số lượng thuốc trong kho không đủ!");
						return;
					}
					@SuppressWarnings({ "unchecked", "rawtypes" })
					Map.Entry<Thuoc, Integer> et = new MyEntry(T, soLuongSP);
					List<String> listMa = new ArrayList<String>();
					listChonThuoc.forEach(t -> {
						listMa.add(t.getKey().getMaThuoc());
					});
					if (listMa.contains(T.getMaThuoc())) {
						int index = getIndexListThuoc(T.getMaThuoc(), listMa);
						listChonThuoc.get(index).setValue(listChonThuoc.get(index).getValue() + soLuongSP);
					} else {
						listChonThuoc.add(et);
					}
					dataToTBHD();
					dataToTBSP();//
//					tblSP.setValueAt((Integer)tblSP.getValueAt(rowSP, 9) - soLuongSP, rowSP, 9);
					for (int i = 0; i < modelHD.getRowCount(); i++) {
						tongTien += Double.parseDouble(String.valueOf(modelHD.getValueAt(i, 5)));
					}
					txtTongHDThue.setText(String.valueOf(Math.round(tongTien)));
				}
			}
		}
		if (rowHD != -1) {
			if (dao_BanThuoc.getThuocTheoMa(listChonThuoc.get(rowHD).getKey().getMaThuoc()).tongSoLuong() < soLuongSP) {
				JOptionPane.showMessageDialog(null, "Số lượng thuốc trong kho không đủ!");
				return;
			}
			Thuoc T = listChonThuoc.get(rowHD).getKey();
			@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
			Map.Entry<Thuoc, Integer> et = new MyEntry(T, soLuongSP);

			List<String> listMa = new ArrayList<String>();
			listChonThuoc.forEach(t -> {
				listMa.add(t.getKey().getMaThuoc());
			});

			int index = getIndexListThuoc(T.getMaThuoc(), listMa);

			if (soLuongSP == 0) {
				listChonThuoc.remove(index);
			} else {
				listChonThuoc.get(index).setValue(soLuongSP);
			}
			dataToTBHD();
			dataToTBSP();
			xoaTrang();
			for (int i = 0; i < modelHD.getRowCount(); i++) {
				tongTien += Double.parseDouble(String.valueOf(modelHD.getValueAt(i, 5)));
			}
			txtTongHDThue.setText(String.valueOf(Math.round(tongTien)));
		}
		txtTienBangChu.setText(docTien.readMoney(String.valueOf(Math.round(tongTien))));

	}

	private void timKhachHang() {
		KH = new KhachHang();
		KH = dao_KhachHang.get1KhachHang(txtTimSDT.getText());
		if (txtTimSDT.getText().equals("")) {
			txtTimSDT.requestFocus();
			txtTenKH.setText("");
			txtSDT.setText("");
			JOptionPane.showMessageDialog(null, "Chưa nhập số điện thoại khách hàng!");
		} else if (!txtTimSDT.getText().matches(
				"(^(03)[2-9]\\d{7})|(^(07)[06-9]\\d{7})|(^(08)[1-5]\\d{7})|(^(056)\\d{7})|(^(058)\\d{7})|(^(059)\\d{7})|(^(09)[0-46-9]\\d{7})")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ!");
			txtTimSDT.selectAll();
			txtTimSDT.requestFocus();
		} else if (KH != null) {
			txtTenKH.setText(KH.getTenKhachHang());
			txtSDT.setText(KH.getSoDienThoai());
//			String diaChi = KH.getDiaChi().getPhuongXa() + " - " + KH.getDiaChi().getQuanHuyen() + " - "
//					+ KH.getDiaChi().getTinhTP();

		} else {
			txtTimSDT.requestFocus();
			txtTimSDT.selectAll();
			txtTenKH.setText("");
			txtSDT.setText("");
			JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng!");
		}

	}

	private boolean thanhToan() {
		if (txtTenKH.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng!");
			txtTimSDT.requestFocus();
			return false;
		}
		if (modelHD.getRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "<html>Giỏ hàng rỗng!<br>Vui lòng kiểm tra lại</html>");
			return false;
		}
		if (txtTienTra.getText().equals("Nhỏ hơn tổng tiền hóa đơn")) {
			JOptionPane.showMessageDialog(null,
					"<html>Số tiền nhận không đủ thanh toán!<br>Vui lòng kiểm tra lại</html>");
			txtTienTra.selectAll();
			txtTienTra.requestFocus();
			return false;
		}
		try {
			long tienTra = 0;
			tienTra = Long.parseLong(txtTienTra.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập tiền nhận!");
			txtTienTra.selectAll();
			txtTienTra.requestFocus();
			return false;
		}
		// ---------
		KH = dao_KhachHang.get1KhachHang(txtSDT.getText());
		if (dao_HoaDonBan.taoHoaDonBan(maNV, KH.getMaKhachHang())) {
			listChonThuoc.forEach(et -> {
				Thuoc thuoc = et.getKey();
				int soLuong = et.getValue();
				double gia = thuoc.getGiaBan();
				float vat = thuoc.getThueVAT();
				HoaDonBan hd = dao_HoaDonBan.getHoaDonMoiNhat();
				CT_HoaDonBan cthd = new CT_HoaDonBan(soLuong, gia, thuoc, hd, vat);
				if (!dao_CTHoaDon.taoCTHDBAN(cthd)) {
					dao_HoaDonBan.xoaHoaDonLoi(hd.getMaHoaDonBan());
					JOptionPane.showMessageDialog(null, "Lỗi trong quá trình tạo hóa đơn!");
				}
			});

		} else {
			JOptionPane.showMessageDialog(null, "Lỗi trong quá trình tạo hóa đơn!");
			return false;
		}
		if (cbkXuatIn.isSelected())
			xuatFileExcel();
		return true;
	}

	private void xoaTrang() {
		// TODO Auto-generated method stub
		jcbNhomCongDung.setSelectedIndex(0);
		jcbDangBC.setSelectedIndex(0);
		jcbDVT.setSelectedIndex(0);
		txtTimKiemHoatChat.setText("");
		txtTimKiemTen.setText("");
		txtTongHDThue.setText("");
		txtSDT.setText("");
		txtTenKH.setText("");
		txtTimSDT.setText("");
		txtTienNhan.setText("");
		txtTienTra.setText("");
		txtTienBangChu.setText("");
		countDSThuoc = dao_BanThuoc.getCountThuocBan();
		dataToTBSP();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(jcbNhomCongDung)) {
			loadCongDung(jcbNhomCongDung.getSelectedItem().toString());
		}
		if (obj.equals(jcbCongDung) || obj.equals(jcbDangBC) || obj.equals(jcbDVT) || obj.equals(jcbNhomCongDung)) {

			if ((jcbDangBC.getItemCount() > 1) && (jcbDVT.getItemCount() > 1) && (jcbNhomCongDung.getItemCount() > 1)) {
				trang = 1;
				if (!dataToTBSP()) {
					modelSP.getDataVector().removeAllElements();
					modelSP.fireTableDataChanged();
				}
				txtSoTrang.setText(String.valueOf(trang));
			}
		} else if (obj.equals(btnSkipPrevius)) {
			if (trang > 1) {
				trang = 1;
				dataToTBSP();
			}
		} else if (obj.equals(btnNextPrevius)) {
			if (trang > 1) {
				trang -= 1;
				dataToTBSP();
			}
		} else if (obj.equals(btnNextForward)) {
			flag = (float) countDSThuoc / 20;
			if (trang < (int) Math.ceil(flag)) {
				trang += 1;
				if (!dataToTBSP())
					trang--;
			}
		} else if (obj.equals(btnSkipForward)) {
			flag = (float) countDSThuoc / 20;
			if (trang < (int) Math.ceil(flag)) {
				trang = (int) Math.ceil(flag);
				dataToTBSP();
			}
		} else if (obj.equals(btnThem)) {
			if (rowSP == -1) {
				JOptionPane.showMessageDialog(null, "Mời chọn thuốc cần thêm");
			} else {
				try {
					int soLuongSP = Integer.parseInt(txtSoLuongSP.getText());
					if (soLuongSP <= 0) {
						JOptionPane.showMessageDialog(null, "Số lượng thuốc mua phải lớn hơn 0!");
						txtSoLuongSP.setText("0");
						txtSoLuongSP.selectAll();
						txtSoLuongSP.requestFocus();
						return;
					}
					chonThuoc(soLuongSP);
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showInternalMessageDialog(null, "SỐ lượng thuốc chỉ được nhập số");
					txtSoLuongSP.requestFocus();
					txtSoLuongSP.selectAll();
					return;
				}
			}
			txtSoLuongSP.setText("0");
			tblSP.clearSelection();
		} else if (obj.equals(btnTim)) {
			timKhachHang();
		} else if (obj.equals(btnHuyHD)) {
			if (JOptionPane.showConfirmDialog(null, "Xác nhận hủy đơn thuốc", "",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				for (int i = 0; i < modelHD.getRowCount(); i++) {
					modelHD.removeRow(i);
				}
				txtTongHDThue.setText("");
				txtTienNhan.setText("");
				txtTienTra.setText("");

				txtTenKH.setText("");
				txtSDT.setText("");
				txtTimSDT.setText("");
				// ----
				listChonThuoc = new ArrayList<>();
				countDSThuoc = dao_BanThuoc.getCountThuocBan();
				trang = 1;
				dataToTBSP();
			}
		} else if (obj.equals(btnThemDialog)) {
			int soLuongSP = Integer.parseInt(txtSoLuongDialog.getValue().toString());
			chonThuoc(soLuongSP);
			jdialogThemThuoc.dispose();
		}

		else if (obj.equals(btnThanhToan)) {
			maNV = gui.getMaNV();
			if (thanhToan()) {
				JOptionPane.showMessageDialog(null, "Thanh toán thành công!");
				listChonThuoc = new ArrayList<>();
				dataToTBHD();
				xoaTrang();
			}
		}

		else if (obj.equals(btnChiTiet)) {
			if (rowSP != -1) {
				new ChiTietThuocJframe(listThuoc.get(rowSP).getKey().getMaThuoc()).setVisible(true);
			} else {
				if (rowHD != -1) {
					new ChiTietThuocJframe(listChonThuoc.get(rowHD).getKey().getMaThuoc()).setVisible(true);
				} else
					JOptionPane.showMessageDialog(null, "Mời chọn thuốc cần xem chi tiết!");
			}
		} else if (obj.equals(btnXemHD)) {
			maNV = gui.getMaNV();
			if (thanhToan()) {
				new ChitietHoadonBanJframe(dao_HoaDonBan.getMaHoaDonMoiNhat()).setVisible(true);
				dao_HoaDonBan.xoaHoaDonLoi(dao_HoaDonBan.getMaHoaDonMoiNhat());
			}
		} else if (obj.equals(btnLamMoiTimKiem)) {
			jcbNhomCongDung.setSelectedIndex(0);
			jcbDangBC.setSelectedIndex(0);
			jcbDVT.setSelectedIndex(0);
			txtTimKiemHoatChat.setText("");
			txtTimKiemTen.setText("");
			countDSThuoc = dao_BanThuoc.getCountThuocBan();
			dataToTBSP();
		}
	}

	public void traLaiThuoc() {
		Thuoc T = listChonThuoc.get(rowHD).getKey();
		List<String> listMa = new ArrayList<String>();
		listChonThuoc.forEach(t -> {
			listMa.add(t.getKey().getMaThuoc());
		});
		int index = getIndexListThuoc(T.getMaThuoc(), listMa);
		listChonThuoc.remove(index);
		dataToTBHD();
		dataToTBSP();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		Object obj = e.getSource();
		if (e.getKeyCode() == KeyEvent.VK_ENTER && obj.equals(txtTimSDT)) {
			timKhachHang();
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER && obj.equals(txtSoLuongSP)) {
			if (rowSP == -1) {
				JOptionPane.showMessageDialog(null, "Chưa chọn thuốc");
			} else {
				try {
					int soLuongSP = Integer.parseInt(txtSoLuongSP.getText());
					chonThuoc(soLuongSP);
				} catch (Exception ex) {
					JOptionPane.showInternalMessageDialog(null, "Chỉ được nhập số");
					txtSoLuongSP.requestFocus();
					txtSoLuongSP.selectAll();
				}
			}
			tblSP.clearSelection();
			txtSoLuongSP.setText("0");
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER && obj.equals(txtSoLuongDialog)) {
			if (Integer.parseInt(txtSoLuongDialog.getValue().toString()) <= 0) {
				JOptionPane.showMessageDialog(null, "Số lượng thuốc phải lớn hơn 0");
			} else {
				int soLuongSP = Integer.parseInt(txtSoLuongDialog.getValue().toString());
				chonThuoc(soLuongSP);
				jdialogThemThuoc.dispose();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(txtTienNhan)) {
			if (txtTienNhan.getText().equals("")) {
				txtTienTra.setText("");
			}
			try {
				double tienNhan = Double.parseDouble(txtTienNhan.getText());
				if (tienNhan < tongTien) {
					txtTienTra.setText("Nhỏ hơn tổng tiền hóa đơn");
				} else {
					double tienTra = tienNhan - tongTien;
					txtTienTra.setText(String.valueOf(Math.round(tienTra)));
				}
			} catch (Exception e2) {
			}
		} else if (e.getSource().equals(txtTimKiemTen) || e.getSource().equals(txtTimKiemHoatChat)) {
			trang = 1;
			if (!dataToTBSP()) {
				modelSP.getDataVector().removeAllElements();
				modelSP.fireTableDataChanged();
			}
			txtSoTrang.setText(String.valueOf(trang));
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

	private void loadCongDung(String loaiCongDung) {
		if (loaiCongDung.equals("") || loaiCongDung.equalsIgnoreCase("Tất cả")) {
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

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(txtSoLuongSP)) {
			txtSoLuongSP.selectAll();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Object obj = e.getSource();
		if (obj.equals(tblSP)) {
			rowSP = tblSP.getSelectedRow();
			tblDonHang.clearSelection();
			rowHD = -1;
			jdialogThemThuoc.setTitle("Thêm thuốc");
			txtLoaiDialog.setText("Thêm thuốc vào giỏ");
			btnThemDialog.setText("Thêm vào giỏ");
			// -----
			txtSoLuongDialog.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
			return;
		}
		if (obj.equals(tblDonHang)) {
			rowHD = tblDonHang.getSelectedRow();
			tblSP.clearSelection();
			rowSP = -1;
			jdialogThemThuoc.setTitle("Sửa số lượng thuốc");
			txtLoaiDialog.setText("Sửa số lượng thuốc");
			int flag = listChonThuoc.get(rowHD).getValue();
			txtSoLuongDialog.setModel(new javax.swing.SpinnerNumberModel(flag, 0, null, 1));
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	private void xuatFileExcel() {
		JFileChooser fChooser = new JFileChooser();

		fChooser.addChoosableFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return "Excell file (*.xls, *xlsx)";
			}

			@Override
			public boolean accept(File f) {
				// TODO Auto-generated method stub
				if (f.isDirectory()) {
					return true;
				} else {
					return f.getName().toLowerCase().endsWith(".xls") || f.getName().toLowerCase().endsWith(".xlsx");
				}
			}

		});

		int i = fChooser.showSaveDialog(this);
		if (i == 0) {
			String path = fChooser.getSelectedFile().getAbsolutePath();
			if (!path.matches("(.)+(\\.xls|\\.xlsx)$")) {
				path += ".xlsx";
			}
			boolean t = ghiFileExcel(path);

			if (t)
				JOptionPane.showMessageDialog(null, "Xuất file thành công");
			else
				JOptionPane.showMessageDialog(null, "Xuất file không thành công");
		}
	}

	public boolean ghiFileExcel(String path) {
		Workbook workBook = new XSSFWorkbook();

		Sheet sh = workBook.createSheet("Sheet1");
		String header[] = { "Mã hóa đơn", "Ngày lập", "Tên nhân viên", "Tên khách hàng", "STT", "Tên thuốc", "Giá tiền",
				"Số lượng", "Tổng tiền" };

		Row rowHeader = sh.createRow(0);
		for (int i = 0; i < header.length; i++) {
			Cell cell = rowHeader.createCell(i);
			cell.setCellValue(header[i]);
		}

		int numRow = 1;
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Row row = sh.createRow(numRow++);
		Entry<Thuoc, Integer> ct1 = listChonThuoc.get(0);
		row.createCell(0).setCellValue(dao_HoaDonBan.getMaHoaDonMoiNhat());
		row.createCell(1).setCellValue(df.format(new Date()));
		row.createCell(2).setCellValue(daoNhanVien.getByMa(maNV).getTenNV());
		row.createCell(3).setCellValue(txtTenKH.getText());
		row.createCell(4).setCellValue(1);
		row.createCell(5).setCellValue(ct1.getKey().getTenThuoc());
		row.createCell(6).setCellValue(ct1.getKey().getGiaBan());
		row.createCell(7).setCellValue(ct1.getValue());
		row.createCell(8).setCellValue(ct1.getValue() * ct1.getKey().getGiaBan());
		int stt = 1;
		for (int i = 1; i < listChonThuoc.size(); i ++) {
			Entry<Thuoc, Integer> ct = listChonThuoc.get(i);
			row = sh.createRow(numRow++);
			stt++;
			row.createCell(4).setCellValue(stt);
			row.createCell(5).setCellValue(ct.getKey().getTenThuoc());
			row.createCell(6).setCellValue(ct.getKey().getGiaBan());
			row.createCell(7).setCellValue(ct.getValue());
			row.createCell(8).setCellValue(ct.getValue() * ct.getKey().getGiaBan());
		}

		for (int i = 0; i < header.length; i++)
			sh.autoSizeColumn(i);

		try {
			FileOutputStream f = new FileOutputStream(path);
			workBook.write(f);
			f.close();
			workBook.close();
		} catch (Exception e) {
			return false;
		}
		return true;

	}

	private javax.swing.JButton btnChiTiet;
	private javax.swing.JButton btnHuyHD;
	private javax.swing.JButton btnLamMoiTimKiem;
	private javax.swing.JButton btnNextForward;
	private javax.swing.JButton btnNextPrevius;
	private javax.swing.JButton btnSkipForward;
	private javax.swing.JButton btnSkipPrevius;
	private javax.swing.JButton btnThanhToan;
	private javax.swing.JButton btnThem;
	private javax.swing.JButton btnThemDialog;
	private javax.swing.JButton btnThemKH;
	private javax.swing.JButton btnTim;
	private javax.swing.JButton btnXemHD;
	private javax.swing.JCheckBox cbkXuatIn;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel18;
	private javax.swing.JLabel jLabel2;
//	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel10;
	private javax.swing.JPanel jPanel11;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JPanel jPanel7;
	private javax.swing.JPanel jPanel8;
	private javax.swing.JPanel jPanel9;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JSeparator jSeparator5;
	private javax.swing.JSeparator jSeparator6;
	private javax.swing.JComboBox<String> jcbCongDung;
	private javax.swing.JComboBox<String> jcbDVT;
	private javax.swing.JComboBox<String> jcbDangBC;
	private javax.swing.JComboBox<String> jcbNhomCongDung;
	private javax.swing.JDialog jdialogThemThuoc;
	private javax.swing.JLabel lblDC;
	private javax.swing.JLabel lblTenKH;
	private javax.swing.JLabel lblTienNhan;
	private javax.swing.JLabel lblTienNhan2;
	private javax.swing.JLabel lblTienNhan4;
	private javax.swing.JPanel pnBody;
	private javax.swing.JPanel pnChonSp;
	private javax.swing.JPanel pnHeader1;
	private javax.swing.JPanel pnKH;
	private javax.swing.JPanel pnTimKiemNangCao2;
	private javax.swing.JTable tblDonHang;
	private javax.swing.JTable tblSP;
	private javax.swing.JLabel txtLoaiDialog;
	private javax.swing.JTextField txtSDT;
	private javax.swing.JSpinner txtSoLuongDialog;
	private javax.swing.JTextField txtSoLuongSP;
	private javax.swing.JTextField txtSoTrang;
	private javax.swing.JTextField txtTenKH;
	private javax.swing.JLabel txtTenThuocDialog;
	private javax.swing.JLabel txtTienBangChu;
	private javax.swing.JTextField txtTienNhan;
	private javax.swing.JTextField txtTienTra;
	private javax.swing.JTextField txtTimKiemHoatChat;
	private javax.swing.JTextField txtTimKiemTen;
	private javax.swing.JTextField txtTimSDT;
	private javax.swing.JTextField txtTongHDThue;
	private javax.swing.JPanel jPanel12;
	private javax.swing.JLabel jLabel3;
	private KhachHang KH;
	private int rowSP = -1;
	// End of variables declaration//GEN-END:variables
}
