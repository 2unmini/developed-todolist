## 필수과제 발전된 일정관리 API

<details>
<summary>POST 사용자 생성</summary>
<div markdown="1">       

/api/users
- Request body

| 파라미터     |타입  |필수여부| 설명   |
|----------|------|------|------|
| username |String|O     | 작성자  |
| email    |String|O     | 이메일  |
| password |String|O     | 비밀번호 |
  ```json
  {
    "username": "작성자",
    "email" : "1234@email.com",
    "password" : "password"
 
}
  
  ```
-Example Response

| 파라미터       | 타입     |필수여부| 설명       |
|------------|--------|------|----------|
| user_id    | Long   |O     | 작성자 고유번호 |
| username | String |O     | 작성자      |
| email | String |O     | 이메일      |
| created_At | Date   |O     | 생성 날짜    |
| updated_At | Date |X     | 수정 날짜    |

```json
  {
    "user_id": 1,
    "username": "작성자" ,
    "content": "내용",
    "created_At": "2024-11-12",
    "updated_At": null
    }
```
</div>
</details>

<details>
<summary>GET 사용자 조회</summary>
<div markdown="1">       

/api/users/{user_id}
- Requset
 ```
  api/users/1 
  ```

| 파라미터    | 타입   |필수여부| 설명   |
|---------|------|------|------|
| user_id | Long |O     | 작성자 고유번호  |


-Example Response

| 파라미터       | 타입     |필수여부| 설명       |
|------------|--------|------|----------|
| user_id    | Long   |O     | 작성자 고유번호 |
| username | String |O     | 작성자      |
| email | String |O     | 이메일      |
| created_At | Date |O     | 생성 날짜    |
| updated_At | Date |X     | 수정 날짜    |

```json
  {
    "user_id": 1,
    "username": "작성자" ,
    "content": "내용",
    "created_At": "2024-11-12",
    "updated_At": null
}
```
</div>
</details>


<details>
<summary>DELETE 사용자 삭제</summary>
<div markdown="1">       

/api/users/{user_id}
- Requset
 ```
  api/users/1 
  ```

| 파라미터    | 타입   |필수여부| 설명   |
|---------|------|------|------|
| user_id | Long |O     | 작성자 고유번호  |


- Example response (성공)
```

```
- Example response (실패)

```
{
    "errorCode": 400,
    "message": "이미 삭제 되었거나 등록된 사용자가 아닙니다."
}
```
</div>
</details>




<details>
<summary>POST 일정 생성</summary>
<div markdown="1">       

/api/schedules
- Request body

| 파라미터     | 타입     |필수여부|설명  |
|----------|--------|-----|------|
| user_id  | Long   |O    |작성자 고유번호 |
| title    | String |O    |제목   |
| content  | String |O     |내용   |

  ```json
  {
    "userId": 1,
    "title": "제목",
    "content": "내용"
}
```
- Example Response

|파라미터| 타입     |필수여부|설명  |
|------|--------|------|------|
|schedule_id | Long   |O     |일정 고유번호  |
| user_id  | Long    |O     |작성자 고유번호 |
|title | String |O     |제목   |
|content  | String |O     |내용   |
|created_At| Date |O     |생성 날짜 |
|updated_At| Date |X     |수정 날짜 |

  ```json
  {
    "schedule_id": 1,
    "user_id": 1,
    "title" : "제목",
    "content": "내용",
    "created_At": "2024-11-06",
    "updated_At": null
    }
```
</div>
</details>

<details>
<summary>GET 전체 일정 조회</summary>
<div markdown="1">       

/api/schedules
- Requset

    ```
  api/schedules 
  ```

- Example response

|파라미터| 타입     |필수여부|설명  |
|------|--------|------|------|
|schedule_id | Long   |O     |일정 고유번호  |
| user_id  | Long    |O     |작성자 고유번호 |
|title | String |O     |제목   |
|content  | String |O     |내용   |
|created_At| Date |O     |생성 날짜 |
|updated_At| Date |X     |수정 날짜 |

  ```json
 [ 
  {
      "schedule_id": 1,
      "user_id": 1,
      "title" : "제목",
      "content": "내용",
      "created_At": "2024-11-12",
      "updated_At": null
    },
  {
    "schedule_id": 2,
    "user_id": 2,
    "title" : "제목2",
    "content": "내용2",
    "created_At": "2024-11-12",
    "updated_At": null
  }
]
```
</div>
</details>

<details>
<summary>GET 상세 일정 조회</summary>

<div markdown="1">       

/api/schedules/{schedule_id}
- Requset
 ```
  api/schedules/1 
  ```

 |파라미터| 타입  |필수여부|설명  |
 |------|-----|------|------|
 |schedule_id    | INT |O     |일정 고유번호  |

