package cn.wmj.xml;

import java.util.*;

public class Dome1 {
    public static void main(String[] args) {
       String str="服微端云入加迎欢|welcome join us !";
       char [] strs= str.substring(0,str.indexOf("|")).toCharArray();
        String substring = str.substring(8);
        String s="";
        for (int i=strs.length-1;i>-1;i--){
            s+=strs[i];
   }
       int num=0;
        Map<String,Integer> map=new HashMap<>();
        System.out.println(s+substring);
        String []  substring2 = str.substring(str.indexOf("w"),str.indexOf("!")).replace(" ","").split("");
        for (int i=0;i<substring2.length;i++){
            if (!map.containsKey(substring2[i])){
                map.put(substring2[i],1);
            }else{
               int o= map.get(substring2[i]);
                map.put(substring2[i],o+1);
            }
        }
      for(Map.Entry<String,Integer > entry : map.entrySet()) {
            System.out.println(" 字母 ：" + entry.getKey() + " 次数 ：" + entry.getValue());
        }




    }
}
