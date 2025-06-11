package thaohn.accountservice.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import thaohn.accountservice.model.StatisticDTO;

// Feign Client
@FeignClient(name = "statistic-service", url = "http://localhost:9099", fallback = StatisticServiceImpl.class)
public interface StatisticService {
    @PostMapping(value = "/statistic", consumes = "application/json", produces = "application/json")
    StatisticDTO addStatistic(@RequestBody StatisticDTO statisticDTO);
}

// Fallback Implementation
@Component
class StatisticServiceImpl implements StatisticService {
    private static final Logger logger = LoggerFactory.getLogger(StatisticServiceImpl.class);

    @Override
    public StatisticDTO addStatistic(StatisticDTO statisticDTO) {
        logger.error("Fallback: statistic-service is unavailable or slow.");
        // Có thể return null hoặc giá trị mặc định
        return null;
    }
}
