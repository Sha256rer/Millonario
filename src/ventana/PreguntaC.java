package ventana;


import java.util.ArrayList;

public class PreguntaC {
	String pregunta;
	int correcta;
	String respuestas[];
	public PreguntaC(String s, String[] s2, int c) {
		this.pregunta = s;
		this.correcta = c;
		this.respuestas = s2;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public int getCorrecta() {
		return correcta;
	}
	public void setCorrecta(int correcta) {
		this.correcta = correcta;
	}
	public String[] getRespuestas() {
		return respuestas;
	}
	public void setRespuestas(String[] respuestas) {
		this.respuestas = respuestas;
	}

}
