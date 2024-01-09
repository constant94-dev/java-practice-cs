## 디자인 패턴(Design Pattern) 기술 면접 준비

### 라이브리리(Library)

공통으로 사용될 수 있는 특정한 기능들을 모듈화한 것을 의미합니다. 풀더명, 파일명 등에 대한 규칙이 없고 프레임워크에 비해 자유롭습니다.
예를들어, 무언가를 자를 때 '도구'인 '가위'를 사용해서 '내가' 직접 컨트롤하여 자르는데, 라이브러리는 이와 비슷합니다.

---
### 프레임워크(Framework)

공통으로 사용될 수 있는 특정한 기능들을 모듈화한 것을 의미합니다. 폴더명, 파일명 등에 대한 규칙이 있으며 라이브러리에 비해 좀 더 엄격합니다.
다른 곳으로 이동할 때 '도구'인 비행기를 타고 이동하지만 '비행기'가 컨트롤하고 나는 가만히 앉아 있어야 한다. 프레임워크는 이와 비슷합니다.

---
### 디자인 패턴이란 무엇인가요?

프로그램을 설계할 때 발생했던 문제점들을 해결할 수 있는 재사용 가능한 `Best Practice`로 만들어 놓은 것을 의미합니다.

---
### Singleton 패턴은 무엇이고 언제 사용되며 어떻게 구현하나요?

싱글톤 패턴은 하나의 클래스에 오직 하나의 인스턴스만 가지는 패턴입니다.

하나의 클래스를 기반으로 단 하나의 인스턴스를 만들어 이를 기반해 로직을 만드는데 쓰이며, 보통 데이터베이스 연결 모듈에 많이 사용됩니다.

하나의 인스턴스를 다른 모듈들이 공유하며 사용하기 때문에 인스턴스를 생성할 때 드는 비용이 줄어드는 장점이 있습니다.
하지만, 의존성이 높아진다는 단점도 있습니다.

```java
class Singleton{
    private static class singleInstanceHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance(){
        return singleInstanceHolder.INSTANCE;
    }
}

public class HelloWorld {
    public static void main(String[] args) {
        Singleton a = Singleton.getInstance();
        Singleton b = Singleton.getInstance();
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        if (a == b){
            System.out.println(true);
        }
    }
}
/*
705927765
705927765
true        
 */
```

싱글톤 패턴은 TDD(Test Driven Development)를 할 때 걸림돌이 됩니다. TDD를 할 때 단위 테스트를 주로 하는데,
단위 테스트는 테스트가 서로 독립적이어야 하며 테스트를 어떤 순서로든 실행할 수 있어야 합니다.

하지만 싱글톤 패턴은 미리 생성된 하나의 인스턴스를 기반으로 구현하는 패턴이므로 각 테스트마다 '독립적인' 인스턴스를 만들기가 어렵습니다.

---
### Factory 패턴은 무엇이고 언제 사용되며 어떻게 구현하나요?

팩토리 패턴은 객체를 사용하는 코드에서 객체 생성 부분을 때어내 추상화한 패턴이자 상속 관계에 있는 두 클래스에서 상위 클래스가 중요한 뼈대를 결정하고,
하위 클래스에서 객체 생성에 관한 구체적인 내용을 결정하는 패턴입니다. 

```java
abstract class Coffee {
    public abstract int getPrice();
    
    @Override
    public String toString(){
        return "Hi this coffee is "+ this.getPrice();
    }
}

class CoffeeFactory {
    public static Coffee getCoffee(String type, int price){
        if ("Latte".equalsIgnoreCase(type)) return new Latte(price);
        else if ("Americano".equalsIgnoreCase(type)) return new Americano(price);
        else return new DefaultCoffee();
    }
}

class DefaultCoffee extends Coffee {
    private int price;
    
    public DefaultCoffee(){
        this.price = -1;
    }
    
    @Override
    public int getPrice(){
        return this.price;
    }
}

class Latte extends Coffee {
    private int price;
    
    public Latte(int price){
        this.price = price;
    }
    
    @Override
    public int getPrice(){
        return this.price;
    }
}

public class HelloWorld {
    public static void main(String[] args) {
        Coffee latte = CoffeeFactory.getCoffee("Latte",4000);
        Coffee ame = CoffeeFactory.getCoffee("Americano",3000);
        System.out.println("Factory latte ::" + latte);
        System.out.println("Factory ame ::"+ ame);
    }
}
/*
Factory latte ::Hi this coffee is 4000
Factory ame ::Hi this coffee is 3000        
 */
```

