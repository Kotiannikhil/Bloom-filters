import java.util.*;
import java.io.*;
public class codedb{
  static int sets,numel,filters,numbits,numhashes;
  static int[][] farray;
  static int[] s;
  static HashMap<Integer,Integer> hmap1 = new HashMap<>();
  static HashMap<Integer,Integer> hmap2 = new HashMap<>();
  static HashMap<Integer,Integer> hmap3 = new HashMap<>();
  static HashMap<Integer,Integer> hmap4 = new HashMap<>();
  static HashMap<Integer,Integer> hmap5 = new HashMap<>();
  static HashMap<Integer,Integer> hmap6 = new HashMap<>();
  static HashMap<Integer,Integer> hmap7 = new HashMap<>();
  public static void main(String[] args){
    try{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of sets: ");
        sets = sc.nextInt();
        System.out.println("Enter the number of elements in each set: ");
        numel = sc.nextInt();
        System.out.println("Enter the number of filters: ");
        filters = sc.nextInt();
        System.out.println("Enter the number of bits in each filter: ");
        numbits = sc.nextInt();
        System.out.println("Enter the number of hashes: ");
        numhashes = sc.nextInt();
        farray = new int[filters][numbits];
        s = new int[numhashes];
        randomgenerator();
        int var;
        int low = 1,high = Integer.MAX_VALUE;
        Random r = new Random();
        for(int i = 1;i <= sets;i++){
          String bin = Integer.toBinaryString(i);
          while(bin.length() < 3)
            bin = "0"+bin;
          for(int j = 1;j <= numel;j++){
            var = r.nextInt(high - low + 1);
            if(i == 1 && !hmap1.containsValue(var)){
                hmap1.put(j,var);
            }
            else if(i == 2 && !hmap2.containsValue(var)){
                hmap2.put(j,var);
            }
            else if(i == 3 && !hmap3.containsValue(var)){
                hmap3.put(j,var);
            }
            else if(i == 4 && !hmap4.containsValue(var)){
                hmap4.put(j,var);
            }
            else if(i == 5 && !hmap5.containsValue(var)){
                hmap5.put(j,var);
            }
            else if(i == 6 && !hmap6.containsValue(var)){
                hmap6.put(j,var);
            }
            else if(i == 7 && !hmap7.containsValue(var)){
                hmap7.put(j,var);
            }
            else{
              j -= 1;
              continue;
            }
            for(int k = 0;k < s.length;k++){
              if(bin.charAt(0) == '1')
                farray[0][hindex(var,k)] = 1;
              if(bin.charAt(1) == '1')
                farray[1][hindex(var,k)] = 1;
              if(bin.charAt(2) == '1')
                farray[2][hindex(var,k)] = 1;
            }
          }
        }

        int temp = 0,count = 0;
        int flag1= 0,flag2 = 0,flag3 = 0;
        for(int i = 1;i <= sets;i++){
          String bin = Integer.toBinaryString(i);
          while(bin.length() < 3){
            bin = "0"+bin;
          }
          for(int j = 1;j <= numel;j++){
            flag1 = 0;
            flag2 = 0;
            flag3 = 0;
            var = r.nextInt(high - low + 1);
            if(i == 1){
                temp = hmap1.get(j);
            }
            else if(i == 2){
                temp = hmap2.get(j);
            }
            else if(i == 3){
                temp = hmap3.get(j);
            }
            else if(i == 4){
                temp = hmap4.get(j);
            }
            else if(i == 5){
                temp = hmap5.get(j);
            }
            else if(i == 6){
                temp = hmap6.get(j);
            }
            else if(i == 7){
                temp = hmap7.get(j);
            }
            for(int k = 0;k < s.length;k++){
              if(bin.charAt(0) == '0' && farray[0][hindex(temp,k)] == 1){
                flag1 += 1;

              }
              if(bin.charAt(1) == '0' && farray[1][hindex(temp,k)] == 1){
                flag2 += 1;

              }
              if(bin.charAt(2) == '0' && farray[2][hindex(temp,k)] == 1){
                flag3 += 1;

              }
            }
            if(flag1 != numhashes && flag2 != numhashes && flag3 != numhashes)
              count += 1;
          }
        }
        BufferedWriter bwriter = new BufferedWriter(new FileWriter("codedb.txt"));
        bwriter.write("The number of elements whose lookup results are correct: "+count);
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
    return (var^s[position]) % numbits;
  }
}
