import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AventuraGraficaGuane {
    private JFrame ventana;
    private JPanel panelPrincipal;
    private CardLayout cardLayout;
    private BioparqueGuane bioparque;
    private int puntos;
    private boolean esGuardian;
    private int arbolActual;
    
    // Colores inspirados en el bosque seco y cultura Guane
    private final Color VERDE_GUANE = new Color(46, 125, 50);
    private final Color MARRON_TIERRA = new Color(121, 85, 72);
    private final Color ORO_SOL = new Color(255, 193, 7);
    private final Color AZUL_CIELO = new Color(179, 229, 252);
    private final Color TERRA_COTTA = new Color(183, 110, 81);
    
    public AventuraGraficaGuane() {
        this.bioparque = new BioparqueGuane();
        this.puntos = 0;
        this.esGuardian = false;
        this.arbolActual = 0;
        inicializarInterfaz();
    }
    
    private void inicializarInterfaz() {
        ventana = new JFrame("🌳 Aventura en el Bosque Seco Tropical - Bioparque Guane");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(1000, 750);
        ventana.setLocationRelativeTo(null);
        
        // ⭐⭐ LOGO - USA SOLO PNG QUE FUNCIONA MEJOR ⭐⭐
        try {
            ImageIcon icono = new ImageIcon("logo.png");
            // Redimensionar a tamaño adecuado para icono
            Image imagen = icono.getImage();
            Image iconoRedimensionado = imagen.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
            ventana.setIconImage(iconoRedimensionado);
            System.out.println("✅ Logo PNG cargado correctamente");
        } catch (Exception e) {
            System.out.println("❌ Error cargando logo: " + e.getMessage());
        }
        
        cardLayout = new CardLayout();
        panelPrincipal = new JPanel(cardLayout);
        panelPrincipal.setBackground(AZUL_CIELO);
        
        crearPantallaBienvenida();
        crearPantallaAves();
        crearPantallaCaminos();
        crearPantallaArbol();
        crearPantallaComunidad();
        crearPantallaFinal();
        
        ventana.add(panelPrincipal);
        ventana.setVisible(true);
    }
    
    private JLabel crearImagenLabel(String nombreArchivo, String textoAlternativo, int ancho, int alto) {
        String ruta = "recursos/" + nombreArchivo;
        File archivo = new File(ruta);
        
        if (archivo.exists()) {
            ImageIcon iconoOriginal = new ImageIcon(ruta);
            Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
            JLabel label = new JLabel(new ImageIcon(imagenEscalada));
            label.setToolTipText(textoAlternativo);
            return label;
        } else {
            // Si no encuentra la imagen, mostrar un placeholder con el número
            JLabel placeholder = new JLabel("<html><center>🖼️ " + textoAlternativo + "</center></html>", JLabel.CENTER);
            placeholder.setFont(new Font("Arial", Font.ITALIC, 14));
            placeholder.setOpaque(true);
            placeholder.setBackground(Color.LIGHT_GRAY);
            placeholder.setPreferredSize(new Dimension(ancho, alto));
            placeholder.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
            return placeholder;
        }
    }
    
    private void crearPantallaBienvenida() {
        JPanel panelBienvenida = new JPanel(new BorderLayout());
        panelBienvenida.setBackground(AZUL_CIELO);
        panelBienvenida.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Título con estilo Guane
        JLabel titulo = new JLabel("🌳 BIOPARQUE GUANE 🌳", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 32));
        titulo.setForeground(VERDE_GUANE);
        
        // Imagen 1 - La puerta del Momotus
        JLabel imagenIntro = crearImagenLabel("1.jpg", "Puerta del Momotus - Entrada Mágica", 500, 300);
        imagenIntro.setHorizontalAlignment(JLabel.CENTER);
        
        // Mensaje de bienvenida con historia Guane
        JTextArea mensaje = new JTextArea();
        mensaje.setText("¡BIENVENIDO, EXPLORADOR GUANE!\n\n" +
                       "Esta es la \"Puerta del Momotus\", donde comienza nuestro\n" +
                       "viaje por el Bosque Seco Tropical, siguiendo las huellas\n" +
                       "de los antiguos Guanes que habitaron estas tierras.\n\n" +
                       "El Barranquero (Momotus momota) te da la bienvenida\n" +
                       "a este espacio sagrado de aprendizaje y conservación.\n\n" +
                       "¿Estás listo para descubrir los secretos del bosque ancestral?");
        mensaje.setFont(new Font("Arial", Font.PLAIN, 16));
        mensaje.setBackground(AZUL_CIELO);
        mensaje.setEditable(false);
        mensaje.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Botones con diseño Guane
        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.setBackground(AZUL_CIELO);
        
        JButton btnSi = crearBoton("¡Sí, cruzar la puerta!", VERDE_GUANE);
        JButton btnNo = crearBoton("Todavía no", MARRON_TIERRA);
        
        btnSi.addActionListener(e -> cardLayout.show(panelPrincipal, "aves"));
        btnNo.addActionListener(e -> mostrarMensajeDespedida());
        
        panelBotones.add(btnSi);
        panelBotones.add(btnNo);
        
        // Organizar componentes
        panelBienvenida.add(titulo, BorderLayout.NORTH);
        
        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
        panelCentro.setBackground(AZUL_CIELO);
        panelCentro.add(imagenIntro);
        panelCentro.add(Box.createRigidArea(new Dimension(0, 20)));
        panelCentro.add(mensaje);
        
        panelBienvenida.add(panelCentro, BorderLayout.CENTER);
        panelBienvenida.add(panelBotones, BorderLayout.SOUTH);
        
        panelPrincipal.add(panelBienvenida, "bienvenida");
    }
    
    private void crearPantallaAves() {
        JPanel panelAves = new JPanel(new BorderLayout());
        panelAves.setBackground(AZUL_CIELO);
        panelAves.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel titulo = new JLabel("🦜 EL BARRAQUERO Y SUS AMIGOS 🦜", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(VERDE_GUANE);
        
        // Panel principal con imagen y texto
        JPanel panelContenido = new JPanel(new BorderLayout(20, 20));
        panelContenido.setBackground(AZUL_CIELO);
        
        // Imagen 1 nuevamente (o puedes usar otra si tienes)
        JLabel imgAves = crearImagenLabel("1.jpg", "El Barranquero - Guardián del Bosque", 400, 300);
        
        JTextArea infoAves = new JTextArea();
        infoAves.setText("EL BARRANQUERO (Momotus momota)\n\n" +
                        "Este ave colorida es uno de los guardianes del bosque.\n" +
                        "Los Guanes creían que su canto anunciaba la llegada\n" +
                        "de la lluvia después de la temporada seca.\n\n" +
                        "Características:\n" +
                        "• Colores vibrantes: verde, azul y naranja\n" +
                        "• Cola única en forma de raqueta\n" +
                        "• Canto melodioso que marca territorios\n" +
                        "• Se alimenta de insectos y frutos\n\n" +
                        "En el Bioparque Guane, el Barranquero nos recuerda\n" +
                        "la importancia de cada ser vivo en el ecosistema.");
        infoAves.setFont(new Font("Arial", Font.PLAIN, 16));
        infoAves.setBackground(AZUL_CIELO);
        infoAves.setEditable(false);
        infoAves.setLineWrap(true);
        infoAves.setWrapStyleWord(true);
        
        panelContenido.add(imgAves, BorderLayout.WEST);
        panelContenido.add(infoAves, BorderLayout.CENTER);
        
        JButton btnContinuar = crearBoton("Conocer los árboles ancestrales →", VERDE_GUANE);
        btnContinuar.addActionListener(e -> cardLayout.show(panelPrincipal, "caminos"));
        
        panelAves.add(titulo, BorderLayout.NORTH);
        panelAves.add(panelContenido, BorderLayout.CENTER);
        panelAves.add(btnContinuar, BorderLayout.SOUTH);
        
        panelPrincipal.add(panelAves, "aves");
    }
    
    private void crearPantallaCaminos() {
        JPanel panelCaminos = new JPanel(new BorderLayout());
        panelCaminos.setBackground(AZUL_CIELO);
        panelCaminos.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel titulo = new JLabel("🌄 ELIGE EL CAMINO GUANE", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(VERDE_GUANE);
        
        JTextArea descripcion = new JTextArea();
        descripcion.setText("Has cruzado la Puerta del Momotus y ahora el bosque\n" +
                           "ancestral se abre ante ti...\n\n" +
                           "Sientes la energía de los antiguos Guanes en cada hoja,\n" +
                           "en cada sonido del bosque.\n\n" +
                           "\"Camina con respeto, como lo hicieron nuestros ancestros\"\n" +
                           "- susurra el viento entre los árboles.\n\n" +
                           "📌 DOS SENDEROS SAGRADOS TE ESPERAN:");
        descripcion.setFont(new Font("Arial", Font.PLAIN, 16));
        descripcion.setBackground(AZUL_CIELO);
        descripcion.setEditable(false);
        
        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 20, 20));
        panelBotones.setBackground(AZUL_CIELO);
        
        JButton btnCamino1 = crearBotonGrande("🛤️ Sendero del\nGuayacán Sagrado");
        JButton btnCamino2 = crearBotonGrande("🌿 Ruta del\nApamate Ancestral");
        
        btnCamino1.addActionListener(e -> {
            arbolActual = 0;
            actualizarPantallaArbol();
            cardLayout.show(panelPrincipal, "arbol");
        });
        
        btnCamino2.addActionListener(e -> {
            arbolActual = 1;
            actualizarPantallaArbol();
            cardLayout.show(panelPrincipal, "arbol");
        });
        
        panelBotones.add(btnCamino1);
        panelBotones.add(btnCamino2);
        
        panelCaminos.add(titulo, BorderLayout.NORTH);
        panelCaminos.add(descripcion, BorderLayout.CENTER);
        panelCaminos.add(panelBotones, BorderLayout.SOUTH);
        
        panelPrincipal.add(panelCaminos, "caminos");
    }
    
    private void crearPantallaArbol() {
        JPanel panelArbol = new JPanel(new BorderLayout());
        panelArbol.setBackground(AZUL_CIELO);
        panelArbol.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelPrincipal.add(panelArbol, "arbol");
    }
    
    private void actualizarPantallaArbol() {
        JPanel panelArbol = (JPanel) panelPrincipal.getComponent(3);
        panelArbol.removeAll();
        
        Arbol arbol = bioparque.getArboles().get(arbolActual);
        
        // Título
        JLabel titulo = new JLabel("🌳 " + arbol.getNombre().toUpperCase() + " 🌳", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(VERDE_GUANE);
        
        // Panel con imagen e información
        JPanel panelInfo = new JPanel(new BorderLayout(20, 20));
        panelInfo.setBackground(AZUL_CIELO);
        
        // Usar imagen 5 como fondo general de árboles (panorámica)
        JLabel imagenArbol = crearImagenLabel("5.jpg", "Vista panorámica del Bioparque", 400, 250);
        imagenArbol.setHorizontalAlignment(JLabel.CENTER);
        
        // Información del árbol
        JTextArea infoArbol = new JTextArea();
        infoArbol.setText("Nombre científico: " + arbol.getNombreCientifico() + 
                         "\n\n💡 " + arbol.getDatoCurioso() +
                         "\n\n*Los Guanes usaban este árbol para medicina,\nconstrucción y rituales ancestrales.*");
        infoArbol.setFont(new Font("Arial", Font.PLAIN, 16));
        infoArbol.setBackground(AZUL_CIELO);
        infoArbol.setEditable(false);
        infoArbol.setLineWrap(true);
        infoArbol.setWrapStyleWord(true);
        
        panelInfo.add(imagenArbol, BorderLayout.WEST);
        panelInfo.add(infoArbol, BorderLayout.CENTER);
        
        // Pregunta
        JLabel labelPregunta = new JLabel("🎯 " + arbol.getPregunta());
        labelPregunta.setFont(new Font("Arial", Font.BOLD, 16));
        
        // Opciones
        JPanel panelOpciones = new JPanel(new GridLayout(3, 1, 10, 10));
        panelOpciones.setBackground(AZUL_CIELO);
        
        String[] opciones = arbol.getOpciones();
        for (int i = 0; i < opciones.length; i++) {
            final int opcionIndex = i;
            JButton btnOpcion = crearBoton((i + 1) + ". " + opciones[i], VERDE_GUANE);
            btnOpcion.addActionListener(e -> verificarRespuesta(opcionIndex, arbol.getRespuestaCorrecta()));
            panelOpciones.add(btnOpcion);
        }
        
        panelArbol.add(titulo, BorderLayout.NORTH);
        panelArbol.add(panelInfo, BorderLayout.CENTER);
        
        JPanel panelPregunta = new JPanel(new BorderLayout());
        panelPregunta.setBackground(AZUL_CIELO);
        panelPregunta.add(labelPregunta, BorderLayout.NORTH);
        panelPregunta.add(panelOpciones, BorderLayout.CENTER);
        
        panelArbol.add(panelPregunta, BorderLayout.SOUTH);
        
        panelArbol.revalidate();
        panelArbol.repaint();
    }
    
    private void verificarRespuesta(int respuestaUsuario, int respuestaCorrecta) {
        Arbol arbol = bioparque.getArboles().get(arbolActual);
        
        if (respuestaUsuario == respuestaCorrecta) {
            puntos += 10;
            JOptionPane.showMessageDialog(ventana, 
                "✅ ¡SABIDURÍA GUANE!\n\n" +
                "Has respondido como lo haría un anciano Guane.\n" +
                "El árbol te entrega una semilla de conocimiento.\n" +
                "Puntos: +10", 
                "¡Respuesta Ancestral!", 
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(ventana, 
                "💡 El bosque te enseña...\n\n" +
                "La respuesta de los Guanes era:\n" +
                arbol.getOpciones()[respuestaCorrecta] + "\n\n" +
                "Sigue aprendiendo, joven explorador!", 
                "Conocimiento Ancestral", 
                JOptionPane.WARNING_MESSAGE);
        }
        
        if (arbolActual < 2) {
            arbolActual++;
            actualizarPantallaArbol();
        } else {
            cardLayout.show(panelPrincipal, "comunidad");
        }
    }
    
    private void crearPantallaComunidad() {
        JPanel panelComunidad = new JPanel(new BorderLayout());
        panelComunidad.setBackground(AZUL_CIELO);
        panelComunidad.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelPrincipal.add(panelComunidad, "comunidad");
    }
    
    private void actualizarPantallaComunidad() {
        JPanel panelComunidad = (JPanel) panelPrincipal.getComponent(4);
        panelComunidad.removeAll();
        
        JLabel titulo = new JLabel("👨‍👩‍👧‍👦 LA COMUNIDAD GUANE 👨‍👩‍👧‍👦", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(VERDE_GUANE);
        
        // Panel con múltiples imágenes
        JPanel panelImagenes = new JPanel(new GridLayout(1, 2, 15, 15));
        panelImagenes.setBackground(AZUL_CIELO);
        
        // Imagen 2 - Clases con niños
        JLabel imgClases = crearImagenLabel("2.jpg", "Clases con niños del colegio", 350, 250);
        
        // Imagen 3 - Guardianas del bioparque
        JLabel imgGuardianas = crearImagenLabel("3.jpg", "Guardianas del Bioparque", 350, 250);
        
        panelImagenes.add(imgClases);
        panelImagenes.add(imgGuardianas);
        
        JTextArea historia = new JTextArea();
        historia.setText("EL BIOPARQUE GUANE: UN SUEÑO HECHO REALIDAD\n\n" +
                        "Estas imágenes muestran la esencia del Bioparque:\n\n" +
                        "🎒 CLASES CON NIÑOS: \n" +
                        "Estudiantes aprendiendo sobre el bosque seco,\n" +
                        "siguiendo el legado educativo de los Guanes.\n\n" +
                        "🌿 GUARDIANAS DEL BOSQUE:\n" +
                        "Mujeres comprometidas protegiendo el ecosistema,\n" +
                        "manteniendo viva la sabiduría ancestral.\n\n" +
                        "Hace años, cuando viste esa valla soñando con este espacio,\n" +
                        "no imaginabas que se convertiría en este santuario\n" +
                        "de aprendizaje y conservación comunitaria.");
        historia.setFont(new Font("Arial", Font.PLAIN, 16));
        historia.setBackground(AZUL_CIELO);
        historia.setEditable(false);
        historia.setLineWrap(true);
        historia.setWrapStyleWord(true);
        
        JButton btnContinuar = crearBoton("Ver el letrero original →", ORO_SOL);
        btnContinuar.addActionListener(e -> {
            actualizarPantallaFinal();
            cardLayout.show(panelPrincipal, "final");
        });
        
        panelComunidad.add(titulo, BorderLayout.NORTH);
        panelComunidad.add(panelImagenes, BorderLayout.CENTER);
        panelComunidad.add(historia, BorderLayout.SOUTH);
        panelComunidad.add(btnContinuar, BorderLayout.AFTER_LAST_LINE);
        
        panelComunidad.revalidate();
        panelComunidad.repaint();
    }
    
    private void crearPantallaFinal() {
        JPanel panelFinal = new JPanel(new BorderLayout());
        panelFinal.setBackground(AZUL_CIELO);
        panelFinal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelPrincipal.add(panelFinal, "final");
    }
    
    private void actualizarPantallaFinal() {
        JPanel panelFinal = (JPanel) panelPrincipal.getComponent(5);
        panelFinal.removeAll();
        
        JLabel titulo = new JLabel("🌟 ¡HAS COMPLETADO EL VIAJE GUANE! 🌟", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(VERDE_GUANE);
        
        // Panel con imagen 4 y 5
        JPanel panelImagenesFinal = new JPanel(new GridLayout(1, 2, 15, 15));
        panelImagenesFinal.setBackground(AZUL_CIELO);
        
        // Imagen 4 - Letrero original que te emocionó
        JLabel imgLetrero = crearImagenLabel("4.jpg", "Letrero original del Bioparque", 350, 250);
        
        // Imagen 5 - Vista panorámica
        JLabel imgPanoramica = crearImagenLabel("5.jpg", "Vista panorámica con Serranía", 350, 250);
        
        panelImagenesFinal.add(imgLetrero);
        panelImagenesFinal.add(imgPanoramica);
        
        // Resultados y mensaje final
        JTextArea resultados = new JTextArea();
        resultados.setText("ESTE FUE EL SUEÑO QUE VISTE HACE AÑOS...\n\n" +
                         "Esa valla (imagen izquierda) anunciaba lo que sería\n" +
                         "el Bioparque Guane. Hoy es realidad: un espacio donde\n" +
                         "la Serranía de los Yariguíes abraza a Barichara y\n" +
                         "el legado Guane revive en cada árbol, en cada ave.\n\n" +
                         "🌱 TU JORNADA GUANE:\n" +
                         "📊 Puntos de sabiduría: " + puntos + "/30\n" +
                         "🌳 Árboles ancestrales conocidos: " + (arbolActual + 1) + "\n" +
                         "🦜 Aves del bosque descubiertas: 5\n\n" +
                         "MISIÓN CUMPLIDA: \n" +
                         "Honrar a los Guanes protegiendo su bosque\n" +
                         "y educando a nuevas generaciones.");
        resultados.setFont(new Font("Arial", Font.PLAIN, 16));
        resultados.setBackground(AZUL_CIELO);
        resultados.setEditable(false);
        
        // Mensaje final según desempeño
        JLabel mensajeFinal = new JLabel("", JLabel.CENTER);
        mensajeFinal.setFont(new Font("Arial", Font.BOLD, 18));
        
        if (puntos >= 20) {
            mensajeFinal.setText("🏆 ¡ERES UN GUARDIÁN GUANE DEL BOSQUE! 🏆");
            mensajeFinal.setForeground(ORO_SOL);
        } else {
            mensajeFinal.setText("🌱 El camino del conocimiento Guane continúa...");
            mensajeFinal.setForeground(VERDE_GUANE);
        }
        
        // Botones finales
        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.setBackground(AZUL_CIELO);
        
        JButton btnReiniciar = crearBoton("🔄 Iniciar nuevo viaje", VERDE_GUANE);
        JButton btnSalir = crearBoton("🚪 Salir del bosque", MARRON_TIERRA);
        
        btnReiniciar.addActionListener(e -> reiniciarJuego());
        btnSalir.addActionListener(e -> System.exit(0));
        
        panelBotones.add(btnReiniciar);
        panelBotones.add(btnSalir);
        
        panelFinal.add(titulo, BorderLayout.NORTH);
        panelFinal.add(panelImagenesFinal, BorderLayout.CENTER);
        panelFinal.add(resultados, BorderLayout.SOUTH);
        panelFinal.add(mensajeFinal, BorderLayout.AFTER_LAST_LINE);
        panelFinal.add(panelBotones, BorderLayout.AFTER_LAST_LINE);
        
        panelFinal.revalidate();
        panelFinal.repaint();
    }
    
    private void reiniciarJuego() {
        puntos = 0;
        esGuardian = false;
        arbolActual = 0;
        cardLayout.show(panelPrincipal, "bienvenida");
    }
    
    private JButton crearBoton(String texto, Color color) {
        JButton boton = new JButton(texto);
        boton.setBackground(color);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Arial", Font.BOLD, 14));
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return boton;
    }
    
    private JButton crearBotonGrande(String texto) {
        JButton boton = new JButton("<html><center>" + texto.replace("\n", "<br>") + "</center></html>");
        boton.setBackground(VERDE_GUANE);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Arial", Font.BOLD, 16));
        boton.setPreferredSize(new Dimension(250, 100));
        boton.setFocusPainted(false);
        return boton;
    }
    
    private void mostrarMensajeDespedida() {
        JOptionPane.showMessageDialog(ventana, 
            "💔 El bosque ancestral suspira...\n\n" +
            "\"Los Guanes esperaremos tu regreso\", murmuran los árboles.\n\n" +
            "El Bioparque Guane siempre estará aquí,\n" +
            "guardando la sabiduría para cuando estés listo.", 
            "Hasta Pronto, Explorador", 
            JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AventuraGraficaGuane();
        });
    }
}