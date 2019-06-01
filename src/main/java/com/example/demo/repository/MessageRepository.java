package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.domain.Message;

public interface MessageRepository extends MongoRepository<Message, String> {

	Message findByIdAndDeletedFalse(String id);
}
