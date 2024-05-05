/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import javax.swing.table.TableCellRenderer;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

class ImageRenderer extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof ImageIcon) {
            // Hiển thị hình ảnh trong JLabel
            JLabel label = new JLabel((ImageIcon) value);
            label.setOpaque(true);
            label.setBackground(Color.WHITE);
            return label;
        } else {
            // Hiển thị dữ liệu mặc định cho các cột khác
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }
}