- Example Response (성공)

|파라미터| 타입     |필수여부|설명  |
|------|--------|------|------|
|schedule_id | Long   |O     |일정 고유번호  |
| user_id  | Long    |O     |작성자 고유번호 |
|title | String |O     |제목   |
|content  | String |O     |내용   |
|created_At| Date |O     |생성 날짜 |
|updated_At| Date |X     |수정 날짜 |

  ```json
  {
    "schedule_id": 1,
    "user_id": 1,
    "title" : "제목",
    "content": "내용",
    "created_At": "2024-11-12",
    "updated_At": null
    }
```

- Example response (실패)

```
{
    "errorCode": 400,
    "message": "올바른 ID값이 아닙니다."
}
```

</div>
</details>

<details>
<summary>PUT 일정 변경</summary>
<div markdown="1">       

/api/schedules/{schedule_id}

- Request
 ```
  api/schedules/1 
  ```

| 파라미터     | 타입     |필수여부|설명  |
|----------|--------|-----|------|
| title    | String |O    |제목   |
| content  | String |O     |내용   |

 ```json
  {
    "title" : "수정제목",
    "content": "수정내용"
}
```
- Example response (성공)

|파라미터| 타입     |필수여부|설명  |
|------|--------|------|------|
|schedule_id | Long   |O     |일정 고유번호  |
| user_id  | Long    |O     |작성자 고유번호 |
|title | String |O     |제목   |
|content  | String |O     |내용   |
|created_At| Date |O     |생성 날짜 |
|updated_At| Date |X     |수정 날짜 |

  ```json
  {
    "schedule_id": 1,
    "user_id": 1,
    "title" : "제목",
    "content": "내용",
    "created_At": "2024-11-12",
    "updated_At": "2024-11-12"
    }
```
</div>
</details>

<details>
<summary>DELETE 일정 삭제</summary>
<div markdown="1">       

/api/schedules/{schedule_id}
- Requset
 ```
  api/schedules/1 
  ```

|파라미터| 타입   |필수여부|설명  |
 |------|------|------|------|
|schedule_id    | Long |O     |일정 고유번호  |

- Example response (성공)
```

```
- Example response (실패)

```
{
    "errorCode": 401,
    "message": "비밀번호가 일치 하지 않습니다."
}
```
</div>
</details>

일정 API

|Method|EndPoint|Desc|
|------|---|---|
|POST|/api/schedules|새로운 일정 생성|
|GET|/api/schedules|전체 일정을 가져옴|
|GET|/api/schedules/{schedule_id}|상세 일정을 가져옴|
|PUT|/api/schedules/{schedule_id}|일정을 변경|
|DELETE|/api/schedules/{schedule_id}|일정을 삭제|

사용자 API

| Method | EndPoint             | Desc           |
|--------|----------------------|----------------|
| POST   | /api/users           | 새로운 사용자 생성     |
| GET    | /api/users/{user_id} | 상세 사용자 정보를 가져옴 |
| DELETE | /api/users/{user_id} | 사용자 정보 삭제      |
| POST   | /api/users/login     | 로그인            |
| DELETE | /api/users/logout    | 로그아웃           |



## 도전과제 발전된 일정관리 API

<details>
<summary>POST 댓글 생성</summary>
<div markdown="1">       

/api/users
- Request body

| 파라미터      | 타입     |필수여부| 설명        |
|-----------|--------|------|-----------|
| userId    | Long   |O     | 작성자 고유 번호 |
| scheduleId | Long   |O     | 일정 고유 번호  |
| content   | String |O     | 댓글        |
  ```json
  {
    "userId": 1,
    "scheduleId" : 1,
    "content" : "댓글입니다"
 
}
  
  ```
-Example Response

| 파라미터       | 타입     |필수여부| 설명        |
|------------|--------|------|-----------|
| commentId  | Long   |O     | 댓글 고유 번호  |
| userId     | Long   |O     | 작성자 고유 번호 |
| scheduleId | Long   |O     | 일정 고유번호   |
| content    | String |O     | 댓글        |
| created_At | Date   |X     | 등록 날짜     |

```json
  {
    "commentId": 1,
    "userId": 1,
    "scheduleId": 1,
    "content": "댓글입니다",
    "created_At": "2024-11-14"
    }
```
</div>
</details>

<details>
<summary>GET 댓글 조회</summary>
<div markdown="1">       

/api/comments/{comment_id}
- Requset
 ```
  api/comments/1 
  ```

