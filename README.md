# EECS-3311
# Project Title

Library Management System (LMS) 

## Description

A Library Management System (LMS) is a software application for organizing and managing a library's collection of books, periodicals, and other materials. It is used to track the circulation of materials, manage the catalog, and assist with the acquisition and cataloging of new items. An LMS typically includes features such as check-in and check-out, patron information management, and reporting tools. It can also offer integration with other systems, such as an integrated library system (ILS) or a student information system (SIS). Overall, an LMS is designed to streamline library processes and provide easy access to materials for staff and patrons.

### Dependencies

* Describe any prerequisites, libraries, OS version, etc., needed before installing program.
* ex. Windows 10

### Installing

* The program will follow agile process and will be availabe soon enough after the first iteration it can be executed


### Itr0
* For iteration 0 the basic information of the project and group members are shown in the file Itr0 

### Itr1
### Classes
* Book
* BookOrganization
* BSR (Booking Study Room)

#### Book
> The class Book has instance variables to store information about a book such as the book's ID (bookId), name (bookName), author (author), category (category), and price (price). The "lend" variable stores information about whether the book is currently lent or not. The class also includes getter and setter methods for all its instance variables, as well as a "toString()" method that returns a string representation of a Book object.

#### BookOrganization
> This class provides a way to manage a collection of books represented by the class Book. The class uses an ArrayList data structure to store instances of the Book class. The booksOrganization class contains methods to add books to the collection, delete books from the collection, and remove all books from the collection. Each method performs the corresponding operation and prints a message indicating the outcome of the operation.

#### BSR
> This class allows users to choose between three options: 1) book a room, 2) check the availability of rooms, and 3) exit the process. The system tracks the availability of 10 rooms using a boolean array. If a room is available, the user can reserve it by entering the room number. The system will then print either a successful booking message or an error message if the room is already booked or if the entered room number is invalid.

### Here are some links to the UML diagrams of classes explained above
* [Book UML](https://drive.google.com/file/d/1Ie8lqg8Q2PyZ7Nskxg1GUPvKBxuqIadu/view?usp=share_link)
* [BookSearch UML](https://drive.google.com/file/d/1_ZHp9gKoaUj5gTr57Ji5wvugpJNGnEnF/view?usp=share_link)
* [BSR BookingStudyRoom UML](https://1drv.ms/u/s!ApjPTpRjtQF0ylcAVZ-gUwvYQdby?e=PsaRgV)
* [booksOrganization UML](https://drive.google.com/file/d/1UyWOcrv5Uz0oB5oZYCP1FU3hzafjCo0e/view?usp=sharing)

### Itr2
(Attention, you need to use junit 5 here. And need to add external JARs, SQL connector in build path. And need to run the database.sql file into MYSQL.)
### Classes 
* Borrow
* StudentAccount
* User
* Account
* Tests ( Containing all test classes )

#### Borrow
> This Java class named "Borrow" represents a book borrowed from a library. It contains instance variables for the book's title, author, borrowed status, borrowed date, and due date. It also provides several methods to manipulate the book's borrowed status and due date.

#### StudentAccount | Account | User
> Used to insert data into Database such as username, password, roll and etc.


* There are main GUI's used as Login fo TA's and QA team which is called AdminLogin and allows the admin to log in with the username "3311" and password "pass" then they will get redirected to another page which allows them to add books and prices to the DB.

> Also the LibraryGUI has information provided for the user in case they need to know how some of the processes are done or what are the business hours of the library.

> New user stories that our cleint suggested are Borrowing books and the extension of the duration for which users are able to do that but has a limit to it.

#### Tests
> There are three test java class in itr2. All of the method had been tested. In JUnitTest.java, we basically test the method by "stub" database which is arraylist. In 
IterationTest.java, we test the method by real database with MYSQL. Lastly, in BorrowBookTest, we test all method.

> For Test java class, we need few more libraries. We need juint-jupiter-api-5.9.2.jar and junit-platform-commons-1.9.2.jar and JUnit 5 to make the Test java class works.

> And need to change your own MYSQL password in IntegrationTest.java, BookSearch.java and booksOrganization.java before use the test java file.
