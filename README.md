# Implementation of autotests for the site "http://automationpractice.com"

Implementation of autotests on selenium with the ability to run from jenkins,
![image](https://user-images.githubusercontent.com/22727314/155967876-48a0b5ac-03ad-46d2-a343-c3ebda2663df.png)
located on the google cloud server (http://34.90.245.179:8080 login: maksimka pas: 123)
via bash script with raising selenoid in docker and recording the results in testrail
![image](https://user-images.githubusercontent.com/22727314/155974845-be5fb811-db62-4efc-bfb5-48bba33357ab.png)
with the formation of the allure report
![image](https://user-images.githubusercontent.com/22727314/155891795-95a27144-fa1f-4425-ad24-cfd6aa41ff37.png)

Bash sckript is used to start the tests
```bash
./scripts/selenoid-and-run-test.sh
```

### In this project were used technologies:
- selenide 6
- Junit 5
- log4j
- Json file for configuration
- Docker
- Jenkins
- Bash script
- Integration with testrail
- Сheckstyle
