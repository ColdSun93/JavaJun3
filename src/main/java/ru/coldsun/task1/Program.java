package ru.coldsun.task1;

import java.io.*;


public class Program{
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Student students = new Student("Иванов Иван Иванович", 10, 4.3);

        try(FileOutputStream fileOutputStream = new FileOutputStream("studentsdata.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(students);
            System.out.println("Объект UserData сериализован.");
        }

        try(FileInputStream fileInputStream = new FileInputStream("studentsdata.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            students = (Student)objectInputStream.readObject();
            System.out.println("Объект UserData десериализован.");
        }

        System.out.println("Объект Student десериализован.");
        System.out.println("Имя: " + students.getName());
        System.out.println("Возраст: " + students.getAge());
        System.out.println("Средний бал: " + students.getAverageScore());


    }
}
