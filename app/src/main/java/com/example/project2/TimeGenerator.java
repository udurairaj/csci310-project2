package com.example.project2;

import java.io.Serializable;

public class TimeGenerator implements Serializable
{
    private TimeSlot[] timeSlots;
    private Event event;

    public TimeGenerator(Event event) // constructor
    {
        this.event = event;
    }

    public TimeSlot[] getTimeSlots()
    {
        return timeSlots;
    }

    public TimeSlot generate()
    {
        // LATER
        return null;
    }
}
