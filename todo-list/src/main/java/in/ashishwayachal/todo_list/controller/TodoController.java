package in.ashishwayachal.todo_list.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import in.ashishwayachal.todo_list.entity.Todo;
import in.ashishwayachal.todo_list.repository.todoRepository;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TodoController {

	private final todoRepository todoRepository;

	
	@GetMapping({ "", "/", "/home" })
	public String showHomePage(Model model) {
		model.addAttribute("todos", todoRepository.findAll());
		return "index";
	}

	
	@PostMapping("/add")
	public String addTodo(@RequestParam String title) {
		if (title != null && !title.trim().isEmpty()) {
			Todo todo = new Todo();
			todo.setTitle(title.trim());
			todo.setCompleted(false);
			todoRepository.save(todo);
		}
		return "redirect:/";
	}

	
	@PostMapping("/delete/{id}")
	public String deleteTodo(@PathVariable Long id) {
		todoRepository.deleteById(id);
		return "redirect:/";
	}

	@PostMapping("/toggle/{id}")
	public String toggleTodo(@PathVariable Long id) {
		todoRepository.findById(id).ifPresent(todo -> {
			todo.setCompleted(!todo.isCompleted());
			todoRepository.save(todo);
		});
		return "redirect:/";
	}
}
