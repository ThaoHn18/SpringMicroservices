package thaohn.accountservice.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import thaohn.accountservice.model.MessageDTO;

// Feign Client
@FeignClient(name = "notification-service", url = "http://localhost:9077", fallback = NotificationServiceImpl.class)
public interface NotificationService {
    @PostMapping("/send-notification")
    void sendNotification(@RequestBody MessageDTO messageDTO);
}

// Fallback
@Component
class NotificationServiceImpl implements NotificationService {
    private static final Logger logger = LoggerFactory.getLogger(NotificationServiceImpl.class);

    @Override
    public void sendNotification(MessageDTO messageDTO) {
        logger.error("Fallback: notification-service is unavailable or slow.");
        // Không cần return gì cả vì method là void
    }
}
