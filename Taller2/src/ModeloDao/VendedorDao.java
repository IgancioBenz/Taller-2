package ModeloDao;
        
import Modelo.Vendedor;
import ModeloDao.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class VendedorDao {

    Conexion con;

    public VendedorDao() {
        this.con = new Conexion();
    }

    public ArrayList<Vendedor> getVendedor() {

        ArrayList<Vendedor> Vendedores = new ArrayList<>();
        Connection accesoBD = con.getConexion();

        try {
            String sql = "SELECT * FROM vendedor ";

            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);

            while (resultados.next()) {
                String nombre = resultados.getString("nombre");
                String apellido = resultados.getString("apellido");
                int edad = resultados.getInt("edad");
                int id = resultados.getInt("id");

                Vendedores.add(new Vendedor(nombre, apellido, edad, id));
            }
            accesoBD.close();
            return Vendedores;
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }

    }

    public Vendedor obtenerVendedor(int id) {

        Vendedor v;
        Connection accesoBD = con.getConexion();

        try {
            String sql = "SELECT * FROM persona WHERE id = " + id + " ";

            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.first()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String rut = rs.getString("rut");

                v = new Vendedor(id, nombre, apellido, rut);
                accesoBD.close();
                return v;
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

    
    }


