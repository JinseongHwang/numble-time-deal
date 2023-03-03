# 참가자

- 이름(닉네임): 황진성
- 팀: 개인 참여
- 이메일: jinseong.dev@gmail.com

# 시스템 아키텍쳐

# ERD

# 기능 구현 시 고려 사항

## 남은 시간

- 각 상품별로 판매 마감 시간(Cutoff time)을 설정해뒀다.
- 화면에서 카운트다운 되는 '남은 시간'은 클라이언트에서 '마감 시간 - 현재 시간'으로 매 초 계산해서 렌더링한다고 가정했다.

## 상품 할인 정책

- 할인 정책이 변경 가능하다고 가정했고, 인터페이스로 구현했다.
  - 비율 할인 정책 : 정가에서 n% 만큼 할인하는 방식이다.
  - 고정 할인 정책 : 정가에서 n원 만큼 할인하는 방식이다.

# 성능 측정 및 개선 내용

# 회고록
