package collection;

public class HashMap <K, V>{

    private HashMapNode[] table;// 位桶数组bucket array
    private int size; //存储的键值对的个数
    private static final double K = 0.75;

    public HashMap(){
        table = new HashMapNode[16];
    }
    public HashMap(int lenth){
        table = new HashMapNode[lenth];
    }

    public void put(K key, V value){
        if(size + 1 >= table.length * K){
            resize();
        }
        //可以添加一个数组扩容***
        HashMapNode<K, V> newNode = new HashMapNode<>();
        newNode.hash = myHash(key.hashCode(), table.length);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;

        ++size;

        HashMapNode head = table[newNode.hash], last;
        if(head == null){  //头结点不存在
            table[newNode.hash] = newNode;
        }else{
            last = head;
            while(head != null){
                if(head.key.equals(newNode.key)){ //如果有重复键，则修改对应的值，之后直接跳出。
                    head.value = newNode.value;
                    --size;
                    return;
                }
                last = head; //保留最后一个结点
                head = head.next;
            }
            last.next = newNode; //未找到相同的键，在最后一个结点后加上新结点
        }
    }

    public void resize(){
        if(size >= 2*30){
            return;
        }
        HashMap hm = new HashMap(table.length * 2);

        for(int i=0; i<table.length; ++i){
            HashMapNode temp = table[i];
            while(temp != null){
                hm.put(temp.key, temp.value);
                temp = temp.next;
            }
        }

        table = hm.table;
    }

    public V get(K key){


        HashMapNode<K, V> temp = table[myHash(key.hashCode(), table.length)];
        while(temp != null){
            if(temp.key.equals(key)){
                return (V)temp.value;
            }
            temp = temp.next;
        }
        return null;
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
        sb.deleteCharAt(sb.length()-1);
        sb.setCharAt(sb.length()-1, '}');
        return sb.toString();
    }
}

class HashMapNode<K, V>{
    int hash;
    K key;
    V value;
    HashMapNode next;
}

class TestHashMap{
    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap<>();
        for(int i=0; i<26; ++i){
            hm.put(i, "" + (char)('a'+i));
        }
        System.out.println(hm);
        System.out.println(hm.get(10));
    }
}