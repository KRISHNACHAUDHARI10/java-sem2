package thisisshape;

public interface Shape {

     public void  drawshape();
      
     public void  color();   
      public default  void  printshape() {
    	  System.out.print("this is method default from shape");
      }
      
      

}
