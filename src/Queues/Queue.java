package Queues;

public class Queue {
    private int front;
    private int rear;
    private int[] array;
    private final int size;


    public Queue(int size) {
        this.size = size;
        this.array = new int[size];
    }

    public Queue(){
        this(5);
    }

    public void enqueue(int value){
            if (isFull()){
                resizeArray();
            }
            array[rear] = value;
            rear++;
    }

    public void resizeArray(){
        int[] arrtemp = this.array;
        this.array = new int[size * 2];
        for (int i = 0; i < arrtemp.length; i++) {
            this.array[i] = arrtemp[i];
        }
    }

    public int peek(){
        if(!isEmpty()){
            return array[front];
        }
        throw new IllegalArgumentException();
    }

    public int dequeue(){
        if(!isEmpty()){
            front++;
            return array[rear -1];
        }
        throw  new IllegalArgumentException();
    }

    public void printQueue(){
        if(!isEmpty()){
            for (int i = front; i < rear; i++) {
                if (i < rear - 1) {
                    System.out.println(array[i] + ",");
                } else {
                    System.out.println(array[i]);
                }
            }
        }
    }

    public boolean isFull(){
        //[.., .., ..] size = 3, count = 0
        return rear == size;
    }
    public boolean isEmpty(){
        return rear == 0;
    }
}
