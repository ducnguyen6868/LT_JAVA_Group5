/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import Controller.TableChiTiet;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import models.TrucNhat;
/**
 *
 * @author HP
 */
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
    }
    private void btnChiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChiaActionPerformed

    private void xuatFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xuatFileActionPerformed
        // TODO add your handling code here:
        try (Workbook workbook = new XSSFWorkbook()) {
            // Tạo một trang tính mới
            Sheet sheet = workbook.createSheet("Danh sách trực nhật");
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Buổi");
            headerRow.createCell(1).setCellValue("Ngày");
            headerRow.createCell(2).setCellValue("Sinh vien truc nhat");
            headerRow.createCell(3).setCellValue("Luu y");
            sheet.autoSizeColumn(3);
            // Dòng bắt đầu từ 0, ô bắt đầu từ 0
            int rowNum = 1;

            // Duyệt qua danh sách ShiftData và ghi dữ liệu vào tệp Excel
            for (TrucNhat tn : listtrucnhat) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(tn.getBuoi());
                row.createCell(1).setCellValue(tn.display(tn.getNgayTN()));
                ArrayList<SinhVien> studentList = tn.getListSV();

                row.createCell(2).setCellValue(model.buildStudentString(studentList));

                row.createCell(3).setCellValue(tn.getLuuY());
                // Ghi danh sách sinh viên vào các ô từ cột 2 trở đi

            }

            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Workbook (.xlsx)", "xlsx");
            fileChooser.setFileFilter(filter);
            fileChooser.setDialogTitle("Chọn vị trí lưu trữ");

            // Hiển thị hộp thoại và kiểm tra nếu người dùng chọn OK
            int userSelection = fileChooser.showSaveDialog(this);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                // Lấy đường dẫn mà người dùng đã chọn
                File selectedFile = fileChooser.getSelectedFile();

                // Thêm đuôi .xlsx nếu chưa có
                String filePath = selectedFile.getAbsolutePath();
                if (!filePath.endsWith(".xlsx")) {
                    filePath += ".xlsx";
                }

                try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                    workbook.write(outputStream);
                   JOptionPane.showMessageDialog(ChiTietQLTN.this, "Xuất File thành công !");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
