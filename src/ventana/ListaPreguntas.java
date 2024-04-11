package ventana;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class ListaPreguntas {
	ArrayList<PreguntaC> p;
	int numeropreg;
	public ListaPreguntas() {
		this.p = new ArrayList<PreguntaC>();
		numeropreg = p.size();
	}
	public ListaPreguntas(ArrayList<PreguntaC> a) throws Error {
		if(a.size()>15) {
		throw new Error("El array es demasado grande");
		}
		else {
		this.p = a;
		numeropreg = p.size();
		}
	}
	public ArrayList<PreguntaC> getP() {
		return p;
	}
	public void setP(ArrayList<PreguntaC> p) throws Error {
		if(p.size()>15) {
			throw new Error("El array es demasado grande");
			}
		this.p = p;
	}
	public int getNumeropreg() {
		return numeropreg;
	}
	public void addPreg(PreguntaC c) throws Error {
		if(p.size()<15) {
			p.add(c);
			}
		else {
			throw new Error("El array es demasado grande");
		}
	
	}
	public PreguntaC getPregunta(int n) {
		return p.get(n);
	}
	public  void EscribirLista(File archivo) {
		 
		try(ObjectOutput stream = new ObjectOutputStream(new FileOutputStream(archivo))) {
			for (int i = 0; i < p.size(); i++) {
				stream.writeObject(p.get(i));
			}	
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	}


	

}
