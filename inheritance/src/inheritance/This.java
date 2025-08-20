package inheritance;


public class This{

	
	
	int a;
	This(int a){
	   this.a=a;   		
	} 
		void show() {
		System.out.println(a);
		
	}
	
public static void main(String[] args) {
		This r =new This(100);
		System.out.println(r);
		r.show();
	}
}
