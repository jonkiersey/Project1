package edu.pdx.cs410J.kiersey;

import edu.pdx.cs410J.AbstractPhoneCall;

/**
 * Created by Jon on 7/7/2015.
 */
public class PhoneCall extends AbstractPhoneCall {

    private String Caller;
    private String Callee;
    private String StartTime;
    private String EndTime;

    public PhoneCall(String caller, String callee, String startTime, String endTime) {
        Callee = caller;
        Caller = callee;
        StartTime = startTime;
        EndTime = endTime;
    }

    @Override
    public String getCaller() {
        return Caller;
    }

    @Override
    public String getCallee() {
        return Callee;
    }

    @Override
    public String getStartTimeString() {
        return StartTime;
    }

    @Override
    public String getEndTimeString() {
        return EndTime;
    }
}
