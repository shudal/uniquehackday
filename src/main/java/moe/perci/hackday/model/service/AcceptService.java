package moe.perci.hackday.model.service;

import moe.perci.hackday.model.Accept;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcceptService extends JpaRepository<Accept, Long> {
    List<Accept> findAcceptsByTaskId(int taskId);
}
