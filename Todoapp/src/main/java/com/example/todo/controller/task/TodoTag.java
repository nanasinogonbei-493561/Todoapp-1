package com.example.todo.controller.task;

import java.util.List;

public record TodoTag(String title, boolean completed, List<Tag> tags) {
}
