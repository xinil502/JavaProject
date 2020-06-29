package collection;

import java.util.Arrays;

/*
 * 实现 ArrayList
 */
public class ArrayList<E>{

    private Object[] elementData;
    private int size;
    private static final int DEFALT_CAPACITY = 10;

    public  ArrayList(){
        elementData = new Object[DEFALT_CAPACITY];
    }

    public  ArrayList(int x){
        if(x <= 0){
            throw new RuntimeException("容量不能为非正数");
        }
        elementData = new Object[x];
    }

    public void add(E e){
        if(size == elementData.length){
            arraysLengthAdd();
        }
        elementData[size++] = e;
    }

    public void arraysLengthAdd(){ //自动扩容数组
        Object[] newObj = new Object[elementData.length + (elementData.length >> 1)];
        System.arraycopy(elementData, 0, newObj, 0, elementData.length);
        elementData = newObj;
    }

    public E get(int index){
        checkRange(index);
        return (E) elementData[index];
    }

    public void set(int index, E e){
        checkRange(index);
        elementData[index] = elementData;
    }

    public void checkRange(int index){
        if(index < 0 || index >= size){ //合法索引判断
            throw new RuntimeException("超出索引范围：" + index);
        }
    }

    public void remove(int index){
        checkRange(index);
        System.arraycopy(elementData, index+1, elementData, index, size-index-1);
        elementData[size--] = null;
    }
    public int remove(E e){
        //判断第一个符合要求的索引
        for(int i=0; i<size; ++i){
            if(elementData[i].equals( e)){
                remove(i);
                return i;
            }
        }
        return -1;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public String toString(){
//        return Arrays.toString(elementData); 第一种输出方法
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for(int i=0; i<size; ++i){
            sb.append(elementData[i].toString() + ",");
        }
        sb.setCharAt(sb.length()-1, '}');
        return sb.toString();
    }
}

class Test{
    public static void main(String[] args) {
        ArrayList al1 = new ArrayList(12);
        for(int i = 0; i<20; ++i){
            al1.add(i);
        }
        System.out.println(al1.toString());
    }
}
