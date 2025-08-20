package CollectionFremwork;


import java.util.HashMap;
import java.util.Map;
public class MapEx {
   Map<String,String> teamsIPL =new HashMap<String,String>();
   Map<String,IPLTeam> teamsIPL1= new HashMap<String,IPLTeam>();
   
   public void addElementsToMap()
   {	
	    teamsIPL.put("CSKt","Ruturaj Gaikwad");
	    teamsIPL.put("RCB","Ruturaj Patidar");
	    teamsIPL.put("MI","Hardik Pandiya");
	    
	    
	    //add remaining teams with their captians
	    teamsIPL.put("KKR","Shreyas Iyer");
	    teamsIPL.put("RR","SANJU SAMSON");
	    teamsIPL.put("LSG","Rishbh Pant");
	     System.out.print("Teams added successfully to the map");
	     System.out.print("Size of the map is :" + teamsIPL.size());
   }

   
   public void addElementsToMap1() {
	   teamsIPL1.put("CSR", new IPLTeam("CSK","RuturajGaikwad",1));
	   teamsIPL1.put("CSR", new IPLTeam("RR","Sanju Smason",2));
	   System.out.print("Elements added to mpi .sizwe is :" +teamsIPL1.size());
	   
   }
   public void traversingMap() {
	   System.out.print("We will print the names and caption names of IPL Tems");
	   for(Map.Entry<String,String> en:teamsIPL.entrySet()) {
	      System.out.print("Team Name"+en.getKey()+"Captain name :"+en.getValue());	   
	   }
   }
   public void traversingMAP1() {
	  System.out.print("we will peint the names and captain name of IPL team1 .");
	  for(Map.Entry<String,IPLTeam>en:teamsIPL1.entrySet()) {
		  
		  System.out.print("Team name" + en.getKey());
		  IPLTeam objTemp = (IPLTeam)en.getValue();
		  System.out.print("Captain Nm :" +objTemp.captainName);
		  System.out.print("Captian Nm:" +objTemp.teamRank);
	  }
   }
   
   public void addNewTeams() {
	   //PBKS - San Curren
	   //dC - Rishbh PAanthh
	   teamsIPL.put("PBKS","Sam Curren");
	   teamsIPL.put("PBKS","Rishbha pant");
	   System.out.print("Size of the map is : "+teamsIPL.size());
	   
   }
   public void chnageElements(String key, String newVal) {
	   teamsIPL.put(key, newVal);
   }
   public void chnageElements(String key, IPLTeam tmObj) {
	   teamsIPL.put(key, tmObj);
   }
   public void removeElementes(String key) {
	   teamsIPL.remove(key);
   }
  
}
