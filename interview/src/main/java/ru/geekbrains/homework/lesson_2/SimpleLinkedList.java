package ru.geekbrains.homework.lesson_2;

public class SimpleLinkedList<E> {
    private Node<E> first = null;
    private Node<E> last =null;
    private int size = 0;

    public void add(E e){
        if (size==0){
            first = new Node<>(e, null, first);
            last = first;
        }else {
            Node<E> tempNode = new Node<>(e, last, null);
            last.next = tempNode;
            last= tempNode;
        }
        size++;
    }

    public void remove(E e){
        Node<E> removeNode = first;
        while (removeNode.next != null){
            removeNode = removeNode.next;
            if (removeNode.element.equals(e)){
                Node<E> prev = removeNode.prev;
                Node<E> next = removeNode.next;
                prev.next = next;
                next.prev = prev;
                size--;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(first.element);
        Node<E> currentNode = first;
        while (currentNode.next!=null){
            currentNode = currentNode.next;
            sb.append("->");
            sb.append(currentNode.element);
        }
        return sb.toString();
    }

    private static class Node<E>{
        E element;
        Node<E> prev;
        Node<E> next;

        Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }
}
