package pkgInterFasEx;

public class ShapeDemo {
    public static void main(String[] args) {
     
     Ractangle recobj = new Ractangle();
     
      recobj.drawshape(4);
      recobj.printShapeDetailes();
      
      
      Shape shobj = new Ractangle();
      shobj.drawshape(5);
      shobj.printShapeDetailes();
}

}
