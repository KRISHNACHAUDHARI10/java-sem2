package Eccoarce;

public class FontedDev  extends Employee{
       String languge;
        int   expriance;
        
        
        public FontedDev(String name,int  conteact,String addresh, String email,int password,String languge,int expriance) {
        	super(name,conteact,addresh,email,password);
        	this.languge=languge;
        	this.expriance=expriance;
        	
        }
	 
        
        public  String getlanguge() {
        	return languge;
         }
	    
        public int  expriance() {
          return expriance;
        }



}
