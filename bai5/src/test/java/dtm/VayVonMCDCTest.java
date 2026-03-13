package dtm;

import org.testng.Assert;
import org.testng.annotations.Test;

public class VayVonMCDCTest {

    @Test(description = "MC/DC cho dieu kien tuoi (A): doi tuoi tu du sang khong du, giu nguyen B, C, D")
    public void testMCDC_TuoiDocLap_ThapHon22() {
        boolean actual = VayVonService.duDieuKienVay(20, 12_000_000, true, 750);
        Assert.assertFalse(
                actual,
                "Sai logic MC/DC tai dieu kien tuoi: tuoi < 22 thi ket qua phai la false."
        );
    }

    @Test(description = "MC/DC cho dieu kien tuoi (A): tuoi du 22 tro len, giu nguyen B, C, D")
    public void testMCDC_TuoiDocLap_Du22TroLen() {
        boolean actual = VayVonService.duDieuKienVay(25, 12_000_000, true, 750);
        Assert.assertTrue(
                actual,
                "Sai logic MC/DC tai dieu kien tuoi: tuoi >= 22 va cac dieu kien khac dung thi ket qua phai la true."
        );
    }

    @Test(description = "MC/DC cho dieu kien thu nhap (B): thu nhap thap hon 10 trieu, giu nguyen A, C, D")
    public void testMCDC_ThuNhapDocLap_Duoi10Trieu() {
        boolean actual = VayVonService.duDieuKienVay(25, 8_000_000, true, 750);
        Assert.assertFalse(
                actual,
                "Sai logic MC/DC tai dieu kien thu nhap: thu nhap < 10.000.000 thi ket qua phai la false."
        );
    }

    @Test(description = "MC/DC cho dieu kien thu nhap (B): thu nhap tu 10 trieu tro len, giu nguyen A, C, D")
    public void testMCDC_ThuNhapDocLap_Tu10TrieuTroLen() {
        boolean actual = VayVonService.duDieuKienVay(25, 12_000_000, true, 750);
        Assert.assertTrue(
                actual,
                "Sai logic MC/DC tai dieu kien thu nhap: thu nhap >= 10.000.000 va cac dieu kien khac dung thi ket qua phai la true."
        );
    }

    @Test(description = "MC/DC cho dieu kien tai san bao lanh (C): khong co tai san, giu nguyen A, B, D=false")
    public void testMCDC_TaiSanBaoLanhDocLap_KhongCoTaiSan() {
        boolean actual = VayVonService.duDieuKienVay(25, 12_000_000, false, 650);
        Assert.assertFalse(
                actual,
                "Sai logic MC/DC tai dieu kien tai san bao lanh: C=false va D=false thi ket qua phai la false."
        );
    }

    @Test(description = "MC/DC cho dieu kien tai san bao lanh (C): co tai san bao lanh, giu nguyen A, B, D=false")
    public void testMCDC_TaiSanBaoLanhDocLap_CoTaiSan() {
        boolean actual = VayVonService.duDieuKienVay(25, 12_000_000, true, 650);
        Assert.assertTrue(
                actual,
                "Sai logic MC/DC tai dieu kien tai san bao lanh: C=true va cac dieu kien con lai dat thi ket qua phai la true."
        );
    }

    @Test(description = "MC/DC cho dieu kien diem tin dung (D): diem tin dung duoi 700, giu nguyen A, B, C=false")
    public void testMCDC_DiemTinDungDocLap_Duoi700() {
        boolean actual = VayVonService.duDieuKienVay(25, 12_000_000, false, 650);
        Assert.assertFalse(
                actual,
                "Sai logic MC/DC tai dieu kien diem tin dung: D < 700 va C=false thi ket qua phai la false."
        );
    }

    @Test(description = "MC/DC cho dieu kien diem tin dung (D): diem tin dung tu 700 tro len, giu nguyen A, B, C=false")
    public void testMCDC_DiemTinDungDocLap_Tu700TroLen() {
        boolean actual = VayVonService.duDieuKienVay(25, 12_000_000, false, 750);
        Assert.assertTrue(
                actual,
                "Sai logic MC/DC tai dieu kien diem tin dung: D >= 700 va cac dieu kien con lai dat thi ket qua phai la true."
        );
    }
}