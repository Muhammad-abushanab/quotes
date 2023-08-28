# quotes

The program reads a collection of quotes from a JSON file, allowing users to retrieve random quotes or search for quotes by a specific author.

## Features

**Random Quote:** If no author name is provided as an argument when running the program, the application will display a randomly selected quote along with its author's name.

**Search by Author:** Users can provide an author's name as an argument when running the program. The application will then search through the quote collection and display all quotes attributed to the specified author.

## How to use 

1. Ensure you have the Gson library included in your project's dependencies.
2. Place your collection of quotes in the qoutes.json file located in the `src/main/resources` directory.
3. Run the program using the following command: `java quotes.App [AuthorName]`
4. If you use gradle run this command `gradle run` for random quotes and for searching by author use `gradle run --args "Author_Name"` **Very Important Note** If the author name contains more than one word separate them with underscore '_' and the program will deal with it if you did not separate the program will not run correctly
5. If you are a developer and running this program from intelliJ ide please make sure to update the path of the file to be `app/src/main/resources/qoutes.json` on App.java