---
### Strategy 패턴은 무엇이고 언제 사용되며 어떻게 구현하나요?

전략 패턴은 객체의 행위를 바꾸고 싶은 경우 '직접' 수정하지 않고 전략이라고 부르는 '캡슐화한 알고리즘'을 컨텍스트 안에서 바꿔주면서 상호 교체가 가능하게 만드는 패턴입니다.

우리가 어떤 것을 구매할 때 네이버페이, 카카오페이 등 다양한 방법으로 결제할 수 있듯이 결제 방식만 바꿔서 구현할 수 있는 것입니다.

컨텍스트란, 프로그래밍에서의 상황, 맥락 문맥을 의미하며 개발자가 어떠한 작업을 완료하는 데 필요한 모든 관련 정보를 말합니다.

```java
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
interface PaymentStrategy {
    public void pay(int amount);
}

class KAKAOCardStrategy implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;
    
    public KAKAOStrategy(String nm, String ccNum, String cvv, String expiryDate){
        this.name = nm;
        this.cardNumber = ccNum;
        this.cvv = cvv;
        this.dateOfExpiry = expiryDate;
    }
    
    @Override
    public void pay(int amount){
        System.out.println(amount + " paid using KAKAOCard.");
    }
}

class LUNACardStrategy implements PaymentStrategy {
    private String emailId;
    private String password;
    
    public LUNACardStrategy(String email, String pwd){
        this.emailId = email;
        this.password = pwd;
    }
    
    @Override
    public void pay(int amount){
        System.out.println(amount + " paid using LUNACard.");
    }
}

class Item {
    private String name;
    private int price;
    
    public Item(String name, int cost){
        this.name = name;
        this.price = cost;
    }
    
    public String getName(){
        return name;
    }
    
    public int getPrice(){
        return price;
    }
}

class ShoppingCart {
    List<Item> items;
    
    public ShoppingCart(){
        this.items = new ArrayList<Item>();
    }
    
    public void addItem(Item item){
        this.items.add(item);
    }
    
    public void removeItem(Item item){
        this.items.remove(item);
    }
    
    public int calculateTotal(){
        int sum = 0;
        for (Item item : items){
            sum += item.getPrice();
        }
        return sume;
    }
    
    public void pay(PaymentStrategy paymentStrategy){
        int amount = calculateTotal();
        paymentStrategy.pay(amount);
    }
}

public class HelloWorld(){
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        
        Item A = new Item("aaronA",100);
        Item B = new Item("aaronB",300);
        
        cart.addItem(A);
        cart.addItem(B);
        
        // pay by LUNACard
        cart.pay(new LUNACardStrategy("aaron@example.com","pukubababo"));
        // pay by KAKAOCard
        cart.pay(new LUNACardStrategy("Park Ji Sung","123456789","123","12/01"));
    }
}
/*
 400 paid using LUNACard.
 400 paid using KAKAOCard.
 */
```

위 코드는 쇼핑 카트에 아이템을 담아 LUNACard 또는 KAKAOCard 두 개의 전략으로 결제하는 코드입니다.

---
### Observer 패턴은 무엇이고 언제 사용되며 어떻게 구현하나요?

