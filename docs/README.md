## 숫자 야구 게임

* 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임
* 게임은 다음과 같은 rule 로 진행된다
    * 같은 수가 같은 자리에 있으면 스트라이크
    * 다른 자리에 있으면 볼
    * 같은 수가 전혀 없으면 낫싱
    * 힌트를 이용해서 먼저 상대방의 수를 맞추면 승리한다
* 해당 프로젝트에서 상대방은 컴퓨터이며, 숫자는 게임마다 랜덤하게 생성된다
* 게임이 종료된 후 게임을 다시 시작하거나 완전히 종료할 수 있다
    * 게임이 종료는 정답 요청 횟수의 제한없이 상대방의 숫자를 맞춰야 한다
    
### 기능 요구사항

1. 게임 시작 시 중복되지 않은 3개의 숫자가 정답으로 생성되어야 한다
2. 사용자가 정답을 입력 할 수 있어야 한다
    * 사용자는 중복되지 않은 3자리 숫자만 입력이 가능하다
    * 잘못된 값을 입력할 경우 `IllegalArgumentException` 이 발생하고 애플리케이션은 종료되어야 한다
3. 입력된 숫자는 정답을 비교하여 힌트 또는 정답을 출력해야 한다
    * 정답은 입력된 모든 숫자가 스트라이크이어야 한다
    * 스트라이크: 숫자와 자리가 모두 같을 경우
    * 볼: 숫자는 일치하나 자리가 맞지 않을 경우
    * 낫싱: 입력된 모든 숫자가 스트라이크 또는 볼이 아닌 경우
4. 게임이 종료 된 후 사용자는 재시작 또는 프로그램 종료를 선택할 수 있어야 한다
    * 1 을 입력할 경우 게임이 종료된다
    * 2 를 입력할 경우 새로운 숫자로 게임이 시작된다

### 게임 진행 예시

* 게임 진행은 정답 숫자가 425 일때 다음과 같이 진행 될 수 있다
    * 123을 입력: 425의 2의 숫자와 자리가 같으므로 **1스트라이크**
    * 456을 입력: 425의 4의 숫자와 자리가 같고, 5는 숫자가 같으나 자리가 다르므로 **1스트라이크 1볼**
    * 789을 입력: 425의 어떠한 숫자와 일치하지 않으므로 **낫싱**

### 제약사항

* 숫자 야구 게임은 JDK 8 버전에서 실행이 가능해야 한다
    * 터미널에 `java -version` 명령어를 통해 버전을 확인할 수 있다
* 숫자 야구 게임의 실행 시작점은 `src/main/java` 폴더의 `baseball.Application` 의 `main()` 이다
* `src/test/java` 폴더의 `baseball.ApplicationTest` 의 기본 2개의 Test Case 가 성공해야 한다
    * 제공되는 기본 2개 Test Case 는 필수이며, 추가적으로 작성하여도 된다
    * Mac, Linux 사용자의 경우 터미널에 `./gradlew clean test` 명령어를 통해 Test Case 를 실행할 수 있다
    * Window 사용자의 경우 터미널에 `gradlew.bat clean test` 명령어를 통해 Test Case 를 실행할 수 있다
* JDK 에서 제공하는 `Random`/`Scanner API` 대신 `camp.nextstep.edu.missionutils` 에서 제공하는 기능으로 구현해야 한다
    * Random 값 추출: `camp.nextstep.edu.missionutils.Randoms` 의 `pickNumberInRange()` 를 활용한다
    * 사용자 입력값 처리: `camp.nextstep.edu.missionutils.Console` 의 `readLine()` 을 활용한다
* [링크](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 의 자바 코드 컨벤션을 지켜야 한다
* indent depth 는 2가 넘지 않아야 한다
    * if, while 등의 block 안에 다시 다른 block 이 있을 경우 2 depth 이다
* 메소드의 길이가 10 라인을 넘어가지 않아야 한다
* 도메인 로직에 단위 테스트를 구현해야 한다
    * UI 로직은 제외
* [링크](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 의 커밋 메시지 컨벤션을 참고하여 commit log 를 남겨야 한다