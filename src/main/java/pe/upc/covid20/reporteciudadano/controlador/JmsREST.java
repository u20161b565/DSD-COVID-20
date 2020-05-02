package pe.upc.covid20.reporteciudadano.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.upc.covid20.reporteciudadano.servicios.JmsProducerConsumer;

@RestController
@RequestMapping("/api")
public class JmsREST {
    @Autowired
    private JmsProducerConsumer jmsProducer;

    @GetMapping("/enviar/{mensaje}")
    public String enviar(@PathVariable(value = "mensaje") String mensaje) {
        jmsProducer.enviarRecibir(mensaje);
        return "OK!";
    }

}
