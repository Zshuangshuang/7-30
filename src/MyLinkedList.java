/**
 * Created With IntelliJ IDEA.
 * Description:
 * User:ZouSS
 * Date:2020-07-30
 * Time:21:24
 **/
class Node{
    private Node next;
    private int data;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
    public void setNext(Node next){
        this.next = next;
    }
    public Node getNext(){
        return next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

}
public class MyLinkedList {
    public Node head;
    public void addFirst(int data){
        Node node = new Node(data);
        if (this.head == null){
            this.head = node;
            return;
        }
        node.setNext(this.head);
        this.head = node;
    }
    public void addLast(int data){
        Node node = new Node(data);
        if (this.head == null){
            this.head = node;
            return;
        }
        Node cur = this.head;
        while(cur.getNext() != null){
            cur = cur.getNext();
        }
        cur.setNext(node);
    }
    public boolean contains(int key){
        Node cur = this.head;
        while(cur != null){
            if (cur.getData() == key){
                return true;
            }
        }
        return false;
    }
    public int size(){
        Node cur = this.head;
        int count = 0;
        while(cur != null){
            count++;
            cur = cur.getNext();
        }
        return count;
    }
    public Node findIndex(int index){
        Node cur = this.head;
        for (int i = 0; i < index-1; i++) {
            cur = cur.getNext();
        }
        return cur;
    }
    public void addIndex(int index,int data){
        if (index < 0){
            return;
        }
        if (index == 0){
            addFirst(data);
            return;
        }
        if (index == size()){
            addLast(data);
            return;
        }
        Node ret = findIndex(index);
        Node node = new Node(data);
        node.setNext(ret.getNext());
        ret.setNext(node);
    }
    private Node findPrev(int key){
        Node prev = this.head;
        while(prev != null){
            while(prev.getNext().getData() != key && prev.getNext() != null){
                prev = prev.getNext();
            }
            return prev;
        }
        return null;
    }
    public void remove(int key){
        if (this.head == null){
            return;
        }
        if (this.head.getData() == key){
            this.head = this.head.getNext();
        }
        Node prev = findPrev(key);
        if (prev == null){
            return;
        }
        Node del = prev.getNext();
        prev.setNext(del.getNext());
    }
    public Node reverse(){
        if (this.head == null){
            return null;
        }
        Node newHead = null;
        Node cur = this.head;
        Node prev = null;
        while(cur != null){
            Node curNext = cur.getNext();
            if (curNext == null){
                newHead = cur;
            }
            cur.setNext(prev);
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }
    public void removeAllKey(int key){
        Node cur = this.head;
        Node curNext = cur.getNext();
        while(curNext != null){
            if (curNext.getData() == key){
                cur.setNext(curNext.getNext());
                curNext = curNext.getNext();

            }else {
                cur = curNext;
                curNext = curNext.getNext();
            }
        }
        if (this.head.getData() == key){
            this.head = this.head.getNext();
        }
    }
    public void display2(Node newHead){
        Node cur = newHead;
        while(cur != null){
            System.out.print(cur.getData()+" ");
            cur = cur.getNext();
        }
    }
    public boolean hasCycle(){
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow){
               break;
            }
        }
        if (fast == null || fast.getNext() == null){
            return false;
        }
        return true;
    }
    public Node findCycle(){
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow){
                break;
            }
        }
        if (fast == null || fast.getNext() == null){
            return null;
        }

       slow = this.head;
        while(fast != slow){
            fast = fast.getNext();
            slow = slow.getNext();
        }
        return slow;
    }
    public void twoMergerList(Node headA,Node headB){
        
    }

    public void display(){
        Node cur = this.head;
        while(cur != null){
            System.out.print(cur.getData()+" ");
            cur = cur.getNext();
        }
    }
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        MyLinkedList myLinkedList1 = new MyLinkedList();
        /*myLinkedList.addFirst(10);
        myLinkedList.addFirst(20);
        myLinkedList.addFirst(30);
        myLinkedList.addFirst(40);*/
        myLinkedList.addLast(10);
        myLinkedList.addLast(20);
        myLinkedList.addLast(30);
        myLinkedList.addLast(40);
        myLinkedList.addLast(50);
        myLinkedList1.addLast(99);
        myLinkedList1.addLast(88);
        myLinkedList1.addLast(66);
        myLinkedList1.addLast(22);
        myLinkedList1.addLast(11);
       /* myLinkedList.display();
        System.out.println();*/
       /* myLinkedList.addIndex(2,66);
        myLinkedList.display();
        *//*int ret = myLinkedList.size();
        System.out.println(ret);*//*
        myLinkedList.remove(66);
        System.out.println();
        myLinkedList.display();*/

       /* Node ret = myLinkedList.reverse();
        myLinkedList.display2(ret);*/
    }

}
