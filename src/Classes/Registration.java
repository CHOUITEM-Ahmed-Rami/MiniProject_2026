package Classes;

public class Registration {
    public int registrationId;
    public String registrationDate;
    public String status;
    public Student student;
    public Event event;

    public Registration(int registrationId, String registrationDate,
            String status, Student student, Event event) {
        this.registrationId = registrationId;
        this.registrationDate = registrationDate;
        this.status = status;
        this.student = student;
        this.event = event;
    }

    public void confirmRegistration() {
        if (event.isFull()) {
            System.out.println("Event is full!");
            status = "Rejected";
            return;
        }

        boolean ok = student.registerToEvent(event);
        if (ok) {
            event.addStudent(student);
            status = "Confirmed";
            System.out.println(student.name + " registered in " + event.title);
        } else {
            status = "Conflict";
        }
    }

    public void cancelRegistration() {
        if (status.equals("Confirmed")) {
            event.students.remove(student);
            student.registeredEvents.remove(event);
            status = "Cancelled";
            System.out.println("Cancelled for " + student.name);
        }
    }

    public void displayRegistration() {
        System.out.println("Registration #" + registrationId);
        System.out.println("Student: " + student.name);
        System.out.println("Event: " + event.title);
        System.out.println("Status: " + status);
    }
}