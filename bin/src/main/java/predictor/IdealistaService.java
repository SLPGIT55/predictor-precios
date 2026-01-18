package predictor;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class IdealistaService {

    private final WebClient webClient;

    public IdealistaService() {
        this.webClient = WebClient.create("https://api.idealista.com");
    }

    public double obtenerPrecioPorCodigoPostal(String cp) {
        // Ejemplo de lógica basada en CP:
        if (cp.startsWith("28")) return 4200.0; // Media de Madrid
        if (cp.startsWith("08")) return 3900.0; // Media de Barcelona
        if (cp.startsWith("41")) return 2100.0; // Media de Sevilla

        return 1800.0; // Resto de España
    }
}