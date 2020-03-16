package lrd.org.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lrd.org.entities.Task;
import lrd.org.repository.TaskRepository;

@CrossOrigin("*")
@RestController
public class TaskController {
	@Autowired
	private TaskRepository taskRepository;
	
	@PostMapping("tasks")
	public Task add(@RequestBody Task task) {
		return taskRepository.save(task);
	}
	
	@GetMapping("/tasks")
	public List<Task> findAll(){
		return taskRepository.findAll();
	}
 }
