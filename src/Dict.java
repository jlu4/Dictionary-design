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
                String[]array=line.split("  ");  //���ַ����ָ��һ�����ַ�,�ָ�� 0λ����Ӣ�� 1λ���Ƿ���  0λ����KEY
          //       dictionary.put(array[0], array[1]);//��key��null��顣���key��null���ᱻ�洢��table[0]����Ϊnull��hashֵ����0��
                
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
	        if( dictionary.containsKey(word)){ //Key��ΪNULL 
	            value=dictionary.get(word);
	        }
	        return value;
	    }

}

