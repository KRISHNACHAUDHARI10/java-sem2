
package Stack;
import java.util.Stack;

public class LearnStack {
  public static void main(String[] args) {
    Stack <String> animal = new  Stack<>();
    animal.push("react");
    animal.push("java");
    animal.push("python");
    animal.push("react.js");
    System.out.print(animal);
    System.out.print(animal.peek());
	  
  }
}
