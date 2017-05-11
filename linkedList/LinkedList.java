package linkedList;

public class LinkedList{

    // head of the linked list
    Node head;

    public static void main(String args[])
    {
//        LinkedList linkedList = new LinkedList();
//        linkedList.head = new Node(1);
//        Node second= new Node(2);
//        Node third = new Node(3);
//        linkedList.head.next=second;
//        second.next=third;
//
//        //printing the list
//        linkedList.traverseList();
//
//        //pushing a new data at the front
//        linkedList.push(0);
//
//        //traversing again
//        linkedList.traverseList();
//
//        //appending an element at the end
//        linkedList.append(10);
//
//        //traversing again
//        linkedList.traverseList();
//
//        //deleting an element
////        linkedList.deleteNode(10);
////        linkedList.deletePositionedNode(7);
//
//        System.out.println("Length of the list = "+linkedList.getLength());
//        System.out.println("Length of the list = "+linkedList.getLengthRec(linkedList.head));
//
//        linkedList.reverse();
//
//        //traversing again
//        linkedList.traverseList();
//
//
        LinkedList a = new LinkedList();
        a.head = new Node(9);
        a.append(7);
        a.append(3);
        a.append(1);

        LinkedList b = new LinkedList();
        b.head = new Node(1);
        b.append(7);
        b.append(8);
//        b.append(8);
//        b.append(9);

        System.out.println("List A");
        a.traverseList();
        System.out.println("List B");
        b.traverseList();

        LinkedList result = a.addTwoLists(a,b);

        System.out.println("Result");
        result.traverseList();

////        LinkedList mergedList = a.sortedMerge(a,b);
////        System.out.println("------------------Merged list----------------");
////        mergedList.traverseList();
//        LinkedList mergedListRec = new LinkedList(a.mergeLists(a.head,b.head));
//        System.out.println("-----------------Rec Merged List---------------");
//        mergedListRec.traverseList();

//
//        LinkedList unsorted = new LinkedList();
//        unsorted.head = new Node(5);
//        unsorted.append(3);
//        unsorted.append(15);
//        unsorted.append(7);
//        unsorted.append(4);
//        unsorted.append(1);
//        unsorted.append(10);
//        System.out.println("---------------Unsorted List-----------------");
//        unsorted.traverseList();
//        System.out.println("---------------Sorted List-------------------");
//        Node sorted = unsorted.mergeSort(unsorted.head);
//        (new LinkedList(sorted)).traverseList();
    }

    public LinkedList(Node head) {
        this.head = head;
    }

    public LinkedList(){
        this.head=null;
    }

