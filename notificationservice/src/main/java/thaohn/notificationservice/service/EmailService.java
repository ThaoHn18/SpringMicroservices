package thaohn.notificationservice.service;

import thaohn.notificationservice.model.MessageDTO;

public interface EmailService {
    void sendEmail(MessageDTO messageDTO);
}
