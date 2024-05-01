/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import Models.Lop;
import Models.SinhVien;
import Models.TrucNhat;
import View.ChiTietQLTN;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import models.TrucNhat;
/**
 *
 * @author HP
 */
public class Them_Sua_Chi_Tiet extends javax.swing.JFrame {
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
            JOptionPane.showMessageDialog(Them_Sua_ChiTiet.this, "Lỗi ghi truc nhat!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }

   public ArrayList<TrucNhat> ganlist(String classID) {
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

    public TrucNhat findTNByBuoi(int buoi,String classID) {
      
        // Tìm kiếm lớp trong danh sách dựa trên mã lớp
        for (TrucNhat tn : ganlist(classID)) {
         
            if (tn.getBuoi() == buoi) {
                return tn;
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }

    public void display(String classID, int buoi, int selectedRow) {
        ngaytn.setText(findTNByBuoi(buoi,classID).display(findTNByBuoi(buoi,classID).getNgayTN())); //ke thua
        luuy.setText(findTNByBuoi(buoi,classID).getLuuY());
        model = new TableSinhVienTN(findTNByBuoi(buoi,classID).getListSV());
        trucnhat.setModel(model);
        clickback(classID, selectedRow);
    }

    public void clickback(String classID, int selectedRow) {
        btnTroVe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Đóng JFrame chi tiết
                // Hiển thị lại JFrame danh sách lớp
                ChiTietQLTN detail = new ChiTietQLTN(classID, selectedRow, null);
                detail.setVisible(true);
            }
        });
    }
}
