package edu.pdx.cs410J.kiersey;

import edu.pdx.cs410J.AbstractPhoneBill;
import edu.pdx.cs410J.AbstractPhoneCall;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Jon on 7/7/2015.
 */
public class PhoneBill extends AbstractPhoneBill {

    private static int SIZE = 10;

    private String CustName;
    //private PhoneCall[] CallList = new PhoneCall[SIZE];
    private List<AbstractPhoneCall> CallList = new ArrayList<AbstractPhoneCall>();

    public PhoneBill(String custName) {
        CustName = custName;
    }

    @Override
    public String getCustomer() {
        return CustName;
    }

    @Override
    public void addPhoneCall(AbstractPhoneCall toAdd) {
        CallList.add(toAdd);
    }

    @Override
    public Collection getPhoneCalls() {
        if(CallList.isEmpty()) return null;
        return CallList;
    }

    public void printBill() {
        if(null == CustName) {
            System.err.print("Customer name is empty.");
            System.exit(0);
        }
        if(CallList.isEmpty()) {
            System.out.println("Call list is empty.");
        }
        else {
            System.out.println(CustName);
            for(int i=0; i<CallList.size(); ++i){
                System.out.println(CallList.get(i).toString());
            }
        }
    }
}
