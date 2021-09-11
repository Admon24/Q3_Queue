package com.tec;

public class DoublyLinkedList <T> {

    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int size;

    public DoublyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T data){
        DoubleNode<T> newNode = new DoubleNode<T>(data);
        if(head == null){
            this.head = newNode;
            this.tail = newNode;
        } else {
            DoubleNode<T> temp = head;
            while (temp.getNextDNode() != null){
                temp = temp.getNextDNode();
            }
            //[NH]->[H]->[1]->[2]->[NN]->
            temp.setNextDNode(newNode);
            newNode.setPrevDNode(temp);
            this.tail = newNode;
        }
        this.size++;
    }

    public void addFirst(T data){
        DoubleNode<T> newDNode = new DoubleNode<>(data);
        if(this.head == null){
            this.head = newDNode;
            this.tail = newDNode;
        } else{
            //A esto se le llama swap        H
            DoubleNode<T> temp = head;   // [H]->[1]->[2]->
            head = newDNode;            // [NH]->[1]->[2]->
            head.setNextDNode(temp);
            temp.setPrevDNode(head);    // [NH]->[H]->[1]->[2]->
            //temp.setNextDNode(temp.getNextDNode());
        }
        size++;
    }

    public void addLast(T data){
        DoubleNode<T> newDNode = new DoubleNode<>(data);
        if(this.tail == null){
            this.tail = newDNode;
            this.head = newDNode;
        } else{
            //A esto se le llama swap        H
            DoubleNode<T> temp = tail;   // [H]->[1]->[T]->
            tail = newDNode;            //  [1]->[2]->[T]
            tail.setPrevDNode(temp);
            temp.setNextDNode(tail);    // [H]->[1]->[2]->
            //temp.setNextDNode(temp.getNextDNode());
        }
        size++;
    }

    public void insert(int index, T data){
        if(index > this.size){
            System.out.println("Error: Index error");
            return;
        }
        DoubleNode<T> newDNode = new DoubleNode<>(data); //Creamos nuestro nuevo nodo
        DoubleNode<T> tmp = head; //Creamos un nodo temporal que apunta a la cabeza
        int cont = 0;

        while (cont < index - 1){
            tmp = tmp.getNextDNode(); //Se va cambiando el nodo temporal al siguiente nodo
            cont++;
        }
        //Quiero introducir mi nodo [c]-> entre [a]->[b]
        newDNode.setNextDNode(tmp.getNextDNode()); //[c]->[b]
        tmp.setNextDNode(newDNode); //[a]->[c]
        this.size++;
    }

    public T get(int index){ //Para obtener un dato de la lista
        if (index >= size){
            System.out.println("Error: Index error");
            return null;
        }
        DoubleNode<T> dnode = head; //Se inicia el nodo en la cabeza
        int cont = 0;

        while (cont != index){
            dnode = dnode.getNextDNode();
            cont++;
        }
        return dnode.getData();
    }

    //Este método de eliminar soporta cualquier posición
    public boolean remove(int index){
        if (index >= size){
            System.out.println("Error: Index error");
            return false;
        }
        DoubleNode<T> node = head, prev = null; //El nodo inicia en la cabeza y el nodo previo en null
        boolean done = false;
        int cont = 0;

        while (cont != index){ //Nos movemos a la posición deseada
            prev = node; //Previo toma el valor del nodo
            node = node.getNextDNode(); //Nodo pasa a ser el siguiente
            cont++;
        }
        if (node != null){
            if (prev == null){ //Quedamos en el head
                head = node.getNextDNode(); //Se pasa la cabeza al siguiente nodo
            } else{
                prev.setNextDNode(node.getNextDNode()); //Al siguiente del nodo anterior, coloquele el siguiente del nodo actual
                //Con eso se saca al nodo actual de la lista
            }
            done = true;
            this.size--;
        }
        return done;
    }

    public int size(){
        return this.size;
    }

    public void show(){
        DoubleNode<T> node = head;
        while (node != null){
            System.out.print(node.toString());
            node = node.getNextDNode();
        }
        System.out.println();
    }
}
