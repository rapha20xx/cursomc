package com.raphasantos.cursomc.services;

import com.raphasantos.cursomc.domain.Pedido;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import java.util.Date;

public abstract class AbstractEmailService implements EmailService {

    @Value("$default.sender")
    private String sender;

    @Override
    public void sendOrderConfirmationEmail(Pedido obj){
        SimpleMailMessage sm =  prepareSimplemailMessageFromPedido(obj);
        sendEmail(sm);
    }

    protected SimpleMailMessage prepareSimplemailMessageFromPedido(Pedido obj){
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(obj.getCliente().getEmail());
        sm.setFrom(sender);
        sm.setSubject("Pedido confirmado! Código do pedido: " + obj.getId());
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText(obj.toString());
        return sm;
    }
}
