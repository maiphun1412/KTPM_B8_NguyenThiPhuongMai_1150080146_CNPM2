package dtm;

public class PhoneValidator {

    public static boolean isValid(String phone) {

        if (phone == null || phone.trim().isEmpty()) {
            return false;
        }

        phone = phone.trim();

        // Chỉ cho phép số, dấu + và khoảng trắng
        if (!phone.matches("[0-9+ ]+")) {
            return false;
        }

        // Xóa khoảng trắng trước khi chuẩn hóa
        phone = phone.replace(" ", "");

        // Chuẩn hóa +84 thành 0
        if (phone.startsWith("+84")) {
            phone = "0" + phone.substring(3);
        }

        // Phải bắt đầu bằng 0 sau chuẩn hóa
        if (!phone.startsWith("0")) {
            return false;
        }

        // Phải đúng 10 chữ số
        if (phone.length() != 10) {
            return false;
        }

        // Kiểm tra đầu số hợp lệ
        if (!(phone.startsWith("03")
                || phone.startsWith("05")
                || phone.startsWith("07")
                || phone.startsWith("08")
                || phone.startsWith("09"))) {
            return false;
        }

        return true;
    }
}