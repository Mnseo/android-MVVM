# 1. 프로젝트 세팅 (2023.06.22 - 2023.06.23)
## 1-1. 프로젝트 생성

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/b7c2c336-b7ee-457f-8d4d-514d07e4f474/Untitled.png)

프로젝트 처음 세팅에 있어 체크해야할 사항은 

- Name
- Package Name
- Launguage
- Minimum SDK
- Use legacy [android.support](http://android.support).libraries가 있습니다.

1. Name은 프로젝트의 이름,
2. Package는 패키지의 이름,
3. Launguage는 Kotlin 또는 Java 중 어떤 언어로 개발할지,
4. Minimum SDK는 안드로이드가 실행될 최소 버전을 의미합니다.

Minimum SDK는 말 그대로 실행에 필요한 ‘제한 사항’이기 때문에 사용자의 범위를 고려하여 너무 높지도, 낮지도 않은 적당한 버전을 선택하는 것이 좋습니다. 
<br></br>

**Use legacy [android.support](http://android.support) libraries는 어떤 것을 의미하는가?**

android.support 라이브러리의 사용여부를 물어보는 옵션입니다.

현재는 support 라이브러리가 androidx에 통합되어 있어 특별한 상황이 아니라면 선택하지 않아도 됩니다.

**만약 실수로 활성화를 했더라도,** 

`Refactor > Migrate AndroidX` 를 통해 이동할 수 있고, 

**반대 상황이더라도,**

 `Refactor > Migrate Appcompat` 을 통해 이동할 수 있습니다. 

![해당 check를 활성화하고 프로젝트를 생성했을 때의 bulid.gradle(:app)](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/20b15d3b-ddb1-4ed4-af4a-93a2e11b6aa2/Untitled.png)

해당 check를 활성화하고 프로젝트를 생성했을 때의 bulid.gradle(:app)

![해당 check를 비활성화하고 프로젝트를 생성했을 때의 build.gradle(:app)](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/823ec9f6-ec60-4050-90ff-20150231ed77/Untitled.png)

해당 check를 비활성화하고 프로젝트를 생성했을 때의 build.gradle(:app)

<br></br>


## 1-2. Build 설정

이번 프로젝트에서는 `멀티 모듈`을 적용하여 `Clean Architecture`을 구현할 예정이기 때문에 data, presentation, domain 모듈을 생성해줍니다.

![Android Clean Architecture (Presentation, Domain, Data)](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a2dd800e-6812-4dfb-87fc-dd2d286f3f12/Untitled.png)

Android Clean Architecture (Presentation, Domain, Data)

Layer별 build 파일의 의존성 주입은 클린 아키텍쳐의 의존 방향을 참고합니다.<br>
Presentation과 Data Layer은 각각 Domain Layer에 의존하며,
Domain Layer은 어느 Layer에도 의존하지 않습니다.<br>
: `Presentation` → `Domain`← `Data`

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/5f91409e-e031-4d2e-b751-6075fd7555d4/Untitled.png)

멀티 모듈 방식을 활용하여 발생하는 장점은 다음과 같습니다.

- **관심사를 분리하여 의존성을 줄일 수 있습니다**
  <br>
기존의 단일 모듈 방식과는 다르게,
멀티 모듈 방식을 이용하게 되면 build.gradle에서 의존성을 추가하지 않을 경우 다른 모듈의 코드를 사용할 수 없어 의존성 관리에 용이합니다.
- **빌드 시간을 감소할 수 있습니다.**
  <br>
단일 모듈을 사용할 경우 하나의 모듈에서 빌드를 진행하므로 진행 시간이 길어지나, 멀티 모듈 방식을 이용하게 되면 변경된 모듈만 빌드하여 빌드 시간을 감소시킬 수 있습니다.
But, 모듈 간의 종속성이 복잡해지고, 모듈의 수정이 많다면 빌드 시간이 증가할 수 있습니다.
- **코드의 재사용성이 높아집니다.**
  <br>
레이어별, 기능 별로 모듈을 나눠 코드를 작성하게 되면 해당 기능이 필요할 때만 의존성을 추가하면 되기 때문에 재사용성이 높아집니다.
- **모듈 단위 테스트를 할 수 있습니다.**

<br></br>

각 모듈 별 생성 방법을 알아보도록 하겠습니다.

- data, presentation → File > new > new Module > Android Library
    
    ![Data / Presentation Module 생성 방법](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/db3b92f4-235f-469b-a786-7bc8ccc45a0c/Untitled.png)
    
    Data / Presentation Module 생성 방법
    
    각각의 build.gradle의 dependencies에 implementation(project(”:domain”)) 을 추가하여 의존성을 부여합니다.

  <br></br>
    
- domain → File > new > new Module > Java or Kotlin Library
    
    ![Domain Module 생성 방법 ](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ff4bc962-06e7-465a-956b-3162b1e805d0/Untitled.png)
    
    Domain Module 생성 방법 
    
    멀티 모듈 구현 방식은 https://brunch.co.kr/@purpledev/43 다음 포스트를 참고 하였으나,
    
     1. 해당 브런치 작성자 분은 gradle을 Groovy에서 Kotlin으로 변경했고, 
     2. 프로젝트 생성 후 libs에 아무것도 작성하지 않은 분들은 
    
    해당 gradle처럼 작성하면 오류가 뜹니다.
    lib에 아무런 내용이 없기 때문에 지칭하는 것이 없는 것과 마찬가지입니다.
    
    ```groovy
    dependencies{
    implementation "org.jetbrains.kotlin:kotlin-stdlib:1.5.30"
        implementation "javax.inject:javax.inject:1"
        implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0"
    }
    ```
    
    따라서 위처럼 domain의 gradle을 작성하거나,
    Domain의 gradle wrapper 아래에 “libs.versions.toml” 파일을 생성해야합니다.

  <br></br>
    
    - Gradle Version Catalog 
    빌드 종속 항목을 추가할 때 있어서 기존 방식과 차이점이 있습니다.
    아래는 coroutine 항목을 추가하는 경우의 예시입니다.
        

        /* 기존 방식 */
        implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0"
        ```
        
      
        /* Gradle Version Catalog */ 
        implementation(libs.hilt.android)
        ```
        
        위와 같은 방식을 사용하면 다음과 같은 장점이 있습니다.
        
        - 하나의 파일로 **여러 프로젝트, 모듈 버전 관리 통합 관리가 가능**합니다.
        특히 멀티 모듈의 경우, 같은 의존성을 모듈마다 추가하는 경우가 있는데, 하나의 파일에서 쉽게 버전 관리를 할 수 있습니다.
        - 함께 사용하는 의존성을 bundle로 묶어서 관리가 가능합니다.
        - 카탈로그 별로 자동 완성을 지원하여 편리하게 이용이 가능합니다.
        
    - Gradle Version Catalog 설정 (Gradle Version 확인)
    Gradle 버전 7.4부터 지원하며, 해당 버전 미만일 경우 toml을 지정해줘야합니다. 
    Gradle 버전이 7.4 이상이면, 지정하지 않아도 됩니다.
    
    
    /* Gradle Ver 7.4 미만일 경우 setting.gradle */
    enableFeaturePreview("VERSION_CATALOGS")
    
    dependencyResolutionManagement{
        versionCatalogs {
            create("libs") {
    /* libs 아래에 libs.versions.toml 파일에 versionCatalogs 지정 */
                from(files("libs.versions.toml"))
            }
        }
    }
    
    - libs.versions.toml 작성 방법
        - versions: 라이브러리의 버전
        - libraries: 라이브러리 의존성
        - bundles: 라이브러리를 묶어서 한번에 선언
        
        다음은 작성 예시입니다.
        
    ```
        /* build.gradle(:domain)
        implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0"
        
   
        /* libs.versions.toml */
        
        [versions]
        coroutine = "1.6.4"
        
        [libraries]
        coroutine-core = {module = "org.jetbrains.kotlinx:kotlinx-coroutines-core", version.ref="coroutine"}
        
        [bundles]
        coroutine = ["coroutine-core", "coroutine-android"]
        ```

       
    만약 자동완성이나 추가가 되지 않을 경우,
    .build의 cache를 삭제하거나, sync now를 실행하면 됩니다.
        
- App의 Build Gradle에 domain, presentation, data의 의존성을 추가합니다. Activity의 정보를 알기 위해 presentation 모듈을,
레포지토리 구현체를 만들기 위해 모든 모듈을 알고 있어야 합니다.

 또한, App Module에서 Version 카탈로그를 사용하고 싶다면,
     
     
     plugins {
         id 'com.android.application'
         id 'org.jetbrains.kotlin.android'
         id 'version catalog'
     }
     ```
     
     플러그인에 ‘version catalog’ 를 추가해준 후,
     
    
     dependencies {
         implementation(libs.bundles.hilt)
     }
     ```
     
     의존성 항목을 추가해줍니다.
