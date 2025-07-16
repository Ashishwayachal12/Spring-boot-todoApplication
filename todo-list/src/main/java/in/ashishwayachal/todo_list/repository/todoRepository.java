package in.ashishwayachal.todo_list.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashishwayachal.todo_list.entity.Todo;

public interface todoRepository  extends JpaRepository<Todo, Long>{

}
