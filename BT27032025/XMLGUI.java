package BT27032025;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import static BT27032025.XMLHelper.deleteXML;
import static BT27032025.XMLHelper.writeXML;

public class XMLGUI extends JFrame {
    private JTextField txtID, txtTen, txtGia;
    private JTextArea txtArea;
    private DanhSachSanPham danhSach;

    public XMLGUI() {
        setTitle("Quản lý Sản phẩm (XML)");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        txtID = new JTextField(5);
        txtTen = new JTextField(10);
        txtGia = new JTextField(7);
        JButton btnThem = new JButton("Thêm");
        JButton btnLuu = new JButton("Lưu XML");
        JButton btnXoa = new JButton("Xóa XML");
        txtArea = new JTextArea(15, 40);
        txtArea.setEditable(false);

        add(new JLabel("ID:"));
        add(txtID);
        add(new JLabel("Tên:"));
        add(txtTen);
        add(new JLabel("Giá:"));
        add(txtGia);
        add(btnThem);
        add(btnLuu);
        add(btnXoa);
        add(new JScrollPane(txtArea));

        danhSach = new DanhSachSanPham();
        danhSach.setSanPhamList(new ArrayList<>());

        btnThem.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtID.getText());
                String ten = txtTen.getText();
                double gia = Double.parseDouble(txtGia.getText());
                danhSach.getSanPhamList().add(new SanPham(id, ten, gia));
                txtArea.append("Thêm: " + ten + " - " + gia + "\n");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lỗi nhập dữ liệu!");
            }
        });

        btnLuu.addActionListener(e -> {
            try {
                writeXML(danhSach, "sanpham.xml");
                JOptionPane.showMessageDialog(this, "Lưu thành công!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi lưu XML!");
            }
        });

        btnXoa.addActionListener(e -> {
            if (deleteXML("sanpham.xml")) {
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy file!");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new XMLGUI().setVisible(true));
    }
}

