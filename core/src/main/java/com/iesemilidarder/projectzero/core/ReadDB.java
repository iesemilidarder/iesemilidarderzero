package com.iesemilidarder.projectzero.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
/*
Importamos las siguientes librerias para que funcione en programa
*/

/*
Creamos una clase llamada ReadDB y una arrayList para conectarnos a una base de datos de oracle
*/
public class ReadDB {
    /*
    en el arraylist readRestaurants le ponemos una string llamado consulta
     */
    public ArrayList readRestaurantes(String consulta) {
        ArrayList rl = new ArrayList();
        try {
/*
Decimos que tipo de base de datos nos queremos conectar y a que IP, puerto, usuario y contraseña
*/
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari","usuari");

            Statement stmt = con.createStatement();
/*
Creamos un select para poder visualizar la tabla y otra select para que encuentre el nnombre del restaurante escrito
*/

            ResultSet rs;
            /*
            creamos un if y un else con la consulta del arraylist
            */
            if (consulta == null) {
                rs = stmt.executeQuery("SELECT R.RES_CODI, R.RES_NOM, R.RES_ADRECA, R.RES_WEB, R.RES_TELEFON, R.RES_URL_IMG, R.RES_MITJANA, T.TRS_DESCRIPCIO FROM RESTAURANTS R, TRESTAURANTS T WHERE R.RES_TRS_CODI = T.TRS_CODI ORDER BY RES_MITJANA DESC ");
            }
            else {
                rs = stmt.executeQuery("SELECT R.RES_CODI, R.RES_NOM, R.RES_ADRECA, R.RES_WEB, R.RES_TELEFON, R.RES_URL_IMG, R.RES_MITIANA, T.TRS_DESCRIPCIO FROM RESTAURANTS R, TRESTAURANTS T WHERE R.RES_TRS_CODI = T.TRS_CODI AND LOWER(RES_NOM) LIKE '%"+consulta.toLowerCase()+"%'");

            }
            while (rs.next()) {
                String codigo = rs.getString("RES_CODI");
                String nombre = rs.getString("RES_NOM");
                String direccion = rs.getString("RES_ADRECA");
                String web = rs.getString("RES_WEB");
                String telefono = rs.getString("RES_TELEFON");
                String imagen = rs.getString("RES_URL_IMG");
                String mitjana = rs.getString("RES_MITJANA");
                String descripcion = rs.getString("TRS_DESCRIPCIO");


                Restaurantes rst = new Restaurantes();
                rst.setCodigo(codigo);
                rst.setNombre(nombre);
                rst.setDireccion(direccion);
                rst.setWeb(web);
                rst.setTelefono(telefono);
                rst.setImagen(imagen);
                rst.setMitjana(mitjana);
                rst.setDescripcion(descripcion);

                //rst.setNombre(rs.getString("Nombre"));
                //rst.setDireccion(rs.getString("Direccion"));
                //rst.setWeb(rs.getString("Web"));
                //rst.setTelefono(rs.getString("Telefono"));

                rl.add(rst);
            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return rl;
    }

    public static ArrayList readScore() {
        ArrayList al = new ArrayList();
        try {
/*
Decimos que tipo de base de datos nos queremos conectar y a que IP, puerto, usuario y contraseña
*/
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari","usuari");

            Statement stmt = con.createStatement();
/*
Creamos un select para poder visualizar la tabla y otra select para que encuentre el nnombre del restaurante escrito
*/

            ResultSet rs;
            /*
            creamos un if y un else con la consulta del arraylist
            */
                rs = stmt.executeQuery("SELECT R.RES_CODI, R.RES_NOM, R.RES_ADRECA, R.RES_WEB, R.RES_TELEFON, R.RES_URL_IMG, R.RES_MITJANA, T.TRS_DESCRIPCIO FROM RESTAURANTS R, TRESTAURANTS T WHERE R.RES_TRS_CODI = T.TRS_CODI ORDER BY RES_MITJANA ");

                if (rs.next()) {
                String codigo = rs.getString("RES_CODI");
                String nombre = rs.getString("RES_NOM");
                String direccion = rs.getString("RES_ADRECA");
                String web = rs.getString("RES_WEB");
                String telefono = rs.getString("RES_TELEFON");
                String imagen = rs.getString("RES_URL_IMG");
                String mitjana = rs.getString("RES_MITJANA");
                String descripcion = rs.getString("TRS_DESCRIPCIO");


                Restaurantes score = new Restaurantes();
                score.setCodigo(codigo);
                score.setNombre(nombre);
                score.setDireccion(direccion);
                score.setWeb(web);
                score.setTelefono(telefono);
                score.setImagen(imagen);
                score.setMitjana(mitjana);
                score.setDescripcion(descripcion);

                //score.setNombre(rs.getString("Nombre"));
                //score.setDireccion(rs.getString("Direccion"));
                //score.setWeb(rs.getString("Web"));
                //score.setTelefono(rs.getString("Telefono"));

                al.add(score);
            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return al;
    }
}
/*
Tomás Sastre Cámara
2n ASIX
WAI
*/
