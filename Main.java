import java.util.*;
public class Main {
    public static void main(String[] args) {
        String sentance="plant chair smile bread clock world dance grass money " +
                "dream heart laugh music shoes peace story party apple watch honey " +
                "house drink sleep field tiger movie table stone beach sugar flower";
        List<String> words =new ArrayList<>();
        String [] guess= sentance.split(" ");
        List<Character> playerguess = new ArrayList<>();
        for(String e:guess)
        {
            words.add(e);
        }
        Random random=new Random();
        String word = new String();
        word = words.get(random.nextInt(words.size()));
        Scanner keyboard= new Scanner(System.in);
        int count=0;
        int wrongCount=0;
        while(true)
        {
            printHnagman(wrongCount);
            if(wrongCount>=6)
            {
                System.out.println("\nYou loose");
                System.out.println("the word was "+word);
                break;
            }
            wordState(playerguess,word,count);
            boolean play=playerGuess(keyboard,playerguess,word);
            if(!play)
            {
                wrongCount++;
            }
            if(wordState(playerguess,word,count))
            {
                System.out.println("You win !!!");
                break;
            }


            if(wrongCount>=2)
            {
                System.out.println("Do you want to enter a guess for the word?");
                String yesno= keyboard.nextLine();
                if(yesno.contains("yes")||yesno.contains("YES"))
                {
                    System.out.println("enter you guess for the word");
                    if(keyboard.nextLine().equals(word))
                    {
                        System.out.println("you win !!");
                        break;
                    }
                    else
                    {
                        System.out.println("Not the same word , try again");
                    }
                }

            }

            System.out.println(6-wrongCount+" lives left");
        }
    }
    public static boolean playerGuess(Scanner keyboard, List<Character> playerguess, String word)
    {
        System.out.print("enter a letter - ");
        String input=keyboard.nextLine();
        playerguess.add(input.charAt(0));
        return word.contains(input);
    }
    public static void printHnagman(int wrongCount)
    {
        System.out.println("__________________");
        System.out.println("|                 |");

        if(wrongCount>=1)
        {
            System.out.print("                  O");
        }
        System.out.println("");
        if(wrongCount>=2)
        {
            System.out.print("                 /");
        }
        if(wrongCount>=3)
        {
            System.out.print(" \\");
        }
        System.out.println("");
        if(wrongCount>=4)
        {
             System.out.print("                  |");
        }
        System.out.println("");
        if(wrongCount>=5)
        {
              System.out.print("                 /");
        }
        if(wrongCount>=6)
        {
            System.out.print(" \\");
        }
        else
        {
            System.out.println(" ");
        }

    }
    public static boolean wordState(List<Character> playerguess, String word,int count)
    {
        for(int i=0;i< word.length();i++)
        {
        if(playerguess.contains(word.charAt(i)))
        {
            System.out.print(word.charAt(i));
            count++;
        }
        else
        {
            System.out.print("_");
        }
        }
        System.out.println("");
        return count==word.length();
    }
}
