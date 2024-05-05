package gui;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class CustomTableModel extends DefaultTableModel {

    public CustomTableModel(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        // Định nghĩa kiểu dữ liệu cho từng cột
        if (columnIndex == 2) {
            return ImageIcon.class; // Cột ảnh sẽ có kiểu dữ liệu là ImageIcon
        }
        // Nếu không phải cột ảnh, giữ nguyên kiểu dữ liệu của DefaultTableModel
        return super.getColumnClass(columnIndex);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false; // Không cho phép chỉnh sửa dữ liệu trên bảng
    }
}
