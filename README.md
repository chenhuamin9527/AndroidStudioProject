
# 《第一行代码》随书笔记

## 第一章
- Android系统架构
  1.Linux内核层
  2.系统运行库层
  3.应用框架层
  4.应用层
- Android应用开发特色
  1.四大组件：Activity、Service、BroadcastReceiver和ContentProvider。
  2.丰富的系统控件
  3.SQLite数据库
  4.强大的多媒体
- 准备所需要工具
  - JDK。JDK是Java语言的软件开发包，它包含了Java的运行环境、工具集合、基础类库等内容。
  - Android SDK。Android SDK是Google提供的Android开发工具包。
  - Android Studio。Google推出的官方IDE工具。
- 项目结构文件
  1. .gradle和.idea
  - 这两个目录下放置的都是Android Studio自动生成的文件。
  
## 第六章
- 广播机制简介
- Android中的广播主要可以分为两种类型：标准广播和有序广播。
  - 标准广播(normal broadcast)是一种完全异步执行的广播，在广播发出之后，所有的BroadcastReceiver几乎会在同一时刻收到这条广播信息，因此它们之间没有任何先后顺序。
  - 有序广播(ordered broadcasts)则是一种同步执行的广播，在广播发出之后，同一时刻只会有一个BroadcastReceiver能够收到这条广播消息，当这个BroadcastReceiver中的逻辑执行完毕后，广播才会继续传递。
