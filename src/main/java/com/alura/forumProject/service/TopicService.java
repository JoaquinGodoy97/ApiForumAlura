package com.alura.forumProject.service;

import com.alura.forumProject.model.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TopicService {
    Page<Topic> getAllTopics(Pageable thePageable);

    Topic findById(Long id);

    Topic updateTopic(Long id, Topic topic);

    void deleteTopic(Topic topic);

    void createTopic(Topic topic);
}
