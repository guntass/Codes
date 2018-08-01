import java.util.*;
import java.io.*;
public class WhatsInTheName
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        String[] s=new String[t];
        for(int ii=0;ii<t;ii++)
        {
           s[ii]=br.readLine();
            //System.out.println("test1");
        }
        for(int iii=0;iii<t;iii++)
        {
          String input=s[iii].toLowerCase();
          String p="";
          String[] words=input.split(" ");
          if(words.length==1)
          {
              p=p+(input.charAt(0)+"").toUpperCase();
              p=p+words[0].substring(1);
              System.out.println(p); 
          }
          else if(words.length==2)
          {
              p=p+(input.charAt(0)+"").toUpperCase()+". ";
              p=p+words[1].substring(0,1).toUpperCase();
              p=p+words[1].substring(1);
              System.out.println(p); 
          }
          else
          {
              p=p+(input.charAt(0)+"").toUpperCase()+". ";
              p=p+(words[1].charAt(0)+"").toUpperCase()+". ";
              p=p+words[2].substring(0,1).toUpperCase();
              p=p+words[2].substring(1);
              System.out.println(p); 
          }
        }
    }
}


