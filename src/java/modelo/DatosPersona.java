
package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatosPersona {
  
    String dui;
    String apellidos;
    String nombres;
    
    Connection cnn;
    Statement state;
    ResultSet result;
    

    public DatosPersona() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_recurso_humano?zeroDateTimeBehavior=convertToNull","root","");//url de la BD, user, pass
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatosPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DatosPersona(String dui, String apellidos, String nombres) {
        this.dui = dui;
        this.apellidos = apellidos;
        this.nombres = nombres;
    }
    
    
    public boolean insertarDatos(){
        try{
            String miQuery ="insert into tb_persona values('" + dui + "', '" + apellidos + "', '" + nombres + "');";
        int estado = 0; 
        state = cnn.createStatement();
        estado = state.executeUpdate(miQuery);
        if(estado == 1){
            return true;
        }
        }catch (SQLException ex){
            Logger.getLogger(DatosPersona.class.getName()).log(Level.SEVERE,null, ex);
        }
        return false;
    }
    
    public ArrayList<DatosPersona> consultarRegistros(){
        ArrayList<DatosPersona> person = new ArrayList(); 
        try{
            String miQuery = "select * from tb_persona;";
            state = cnn.createStatement();  
            result = state.executeQuery(miQuery);   
            while(result.next()){  
                
                person.add(new DatosPersona(result.getString("dui_persona"), result.getString("apellidos_persona"), result.getString("nombres_Persona")));
                
            }
            
        } catch(SQLException ex){
            Logger.getLogger(DatosPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return person; 
    }


    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public ArrayList<DatosPersona> consultarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    
}
