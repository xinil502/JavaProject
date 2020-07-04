package collection;

public class LinkedList<E> {
    private LinkedListNode first;
    private LinkedListNode last;
    private int size;

    public void add(E element){
        LinkedListNode newNode = new LinkedListNode(element);
        if(first == null){
            first = last = newNode;
        }else{
            newNode.previous = last;
            last.next = newNode;

            last = newNode;
        }
        ++size;
    }

    public void add(int index, E element){ //插入至对应索引值
        LinkedListNode newNode = new LinkedListNode(element);
        if(index == 0){
            if(index == 0 && size == 0){
                first = last = newNode;
                return;
            }
            newNode.next = first;
            first.previous = newNode;

            first = newNode;
            return;
        }
        checkRange(index-1);
        if(index == size){
            newNode.previous = last;
            last.next = newNode;

            last = newNode;
        }else{
            LinkedListNode node = getNode(index-1);
            newNode.next = node.next;
            newNode.previous = node;

            newNode.previous.next = newNode;
            newNode.next.previous = newNode;
        }
        ++size;
    }

    private LinkedListNode getNode(int index){
        checkRange(index);
        LinkedListNode temp;
        if(index < (size>>1)) {
            temp = first;
            while (index-- != 0) {
                temp = temp.next;
            }
        }else{
            temp = last;
            for(int i=size-1; index != i; --i) {
                temp = temp.previous;
            }
        }
        return temp;
    }

    public Object get(int index){ //根据索引值查找对应结点值
        return getNode(index).element;
    }

    public void remove(int index) {
        checkRange(index);
        LinkedListNode tempNode = getNode(index);
        if (tempNode == first && tempNode == last) {
            first = last = null;
        } else if (tempNode == first) {
            tempNode.next.previous = null;
            first = tempNode.next;
        } else if (tempNode == last) {
            tempNode.previous.next = null;
            last = tempNode.previous;
        } else {
            tempNode.previous.next = tempNode.next;
            tempNode.next.previous = tempNode.previous;
        }
        --size;
    }

    private void checkRange(int index){//合法索引判断
        if(index < 0 || index >= size){
            throw new RuntimeException("超出索引范围：" + index);
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        LinkedListNode temp = first;
        while(temp != null){
            sb.append(temp.element + ",");
            temp = temp.next;
        }
        sb.setCharAt(sb.length()-1, '}');
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();
        ll.add("a");
        ll.add("b");
        ll.add("c");
        System.out.println(ll); //会调用toString方法
        System.out.println(ll.get(1));
        ll.remove(1);
        System.out.println(ll);
        ll.add(1,"ZZZ");
        System.out.println(ll);


    }
}

class LinkedListNode{
    Object element;
    LinkedListNode previous;
    LinkedListNode next;

    public LinkedListNode(Object element, LinkedListNode previous, LinkedListNode next) {
        this.element = element;
        this.previous = previous;
        this.next = next;
    }

    public LinkedListNode(Object element) {
        this.element = element;
    }
}
