class BrowserHistory {
    class Node {
        String url;
        Node prev, next;
        Node(String url) {
            this.url = url;
        }
    }
    Node current;
    public BrowserHistory(String homepage) {
       current=new Node(homepage);


        
    }
    
    public void visit(String url) {
        Node newnode=new Node(url);
        current.next=newnode;
        newnode.prev=current;
        current=newnode;

    }
    
    public String back(int steps) {
        while(steps>0){
            if(current.prev!=null)
            current=current.prev;
            else
            break;
            steps--;
        }
        return current.url;
        
    }
    
    public String forward(int steps) {
        
        while(steps>0){
            if(current.next!=null)
            current=current.next;
            else
            break;
            steps--;
        }
        return current.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */