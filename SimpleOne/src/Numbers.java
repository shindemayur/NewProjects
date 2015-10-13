import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;

public class Numbers {
	 Integer m;
	String interst="yes";
	public int select;
	
	Numbers numbers;
	HashSet<Numbers> hs=new HashSet<Numbers>();
	
	public int getSelect() {
		return select;
	}


	public void setSelect(int select) {
		this.select = select;
	}


	public int getRs() {
		return rs;
	}


	public void setRs(int rs) {
		this.rs = rs;
	}


	public int rs;
	public HashSet<Numbers> shownumber()
	{
		
		HashSet<Numbers> hs1=new HashSet<Numbers>();
 		//String flag= "yes";
		
		while(!interst.equals("no"))
		{
		System.out.println("Nubmbers are :-");
		for(int i=1;i<=5;i++)
		{
			System.out.print(i+" ");
		}
		
	  hs1=selectNumbers();
	    
		}
		
		
		
		
		
		return hs1;
	}
	
	
	public HashSet selectNumbers()
	{
		String flag= "yes";
		
		
		System.out.println("\nselect the lucky Number");
		
		Scanner sc = new Scanner(System.in);
		select=sc.nextInt();
		System.out.println("selected no:-"+select);
		
		System.out.println("how much you want to deposit");
		rs=sc.nextInt();
		System.out.println("\ncash is"+rs);
		
		numbers=new Numbers();
		numbers.setRs(rs);
		numbers.setSelect(select);
		hs.add(numbers);
		
		System.out.println("slect exit :-no  and yes to continue");
		interst =sc.next();
		
		return hs;
	}
	
	
	public void getcollection(HashMap hm)
	{
		int onecol=0,twocol=0,threecol=0,fourcol=0,fivecol=0;
		System.out.println("in get collection class");
		Set  setcol=hm.keySet();
		Iterator itr =setcol.iterator();
	while (itr.hasNext()) {
		int keyelement=(int)itr.next();
		
		
		if(keyelement==1)
		{
			 onecol=(int)hm.get(keyelement);
			System.out.println("1 collection="+onecol);
			
		}
		else if (keyelement==2)
		{
			twocol=(int)hm.get(keyelement);
			System.out.println("2 collection="+twocol);
		}
		else if (keyelement==3)
		{
			threecol=(int)hm.get(keyelement);
			System.out.println("3 collection="+threecol);
		}
		else if (keyelement==4)
		{
			threecol=(int)hm.get(keyelement);
			System.out.println("4 collection="+threecol);
		}
		else if (keyelement==5)
		{
			threecol=(int)hm.get(keyelement);
			System.out.println("5 collection="+threecol);
		}
	}
	   int finalcollection=onecol+twocol+threecol+fourcol+fivecol;
	   System.out.println("final collection is="+finalcollection);
	
	}
	
	
	
	public static void main(String[] args) 
	{
		
		Timer timer = new Timer();
		
		
		int one=0,two=0,three=0,four=0,five=0;
		System.out.println("how many person access the application");
		Scanner sc= new Scanner(System.in);
		int person=sc.nextInt();
		System.out.println("uses person application"+person);
		Numbers no2=new Numbers();
		for(int m=1;m<=person;m++)
		{	
		
		
			Numbers no= new Numbers();
		
	HashSet<Numbers> hn =no.shownumber();
		System.out.println("thank you");
		
		System.out.println("selected data is");
		
		Iterator itr =hn.iterator();
		while (itr.hasNext()) {
			Numbers nm = (Numbers) itr.next();
			System.out.println(nm.getSelect());
			System.out.println(nm.getRs());
			
			int key=nm.getSelect();
			System.out.println("key element"+key);
			
			switch (key) {
			case 1: System.out.println("match key to one");
			        one=one+nm.getRs();
			        System.out.println("in switch statement"+one);
				break;
				
			case 2: 
					System.out.println("match key to two");
	        		two=two+nm.getRs();
	        		System.out.println("in switch statement"+two);
	        		break;
			case 3: 
				System.out.println("match key to three");
        		three=three+nm.getRs();
        		System.out.println("in switch statement"+three);		
        		break;
			case 4: 
				System.out.println("match key to four");
        		four=four+nm.getRs();
        		System.out.println("in switch statement"+four);	
        		break;
			case 5: 
				System.out.println("match key to five");
        		five=five+nm.getRs();
        		System.out.println("in switch statement"+five);	
        		break;
        			

			default:System.out.println("select value");
				break;
			}
			
		
		}
		
	}
		
		
		
	HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
	hm.put(1, one);
	hm.put(2, two)	;
	hm.put(3, three);
	hm.put(4, four)	;
	hm.put(5, five)	;
	
	
	
		
 int last=Collections.min(hm.values());
	System.out.println(last);

	
    Integer strKey = null;
    for(Entry<Integer, Integer> entry: hm.entrySet()){
        if(last==(entry.getValue())){
            strKey = entry.getKey();
            break; //breaking because its one to one map
        }
       
        
        
        
    }
    	
    int mi=(Integer)strKey;
    System.out.println("key"+strKey);
    
		no2.getcollection(hm);
      
		
		System.out.println("wait for 10 second time result will be declare");
		System.out.println(new Date());
		
		timer.schedule(new TimerTask() {

			   public void run() {
				   
				   
			      //here you can start your Activity B.
				   System.out.println("Lucky Number is="+mi);
			   }

			}, 10000);
	
		
	}
    
	
	
	
}
