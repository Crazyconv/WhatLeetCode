import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayQueue<E>{
    E[] arr;
    int head;
    int tail;
    int size;
    public ArrayQueue(Class<E> c, int size){
        arr = (E[]) Array.newInstance(c, size);
        head = -1;
        tail = -1;
        this.size = 0;
    }
    boolean push(E e){
        if(size == arr.length)
            return false;
        tail = (tail + 1) % arr.length;
        arr[tail] = e;
        size ++;
        if(head == -1)
            head = tail;
        return true;
    }
    boolean pop(){
        if(size == 0)
            return false;
        arr[head] = null;
        head = (head + 1) % arr.length;
        size --;
        if(size == 0){
            head = -1;
            tail = -1;
        }
        return true;
    }
    E peek(){
        if(size == 0)
            return null;
        else
            return arr[head];
    }
    public int size(){
        return size;
    }
    public String toString(){
        return Arrays.toString(arr);
    }
    public static void main(String[] args){
        ArrayQueue<Integer> q = new ArrayQueue<Integer>(Integer.class, 5);
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);
        q.pop();
        q.push(6);
        q.pop();
        System.out.println(q);
    }
}