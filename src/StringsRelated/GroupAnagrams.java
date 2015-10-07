package StringsRelated;
import java.util.*;
import java.lang.*;


/**
 * Created by Upasana on 9/17/2015.
 */

class ListComparator implements Comparator<List<String>> {

    @Override
    public int compare(List<String> o1, List<String> o2) {

        if((o1 == null && o2 == null ) ||( o1.size() == 0 &&  o1.size() == 0))
            return 0;

        if(o1 == null || o1.size() == 0)
            return -1;
        if(o2 == null || o2.size() == 0)
            return 1;

        return o1.get(0).compareTo(o2.get(0));
    }
}

public class GroupAnagrams{
    public void sortList (List<List<String>>AnagramList)
    {
        if(AnagramList == null || AnagramList.size() ==0)
            return;

      Collections.sort(AnagramList, new ListComparator());
    }

    public boolean isAnagram(String Str1, String Str2)
    {

        if( (Str1 == null || Str2 == null) || Str1.length() != Str2.length())
            return false;

        int[] charArr1 = new int[26];
        int[] charArr2 = new int[26];

        for( int i = 0 ; i < Str1.length(); i++)
        {
            charArr1[(int)Str1.charAt(i) - 'a']++;
        }

        for( int i = 0 ; i < Str2.length(); i++)
        {
            charArr2[(int)Str2.charAt(i) - 'a']++;
        }

        for( int i=0 ; i < 26; i++)
        {
            if(charArr1[i] != charArr2[i])
                return false;
        }

        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {


        List<List<String>> AnagramList = new ArrayList<List<String>>();

        int arrLen = strs.length;

        for( int i = 0 ; i < arrLen; i++ )
        {
            List<String> nList = null;
            if( strs[i] != null) {
                nList = new ArrayList<String>();
                nList.add(strs[i]);

                for (int j = i; j < arrLen; j++) {

                    if (isAnagram(strs[i], strs[j])) {
                        nList.add(strs[j]);
                        strs[j] = null;
                    }
                }
            }
            if(nList != null)
            {
                Collections.sort(nList);
                AnagramList.add(nList);
            }
        }

        return AnagramList;
    }

    public static void main(String[] args)
    {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};

    }
}