## 스프링 프레임워크 기술 면접 준비

### Spring Framework란 무엇인가요?

스프링 프레임워크란 자바를 위한 오픈 소스 애플리케이션 프레임워크로써 애플리케이션 개발을 위해 다양한 서비스를 제공해주고 있습니다.

+ 애플리케이션을 만들기 위해 기본적인 틀을 구성해주어 개발자가 비즈니스 로직에 집중하게 도와줍니다.

---
### 라이브리리(Library)

공통으로 사용될 수 있는 특정한 기능들을 모듈화한 것을 의미합니다. 풀더명, 파일명 등에 대한 규칙이 없고 프레임워크에 비해 자유롭습니다.
예를들어, 무언가를 자를 때 '도구'인 '가위'를 사용해서 '내가' 직접 컨트롤하여 자르는데, 라이브러리는 이와 비슷합니다.

---
### 프레임워크(Framework)

공통으로 사용될 수 있는 특정한 기능들을 모듈화한 것을 의미합니다. 폴더명, 파일명 등에 대한 규칙이 있으며 라이브러리에 비해 좀 더 엄격합니다.
다른 곳으로 이동할 때 '도구'인 비행기를 타고 이동하지만 '비행기'가 컨트롤하고 나는 가만히 앉아 있어야 한다. 프레임워크는 이와 비슷합니다.

---
### 프레임워크와 라이브러리의 차이는 무엇인가요?

프레임워크는 특정한 문제 해결을 위해 어느 정도의 뼈대 즉, 구조를 제공해주는 것을 의미하구요, 라이브러리는 특정 기능 사용을 위한 도구나 함수들의 모음을 의미합니다.

차이점으로는 프로그램 전체 흐름에 대한 제어권에서 차이가 발생합니다. 프레임워크는 프로그램의 전체적인 흐름을 자체적으로 가지고 있으며 프레임워크 사용자가 작성한 코드를 호출해서 사용합니다.
하지만, 라이브러리는 사용자가 프로그램의 전체 흐름을 제어하며 사용자 코드로써 라이브러리 특정 기능을 직접 가져다 쓰는것을 의미한다.

---
### 스프링 프레임워크(Spring Framework)의 3대 특징인 IoC, AOP, PSA에 대해서 설명해주세요

IoC란 Inversion of Control의 줄임말로 개발자가 작성한 프로그램의 제어권이 프레임워크에 넘어가서 Spring Framework에서 개발자의 코드를 호출하는 것을 의마합니다.
IoC는 DL(Dependency Lookup)과 DI(Dependency Injection)에 의해서 구현되는데 클래스 및 계층간에 필요한 의존관계를 빈 설정 정보를 바탕으로 IoC Container가 의존성을 찾아주는 것을 DL이라 하구요, 의존성을 주입해 주는 것을 DI라고 합니다.

AOP란 Aspect Oriented Programming의 줄임말로 여러 모듈에서 공통적으로 사용하는 기능 및 로직들을 분리해 관리하고 모듈화하는 프로그래밍 패러다임을 의미합니다.
AOP의 사용 예로는 로깅, 트랜잭션, 인증 등이 존재합니다. 컴파일 타임과 클래스 로드 타임, 런타임 등 모든 시간에 AOP를 적용할 수 있는 방법이 존재한다고 알고 있습니다.
(Java Reflection, Proxy 등)

PSA란 Portable Service Abstraction의 줄임말로 환경과 세부 기술의 변화에 관계없이 일관된 방식으로 기술에 접근할 수 있게 해주는 것을 의미합니다.
PSA가 적용된 대표적인 곳은 JDBC, JPA, Transaction Manager 등이 존재합니다.

---
### IoC Container에 대해서 알고 계시나요?

IoC 컨테이너란 Spring Bean 즉, IoC Container에서 관리하는 객체의 생성과 관계설정, 사용, 제거 등의 전체 LifeCycle을 관리해주는 작업을 하는 컨테이너를 IoC 컨테이너라고 부릅니다.

