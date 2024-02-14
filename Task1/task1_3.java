/*for Scenario 1: 4 People entered elevator from floor 5.
Person 1: Requests to go at floor 3
Person 2: Requests to go at floor 6
person 3: Requests to go at floor 10
person 4: Requests to go at floor 1
Elevator should start moving in the direction first which is nearest from the current floor*/
import java.util.*;
class task1_3{
    static int num_Floors;
    static int npe;
    public static void move_to_floor(int[] arr,int currentFloor)
    {
        
        HashMap<Integer,Integer> hm=new HashMap<>();  //floor numbers and their respective distance are stored in hashmap
        for(int i=0;i<arr.length;i++)
        {
            hm.put(arr[i],0);
        }
        floor_diff(hm,currentFloor);

    }
    //floor difference is updated recursively after updating the current floor
    public static void floor_diff(HashMap<Integer,Integer> hm,int cf)
    {
        if(hm.isEmpty())
        {
            return;
        }
        int min=Integer.MAX_VALUE;
        int k=cf;
        for (Integer n:hm.keySet())     
        { 
            if(min>Math.abs(cf-n)){
                min=Math.abs(cf-n);
                k=n;
            }
            hm.put(n,Math.abs(cf-n));
        }
        hm.remove(k);      //current floor is removed from hashmap 
        System.out.println(k);
        floor_diff(hm,k);;
        
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Number of Floors : ");
        int num_Floors=sc.nextInt();
        System.out.print("Enter Current Floor : ");
        int currentFloor=sc.nextInt();
        System.out.print("Enter Number of Persons entering : ");
        int npe=sc.nextInt();
        int[] arr=new int[npe];
        System.out.println("Enter floor numbers :");
        for (int i=0;i<npe;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("Sequence of Floors :");
        move_to_floor(arr,currentFloor);
    }
}


/*
 Enter Number of Floors : 10
Enter Current Floor : 5
Enter Number of Persons entering : 4
Enter floor numbers :
3
6
10
1
Sequence of Floors :
6
3
1
10

Enter Number of Floors : 10
Enter Current Floor : 4
Enter Number of Persons entering : 5
Enter floor numbers :
5
7
6
10
1
Sequence of Floors :
5
6
7
10
1
 */