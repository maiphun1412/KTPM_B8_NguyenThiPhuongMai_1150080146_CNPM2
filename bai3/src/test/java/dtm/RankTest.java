package dtm;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RankTest {

    @Test
    public void TC1_invalidScore() {
        Assert.assertEquals(
                RankService.xepLoai(-1, false),
                "Diem khong hop le"
        );
    }

    @Test
    public void TC2_gioi() {
        Assert.assertEquals(
                RankService.xepLoai(9, false),
                "Gioi"
        );
    }

    @Test
    public void TC3_kha() {
        Assert.assertEquals(
                RankService.xepLoai(7, false),
                "Kha"
        );
    }

    @Test
    public void TC4_trungBinh() {
        Assert.assertEquals(
                RankService.xepLoai(6, false),
                "Trung Binh"
        );
    }

    @Test
    public void TC5_thiLai() {
        Assert.assertEquals(
                RankService.xepLoai(4, true),
                "Thi lai"
        );
    }

    @Test
    public void TC6_hocLai() {
        Assert.assertEquals(
                RankService.xepLoai(4, false),
                "Yeu - Hoc lai"
        );
    }
}