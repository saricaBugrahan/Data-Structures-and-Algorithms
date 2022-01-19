
public class MovieDatabase{
    //Creating binary search tree called movie
    BST movie = new BST();
    public void addMovie(String movieTitle, String directorFirstName,
                         String directorLastName, int releaseDay,
                         int releaseMonth, int releaseYear)
    {
        //Holding all the informations as value
        String s = movieTitle+","+releaseYear +","+ directorFirstName+" "+directorLastName+","+releaseDay+","+releaseMonth;
        //Normally pdf says that you should use only the release year but I get so many bugs due to that
        //I added tiny amount of months to be unique key.
        double key = (double)releaseYear+ (releaseMonth/1.1);
        if(!movie.contains(key))
        {
            System.out.println("INFO: Movie "+movieTitle+" has been added");
            movie.insertNode(key,s);
        }
        else
        {
            System.out.println("ERROR: Movie "+movieTitle+" overwritten");
        }


    }
    public void removeMovie(String movieTitle)
    {
        //If the Value contains movieTitle it get's inside
        if((movie.getKey(movieTitle)) != null)
        {
            //To find out the key
            double key = (double)movie.getKey(movieTitle);
            //Our deletion method according to the key
            movie.delete(key);
            System.out.println("INFO: Movie "+movieTitle+" has been removed.");
        }
        // If movieDatabase does not contain the film.
        else {
            System.out.println("Warning there is no " + movieTitle + " in the database.");
        }
    }
    public void addActor(String movieTitle, String actorFirstName,
                         String actorLastName, String actorRole)
    {
        //If there is a it get inside if not it got into else
        if(movie.getKey(movieTitle) != null)
        {
            double key = (double)movie.getKey(movieTitle);
            //Adding Node to our actors bst.
            if(movie.getBST(key).get(actorFirstName+actorLastName) == null) {
                movie.getBST(key).insertNode(actorFirstName + actorLastName, actorFirstName + " " + actorLastName + "," + actorRole);
                System.out.println(actorFirstName + " " + actorLastName + " has been added to the movie " + movieTitle);
            }
            else{
                System.out.println("The actor"+actorFirstName+" "+actorLastName+" is already have role in "+movieTitle);
            }
        }
        else
        {
            System.out.println("Movie "+movieTitle+" is not exist");
        }
    }
    public void removeActor(String movieTitle, String actorFirstName,
                            String actorLastName)
    {
        //Same procedure.If there is a movie inside the database get inside
        if((movie.getKey(movieTitle)) != null)
        {
            double key = (double)movie.getKey(movieTitle);
            //Delete From our actors bst.
            if(movie.getBST(key).get(actorFirstName+actorLastName) != null) {
                movie.getBST(key).delete(actorFirstName + actorLastName);
                System.out.println("INFO:" + actorFirstName + " " + actorLastName + " has been removed from " + movieTitle);
            }
            else
            {
                System.out.println("There is no name called "+actorFirstName+" "+actorLastName+" in the "+movieTitle);
            }
        }
    }

    public void showAllMovies()
    {
        //movie.Value returning a queue holding String arrays.
        Queue<String []> q = movie.Values();
        if(q.isEmpty())
        {
            System.out.println("--none--");
        }
        int a = q.size();
        for(int i =0;i<a;i++)
        {
            //We are empty the queue.
            String arr[] = q.dequeue();
            System.out.println(arr[0]+", "+arr[1]+", "+arr[2]);


        }

    }
    public void showMovie(String movieTitle)
    {
        //We are doing similar thing up.
        if((movie.getKey(movieTitle)) != null)
        {
            double key = (double)movie.getKey(movieTitle);
            //Finding the values
            String arr[] = (String[])movie.get(key);
            //Expressing the values according to the pdf
            System.out.println(arr[0]+"\n"+""+arr[3]+"/"+arr[4]+"/"+arr[1]);
            System.out.println(arr[2]);
            //Then we are now finding our actors from actors bst and take it and express in the screen.
            Queue<String[]> q = movie.getBST(key).Values();
            if(q.isEmpty())
            {
                System.out.println("--none--");
            }
            int size = q.size();
            for(int i =0;i<size;i++)
            {
                String[] vrr = q.dequeue();
                System.out.println(vrr[0]+", "+vrr[1]);
            }
            }
        else
        {
            System.out.println(movieTitle+ "\n--none--");
        }

    }
    public void showActorRoles(String actorFirstName,
                               String actorLastName)
    {
        Stack<String[]> stack = movie.ReverseValues();
        int a = 0;
        int temp = 0;
        while(!stack.isEmpty())
        {

            String[] arr = stack.pop();
            double key = (double)movie.getKey(arr[0]);
            BST bst =movie.getBST(key);
            Stack<String[]> actorStack = bst.ReverseValues();

            while (!actorStack.isEmpty())
            {
                String[] actorArr = actorStack.pop();
                if(actorArr[0].equals(actorFirstName+" "+actorLastName))
                {
                    if(a == 0)
                    {
                        System.out.println(actorArr[0]);
                        a++;
                    }
                    temp++;
                    System.out.println(actorArr[1]+", "+arr[0]+", "+arr[1]);
                }
            }

        }
        if(temp == 0)
        {
            System.out.println(actorFirstName+" "+actorLastName);
            System.out.println("--none--");
        }

    }
    public void showDirectorMovies(String directorFirstName,
                                   String directorLastName)
    {
        //We pop the stack until it's empty and express it's values according to pdf.
        Stack<String[]> stack = movie.ReverseValues();
        int a = 0;
        int temp = 0;
        while(!stack.isEmpty()) {
            String[] arr = stack.pop();
            if (arr[2].equals(directorFirstName + " " + directorLastName)) {
                if (a == 0) {
                    System.out.println(arr[2]);
                    a++;
                }
                temp++;
                System.out.println(arr[0] + ", " + arr[3] + "/" + arr[4] + "/" + arr[1]);
            }
        }
        if(temp == 0)
        {
            System.out.println(directorFirstName+" "+directorLastName);
            System.out.println("--none--");
        }



    }

}