public class Arbol {
    private String nombre;
    private String nombreCientifico;
    private String pregunta;
    private String[] opciones;
    private int respuestaCorrecta;
    private String datoCurioso;
    
    public Arbol(String nombre, String nombreCientifico, String pregunta, 
                String[] opciones, int respuestaCorrecta, String datoCurioso) {
        this.nombre = nombre;
        this.nombreCientifico = nombreCientifico;
        this.pregunta = pregunta;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
        this.datoCurioso = datoCurioso;
    }
    
    // Getters
    public String getNombre() { return nombre; }
    public String getNombreCientifico() { return nombreCientifico; }
    public String getPregunta() { return pregunta; }
    public String[] getOpciones() { return opciones; }
    public int getRespuestaCorrecta() { return respuestaCorrecta; }
    public String getDatoCurioso() { return datoCurioso; }
}