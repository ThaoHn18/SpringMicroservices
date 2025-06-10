package thaohn.statisticservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import thaohn.statisticservice.model.StatisticDTO;
import thaohn.statisticservice.service.StatisticService;

import java.util.List;

@RestController
@RequestMapping("statistic")
@Slf4j
public class StatisticController {
    Logger logger = LoggerFactory.getLogger(StatisticController.class);
    @Autowired
    private StatisticService statisticService;

    @PostMapping()
    public StatisticDTO addStatistic(@RequestBody StatisticDTO statisticDTO) {
        logger.info("addStatistic");
        statisticService.add(statisticDTO);
        return statisticDTO;
    }

    @GetMapping()
    public List<StatisticDTO> getAllStatistics() {
        logger.info("getAllStatistics");

        return statisticService.getAll();
    }

}
