## 2020-1 System Software Develop Spring Project
- **소규모 디자인/팬시 문구점을 운영하는 개인 사업자를 위한 미니 POS 시스템**  
    *- 소상공인을 위한 ERP -*

<div>
<img src="https://user-images.githubusercontent.com/64065318/99981952-50bd1480-2ded-11eb-96f9-4e97c38859c2.GIF" width="90%"></img>
<img src="https://user-images.githubusercontent.com/64065318/99981959-5286d800-2ded-11eb-8f70-543169dcbe36.GIF" width="90%"></img>
<img src="https://user-images.githubusercontent.com/64065318/99981960-531f6e80-2ded-11eb-9fe0-b924d7d3dd9b.GIF" width="90%"></img>
<div>


# 개발환경
```java
1. 개발IDE - Eclipse IDE for Java EE Developer , SpringToolSuite4<br/>
2. Tomcat - Apache Tomcat 9.0<br/>
3. Oracle - Oracle SQL Develop<br/>
```


# 사용기술
- **Model-View-Controller구조 FLOW**  
<div style="text-align : center;">
<img src="./img/SpringMVC.png" width="80%" class="center"></img>
<img src="./img/html.png" width="80%"></img>
</div>
  
1. *Model – JavaBean DI 및 어노테이션 활용(Business layer)*
2. *View – JSP, HTML, Ajax 등을 이용(Presentation layer)*
3. *Controller – Client로부터 HTTP Request수신*

- **MyBatis**  
    *DB CRUD기능 분리, SQL문을 사용, DAO클래스 및 mapper를 이용해 DB관리*
<div style="text-align : center;">
<img src="./img/mybatis.jpg" width="90%"></img>
</div>

- **RestAPI & JSON**  
    *Client와 통신을 통한 양방향 소통 구현(view와 controller사이에서의 데이터를 처리)* 
<div style="text-align : center;">
<img src="./img/restapi.png" width="50%"></img>
<img src="./img/json.jpg" width="20%"></img>
</div>

- **Interceptor**  
    *로그인이 필요한 부분에서 Interceptor 구현 통해 session 검사*

- **Validator**  
    *아이디, 비밀번호 등 조건 추가 통해 안정성 향상*

## 자세한 DEMO나 구현 내용 Google 공유 드라이브에 첨부
https://drive.google.com/drive/folders/1p_mnWSnahLpD0WB9pcjpoYCqi1PGvphS


# Author
[Sujin](https://github.com/SujinJeong)
- Blog : https://blog.naver.com/lovesujin051
- E-mail : lovesujin05173@gmail.com