옵저버 패턴은 주체가 어떤 객체(subject)의 상태 변화를 관찰하다가 상태 변화가 있을 때마다 메서드 등을 통해 옵저버 목록에 있는 옵저버들에게 변화를 알려주는 디자인 패턴입니다.

옵저버 패턴을 활용한 서비스로는 트위터가 있습니다. 내가 어떤 사람을 '팔로우'했다면 주체가 포스팅을 올리게 되면 알림이 '팔로워'에게 가게됩니다.

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

interface Subject {
    public void register();
    public void unregister();
    public void notifyObservers();
    public Object getUpdate(Observer obj);
}

interface Observer {
    public void update();
}

class Topic implements Subject {
    private List<Observer> observers;
    private String message;
    
    public Topic(){
        this.observers = new ArrayList<>();
        this.message = "";
    }
    
    @Override
    public void register(Observer obj){
        if (!observers.contains(obj)) observers.add(obj);
    }
    
    @Override
    public void unregister(Observer obj){
        observers.remove(obj);
    }
    
    @Override
    public void notifyObservers(){
        this.observers.forEach(Observer::update);
    }
    
    @Override
    public Object getUpdate(Observer obj){
        return this.message;
    }
    
    public void postMessage(String msg){
        System.out.println("Message sended to Topic: "+msg);
        this.message = msg;
        notifyObservers();
    }
}

class TopicSubscriber implements Observer {
    private String name;
    private Subject topic;
    
    public TopicSubscriber(String name, Subject topic){
        this.name = name;
        this.topic = topic;
    }
    
    @Override
    public void update(){
        String msg = (String)topic.getUpdate(this);
        System.out.println(name + ":: got message >> "+msg);
    }
}

public class HelloWorld {
    public static void main(String[] args) {
        Topic topic = new Topic();
        Observer a = new TopicSubscriber("a",topic);
        Observer b = new TopicSubscriber("b",topic);
        Observer c = new TopicSubscriber("c",topic);
        
        topic.register(a);
        topic.register(b);
        topic.register(c);
        
        topic.postMessage("lilia is op champion!!");
    }
}
/*
 Message sended to Topic: lilia is op champion!!
 a:: got message >> lilia is op champion!!
 b:: got message >> lilia is op champion!!
 c:: got message >> lilia is op champion!!
 */
```

---
### Proxy 패턴은 무엇이고 언제 사용되며 어떻게 구현하나요?

프록시 패턴은 대상 객체에 접근하기 전 그 접근에 대한 흐름을 가로채 대상 객체 앞단의 인터페이스 역할을 하는 디자인 패턴입니다.

이를 통해 객체의 속성, 변환 등을 보완하며 보안, 데이터 검증, 캐싱, 로깅에 사용합니다.

```java
interface Coffee {
    String getName();
}

class Americano implements Coffee{
    @Override
    public String getName(){
        return "아메리카노 맛있어!";
    }
}

class CoffeeProxy implements Coffee {
    private Coffee coffee;
    
    public CoffeeProxy(Coffee coffee){
        this.coffee = coffee;
    }
    
    @Override
    public String getName(){
        // 호출에 대한 흐름 제어가 주 목적이다.
        return coffee.getName();
    }
}

public class Proxy {
    public static void main(String[] args) {
        Coffee proxy = new CoffeeProxy(new Americano());
        System.out.println(proxy.getName());
    }
}
/*
 아메리카노 맛있어~
 */
