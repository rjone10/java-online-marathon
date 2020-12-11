package task5_4;

import java.util.Objects;

class Person {
    private String firstName;
    private String lastName;
    private String idCode;

    public void setFirstName(String firstName) throws NameException {
        if (firstName.matches("[A-Z][a-zA-Z]+")) {
            this.firstName = firstName;
        } else {
            throw new NameException("Incorrect value " + firstName +
                    " for firstName (should start from upper case and contains only alphabetic characters and symbols -, _)");
        }
    }

    public void setLastName(String lastName) throws NameException {
        if (lastName.matches("[A-Z][a-zA-Z]+")) {
            this.lastName = lastName;
        } else {
            throw new NameException("Incorrect value " + lastName +
                    " for lastName (should start from upper case and contains only alphabetic characters and symbols -, _)");
        }
    }

    public void setIdCode(String idCode) throws CodeException {
        if (idCode.matches("\\d{10}")) {
            this.idCode = idCode;
        } else {
            throw new CodeException("Incorrect value " + idCode +
                    " for code (should contains exactly 10 digits)");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s: %s", firstName, lastName, idCode);
    }

    static Person buildPerson(String firstName, String lastName, String idCode) throws NameException, CodeException {
        Person person = new Person();
        StringBuilder sb = new StringBuilder();
        try {
            person.setFirstName(firstName);
        } catch (NameException e) {
            sb.append(e.getMessage()).append("; ");
        }
        try {
            person.setLastName(lastName);
        } catch (NameException e) {
            sb.append(e.getMessage()).append("; ");
        }
        try {
            person.setIdCode(idCode);
        } catch (CodeException e) {
            sb.append(e.getMessage()).append("; ");
        }

        if (sb.length() == 0) {
            return person;
        }
        throw new IllegalArgumentException(sb.substring(0, sb.length() - 2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(idCode, person.idCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, idCode);
    }

    public static void main(String[] args) throws NameException, CodeException {
//        Person person = new Person();
//        person.setFirstName("Joe");
//        person.setLastName("KlarK2");
//        person.setIdCode("2");
//        System.out.println(person);

        System.out.println(buildPerson("io", "Oros", "23"));
    }
}

class NameException extends RuntimeException {
    public NameException(String message) {
        super(message);
    }
}

class CodeException extends RuntimeException {
    public CodeException(String message) {
        super(message);
    }
}
