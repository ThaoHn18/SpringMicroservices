package thaohn.accountservice.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import thaohn.accountservice.model.StatisticDTO;

@FeignClient(name = "statistic-service", url = "http://localhost:9099")
public interface StatisticService {
    @PostMapping(value = "/statistic")
    StatisticDTO addStatistic(@RequestBody StatisticDTO statisticDTO);
}


