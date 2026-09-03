package com.ngo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.ngo.model.Event;
import com.ngo.service.EventService;

@RestController
@RequestMapping("/api/events")
@CrossOrigin(
    origins = "http://localhost:5174",
    methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE,
        RequestMethod.OPTIONS
    }
)
public class EventController {

    @Autowired
    private EventService service;


    // =====================================================
    // ADD EVENT
    // =====================================================

    @PostMapping
    public ResponseEntity<?> save(
            @RequestParam("title") String title,
            @RequestParam("date") String date,
            @RequestParam("location") String location,
            @RequestParam("image") MultipartFile image
    ) {

        try {

            Event event = new Event();

            event.setTitle(title);
            event.setDate(date);
            event.setLocation(location);


            // =================================================
            // SAVE IMAGE
            // =================================================

            if (image != null && !image.isEmpty()) {

                event.setImage(image.getBytes());

                event.setImageType(
                    image.getContentType()
                );
            }


            Event savedEvent =
                    service.saveEvent(event);

            return ResponseEntity.ok(savedEvent);

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity
                    .internalServerError()
                    .body(
                        "Unable to add event: "
                        + e.getMessage()
                    );
        }
    }


    // =====================================================
    // GET ALL EVENTS
    // =====================================================

    @GetMapping
    public ResponseEntity<List<Event>> getAll() {

        return ResponseEntity.ok(
            service.getAllEvents()
        );
    }


    // =====================================================
    // GET EVENT BY ID
    // =====================================================

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(
            @PathVariable Long id
    ) {

        Event event =
                service.getEventById(id);

        if (event == null) {

            return ResponseEntity
                    .notFound()
                    .build();
        }

        return ResponseEntity.ok(event);
    }


    // =====================================================
    // UPDATE EVENT
    // =====================================================

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,

            @RequestParam("title")
            String title,

            @RequestParam("date")
            String date,

            @RequestParam("location")
            String location,

            @RequestParam(
                value = "image",
                required = false
            )
            MultipartFile image
    ) {

        try {

            Event existingEvent =
                    service.getEventById(id);


            // =================================================
            // CHECK EVENT
            // =================================================

            if (existingEvent == null) {

                return ResponseEntity
                        .notFound()
                        .build();
            }


            // =================================================
            // UPDATE TEXT DATA
            // =================================================

            existingEvent.setTitle(title);

            existingEvent.setDate(date);

            existingEvent.setLocation(location);


            // =================================================
            // UPDATE IMAGE
            // =================================================

            /*
             * If user selects a new image,
             * replace the old image.
             *
             * If user does not select an image,
             * keep the existing image.
             */

            if (image != null && !image.isEmpty()) {

                existingEvent.setImage(
                    image.getBytes()
                );

                existingEvent.setImageType(
                    image.getContentType()
                );
            }


            // =================================================
            // SAVE UPDATED EVENT
            // =================================================

            Event updatedEvent =
                    service.saveEvent(existingEvent);


            return ResponseEntity.ok(
                updatedEvent
            );

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity
                    .internalServerError()
                    .body(
                        "Unable to update event: "
                        + e.getMessage()
                    );
        }
    }


    // =====================================================
    // DELETE EVENT
    // =====================================================

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(
            @PathVariable Long id
    ) {

        try {

            Event existingEvent =
                    service.getEventById(id);


            if (existingEvent == null) {

                return ResponseEntity
                        .notFound()
                        .build();
            }


            service.deleteEvent(id);


            return ResponseEntity.ok(
                "Event deleted successfully"
            );

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity
                    .internalServerError()
                    .body(
                        "Unable to delete event: "
                        + e.getMessage()
                    );
        }
    }


    // =====================================================
    // EVENT COUNT
    // =====================================================

    @GetMapping("/count")
    public long getCount() {

        return service.getAllEvents().size();
    }
}