IoC Container의 대표적인 명세는 BeanFactory인데 요즘은 이를 상속하는 ApplicationContext를 사용하는 추세입니다.
ApplicationContext는 BeanFactory를 상속하는 인터페이스로써 BeanFactory의 기능 뿐만 아니라, 메시지 다국화, 이벤트 발행 기능, 리소스 로딩 기능 등의 여러 기능을 명세하고 있습니다.

---
### IoC Container로 부터 Bean을 주입받는 방법은 무엇이 있나요?

Bean을 등록하는 방법으로는 xml 설정파일을 이용하는 방법, Configuration 클래스에서 어노테이션을 사용해 Bean을 등록하는 방법, Bean 등록을 하고 싶은 클래스에서 Bean 어노테이션을 통해 등록하는 방법이 존재합니다.
마지막의 경우 Component Scan이 꼭 필요하지만 Spring Boot의 경우 Component Scan까지 자동으로 구성해주어 스프링 환경을 매우 편리하게 사용할 수 있습니다.

---
### Web Server와 Web Application Server의 차이를 아시나요?

웹 서버는 클라이언트부터 HTTP 요청을 받아 정적 콘텐츠인 HTML, CSS, Image 파일 등을 제공하는 서버를 말합니다.
웹 서버의 대표적인 예로는 Apache Server, Nginx 등이 존재합니다.

웹 애플리케이션 서버는 DB 연산이나 다양한 로직 처리를 위한 동적인 콘텐츠를 제공하기 위해 만들어진 애플리케이션 서버입니다.
이는 HTTP를 통해 컴퓨터나 장치에 애플리케이션을 수행해주는 미들웨어입니다. WAS는 Web Container 혹은 Servlet Container라고 불리며 대표적 예로는 Tomcat, Jetty 등이 존재합니다.

웹 서버와 WAS를 분리하는 이유는 자원 이용의 효율성 및 장애 대응, 배포 및 유지보수의 편의성을 위해서 분리합니다.

---
### Java Reflection이란 무엇인가요?

자바 리플렉션이란 컴파일 타임에 클래스나 메서드의 이름을 알지 못해도 런타임에 클래스나 인터페이스, 메서드, 필드 등을 접근할 수 있게 해주는 기능을 의미합니다.

자바 리플렉션이 사용되는 대표적인 예로는 스프링의 `Dependency Injection`이 존재하며 Jackson 라이브러리의 ObjectMapper 에서도 사용됩니다.

---
### Spring Boot와 Spring의 차이점은 무엇인가요?

Spring Boot와 Spring Framework의 가장 큰 차이는 `AutoConfiguration` 즉, 자동 설정의 차이입니다.
스프링 부트는 스프링 부트 스타터 프로젝트를 통해서 특정 애플리케이션 개발을 위한 설정을 자동으로 구성해주고 라이브러리간에 호환성 문제를 해결합니다.

예를들자면, Spring MVC 프로젝트를 Spring Framework 기반으로 구성 한다면, 관련 Bean 설정, DispatcherServlet 설정, View Resolver 설정, JDBC 설정 등
다양한 설정 및 버전 호환성 문제가 발생하지만 Spring Boot Starter Web을 사용해 프로젝트를 구성하면 초기 구성에 걸리는 비용 문제와 호환성 이슈를 해결할 수 있습니다.

---
### MVC 패턴이란 무엇인가요?

MVC 패턴은 모델(Model), 뷰(View), 컨트롤러(Controller)로 이루어진 디자인 패턴입니다.

+ Controller란 사용자 요청을 받아서 모델,뷰와 상호작용을 통해 적절한 응답을 제공해주는 중개자 역할을 하는 컴포넌트입니다.
+ Model은 시스템에서 사용하는 도메인을 의미합니다.
+ View는 사용자에게 제공하는 화면이나 페이지를 의미합니다.

---
### Servlet 이란 무엇인가요?

서블릿이란 특정한 타입의 네트워크 요청에 응답하기 위한 Java EE의 인터페이스 즉, 명세입니다. 구현체로는 `HttpServlet`을 사용하며 Spring MVC에서는 `DispatcherServlet`을 프론트 컨트롤러로 사용합니다.

