# GDJ53-7 Project

## 1. Base Package
```
com.app.home
```
## 2. 기능별 Package
```
기능별 package 명 분리
1. 회원관리		: user
2. 게시판		: board
3. 예약			: schedule
4. 보고서		: report
5. 메신져		: messanger
6. 설정			: config
7. interceptor	: interceptors
8. 공통			: util
9. 기타 필요한 패키지는 협의하에 작성
ex) com.app.home.user....
```

## 3. 기능별 조 편성
```
1. 회원관리
	 4조
2. 게시판
   2조
3. 예약
	 5조
4. 보고서 결제
	 1조
5. 사내 채팅
	 3조
```

## 4. properties 분리
```
 1. application.properties
	공통 설정
	보안을 요구하지 않는 공통 설정
 2. application-dev.properties
	개발시 필요한 설정
	DB연결등 보안을 요구하는 개별 설정

- application-dev.properties 는 ignore파일에 등록 됨
- github에 등록되지 않음에 유의
- JSP 연결 확인 완료
```

## 5. 하나의 파일을 여러명 작성시
```
- application.properties등 하나의 파일에 여러명 작성시 충돌을 방지

- 각 조별 명이 있는 주석 다음줄 부터 작성

ex) 
	#1조
	  1조는 이 영역에서만 작성

	#2조
	  2조는 이 영역에서만 작성

	...
```

## 6. Git merge
```
	1. 각 조별로 기능을 완성하고 한명에 merge

	2. 이후 main(강사)과 merge
```
## 7. Web Design
```
	1. BootStrap Admin Template 사용
	2. 참조 https://startbootstrap.com/previews/sb-admin-2
	3. header, footer등 template으로 분리 작업 
```
## 8. pom.xml
```
	- 기본 API 설정
	- mybatis, security관련 주석 처리함 , 필요시 주석 해제 후 사용
	- jsp 연결 확인함
	- 각 조별로 필요한 API는 조별 영역(pom.xml내 주석 확인)에 추가
	
```
