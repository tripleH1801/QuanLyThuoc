package view;

import bean.DanhMucBean;
import connect.Connect;
import controller.ChuyenManHinh;
import controller.ClassGetImg;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author Ryzen-Luci
 */
public class gui_Chinh extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	private BanThuocJPanel banThuocPanel;
	private QuanLyKhachHangPanel quanLyKhachHangPanel;
	private CardLayout cardLayout;
	private String maNV;

	// ----test
	private JButton btnF1 = new JButton();
	private JButton btnF2 = new JButton();
	private JButton btnF3 = new JButton();
	private JButton btnF4 = new JButton();
	private JButton btnF5 = new JButton();
	private JButton btnF6 = new JButton();

	private QuanLyTaiKhoan taiKhoan;

	// -------

	public gui_Chinh(String ten, String ma, boolean loaiNV) {
		try {
			Connect.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initComponents();
		ChuyenManHinh controller = new ChuyenManHinh(pnView, this);
		controller.setView(pnMnBanThuoc, lblMnBanThuoc);
		List<DanhMucBean> listbean = new ArrayList<>();
		listbean.add(new DanhMucBean("banthuoc", pnMnBanThuoc, lblMnBanThuoc));
		listbean.add(new DanhMucBean("quanlythuoc", pnMnQLThuoc, lblMnQLThuoc));
		listbean.add(new DanhMucBean("quanlykhachhang", pnMnQLKH, lblMnQLKH));
		listbean.add(new DanhMucBean("quanlyhoadon", pnMnQLHD, lblMnQLHD));
		listbean.add(new DanhMucBean("quanlytk", pnMnQuanLyTaiKhoan, txtTenNV));
		listbean.add(new DanhMucBean("quanlytk", pnMnQuanLyTaiKhoan, lblMnTK1));
		listbean.add(new DanhMucBean("quanlynv", pnMnNhanVien, lblQlNV));
		if (loaiNV) {
			listbean.add(new DanhMucBean("thongkequanly", pnMnThongKe, lblMnTK));
		}
		else {
			listbean.add(new DanhMucBean("thongke", pnMnThongKe, lblMnTK));
		}
		
		controller.setEvent(listbean);
		this.setExtendedState(MAXIMIZED_BOTH);

		banThuocPanel = new BanThuocJPanel(this, ten, ma);
		txtTenNV.setText(ten);
		pnMnNhanVien.setVisible(loaiNV);
		taiKhoan = new QuanLyTaiKhoan();
		this.maNV = ma;
		ClassGetImg getimg = new ClassGetImg();
		lblHeader.setText("");
		getimg.setImgChiTiet(lblHeader, "/img/brand1");
		taoNutChucNang();
	}

	public gui_Chinh() {
		initComponents();

	}

	private void initComponents() {

        pnRoot = new javax.swing.JPanel();
        pnHeader = new javax.swing.JPanel();
        lblHeader = new javax.swing.JLabel();
        pnMenu = new javax.swing.JPanel();
        pnMnBanThuoc = new javax.swing.JPanel();
        lblMnBanThuoc = new javax.swing.JLabel();
        pnMnQLThuoc = new javax.swing.JPanel();
        lblMnQLThuoc = new javax.swing.JLabel();
        pnMnQLKH = new javax.swing.JPanel();
        lblMnQLKH = new javax.swing.JLabel();
        pnMnQLHD = new javax.swing.JPanel();
        lblMnQLHD = new javax.swing.JLabel();
        pnMnThongKe = new javax.swing.JPanel();
        lblMnTK = new javax.swing.JLabel();
        pnMnQuanLyTaiKhoan = new javax.swing.JPanel();
        lblMnTK1 = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JLabel();
        pnMnDangXuat = new javax.swing.JPanel();
        lblMnDangXuat = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JLabel();
        pnMnNhanVien = new javax.swing.JPanel();
        lblQlNV = new javax.swing.JLabel();
        pnView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DramaCity");
        setMinimumSize(new java.awt.Dimension(1234, 725));

        pnRoot.setBackground(new java.awt.Color(255, 153, 153));

        pnHeader.setBackground(new java.awt.Color(29, 53, 87));

        lblHeader.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblHeader.setForeground(new java.awt.Color(255, 255, 255));
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("DramaCity");
        lblHeader.setToolTipText("");

        javax.swing.GroupLayout pnHeaderLayout = new javax.swing.GroupLayout(pnHeader);
        pnHeader.setLayout(pnHeaderLayout);
        pnHeaderLayout.setHorizontalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnHeaderLayout.setVerticalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnMenu.setBackground(new java.awt.Color(29, 53, 87));
        pnMenu.setPreferredSize(new java.awt.Dimension(260, 550));
        pnMenu.setRequestFocusEnabled(false);

        pnMnBanThuoc.setBackground(new java.awt.Color(29, 53, 87));

        lblMnBanThuoc.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblMnBanThuoc.setForeground(new java.awt.Color(255, 255, 255));
        lblMnBanThuoc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMnBanThuoc.setText("Cửa hàng");
        lblMnBanThuoc.setToolTipText("Cửa hàng");

        javax.swing.GroupLayout pnMnBanThuocLayout = new javax.swing.GroupLayout(pnMnBanThuoc);
        pnMnBanThuoc.setLayout(pnMnBanThuocLayout);
        pnMnBanThuocLayout.setHorizontalGroup(
            pnMnBanThuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMnBanThuocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMnBanThuoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnMnBanThuocLayout.setVerticalGroup(
            pnMnBanThuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMnBanThuocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMnBanThuoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnMnQLThuoc.setBackground(new java.awt.Color(29, 53, 87));

        lblMnQLThuoc.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblMnQLThuoc.setForeground(new java.awt.Color(255, 255, 255));
        lblMnQLThuoc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMnQLThuoc.setText("Thuốc");
        lblMnQLThuoc.setToolTipText("Quản lý thuốc");

        javax.swing.GroupLayout pnMnQLThuocLayout = new javax.swing.GroupLayout(pnMnQLThuoc);
        pnMnQLThuoc.setLayout(pnMnQLThuocLayout);
        pnMnQLThuocLayout.setHorizontalGroup(
            pnMnQLThuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMnQLThuocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMnQLThuoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnMnQLThuocLayout.setVerticalGroup(
            pnMnQLThuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMnQLThuocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMnQLThuoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnMnQLKH.setBackground(new java.awt.Color(29, 53, 87));

        lblMnQLKH.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblMnQLKH.setForeground(new java.awt.Color(255, 255, 255));
        lblMnQLKH.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMnQLKH.setText("Khách Hàng");
        lblMnQLKH.setToolTipText("Quản lý khách hàng");

        javax.swing.GroupLayout pnMnQLKHLayout = new javax.swing.GroupLayout(pnMnQLKH);
        pnMnQLKH.setLayout(pnMnQLKHLayout);
        pnMnQLKHLayout.setHorizontalGroup(
            pnMnQLKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMnQLKHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMnQLKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnMnQLKHLayout.setVerticalGroup(
            pnMnQLKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMnQLKHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMnQLKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnMnQLHD.setBackground(new java.awt.Color(29, 53, 87));

        lblMnQLHD.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblMnQLHD.setForeground(new java.awt.Color(255, 255, 255));
        lblMnQLHD.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMnQLHD.setText("Hóa Đơn");
        lblMnQLHD.setToolTipText("Quản lý hóa đơn nhập và bán");

        javax.swing.GroupLayout pnMnQLHDLayout = new javax.swing.GroupLayout(pnMnQLHD);
        pnMnQLHD.setLayout(pnMnQLHDLayout);
        pnMnQLHDLayout.setHorizontalGroup(
            pnMnQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMnQLHDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMnQLHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnMnQLHDLayout.setVerticalGroup(
            pnMnQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMnQLHDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMnQLHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnMnThongKe.setBackground(new java.awt.Color(29, 53, 87));

        lblMnTK.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblMnTK.setForeground(new java.awt.Color(255, 255, 255));
        lblMnTK.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMnTK.setText("Thống Kê");
        lblMnTK.setToolTipText("Thống kê");

        javax.swing.GroupLayout pnMnThongKeLayout = new javax.swing.GroupLayout(pnMnThongKe);
        pnMnThongKe.setLayout(pnMnThongKeLayout);
        pnMnThongKeLayout.setHorizontalGroup(
            pnMnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMnThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMnTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnMnThongKeLayout.setVerticalGroup(
            pnMnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMnThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMnTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnMnQuanLyTaiKhoan.setBackground(new java.awt.Color(29, 53, 87));

        lblMnTK1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblMnTK1.setForeground(new java.awt.Color(255, 255, 255));
        lblMnTK1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMnTK1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/baseline_person_white_24dp.png"))); // NOI18N

        txtTenNV.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtTenNV.setForeground(new java.awt.Color(255, 255, 255));
        txtTenNV.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtTenNV.setText("Ha Huy Hoang");
        txtTenNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtTenNVMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout pnMnQuanLyTaiKhoanLayout = new javax.swing.GroupLayout(pnMnQuanLyTaiKhoan);
        pnMnQuanLyTaiKhoan.setLayout(pnMnQuanLyTaiKhoanLayout);
        pnMnQuanLyTaiKhoanLayout.setHorizontalGroup(
            pnMnQuanLyTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMnQuanLyTaiKhoanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMnTK1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnMnQuanLyTaiKhoanLayout.setVerticalGroup(
            pnMnQuanLyTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMnTK1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtTenNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        pnMnDangXuat.setBackground(new java.awt.Color(255, 51, 51));

        lblMnDangXuat.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblMnDangXuat.setForeground(new java.awt.Color(255, 255, 255));
        lblMnDangXuat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMnDangXuat.setText("  Đăng xuất");
        lblMnDangXuat.setToolTipText("Đăng xuất tài khoản");
        lblMnDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMnDangXuatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMnDangXuatMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblMnDangXuatMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblMnDangXuatMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout pnMnDangXuatLayout = new javax.swing.GroupLayout(pnMnDangXuat);
        pnMnDangXuat.setLayout(pnMnDangXuatLayout);
        pnMnDangXuatLayout.setHorizontalGroup(
            pnMnDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMnDangXuat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnMnDangXuatLayout.setVerticalGroup(
            pnMnDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMnDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        txtMaNV.setBackground(new java.awt.Color(29, 53, 87));
        txtMaNV.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        txtMaNV.setForeground(new java.awt.Color(29, 53, 87));
        txtMaNV.setText("1801");

        pnMnNhanVien.setBackground(new java.awt.Color(29, 53, 87));

        lblQlNV.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblQlNV.setForeground(new java.awt.Color(255, 255, 255));
        lblQlNV.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblQlNV.setText("Nhân viên");
        lblQlNV.setToolTipText("Nhập thêm thuốc");

        javax.swing.GroupLayout pnMnNhanVienLayout = new javax.swing.GroupLayout(pnMnNhanVien);
        pnMnNhanVien.setLayout(pnMnNhanVienLayout);
        pnMnNhanVienLayout.setHorizontalGroup(
            pnMnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMnNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblQlNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnMnNhanVienLayout.setVerticalGroup(
            pnMnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMnNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblQlNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnMenuLayout = new javax.swing.GroupLayout(pnMenu);
        pnMenu.setLayout(pnMenuLayout);
        pnMenuLayout.setHorizontalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMnQuanLyTaiKhoan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnMnDangXuat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnMnThongKe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnMnQLHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnMnQLKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnMnQLThuoc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnMnBanThuoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnMnNhanVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnMenuLayout.setVerticalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addComponent(pnMnBanThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnMnQLThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnMnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnMnQLKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnMnQLHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnMnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                .addComponent(txtMaNV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnMnQuanLyTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnMnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnView.setBackground(new java.awt.Color(255, 255, 255));
        pnView.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout pnRootLayout = new javax.swing.GroupLayout(pnRoot);
        pnRoot.setLayout(pnRootLayout);
        pnRootLayout.setHorizontalGroup(
            pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRootLayout.createSequentialGroup()
                .addGroup(pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(pnHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(pnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnRootLayout.setVerticalGroup(
            pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRootLayout.createSequentialGroup()
                .addComponent(pnHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE))
            .addComponent(pnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        this.cardLayout = (CardLayout) pnView.getLayout();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnRoot, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();

	}

	private void lblMnDangXuatMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblMnDangXuatMouseEntered
		pnMnDangXuat.setBackground(new Color(224, 51, 51));
	}

	private void lblMnDangXuatMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblMnDangXuatMouseExited
		pnMnDangXuat.setBackground(new Color(255, 51, 51));
	}

	private void lblMnDangXuatMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblMnDangXuatMousePressed
		pnMnDangXuat.setBackground(new Color(200, 51, 51));
		int c = JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất?", "Thông báo", JOptionPane.YES_NO_OPTION);
		if (c == JOptionPane.YES_OPTION) {
			this.setVisible(false);
			new start_DangNhapJframe().setVisible(true);
		}
	}

	private void lblMnDangXuatMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblMnDangXuatMouseReleased
		pnMnDangXuat.setBackground(new Color(224, 51, 51));
	}

	private void txtTenNVMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_txtTenNVMouseEntered
		txtTenNV.setToolTipText("Nhân viên: " + txtTenNV.getText());
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
			java.util.logging.Logger.getLogger(gui_Chinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(gui_Chinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(gui_Chinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(gui_Chinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new gui_Chinh().setVisible(true);

			}
		});

	}

	public void chuyenTuBanThuocDenKH(BanThuocJPanel bt) {
		cardLayout = (CardLayout) pnView.getLayout();
		// test
		if (pnView.getComponentCount() == 1) {
			quanLyKhachHangPanel = new QuanLyKhachHangPanel(this, true, banThuocPanel);
		}
		pnView.add(quanLyKhachHangPanel, "quanlykhachhang");
		cardLayout.show(pnView, "quanlykhachhang");
	}

	public void chuyenTuKhachHangDenBanThuoc(String ten, String sdt, String dc) {
		cardLayout = (CardLayout) pnView.getLayout();
		cardLayout.show(pnView, "banthuoc");
		if (banThuocPanel.isVisible() == true) {
			banThuocPanel = (BanThuocJPanel) pnView.getComponent(0);
			banThuocPanel.getTtKhJframe(ten, sdt, dc);
			
		}
	}

	private void taoNutChucNang() {
		this.add(btnF1);
		Action f1Action = new AbstractAction("") {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Chua cap nhat chuc nang nut F1");
			}
		};
		String key1 = "help";
		btnF1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), key1);
		btnF1.getActionMap().put(key1, f1Action);

		this.add(btnF2);
		Action f2Action = new AbstractAction("") {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Chua cap nhat chuc nang nut F2");
			}
		};
		String key2 = "help";
		btnF2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), key2);
		btnF2.getActionMap().put(key2, f2Action);

		this.add(btnF3);
		Action f3Action = new AbstractAction("") {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Chua cap nhat chuc nang nut F3");
			}
		};
		String key3 = "help";
		btnF3.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0), key3);
		btnF3.getActionMap().put(key3, f3Action);
	}

	// =====================
	public String getMaNV() {
		return maNV;
	}

	private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblMnBanThuoc;
    private javax.swing.JLabel lblMnDangXuat;
    private javax.swing.JLabel lblMnQLHD;
    private javax.swing.JLabel lblMnQLKH;
    private javax.swing.JLabel lblMnQLThuoc;
    private javax.swing.JLabel lblMnTK;
    private javax.swing.JLabel lblMnTK1;
    private javax.swing.JLabel lblQlNV;
    private javax.swing.JPanel pnHeader;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JPanel pnMnBanThuoc;
    private javax.swing.JPanel pnMnDangXuat;
    private javax.swing.JPanel pnMnNhanVien;
    private javax.swing.JPanel pnMnQLHD;
    private javax.swing.JPanel pnMnQLKH;
    private javax.swing.JPanel pnMnQLThuoc;
    private javax.swing.JPanel pnMnQuanLyTaiKhoan;
    private javax.swing.JPanel pnMnThongKe;
    private javax.swing.JPanel pnRoot;
    private javax.swing.JPanel pnView;
    private javax.swing.JLabel txtMaNV;
    private javax.swing.JLabel txtTenNV;
}
