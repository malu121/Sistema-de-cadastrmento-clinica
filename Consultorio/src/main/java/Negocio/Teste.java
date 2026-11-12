/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Maria Luiza
 */
public class Teste {
    public static void main(String[] args) throws SQLException{
        Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/dbConsultorio","root","*M@Y4[Z%7LV*");
        System.out.println("Conectado!");
        conexao.close();
    }
    
}
