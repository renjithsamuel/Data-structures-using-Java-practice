
public class DoublyLinkedList<T> implements Iterable<T> {
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    private static class Node<T>{
        private T data;
        private Node<T> prev;
        private Node<T> next;

        public Node(T elem,Node<T> prev , Node<T> next){
            this.data = elem;
            this.prev = prev;
            this.next = next;}
        @Override
            public String toString(){
            return data.toString();
    }
    }
    public void clear(){
        Node<T> trav  = head;
        while(trav != null){
            Node<T> next = trav.next;
            trav.prev = null;
            trav.next = null;
            trav.data = null;
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }
    

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void add(T elem){
        addLast(elem);
    }

    public void addLast(T elem){
        if(isEmpty()) head = tail =  new  Node<T>(elem , null , null);
        else tail.next = new Node<T> (elem , tail , null);
        tail = tail.next;
        size++;
    }

    public void addFirst(T elem){
        if(isEmpty()) head = tail = new Node<T>(elem , null , null);
        else{
            head.prev = new Node<T> (elem , null , head);
            head = head.prev;
        }
        size++;
    }

    public T peekFirst(){
        if(isEmpty()) throw new RuntimeException("Empty List");
        return head.data;
    }

    public T peekLast(){
        if(isEmpty()) throw new RuntimeException("Empty list");
        return tail.data;
    }
    
    public T removeFirst(){
        if(isEmpty()) throw new RuntimeException("Empty List");
        T data = head.data;
        head = head.next;
        --size;
        if(isEmpty()) tail= null;
        else head.prev = null;
        return data;
    }

    public T removeLast(){
        if(isEmpty()) throw new RuntimeException("Empty list");
        T data = tail.data;
        tail.prev = tail;
        --size;
        if(isEmpty()) head = null;
        else tail.next = null;
        return data;
    }

    private T remove(Node<T> node){

        if(node.prev == null) return removeFirst();
        if(node.next == null) return removeLast();

        node.next.prev  =  node.prev;
        node.prev.next = node.next;

        T data = node.data;

        node.data = null;
        node = node.prev = node.next = null;
        --size;
        return data;
    }

    public T removeAt(int index){
        if(index<0 || index>=size) throw new IllegalArgumentException();

        int i;
        Node<T> trav;

        if(index< size/2) for(i = 0 , trav = head;i!=index ; trav = trav.next , i++);
        else for(i = size-1,trav= tail;i!=index;trav=trav.prev,i--);
        return remove(trav);
        }

    public boolean remove(Object obj){
        Node<T> trav;
        if(obj == null){
            for(trav = head;trav!=null;trav=trav.next){
                if(trav.data==null){
                    remove(trav);
                    return true;
                }
            }
        }
        else{
            for(trav = head;trav!=null;trav=trav.next){
                if(obj.equals(trav.data)){
                    remove(trav);
                    return true;
                }
            }
        }
        return false;
    }

    public int indexOf(Object obj){
        Node<T> trav;
        int index = 0;
        

        if(obj == null){
            for(trav = head,index = 0;trav!=null;trav=trav.next,index++){
                if(trav.data==null){
                    return index;
                }
            }
        }
        else{
            for(trav = head,index = 0;trav!=null;trav=trav.next,index++){
                if(obj.equals(trav.data)){
                    return index;
                }
            }
        }
        return -1;
    }

    
    public boolean contains(Object obj){
        return indexOf(obj)!=-1;
    }


    public java.util.Iterator <T> iterator(){
        return new java.util.Iterator<T>(){
            private Node<T> trav = head;

            @Override
            public boolean hasNext(){
                return trav!=null;
            }

            @Override
            public T next(){
                T data = trav.data;
                trav = trav.next;
                return data;
            }

            @Override
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(Node<T> trav = head ; trav!=null; trav=trav.next){
            sb.append(trav.data+", ");
            }
        sb.append("]");
        return sb.toString();
    }
    
    public static void main(String[] args){
        DoublyLinkedList<Integer> dl_list = new DoublyLinkedList<>();

        dl_list.addFirst(5);
        dl_list.addLast(200);
        for(int i= 0;i<10;i++){
            dl_list.add(i);
        }
        // dl_list.peekFirst();
        dl_list.removeAt(0);
        System.out.println(dl_list.indexOf(200));
        // System.out.println(dl_list);
        
    }


    


    

    }

    



