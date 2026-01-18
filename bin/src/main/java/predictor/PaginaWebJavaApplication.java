package predictor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class PaginaWebJavaApplication {

    @Autowired
    private CalculadoraPrecioService calculadora;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(PaginaWebJavaApplication.class);
        // Forzamos el tipo de aplicación a SERVLET para asegurar que arranque Tomcat
        app.setWebApplicationType(WebApplicationType.SERVLET);
        app.run(args);
    }

    // Ruta para cargar la página principal
    @GetMapping("/")
    public String bienvenida() {
        return "index";
    }

    // Ruta para procesar el formulario de predicción
    @PostMapping("/predecir")
    public String predecir(@RequestParam String codigoPostal, // <-- Cambiado
                           @RequestParam int metros,
                           @RequestParam(defaultValue = "0") int habitaciones,
                           Model model) {

        // Ahora pasamos el código postal a la calculadora
        double precioFinal = calculadora.calcularPrediccion(metros, habitaciones, codigoPostal);

        String mensaje = "Estimación para el CP " + codigoPostal + ": " + String.format("%,.2f", precioFinal) + " €";
        model.addAttribute("resultado", mensaje);
        return "index";
    }
}