---
### Servlet과 WAS(Servlet Container)의 관계는 어떻게 되나요?

Servlet Container는 설정 파일(web.xml)을 읽고, 서블릿 클래스를 식별한 다음 클래스 로더를 사용해 JVM에 로드하고 요청에 알맞은 서블릿을 실행합니다.
서블릿 컨테이너는 요청이 들어올 때마다 서블릿을 생성하며 하나의 서블릿에는 하나의 스레드가 할당됩니다.

---
### MVC 패턴 Model1과 Model2를 비교해주세요.

모델1은 사용자 요청과 응답을 전부 `JSP`가 처리하는 모델이구요. 모델2는 컨트롤러에서 사용자 요청을 받아 비즈니스 로직을 태우고 데이터를 `JSP`로 넘겨 응답하는 모델입니다.

![]()

---
### Spring MVC를 위한 필수 설정은 어떤게 있나요?

web.xml 파일을 통해 특정 요청이 Servlet Container로 들어왔을 때 어떠한 Servlet을 매핑할지 설정해야 하구요.
Servlet Container가 Servlet을 매핑하기 전 필터링 해야할 부분이 있다면 필터 설정이 필요합니다.

그 외에도 View를 Resolve할 필요가 있다면 View Resolver, Message를 특정 타입으로 변환해야할 필요가 있다면 MessageConvertor, 어노테이션 기반의 Bean 등록을 위해 ComponentScan,
JDBC 설정을 위한 Bean 설정과 트랜잭션 설정 등 다양한 설정이 MVC 기본 프로젝트를 구성하기 위해서 필요합니다.

---
### Spring MVC 구조에 대해서 설명해주세요

Spring MVC의 시작은 프론트 컨트롤러인 `DispatcherServlet`입니다. `DispatcherServlet`은 사용자 HTTP 요청을 처리하기 위해 등록된 핸들러로 디스패치시켜 맵핑 및 예외 처리 기능을 제공합니다.

![]()

1. `DispatcherServlet`으로 HTTP Request가 들어온다
2. `DispatcherServlet`은 요청 URL 등의 정보와 맵핑되는 적절한 Controller를 선택하는 작업을 HandlerMapping에 디스패치한다.
3. `DispatcherServlet`은 컨트롤러 비즈니스 로직을 실행하는 작업을 HadlerAdapter에 디스패치한다.
4. `HandlerAdapter`는 컨트롤러 비즈니스 로직 프로세스를 호출한다.
5. `Controller`는 비즈니스 로직을 실행하고 결과를 모델에 맵핑하고 view의 논리적인 이름을 HandlerAdapter에 리턴한다.
6. `DispatcherServlet`은 View name에 일치하는 뷰를 Resolving하는 작업을 ViewResolver에게 디스패치하고 ViewResolver는 View name에 맵핑된 뷰를 리턴한다.
7. `DispatcherServlet`은 랜더링 프로세스를 리턴된 뷰에 디스패치한다.
8. `View`는 모델을 랜더링하고 Response를 전송한다

---
### Spring MVC Servlet Processing간에 예외가 발생하면 어떻게 되나요?

`Request Mapping` 또는 `Request Handler`에서 예외가 발생하면 `DispatcherServlet`은 `HandlerExceptionResolver` 인터페이스의 구현체가 예외를 처리해 적절한 응답을 클라인언트에게 보냅니다.

---
### Spring Security는 무엇인가요?

스프링 시큐리티란 자바 애플리케이션에서 인증과 권한 부여, 일반적인 공격에 대한 보호 기능을 제공하는 프레임워크 입니다.

---
### 인증 구현을 위해 Spring Security를 사용한 이유가 있나요?

인증 구현을 위해서 Spring Security를 사용한 이유는 공식문서에서 기본적인 인증과 권한 부여 기능을 제공한다고 해서 사용했구요,
인터셉터와 AOP를 활용하기 보다는 Filter를 통해서 인증을 구현하고 싶어 `Spring Security`를 사용했습니다.

---
### Spring Security 사용하면서 어려운 점이 없었나요?

