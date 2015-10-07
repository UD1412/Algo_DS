package StringsRelated;

/**
 * Created by Upasana on 9/30/2015.
 */
public class Permutation2 {

    public static void permute(String str, int st)
    {
        //System.out.println("str = "+ str );
       // System.out.println("index = "+ st );
        if(st == str.length()) {
            System.out.println(str);
            return;
        }

        char[] c1 = str.toCharArray();
        for( int i = st; i < str.length(); i++)
        {
          //  System.out.println("Starting String "+ new String(c1) );
            char ct = c1[st];
            c1[st] = c1[i];
            c1[i] = ct;
            permute(new String(c1), st+1);
            ct = c1[st];
            c1[st] = c1[i];
            c1[i] = ct;
          //  System.out.println("Final String "+ new String(c1) );

        }


    }
    public static void main(String[] args)
    {
        String test = "abcd";

        permute(test,0);

    }

}