    public void reverse()
    {
        Node prev = null,current=head,next=null;

        while(current!=null)
        {
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        head=prev;
    }

    public int getLengthRec(Node node)
    {
        if(node == null)
            return 0;
        return 1+ getLengthRec(node.next);
    }

    public Node getHead() {
        return head;
    }

    public void traverseList()
    {
        Node tempHead = head;
        while(tempHead!=null) {
            System.out.print(tempHead.getData()+" ");
            tempHead = tempHead.getNext();

        }
        System.out.println();
    }

    public static void traverseNode(Node list)
    {
        Node temp = list;
        while(temp!=null)
        {
            System.out.print(temp.getData()+" ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    public void push(int newData)
    {
        Node newNode = new Node(newData);
        newNode.setNext(head);
        head=newNode;
    }

    public void append(int newData)
    {
        Node newNode = new Node(newData);
        newNode.setNext(null);
        Node tempHead=head;
        while(tempHead.next!=null) {
            tempHead = tempHead.next;
        }
        tempHead.next=newNode;
    }

    public void deleteNode(int data)
    {
        Node tempHead=head, prev=null;
        // If first node is to be deleted
        if(tempHead!=null && tempHead.getData() == data)
        {
            head=tempHead.next;
            return;
        }
        while(tempHead!=null && tempHead.getData()!=data)
        {
            prev=tempHead;
            tempHead=tempHead.getNext();
        }
        // if key was not found then tempHead would be null
        if(tempHead==null)
        {
            System.out.println("Key to be deleted not found");
            return;
        }
        //if key was found remove the node
        prev.next=tempHead.next;
    }

    public int getLength()
    {
        Node temp= head;
        int length;
        for(length=0;temp!=null;length++,temp=temp.next);
        return length;
    }

    public void deletePositionedNode(int position)
    {
        Node temp = head, prev=null;
        if(position==0)
        {
            head=temp.next;
            return;
        }
        for(int i=0;temp!=null && i<position-1;i++)
            temp=temp.next;
        if(temp==null || temp.next==null) // position does not exist
        {
            System.out.println("Invalid position, out of bounds");
            return;
        }
        temp.next=temp.next.next;
    }

    public LinkedList sortedMerge(LinkedList first, LinkedList second)
    {
        Node mergedList = new Node(-1); //dummy node
        Node mergedListTemp = mergedList;
        Node a=first.head;
        Node b=second.head;
        while(true)
        {
            if(a == null)
            {
                mergedList.next = b;
                break;
            }
            if(b == null)
            {
                mergedList.next=a;
                break;
            }
            if(a.getData()<=b.getData())
            {
                mergedList.next=a;
                a=a.next;
            }
            else
            {
                mergedList.next=b;
                b=b.next;
            }
            mergedList = mergedList.next;
        }

        mergedListTemp = mergedListTemp.next;
        return new LinkedList(mergedListTemp);
    }

    public Node mergeLists(Node a, Node b)
    {
        if(a==null) return b;
        if(b==null) return a;

        Node head;
        if(a.getData()<b.getData())
        {
            head=a;
        }
        else{
            head=b;
            b=a;
            a=head;
        }
        while(a.next!=null)
        {
            if(a.next.getData()>b.getData())
            {
                Node temp=a.next;
                a.next=b;
                b=temp;
            }
            a=a.next;
        }
        if(a.next==null) a.next=b;
        return head;
    }

    public Node sortedMergeRec(Node a, Node b){
        if(a==null)
        {
            return b;
        }
        if(b==null)
        {
            return a;
        }
        Node result;
        if(a.getData()<=b.getData())
        {
            result = a;
            result.next = sortedMergeRec(a.next,b);
        }
        else {
            result = b;
            result.next=sortedMergeRec(a,b.next);
        }
        return result;
    }

    /**
    Perform merge sort on given list
     **/
    public Node mergeSort(Node list)
    {
//        this.traverseNode(list);
        // case length 0 or 1
        if(list == null || list.next == null)
            return list;
        // split in two
        Node[] splitLists =  halfSplit(list);
        // call merge sort on each
        Node sorted1 = mergeSort(splitLists[0]);
        Node sorted2 = mergeSort(splitLists[1]);
        // merge two sorted lists
        return mergeLists(sorted1,sorted2);
    }

    public Node[] halfSplit(Node list)
    {
        Node fast=list,slow=list,prevSlow=null;
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            prevSlow = slow;
            slow=slow.next;
        }
        prevSlow.next = null;
        Node[] splittedList= new Node[2];
        splittedList[0]= list;
        splittedList[1]= slow;
        return  splittedList;
    }

    public boolean findLoop(Node list)
    {
        Node slow=list,fast=list;
        while(fast!=null && fast.next!=null && slow!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            if(fast == slow)
            {
                return true;
            }
        }
        return false;
    }

    public Node reverse(Node list, int k)
    {
        int count=0;
        Node current=list,prev=null,next=null;

        while (count<k && current!=null)
        {
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
            count++;
        }

        if(next!=null)
        {
            list.next=reverse(next,k);
        }

        return prev;
    }

    public LinkedList addTwoLists(LinkedList first, LinkedList second)
    {
        Node a = first.head;
        Node b = second.head;
        Node result = new Node(-1); // dummy node
        Node currentResult = result;
        int carry=0;
        while (a!=null || b!=null)
        {
            int runningSum = (a!=null ?a.getData():0) + (b!=null ? b.getData():0) + carry;
            carry = (runningSum>=10)?1:0;
            runningSum%=10;
            currentResult.next= new Node(runningSum);
            currentResult=currentResult.next;
            if(a!=null) a=a.next;
            if(b!=null) b=b.next;
        }
        if(carry > 0)
        {
            currentResult.next= new Node(carry);
        }
        result = result.next;
        return new LinkedList(result);
    }

    public void reverseList()
    {
        Node current=this.head,prev=null,next=null;
        while (current!=null)
        {
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        head=prev;
    }

    public void splitList()
    {
        Node head= this.head;
        Node fast=head,slow=head;
        while (fast.next!=head && fast.next.next != head)
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        Node first = head;
        Node second = slow.next;
        slow.next = head;
        fast.next=second;
    }
}