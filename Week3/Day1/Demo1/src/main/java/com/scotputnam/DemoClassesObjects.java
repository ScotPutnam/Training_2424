package com.scotputnam;

import java.util.Objects;

public class DemoClassesObjects {

    static class student {
        private static int nextId = 1;
        private static int totalStudents = 0;

        private final int id;
        private String name;

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            student student = (student) o;
            return id == student.id && Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        @Override
        public String toString() {
            return "student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        // static initializer block - runs once when class is loaded
        static {
            System.out.println("[student class] Static initializer block");
        }

        student(String name) {
            this.id = nextId++;
            this.name = name;
            totalStudents++;
        }

        public static int getNextId() {
            return nextId;
        }

        public static int getTotalStudents() {
            return totalStudents;
        }

        public static void setTotalStudents(int totalStudents) {
            student.totalStudents = totalStudents;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }


    }
    public static void main(String[] args) {

        student s1 = new student("John");
        student s2 = new student("John");
        System.out.println(s1.equals(s2));


        s1 = null;
        System.gc();
        System.out.println(student.getTotalStudents());

        System.out.println(student.getNextId());

    }
}
