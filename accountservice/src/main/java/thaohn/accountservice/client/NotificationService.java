package thaohn.accountservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import thaohn.accountservice.model.MessageDTO;

@FeignClient(name = "notification-service", url = "http://localhost:9077")
public interface NotificationService {

    @PostMapping("/send-notification")
    public void sendNotification(@RequestBody MessageDTO messageDTO);
}
