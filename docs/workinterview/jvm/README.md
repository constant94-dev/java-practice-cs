## Java Virtual Machine(JVM) 기술 면접 준비

### .java와 .class 파일의 차이는 무엇이고 어떻게 동작하나요?

프로그래머는 자바 파일(.java)을 작성하고 컴파일러가 이를 바이트 코드 파일(.class)로 변경시켜 Class Loader에 의해 JVM 메모리에 로드됩니다.

다시말해, .java 파일은 프로그래머가 작성하는 파일이고, .class 파일은 컴파일러에 의해서 .java 파일이 바이트 코드로 변경된 파일입니다.

JVM은 클래스 로더를 사용해서 클래스 파일을 JVM 메모리 즉, Runtime Data Area에 올려놓는다.

---
### 자바는 어떠한 Linking 알고리즘을 사용하고 이러한 알고리즘이 가능한 이유는 무엇인가요?

Linking이란 여러 개의 코드와 데이터를 모아서 연결하는 작업을 의미합니다. Linking을 통해서 생성된 실행 가능한 파일은 Loader를 통해 메모리에 배치됩니다.

자바는 동적 링킹(Dynamic Linking)을 사용하여 실행 가능한 파일을 만들 때 프로그램에서 사용하는 모든 라이브러리 모듈을 복사하지 않고,
해당 모듈의 주소만 가지고 있다가 런타임에 실행 파일과 라이브러리가 메모리에 위치될 때 해당 모듈의 주소로 가서 필요한 것을 들고 오는 방식을 사용합니다.

자바가 동적 링킹(Dynamic Linking)을 사용할 수 있는 이유는 .class 파일이 실행 가능한 형태가 아닌 JVM이 읽을 수 있는 형태 Java Byte Code 이기 때문입니다.

.class 파일은 JVM 위에서 Linking 작업을 수행할 수 있도록, 라이브러리에 대한 `Symbolic Reference`만을 가지고 있게 됩니다.

---
### Runtime Dynamic Loading이란 무엇인가요?

Runtime Dynamic Loading이란 소스코드에서 객체를 참조하는 순간에 동적으로 Loading 하는 방식입니다. 이는 `Reflection`이라는 기술의 기본입니다.

---
### Class Loader란 무엇인가요?

Class Loader는 컴파일 타임에 생성된 바이트 코드(.class)를 런타임에 Load하고 배치하는 일을 담당합니다. 클래스가 참조되는 순간 동적으로 Load 및 Link가 이루어지는 Dynamic Loading을 담당하는 주체입니다.

---
### Runtime Data Area란 무엇인가요?

Runtime Data Area란 JVM이 프로그램을 수행하기 위해 OS로부터 할당 받는 메모리 영역을 의미합니다.

5개의 영역으로 나누어져 있고 `Method Area`, `Heap Area`, `Stacks`, `PC Register`, `Native Method Stacks` 입니다.

---
### PC Register는 무엇인가요?

PC 레지스터(Program Counter Register)는 쓰레드가 시작될 때 생성되며, 현재 수행중인 JVM 명령어 주소를 저장하는 공간입니다.

---
### Stack Area는 무엇인가요?

스택 영역(Stack Area)은 int, long, boolean 등 기본 자료형을 생성할 때 저장하는 공간으로, 임시적으로 사용되는 변수나 정보들이 저장되는 영역

---
### Stack Area에 존재하는 Frame은 무엇인가요?

메서드 호출 시마다 각각의 스택 프레임(메서드만을 위한 공간)이 생성되고 메서드 안에서 사용되는 값들을 저장하고,
호출된 메서드의 매개변수, 지역변수, 리턴 값 및 연산 시 발생하는 값들을 임시로 저장합니다.

---
### Native Method Stack은 무엇인가요?

네이티브 메서드 스택(Native Method Stack)은 자바 코드가 컴파일되어 생성되는 바이트 코드가 아닌
실제 실행할 수 있는 기계어로 작성된 프로그램을 실행시키는 영역

또한, 자바 이외의 언어 C, C++로 작성된 네이티브 코드를 실행하기 위한 공간이기도 합니다.

---
### Method Area란 무엇인가요?

메서드 영역(Method Area)은 JVM이 시작될 때 생성되는 공간으로 바이트 코드(.class)를 처음 메모리 공간에 올릴 때 초기화되는 대상을 저장하기 위한 메모리 공간입니다.

---
### Run-Time Constant Pool이란 무엇인가요?

Runtime Constant Pool은 메서드 영역에 존재하는 별도의 관리영역이고 각 클래스/인터페이스 마다 별도의 constant pool 테이블이 존재하고, 클래스를 생성할 때 참조해야할 정보들을 상수로 가지고 있는 영역입니다.

상수 자료형을 저장하여 참조하고 중복을 막는 역할을 합니다.

---
### Heap Area란 무엇인가요?

힙 영역(Heep Area)는 메서드 영역과 함께 모든 쓰레드가 공유하며, JVM이 관리하는 프로그램에서 데이터를 저장하기 위해 런타임시 동적으로 할당하여 사용하는 영역입니다.

new 연산자로 생성되는 클래스와 인스턴스 변수, 배열 타입 등 `Reference Type`이 저장되는 곳입니다.

`Young Generation`은 객체가 최초로 할당되는 장소이며 Eden 영역의 공간이 꽉 차게 되면 객체 참조가 살아있는 객체만 Survivor 영역으로 옭기고, 참조가 없는 객체라면 청소합니다.

`Old Generation`은 Young Generation 영역에서 마지막 까지 살아남은 객체가 이동하는 영역이며 이동하는 작업을 `Promotion`이라고 부릅니다.

---
### Execute Engine이란 무엇인가요?

실행 엔진(Execution Engine)은 클래스 로더를 통해 런타임 데이터 영역에 배치된 바이트 코드를 명령어 단위로 읽어서 실행하는 영역입니다.

3가지 주요 요소가 있는데요.

+ 인터프리터(Interpreter): 인터프리터는 Java Byte Code를 읽고 OS의 native code로 변화하여 이들을 순차적인 방식으로 실행하는 구성요소를 의미합니다.
+ JIT 컴파일러(Compiler): JIT 컴파일러는 인터프리터의 느린 실행의 단점을 보완하기 위해 도입되었습니다.
+ 가비지 컬렉터(Garbage Collector): Heap 메모리 영역에서 더는 사용하지 않는 메모리를 자동으로 회수합니다.

---
### Java Native Interface(JNI)

JNI(Java Native Interface)는 자바가 다른 언어로 만들어진 애플리케이션과 상호 작용할 수 있는 인터페이스 제공합니다.

또한, JVM이 Native Method를 적재하고 수행할 수 있도록 한다

---
### Garbage Collection이란 무엇인가요?

가비지 컬렉션이란 Heap을 재활용하기 위해 Root Space에서 참조되지 않는 Object(Unreachable Object)를 없애 가용한 공간을 만드는 작업이라고 할 수 있습니다.

가비지 컬렉션에서 청소 방식은 `Mark And Sweep` 과정을 사용하는데요. 대상 객체를 식별(Mark)하고 제거(Sweep)하며 파편화된 메모리 영역을 앞에서 부터 채워나가는 작업(Compaction)을 수행합니다.

---
### Reference Counting Algorithm이란 무엇인가요?

Heap Area에서 관리되는 객체마다 Count를 관리하여 객체가 참조될 때마다 Count를 1증가시키고 참조가 사라지면 1을 감소하는 식으로 동작합니다.