스프링 시큐리티를 사용하면서 가장 어려웠던 점 중에 하나는 스프링 MVC와 스프링 시큐리티의 구조를 제대로 이해하지 못해서 어느 시점에 `Security Filer`와 `DispatcherServlet`이 동작하며
어떻게 `Security Filter`에 JWT를 처리하는 필터를 만들어서 끼워 넣을까?에 대해서 설계하고 이해하는 데 많이 어려웠습니다.

---
### Filter와 Security Filter의 차이는 무엇인가요?

필터와 시큐리티 필터 모두 `Servlet`에 요청이 맵핑되기 전에 실행되는 필터입니다. 둘 다 동일한 필터이지만 일반 필터는 서블릿 컨테이너에 직접 등록해서 사용하는 필터이고,
시큐리티 필터는 `DelegatingFilterProxy`가 서블릿 컨테이너에 필터로 등록되어서 필터 작업을 `Security FilterChain`으로 위임해 실행되는 필터를 의미합니다.

![]()

---
### Filter와 Interceptor의 차이는 무엇인가요?

필터는 `Spring Context` 외부에 존재하여 서블릿에 요청이 맵핑되기 전에 작업을 수행하구요, `Interceptor`는 `Spring Context`내부에 존재해 `DispatcherServlet`이 컨트롤러를 호출하기 전과 후에 작업을 수행합니다.

![]()

---
### 인증을 위해서 어떻게 Spring Security를 사용하셨나요?

JWT를 생성, 인증, 권한 부여, 유효성 검사, PK 추출을 할 수 있는 클래스인 `JwtTokenProvider`를 만들었구요.
이를 사용해서 Filter 작업을 수행할 `JwtAuthenticationFilter`를 만들었습니다.
JWT 인증 필터가 기본 인증 필터인 `UsernamePasswordAuthenticationFilter` 이전에 수행할 수 있도록 Security Filter Chain 설정을 통해서 인증을 구현할 수 있었습니다.

![]()

---
### Spring Security의 전체적인 인증 프로세스를 설명해 주실 수 있나요?

![]()

1. 클라이언트가 요청을 보내면, `Servlet Filter`에 의해서 `Security Filter`로 작업이 위임되고 여러 Security Filter 중 `JwtAuthenticationFilter`에서 인증을 처리한다.
2. `JwtAuthenticationFilter`는 서블릿 요청 객체에서 토큰을 가져와서 `JwtTokenProvider`가 해당 토큰을 검증해 토큰이 유효한지 검사한다.
3. 토큰이 유효하면 `Authentication` 객체를 만들고 `AuthenticationManager`를 사용할 필요 없이 직접 `SecurityContextHolder`에 접근해 `Authentication`객체를 저장한다.

`SecurityContext`는 default로 `ThreadLocalSecurityContextHolderStrategy`를 사용해 인증 객체를 저장하기 때문에 서블릿 당 하나의 인증 객체가 저장됨을 알 수 있었습니다.

추후에 Controller나 Business Layer에서 `Authentication`객체를 가져와 관련 비즈니스 로직들을 사용자에 맞게 태웠습니다.

---
### ORM이란 무엇인가요?

Object Relational Mapping의 줄임말로 객체 지향 프로그래밍과 관계형 데이터베이스간에 통신시 발생하는 패러다임 불일치 문제를 해결하고자
객체와 관계형 데이터베이스간에 데이터를 자동으로 매핑해주는 기술입니다.

---
### ORM, JPA, Hibernate, Spring Data JPA를 각각 비교해보세요.

`ORM`은 객체 지향 프로그램과 관계형 데이터베이스간 통신시 발생하는 패러다임 문제를 해결하기 위해 데이터를 자동으로 매핑해주는 기술을 의미합니다.

`JPA`란 자바 진영의 ORM을 위한 명세를 의미합니다.

`Hibernate`란 자바 진영의 ORM 명세인 JPA를 구현한 여러 구현체 중 하나를 의미합니다. JPA 구현체로 Hibernate 외에도 `EclipseLink`,`DataNucleus`등이 존재합니다.

