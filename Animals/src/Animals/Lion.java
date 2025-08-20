package Animals;

class Lion extends Animal{
    int  height;
    boolean  marrid;
    
    
	public Lion(int age, String gender, double weight,int height,boolean marrid) {
		  super(age, gender, weight);  
         this.height=height;
         this.marrid=marrid;
        	
	}
	//method lion sounding
	
	public void sound() {
		System.out.println("Lion are rors");
	}

	public  void details() {
		System.out.println("------ lion informaiton ----");
	     super.details();
	     System.out.println("helo i am lion");
	     System.out.print( "lion height" + "  "+height + "lion is marrid" + "  " + marrid);
	 }
}
