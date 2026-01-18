package predictor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraPrecioService {

    @Autowired
    private IdealistaService idealistaService;

    public double calcularPrediccion(int metros, int habitaciones, String codigoPostal) {
        // La API de Idealista usa el CP para buscar los anuncios de esa zona exacta
        double precioM2Real = idealistaService.obtenerPrecioPorCodigoPostal(codigoPostal);

        double resultado = (metros * precioM2Real) + (habitaciones * 5000);
        return resultado;
    }
}
