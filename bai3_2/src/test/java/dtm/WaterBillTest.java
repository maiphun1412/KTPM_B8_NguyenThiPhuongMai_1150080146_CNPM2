package dtm;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WaterBillTest {

    @Test
    public void TC1_invalidM3() {

        Assert.assertEquals(
                WaterBillService.tinhTienNuoc(0,"ho_ngheo"),
                0.0
        );
    }

    @Test
    public void TC2_hoNgheo() {

        Assert.assertEquals(
                WaterBillService.tinhTienNuoc(5,"ho_ngheo"),
                25000.0
        );
    }

    @Test
    public void TC3_danCu1() {

        Assert.assertEquals(
                WaterBillService.tinhTienNuoc(8,"dan_cu"),
                60000.0
        );
    }

    @Test
    public void TC4_danCu2() {

        Assert.assertEquals(
                WaterBillService.tinhTienNuoc(15,"dan_cu"),
                148500.0
        );
    }

    @Test
    public void TC5_danCu3() {

        Assert.assertEquals(
                WaterBillService.tinhTienNuoc(25,"dan_cu"),
                285000.0
        );
    }

    @Test
    public void TC6_kinhDoanh() {

        Assert.assertEquals(
                WaterBillService.tinhTienNuoc(5,"kinh_doanh"),
                110000.0
        );
    }
}