# Gentool

## 简介

## 组件

## 其他

### Idea生成JavaDoc
> 方法：【Tool】-【Generate JavaDoc...】  
> 生成过程中会报错：@date未知标签、不允许的标签<br />等，因为在jdk8以后，javadoc引入lint，要求比较严格，临时解决版本：  
> JavaDoc操作对话框-【Other command line arguments】填入: -Xdoclint:none -tag date:a:"日期" -link https://docs.oracle.com/javase/8/docs/api/  -encoding UTF-8 -charset UTF-8
