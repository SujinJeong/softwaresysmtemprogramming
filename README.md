## 2020-1 System Software Develop
<h3>소규모 디자인/팬시 문구점을 운영하는 개인 사업자를 위한 미니 POS 시스템(소상공인을 위한 ERP)<h3>

<div>
<img src="https://user-images.githubusercontent.com/64065318/99981952-50bd1480-2ded-11eb-96f9-4e97c38859c2.GIF" width="90%"></img>
<img src="https://user-images.githubusercontent.com/64065318/99981959-5286d800-2ded-11eb-8f70-543169dcbe36.GIF" width="90%"></img>
<img src="https://user-images.githubusercontent.com/64065318/99981960-531f6e80-2ded-11eb-9fe0-b924d7d3dd9b.GIF" width="90%"></img>
<div>

## 개발환경<br/>
개발IDE - Eclipse IDE for Java EE Developer , SpringToolSuite4<br/>
Tomcat - Apache Tomcat 9.0<br/>
Oracle - Oracle SQL Develop<br/>

## 사용기술<br/>
> 1. Model-View-Controller구조<br/>
Model – JavaBean DI 및 어노테이션 활용(Business layer)<br/>
View – JSP, HTML, Ajax 등을 이용함(Presentation layer)<br/>
Controller –client로부터 HTTP Request수신<br/>
RESTful API를 사용해 view와 controller사이에서의 데이터를 처리함 <br/>
SQL문을 사용, DAO클래스 및 mapper를 이용해 DB관리(Persistence layer)<br/>
> 2. MyBatis<br/>
> 3. RestAPI<br/>
> 4. Interceptor : 로그인이 필요한 부분에서 Interceptor 구현 통해 session 검사<br/>
> 5. Validator<br/>

## 자세한 DEMO나 구현 내용 Google 공유 드라이브에 첨부<br/>
https://drive.google.com/drive/folders/1p_mnWSnahLpD0WB9pcjpoYCqi1PGvphS
