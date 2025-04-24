package BT27032025;

import javax.xml.bind.*;
import java.io.File;

public class XMLHelper {
    // Ghi danh sách sản phẩm vào file XML
    public static void writeXML(DanhSachSanPham danhSach, String filePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(DanhSachSanPham.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // Định dạng file XML đẹp hơn
        marshaller.marshal(danhSach, new File(filePath)); // Ghi vào file
    }

    public static DanhSachSanPham readXML(String filePath) throws JAXBException {
        File file = new File(filePath);
        if (!file.exists()) {
            return new DanhSachSanPham(); // Nếu file không tồn tại, trả về danh sách rỗng
        }

        JAXBContext context = JAXBContext.newInstance(DanhSachSanPham.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (DanhSachSanPham) unmarshaller.unmarshal(file);
    }

    public static boolean deleteXML(String filePath) {
        File file = new File(filePath);
        return file.exists() && file.delete(); // Xóa file nếu tồn tại
    }
}
