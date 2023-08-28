class MyStack {

    public MyStack() {
        
    }
    
    public void push(int x) {
        queue.offer(x);

        for(int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }

    private Queue<Integer> queue = new ArrayDeque<>();
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */