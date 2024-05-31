package graphs;

import java.util.PriorityQueue;

public class QueueObject<T extends Comparable<T>> implements Comparable<QueueObject<T>> {
    private T data;
    private double priority;

    public QueueObject(T data, double priority) {
        this.data = data;
        this.priority = priority;
    }

    public T getData() {
        return data;
    }

    public double getPriority() {
        return priority;
    }

    @Override
    public int compareTo(QueueObject<T> other) {
        return Double.compare(this.priority, other.priority);
    }

    public static void main(String[] args) {
        PriorityQueue<QueueObject<String>> queue = new PriorityQueue<>();

        queue.offer(new QueueObject<>("C", 3.0));
        queue.offer(new QueueObject<>("A", 1.0));
        queue.offer(new QueueObject<>("B", 2.0));
        queue.offer(new QueueObject<>("D", 4.0));

        while (!queue.isEmpty()) {
            QueueObject<String> obj = queue.poll();
            System.out.println("Data: " + obj.getData() + ", Priority: " + obj.getPriority());
        }
    }
}
