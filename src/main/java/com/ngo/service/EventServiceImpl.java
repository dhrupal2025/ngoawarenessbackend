
package com.ngo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngo.model.Event;
import com.ngo.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository repository;


    // =====================================================
    // SAVE EVENT
    // =====================================================
    @Override
    public Event saveEvent(Event event) {

        return repository.save(event);
    }


    // =====================================================
    // GET ALL EVENTS
    // =====================================================
    @Override
    public List<Event> getAllEvents() {

        return repository.findAll();
    }


    // =====================================================
    // GET EVENT BY ID
    // =====================================================
    @Override
    public Event getEventById(Long id) {

        return repository.findById(id).orElse(null);
    }


    // =====================================================
    // DELETE EVENT
    // =====================================================
    @Override
    public void deleteEvent(Long id) {

        repository.deleteById(id);
    }
}

