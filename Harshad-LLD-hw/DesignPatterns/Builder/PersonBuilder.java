public class PersonBuilder {
    private final Person person;

    public PersonBuilder(){
        this.person = new Person();
    }

    public PersonBuilder name(String name){
        this.person.setName(name);
        return this;
    }

    public PersonBuilder contact(String contact) {
        this.person.setContact(contact);
        return this;
    }
    
    public PersonBuilder email(String email){
        this.person.setEmail(email);
        return this; 
    }
    
    public Person build(){
        return this.person;
    }
}
