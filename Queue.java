package com.tec;

public class Queue <T> {

    private DoublyLinkedList<T> innerList;

    //Clase constructor
    public Queue(){
        innerList = new DoublyLinkedList<>();
    }

    public void enqueue(T data){
        innerList.add(data);
    }

    public T peek(){
        return innerList.get(0);
    }

    public T dequeue(){
        T data = peek(); //Se obtiene el dato
        innerList.remove(0); //Ahora se elimina
        return data;
    }

    public void show(){
        innerList.show();
    }
}
