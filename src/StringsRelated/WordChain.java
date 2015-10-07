package StringsRelated;
import java.lang.*;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by Upasana on 9/16/2015.
 */
public class WordChain {

    /*public static int FindShortestChain(String start, String target, List<String> Dictionary)
    {

        if(start.length() != target.length())
            return -1;

        if(Dictionary.size() == 0)
            return -1;

        if( !Dictionary.contains(start) || !Dictionary.contains(target))
            return -1;

        Set<String> VisitedWord = new HashSet<String>();

        String currStr = start;
        int steps = 0;
        while( true)
        {
            //System.out.println("abc");
            if( currStr.equalsIgnoreCase(target))
                break;

            if(VisitedWord.size() == Dictionary.size())
                return -1;

            if(!VisitedWord.contains(currStr)) {
                VisitedWord.add(currStr);

                for(int  i= 0; i < Dictionary.size(); i++)
                {
                    if(WordDistance(currStr, Dictionary.get(i)) == 1)
                    {
                        if(FindShortestChain(Dictionary.get(i), target, Dictionary, steps++)
                            break
                    }
                }

            }

        }

        System.out.println("***********************");
        return steps;


    }*/

    public static boolean FindWordChain(String start, String target, Set<String> Dictionary, LinkedHashSet<String>currPath)
    {
        if( start == null || target == null)
            return false;

        if(!Dictionary.contains(target))
            return false;

        if( start.equalsIgnoreCase(target))
        {
            for( String str : currPath)
            {
                System.out.println(str);
            }
            return true;
        }

        String pat = ".*OO*.";

        boolean isMatch = Pattern.matches(pat, "TOON");
        System.out.println("Pattern match = " + isMatch);
        if( !currPath.contains(start))
            currPath.add(start);

        for( String str: Dictionary)
        {
            if((WordDistance(start, str) ==1) && !currPath.contains(str))
            {
                currPath.add(str);
                FindWordChain(str, target, Dictionary, currPath);
            }

        }
        return true;
    }

    private static int WordDistance( String a, String b)
    {
        System.out.println(a);
        System.out.println(b);
        int wordDist = 0;
        for(int i = 0; i < a.length(); i++)
        {
            int aChar = a.charAt(i);
            int bChar = b.charAt(i);
            wordDist += (aChar != bChar)? 1 : 0;
        }

        System.out.println(wordDist);
        return wordDist;
    }

    public static void main(String[] args)
    {
        //String[] Dictionary = {"POOL", "PLEE", "SAME", "POIE", "PLEA", "PLIE","POIN" };
//        List<String> Dictionary = new ArrayList<String>();
        Set<String> Dictionary = new HashSet<String>();
        Dictionary.add("POON");
        Dictionary.add("POOL");
        Dictionary.add("PLEE");
        Dictionary.add("SAME");
        Dictionary.add("POIE");
        Dictionary.add("PLEA");
        Dictionary.add("PLIE");
        Dictionary.add("POIN");

        LinkedHashSet<String> currPath = new LinkedHashSet<String>();
        //System.out.println(FindShortestChain("POOL", "PLEA", Dictionary));
        System.out.println(FindWordChain("TOON", "PLEA", Dictionary, currPath));

    }
}
