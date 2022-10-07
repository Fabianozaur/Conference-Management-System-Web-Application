package sdi.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sdi.cms.model.conference.Room;
import sdi.cms.service.RoomService;

import java.util.List;

@RestController
public class RoomController {
    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @RequestMapping(value = "/rooms", method = RequestMethod.POST)
    public Room addRoom(@RequestBody final Room room) {
        return roomService.addRoom(room);
    }
}
