package dtm;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PhoneValidatorTest {

    @Test(description = "TC01 - So dien thoai null phai khong hop le")
    public void testNullPhone() {
        Assert.assertFalse(
                PhoneValidator.isValid(null),
                "So dien thoai null phai tra ve false"
        );
    }

    @Test(description = "TC02 - So dien thoai rong phai khong hop le")
    public void testEmptyPhone() {
        Assert.assertFalse(
                PhoneValidator.isValid(""),
                "So dien thoai rong phai tra ve false"
        );
    }

    @Test(description = "TC03 - Chua ky tu khong hop le phai tra ve false")
    public void testInvalidCharacters() {
        Assert.assertFalse(
                PhoneValidator.isValid("09a1234567"),
                "So dien thoai chua ky tu khong hop le phai tra ve false"
        );
    }

    @Test(description = "TC04 - So dien thoai hop le bat dau bang 03")
    public void testValid03() {
        Assert.assertTrue(
                PhoneValidator.isValid("0381234567"),
                "So dien thoai bat dau bang 03 va dung dinh dang phai hop le"
        );
    }

    @Test(description = "TC05 - So dien thoai hop le bat dau bang +84")
    public void testValidPlus84() {
        Assert.assertTrue(
                PhoneValidator.isValid("+84381234567"),
                "So dien thoai dang +84 hop le phai tra ve true"
        );
    }

    @Test(description = "TC06 - Dau so khong hop le phai tra ve false")
    public void testInvalidPrefix() {
        Assert.assertFalse(
                PhoneValidator.isValid("0212345678"),
                "Dau so khong nam trong 03,05,07,08,09 phai tra ve false"
        );
    }

    @Test(description = "TC07 - Do dai khong du 10 chu so phai tra ve false")
    public void testInvalidLength() {
        Assert.assertFalse(
                PhoneValidator.isValid("038123456"),
                "So dien thoai khong du 10 chu so phai tra ve false"
        );
    }

    @Test(description = "TC08 - So dien thoai hop le co khoang trang")
    public void testValidWithSpaces() {
        Assert.assertTrue(
                PhoneValidator.isValid("038 123 4567"),
                "So dien thoai hop le co khoang trang phai duoc chap nhan sau khi chuan hoa"
        );
    }
}