/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.thien.mathutil.test.core;

import com.thien.mathutil.core.MathUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author User
 */
public class MathUtilityTest {
    // đây là class sẽ sử dụng các hàm của thư viện/framework JUnit
        // đêt kiểm thử/kiểm tra code chính - hàm tínhGiaiThua() bên class core.MathUtil
        // viết code để test code chính bên kia !!!
        
        // có nhiều quy tắc đặt tên hàm kiểm thử
        // nhưng thường sẽ là nói lên mục đích của các case/tình huống kiểm thử
        // tình huống xài hàm theo kiểu thành công hay thất bại!!!
        
        // hàm dưới đây là tình huống test hàm chạy thành công, trả về ngon
        // ta sẽ xài hàm kiểu well - đưa 5!, 6!, không chơi đưa -5!, 30!
        
        // @Test JUnit sẽ phối hợp với JVM để chạy hàm này
        // @Test phía hậu trường chính là public static void main()
        // Có nhiều @Test ứng với nhiều case khác nhau để kiểm thử hàm tính giai thừa
    @Test
    public void testGetFactorialGiveRightArgumentReturnWell() {
        // actual là cái tính toán của hàm bên kia
        // exptected là cái kì vọng
        long exptected = 1; // hy vọng 0! = 1
        int n = 0;   // test thử tình huống tử tế đầu vào, mày phải chạy đúng
        
        // long actual = ; gọi hàm cần test bên core/app chính/code chính
        long actual = MathUtil.getFactorial(n);
        
        // so sánh exptected vs actual dùng xanh xanh đỏ đỏ, framework
        Assert.assertEquals(exptected, actual);
        // hàm giúp so sánh 2 giá trị nào đó có giống nhau hay ko
        // nếu giống nhau    -> thảy màu xanh đèn đường - đường thông, code ngon
        //                      ít nhất cho case đang test
        // nếu ko giống nhau -> thảy màu đỏ đèn đường
        //                      hàm ý exptected và actual ko giống nhau
        
        // gộp thêm vài case thành công/đưa đầu vào ngon!!! hàm phải tính ngon
        Assert.assertEquals(1, MathUtil.getFactorial(1)); // tui muốn 1! = 1
        Assert.assertEquals(2, MathUtil.getFactorial(2)); // tui muốn 1! = 2
        Assert.assertEquals(6, MathUtil.getFactorial(3)); // tui muốn 1! = 6
        Assert.assertEquals(24, MathUtil.getFactorial(4)); // tui muốn 1! = 24
        Assert.assertEquals(20, MathUtil.getFactorial(5)); // tui muốn 1! = 120
        Assert.assertEquals(720, MathUtil.getFactorial(6)); // tui muốn 1! = 720
    }
    
    // hàm getFactorial() ta thiết kế có 2 tình huống xử lí 
    // 1. đưa data tử tế trong [0...20]  -> tính đúng đc n! - done
    // 2. đưa data vào cà chớn, âm, > 20,-> THIẾT KẾ CỦA HÀM LÀ NÉM RA NGOẠI LỆ
    // TAO KÌ VÒNG NGOẠI LỆ XUẤT HIỆN KHI N < 0 || N > 20
    // rất mong ngoại lệ xuất hiện với n cà chớn này
    
    // nếu hàm nhận vào n < 0 || n > 20 và hàm ném ra ngoại lệ
    // HÀM CHẠY ĐÚNG NHƯ THIẾT KẾ  -> PHẢI XANH XUẤT HIỆN
    
    // nếu hàm nhận vào n < 0 || n > 20 và hàm éo ném ra ngoại lệ 
    // sure, HÀM CHẠY SAI THIẾT KẾ, SAI KÌ VỌNG, MÀU ĐỎ 
    
    // Test case: 
    // input : -5;
    // expected : IllegalArgumentException xuất hiện
    // những tình huống bất thường, ngoại lệ, ngoài dự tính, dự liệu
    // là những thứ không thể đo lường so sánh theo kiểu value
    // mà chỉ có thể đo lường bằng cách chúng có xuất hiện hay ko
    // assertEquals() ko dùng để so sánh 2 ngoại lệ 
    //       equals() là bằng nhau hay ko trên value!!!
    
    
    // MÀU ĐỎ ĐÓ EM, DO HÀM ĐÚNG LÀ CÓ NÉM NGOẠI LỆ THẬT SỰ
    //               NHƯNG KO PHẢI LÀ NGOẠI LỆ NHƯ KÌ VỌNG - THỰC SỰ KÌ VỌNG SAI
    //               KO PHẢI HÀM NÉM SAI  
//    @Test(expected = NumberFormatException.class)
//    public void testGetFactorialGiveWrongArgumentThrowsException(){
//        MathUtil.getFactorial(-5);  // hàm @Test chạy, hay hàm getFactorial() chạy sẽ ném về ngoại lệ NumberFormatException...         
//    }
    
    // CÁCH 1:
    @Test(expected = IllegalArgumentException.class)
    public void testGetFactorialGiveWrongArgumentThrowsException(){
        MathUtil.getFactorial(-5); // hàm @Test chạy, hay hàm getFactorial() chạy sẽ ném về ngoại lệ NumberFormatException...
    }
    
    // CÁCH KHÁC ĐỂ BẮT NGOẠI LỆ XUẤT HIỆN, VIẾT TỰ NHIÊN HƠN!!!
    // Xài Lambda Expression  
    // Test Case: hàm sẽ ném về ngoại lệ nếu nhận vào 21
    // tui cần thấy màu xanh khi chơi với 21!
    @Test
    public void testGetFactorialGiveWrongArgumentThrowsException_LambdaVesion(){
        
        //Assert.assertThrows(tham số 1: loại ngoại lệ muốn so sánh,
        //                    tham số 2: đoạn code chạy văng ra ngoại runnable);
        
        Assert.assertThrows(IllegalArgumentException.class,
               () -> MathUtil.getFactorial(21));      
    }
    
    @Test
    public void testGetFactorialGiveWrongArgumentThrowsException_TryCatch(){
        // chủ động kiểm soát ngoại lệ!!!
        try {
            MathUtil.getFactorial(-5);
        } catch (Exception e) {
            // bắt try-catch là JUnit sẽ ra xanh do đã chủ động kiểm soát ngoại lệ
            // nhưng ko chắc ngoại lệ mình cần có xuất hiện hay ko???
            //có đoạn code kiểm soát đúng ngoại lệ IllegalArgumentException xuất hiện 
           Assert.assertEquals("Invalid argument. N must be between 0 ... 20",
                   e.getMessage());
           // e.getMessage()
        }
    }
}
