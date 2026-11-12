/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author Maria Luiza
 */
public class ConFactory {
    public Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost/dbconsultorio","root","*M@Y4[Z%7LV*");
        }
        catch(SQLException excecao){
            throw new RuntimeException(excecao);
        }
    }
    
}
