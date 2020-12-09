package task3_6;

import java.beans.PersistenceDelegate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

enum SortOrder {
    ASC, DESC;
}

public class AddressBook implements Iterable {
    private NameAddressPair[] addressBook;
    private int counter = 0;

    public AddressBook(int capacity) {
        //
        addressBook = new NameAddressPair[capacity];
    }

    public boolean create(String firstName, String lastName, String address) {
        for (NameAddressPair person : addressBook) {
            if (person != null) {
                if (person.person.firstName.equals(firstName) && person.person.lastName.equals(lastName)) {
                    return false;
                }
            }
        }
        if (counter == addressBook.length) { //check array length, grow twice;
            addressBook = Arrays.copyOf(addressBook, counter * 2);
        }
        addressBook[counter] = new NameAddressPair(new NameAddressPair.Person(firstName, lastName), address);
        counter++;
        return true;
    }

    public String read(String firstName, String lastName) {
        for (NameAddressPair person : addressBook) {
            if (person != null) {
                if (person.person.firstName.equals(firstName) && person.person.lastName.equals(lastName)) {
                    return person.address;
                }
            }
        }
        return null;
    }

    public boolean update(String firstName, String lastName, String address) {
        for (NameAddressPair person : addressBook) {
            if (person != null) {
                if (person.person.firstName.equals(firstName) && person.person.lastName.equals(lastName)) {
                    person.address = address;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean delete(String firstName, String lastName) {
        boolean flag = false;
        int ind = 0;
        for (int i = 0; i < addressBook.length; i++) {
            if (addressBook[i] != null) {
                if (addressBook[i].person.firstName.equals(firstName) && addressBook[i].person.lastName.equals(lastName)) {
                    addressBook[i] = null;
                    ind = i;
                    flag = true;
                    break;
                }
            }
        }
        if (flag) {
            if (ind < addressBook.length) {
                for (int i = ind; i < addressBook.length - 1; i++) {
                    addressBook[i] = addressBook[i + 1];
                }
                addressBook[addressBook.length - 1] = null;
                return true;
            }
        }
        return false;
    }

    public int size() {
        int count = 0;
        for (NameAddressPair person : addressBook) {
            if (person != null) {
                count++;
            }
        }
        return count;
    }
    public void sortedBy(SortOrder order) {
        if (order == SortOrder.ASC) {
            Arrays.sort(addressBook, (o1, o2) -> {
                int compareTo = o1.person.firstName.compareTo(o2.person.firstName);
                if (compareTo > 0) {
                    return compareTo;
                }
                if (compareTo < 0) {
                    return compareTo;
                }
                if (o1.person.firstName.equals(o2.person.firstName)) {
                    return o1.person.lastName.compareTo(o2.person.lastName);
                }
                return 0;
            });
        } else if (order == SortOrder.DESC) {
            Arrays.sort(addressBook, (o1, o2) -> {
                int compareTo = o2.person.firstName.compareTo(o1.person.firstName);
                if (compareTo > 0) {
                    return compareTo;
                }
                if (compareTo < 0) {
                    return compareTo;
                }
                if (o2.person.firstName.equals(o1.person.firstName)) {
                    return o2.person.lastName.compareTo(o1.person.lastName);
                }
                return 0;
            });
        }
    }

    @Override
    public Iterator iterator() {
        return new AddressBookIterator();
    }


    //nested AddressBookIterator
    private class AddressBookIterator implements Iterator {
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < addressBook.length && addressBook[counter] != null;
        }

        @Override
        public String next() {
            if (addressBook[counter] != null) {
                String res = String.format("First name: %s, Last name: %s, Address: %s", addressBook[counter].person.firstName,
                        addressBook[counter].person.lastName, addressBook[counter].address);
                counter++;
                return res;
            }
            return null;
        }

    }

    //inner NameAddressPair
    private static class NameAddressPair {
        private final Person person;
        private String address;

        private NameAddressPair(Person person, String address) {
            this.person = person;
            this.address = address;
        }

        //inner Person
        private static class Person {
            private final String firstName;
            private final String lastName;

            private Person(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }

            @Override
            public boolean equals(Object obj) {
                return super.equals(obj);
            }
        }
    }

    public static void main(String[] args) {
//        String[] expected = {"First name: Susan, Last name: Brown, Address: Address # 4",
//                "First name: Karen, Last name: Davis, Address: Address #2",
//                "First name: John, Last name: Taylor, Address: Address #1",
//                "First name: John, Last name: Brown, Address: Address #1"};
//        String[] actual = new String[4];
//        AddressBook addressBook = new AddressBook(4);
//        addressBook.create("John", "Brown", "Address #1");
//        addressBook.create("Susan", "Brown", "Address # 4");
//        addressBook.create("Karen", "Davis", "Address #2");
//        addressBook.create("John", "Taylor", "Address #1");
//        addressBook.sortedBy(SortOrder.DESC);
//        int counter = 0;
//        for (Object record : addressBook)
//            actual[counter++] = record.toString();
//        System.out.println(Arrays.equals(expected, actual));


        String[] expected = {"First name: John, Last name: Brown, Address: Address #1",
                "First name: John, Last name: Taylor, Address: Address #1",
                "First name: Karen, Last name: Davis, Address: Address #2",
                "First name: Susan, Last name: Brown, Address: Address #4"};
        String[] actual = new String[4];
        AddressBook addressBook = new AddressBook(4);
        addressBook.create("John", "Brown", "Address #1");
        addressBook.create("Susan", "Brown", "Address #4");
        addressBook.create("Karen", "Davis", "Address #2");
        addressBook.create("John", "Taylor", "Address #1");
        addressBook.sortedBy(SortOrder.ASC);
        int counter = 0;
        for (Object record : addressBook)
            actual[counter++] = record.toString();
        System.out.println(Arrays.equals(expected, actual));
    }
}
