package com.example.todo.service.task;

import com.example.todo.controller.task.TodoTag;
import com.example.todo.repository.task.TaskRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.HTML;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    //    Todoアイテムの一覧取得
    @Getter
    private final List<TodoTag> todos = new ArrayList<>();

    public List<TaskEntity> find(TaskSearchEntity searchEntity) {
        return taskRepository.select(searchEntity);
    }

    public Optional<TaskEntity> findById(long taskId) {
        return taskRepository.selectById(taskId);
    }

    @Transactional
    public void create(TaskEntity newEntity) {
        taskRepository.insert(newEntity);
    }

    @Transactional
    public void update(TaskEntity entity) {
        taskRepository.update(entity);
    }

    @Transactional
    public void delete(long id) {
        taskRepository.delete(id);
    }

//    TODOアイテムの追加
    public void addTodo(String title, List<Tag> tags) {
        todos.add(new TodoTag(title, false, tags));
    }

}
