import java.util.Iterator;

public class Stack<T> implements Iterable<T> {

    private java.util.LinkedList<T> list  = new java.util.LinkedList<T>();

    public Stack(){}

    public Stack(T firstelement){
        push(firstelement);
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public void push(T element){
        list.addLast(element);
    }

    public T pop(){
        if(isEmpty())throw new java.util.EmptyStackException();
        return list.removeLast();
    }

    public T peek(){
        if(isEmpty())throw new java.util.EmptyStackException();
        return list.peekLast();
    }

    @Override
    public Iterator<T> iterator() {
       
        return list.iterator();
    }
    
}
