package bitc.fullstack405.server_intravel.service;

import bitc.fullstack405.server_intravel.entity.TodoEntity;
import bitc.fullstack405.server_intravel.repository.TodoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

  private final TodoRepository todoRepository;

  public List<TodoEntity> listAll(Long travId) {
    return todoRepository.findByTravId(travId);
  }

  public TodoEntity save(Long travId, TodoEntity todoEntity) {
    todoEntity.setTravId(travId);
    return todoRepository.save(todoEntity);
  }

  @Transactional
  public TodoEntity update(Long todoId, TodoEntity todoEntity) {
    TodoEntity updateTodo = todoRepository.findByTodoIdAndTravId(todoEntity.getTodoId(), todoId);

    updateTodo.setTodoImpo(todoEntity.getTodoImpo());
    updateTodo.setTodoContent(todoEntity.getTodoContent());

    return updateTodo;
  }

  public void deleteByTodoId(Long todoId) {
    todoRepository.deleteById(todoId);
  }

//  public List<TodoEntity> listUncomp(Long travelId) {
//    char complete = 'N';
//    return todoRepository.findByTravIdAndTodoComplete(travelId, complete);
//  }

  public List<TodoEntity> listIsComplete(Long travelId, char isComplete) {
    return todoRepository.findByTravIdAndTodoComplete(travelId, isComplete);
  }

//  public List<TodoEntity> listUncomp(Long travelId, char comp) {
////    char complete = 'N';
//    return todoRepository.findByTravelIdAndTdComplete(travelId, comp);
//  }

//  public List<TodoEntity> listComp(Long travelId) {
//    char complete = 'Y';
//    return todoRepository.findByTravelIdAndTdComplete(travelId, complete);
//  }
}
