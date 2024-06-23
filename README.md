
# Lendo Assessment

Lendo Assessment submission by Muhammad Moiz



## Installation



Clone the Project Repository:

```bash
git clone https://github.com/muhammadmoiz65/lendo-assessment
```
Navigate into the project directory:

```bash
cd lendo-assessment
```

Run the Maven command to build the project:

```bash
mvn clean install
```
Start the application using:
```bash
mvn spring-boot:run
```

## API Reference

### Postman collection
I have includes a postman collection too, please feel free to use that, set following variables in postman before using :

- baseUrl : http://localhost:8080
- token : Auth token returned in signin API response

### Test Credentials
geoff@gmail.com
pw :1234

fran@gmail.com
pw:1234

#### Sign up

```http
  GET /public/v2/auth/signup
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `firstName`      | `string` | First Name for new user |
| `lastName`      | `string` | Last Name for new user |
| `email`      | `string` | Email for new user, this will be used to login |
| `passowrd`      | `string` | Password for new user, this will be used to login |


#### Sign in

```http
  GET /public/v2/auth/signin
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `email`      | `string` | Valid User Credentials |
| `passowrd`      | `string` | Valid User Credentials  |


#### Get all Posts (requires auth)

```http
  GET /public/v2/posts
```

#### Filter Posts by User ID (requires auth)

```http
  GET /public/v2/posts?userId=x
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId`      | `string` | User ID that we want to filter Posts with |



#### Filter Posts by Post ID (requires auth)

```http
  GET /public/v2/posts?postId=x
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `postId`      | `string` | Id of post to filter |







#### Get all Comments (requires auth)

```http
  GET /public/v2/comments
```

#### Filter Comments by Post ID (requires auth)

```http
  GET /public/v2/comments?postId=x
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `postId`      | `string` | Post ID to get comments for a Post|


#### Filter Comment by Comment ID (requires auth)

```http
  GET /public/v2/comments?commentId=x
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `commentId`      | `string` | Id of comment to filter |




#### Get all Users (requires auth)

```http
  GET /public/v2/users
```

#### Filter Users by User ID (requires auth)

```http
  GET /public/v2/users?userId=x
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId`      | `string` | Id of user to filter |

## Authors

- [@muhammadmoiz65](mailto:muhammadmoiz65@gmail.com)


![Logo](https://cdn.prod.website-files.com/64b3d44b75703fdd986f9ab3/64c9503d793c8a64a17be6f6_lendo%20svg.svg)

