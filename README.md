
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

- if条件语句

  - Kotlin中的if语句有一个额外功能，它可以有返回值，返回值就是if语句每一个条件中最后一行代码的返回值。

  ```Kotlin
  fun largerNumber(num1: Int, num2: Int): Int {
    val value = if (num1 > num2){
      num1
    }else {
      num2
    }
    return value
  }
  ```

- 更简洁的版本

  ```Kotlin
  fun largerNumber(num1: Int, num2: Int): Int {
    return if (num1 > num2) {
      num1
    } else {
      num2
    }
  }
  ```

- 更简洁的版本

```Kotlin
fun largerNumber(num1: Int, num2: Int) = if (num1 > num2) {
  num1
} else {
  num2
}
```

- 一行代码

```Kotlin
fun largerNumber(num1: Int, num2: Int) = if (num1 > num2) num1 else num2
```

- when条件语句

```Kotlin
fun getScore(name: String) = if (name == "Tom") {
  86
} else if (name == "Jim") {
  77
} else if (name == "Jack") {
  95
} else if (name == "Lily") {
  100
} else {
  0
}
```

- 用when语句的写法：

```Kotlin
fun getScore(name: String) = when(name) {
  "Tom" -> 86
  "Jim" -> 77
  "Jack" -> 95
  "Lily" -> 100
  else -> 0
}
```

- when语句还允许进行类型匹配。

```Kotlin
fun checkNumber(num: Number){
  when (num) {
    is Int -> printLn("number is Int")
    is Double -> println("number is Double")
    else -> println("number not support")
  }
}
```

- when语句不带参数的写法

```Kotlin
fun getScore(name: String) = when {
  name == "Tom" -> 86
  name == "Jim" -> 77
  name == "Jack" -> 95
  name == "Lily" -> 100
  else -> 0
}
```

- 假设所有名字以Tom开头的人，他的分数都是86分

```Kotlin
fun getScore(name: String) = when {
  name.startsWith("Tom") -> 86
  name == "Jim" -> 77
  name == "Jack" -> 95
  name == "Lily" -> 100
  else -> 0
}
```

- 要使一个类可以被继承，要在类的前面加上open关键字

```Kotlin
open class Person{

}
```

- Kotlin将构造函数分成两种：主构造函数和次构造函数。</p>
每个类默认都有一个不带参数的主构造函数，当然你也可以显式地给它指明参数。主构造函数的特点是没有函数体，直接定义在类名的后面即可。

```Kotlin
class Student(val sno: String, val grade: Int) : Person() {

}
```

- 需要实例化时

```Kotlin
val student = Student("a123", 5)
```

- Kotlin给我们提供一个init结构体，所有主构造函数中的逻辑都可以写在里面

```Kotlin
  class Student(val sno: String, val grade: Int) : Person() {
    init {
      println("sno is " + sno)
      println("grade is " + grade)
    }
  }
```

- Kotlin规定，当一个类既有主构造函数又有次构造函数时，所有的次构造函数都必须调用主构造函数（包括间接调用）。

```Kotlin
class Student(val sno: String, val grade: Int, name: String, age: Int) :
        Person(name, age) {
          constructor(name: String, age: Int) : this("", 0, name, age) {

          }

          constructor() : this("", 0) {

          }
        }
```

- 第一个次构造函数接受name和age参数，然后它又通过this关键字调用了主构造函数，并将sno和grade这两个参数赋值成初始值；第二个次构造函数不接受任何参数，它通过this关键字调用我们刚才定义的第一个次构造函数，并将name和age参数也赋值成初始值。

- 类中只有次构造函数，没有主构造函数

```Kotlin
class Student : Person {
  constructor(name: String, age: Int) : super(name, age){

  }
}
```

- 接口

```Kotlin
interface Study {
  fun readBooks()
  fun doHomework()
}
```

- 继承父类和实现接口

```Kotlin
class Student(name: String, age: Int) : Person(name, age), Study {
  override fun readBooks() {
    println(name + " is reading.")
  }

  override fun doHomework() {
    println(name + " is doing homework.")
  }
}
```

- 接口中的函数默认实现，现在当一个类去实现Study接口时，只会强制要求实现readBooks()函数，而doHomework()函数则可以自由选择实现或者不实现，不实现时就会自动使用默认的实现逻辑。

```Kotlin
interface Study{
  fun readBooks()

  fun doHomework() {
    println("do homework default implementation.")
  }
}
```

修饰符|Java|Kotlin
--|--|--
public|所有类可见|所有类可见
private|当前类可见|当前类可见
protected|当前类、子类、同一包路径下的类可见|当前类、子类可见
default|同一包路径下的类可见（默认）|无
internal|无|同一模块中的类可见

- 数据类通常需要重写equals()、hashCode()、toString()这几个方法。
- equals()方法用于判断两个数据类是否相等
- hashCode()方法作为equals()的配套方法，也需要一起重写，否则会导致HashMap、HashSet等hash相关的系统类无法正常工作。
- toString()方法用于提供更清晰的输入日志，否则一个数据类默认打印出来的就是一行内存地址。

- 假设使用Java来实现一个手机数据类

```Java
public class Cellphone
  String brand;
  double price;

  public Cellphone(String brand, double price) {
    this.brand = brand;
    this.price = price;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Cellphone) {
      Cellphone other = (Cellphone) obj;
      return other.brand.equals(brand) && other.price == price;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return brand.hashCode() + (int) price;
  }

  @Override
  public String toString() {
    return "Cellphone(brand=") + brand + ", price=" + price + ")";
  }
```

