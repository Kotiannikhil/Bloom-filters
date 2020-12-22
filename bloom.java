import java.util.*;
import java.io.*;
public class bloom{
  static int num,numbits,numhashes,res1 = 1000,res2 = 0;
  static HashSet<Integer> hset1 = new HashSet<>();
  static HashSet<Integer> hset2 = new HashSet<>();
  static int[] barray;
  static int[] s;
  public static void main(String[] args){
    try{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements to be encoded: ");
        num = sc.nextInt();
        System.out.println("Enter the number of bits in the filter: ");
        numbits = sc.nextInt();
        System.out.println("Enter the number of hashes: ");
        numhashes = sc.nextInt();
        barray = new int[numbits];
        s = new int[numhashes];
        randomgenerator();
        int i = 1,var;
        int low = 1,high = Integer.MAX_VALUE;
        Random r = new Random();
        while(i <= num){
          var = r.nextInt(high - low + 1);
          if(hset1.contains(var)){
            continue;
          }
          hset1.add(var);
          for(int j = 0;j < s.length;j++){
            barray[hindex(var,j)] = 1;
          }
          i += 1;
        }
        i = 1;
        while(i <= num){
          var = r.nextInt(high - low + 1);
          if(hset2.contains(var)){
            continue;
          }
          hset2.add(var);
          boolean flag = false;
          for(int j = 0;j < s.length;j++){
            flag = false;
            if(barray[hindex(var,j)] == 0){
              flag = true;
              break;
            }
          }
          if(flag == false)
            res2 += 1;
          i += 1;
        }
        BufferedWriter bwriter = new BufferedWriter(new FileWriter("bloom.txt"));
        bwriter.write("The number of elements in the filter after lookup of elements in set A are: "+res1+"\n");
        bwriter.write("The number of elements in the filter after lookup of elements in set B are: "+res2);
        bwriter.close();
        //System.out.println(res1);
        //System.out.println(res2);
    }
    catch (Exception e) {
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
    return (var^s[position]) % numbits;
  }
}
