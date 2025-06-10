package thaohn.statisticservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import thaohn.statisticservice.entity.Statistic;
import thaohn.statisticservice.model.StatisticDTO;
import thaohn.statisticservice.repository.StatisticRepository;
import thaohn.statisticservice.service.StatisticService;

import java.util.ArrayList;
import java.util.List;
@Transactional
@Service
public class StatisticServiceImpl  implements StatisticService {
    @Autowired
    StatisticRepository statisticRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public void add(StatisticDTO statisticDTO) {
        Statistic statistic = modelMapper.map(statisticDTO, Statistic.class);
        statisticRepository.save(statistic);

    }

    @Override
    public List<StatisticDTO> getAll() {
        List<StatisticDTO> statisticDTOs = new ArrayList<>();
        statisticRepository.findAll().forEach(statisticDTO -> {
            statisticDTOs.add(modelMapper.map(statisticDTO, StatisticDTO.class));
        });
        return statisticDTOs;
    }
}
