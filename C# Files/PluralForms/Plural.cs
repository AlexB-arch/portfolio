using System;

class Program
{
    //Create a method to process words and convert to plural.
    public static string PluralForm(string word)
    {
        char last = word[word.Length - 1], secondToLast = word[word.Length - 2];
        string removed;

        //If the word ends with punctuation, remove it to use later.
        if (char.IsPunctuation(last))
        {
            removed = Convert.ToString(word[word.Length - 1]);
            word = word.Remove(word.Length - 1);
            last = word[word.Length - 1];
            secondToLast = word[word.Length - 2];

            return checker(word, last, secondToLast) + removed;
        }

        //Else, proceed to these rules.
        return checker(word, last, secondToLast);
    }

    //This method evaluates the last two characters and returns the word accordingly.
    public static string checker(string word, char last, char secondToLast)
    {
        switch (last)
        {
            case 's':
                return word + "es";
            case 'x':
                return word + "es";
            case 'z':
                return word + "es";
            case 'h':
                switch (secondToLast)
                {
                    case 's':
                        return word + "es";
                    case 'c':
                        return word + "es";
                    default:
                        return word + "s";
                }
            case 'o':
                switch (secondToLast)
                {
                    case 'a':
                        return word + "s";
                    case 'e':
                        return word + "s";
                    case 'i':
                        return word + "s";
                    case 'o':
                        return word + "s";
                    case 'u':
                        return word + "s";
                    default:
                        return word + "es";
                }

            case 'y':

                switch (secondToLast)
                {
                    case 'a':
                        return word + "s";
                    case 'e':
                        return word + "s";
                    case 'i':
                        return word + "s";
                    case 'o':
                        return word + "s";
                    case 'u':
                        return word + "s";
                    default:
                        word = word.Remove(word.Length - 1);
                        return word + "ies";
                }

            default:
                return word + "s";
        }
        
    }

    public static void Main(string[] args)
    {
        string input;
        Console.WriteLine("This program converts an English word to its plural form.\n");

        Console.Write("English word: ");
        input = PluralForm(Console.ReadLine());

        Console.Write("Plural form: {0}", input);
    }
}