`Spring Data JPA`는 스프링 환경에서 JPA를 편리하게 사용할 수 있도록 `Repository` 기반으로 추상화 시킨 스프링 서브 프로젝트입니다.
Spring Data JPA는 JPA 사용시 발생하는 수 많은 `boilerplate`를 없애주고 `Pagination`이나 `Query Method` 등의 다양한 기능을 지원합니다.

---
### 프로젝트에 JPA를 사용하신 이유가 무엇인가요?

프로젝트 진행간에 발생하는 반복되는 쿼리문을 없애고 좀 더 객체지향적으로 코드를 작성하고 싶어서 JPA를 사용했습니다.

---
### JPA의 장점과 단점에 대해서 말씀해주실 수 있나요?

장점으로는 개발자가 반복되는 쿼리를 직접 작성하지 않아도 됨으로 개발 생산성 측면에서 효율이 올라가는 장점이 있습니다.

단점으로는 `Persistent Context`에서 1차 Cache, Write Behind, Dirty Checking, Lazy Loading 등의 다양한 기능을 지원하기 때문에 해당 개념을 모르고 JPA를 사용했을 경우
수 많은 예외와 성능 저하가 발생할 수 있다는 점입니다.

---
### JPA Entity의 상태 변화에 대해서 설명해주실 수 있나요?

JPA Entity의 상태는 `Transient`,`Persistent`,`Detached`,`Removed` 상태가 존재합니다.

+ Transient는 객체가 새롭게 생성된 상태를 의미하며 `Persistent Context`에서 관리하지 않는 상태입니다.
+ Persistent는 `Persistent Context`에서 관리되는 상태이며 해당 엔티티는 1차 캐시, write behind, dirty checking 등의 다양한 기능을 제공받습니다.
+ Detached는 `Persistent Context`에서 해당 엔티티를 더 이상 관리하지 않는 상태입니다.
+ Removed는 데이터베이스로부터 해당 엔티티를 제거한 상태를 의미합니다.

---
### 영속성이 어떻게 유지되고 DB에 저장되는건가요?

1. 트랜잭션이 시작합니다.
2. 새로운 엔티티 객체를 생성합니다.
3. `Persistent Context`에 엔티티 객체를 올립니다.
4. `Persistent Context`는 해당 엔티티를 관리하면서 `Dirty Checking`이나 `1차 캐시`등의 다양한 기능을 제공합니다.
5. 트랜잭션이 커밋되기 전에 flush가 발생하며 `Persistent Context`의 변경 내용들이 데이터베이스에 반영됩니다.
6. 트랜잭션이 커밋됩니다.

---
### 1차 Caching은 무엇인가요?

Flush가 발생하기 전 `Persistent Context` 내부에서 엔티티를 캐싱하는 것을 1차 캐싱이라고 합니다.

---
### Write Behind는 무엇인가요?

Flush가 발생하기 전 DB에 write하는 쿼리문을 `Persistent Context`내의 쓰기 지연 SQL 저장소에서 관리해 Flush가 일어날 때 이를 데이터베이스에 반영하는 것을 `Write Behind`라고 합니다.

---
### Dirty Checking은 무엇인가요?

`Persistent Context`에서 flush가 일어날 때 저장된 엔티티와 스냅샷의 상태를 비교해서 서로 다르면 알맞은 쿼리문을 데이터베이스에 반영하는 것을 `Dirty Checking`이라고 합니다.

---
### Lazy Loading은 무엇인가요?

DB로부터 엔티티를 가져올 때 참조된 엔티티와 관련된 select 쿼리가 발생하는 것이 아닌 프록시를 통해 직접 참조된 엔티티를 사용할 경우에 select 쿼리가 발생하는 것을 의미합니다.

---
### QueryDSL은 무엇인가요?

`Type-safe`한 방식으로 쿼리를 작성할 수 있도록 도와주는 프레임워크를 의미합니다. `QueryDSL`을 사용하면 컴파일 타임에 쿼리의 문법 오류를 검증할 수 있고, IDE의 자동 완성 기능을 사용해 보다 `Type-safe`한 쿼리를 작성할 수 있습니다.