```

---
### Iterator 패턴은 무엇이고 언제 사용되며 어떻게 구현하나요?

이터레이터 패턴은 이터레이터(Iterator)를 사용하여 컬렉션 요소들에 접근하는 디자인 패턴입니다.

이를 통해 순회할 수 있는 여러 가지 자료형의 구조와는 상관없이 이터레이터라는 하나의 인터페이스로 순회가 가능합니다.

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// 요소를 나타내는 클래스
class Number {
    private int value;
    
    public Number(int value){
        this.value = value;
    }
    
    public int getValue(){
        return value;
    }
}

// 이터레이터 인터페이스
interface NumberIterator {
    boolean hasNext();
    Number next();
}

// 숫자 리스트를 가지고 있는 컬렉션 클래스
class NumberCollection implements NumberIterator {
    private List<Number> numbers;
    private int currentIndex;
    
    public NumberCollection(){
        this.numbers = new ArrayList<>();
        currentIndex = 0;
    }
    
    public void addNumber(Number number){
        numbers.add(number);
    }
    
    @Override
    public boolean hasNext(){
        return currentIndex < numbers.size();
    }
    
    @Override
    public Number next(){
        if (hasNext()){
            Number number = numbers.get(currentIndex);
            currentIndex++;
            return number;
        } else {
            return null;
        }
    }
}

public class IteratorPatternExample {
    public static void main(String[] args) {
        NumberCollection numberCollection = new NumberCollection();
        numberCollection.addNumber(new Number(1));
        numberCollection.addNumber(new Number(2));
        numberCollection.addNumber(new Number(3));
        
        // 이터레이터를 사용하여 순회
        NumberIterator iterator = numberCollection;
        while (iterator.hasNext()){
            Number number = iterator.next();
            System.out.println("Number: "+number.getValue());
        }
    }
}
/*
Number: 1
Number: 2
Number: 3
 */
```

---
### revealing module 패턴은 무엇이고 언제 사용되며 어떻게 구현하나요?

노출모듈 패턴은 즉시 실행 함수를 통해 private, public 같은 접근 제어자를 만드는 패턴을 말합니다.

해당 패턴은 자바스크립트 사용시 접근 제어자가 존재하지 않고 전역 범위에서 스크립트가 실행됩니다. 그렇기 때문에 노출모듈 패턴을 통해 접근제어자를 구현하기도 합니다.

```javascript
const pukuba = (() => {
    const a = 1
    const b = () => 2
    const public = {
        c : 2,
        d : () => 3
    }
    return public
})()
console.log(pukuba)
console.log(pukuba.a)
/*
{ c:2, d:[Function:d] }
undefined
*/
```

위 코드에서 a,b 는 다른 모듈에서 사용할 수 없는 변수나 함수이며 private 범위를 가진다.

c,d 는 다른 모듈에서 사용할 수 있는 변수나 함수이며 public 범위를 가진다.

+ public: 클래스에 정의된 함수에서 접근 가능하며 자식 클래스와 외부 클래스에서 접근 가능한 범위
+ protected: 클래스에 정의된 함수에서 접근 가능, 자식 클래스에서 접근 가능하지만 외부 클래스에서 접근 불가능한 범위
+ private: 클래스에 정의된 함수에서 접근 가능하지만 자식 클래스와 외부 클래스에서 접근 불가능한 범위
+ 즉시 실행 함수: 함수를 정의하자마자 바로 호출하는 함수, 초기화 코드, 라이브러리 내 전역 변수의 충돌 방지 등에 사용한다.

---
### MVC 패턴은 무엇인가요?

MVC 패턴은 모델(Model), 뷰(View), 컨트롤러(Controller)로 이루어진 디자인 패턴입니다.

애플리케이션의 구성 요소를 세 가지 역할로 구분하여 개발 프로세스에서 각각의 구성 요소에마 집중해서 개발할 수 있습니다.

재사용성과 확장성이 용이하다는 장점이 있고, 애플리케이션이 복잡해질수록 모델과 뷰의 관계가 복잡해지는 단점이 있습니다.

---
### MVP 패턴은 무엇인가요?

MVP 패턴은 MVC 패턴으로부터 파생되었으며 MVC에서 C에 해당하는 컨트롤러가 프레젠터(presenter)로 교체된 패턴입니다.

뷰와 프레젠터는 일대일 관계이기 때문에 MVC 패턴보다 더 강한 결합을 지닌 디자인 패턴이라고 불 수 있습니다.

---
### MVVM 패턴은 무엇인가요?

