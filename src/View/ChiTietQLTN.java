package View;

import java.awt.Color;
import javax.swing.JFrame;
import Models.Lop;
import Models.SinhVien;
import Models.TrucNhat;
import java.util.ArrayList;
import View.TrangChu;
import Controller.MultiLineTableCellRenderer;
import Controller.TableChiTiet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import View.ChiTietQLTN;
import Controller.TableTrangChu;

import Models.FileTXT.ReadWriteList;
import View.DangNhap;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ChiTietQLTN extends javax.swing.JFrame {

    ArrayList<Lop> listLop = new ArrayList<>();
    ReadWriteList fileListLop = new ReadWriteList();
    ReadWriteList fileListTrucNhat=new ReadWriteList();
    String data_listLop = "CSDL_txt\\data_listLop.txt";
 String data_listTrucNhat = "CSDL_txt\\data_listTrucNhat.txt";
 ArrayList<ArrayList<TrucNhat>> allListTrucNhat=new ArrayList<>();
    
    ArrayList<TrucNhat> listtrucnhat=new ArrayList<>();
    
   
    TableChiTiet model;
    //hàm này lấy listLop từ txt, m làm hàm ghi tất cả trực nhật vào txt rồi sang trang sinh viên đọc txt là xong
    // nhớ implemt
    void readListLop() {
        try {
            this.listLop = fileListLop.ReadObject(data_listLop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        void readListTrucNhat() {
            
        try {
            this.allListTrucNhat = fileListTrucNhat.ReadObject(data_listTrucNhat);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
         public void writeListTrucNhat(){
            
        try {
            fileListTrucNhat.WriteObject(data_listTrucNhat, allListTrucNhat);
          
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(ChiTietQLTN.this, "Lỗi ghi truc nhat!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    
  

    public ChiTietQLTN() {

    }

    public ChiTietQLTN(String classID, int selectedRow, TrangChu This) {
        initComponents();
       
        readListLop();
        readListTrucNhat() ;
          listtrucnhat=ganlist(classID);
        displaytable(classID, selectedRow);
        btnChia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy hàng được chọn

                if (listtrucnhat.isEmpty()) {
                    chiatrucnhat(classID);
                      writeListTrucNhat();
                    displaytable(classID, selectedRow);
                } else {
                    JOptionPane.showMessageDialog(ChiTietQLTN.this, "Bạn đã chia trực nhật");
                }

            }
        });
        
        xoa(classID);
        SuaChiTiet(classID, selectedRow);
        Sua();
        clickback();
    }
    //chia se du lieu

    public ArrayList ganlist(String classID) {
     for(ArrayList<TrucNhat> tn :allListTrucNhat){
         if(tn.get(0).getLop().getMaLop().equals(classID)){
             return tn;
         }
     }
     return new ArrayList<TrucNhat>();
    }

    public Lop findClassByID(String classID) {
        // Tìm kiếm lớp trong danh sách dựa trên mã lớp
        for (Lop classInfo : listLop) {
            if (classInfo.getMaLop().equals(classID)) {
                return classInfo;
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnTimKiem = new javax.swing.JButton();
        txtNgay = new javax.swing.JTextField();
        Reload = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        txtMaLop = new javax.swing.JLabel();
        labelMaLop = new javax.swing.JTextField();
        labelTenLop = new javax.swing.JTextField();
        txtTenLop = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableChiTiet = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnTrangChu = new javax.swing.JButton();
        LaBel_QLTN = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnDangXuat = new javax.swing.JButton();
        xuatFile = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnXoa = new javax.swing.JButton();
        btntrove = new javax.swing.JButton();
        suachitiet = new javax.swing.JButton();
        btnChia = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trang Chi Tiết QLTN");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnTimKiem.setBackground(new java.awt.Color(255, 204, 0));
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        txtNgay.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNgay.setToolTipText("");
        txtNgay.setActionCommand("<Not Set>");
        txtNgay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0), 2));
        txtNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayActionPerformed(evt);
            }
        });

        Reload.setBackground(new java.awt.Color(255, 255, 204));
        Reload.setText("Reload");
        Reload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReloadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Reload)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgay, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Reload, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 51)));

        txtMaLop.setBackground(new java.awt.Color(255, 255, 255));

        labelMaLop.setEditable(false);
        labelMaLop.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelMaLop.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        labelMaLop.setText("Mã lớp");
        labelMaLop.setAutoscrolls(false);
        labelMaLop.setBorder(null);
        labelMaLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labelMaLopActionPerformed(evt);
            }
        });

        labelTenLop.setEditable(false);
        labelTenLop.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelTenLop.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        labelTenLop.setText("Tên lớp");
        labelTenLop.setBorder(null);
        labelTenLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labelTenLopActionPerformed(evt);
            }
        });

        txtTenLop.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelMaLop)
                    .addComponent(labelTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaLop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(txtTenLop, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelMaLop, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(txtMaLop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        labelMaLop.getAccessibleContext().setAccessibleName("");

        tableChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableChiTiet.setGridColor(new java.awt.Color(0, 153, 102));
        tableChiTiet.setRowHeight(150);
        tableChiTiet.setSelectionBackground(new java.awt.Color(0, 51, 153));
        jScrollPane1.setViewportView(tableChiTiet);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 102, 51));

        btnTrangChu.setBackground(new java.awt.Color(0, 102, 51));
        javax.swing.ImageIcon originalIcon  = new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/logo-haui.png"));
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        btnTrangChu.setIcon(resizedIcon);
        btnTrangChu.setBorder(null);
        btnTrangChu.setFocusable(false);
        btnTrangChu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTrangChu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTrangChu.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnTrangChu.setMaximumSize(new java.awt.Dimension(40, 40));
        btnTrangChu.setMinimumSize(new java.awt.Dimension(40, 40));
        btnTrangChu.setRolloverEnabled(false);
        btnTrangChu.setVerifyInputWhenFocusTarget(false);


        LaBel_QLTN.setBackground(new java.awt.Color(0, 135, 102));
        LaBel_QLTN.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        LaBel_QLTN.setForeground(new java.awt.Color(255, 255, 255));
        LaBel_QLTN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LaBel_QLTN.setText("Quản lý trực nhật sinh viên HAUI");
        LaBel_QLTN.setToolTipText("");
        LaBel_QLTN.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LaBel_QLTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(LaBel_QLTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        btnDangXuat.setBackground(new java.awt.Color(0, 153, 255));
        btnDangXuat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDangXuat.setForeground(new java.awt.Color(255, 255, 255));
        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.setToolTipText("");
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        xuatFile.setBackground(new java.awt.Color(0, 102, 0));
        xuatFile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        xuatFile.setForeground(new java.awt.Color(255, 255, 255));
        xuatFile.setText("Xuất File");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(xuatFile)
                .addGap(40, 40, 40)
                .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xuatFile, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(btnDangXuat)))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        btnXoa.setBackground(new java.awt.Color(204, 0, 0));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa");
        btnXoa.setToolTipText("");

        btntrove.setBackground(new java.awt.Color(255, 204, 0));
        btntrove.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btntrove.setForeground(new java.awt.Color(255, 255, 255));
        btntrove.setText("Trở về");
        
        suachitiet.setBackground(new java.awt.Color(0, 102, 0));
        suachitiet.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        suachitiet.setForeground(new java.awt.Color(255, 255, 255));
        suachitiet.setText("Sửa chi tiết");
    

        btnChia.setBackground(new java.awt.Color(0, 102, 0));
        btnChia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnChia.setForeground(new java.awt.Color(255, 255, 255));
        btnChia.setText("Chia trực nhật");

        btnSua.setBackground(new java.awt.Color(0, 102, 0));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(suachitiet, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnChia)
                .addGap(18, 18, 18)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btntrove, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addComponent(btntrove, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                    .addComponent(btnChia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(suachitiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public void displaytable(String classID, int selectedRow) {
//        tableChiTiet.setModel();
           
        try {
            txtMaLop.setText(findClassByID(classID).getMaLop());
            txtTenLop.setText(findClassByID(classID).getTenLop());

        } catch (Exception e) {
            System.out.println("ko tim thay classId");
        }

        model = new TableChiTiet(listtrucnhat);
        tableChiTiet.setModel(model);
        tableChiTiet.getColumnModel().getColumn(2).setCellRenderer(new MultiLineTableCellRenderer());
        tableChiTiet.getColumnModel().getColumn(3).setCellRenderer(new MultiLineTableCellRenderer());

    }

    public void chiatrucnhat(String classID) {
ArrayList<TrucNhat> list = new ArrayList<>();
        Date ngay = findClassByID(classID).getNgayBD();
        //System.out.println(ngay);
        String luuy = "";
        ArrayList<SinhVien> listsv = findClassByID(classID).getListSV();

        int sosvtrucnhat1buoi = (int) listsv.size() / findClassByID(classID).getSoBuoiHoc();
        // Chia đều sinh viên vào các buổi
        int startIndex = 0;
        for (int i = 0; i < findClassByID(classID).getSoBuoiHoc(); i++) {
            int endIndex = Math.min(startIndex + sosvtrucnhat1buoi, listsv.size());

            // Lấy danh sách sinh viên cho buổi hiện tại
            ArrayList<SinhVien> list1buoi = new ArrayList<SinhVien>(listsv.subList(startIndex, endIndex));

            // Nếu số sinh viên trong buổi > 5, chỉ lấy 5 người đầu tiên
            if (list1buoi.size() > 5) {
                list1buoi = new ArrayList<>(list1buoi.subList(0, 5));
                
            }
//            else {
//                JOptionPane.showMessageDialog(this, "Số lượng sinh viên quá ít", "Thông báo", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(ngay);
            calendar.add(Calendar.DAY_OF_YEAR, 7);
            TrucNhat them;
            if (i == 0) {
                calendar.add(Calendar.DAY_OF_YEAR, -7);
                them = new TrucNhat(i + 1, ngay, list1buoi, luuy, findClassByID(classID));
            } else {
                them = new TrucNhat(i + 1, calendar.getTime(), list1buoi, luuy, findClassByID(classID));
            }
            // Thêm danh sách sinh viên trực nhật vào danh sách lịch
        
         list.add(them);
            ngay = calendar.getTime();
            startIndex = endIndex;

        }
          listtrucnhat=list;
          
          allListTrucNhat.add(list);
    }

    public void btnTimKiem() {

    }

    public void clickback() {
        btntrove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Đóng JFrame chi tiết
                // Hiển thị lại JFrame danh sách lớp
                TrangChu trangchu = new TrangChu();
                trangchu.setVisible(true);

            }
        });
    }

    public void xoa(String classID) {
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tableChiTiet.getSelectedRow();
                if (selectedRow != -1) {
                    int confirmResult = 0;

                    confirmResult = JOptionPane.showConfirmDialog(
                            ChiTietQLTN.this,
                            "Bạn có chắc chắn muốn xóa Buổi trực nhật này không?",
                            "Xác nhận Xóa",
                            JOptionPane.OK_CANCEL_OPTION);
                    TableChiTiet model = new TableChiTiet(listtrucnhat);
                    if (confirmResult == JOptionPane.OK_OPTION) {
                        model.removeStudentAt(selectedRow);
                        findClassByID(classID).setSoBuoiHoc(findClassByID(classID).getSoBuoiHoc() - 1);
                        JOptionPane.showMessageDialog(ChiTietQLTN.this, "Xóa thành công!");
                                              writeListTrucNhat();
                    }
                } else {
                    JOptionPane.showMessageDialog(ChiTietQLTN.this, "Vui lòng chọn một buổi trực nhật để xóa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    private void Sua() {
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy hàng được chọn
                int selectedRow = tableChiTiet.getSelectedRow();
                tableChiTiet.getColumnModel().getColumn(3).setCellRenderer(new MultiLineTableCellRenderer());
                // Kiểm tra xem có hàng được chọn hay không
                if (selectedRow != -1) {
                    // Lấy dữ liệu từ hàng được chọn và mở dialog sửa
                    TrucNhat tn = model.getStudentAt(selectedRow);
                    EditDialog(ChiTietQLTN.this, tn);
                } else {
                    // Nếu không có hàng nào được chọn, thông báo cho người dùng
                    JOptionPane.showMessageDialog(ChiTietQLTN.this, "Vui lòng chọn một hàng để sửa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    private void EditDialog(JFrame parent, TrucNhat tn) {
        JPanel panel = new JPanel(new GridLayout(2, 2));

        JTextField ngayField = new JTextField();
        JTextArea luuYField = new JTextArea();

        if (tn != null) {
            // Nếu có sinh viên, hiển thị thông tin cũ
            ngayField.setText(tn.display(tn.getNgayTN()));
            luuYField.setText(tn.getLuuY());
        }

        panel.add(new JLabel("Ngày:"));
        panel.add(ngayField);
        panel.add(new JLabel("Lưu Ý:"));
        panel.add(luuYField);
        ngayField.setColumns(4);  // Thay đổi số cột theo nhu cầu của bạn

        luuYField.setColumns(20);  // Thay đổi số cột theo nhu cầu của bạn
        luuYField.setRows(6);
        luuYField.setLineWrap(true);
        luuYField.setWrapStyleWord(true);
        int result = JOptionPane.showConfirmDialog(
                parent,
                panel,
                "Sửa Thông Tin Trực Nhật",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
//           
            // Nếu có sinh viên (sửa), cập nhật thông tin sinh viên
            try {
                // Kiểm tra định dạng ngày
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date ngay = dateFormat.parse(ngayField.getText());
                tn.setNgayTN(ngay);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(parent, "Ngày không hợp lệ! Vui lòng nhập theo định dạng dd/MM/yyyy.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }

            tn.setLuuY(luuYField.getText());
            model.fireTableDataChanged(); // Cập nhật toàn bộ bảng
    
             writeListTrucNhat();
        }
    }

    public void SuaChiTiet(String classID, int selectedRowdetail) {
        suachitiet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy hàng được chọn
                int selectedRow = tableChiTiet.getSelectedRow();

                // Kiểm tra xem có hàng được chọn hay không
                if (selectedRow != -1) {
                    // Lấy giá trị MASV của hàng được chọn
                    int buoi = (int) tableChiTiet.getValueAt(selectedRow, 0);

                    // Mở trang sửa và gửi mã sinh viên đi
                    showEditPage(buoi, classID, selectedRowdetail);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(ChiTietQLTN.this, "Chọn một dòng để sửa.");
                }
            }
        });

    }

    public void showEditPage(int buoi, String classID, int selectedRow) {
        // Gọi lại interface để chuyển sang JFrame chi tiết
        Them_Sua_ChiTiet detailFrame = new Them_Sua_ChiTiet(classID, buoi, selectedRow, this);
        detailFrame.setVisible(true);
    }

    private void labelMaLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labelMaLopActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_labelMaLopActionPerformed

    private void labelTenLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labelTenLopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_labelTenLopActionPerformed

    private void txtNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        String TimKiem = txtNgay.getText().toString().toLowerCase();
        if (TimKiem.isEmpty() == false) {
            String regex = ".*" + Pattern.quote(TimKiem) + ".*";
            ArrayList<TrucNhat> searchedngay = new ArrayList<>();
            for (TrucNhat tn : listtrucnhat) {
                if (tn.display(tn.getNgayTN()).contains(TimKiem)) {
                    searchedngay.add(tn);
                }

//                String malop = lop.getMaLop().toLowerCase();
//                    if(malop.length()>= TimKiem.length()){
//                        for(int i = 0; i <= TimKiem.length()- malop.length();i++){
//                           if(malop) 
//                        }
//                    }
//                if(malop.equals(TimKiem))
//                    searchedLop.add(lop);
//                if (lop.getTenLop().matches(regex)) 
//                searchedLop.add(lop);
//                if(lop.getMaLop().contains(regex));
//                    searchedLop.add(lop);
            }

            tableChiTiet.setModel(new TableChiTiet(searchedngay));
            tableChiTiet.getColumnModel().getColumn(2).setCellRenderer(new MultiLineTableCellRenderer());
            tableChiTiet.getColumnModel().getColumn(3).setCellRenderer(new MultiLineTableCellRenderer());
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        DangNhap a = new DangNhap();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnDangXuatActionPerformed
}