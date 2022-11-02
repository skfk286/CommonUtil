# CommonUtil
공통 유틸 클래스 관리


# IDE 공통 설정

  - IDE(통합개발환경) - Eclipse 설정
    - 상단 메뉴바에서 Window - Preferences 선택
      - Workspace 인코딩 설정
        - General - Workspace > Text file encoding : UTF-8 선택
      - 들여쓰기(Indentation) 설정 : 공백 4칸으로 사용<br>
        - General - Editors - Text Editors : Insert spaces for tabs 선택
        - Java - Code Style - Formatter > New.. 버튼 클릭 후 새로운 Profile 생성 > Indentation : Spaces only 선택
        - JavaScript - Code Style - Formatter > New.. 버튼 클릭 후 새로운 Profile 생성 > Tab policy : Spaces only 선택
        - Web - CSS Files - Editor > Indent using spaces 선택 후 size는 4로 설정
        - Web - HTML Files - Editor > Indent using spaces 선택 후 size는 4로 설정
        - XML - XML Files - Editor > Indent using spaces 선택 후 size는 4로 설정
	    - General - Editors - Text Editors > Show whitespace characters 체크
      - MAVEN 저장소 설정<br>
        ![Maven](./images/path_maven.png)<br>
        User Settings > Browse...에서 C:\Workspaces\maven\settings.xml 선택
