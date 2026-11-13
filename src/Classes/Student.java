package Classes;

import java.util.ArrayList;

public class Student extends Person {
    public String level;
    public String department;
    public ArrayList<Event> registeredEvents = new ArrayList<>();

    public Student(int id, String name, String email, String level, String department) {
        super(id, name, email);
        this.level = level;
        this.department = department;
    }

    public boolean registerToEvent(Event e) {
        for (Event registered : registeredEvents) {
            if (e.hasConflict(registered)) {
                System.out.println("Conflict for " + name +
                        " between " + registered.title + " and " + e.title);
                return false;
            }
        }
        registeredEvents.add(e);
        return true;
    }

    public void displayMyEvents() {
        System.out.println("Events for " + name + ":");
        for (Event e : registeredEvents) {
            System.out.println(" - " + e.title + " on " + e.date);
        }
    }

    public void mainTest() {
        displayInfo();
        System.out.println("Level: " + level + ", Department: " + department);
    }
}