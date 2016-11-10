import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Dict {
	

	public HashMap<String,String> dictionary;  ///////////
		TriNode dic;
//		FileInputStream fis = null;
		
		public Dict(){         //////////////////////////////
	        dictionary=new HashMap<String,String>();
	        dic=new TriNode();
	      
	    }

		public void readDict(){
			BufferedReader br=null;////////////////
			InputStreamReader fr=null;////////////////////////
		 try{
			 fr=new InputStreamReader (new FileInputStream(new File("d:\\dictionary.txt")),"UTF-8");
	         br=new BufferedReader(fr);
             String line="";
             while((line=br.readLine())!=null){
                String[]array=line.split("  ");  //把字符串分割成一个个字符,分割后 0位置是英文 1位置是翻译  0位置是KEY
          //       dictionary.put(array[0], array[1]);//对key做null检查。如果key是null，会被存储到table[0]，因为null的hash值总是0。
                
                 array[0]=array[0]+"   "+array[1];
                 Trie.insert(dic, array[0]);
 
             
             }
            
    }catch(Exception e){
             e.printStackTrace();
    }finally{
             try{
            	 br.close();
                      fr.close();
             }catch(Exception e){
            	 e.printStackTrace();
             }
	}
		 
	}
		public String searchWord(String word){
	        String value="";
	        if( dictionary.containsKey(word)){ //Key不为NULL 
	            value=dictionary.get(word);
	        }
	        return value;
	    }

}

