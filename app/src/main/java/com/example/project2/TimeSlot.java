package com.example.project2;

public class TimeSlot
{
    // data members
    private int startTime;
    private int endTime;

    // constructor
    public TimeSlot(int startTime, int endTime)
    {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStart()
    {
        return startTime;
    }

    public void setStart(int st)
    {
        startTime = st;
    }

    public int getEnd()
    {
        return endTime;
    }

    public void setEnd(int et)
    {
        endTime = et;
    }

    public void select()
    {
        // LATER
    }

    public void deselect()
    {
        // LATER
    }
}
