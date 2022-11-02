/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author ASUS
 */
public class QLMauSac {
    private String id;
    private String ma;
    private String ten;

    public QLMauSac(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public QLMauSac() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Object[] toRowData() {
        return new Object[]{id, ma, ten};
    }
}
