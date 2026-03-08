package com.alura.forumProject.service;

import com.alura.forumProject.exception.TopicNotFoundException;
import com.alura.forumProject.model.Topic;
import com.alura.forumProject.repository.TopicRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicServiceImp implements TopicService{

    private final TopicRepository topicRepository;

    public TopicServiceImp(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public Page<Topic> getAllTopics(Pageable thePageable) {
        return topicRepository.findAll(thePageable);
    }

    @Override
    public Topic findById(Long id) {
        return topicRepository.findById(id)
                .orElseThrow(() -> new TopicNotFoundException("Topic not found."));
    }

    @Override
    public Topic updateTopic(Long id, Topic updateTopic) {
        Optional<Topic> existing = topicRepository.findById(id);

        if (!existing.isPresent()) {
            throw new TopicNotFoundException("Topic not found.");
        }

        var existingTopic = existing.get();

        existingTopic.setAuthor(updateTopic.getAuthor());
        existingTopic.setMessage(updateTopic.getMessage());
        existingTopic.setStatus(updateTopic.getStatus());
        existingTopic.setTitle(updateTopic.getTitle());
        existingTopic.setSubject(updateTopic.getSubject());
        existingTopic.setCreationDate(updateTopic.getCreationDate());

        return topicRepository.save(existingTopic);
    }

    @Override
    public void deleteTopic(Topic topic) {
        topicRepository.delete(topic);
    }

    @Override
    public void createTopic(Topic topic) {
        topicRepository.save(topic);
    }
}
