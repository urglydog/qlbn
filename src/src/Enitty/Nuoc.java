/*
* @ (#) Nuoc.java   1.0     Apr 24, 2024
*
*Copyright (c) 2024 IUH. All rights reserved
*/
package src.Enitty;
/*
*@Deccription:
*@author: Thien Nguyen
*@date: Apr 24, 2024
*@version: 1.0
*/
public class Nuoc {
	private String maSanPham;
	private String maLoai;
	private String maSize;
	private String tenSanPham;
	private String danhMuc;
	private double gia;
	private String moTa;

	public Nuoc() {
		this("","","","","",0.0,"");
	}

	public Nuoc(String maSanPham, String maLoai, String maSize, String tenSanPham, String danhMuc, double gia,
			String moTa) {
		super();
		this.maSanPham = maSanPham;
		this.maLoai = maLoai;
		this.maSize = maSize;
		this.tenSanPham = tenSanPham;
		this.danhMuc = danhMuc;
		this.gia = gia;
		this.moTa = moTa;
	}

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}

	public String getMaSize() {
		return maSize;
	}

	public void setMaSize(String maSize) {
		this.maSize = maSize;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public String getDanhMuc() {
		return danhMuc;
	}

	public void setDanhMuc(String danhMuc) {
		this.danhMuc = danhMuc;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maSanPham == null) ? 0 : maSanPham.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nuoc other = (Nuoc) obj;
		if (maSanPham == null) {
			if (other.maSanPham != null)
				return false;
		} else if (!maSanPham.equals(other.maSanPham))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Nuoc [maSanPham=" + maSanPham + ", maLoai=" + maLoai + ", maSize=" + maSize + ", tenSanPham="
				+ tenSanPham + ", danhMuc=" + danhMuc + ", gia=" + gia + ", moTa=" + moTa + "]";
	}

    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


	
}
