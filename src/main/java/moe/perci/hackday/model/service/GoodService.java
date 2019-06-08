package moe.perci.hackday.model.service;

import moe.perci.hackday.model.Good;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodService extends JpaRepository<Good, Long> {
    List<Good> findGoodsByTypeAndStatus(int type, int status);
    Good findGoodById(int id);
}
