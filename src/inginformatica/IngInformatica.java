package inginformatica;
//package com.ingreso.main;
//import java.util.Scanner;
import java.util.Date;
//import java.util.Calendar;
//import java.util.GregorianCalendar;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
/**
 *
 * @author Asus
 */
public class IngInformatica {
    //private static Object integer;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try {
        // TODO code application logic here
        Scanner Entrada= new Scanner (System.in);
        //int edadAlumno;
        int diaNac, mesNac, anoNac, dia, diaEdad, mesEdad, anoEdad;
       
        do {
            System.out.print("Ingrese dia de nacimiento (1-31): ");
            diaNac = Entrada.nextInt();
        }while (diaNac>31 || diaNac<1);
        do {
            System.out.print("Ingrese mes de nacimiento (1-12): ");
            mesNac = Entrada.nextInt();
        } while (mesNac>12 || mesNac<1);
        System.out.print("Ingrese ano de nacimiento: ");
        anoNac = Entrada.nextInt();
       
        Calendar fecha= new GregorianCalendar();
        int diaActual = fecha.get (Calendar.DAY_OF_MONTH);
        int mesActual = fecha.get (Calendar.MONTH);
        int anoActual = fecha.get (Calendar.YEAR);
        
        //operaciones 
        if (diaActual<diaNac){
            diaActual=diaActual+30;
            mesActual=mesActual-1;
            diaEdad=diaActual-diaNac; 
        }else{
            diaEdad=diaActual-diaNac; 
        }
        if(mesActual<mesNac){
            mesActual=mesActual+12;
            anoActual=anoActual-1;
            mesEdad=mesActual-mesNac;
        }else {
            mesEdad=mesActual-mesNac;
        }
        anoEdad=anoActual-anoNac;
        Date fechaActual=new Date ();
        //System.out.println("siendo hoy: "+ fechaActual);
        System.out.println("Su edad es: " + anoEdad + " anos/ " + mesEdad + " meses/ " + diaEdad + " dias ");
        aniadirArchivo(diaEdad, mesEdad, anoEdad); //asiganamos las variables
    }catch (Exception ex) {
            System.out.println("Ha habido un error " + ex.toString());
    }
    }
    
    public static void aniadirArchivo(int wdia, int wmes, int wanio) {
		FileWriter flwriter = null;
		try {//además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros 
			flwriter = new FileWriter("C:\\_versalida\\persona.txt", true);
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
     		//escribe los datos en el archivo
		bfwriter.write( "Edad exacta = " + wanio + " años " + wmes + " meses "+ wdia + " dias" +"\n");
                //bfwriter.flush();
		bfwriter.close();
		System.out.println("Archivo modificado satisfactoriamente..");
                System.out.println("Sera registrado los cambios en este proyecto");
                System.out.println("Sera registrado los cambios en este proyecto 2");
 
		} catch (IOException e) {
		} finally {
			if (flwriter != null) {
				try {
					flwriter.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
