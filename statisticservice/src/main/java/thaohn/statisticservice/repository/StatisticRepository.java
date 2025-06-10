package thaohn.statisticservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thaohn.statisticservice.entity.Statistic;

public interface StatisticRepository extends JpaRepository<Statistic, Long> {
}
