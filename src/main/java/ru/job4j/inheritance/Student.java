package ru.job4j.inheritance;

public class Student {
    private byte age;
    private byte sex;
    private byte formOfYear;

    public Student() {
    }

    public Student(byte age, byte sex, byte formOfYear) {
        this.age = age;
        this.sex = sex;
        this.formOfYear = formOfYear;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    public byte getFormOfYear() {
        return formOfYear;
    }

    public void setFormOfYear(byte formOfYear) {
        this.formOfYear = formOfYear;
    }
}
