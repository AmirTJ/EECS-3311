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
* [BST BookingStudyRoom UML](![image](https://user-images.githubusercontent.com/77169817/217880371-ed41e7a0-222f-4fd9-92a4-ca6c08d67e7c.png)


