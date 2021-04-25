/*
Ankit Das
Multiple Inheritance using Interfaces

Written in Java 11
*/

interface Exam {
    void calculatePercentage(Double[] marks);
}

class Student {
    private String name;
    private Integer roll;
    private Double mark1;
    private Double mark2;

    Student(){
        this.name = "";
        this.roll = 0;
        this.mark1 = 0.00;
        this.mark2 = 0.00;
    }

    Student(String name, Integer roll, Double mark1, Double mark2){
        this.name = name;
        this.roll = roll;
        this.mark1 = mark1;
        this.mark2 = mark2;
    }

    public void setValues(String name, Integer roll, Double mark1, Double mark2){
        this.name = name;
        this.roll = roll;
        this.mark1 = mark1;
        this.mark2 = mark2;
    }

    public Double[] getMarks(){
        Double marks[] = new Double[2];
        marks[0] = mark1;
        marks[1] = mark2;

        return marks;
    }

    public String toString(){
        return "NAME: " + this.name + "\nROLL NUMBER: " + this.roll + "\nMARK 1: " + this.mark1 + "\nMARK 2: " + this.mark2; 
    }
}

class Result extends Student implements Exam {
    private Student student;
    private Double percentage;

    public void calculatePercentage(Double[] marks){
        for(int i = 0; i < marks.length; i++){
            this.percentage += marks[i];
        }

        this.percentage /= marks.length;
    }

    Result(String name, Integer roll, Double mark1, Double mark2){
        student = new Student(name, roll, mark1, mark2);
        this.percentage = 0.0;

        calculatePercentage(this.student.getMarks());
    }

    Result(Student student){
        this.student = student;

        this.percentage = 0.0;
        calculatePercentage(this.student.getMarks());
    }

    public Double getPercentage(){
        return this.percentage;
    }

    public String toString(){
        return this.student + "\nPERCENTAGE: " + this.percentage + "%";
    }
}

public class Main {
    public static void main(String[] args) {
        Student student = new Student("ANKIT DAS", 023, 100.00, 100.00);
        Result result = new Result(student);

        System.out.println(result);  
    }
}
