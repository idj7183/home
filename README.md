* Thmyleaf를 사용하다가 아직 익숙하지 않아 일단 Mustache를 사용했습니다<br>
  프론트엔드 쪽에 너무 많은 신경을 쓰지 않으려고 일단 사용한 것이고, 기능을 이제 다 구현했으니 Thymeleaf로 천천히 바꾸겠습니다
- - -
## 시연영상
[![시연영상](https://img.youtube.com/vi/YiBDo5mq0CQ/0.jpg)](https://youtu.be/UYdviTdyQhY?t=0s)

## 장바구니

<기능><br>
1. 모든 물품 보기 : cart Cookie에는 물품1=3/물품2=4 라는 값이 저장되어 있음
2. 물품 수량 증/감 : 수량 input에 마우스를 갖다대면 화살표가 뜨고, 이를 통해 증가/감소 시킬 수 있음
<br>* 음수 수량은 화살표를 통해 못 감. -1을 입력으로써는 가능하므로, Validation을 사용해야 할 것으로 생각됨
3. 장바구니에서 제거 : 장바구니에서 제거 버튼을 클릭하면 해당 물품이 제거됨
4. 결제 --> 버튼만 생성

- - -
## 관리자 페이지

<조건>
ADMIN의 ROLE을 가진 사람만 접근 가능 : 저는 시큐리티에서 일단 permitAll로 해놔서 들어갈 수 있을 겁니다
<br>
<기능><br>
1. 메인 페이지 : 방문자 수<br>
* 오늘 ~ 6일 전까지의 방문자 수를 표현<br>
* 날짜가 변경되면 그래프가 왼쪽으로 움직이며, 다시 오늘 방문자 수가 0으로 설정되도록 했음<br>
* 어차피 테스트이기 때문에, 당일 페이지 빼고는 Random한 값을 대입했음<br>
* 쿠키를 사용하고, setMaxage(-1)을 사용했으므로 브라우저를 닫았다가 다시 들어오면 방문자 수가 늘어날 것입니다<br>
* AOP를 사용해서 Controller(GetMapping) 중 어느 곳이든 접근하면 증가하도록 했으므로 사이트의 어느 부분이든 접근하면 수가 증가합니다
<br>
2. 권한 부여 : 버튼을 클릭하고 ID를 입력 후 엔터 혹은 찾기 버튼을 클릭하면 확인 구문창이 나오고 확인을 누르면 권한 변경<br>
* 만약 해당 아이디가 없으면 error창을 띄우게 했는데, 이게 JSON형태라 조금 손봐야해서 완벽한 구현은 아닙니다
<br>
3. 전체 회원 수 : 버튼을 클릭하면 알림창으로 전체 회원 수가 나오도록 설정
