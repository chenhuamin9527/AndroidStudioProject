
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
  - 这两个文件是用来在命令行界面中执行gradle命令的，其中gradlew是在Linux或Mac系统中使用，gradlew.bat是在Windows系统中使用。

9. HelloWorld.iml
  - iml文件是所有IntelliJ IDEA项目都会自动生成的一个文件，用于标识这是一个IntelliJ IDEA项目

10. local.properties

- 这个文件用于指定本机中的Android SDK路径

11. settings.gradle

- 这个文件用于指定项目中所有引入的模块。
  
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

- 在代码中通过R.string.app_name可以获得该字符串的引用

- 在XML中通过@string/app_name可以获得该字符串的引用

- 使用Android的日志工具Log

  - Log.v()，用于打印最为琐碎的信息，对应级别verbose。

  - Log.d()，用于打印一些调试信息，对应级别debug。

  - Log.i()，用于打印一些比较重要的数据，可以帮助分析用户行为的数据，对应级别info。

  - Log.w()，用于打印一些警告信息，提示程序可能会有潜在的风险，对应级别warn。

  - Log.e()，用于打印程序的错误信息，对应级别error。

  - Log.d()方法中传入两个参数，第一个参数是tag，一般传入当前类名。第二个参数是msg，即想要打印的具体内容。

## 第二章

- 变量

  - val(value)用来声明一个不可变的变量，这种变量在初始赋值之后就再也不能重新赋值。

  - var(variable)用来声明一个可变的变量，这种变量在初始赋值之后仍然可以再被重新赋值。

Java    |kotlin |数据类型说明
--      |--     |---      |
int     |Int    |整型
long    |Long   |长整型
short   |Short  |短整型
float   |Float  |单精度浮点型
double  |Double |双精度浮点型
boolean |Boolean|布尔型
char    |Char   |字符型
byte    |Byte   |字节型

- 函数

```kotlin
fun methodName(param1: Int, param2: Int): Int{
  return 0;
}
```

- fun是定义函数的关键字，括号内表示函数参数，参数的声明格式是“参数名: 参数类”，括号后的“: Int”是代表函数返回一个Int类型的数据。


## 第六章

- 广播机制简介
- Android中的广播主要可以分为两种类型：标准广播和有序广播。
  - 标准广播(normal broadcast)是一种完全异步执行的广播，在广播发出之后，所有的BroadcastReceiver几乎会在同一时刻收到这条广播信息，因此它们之间没有任何先后顺序。
  - 有序广播(ordered broadcasts)则是一种同步执行的广播，在广播发出之后，同一时刻只会有一个BroadcastReceiver能够收到这条广播消息，当这个BroadcastReceiver中的逻辑执行完毕后，广播才会继续传递。
