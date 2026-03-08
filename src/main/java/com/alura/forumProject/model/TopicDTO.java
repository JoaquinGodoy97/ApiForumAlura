package com.alura.forumProject.model;

public record TopicDTO(
        Long id,
        String title,
        String message,
        String author
) {
    public TopicDTO(Topic topic) {
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getAuthor());
    }
}