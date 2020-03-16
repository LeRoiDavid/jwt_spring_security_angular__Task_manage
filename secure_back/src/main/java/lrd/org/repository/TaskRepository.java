package lrd.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lrd.org.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
		
}
