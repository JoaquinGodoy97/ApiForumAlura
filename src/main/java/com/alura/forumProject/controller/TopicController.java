package com.alura.forumProject.controller;

import com.alura.forumProject.model.Topic;
import com.alura.forumProject.service.TopicService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/topic/")
@SecurityRequirement(name = "bearer-key")
public class TopicController {

    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping
    public Page<Topic> getAllTopics(@PageableDefault(size = 10) Pageable thePagable){
        return topicService.getAllTopics(thePagable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topic> getTopicByID(@PathVariable Long id){
        Topic topic = topicService.findById(id);
        return ResponseEntity.ok(topic);
    }

    @PostMapping
    public ResponseEntity<Topic> createTopic(@RequestBody Topic topicData){
        topicService.createTopic(topicData);
        return ResponseEntity.ok(topicData);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Topic> updateTopic(@PathVariable Long id, @RequestBody Topic topic) {
        Topic updated = topicService.updateTopic(id, topic);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        Topic foundTopic = topicService.findById(id);
        topicService.deleteTopic(foundTopic);
        return ResponseEntity.noContent().build();
    }

}
