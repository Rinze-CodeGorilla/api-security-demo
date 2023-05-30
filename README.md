# Java demos for my blog posts

* [How to Extract Event Time in Apache Flume](https://shzhangji.com/blog/2017/08/05/how-to-extract-event-time-in-apache-flume/), [中文](https://shzhangji.com/cnblogs/2017/08/06/how-to-extract-event-time-in-apache-flume/)
* [Extract Data from MySQL with Binlog and Canal](https://shzhangji.com/blog/2017/08/12/extract-data-from-mysql-with-binlog-and-canal/), [中文](https://shzhangji.com/cnblogs/2017/08/13/extract-data-from-mysql-with-binlog-and-canal/)
* [How to Avoid NullPointerException](https://shzhangji.com/blog/2018/09/20/how-to-avoid-null-pointer-exception/), [中文](https://shzhangji.com/cnblogs/2018/09/22/how-to-avoid-null-pointer-exception/)
* [Store Custom Data in Spring MVC Request Context](https://shzhangji.com/blog/2022/07/05/store-custom-data-in-spring-mvc-request-context/)
* [Manage Multiple CommandLineRunner in Spring Boot](https://shzhangji.com/blog/2022/07/16/manage-multiple-command-line-runner-in-spring-boot/)
* [RESTful API Authentication with Spring Security](https://shzhangji.com/blog/2023/01/15/restful-api-authentication-with-spring-security/)


# API Auth example with Spring Boot

# Installation instructions

The application wants to connect to a MySQL Database running on the localhost, with username root and no password.

In src/main/resources/application.properties changes can be made to the default configuration.

To initialize the database run the queries from demo.sql

The following JavaScript code logs you in and out.

POST requests require a csrf token, all routes except /api/csrf and /api/login require being logged in. The session is stored in a cookie, this does not require additional code.

```JavaScript
async function logout() {
    const response = await fetch('/api/logout', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': await getCsrfToken(),
        },
        body: 'null',
    })
    return await response.json()
}

async function login(username, password) {
    const response = await fetch('/api/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': await getCsrfToken(),
        },
        body: JSON.stringify({ username, password }),
    })
    return await response.json()
}

async function getCsrfToken() {
    const response = await fetch('/api/csrf')
    const payload = await response.json()
    return payload.token
}

login("admin","888888");

logout();
```
