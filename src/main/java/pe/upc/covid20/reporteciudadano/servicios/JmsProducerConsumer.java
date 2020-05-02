package com.upc.curso.jms;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsProducerConsumer {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${jms.cola.envio}")
    String destinationQueue;

    @Value("${jms.cola.respuesta}")
    String responseQueue;

    public void enviarRecibir(String msg) {
        String id = UUID.randomUUID().toString();//
        jmsTemplate.convertAndSend(destinationQueue, msg, m -> {
            m.setJMSCorrelationID(id);
            return m;
        });
        System.out.println("RIPLEY: Enviando " + msg);
        System.out.println("RIPLEY: Enviando con CorrId: " + id);
        //espera respuesta solo de un mensaje cuyo corrId es el mismo del que envió
        //jmsTemplate.setReceiveTimeout(1000);
        String responseMessage = (String) jmsTemplate
                .receiveSelectedAndConvert(responseQueue,
                        "JMSCorrelationID='" + id + "'");
        System.out.println("RIPLEY RESPUESTA:" + responseMessage);
        System.out.println("RIPLEY RESPUESTA CORR ID:" + id);
    }

}
