package ru.maxawergy.rkss_pr1;

public class bookOfSolution {
    public static boolean isTriangleExists(int x1, int y1, int x2, int y2, int x3, int y3) {
        // Вычисляем длины сторон треугольника с использованием теоремы Пифагора
        double sideAB = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double sideBC = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        double sideCA = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));

        System.out.println(x1 + " " + y1 + " " + x2+ " " + y2+ " " + x3+ " " + y3);
        // Проверяем условие существования треугольника: сумма любых двух сторон должна быть больше третьей
        return (sideAB + sideBC > sideCA) && (sideBC + sideCA > sideAB) && (sideCA + sideAB > sideBC);
    }

    public static boolean canCircleFitInSquare(double squareArea, double circleArea) {
        // Радиус круга можно вычислить как корень из (площади круга / π)
        double radius = Math.sqrt(circleArea / Math.PI);

        // Сторона квадрата, в который можно вписать круг, равна удвоенному радиусу круга
        double squareSide = 2 * radius;

        // Проверяем, помещается ли квадрат в круг, учитывая площади
        return squareSide * squareSide <= squareArea;
    }

    public static boolean canSquareFitInCircle(double squareArea, double circleArea) {
        // Радиус круга можно вычислить как корень из (площади круга / π)
        double radius = Math.sqrt(circleArea / Math.PI);

        // Площадь квадрата, который можно вписать в круг, равна удвоенному квадрату радиуса
        double squareAreaToFitInCircle = 2 * radius * 2 * radius;

        // Проверяем, помещается ли круг в квадрат, учитывая площади
        return squareAreaToFitInCircle >= squareArea;
    }

    public static boolean canFitRectangle(double A, double B, double C, double D) {
        // Проверяем, можно ли уместить прямоугольник со сторонами A и B внутри прямоугольника со сторонами C и D
        if (A <= C && B <= D) {
            return true;
        }
        return A <= D && B <= C;
    }

    public static boolean checkInterval(double number) {
        return !(number < 3) && !(number > 15);
    }

    public static boolean isTriangleExists(double A, double B, double C) {
        // Условие существования треугольника: сумма любых двух сторон должна быть больше третьей стороны
        return A + B > C && B + C > A && C + A > B;
    }

    public static double calculateTriangleArea(double A, double B, double C) {
        // Вычисление полупериметра
        double s = (A + B + C) / 2.0;

        // Вычисление площади треугольника по формуле Герона
        double area = Math.sqrt(s * (s - A) * (s - B) * (s - C));
        return area;
    }
}