- 用Kotlin来实现同样的类，在com.example.helloworld包->New->Kotlin File/Class，在弹出的对话框中输入"Cellphone"，创建类型选择"Class"。

```Kotlin
data class Cellphone(val brand: String, val price: Double)
```

- 单类模式，用于避免创建重复的对象。

- 常见Java写法

```Java
public class Singleton {
  private static Singleton instance;

  private Singleton() {}

  public synchronized static Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }

  public void singletonTest() {
    System.out.println("singletonTest is called.");
  }
}
```

- 首先为了禁止外部创建Singleton的实例，使用private关键字将Singleton的构造函数私有化，然后给外部提供了一个getInstance()静态方法用于获取Singleton的实例。在getInstance()方法中，我们判断如果当前缓存的Singleton实例为null，就创建一个新的实例，否则直接返回缓存的实例即可。

- 调用singletonTest()方法

```Java
Singleton singleton = Singleton.getInstance();
singleton.singletonTest();
```

- 在Kotlin中创建一个单例类的方式极其简单，只需要将class关键字改成object关键字即可。

```Kotlin
object Singleton {
  fun singletonTest() {
    println("singletonTest is called.")
  }
}
```

- 调用单例类中的函数

```Kotlin
Singleton.singletonTest()
```

- ArrayList实例一般写法

```Kotlin
val list = ArrayList<String>()
list.add("Apple")
list.add("Banana")
list.add("Orange")
list.add("Pear")
list.add("Grape")
```

- listOf()函数创建的是一个不可变的集合，无法对集合进行添加、修改或删除操作。

```Kotlin
fun main() {
  val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
  for (fruit in list) {
    println(fruit)
  }
}
```

- 使用mutableListOf函数创建一个可变集合

```Kotlin
fun main() {
  val list = mutableListOf("Apple", "Banana", "Orange", "Pear", "Grape")
  list.add("Watermelon")
  for (fruit in list) {
    println(fruit)
  }
}
```

- set集合中不可以存放重复元素，与List集合用法相似
- Map是一种键值对形式的数据结构。

```Kotlin
val map = HashMap<String, Int>()
map.put("Apple", 1)
map.put("Banana", 2)
map.put("Orange", 3)
map.put("Pear", 4)
map.put("Grape", 5)
```

- 在Kotlin中更推荐的写法

```Kotlin
map["Apple"] = 1  //向Map中添加一条数据

val number = map["Apple"] //在map中读取数据
```

```Kotlin
val map = HashMap<String, Int>()
map["Apple"] = 1
map["Banana"] = 2
map["Orange"] = 3
map["Pear"] = 4
map["Grape"] = 5
```

```Kotlin
val map = mapOf("Apple" to 1, "Banana" to 2, "Orange" to 3, "Pear" to 4, "Grape" to 5)

fun main() {
  val map = mapOf("Apple" to 1, "Banana" to 2, "Orange" to 3, "Pear" to 4, "Grape" to 5)
  for ((fruit, number) in map) {
  println("fruit is " + fruit + ", number is " + number)
 }
}
```

- 集合的函数式API


- 在一个水果集合中找到单词最长的水果

```Kotlin
val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape", "Watermelon")
var maxLengthFruit = ""
for (fruit in list) {
  if (fruit.length > maxLengthFruit.length) {
  maxLengthFruit = fruit
  }
}
println("max length fruit is " + maxLengthFruit)
```

```Kotlin
val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape", "Watermelon")
val maxLengthFruit = list.maxBy { it.length }
println("max length fruit is " + maxLengthFruit)
```

- Lambda表达式的语法结构

```Kotlin
{参数名1: 参数类型, 参数名2: 参数类型 -> 函数体}
```

- 上述例子Lambda表达式的简化过程

```Kotlin
val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape", "Watermelon")
val lambda = { fruit: String -> fruit.length }
val maxLengthFruit = list.maxBy(lambda)
```

- 省略lambda变量

```Kotlin
val maxLengthFruit = list.maxBy({ fruit: String -> fruit.length })
```

- 当Lambda参数是函数的最后一个参数时，可以将Lambda表达式移到函数括号的外面

```Kotlin
val maxLengthFruit = list.maxBy() { fruit: String -> fruit.length }
```

- 当Lambda参数时函数的唯一一个参数时，可以将函数的括号省略

```Kotlin
val maxLengthFruit = list.maxBy { fruit: String -> fruit.length}
```

- 由于Kotlin拥有出色的类型推导机制，Lambda表达式中的参数列表大多数情况下不必声明参数类型

```Kotlin
val maxLengthFruit = list.maxBy { fruit -> fruit.length}
```

- 当Lambda表达式的参数列表中只有一个参数时，不必声明参数名，而是用it关键字代替

```Kotlin
val maxLengthFruit = list.maxBy{ it.length }
```


## 第六章

- 广播机制简介
- Android中的广播主要可以分为两种类型：标准广播和有序广播。
  - 标准广播(normal broadcast)是一种完全异步执行的广播，在广播发出之后，所有的BroadcastReceiver几乎会在同一时刻收到这条广播信息，因此它们之间没有任何先后顺序。
  - 有序广播(ordered broadcasts)则是一种同步执行的广播，在广播发出之后，同一时刻只会有一个BroadcastReceiver能够收到这条广播消息，当这个BroadcastReceiver中的逻辑执行完毕后，广播才会继续传递。
