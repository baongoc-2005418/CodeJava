package BT27032025;

import java.util.List;

@XmlRootElement(name = "DanhSachSanPham")
@XmlAccessorType(XmlAccessType.FIELD)
public class DanhSachSanPham {
    @XmlElement(name = "SanPham")
    private List<SanPham> sanPhamList;

    public List<SanPham> getSanPhamList() {
        return sanPhamList;
    }

    public void setSanPhamList(List<SanPham> sanPhamList) {
        this.sanPhamList = sanPhamList;
    }
}

@XmlAccessorType(XmlAccessType.FIELD)
class SanPham {
    @XmlAttribute
    private int id;
    @XmlElement
    private String ten;
    @XmlElement
    private double gia;

    public SanPham() {}

    public SanPham(int id, String ten, double gia) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
    }

    public int getId() { return id; }
    public String getTen() { return ten; }
    public double getGia() { return gia; }
}
