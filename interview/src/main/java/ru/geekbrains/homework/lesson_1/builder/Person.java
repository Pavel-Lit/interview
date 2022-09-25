package ru.geekbrains.homework.lesson_1.builder;

public class Person {

    private String firstName;

    private String lastName;

    private String middleName;
    private String country;
    private String phone;
    private Gender gender;
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private Person(){

    }

    public Person(String firstName, String lastName, String middleName, String country, String phone, Gender gender, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.country = country;
        this.phone = phone;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }

    public static Builder createBuilder(){
        return new Builder();
    }

    public static class Builder{
        private final Person person;

        public Builder() {
            this.person = new Person();
        }

        public Builder withFirstName(String firstName){
            this.person.firstName = firstName;
            return this;
        }
        public Builder withLastName(String lastName){
            this.person.lastName = lastName;
            return this;
        }

        public Builder withMiddleName(String middleName){
            this.person.middleName = middleName;
            return this;
        }

        public Builder withCountry(String country){
            this.person.country = country;
            return this;
        }

        public Builder withPhone(String phone){
            this.person.phone = phone;
            return this;
        }

        public Builder withGender(Gender gender){
            this.person.gender = gender;
            return this;
        }

        public Builder withAge(int age){
            this.person.age = age;
            return this;
        }

        public Person build(){
            return person;
        }
    }
}
