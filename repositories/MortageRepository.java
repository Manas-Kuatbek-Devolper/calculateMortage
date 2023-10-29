package kz.mortgage.percent.repositories;

import kz.mortgage.percent.entity.Mortage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MortageRepository extends JpaRepository<Mortage,Long> {

}
