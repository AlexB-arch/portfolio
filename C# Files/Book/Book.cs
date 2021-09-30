using System;

class Book
{
    string title, textContents, allChars;
    double price;
    int pages;

    public Book(string input, string body)
    {

        title = input;
        textContents = body;
    }

    public string getTitle()
    {
        return title;
    }

    public string getContents()
    { 
        return textContents;
    }

    //Calculating the value per character includes the title!
    public double getValue()
    {
        //Will remove all spaces and create a string of only characters for calculating price.
        allChars = title.Replace(" ", "") + textContents.Replace(" ", "");
        foreach (char characters in allChars)
        {
            price += 0.50;
        }
        return price;
    }

    public int getPages()
    {
        //Pages increase every 5 chars, plus an additional page with chars that remain.
        pages = (title.Length - 1 + textContents.Length - 1) / 5;
        int remainder = (title.Length + textContents.Length - 1) % 5;
      
        if (remainder == 0)
            return pages;

        if (remainder <= 5)
            pages = pages + 1;

        return pages;
    }

    //Encrypts the title and contents of the book.
    public void encrypt(int key)
    {
        char[] encryptedTitle = new char [title.Length];
        char[] encryptedBody = new char[textContents.Length];
        int wrap = key;

        for (int i = 0; i < encryptedTitle.Length; i++)
        {
            if(key > encryptedTitle.Length)
            {
                key = wrap;
            }
            encryptedTitle[i] = title[key++];
        }

        //Reset the key back to its original value before the next loop.
        key = wrap;

        for (int j = 0; j < encryptedBody.Length; j++)
        {
            if (key > encryptedBody.Length)
            {
                key = wrap;
            }
            encryptedBody[j] = textContents[key++];
        }

        title = Convert.ToString(encryptedTitle);
        textContents = Convert.ToString(encryptedBody);
    }

    public void print()
    {
        Console.Write("Title: {0}", getTitle());
        Console.Write("\nBody: {0}", getContents());
        Console.Write("\nValue: ${0}", getValue().ToString("F1"));
        Console.Write("\nPages: {0}", getPages().ToString());
    }
}