| 파라미터      | 타입   |필수여부| 설명      |
|-----------|------|------|---------|
| commentId | Long |O     | 댓글 고유번호 |


-Example Response

| 파라미터       | 타입     |필수여부| 설명        |
|------------|--------|------|-----------|
| commentId  | Long   |O     | 댓글 고유 번호  |
| userId     | Long   |O     | 작성자 고유 번호 |
| scheduleId | Long   |O     | 일정 고유번호   |
| content    | String |O     | 댓글        |
| created_At | Date   |X     | 등록 날짜     |
| updated_At | Date |X     | 수정 날짜    |

```json
  {
    "commentId": 1,
    "userId": 1,
    "scheduleId": 1,
    "content": "댓글입니다",
    "created_At": "2024-11-14",
    "updated_At": null
    }
```
</div>
</details>

<details>
<summary>PUT 댓글 변경</summary>
<div markdown="1">       

/api/comments/{comment_id}

- Request
 ```
  api/comments/1 
  ```

| 파라미터     | 타입     |필수여부| 설명      |
|----------|--------|-----|---------|
| content   | String |O     | 댓글      |

 ```json
  {
    "content" : "수정 댓글"
}
```
- Example response (성공)

| 파라미터       | 타입     |필수여부| 설명        |
|------------|--------|------|-----------|
| commentId  | Long   |O     | 댓글 고유 번호  |
| userId     | Long   |O     | 작성자 고유 번호 |
| scheduleId | Long   |O     | 일정 고유번호   |
| content    | String |O     | 댓글        |
| created_At | Date   |X     | 등록 날짜     |
| updated_At | Date |X     | 수정 날짜    |

```json
  {
  "commentId": 1,
  "userId": 1,
  "scheduleId": 1,
  "content": "수정 댓글",
  "created_At": "2024-11-14",
  "updated_At": "2024-11-14"
}
```
</div>
</details>

<details>
<summary>DELETE 댓글 삭제</summary>
<div markdown="1">       

/api/comments/{comment_id}
- Requset
 ```
  api/comments/1 
  ```

| 파라미터      | 타입   |필수여부|설명  |
 |-----------|------|------|------|
| commentId | Long |O     |일정 고유번호  |

- Example response (성공)
```

```
- Example response (실패)

```
{
    "errorCode": 400,
    "message": "댓글이 삭제되지 않았습니다."
}
```
</div>
</details>

<details>
<summary>GET 페이지네이션 일정 조회</summary>
<div markdown="1">       

/api/schedules
- Requset

    ```
  api/schedules/page?page=페이지 번호 & pagesize=한 페이지당크기
  ```
  
|파라미터| 타입   |필수여부| 설명       |
|------|------|------|----------|
|page | INT  |O     | 페이지 번호   |
| pagesize  | INT |O     | 한 페이지당크기 |

- Example response

| 파라미터         | 타입     | 필수여부 | 설명     |
|--------------|--------|------|--------|
| title        | Long   | O    | 제목     |
| username     | String | O    | 작성자 이름 |
| content      | String | O    | 내용     |
| commentCount | INT    | O    | 댓글 수   |
| created_At   | Date   | O    | 생성 날짜  |
| updated_At   | Date   | O    | 수정 날짜  |

  ```json
 [ 
  {
      "title": "제목",
      "username": "이름",
      "content" : "내용",
      "commentCount": 12,
      "created_At": "2024-11-12",
      "updated_At": "2024-11-13"
    },
  {
    "title": "제목",
    "username": "이름",
    "content" : "내용",
    "commentCount": 12,
    "created_At": "2024-11-12",
    "updated_At": "2024-11-12"
  }
]
```
</div>
</details>

일정 페이지네이션 API

| Method | EndPoint                                           | Desc           |
|--------|----------------------------------------------------|----------------|
| GET    | /api/schedules/page? page=page & pagesize=pagesize | 상세 사용자 정보를 가져옴 |


댓글 API

| Method | EndPoint                   | Desc          |
|--------|----------------------------|---------------|
| POST   | /api/comments              | 새로운 댓글 생성     |
| GET    | /api/comments/{comment_Id} | 상세 댓글 정보를 가져옴 |
| PATCH  | /api/comments/{comment_Id}      | 댓글 수정         |
| DELETE | /api/comments/{comment_Id}    | 댓글 삭제         |



## 필수과제 발전된 일정관리 ERD

![ERD](https://github.com/user-attachments/assets/b32d9989-e838-4bf3-bcf6-d50feb03e967)


## 도전과제 발전된 일정관리 ERD
![도전과제 ERD](https://github.com/user-attachments/assets/dd5d372a-e72e-4369-8445-b92c0f7a506c)

