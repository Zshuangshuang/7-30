/**
 * Created With IntelliJ IDEA.
 * Description:
 * User:ZouSS
 * Date:2020-07-30
 * Time:22:25
 **/
public class TestDemo {
    public static Node getIntersectionNode(Node headA,Node headB){

        //1、求长度
        Node pl = headA;
        Node ps = headB;
        int lenA = 0;
        int lenB = 0;
        while(pl != null){
            lenA ++;
            pl = pl.getNext();
        }
        while(ps != null){
            lenB ++;
            ps = ps.getNext();
        }
        pl = headA;
        ps = headB;
        int len = lenA - lenB;
        if(len < 0){
            pl = headB;
            ps = headA;
            len = lenB - lenA;
        }
        for (int i = 0; i < len ; i++) {
            pl = pl.getNext();
        }
        while(ps != pl && pl != null && ps != null){
            ps = ps.getNext();
            pl = pl.getNext();
        }
        if (pl == ps && pl != null ){
            return pl;
        }
        return null;
    }
    public static void createCut(Node headA,Node headB){
        headA.setNext(headB.getNext().getNext());
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
        createCut(myLinkedList.head,myLinkedList1.head);
        Node ret = getIntersectionNode(myLinkedList.head,myLinkedList1.head);
        System.out.println(ret.getData());
    }
}