MVVM 패턴은 MVC의 C에 해당하는 컨트롤러가 뷰모델(view model)로 바뀐 패턴입니다.

여기서 뷰모델은 뷰를 더 추상화한 계층이며, MVVM 패턴은 MVC 패턴과는 다르게 커맨드와 데이터 바인딩을 가지는 것이 특징입니다.
뷰와 뷰모델 사이의 양방향 데이터 바인딩을 지원하며 UI를 별도의 코드 수정 없이 재사용할 수 있고 단위 테스팅하기 쉽다는 장점이 있습니다.

---
### 프로그래밍 패러다임

프로그래밍 패러다임은(Programming Paradigm)은 프로그래머에게 프로그래밍의 관점을 갖게 해주는 역할을 하는 개발 방법론입니다.

예를 들어, 객체지향 프로그래밍은 프로그래머들이 프로그램을 상호 작용하는 객체들의 집합으로 볼 수 있게 하는 반면에, 함수형 프로그래밍은 상태 값을 지니지 않는 함수 값들의 연속으로 생각할 수 있게 해줍니다.

jdk 1.8 이전의 자바는 객체지향 프로그래밍을 지원해왔고 jdk 1.8 이후부터 함수형 프로그래밍 패러다임을 지원하기 위해 람다식, 생성자 레퍼런스, 메서드 레퍼런스를 도입했고
선언형 프로그래밍을 위해 스트림(stream) 같은 표준 API 등도 추가했습니다.

프로그래밍 패러다임은 크게 선언형, 명령형으로 나누며, 선언형은 함수형이라는 하위 집합을 갖습니다. 또한, 명령형은 다시 객체지향, 절차지향으로 나눕니다.

---
### 선언형과 함수형 프로그래밍

선언형 프로그래밍(declarative programming)이란 '무엇을' 풀어내는가에 집중하는 패러다임이며, '프로그램은 함수로 이루어진 것이다.'라는 명제가 담긴 패러다임이기도 합니다.

함수형 프로그래밍(functional programming)은 선언형 패러다임의 일종입니다.

예를 들어, 자연수로 이루어진 배열에서 최댓값을 찾으려고 한다면 다음과 같은 로직을 구성합니다.

```javascript
const list = [1,2,3,4,5,11,12]
const ret = list.reduce((max,num) => num > max ? num : max, 0)
console.log(ret) // 12
```

위 코드에 `reduce()`는 '배열'만 받아서 누적한 결괏값을 반환하는 순수 함수이다.

함수형 프로그래밍은 이와 같은 작은 '순수 함수'들을 블록처럼 쌍하 로직을 구현하고 '고차 함수'를 통해 재사용성을 높인 프로그래밍 패러다임입니다.

자바스크립트는 단순하고 유연한 언어이며, 함수가 일급 객체이기 때문에 객체지향 프로그래밍보다는 함수형 프로그래밍 방식이 선호됩니다.

<strong>순수 함수</strong>는 출력이 입력에만 의존하는 것을 의미합니다.
```javascript
const pure = (a,b) => {
    return a + b
}
```

pure 함수는 들어오는 매개변수 a,b에만 영향을 받습니다. 만약 a,b 말고 다른 전역 변수 c 등이 이 출력에 영향을 주면 순수 함수가 아닙니다.

<strong>고차 함수</strong>란 함수가 함수를 값처럼 매개변수로 받아 로직을 생성할 수 있는 것을 말합니다.

이때 고차 함수를 쓰기 위해서는 해당 언어가 <strong>일급 객체</strong>라는 특징을 가져야 하며 그 특장은 아래와 같습니다.
+ 변수나 메서드에 함수를 할당할 수 있습니다.
+ 함수 안에 함수를 매개변수로 담을 수 있습니다.
+ 함수가 함수를 반환할 수 있습니다.

함수형 프로그래밍은 이외에도 커링, 불변성 등 많은 특징이 있습니다.







