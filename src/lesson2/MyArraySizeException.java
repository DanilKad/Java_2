package lesson2;

public class MyArraySizeException extends Exception {
    private int SIZE = 4 ;

    public int getSIZE() {
        return SIZE;
    }

    public MyArraySizeException(String некорректное_значение, int SIZE) {
        this.SIZE = SIZE;
    }
}

