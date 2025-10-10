public class Main {
public static void main(String[] args) {
IntStack st = new IntStack();
st.push(10);
st.push(20);
st.push(30);
System.out.println("peek = " + st.peek()); 
System.out.println("pop = " + st.pop()); 
System.out.println("size = " + st.size()); 
st.clear();
System.out.println("isEmpty = " + st.isEmpty()); 
}
}
