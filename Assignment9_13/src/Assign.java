import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class Assign {

	public static void main(String[] args) {
		
		int[] arr = {0,2,0,1,0,2,1,2,1,0}; 
		int[] arr1= {4,7,2,3,4,9,8};
		Assign obj = new Assign();
		System.out.println(Arrays.toString(obj.move(arr)));
		System.out.println(Arrays.toString(obj.rotate(arr1,3)));
		System.out.println(Arrays.toString(obj.removedups(arr)));
		System.out.println(Assign.longestSubstring("abcbbcbhkafbskfbak"));
		System.out.println(Assign.vowels("sandeep"));
	}
	//moving 0 s to right
	public int[] move(int[] arr)
	{
		int count=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i] !=0)
			{
			arr[count++] = arr[i];
			}
		}
		while(count<arr.length)
		{
			arr[count++]=0;
		}
		return arr;
	}
	//rotate an array to right
	public int[] rotate(int[] arr,int input)
	{
		for(int j=1;j<=input;j++) {
		int temp = arr[arr.length-1];
		for(int i =arr.length-1;i>0;i--) 
		{
			arr[i]=arr[i-1];
		}
		arr[0]=temp;
		}
		return arr;
	}
	
	//remove duplicates from array without collection framework
	public int[] removedups(int[] arr)
	{
		Arrays.sort(arr);
		int length =0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[length] !=arr[i])
			{
				length++;
				arr[length]=arr[i];
			}
		}
		int res[] = new int[length+1];
		for(int i=0;i<=length;i++)
		{
			res[i]=arr[i];
		}
		return res;
	}
	// longest sub string with out repeated characters
	public static String longestSubstring(String input)
    {	
        char[] charArray = input.toCharArray();
        String sub = null;
        int length = 0;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
         
        for (int i = 0; i < charArray.length; i++) 
        {
            char current = charArray[i];
            if(!map.containsKey(current))
            {
                map.put(current, i);
            }
              //If current is already present in charPosMap, repositioning the cursor i to the 
            //position of current and clearing the charPosMap
             else
            {    
                i = map.get(current);
                map.clear();
            }
              if(map.size() > length)
            {
                length = map.size();
                 sub = map.keySet().toString();
            }
        }
        
       return sub;
    }
     
	//reverse vowels in a string
	public static String vowels(String input)
	{
			HashSet<Character> vowels = new HashSet<Character>();
			vowels.add('a');
			vowels.add('e');
			vowels.add('i');
			vowels.add('o');
			vowels.add('u');
			vowels.add('A');
			vowels.add('E');
			vowels.add('I');
			vowels.add('O');
			vowels.add('U');
			
			char[] array = input.toCharArray();
			int i=0,j=array.length-1;
			while(i<j) 
			{
					if(!vowels.contains(array[i]))
					{i++;}
					if(!vowels.contains(array[j])) 
					{j--;}
					if(vowels.contains(array[i]))
					{
						if(array[i] != array[j])
						{
							char temp = array[i];
							array[i] = array[j];
							array[j] = temp;
						}
						i++;j--;
					}
						
				}
			return String.valueOf(array);
	}
}










