package java2.lesson1.lesson2;

//1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4,
// при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
// 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
// Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
// должно быть брошено исключение MyArrayDataException – с детализацией, в какой именно ячейке лежат неверные данные.
// 3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException
// и MyArrayDataException и вывести результат расчета.

public class Main {
    public static void main(String[] args) {


        try {
            MyArrayDataException(6);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
            System.out.println(e.getSIZE());
        }


    }

    static void MyArrayDataException(int SIZE) throws MyArraySizeException {
        String[][] arr = {
                {"12", "34", "24", "33"},
                {"62", "37", "454", "4545"},
                {"62", "37", "55", "98"},
                {"62", "37", "345", "56"}
        };


        System.err.println("Сейчас должна быть ошибка ");
        int z = Integer.parseInt(arr[1][3]);
        System.out.println(z);
        if (SIZE > 4) {
            throw new MyArraySizeException("некорректное значение", SIZE);

        }
        for (int i = 0; i < arr.length ; i++) {
                System.out.println(arr[1][3]);

            }

        }
    }
