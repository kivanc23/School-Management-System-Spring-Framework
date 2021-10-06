# Hello <img src="https://raw.githubusercontent.com/MartinHeinz/MartinHeinz/master/wave.gif" width="30px">

My name is Kıvanç and I'm a Computer Engineer. You can find me on [![LinkedIn][1.2]][1].

## Project Description:
<ul>
  <li>This project is called a School Management System. System stores everything about the school. </li>
  <li>The School Management System stores informations about University network teaching system.University's Course Names,at Quiz problems, Quiz informations, Teacher Names, Test Questions and of course Users of system.The system purpose Creating a digital learning environment, to promote the reform of the education concept.Teaching content and method, to improve the teaching quality and efficiency of education. The following data have been identified in the requirements collection and analysis phase and they are to be represented in the enterprise:</li>
  <li>Current Project Version is V0.1.0</li>
</ul>

## About Project V0.1.0:
<ul>
  <li>This version is a start of the project.</li>
  <li>Project designed by Inversion of Control ( IoC ) principles.</li>
  <li>Project will be updated in short periods.</li>
  <li>During the project will be take care of using Clean Code principles.</li>
</ul>

## System includes:
<ul>
  <li>API</li>
  <li>Private and protected resources</li>
  <li>Spring Data JPA</li>
</ul>

## API Methods
<ul>
    <p>
    <b>API for Courses</b>
    <p>
    <li>GET /courses for listing all courses</li>
    <li>GET /courses/{id} for listing course by id</li>
    <li>POST /course for adding course to database from Postman</li>
    <li>POST /course/delete/{name} for delete course from database by name</li>
    <p><p>
    <b>API for Students</b>
    <p>
    <li>GET /students for listing all students</li>
    <li>POST /student for adding student to database from Postman</li>
    <li>POST /student/delete/{name} delete student from database by name</li>
    <li>POST /student/deleteid/{id} delete student from database by name</li>
    <p><p>
    <b>API for Teach (who *Teach* which Course)</b>
    <p>
    <li>POST /teach/deleteid/{id} for delete Teach by id</li>
    <p><p>
    <b>API for Teachers</b>
    <p>
    <li>GET /teachers for listing all teachers</li>
    <li>POST /teacher for adding teacher to database from Postman</li>
    <li>POST /teacher/deleteid/{id} delete teacher from database by id </li>
    <li>POST /teachers/teach/{teacherId}/{courseId} adding Teach to database (Kıvanç teacher Teach Physics)</li>
    
</ul>

## 🔧 Technologies & Tools
![](https://img.shields.io/badge/OS-Windows-Green?style=flat&logo=windows&logoColor=white&color=2bbc8a)
![](https://img.shields.io/badge/Editor-intellij%20idea-blue.svg?style=flat&logo=eclipse%20ide&logoColor=white&color=2bbc8a)
![](https://img.shields.io/badge/Code-Java-informational?style=flat&logo=java&logoColor=white&color=2bbc8a)
![](https://img.shields.io/badge/Tools-Spring-informational?style=flat&logo=spring&logoColor=white&color=2bbc8a)
![](https://img.shields.io/badge/Tools-MySQL-informational?style=flat&logo=mysql&logoColor=white&color=2bbc8a)

# About System
<div style="align:center; margin:5px;">
  <p>
    <p>Tables that we define in entites package will be automatically generated in database.</p>
      <img src="https://user-images.githubusercontent.com/75583938/136090806-da0be7ba-47d9-4233-8331-4e2635cdf212.png" width="700" height="450"/>
  </p>
  

  <p>
    <p>Full EER of the database diagram.</p>
      <img src="https://user-images.githubusercontent.com/75583938/136091340-bd3a3081-3571-452e-ba92-6ffe91d3631c.png" width="700" height="350"/>
  </p>
  

  <p>
  
  
</div>



[1.1]: http://i.imgur.com/0o48UoR.png (github icon with padding)
[1.2]: https://img.icons8.com/plasticine/25/000000/linkedin.png (LinkedIn icon without padding)


<!-- links to your social media accounts -->

[1]: https://www.linkedin.com/in/k%C4%B1van%C3%A7-tanr%C4%B1verdi-229534202/
[2]: https://github.com/kivanc23
