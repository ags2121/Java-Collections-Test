package homework_4;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

public class CollectionsTest {
	
	//FIELDS
	private static ArrayList<String> strArr;
	private static Hashtable<Integer, String> strHash;
	private static LinkedList<String> strList;
	
	private static int nArrTot;
	private static int nHashTot;
	private static int nListTot;
	private static int nNumOfStrings;
	
	private static String strAction;
	private static String strProp;
	
	private final static int SCALED_MIN = 0;
	private final static int SCALED_MAX = 54;
	private final static int MAX_STRING_LENGTH = 10;
	
	//program to test amount of time to add and retrieve a specified amount of Strings
	//Strings are randomly constructed.
	
	//CONSTRUCTOR
	public CollectionsTest(){}
	
	
	//METHODS
	public void add(int nObs){
		
		nNumOfStrings = nObs;
		strAction = "add";
		strProp = "to";
		
		//fill source array will an nObs amount of randomly constructed strings
		String[] source = new String[nObs];
		fillSource(source);
		
		//start timing array add
		long arrStart = System.currentTimeMillis();
		fillArray(source);
		//end timing array add
		long arrEnd = System.currentTimeMillis();
		long arrTotal = arrEnd - arrStart;
		setnArrTot((int)arrTotal);
		
		//start timing HashTable add
		long hashStart = System.currentTimeMillis();
		fillHash(source);
		//end timing array add
		long hashEnd = System.currentTimeMillis();
		long hashTotal = hashEnd - hashStart;
		setnHashTot((int)hashTotal);
		
		//start timing LinkedList add
		long listStart = System.currentTimeMillis();
		fillList(source);
		//end timing LinkedList add
		long listEnd = System.currentTimeMillis();
		long listTotal = listEnd - listStart;
		setnListTot((int)listTotal);
		
		//computes and prints scaled histograms
		printScaledGraph(nArrTot, nHashTot, nListTot);
		
	}

	public void retrieve(int nObs){
		
		nNumOfStrings = nObs;
		strAction = "retrieve";
		strProp = "from";
		
		//fill source array will an nObs amount of randomly constructed strings
		String[] source = new String[nObs];
		fillSource(source);
		String[] result = new String[nObs];
		
		//add Strings to Array
		fillArray(source);
		//start timing array retrieve
		long arrStart = System.currentTimeMillis();
		for(int i=0;i<source.length;i++){
			result[i] = strArr.get(i);
		}
		//end timing array retrieve
		long arrEnd = System.currentTimeMillis();
		long arrTotal = arrEnd - arrStart;
		int nArrTot = (int)arrTotal;
		
		//add Strings to hashtable
		fillHash(source);
		//start timing hash retrieve
		long hashStart = System.currentTimeMillis();
		for(int i=0;i<source.length;i++){
			result[i] = (String) strHash.get(i);
		}
		//end timing array retrieve
		long hashEnd = System.currentTimeMillis();
		long hashTotal = hashEnd - hashStart;
		int nHashTot = (int)hashTotal;
		
		//add Strings to list
		fillList(source);
		//start timing LinkedList retrieve
		long listStart = System.currentTimeMillis();
		for(int i=0;i<source.length;i++){
			result[i] = (String) strList.get(i);
		}
		//end timing list retrieve
		long listEnd = System.currentTimeMillis();
		long listTotal = listEnd - listStart;
		int nListTot = (int)listTotal;
		
		//computes and prints scaled histograms
		printScaledGraph(nArrTot, nHashTot, nListTot);
		
	}
	
	public static void fillArray(String[] source) {
		strArr = new ArrayList<String>();
		for(int i=0;i<source.length;i++){
			strArr.add(source[i]);
		}
	}

	public static void fillHash(String[] source) {
		strHash = new Hashtable<Integer, String>();
		for(int i=0;i<source.length;i++){
			strHash.put((Integer)i, source[i]);
		}
	}
	
	public static void fillList(String[] source) {
		strList = new LinkedList<String>();
		for(int i=0;i<source.length;i++){
			strList.add(source[i]);
		}
	}

	
	//prints scaled histograms of results (scaled min and max values are set as constants above)
	public static void printScaledGraph(int arrayT, int hashT, int listT){
		
		int[] localArr = {arrayT, hashT, listT};
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<localArr.length; i++){
			if(localArr[i]<min){
				min = localArr[i];
			}
			else if(localArr[i]>max){
				max = localArr[i];
			}
		}
		
		int scaledArrT = scaleFunction(arrayT, max, min);
		int scaledHashT = scaleFunction(hashT, max, min);
		int scaledListT = scaleFunction(listT, max, min);
		
		System.out.println("Milliseconds to "+strAction+" "+nNumOfStrings+" Strings "+strProp+" ArrayList:");
		printGraph(scaledArrT, arrayT);
		
		System.out.println("Milliseconds to "+strAction+" "+nNumOfStrings+" Strings "+strProp+" HashTable:");
		printGraph(scaledHashT, hashT);
		
		System.out.println("Milliseconds to "+strAction+" "+nNumOfStrings+" Strings "+strProp+" LinkedList:");
		printGraph(scaledListT, listT);
		
	}
	
	private static void printGraph(int scaledT, int rawT){
		
		for(int i=0;i<scaledT;i++){
			System.out.print("*");
		}
		
		System.out.println();
		System.out.println(rawT+" ms");
		System.out.println();
	}
	
	private static int scaleFunction(int rawVal, int max, int min){
		
		if ( (max-min) == 0){
			return 0;
		}
		
		return ( ((SCALED_MAX-SCALED_MIN)*(rawVal-min)) / (max-min) );
		
	}
	
	private static void fillSource(String[] source) {
		
		for(int i=0;i<source.length;i++){
			source[i]=randomString(1, MAX_STRING_LENGTH);
		}
		
	}
    
    public static String randomString(int nlow, int nhigh){
    	String strOut = "";
    	int nLim = randBetween(nlow, nhigh);
    	
    	for(int i=1;i<=nLim;i++){
    		char c = (char)randBetween(97,122);
    		strOut+=Character.toString(c);
    	}
    	
    	return strOut;
    }
    
    public static int randBetween(int start, int end) {
    	return start + (int)Math.round(Math.random() * (end - start));
	}

	public int getnArrTot() {
		return nArrTot;
	}

	public static void setnArrTot(int nArrTot) {
		CollectionsTest.nArrTot = nArrTot;
	}

	public int getnHashTot() {
		return nHashTot;
	}

	public static void setnHashTot(int nHashTot) {
		CollectionsTest.nHashTot = nHashTot;
	}

	public int getnListTot() {
		return nListTot;
	}

	public static void setnListTot(int nListTot) {
		CollectionsTest.nListTot = nListTot;
	}
	
	public static int getMAX_STRING_LENGTH(){
		return MAX_STRING_LENGTH;
	}
}
	

