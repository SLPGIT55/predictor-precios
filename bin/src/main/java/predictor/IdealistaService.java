package predictor;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class IdealistaService {
    private final WebClient webClient;

    public IdealistaService() {
        this.webClient = WebClient.create("https://api.idealista.com");
    }

    public String obtenerPrecio(String zona) {
        // Aquí irá la lógica para llamar a la API con tu clave
        return "Precio estimado en " + zona + ": 250.000€";
    }
}