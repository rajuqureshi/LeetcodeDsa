class StockSpanner {
    Stack<Integer> s ;
    ArrayList<Integer> list;
    public StockSpanner() {
        s = new Stack<>();
        list = new ArrayList<>();
    }
    
    public int next(int price) {
        list.add(price);
        int i = list.size()-1;
        // s.push();
        while (!s.isEmpty() && list.get(s.peek())<=price) {
                s.pop();
            }
            int span;

            if (s.isEmpty()) {
                span= i+1;
            }else {
                span = i-s.peek();
            }
            s.push(i);
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */