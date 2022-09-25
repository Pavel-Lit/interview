package ru.geekbrains.homework.lesson_2;

import java.util.Arrays;

public class SimpleArrayList<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] initArray;

    private int pointer;

    private int size;

    public SimpleArrayList(){
        this.size = DEFAULT_CAPACITY;
        this.initArray = new Object[size];
        this.pointer = 0;
    }

    public int getSize(){
        return this.pointer;
    }

    public E getElementByIndex(int index){
        return (E) this.initArray[index];
    }

    public void add(E e){
        if(pointer == this.initArray.length){
            this.initArray = Arrays.copyOf(this.initArray, (int) (this.initArray.length * 1.6));
        }
        this.initArray[pointer] = e;
        this.pointer++;
    }

    public void removeElementByIndex(int index){
        Object[] temp1 = new Object[this.initArray.length];
        if(pointer!=index){
            int i =0;
            while ( i != index){
                temp1[i]= this.initArray[i];
                i++;
            }
            for (int j =index+1; j < this.initArray.length; j++) {
                    temp1[j-1] = this.initArray[j];
            }
            System.arraycopy(temp1, 0, this.initArray, 0, temp1.length);
        } else {
            this.initArray[index] = null;
        }
        pointer--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i <= this.pointer-1; i++) {
            sb.append(this.initArray[i]);
            if(i!=pointer-1){
                sb.append(", ");
            }else
            sb.append("]");
        }
        return sb.toString();
    }
}
