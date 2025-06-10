package thaohn.statisticservice.service;

import thaohn.statisticservice.model.StatisticDTO;

import java.util.List;

public interface StatisticService {
    void add(StatisticDTO statisticDTO);

    List<StatisticDTO> getAll();
}
