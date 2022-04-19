package com.chenjiehan.algorithm.entity;

import lombok.Data;

@Data
public class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student another) {
        return this.score - another.score;
    }

    @Override
    public String toString() {
        return String.format("Student(name  :  %s,score : %d", name, score);
    }
}
