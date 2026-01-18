package predictor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.WebApplicationType; // <--- Asegúrate de que este import esté

@SpringBootApplication
public class PaginaWebJavaApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(PaginaWebJavaApplication.class);

        // Esta línea es la que soluciona tu error específico:
        app.setWebApplicationType(WebApplicationType.SERVLET);

        app.run(args);
    }
}