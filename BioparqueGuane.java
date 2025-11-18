import java.util.ArrayList;
import java.util.List;

public class BioparqueGuane {
    private List<Arbol> arboles;
    
    public BioparqueGuane() {
        arboles = new ArrayList<>();
        inicializarArboles();
    }
    
    private void inicializarArboles() {
        // Guayacán Sagrado
        arboles.add(new Arbol(
            "Guayacán Sagrado",
            "Guaiacum officinale",
            "¿Para qué usaban los Guanes la madera del Guayacán?",
            new String[]{
                "Para construir herramientas de caza",
                "Para tallar figuras rituales y medicinales", 
                "Para hacer canoas de río"
            },
            1,
            "Su madera es tan dura que se hunde en el agua. Los Guanes la consideraban mágica."
        ));
        
        // Apamate Ancestral
        arboles.add(new Arbol(
            "Apamate Ancestral", 
            "Tabebuia rosea",
            "¿Qué característica del Apamate era sagrada para los Guanes?",
            new String[]{
                "Sus flores rosadas en forma de campana",
                "Su capacidad de florecer en sequía",
                "El sonido del viento en sus hojas"
            },
            1,
            "Florece espectacularmente en febrero-marzo, anunciando el cambio de estación."
        ));
        
        // Ceiba Protectora
        arboles.add(new Arbol(
            "Ceiba Protectora",
            "Ceiba pentandra", 
            "¿Por qué la Ceiba era el 'Árbol del Mundo' para los Guanes?",
            new String[]{
                "Por sus raíces profundas que conectaban con el inframundo",
                "Por su altura que unía tierra y cielo",
                "Por sus frutos que alimentaban a los espíritus"
            },
            1,
            "Puede alcanzar 70 metros de altura. Los Guanes creían que conectaba los tres mundos."
        ));
    }
    
    public List<Arbol> getArboles() {
        return arboles;
    }
}