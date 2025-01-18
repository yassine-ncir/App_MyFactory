MyFactory it is a standalone desktop application that builds to manage a simple factory buisness 

![Screenshot (121)](https://github.com/user-attachments/assets/42b1fbdb-0f69-449b-8e4e-0fe4d7e7a81d)

our application manage Employees, inventory(Products, Material), Orders of factory.

this is the diagram of MyFactory app:
![MyFactory drawio](https://github.com/user-attachments/assets/1d5dd9c0-0b39-4bea-9a05-c4b0cac6de3d)

I uses MVC Architecture for this app with some simple other design patterns 
DataBase :
  + SQLite is the DB because our goal is and as we say we need a standalone application (no needed to network, server etc...) .
  + SQLite is a single file in our app that store all data
  + the comminucation between app (logic layer) & database depends on JDBC (java databases connectivity) .

User interface <UI>:
  + JavaFX it is the user interface of MyFactory application .
  + as you know JavaFx has fxml file to show interface and comminucate with the back with its controller , i inject the services interfaces in javafx controller to get easily integration 
  + JavaFX it is a modern GUI framework based on java languages.


