package org.example.task3;

public class Main {
    public static void main(String[] args) {
        IntStack st = new IntStack();
        st.push(10);
        st.push(20);
        System.out.println(st.peek()); 
        System.out.println(st.pop());  
        System.out.println(st.size()); 
    }
}
