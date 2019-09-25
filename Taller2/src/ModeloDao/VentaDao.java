package ModeloDao;
import Modelo.Venta;
import ModeloDao.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class VentaDao {

    Conexion con;

    public VentaDao() {
        this.con = new Conexion();
    }

    public ArrayList<Venta> getVenta() {

        ArrayList<Venta> Venta = new ArrayList<>();
        Connection accesoBD = con.getConexion();

        try {
            String sql = "SELECT * FROM venta ";

            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);

            while (resultados.next()) {
                String fecha= resultados.getString("fecha");
                String sucursal= resultados.getString("sucursal");
                int monto = resultados.getInt("monto");
                int idvendedor = resultados.getInt("idvendedor");
                int idventa = resultados.getInt("idventa");

                Venta.add(new Venta(fecha, sucursal, monto, idvendedor, idventa));
            }
            accesoBD.close();
            return Venta;
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }

    }

    public Venta obtenerVenta(String fecha) {

        Venta vta;
        VendedorDao vendedor= new VendedorDao();
        Connection accesoBD = con.getConexion();
        String mesNumero = transformar(fecha);
        try {
            String sql = "SELECT * FROM venta WHERE fecha BETWEEN '2019-" + mesNumero + "-01' and '2019-" +mesNumero + "-31";

            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.first()) {
                  
                String sucursal= rs.getString("sucursal");
                int monto = rs.getInt("monto");
                int idvendedor = rs.getInt("idvendedor");
                int idventa = rs.getInt("idventa");

                vta = new Venta(fecha, sucursal, monto, idvendedor, idventa);
                accesoBD.close();
                return vta;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }
    }
private String transformar(String fecha){

    if("Enero".equals(fecha)){
     return "01";   
    }
    if("Febrero".equals(fecha)){
     return "02";   
    }
    if("Marzo".equals(fecha)){
     return "03";   
    }
    if("Abril".equals(fecha)){
     return "04";   
    }
    if("Mayo".equals(fecha)){
     return "05";   
    }
    if("Junio".equals(fecha)){
     return "06";   
    }
    if("Julio".equals(fecha)){
     return "07";   
    }
    if("Agosto".equals(fecha)){
     return "08";   
    }
    if("Septiembre".equals(fecha)){
     return "09";   
    }
    if("Octubre".equals(fecha)){
     return "10";   
    }
    if("Noviembre".equals(fecha)){
     return "11";   
    }
    if("Diciembre".equals(fecha)){
     return "12";   
    }
return null;
}
        
    }

