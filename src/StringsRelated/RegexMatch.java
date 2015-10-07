package StringsRelated;
import java.lang.*;

/**
 * Created by Upasana on 9/17/2015.
 */
public class RegexMatch {

    //Regex accepted are only *, . ALso they cannot be consecuetive bat**- invalid input
    public static boolean IsMatch(String pattern, String str, int patternIndex, int StrIndex)
    {
        if (pattern == null || str == null)
            return false;

        if( patternIndex == pattern.length() && StrIndex == str.length())
            return true;


        if(StrIndex == str.length())
            return false;

        //expected regex are only  * & .

        //CASE 1: When symbol is "*"
            if(pattern.charAt(patternIndex) == '*')
            {
                System.out.println("Pattern is *");
                //last char is * and it is the end of pattern eg : bat*,
                // the input str implicitly matched the pattern
                if(patternIndex == pattern.length() -1) {
                    return true;
                }

                int matchIndex = patternIndex+1;
                if( pattern.charAt(patternIndex+1) == '.')
                    matchIndex = patternIndex+2;

                if(matchIndex >= pattern.length())
                    return true;
                //parse teh input str until it starts matching teh next char of the pattern
                while(str.charAt(StrIndex) != pattern.charAt(matchIndex))
                {
                    StrIndex++;
                    if(StrIndex == str.length())
                        return false;

                }
                return IsMatch(pattern, str, matchIndex, StrIndex);
            }

        //CASE 2: When symbol is ".", just skip the current char of the string
        if(pattern.charAt(patternIndex) == '.')
            return IsMatch(pattern, str, patternIndex + 1, StrIndex+1);

        //CASE 3: When it is a character, not a symbol
        if(pattern.charAt(patternIndex) != str.charAt(StrIndex))
            return false;
        else
            return IsMatch(pattern, str, patternIndex+1, StrIndex+1);

    }

    public static void main( String[] args)
    {

        System.out.println(IsMatch("*t*e*l", "oatkedhgtyrp", 0, 0));

        System.out.println("*********************************");
        System.out.println(IsMatch("*t*e*l", "oatkedhgtyrl", 0, 0));

        System.out.println("*********************************");
        System.out.println(IsMatch("*t*e*.", "oatkedhgtyrl", 0, 0));

        System.out.println("*********************************");
        System.out.println(IsMatch("*t..*e.*", "oatkedhgtyrl", 0, 0));
        System.out.println("*********************************");
        System.out.println(IsMatch("*t.*e*.", "oatkedhgtyrl", 0, 0));
    }
}
