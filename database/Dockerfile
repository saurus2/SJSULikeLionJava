FROM --platform=linux/x86_64 mysql:5.7

# 이미지 환경변수들 세팅
# 실전에서는 비밀번호 등을 이곳에 입력하지 말 것!
# 서버의 환경변수 등을 활용하세요.
ENV MYSQL_USER likelion
ENV MYSQL_PASSWORD Java123!
ENV MYSQL_ROOT_PASSWORD likelionjava
ENV MYSQL_DATABASE likelionjava

# 도커환경에서 컨테이너 생성시 스크립트를 실행하는 폴더로
# 미리 작성된 스크립트들을 이동
COPY ./scripts/ /docker-entrypoint-initdb.d/

# 이미지 빌드 명령어 (현 파일과 같은 디렉토리에서)
# docker build -t liondb-img .

# 실행 명령어 (터미널에 로그 찍히는 것 보기)
# docker run --name liondb-con -it -p 3306:3306 liondb-img

# 실행 명령어 (데몬으로 실행)
# docker run --name liondb-con -p 3306:3306 -d liondb-img
