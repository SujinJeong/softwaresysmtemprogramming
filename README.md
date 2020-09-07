2020-1 System Software Develop
소규모 디자인/팬시 문구점을 운영하는 개인 사업자를 위한 미니 POS 시스템(소상공인을 위한 ERP)

- 개발환경
개발IDE - Eclipse IDE for Java EE Developer , SpringToolSuite4
Tomcat - Apache Tomcat 9.0
Oracle - Oracle SQL Develop

- 사용기술
1. Model-View-Controller구조
Model – JavaBean DI 및 어노테이션 활용(Business layer)
View – JSP, HTML, Ajax 등을 이용함(Presentation layer)
 Controller –client로부터 HTTP Request수신 / Rest를 사용해 view와 controller사이에서의 데이터를 처리함 / SQL문을 사용, DAO클래스 및 mapper를 이용해 DB관리(Persistence layer)
2. MyBatis
3. RestAPI
4. Interceptor
5. Validator