package com.example.demo.service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Message;
import com.example.demo.repository.MessageRepository;

@Service
public class MessageService {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(MessageService.class);

	@Autowired
	private MessageRepository messageRepository;

	public Message createMessage(Message message) {

		LOGGER.debug("Debug Message");
		LOGGER.info("Info Message");
		LOGGER.warn("Warning Message");
		LOGGER.error("Error message");

		message.setId(UUID.randomUUID().toString());
		message.setDeleted(false);
		message.setCreatedAt(Calendar.getInstance().getTime());

		return messageRepository.save(message);
	}

	public Message updateMessage(String id, Message message) {

		return messageRepository.save(message);
	}

	public Optional<Message> getMessage(String id) {

		return messageRepository.findById(id);
	}

	public List<Message> listMessages() {

		return messageRepository.findAll();
	}

	public void deleteMessage() {

		messageRepository.delete(null);
	}
}
