package Classes;

import java.util.ArrayList;

public class Event {
    public String code;
    public String title;
    public String date;
    public int startHour;
    public int endHour;
    public int maxParticipants;

    public Room room;
    public Organizer organizer;

    public ArrayList<Student> students = new ArrayList<>();
    public ArrayList<Equipment> equipments = new ArrayList<>();

    public Event(String code, String title, String date,
            int startHour, int endHour, int maxParticipants) {
        this.code = code;
        this.title = title;
        this.date = date;
        this.startHour = startHour;
        this.endHour = endHour;
        this.maxParticipants = maxParticipants;
    }

    public boolean addStudent(Student s) {
        if (isFull())
            return false;
        students.add(s);
        return true;
    }

    public void addEquipment(Equipment eq, int qty) {
        if (eq.isAvailable(qty)) {
            equipments.add(eq);
        } else {
            System.out.println("Not enough equipment: " + eq.name);
        }
    }

    public void assignRoom(Room r) {
        if (r.canHost(maxParticipants)) {
            this.room = r;
        } else {
            System.out.println("Room too small!");
        }
    }

    public boolean isFull() {
        return students.size() >= maxParticipants;
    }

    public boolean hasConflict(Event other) {
        if (!this.date.equals(other.date))
            return false;
        return this.startHour < other.endHour && this.endHour > other.startHour;
    }

    public void displayDetails() {
        System.out.println("Event Code: " + code);
        System.out.println("Title: " + title);
        System.out.println("Date: " + date);
        System.out.println("Time: " + startHour + " - " + endHour);
        System.out.println("Max Participants: " + maxParticipants);
        System.out.println("Current Participants: " + students.size());
        System.out.println("Remaining: " + (maxParticipants - students.size()));
    }

    public void displayParticipants() {
        System.out.println("Participants in " + title + ":");
        for (Student s : students) {
            System.out.println(" - " + s.name);
        }
    }
}