package com.AOC;

public class Agent implements Person {
    private Person actor;
    private String before;
    private String after;
    public Agent(Person person, String before, String after) {
        this.actor = person;
        this.before = before;
        this.after = after;
    }
    @Override
    public void speak() {
        //before speak
        System.out.println("Before actor speak, Agent say: " + before);
        //real speak
        this.actor.speak();
        //after speak
        System.out.println("After actor speak, Agent say: " + after);
    }
}
