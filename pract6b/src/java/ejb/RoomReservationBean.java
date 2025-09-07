package ejb;

import jakarta.ejb.Stateless;
import java.util.HashMap;
import java.util.Map;

@Stateless
public class RoomReservationBean {

    private static Map<Integer, String> rooms = new HashMap<>();

    static {
        rooms.put(101, "Available");
        rooms.put(102, "Available");
        rooms.put(103, "Available");
    }

    public String reserveRoom(int roomId) {
        if (rooms.containsKey(roomId)) {
            if (rooms.get(roomId).equals("Available")) {
                rooms.put(roomId, "Reserved");
                return "Room " + roomId + " reserved successfully!";
            } else {
                return "Room " + roomId + " is already reserved!";
            }
        } else {
            return "Room not found!";
        }
    }

    public String checkRoomStatus(int roomId) {
        return rooms.getOrDefault(roomId, "Room not found!");
    }
}
