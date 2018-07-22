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
    
    //Campos de clase.
    private List<String> log;
    /**
     * Constructor del Log.
     */
    public Log(){
        this.log = new ArrayList();
    }//Cierre constructor.
    
    /**
     * Método para obtener el log actual.
     * @return Lista de strings que representa el historial de la conversación.
     */
    public List<String> getLog(){
        return log;
    }
    /**
     * Método para comprobar que una lista efectivamente es un Log.
     * @param log, parametro a comprobar si es Log o no.
     * @return Booleano que ratifica si el parametro ingresado es Log.
     */
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
    
    /**
     * Método que añade un String al Log.
     * @param log, parametro objetivo en donde se añadirá el String dado.
     * @param Msg, parametro dado a añadir en un Log específico.
     * @return Se devuelve el Log ya con el String añadido.
     */
    public List addLog(List log, String Msg){
	this.log = log;
	log.add(Msg);
	return log;
    }
    
    /**
     * Método que exporta el Log a un archivo de texto .log
     * @param log, parametro a exportar al archivo de texto.
     * @throws IOException, excepción de tipo Input/Output.
     */
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
    }//Cierre del método.
    
    /**
     * Método que importa desde un archivo de texto a el Log actual, 
     * reemplazandole.
     * @param nombreArchivo, parametro que indica el nombre del archivo de 
     * texto con el Log a importar.
     * @throws IOException, excepción de tipo Input/Output. 
     */
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
    
    /**
     * Método que adquiere el tiempo actual (Tiempo y fecha)según el computador
     * en donde se ejecuta el programa en un formato predefinido.
     * @return String que contiene metadatos de tiempo en formato predefinido.
     */
    public String getTiempo(){
        DateTimeFormatter formatoTiempoActual = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm");
        LocalDateTime tiempoActualLocal = LocalDateTime.now();
        String tiempoActual;
        tiempoActual = (formatoTiempoActual.format(tiempoActualLocal));
        return tiempoActual;
    }
    
    /**
     * Método que adquiere el último String de el Log en cuestión.
     * @param log, parametro objetivo de donde se obtiene el último elemento.
     * @return String final del Log implicado.
     */
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
    
    /**
     * Método que busca todas las repeticiones de un identificador en específico,
     * esto para ayudar a la autoevaluación del Chatbot.
     * @return Número entero que identifica la cantidad de veces que se ha 
     * encontrado un error durante la conversación Usuario-Chatbot.
     */
    public int searchRepeticiones(){
        int repeticiones = Collections.frequency(log, "|Error|");
        return repeticiones;
    }
}//Cierre de clase.
