package main;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Iterables {
    public static void main(String[] args) {
        //构造数组
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        //定义iterator
        Iterator iterator = list.iterator();
        //while循环
        while (iterator.hasNext()) {//判断下面是否还有元素
            Integer number = (Integer) iterator.next();//指向下一个元素
//            System.out.println(number);
            if (number == 3) {
                iterator.remove();
            }
        }
        while (iterator.hasNext()) {//判断下面是否还有元素
            Integer number = (Integer) iterator.next();//指向下一个元素
            System.out.println(number);
        }
        System.out.println(Iterables.class.getClassLoader().getParent());
    }
}
