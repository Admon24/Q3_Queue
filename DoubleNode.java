package com.tec;

public class DoubleNode <T> {

    private T data;
    private DoubleNode<T> prevDNode;
    private DoubleNode<T> nextDNode;

    //Método constructor
    public DoubleNode(T data){
        this.data = data;
        this.nextDNode = null;
        this.prevDNode = null;
    }

    public void setData(T newData){
        this.data = newData;
    }

    public T getData(){
        return this.data;
    }

    public void setNextDNode(DoubleNode<T> dNode){
        this.nextDNode = dNode;
    }

    public void setPrevDNode(DoubleNode<T> dNode){
        this.prevDNode = dNode;
    }

    public DoubleNode<T> getNextDNode(){
        return this.nextDNode;
    }

    public DoubleNode<T> getPrevDNode(){
        return this.prevDNode;
    }
    public String toString(){
        String sNode = " [" + this.getData() + "] -->";
        return sNode;
    }
}
