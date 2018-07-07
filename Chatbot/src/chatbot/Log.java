package chatbot;

import java.util.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * Esta clase define el log que contendrá todos los datos de la conversación y 
 * todos los parametros que afectan a este.
 * @author Omar Antonio Carrasco Escudero - KomarovLTS
 */

public class Log{

    public List<String> log;
    
    public Log(){
        this.log = new ArrayList();
    }
    
    
    public boolean isLog(List log){
        this.log = log;
        if(log.isEmpty()){
            return true;
            }
        else{
            try{
		Iterator<String> iterator = log.iterator();
		int i = 0;
		while (iterator.hasNext()) {
		    i++;
		    if(i > log.size()){
		        break;
		    }
		}
                return true;
            }
            catch(Exception e){
		return false;
	    }
	}
    }
    
    public List addLog(List log, String Msg){
	this.log = log;
	log.add(Msg);
	return log;
    }
    
    public void saveLog(List<String> log)throws IOException {
        String nombreArchivo = getTiempo();
        FileWriter archivoSalida = null;
        
        try {
            archivoSalida = new FileWriter(nombreArchivo+".log");
            
            for(String stringsLog : log){
                archivoSalida.write(stringsLog);
                archivoSalida.write("\r\n");
            }
        }finally {
            if (archivoSalida != null) {
                archivoSalida.close();
                System.out.println("El log ha sido guardado satisfactoriamente.");
            }
        }
    }
   
    public void loadLog(String nombreArchivo) throws IOException{
        FileReader fr = null;
        BufferedReader br = null;
        try{	
            fr = new FileReader (nombreArchivo+".log");
            br = new BufferedReader(fr);
            System.out.println("Leyendo el contendio del archivo.txt");
            this.log = new ArrayList();
            String linea;

            while((linea = br.readLine())!=null){
		addLog(this.log, linea);
            }
        }
        catch(IOException e){
            System.out.println("El log no se ha podido cargar, por favor inténtelo nuevamente.");
        }
        finally{
            if( null != fr ){
                fr.close();
                System.out.println("El log ha sido cargado satisfactoriamente.");
            }
        }
    }
    
    public String getTiempo(){
        DateTimeFormatter formatoTiempoActual = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm");
        LocalDateTime tiempoActualLocal = LocalDateTime.now();
        String tiempoActual;
        tiempoActual = (formatoTiempoActual.format(tiempoActualLocal));
        return tiempoActual;
    }
    
    public String getUltimo(List log){
        String ultimoElemento;
        if (log != null && !log.isEmpty()) {
            ultimoElemento = (String) log.get(log.size()-1);
        }
        else{
            ultimoElemento = "";
        }
        return ultimoElemento;
    } 
    
    public int searchRepeticiones(){
        int repeticiones = Collections.frequency(log, "|Error|");
        return repeticiones;
    }
}
