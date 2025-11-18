public class Arbol {
    private String nombre;
    private String nombreCientifico;
    private String datoCurioso;
    private String pregunta;
    private String[] opciones;
    private int respuestaCorrecta;
    private String imagenPath;
    
    public Arbol(String nombre, String nombreCientifico, String datoCurioso, 
                 String pregunta, String[] opciones, int respuestaCorrecta, String imagenPath) {
        this.nombre = nombre;
        this.nombreCientifico = nombreCientifico;
        this.datoCurioso = datoCurioso;
        this.pregunta = pregunta;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
        this.imagenPath = imagenPath;
    }
    
    // Getters
    public String getNombre() { return nombre; }
    public String getNombreCientifico() { return nombreCientifico; }
    public String getDatoCurioso() { return datoCurioso; }
    public String getPregunta() { return pregunta; }
    public String[] getOpciones() { return opciones; }
    public int getRespuestaCorrecta() { return respuestaCorrecta; }
    public String getImagenPath() { return imagenPath; }
}