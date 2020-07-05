package collection;

public class HashMap <K, V>{

    private HashMapNode[] table;// 位桶数组bucket array
    private int size; //存储的键值对的个数

    public HashMap(){
        table = new HashMapNode[16];
    }

    public void put(K key, V value){
        //可以添加一个数组扩容
        HashMapNode newNode = new HashMapNode();
        newNode.hash = myHash(key.hashCode(), table.length);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;

        ++size;

        HashMapNode head = table[newNode.hash], last;
        if(head == null){
            table[newNode.hash] = newNode;
        }else{
            last = head;
            while(head != null){
                if(head.key.equals(newNode.key)){
                    head.value = newNode.value;
                    --size;
                    return;
                }
                last = head;
                head = head.next;
            }
            last.next = newNode;
        }
    }

    public int myHash(int hashCode, int length){
        return hashCode&(length-1); //length必须为2的整数倍
    }

    public String toString(){
        if(size == 0){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for(int i=0; i<table.length; ++i){
            HashMapNode head = table[i];
            while(head != null){
                sb.append("" + head.key + ":" + head.value + ", ");
                head = head.next;
            }
        }
        if(sb.length() == 1){
            return "";
        }
        sb.setCharAt(sb.length()-2, '}');
        return sb.toString();
    }
}

class HashMapNode{
    int hash;
    Object key;
    Object value;
    HashMapNode next;
}

class TestHashMap{
    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(10, "ten");
        hm.put(11, "eleven");
        hm.put(12, "twelve");
        hm.put(30, "thirty");
        System.out.println(hm);
    }
}