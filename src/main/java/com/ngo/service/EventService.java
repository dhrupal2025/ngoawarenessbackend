
package com.ngo.service;

import java.util.List;

import com.ngo.model.Event;

public interface EventService {

    // Add / Save Event
    Event saveEvent(Event event);

    // Get All Events
    List<Event> getAllEvents();

    // Get Event By ID
    Event getEventById(Long id);

    // Delete Event
    void deleteEvent(Long id);
}

