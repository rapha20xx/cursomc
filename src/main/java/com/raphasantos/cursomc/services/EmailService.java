package com.raphasantos.cursomc.services;

import com.raphasantos.cursomc.domain.Pedido;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

   void sendOrderConfirmationEmail(Pedido obj);
   void sendEmail(SimpleMailMessage msg);

}
