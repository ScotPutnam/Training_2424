package com.scotputnam.polymorphism;

public class Parent {
    private String jobTitle;
    public void work(){
        System.out.println("Work hard to make money");
    }

    public Parent() {

    }


    public String getJobtitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobtitle) {
        this.jobTitle = jobtitle;
    }
}
