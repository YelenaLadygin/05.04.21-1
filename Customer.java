package com.company;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@Getter
@Setter
public class Customer implements Comparable <Customer>{

    // POJO
        public int Id;
        public String FirstName;
        public String LastName;
        public int NumberofOrder;
        public int hight;

    public Customer(int id, String firstName, String lastName, int NumberofOrder, int hight) {
        Id = id;
        FirstName = firstName;
        LastName = lastName;
        this.NumberofOrder = NumberofOrder;
        this.hight = hight;
    }

    @Override
    public int compareTo(Customer o) {
        return this.Id - o.Id;
    }
}
