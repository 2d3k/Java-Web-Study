# 1. main() 메소드를 활용한 테스트의 문제점

의도한 결과 값이 출력되는지 콘솔을 통해 확인하는 방법

```java
public class Calculator {

    int add(int i, int j) {
        return i + j;
    }

    public static void main(String[] args) {

        Calculator cal = new Calculator();

        System.out.println(cal.add(1, 2));

    }
}
```

### 문제점 1번
프로덕션 코드와 테스트 코드가 같은 클래스에 위치

* 프로덕션 코드: 실제 서비스를 담당

### 문제점 1번 해결
프로덕션 코드와 테스트 코드를 분리

```java
public class CalculatorTest{

    public static void main(String[] args) {
        Calculator cal = new Calculator();

        add(cal);
        
        private static void add(Calculator cal) {
            System.out.println(cla.add(1, 2));
        }
    }
}
```

### 문제점 2번
메소드 하나의 구현에 집중이 필요
-> Calculator 클래스가 가지고 있는 모든 메소드를 테스트 함.

### 문제점 3번
테스트 결과를 매번 콘솔에 출력되는 값을 통해 수동으로 확인해야 됨.
-> Junit을 활용해 문제점 극복 필요

---

### Junit 메소드

```java
assertEqual()
첫 번째 인자: 기대하는 결과값(expected)
두 번째 인자: 실행한 결과값(actual)

assertTrue()
결과 값이 true/false 인자 확인 가능

assertNull() / assertNotNull()
결과 값의 null 유무 판단 가능

assertArrayEquals()
배열 값이 같은 지 검증

```

### 테스트 코드 중복 제거

- @Before(각 단위테스트 전 전처리)
- @After(메소드 실행 후 후처리) 애노테이션을 활용

- 사용 이유?
코딩량도 더 많아 구현 비용이 크지만, 
Junit은 @RunWith, @Rule과 같은 애노테이션을 사용해 확장할 수 있는데, 
이것은 @Before 안이어야만초기화된 객체에 접근할 수 있다는 제약사항이 있기 때문이다.

---

# 2. 문자열 계산기

문자열 계산기의 요구사항
전달하는 문자를 구분자로 정리 -> 숫자의 합 반환

- 기본 구분자(쉼표나 콜론): 구분자를 기준으로 분리 -> 숫자의 합 반환
- 기본 구분자 외 커스텀 구분자: //와 \n 사이에 위치하는 문자를 커스텀 구분자로 사용
- 음수: RuntimeException 예외처리

추가 요구사항
리팩토링: 중복을 제거하고, 읽기 좋은 코드를 구현하기 위해 구조를 변경하는 것
-> 가독성 향상, 유지보수 편리

리팩토링 tip
- 메소드가 한 가지 책임만 가지도록 구현
- 인덴트(들여쓰기) 깊이를 1단계로 유지
- Else 사용 지양

구현 -> 테스트로 결과 확인 -> 리팩토링의 과정을 연습

---

1. 기본 메소드 구조
```
Public class StringCalculator {

	Int add(String text) {
		return 0;
	}
}
```

2. 빈 문자열 또는 null 값을 입력: 0 반환

```
Public class StringCalculatorTest {

    private StringCalculator cal;
    
    @Before
    public void setup() {
        cal = new StringCalculator();
    }
    
    @Test
    public void add_null() {
    
        assertEquals(0, cal.add(null));
        assetEquals(0, cal.add(""));
    }
    
}
```