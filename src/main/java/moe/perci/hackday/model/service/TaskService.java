package moe.perci.hackday.model.service;

import moe.perci.hackday.model.Task;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TaskService extends PagingAndSortingRepository<Task, Long> {
    List<Task> findTasksByUserProvince(String _province);
    Task findTaskById(int id);
}
