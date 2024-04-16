package ventana;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ProcesadorPreguntas {

	File f;
	public ProcesadorPreguntas(String r) {
		this.f = new File("archivo.txt", r);
	}
	public ProcesadorPreguntas() {
		this.f = new File("archivo.txt");
	}
	public void EscribirArchivo(ListaPreguntas l) {

	    try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(this.f))) {
	    	stream.writeObject(l);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	


	public ArrayList<ListaPreguntas> LeerArchivo() throws IOException, ClassNotFoundException {
		ArrayList<ListaPreguntas> retornar = new ArrayList();
	    try(ObjectInputStream stream = new ObjectInputStream(new FileInputStream(this.f))) {
	    	while(true) {
	    		retornar.add((ListaPreguntas)stream.readObject());
	    	}
			
		}
	    catch(EOFException e) {
	    	return retornar;
	    }
	    catch (IOException e) {
			// TODO Auto-generated catch block
		throw new IOException("No se pudo leer");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
		throw new ClassNotFoundException ("No se pudo leer");
		}
	}
	public ListaPreguntas SoloUna(ArrayList<ListaPreguntas> p, int i) {
		return p.get(i);
	
	}

	
//	public void EscribirArchivo(ArrayList <ListaPreguntas> l) {
//	for (int i = 0; i < l.size(); i++) {
//	
//		EscribirArchivo(l.get(i));
//	}
//	 
//	} por si algun dia introduzco los temas para listas  preguntas	
	
	
//	public ArrayList<ListaPreguntas> LeerArchivo2() throws IOException, ClassNotFoundException {
//		ArrayList<ListaPreguntas> retornar = new ArrayList();
//	    try(ObjectInputStream stream = new ObjectInputStream(new FileInputStream(this.f))) {
//	    while(true) {
//	    	retornar.add((ListaPreguntas)stream.readObject());
//	    }
//	  
//	    			
//		}
//	    catch(EOFException e) {
//	    	return retornar;
//	    }
//	    catch (IOException e) {
//			// TODO Auto-generated catch block
//		throw new IOException("No se pudo leer");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//		throw new ClassNotFoundException ("No se pudo leer");
//		}
//	
//		
//	}
}
