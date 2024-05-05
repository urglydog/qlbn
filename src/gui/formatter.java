/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.text.DecimalFormat;

/**
 *
 * @author viet6
 */
class formatter {
    private static final DecimalFormat formatter = new DecimalFormat("#,###.##");

    public static void main(String[] args) {
        double number = 12345.6789;
        String formattedNumber = formatter.format(number);
        System.out.println("Formatted Number: " + formattedNumber);
    }

static String format(double gia) {
    // Sử dụng DecimalFormat để định dạng số và định dạng theo mẫu "#,###.##"
    DecimalFormat decimalFormat = new DecimalFormat("#,###.##");

    // Định dạng giá tiền và trả về chuỗi đã định dạng
    return decimalFormat.format(gia);
}
}
