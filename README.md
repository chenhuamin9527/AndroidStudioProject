
# 《第一行代码》随书笔记

## 第一章
- Android系统架构
  1. Linux内核层
  2. 系统运行库层
  3. 应用框架层
  4. 应用层
- Android应用开发特色
  1. 四大组件：Activity、Service、BroadcastReceiver和ContentProvider。
  2. 丰富的系统控件
  3. SQLite数据库
  4. 强大的多媒体
- 准备所需要工具
  - JDK。JDK是Java语言的软件开发包，它包含了Java的运行环境、工具集合、基础类库等内容。
  - Android SDK。Android SDK是Google提供的Android开发工具包。
  - Android Studio。Google推出的官方IDE工具。
- 项目结构文件
  1. .gradle和.idea
  - 这两个目录下放置的都是Android Studio自动生成的文件。
  2. app
  - 项目中的代码、资源等内容都是放置在这个目录下。
  3. build
  - 这个目录主要包含了一些在编译时自动生成的文件
  4. gradle
  - 这个目录下包含了gradle wrapper的配置文件，使用gradle wrapper的方式不需要提前将gradle下载好，而是会自动根据本地的缓存情况决定是否需要联网下载gradle。Android Studio默认就是启用gradle wrapper方式的，如果需要更改成离线模式，可以点击Android Studio导航栏->File->Settings->Build,Execution,Deployment->Gradle，进行配置更改。
  5. .gitignore
  - 这个文件是用来将指定的目录或文件排除在版本控制之外的。
  6. build.gradle
  - 这是项目全局的gradle构建脚本。
  7. gradle.properties
  - 这个文件是全局的gradle配置文件。
  8. gradlew和gradlew.bat
  这两个文件是用来在命令行界面中执行gradle命令的，其中gradlew是在Linux或Mac系统中使用，gradlew.bat是在Windows系统中使用。
  9. HelloWorld.iml
  iml文件是所有IntelliJ IDEA项目都会自动生成的一个文件，用于标识这是一个IntelliJ IDEA项目
  10. local.properties
  这个文件用于指定本机中的Android SDK路径
  11. settings.gradle
  这个文件用于指定项目中所有引入的模块。
  
  - 打开HelloWorld项目中的Android-Manifest.xml文件，从中可以找到如下代码：
  
  ```kotlin
  <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
  ```
  
  - 这段代码表示对MainActivity进行注册，没有在AndroidManifest.xml里注册的Activity是不能使用的。其中\<action android:name="android.intent.action.MAIN" />,\<category android:name="android.intent.category.LAUNCHER" />表示MainActivity是这个项目的主Activity，打开应用首先启动的是主Activity。
                
## 第六章
- 广播机制简介
- Android中的广播主要可以分为两种类型：标准广播和有序广播。
  - 标准广播(normal broadcast)是一种完全异步执行的广播，在广播发出之后，所有的BroadcastReceiver几乎会在同一时刻收到这条广播信息，因此它们之间没有任何先后顺序。
  - 有序广播(ordered broadcasts)则是一种同步执行的广播，在广播发出之后，同一时刻只会有一个BroadcastReceiver能够收到这条广播消息，当这个BroadcastReceiver中的逻辑执行完毕后，广播才会继续传递。
