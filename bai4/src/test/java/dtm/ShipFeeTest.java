package dtm;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ShipFeeTest {

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void TC1_trongLuongKhongHopLe() {
        ShipService.tinhPhiShip(-1, "noi_thanh", false);
    }

    @Test
    public void TC2_noiThanhKhongVuotMoc() {
        Assert.assertEquals(
                ShipService.tinhPhiShip(4, "noi_thanh", false),
                15000.0
        );
    }

    @Test
    public void TC3_noiThanhVuot5Kg() {
        Assert.assertEquals(
                ShipService.tinhPhiShip(8, "noi_thanh", false),
                21000.0
        );
    }

    @Test
    public void TC4_ngoaiThanhKhongVuotMoc() {
        Assert.assertEquals(
                ShipService.tinhPhiShip(2, "ngoai_thanh", false),
                25000.0
        );
    }

    @Test
    public void TC5_ngoaiThanhVuot3Kg() {
        Assert.assertEquals(
                ShipService.tinhPhiShip(5, "ngoai_thanh", false),
                31000.0
        );
    }

    @Test
    public void TC6_vungKhacKhongVuotMoc() {
        Assert.assertEquals(
                ShipService.tinhPhiShip(1, "khac", false),
                50000.0
        );
    }

    @Test
    public void TC7_vungKhacVuot2Kg() {
        Assert.assertEquals(
                ShipService.tinhPhiShip(4, "khac", false),
                60000.0
        );
    }

    @Test
    public void TC8_memberDuocGiam10PhanTram() {
        Assert.assertEquals(
                ShipService.tinhPhiShip(6, "noi_thanh", true),
                15300.0
        );
    }
}