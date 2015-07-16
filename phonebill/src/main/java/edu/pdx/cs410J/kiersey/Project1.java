package edu.pdx.cs410J.kiersey;

import edu.pdx.cs410J.AbstractPhoneBill;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The main class for the CS410J Phone Bill Project
 */
public class Project1 {

  public static void main(String[] args) {
    Class c = AbstractPhoneBill.class;  // Refer to one of Dave's classes so that we can be sure it is on the classpath
    if(args.length != 1 && args.length != 7 && args.length != 8) {
      System.err.println("Missing command line arguments");
      System.exit(0);
    }
    if(args.length == 1) {
      if(args[0] == "-README") {
        System.out.println("This program creates a phone bill for a customer with one phone call specified by the user.");
        System.out.println("Usage: <customer> <caller> <callee> <start time> <end time>");
        System.exit(1);
      }
      else {
        System.err.println("Missing command line arguments");
        System.exit(0);
      }
    }
    boolean error = false;
    /*
    for (String arg : args) {
      System.out.println(arg);
    }
    */
    String name = args[0];

    Pattern phoneNumberPattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
    Matcher match = phoneNumberPattern.matcher(args[1]);
    if(!match.find()) {
      System.err.println("Incorrect caller number format: " + args[1]);
      error = true;
    }
    match = phoneNumberPattern.matcher(args[2]);
    if(!match.find()) {
      System.err.println("Incorrect callee number format: " + args[2]);
      error = true;
    }

    String caller = args[1];
    String callee = args[2];


    Pattern datePattern = Pattern.compile("\\d?\\d/\\d?\\d/\\d\\d\\d\\d");
    match = datePattern.matcher(args[3]);
    if(!match.find()) {
      System.err.println("Incorrect start date format: " + args[3]);
      error = true;
    }
    match = datePattern.matcher(args[5]);
    if(!match.find()) {
      System.err.println("Incorrect end date format: " + args[5]);
      error = true;
    }

    Pattern timePattern = Pattern.compile("\\d{1,2}:\\d{2}");
    match = timePattern.matcher(args[4]);
    if(!match.find()) {
      System.err.println("Incorrect start time format: " + args[2]);
      error = true;
    }
    match = timePattern.matcher(args[6]);
    if(!match.find()) {
      System.err.println("Incorrect end time format: " + args[4]);
      error = true;
    }
    String startTime = args[3] + args[4];
    String endTime = args[5] + args[6];
    if(error) {
      System.exit(0);
    }

    PhoneBill myPhoneBill = new PhoneBill(name);
    PhoneCall myPhoneCall = new PhoneCall(caller, callee, startTime, endTime);
    myPhoneBill.addPhoneCall(myPhoneCall);

    if(args.length == 8)
      if(args[7].equals("-print"))
        myPhoneBill.printBill();


    System.exit(1);
  }

}