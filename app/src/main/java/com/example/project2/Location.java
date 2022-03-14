package com.example.project2;

public class Location
{
    private String name;
    private float latitude;
    private float longitude;
    private Event[] events;

    public Location(String name, float latitude, float longitude)
    {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName()
    {
        return name;
    }

    public float getLatitude()
    {
        return latitude;
    }

    public float getLongitude()
    {
        return longitude;
    }

    public Event[] getEvents()
    {
        return events;
    }

    public void setName(String str)
    {
        name = str;
    }

    public void setLatitude(float num)
    {
        latitude = num;
    }

    public void setLongitude(float num)
    {
        longitude = num;
    }

    public void addEvent(Event event)
    {
        events.add(event);
    }

    public void removeEvent(Event event)
    {
        int index = events.indexOf(event);
        events.remove(index);
    }
}
