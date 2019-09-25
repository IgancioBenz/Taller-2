
 
package Modelo;


public class Venta {
    private int idventa;
    private String sucursal;
    private int monto;
    private String fecha;
    private int idvendedor;

    public Venta(int id, String sucursal, int monto, String fecha, int idvendedor) {
        this.idventa = idventa;
        this.sucursal = sucursal;
        this.monto = monto;
        this.fecha = fecha;
        this.idvendedor = idvendedor;
    }

    public Venta(String fecha, String sucursal, int monto, int idvendedor, int idventa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return idventa;
    }

    public void setId(int idventa) {
        this.idventa = idventa;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(int idvendedor) {
        this.idvendedor = idvendedor;
    }
    
    
    
}
