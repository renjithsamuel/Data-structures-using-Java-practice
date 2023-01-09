import java.util.*;

import javax.xml.stream.events.EntityReference;

/**
 * main
 */

class Student{
    private int id;
    private String name;
    private static int noOfStudents = 0;
    Student(String name){
        this.id = ++noOfStudents;
        this.name = name;
    }
    public void setName(String name){
        this.name = name;
    }
    Student(Student stu){
        id = ++noOfStudents;
        name = stu.name;
    }
    public String toString(){
        return "["+id+"..."+name+"]";
    }
    public static int getNoOfStudents(){
        return noOfStudents;
    }
}

class MyComparator implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        Integer i1 = (Integer) o1;
        Integer i2 = (Integer) o2;
        return i2.compareTo(i1);
    }

}

class main{
    public static void main(String[] args) {
        
        
        
        // PriorityQueue<Integer> pri = new PriorityQueue<>();
        // for(int i=10;i>=0;i--) pri.add(i);
        
        // Iterator iter = pri.iterator();
        // while (iter.hasNext()) {
        //     Integer ele = (Integer) iter.next();
            // System.out.println(ele);
        // }
        // while(!pri.isEmpty()){
        //     System.out.println(pri.poll());
        // }
        // Map<Integer, Integer> map = new HashMap();
        // Scanner sc = new Scanner(System.in);
        // for(int i=0;i<2;i++)
        //     map.put(sc.nextInt(), sc.nextInt());
        
        // System.out.println(map);

        // Set entries = map.entrySet();
        // Iterator iter = entries.iterator();
        // // Set keys = map.keySet();
        // // Iterator iter2 =keys.iterator();
        // while (iter.hasNext()) {
        //     Map.Entry entry = (Map.Entry) iter.next();
        //     System.out.println(entry.getKey()+"..."+entry.getValue());
            
        // }
    }
}