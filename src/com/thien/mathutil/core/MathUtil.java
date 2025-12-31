/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thien.mathutil.core;

/**
 *
 * @author User
 */
public class MathUtil {
    // trong class này cung cấp cho ai đó nhiều hàm xử lí toán học
    // clone class Math của JDK
    // hàm thư viện xài chung cho ai đó, ko cần lưu lại trạng thái/giá trị
    // chọn thiết kế là hàm static
    // còn non-static hàm thư viện xài riêng 
    
    // hàm tính giai thừa!!!
    // n! = 1.2.3.4.5...n
    // ko có giao thừa cho số âm
    // 0! = 1! = 1 quy ước
    // giai thừa hàm đồ thị dốc đứng, tăng nhanh về giá trị
    // 10 giai thừa là 18 con số 0, vừa kịp đủ cho kiểu long của Java
    // 21 giao thừa tràn kiểu long
    // bài này quy ước tính n! trong khoảng 0...20
//    public static long getFactorial(int n){
//        
//        if (n < 0 || n > 20)
//            throw new IllegalArgumentException("Invalid argument. N must be between 0 ... 20");
//        
//        if (n == 0 || n == 1)
//            return 1;  // kết thúc cuộc chơi sớm nếu nhận những đầu vào đặc biệt
//        
//        long product = 1; // tích nhân dồn, thuật toán heo đất, ốc bu dồn thịt.
//        
//        for (int i = 1; i <= n; i++) 
//            product *= i;  //product = product * i;
//        
//        return product;
//        
//    }
    
    public static long getFactorial(int n){
        if(n < 0 || n > 20)
            throw new IllegalArgumentException("Invalid argument. N must be between 0 ... 20");
        
        if(n == 0 || n == 1)
            return 1;
        
        return n * getFactorial(n - 1);
    }
}
