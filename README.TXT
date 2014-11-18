Database of Media Items

In this assignment, you will implement a database for a library. This library stores three types of media items:

books
music albums
movies
The choice of items included in the library database reflects either the instructor’s superior taste, his advanced age, or perhaps both.

You will start with asgmt03.zip, which contains six Java source files:
Assignment3.java
make no changes to this code, except to have it print your actual name instead of “your name”.
Library.java
Item.java, which has the following subclasses:
Book.java
MusicAlbum.java
Movie.java
Library.java, Item.java, Book.java, MusicAlbum.java, and Movie.java are in a Java package named “library.” In the project folder, thay are contained in a subfolder with the same name as the package.

Library.java contains the methods that are used by Assignment3.java. As provided, Library.java contains a stub implementation for each method. (A “stub” is a method definition with no code in it, other than return null; for methods that return a reference.)

You should not add new .java files to this project, and you should not remove any of the provided .java files from this project.

Your task for this assignment is to write code for the method stubs in Library.java to implement the database functionality. In addition, you will need to add code to Item.java and its subclasses to support the Library class as it stores and retrieves data about the various items. Your code should exhibit high cohesion – the code in each class should do things that match what the physical item corresponding to that class would do in the real world. Item, for instance would not be the place to store (or make some use of) a book’s number of pages.

Once you have properly implemented the database functionality, your code’s output should be identical to the contents of one of the provided text output file (asgmt03.out.txt). This will require all of your output lists (including keywords, band members, movie casts) to be sorted alphabetically. Lists of Items should be sorted by title.
Make sure to do all of your printing from the appropriate place, as defined by object-oriented design. This would include your items’ toString() methods.

As you define fields for the various classes in this assignment, make sure to give each of them the appropriate access modifier (e.g. private, protected, public, or none (which means “package protected”).

You should use the Java Collections Framework where appropriate – do not reinvent that wheel for this assignment.

For this assignment you should code for “high performance,” meaning fast access. This means that you should choose components of the Collections Framework that support the highest possible speed consistent with the tasks your code needs to perform. To put this another way, do not do linear searches when a faster method is available in the Collections Framework. For example, the set of items for a particular keyword should not be collected by a linear search through all of the items contained in the library.