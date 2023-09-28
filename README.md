# Spring Boot Mini Project

## How to run

### 1. Run mysql server in docker container

```bash
./mysql.sh
```

### 2. Run Spring boot project in IDE

## Axios

```javascript
axios({
  method: "post",
  url: "/user/signup",
  data: {
    username: "test",
    password: "apple123",
    name: "Steve Jobs",
  },
}).then(function (response) {
  console.log(response);
});
```

Axios docs <https://axios-http.com/kr/docs/api_intro>
