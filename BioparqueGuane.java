import java.util.ArrayList;
import java.util.List;

public class BioparqueGuane {
    private List<Arbol> arboles;
    private List<String> aves;
    
    public BioparqueGuane() {
        this.arboles = new ArrayList<>();
        this.aves = new ArrayList<>();
        inicializarDatos();
    }
    
    private void inicializarDatos() {
        // Inicializar aves del bosque seco tropical
        aves.add("Momotus momota - Barranquero");
        aves.add("Megascops choliba - Currucutú");
        aves.add("Cyanocorax yncas - Urraca");
        aves.add("Columbina talpacoti - Tortolita rojiza");
        aves.add("Tyrannus melancholicus - Pitirre");
        
        // Árboles del Bosque Seco Tropical con rutas de imágenes
        arboles.add(new Arbol("Guayacán", "Guaiacum officinale", 
            "Conocido como 'el árbol de la vida', su madera es tan fuerte que puede vivir por cientos de años! Los Guanes lo usaban para herramientas sagradas.",
            "¿Por qué los árboles del bosque seco pierden sus hojas en verano?",
            new String[]{"Porque se cansan de tener hojas", "Para conservar agua durante la sequía", "Porque les gusta estar pelados"}, 
            1, "recursos/5.jpg"));
            
        arboles.add(new Arbol("Apamate Rosa", "Tabebuia rosea", 
            "Florece justo cuando el bosque está más seco, ¡como si trajera esperanza en tiempos difíciles! Los Guanes asociaban sus flores con nuevos comienzos.",
            "¿Qué hacen los animales cuando el bosque está muy seco?",
            new String[]{"Se van de vacaciones a la playa", "Se esconden y duermen hasta que llueve", "Piden ayuda a los humanos"}, 
            1, "recursos/5.jpg"));
            
        arboles.add(new Arbol("Carreto", "Aspidosperma polyneuron", 
            "Mi madera es tan valiosa que casi desaparecí, pero lugares como este me protegen. Los Guanes me consideraban árbol de protección.",
            "¿Por qué es importante proteger los árboles nativos?",
            new String[]{"Porque son bonitos", "Mantienen el equilibrio del ecosistema", "Para hacer muebles"}, 
            1, "recursos/5.jpg"));
    }
    
    public List<Arbol> getArboles() {
        return arboles;
    }
    
    public List<String> getAves() {
        return aves;
    }
    
    public String getHistoriaGuane() {
        return "🌿 **LEGADO GUANE - GUARDIANES DEL BOSQUE SECO** 🌿\n\n" +
               "Los Guanes fueron un pueblo indígena sabio que habitó estas tierras,\n" +
               "conviviendo en armonía con el Bosque Seco Tropical. Eran expertos\n" +
               "agricultores, tejedores y conocedores de las plantas medicinales.\n\n" +
               "Este bioparque honra su legado protegiendo:\n\n" +
               "🌳 **LA BIODIVERSIDAD** - 20+ especies de árboles nativos\n" +
               "🦜 **LAS AVES** - Como el Barranquero (Momotus momota)\n" +
               "💧 **EL AGUA** - Fuente de vida del ecosistema\n" +
               "👨‍👩‍👧‍👦 **LA COMUNIDAD** - Espacio gratuito para todos\n\n" +
               "**MISIÓN:** Conservar el conocimiento ancestral Guane\n" +
               "y proteger el Bosque Seco Tropical para las futuras generaciones.";
    }
    
    public String getMisionTexto() {
        return "🌿 ESTE BOSQUE GUARDA LA SABIDURÍA DE LOS GUANES...\n" +
               "ES UN LEGADO VIVO PARA:\n\n" +
               "🌳 PROTEGER el Bosque Seco Tropical - herencia ancestral\n" +
               "🤝 ELIMINAR BARRERAS - espacio GRATIS inspirado en la comunidad Guane\n" +
               "👨‍👩‍👧‍👦 UNIR LA COMUNIDAD - como lo hacían los antiguos Guanes\n" +
               "🎨 INSPIRAR a nuevas generaciones - manteniendo viva la cultura\n\n" +
               "EL BIOPARQUE GUANE EXISTE PARA HONRAR:\n" +
               "💚 LA SABIDURÍA ANCESTRAL QUE NOS UNE CON LA NATURALEZA 💚";
    }
}