package moe.perci.hackday.model.service;

import moe.perci.hackday.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskService extends JpaRepository<Task, Long> {
}
