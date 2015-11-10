BPT - Attendance

How to run this project:
    1. Following preparation steps if you have not done yet.
    2. {under project folder}/.gradlew clean bootRun

Preparation Step:
    1. Install Mysql
    2. Execute scripts in sql-scripts folder


Endpoint:

Company:
| endpoint   | http method | description
|------------|-------------|----------------------
| /companies | PUT         | create a new company

    example :
        {
            "name" : "香蕉計畫",
            "account" : "bananaplan",
            "password" : "password"
        }

User:
| endpoint          | http method | description
|-------------------|-------------|----------------------
| /users            | PUT         | create a new user
| /users            | GET         | account login
| /users/{username} | DELETE      | delete account

    @RequestMapping(value = "/users", method = RequestMethod.PUT)
        {
            "username" : "popotest1",
            "password" : "password",
            "employeeName" : "歐瀚陽",
            "companyName" : "香蕉計畫"
        }
    @RequestMapping(value = "/users", method = RequestMethod.GET)
        http://localhost:8080/users?username=popotest1&password=password
    @RequestMapping(value = "/users/{username}", method = RequestMethod.DELETE)
        http://localhost:8080/users/popotest1

Attendance:
| endpoint                            | http method | description
|-------------------------------------|-------------|----------------------
| /attendance/checkIn/{userId}        | PUT         | work check-in
| /attendance/checkOut/{attendanceId} | PUT         | work check-out

            @RequestMapping(value = "/attendance/checkIn/{userId}", method = RequestMethod.PUT)
            @RequestMapping(value = "/attendance/checkOut/{attendanceId}", method = RequestMethod.PUT)
