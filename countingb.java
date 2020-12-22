import java.util.*;
import java.io.*;
public class countingb{
  static int num,rem,add,numcounters,numhashes;
  static int[] carray;
  static int[] s;
  static HashMap<Integer,Integer> hmap1 = new HashMap<>();
  static HashMap<Integer,Integer> hmap2 = new HashMap<>();
  public static void main(String[] args) throws IOException{
    try{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements to be encoded initally: ");
        num = sc.nextInt();
        System.out.println("Enter the number of elements to be removed: ");
        rem = sc.nextInt();
        System.out.println("Enter the number of elements to be added: ");
        add = sc.nextInt();
        System.out.println("Enter the number of counters in the filter: ");
        numcounters = sc.nextInt();
        System.out.println("Enter the number of hashes: ");
        numhashes = sc.nextInt();
        carray = new int[numcounters];
        s = new int[numhashes];
        randomgenerator();
        int i = 1,var;
        int low = 1,high = Integer.MAX_VALUE;
        Random r = new Random();
        while(i <= num){
          var = r.nextInt(high - low + 1);
          if(hmap1.containsValue(var)){
            continue;
          }
          hmap1.put(i,var);
          for(int j = 0;j < s.length;j++){
            carray[hindex(var,j)] += 1;
          }
          i += 1;
        }
        for(i = 1;i <= rem;i++){
          for(int j = 0;j < s.length;j++){
              carray[hindex(hmap1.get(i),j)] -= 1;
          }
        }
        for(i = 1;i <= add;i++){
          var = r.nextInt(high - low + 1);
          if(hmap2.containsValue(var)){
            continue;
          }
          hmap2.put(i,var);
          for(int j = 0;j < s.length;j++){
              carray[hindex(var,j)] += 1;
          }
        }
        i = 1;
        boolean flag = false;
        int res = 0;
        while(i <= num){

          for(int j = 0;j < s.length;j++){
              flag = false;
              if(carray[hindex(hmap1.get(i),j)] == 0){
                flag = true;
                break;
              }
            }
            if(flag == false)
              res += 1;
            i += 1;
        }
        BufferedWriter bwriter = new BufferedWriter(new FileWriter("countingb.txt"));
        bwriter.write("The number of elements in the filter after lookup of elements in set A are: "+res+"\n");
        bwriter.close();
        //System.out.println(count);
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
  public static void randomgenerator() {
    int low = 1, high = Integer.MAX_VALUE;
    Random r = new Random();
    int range = (high - low) + 1;
    for(int i=0; i<numhashes; i++)
      s[i] = r.nextInt(range) + low;
  }
  public static int hindex(int var, int position){
    return (var^s[position]) % numcounters;
  }
}
