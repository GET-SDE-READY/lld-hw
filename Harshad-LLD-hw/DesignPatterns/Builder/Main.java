//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {

        Person person = new PersonBuilder()
                .name("Harshad")
                .email("xyz@gmail.com")
                .contact("9999999999")
                .build();

        System.out.println(person.getName() + " " +person.getContact() + " " + person.getEmail());

    }
}