package com.company;

import java.util.Comparator;


    public class CustomerCompareByOrder implements Comparator<Customer> {
        @Override
        public int compare(Customer o1, Customer o2) {
                return o1.NumberofOrder - o2.getNumberofOrder();
        }
}
