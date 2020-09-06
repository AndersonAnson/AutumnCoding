package basisGrammar;

public class IntegerValueOfDemo {
    public static void main(String[] args) {
        String tempWord = "123";
        String password = "456";
        int index = 1;
        int sum = tempWord.charAt(index) - '0' + password.charAt(index) - '0';
        int sum2 = Integer.valueOf(tempWord.charAt(index)) + Integer.valueOf(password.charAt(index));
        int sum3 = Integer.valueOf("123") + Integer.valueOf("456");
        System.out.println(sum);
        System.out.println(sum2);
        System.out.println(sum3);
        System.out.println(Integer.valueOf("789"));//Integer.valueOf如果是字符串就直接可以进行整数运算
        System.out.println(Integer.valueOf('7'));//Integer.valueOf如果是字符的话就要减'0'才可以进行整数运算
    }
}
