## 表达式语言 EL （Expression Language）

作者：彣彧 wenyu7980@163.com

> **注意**
>
> 该库所有数字类型都是BigDecimal

### 语法

> 操作数  操作符 操作数 ；

### 支持的功能

+ 四则运算
+ 比较运算
+ 逻辑运算
+ 三元运算
+ 获取上下文中的属性值
+ 执行上下文中的方法

#### 四则运算

| 运算符 | 运算符意义 | 示例                                                |
| ------ | ---------- | --------------------------------------------------- |
| +      | 加         | ExpressionLanguages.parse(“1+1;”,BigDecimal.class); |
| -      | 减         | ExpressionLanguages.parse(“1-1;”,BigDecimal.class); |
| *      | 乘         | ExpressionLanguages.parse(“1*1;”,BigDecimal.class); |
| /      | 除         | ExpressionLanguages.parse(“1/1;”,BigDecimal.class); |



#### 比较运算

| 运算符 | 运算符意义 | 示例                                              |
| ------ | ---------- | ------------------------------------------------- |
| <      | 小于       | ExpressionLanguages.parse(“1<1;”,Boolean.class);  |
| <=     | 小于等于   | ExpressionLanguages.parse(“1<=1;”,Boolean.class); |
| >      | 大于       | ExpressionLanguages.parse(“1>0;”,Boolean.class);  |
| >=     | 大于等于   | ExpressionLanguages.parse(“1>=1;”,Boolean.class); |
| <>     | 不等于     | ExpressionLanguages.parse(“1<>0;”,Boolean.class); |
| ==     | 等于       | ExpressionLanguages.parse(“1==0;”,Boolean.class); |

#### 逻辑运算

| 运算符 | 运算符意义 | 示例                                                        |
| ------ | ---------- | ----------------------------------------------------------- |
| &&     | 与         | ExpressionLanguages.parse(“1==0 && 1==0;”,Boolean.class);   |
| \|\|   | 或         | ExpressionLanguages.parse(“1==0 \|\| 1==0;”,Boolean.class); |
| ！     | 非         | ExpressionLanguages.parse(“!1==0”,Boolean.class);           |

#### 三元运算

> logic? left : right

**例**

```java
ExpressionLanguages.parse(“1==0?2:3”,BigDecimal.class);
```



#### 获取上下文中的属性值

> 需要设定上下文

**例**

```java
public class Data {
    private String text;
}

ExpressionLanguages.parse("$.text;",new ElContext().addContext("$",new Data()),String.class);
```



#### 执行上下文中的方法

> 需要设定上下文

**例**

```java
public class Data {
    public String f(){
        return "text";
    }
}

ExpressionLanguages.parse("$.f();",new ElContext().addContext("$",new Data()),String.class);
```

### 运算符优先级

优先级由高到低

| 运算符          |
| --------------- |
| .               |
| */              |
| +-              |
| > >= < <= <> == |
| &&              |
| \|\|            |
| !               |
| ?:              |



