package com.company;

import java.util.Comparator;

    public class CustomerCompareByLastName implements Comparator<Customer> {
        @Override
        public int compare(Customer o1, Customer o2) {
            return o1.LastName.compareTo(o2.LastName);
        }

    }

