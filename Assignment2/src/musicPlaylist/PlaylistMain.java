package musicPlaylist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class PlaylistMain {
// ,"C:\\\\Users\\\\felix\\\\Documents\\\\workspace-spring-tool-suite-4-4.4.1.RELEASE\\\\victorWork\\\\src\\\\assets\\\\regional-global-weekly-2020-02-28--2020-03-06.csv","C:\\\\Users\\\\felix\\\\Documents\\\\workspace-spring-tool-suite-4-4.4.1.RELEASE\\\\victorWork\\\\src\\\\assets\\\\regional-global-weekly-2020-03-06--2020-03-13.csv","C:\\\\Users\\\\felix\\\\Documents\\\\workspace-spring-tool-suite-4-4.4.1.RELEASE\\\\victorWork\\\\src\\\\assets\\\\regional-global-weekly-2020-03-13--2020-03-20.csv"
	public static void main(String[] args) {
		String[] myFiles = new String[]{"C:\\\\Users\\\\felix\\\\Documents\\\\workspace-spring-tool-suite-4-4.4.1.RELEASE\\\\victorWork\\\\src\\\\assets\\\\regional-global-weekly-2020-02-21--2020-02-28.csv","C:\\\\Users\\\\felix\\\\Documents\\\\workspace-spring-tool-suite-4-4.4.1.RELEASE\\\\victorWork\\\\src\\\\assets\\\\regional-global-weekly-2020-02-28--2020-03-06.csv"};
		
		ArrayList<MyQueue> allTheWeeks = new ArrayList<MyQueue>();
		
		for(int i=0; i<=myFiles.length-1;i++) {
			try {
				MyQueue dataExtract = new MyQueue(myFiles[i]);
				allTheWeeks.add(dataExtract);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		MyQueue mergedList = mergingFunction(allTheWeeks.get(0), allTheWeeks.get(1));
		
		
	}
	
	static MyQueue mergingFunction(MyQueue first, MyQueue second) {
		
		String[] myList = new String[first.getOrderedList().length + second.getOrderedList().length];
		MyQueue ret = new MyQueue();
		HashSet<String> noCopies = new HashSet<String>();
		for(int i=0; i<first.getOrderedList().length; i++) {
//			noCopies.add(first.getOrderedList()[i]);
			myList[i] = first.getOrderedList()[i];
		}
		for(int i=0; i< second.getOrderedList().length; i++) {
//			noCopies.add(second.getOrderedList()[i]);
			myList[i + first.getOrderedList().length] = second.getOrderedList()[i];
		}
//	    ArrayList<String> list = new ArrayList<String>(noCopies); 
//        Collections.sort(list); 
 
		Arrays.sort(myList);
		ret.setOrderedList(myList);
		
		
		
//		System.out.println("====================SORTED LIST======================");
		for(int i=0; i<myList.length; i++) {
			System.out.println(myList[i]);
		}
		
		return null;
	}
}
