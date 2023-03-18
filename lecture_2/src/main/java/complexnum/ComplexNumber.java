package complexnum;

public class ComplexNumber {
    private double real;
    private double imaginary;

    // Конструктор с 1 параметром
    public ComplexNumber(double real) {
        this.real = real;
        this.imaginary = 0;
    }

    // Конструктор с 2 параметрами
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Сложение
    public ComplexNumber add(ComplexNumber other) {
        double real = this.real + other.real;
        double imaginary = this.imaginary + other.imaginary;
        return new ComplexNumber(real, imaginary);
    }

    // Вычитание
    public ComplexNumber subtract(ComplexNumber other) {
        double real = this.real - other.real;
        double imaginary = this.imaginary - other.imaginary;
        return new ComplexNumber(real, imaginary);
    }

    // Умножение
    public ComplexNumber multiply(ComplexNumber other) {
        double real = this.real * other.real - this.imaginary * other.imaginary;
        double imaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(real, imaginary);
    }

    // Модуль
    public double abs() {
        return Math.sqrt(this.real * this.real + this.imaginary * this.imaginary);
    }

    // Преобразование в строку
    public String toString() {
        return this.real + (this.imaginary < 0 ? "-" : "+") + Math.abs(this.imaginary) + "i";

    }
}

