package mainAPI.service;

import mainAPI.model.Event;
import mainAPI.model.EventLocation;
import mainAPI.model.RegistrationEvent;
import mainAPI.model.User;
import mainAPI.repository.RegistrationEventRepository;
import mainAPI.repository.EventLocationRepository;
import mainAPI.repository.EventRepository;
import mainAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cbadea on 4/2/2018.
 */

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    RegistrationEventRepository registrationEventRepository;

    @Autowired
    EventLocationRepository eventLocationRepository;

    @Autowired
    UserRepository userRepository;

    public Event applyOnEvent(Event event, int userId, int locationId) {
        User user = userRepository.findOne(userId);
//        List<Event> userEvents = user.getEvents();
//        userEvents.add(event);
//        user.setEvents(userEvents);

//        List<User> users = event.getUsers();
//        if (users == null) {
//            users = new ArrayList<>();
//        }
//        users.add(user);
//        event.setUsers(users);

        EventLocation eventLocation = eventLocationRepository.findById(locationId);
        event.setEventLocation(eventLocation);

        return eventRepository.save(event);
    }

    public Event addEvent(Event event, int locationId) {
        EventLocation el =  eventLocationRepository.findById(locationId);
        event.setEventLocation(el);
        return eventRepository.save(event);
    }

    public void deleteEvent(int eventId) {
        Event event =  eventRepository.findOne(eventId);
        eventRepository.delete(event);
    }
}

