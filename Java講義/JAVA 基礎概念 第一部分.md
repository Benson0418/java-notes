# Java基礎教學講義 (Java 21)

## 1 Java初識

### 1.1 第一個Java程式

編寫一個Java程式總共分為4個步驟：

- 建立專案
- 建立檔案
- 撰寫程式碼
- 執行程式

#### 1.1.1 第一個程式範例

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```

> 提示：Java程式必須包含在類別（class）中，並且檔名必須與公開類別名稱相同。

### 1.2 註解

**作用**：在程式碼中加入一些說明和解釋，方便自己或其他程式設計師閱讀程式碼

**兩種格式**：

1. **單行註解**：`// 描述資訊`
   - 通常放在一行程式碼的上方，或者一條敘述的末尾，==對該行程式碼說明==

2. **多行註解**：`/* 描述資訊 */`
   - 通常放在一段程式碼的上方，==對該段程式碼做整體說明==

**範例：**

```java
public class Main {
    public static void main(String[] args) {
        // 這是單行註解
        System.out.println("Hello World");
        
        /*
         這是多行註解
         可以寫很多行說明
         */
    }
}
```

> 提示：編譯器在編譯程式碼時，會忽略註解的內容

### 1.3 變數

**作用**：給一段指定的記憶體空間命名，方便操作這段記憶體

**語法**：`資料型別 變數名稱 = 初始值;`

**範例：**

```java
public class Main {
    public static void main(String[] args) {
        // 變數的定義
        // 語法：資料型別 變數名稱 = 初始值
        
        int a = 10;
        System.out.println("a = " + a);
        
        // 變數使用範例
        int cnt = 0;
        cnt = cnt + 1;
        cnt = cnt - 2 + 1;
        cnt = cnt - 1;
        cnt = cnt + 21;
        System.out.println("cnt = " + cnt);
    }
}
```

> 注意：Java在建立變數時，建議給變數一個初始值

### 1.4 Java關鍵字

**作用**：關鍵字是Java中預先保留的單詞（識別符號）

- **在定義變數或者常數時候，不要用關鍵字**

Java關鍵字如下：

| abstract | continue | for        | new       | switch       |
| -------- | -------- | ---------- | --------- | ------------ |
| assert   | default  | goto       | package   | synchronized |
| boolean  | do       | if         | private   | this         |
| break    | double   | implements | protected | throw        |
| byte     | else     | import     | public    | throws       |
| case     | enum     | instanceof | return    | transient    |
| catch    | extends  | int        | short     | try          |
| char     | final    | interface  | static    | void         |
| class    | finally  | long       | strictfp  | volatile     |
| const    | float    | native     | super     | while        |

### 1.5 Java字面值/特殊字元

| 字面值類型 | 說明                               | 舉例                          |
| ---------- | ---------------------------------- | ----------------------------- |
| 整數類型   | 不帶小數點的數字                   | 666, -88                      |
| 小數類型   | 帶小數點的數字                     | 13.14, -5.21                  |
| 字串類型   | 用雙引號括起來的內容               | "Hello World", "Java程式設計" |
| 字元類型   | 用單引號括起來，內容只能有一個字元 | 'A', 'O', '我'                |
| 布林類型   | 布林值，表示真假                   | 只有兩個值：true, false       |
| 空類型     | 一個特殊的值，空值                 | 值是：null                    |

**特殊字元**：`\t` `\r` `\n` 等跳脫字元

### 1.6 識別符號命名規則

**作用**：Java規定給識別符號（變數、常數）命名時，有一套自己的規則

- 識別符號不能是關鍵字
- 識別符號只能由字母、數字、底線組成
- 第一個字元必須為字母或底線
- 識別符號中字母區分大小寫

> 建議：給識別符號命名時，爭取做到見名知意的效果，方便自己和他人的閱讀

## 2 資料型別

Java規定在建立一個變數或者常數時，必須要指定出相應的資料型別，否則無法給變數分配記憶體

### 2.1 基本資料型別

Java中能夠表示各種資料的型別有以下幾種方式，**區別在於所占記憶體空間不同**：

| 資料型別 | 關鍵字           | 取值範圍                                         | 記憶體占用 |
| -------- | ---------------- | ------------------------------------------------ | ---------- |
| 整數     | byte             | -128~127                                         | 1位元組    |
|          | short            | -32768~32767                                     | 2位元組    |
|          | int(預設型別)    | -2147483648~2147483647(10位數)                   | 4位元組    |
|          | long (L)         | -9223372036854775808~9223372036854775807(19位數) | 8位元組    |
| 浮點數   | float (F)        | -3.401298e-38 到 3.402823e+38                    | 4位元組    |
|          | double(預設型別) | -4.9000000e-324 到 1.797693e+308                 | 8位元組    |
| 字元     | char             | 0~65535                                          | 2位元組    |
| 布林     | boolean          | true, false                                      | 1位元組    |

#### 2.1.1 整數型別範例

```java
public class Main {
    public static void main(String[] args) {
        // byte
        byte b = 10;
        System.out.println(b); // 10
        
        // short
        short s = 20;
        System.out.println(s); // 20
        
        // int
        int i = 30;
        System.out.println(i); // 30
        
        /*
         * long
         * 如果要定義long類型的變數
         * 在數據值的後面需要加一個L作為後綴
         * L可以是大寫，也可以是小寫的，建議使用大寫
         */
        long n = 9999999999L;
        System.out.println(n);
    }
}
```

#### 2.1.2 各種資料型別範例

```java
public class Main {
    public static void main(String[] args) {
        String name = "小明";
        int age = 18;
        char gender = 'M';
        double height = 180.1;
        boolean flag = true;

        System.out.println("姓名: " + name);
        System.out.println("年齡: " + age);
        System.out.println("性別: " + gender);
        System.out.println("身高: " + height);
        System.out.println("標記: " + flag);
    }
}
```

### 2.2 字串型別

**作用**：用於表示一串字元

Java中字串使用 `String` 類別：

**語法**：`String 變數名稱 = "字串值";`

**範例：**

```java
public class Main {
    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println(str);
    }
}
```

## 3 資料的輸入

**作用**：用於從鍵盤取得資料

**關鍵字**：Scanner

**語法**：需要先匯入 `java.util.Scanner` 套件

### 3.1 基本輸入範例

```java
// 1. 匯入套件
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 2. 建立物件
        Scanner sc = new Scanner(System.in);
        
        // 3. 接收資料
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();
        
        // 4. 印出結果
        System.out.println(number1 + number2);
    }
}
```

### 3.2 各種資料型別輸入

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.next();        // 讀取一個單詞 (相當於C++ 的cin)
        int age = sc.nextInt();         // 讀取整數 (同cin)
        double height = sc.nextDouble(); // 讀取浮點數 (同cin)

        sc.nextLine(); // 消耗掉換行字元 (同getline(cin, line);)

        String line = sc.nextLine(); // 正確讀取整行 (同getline(cin, line);)

        System.out.println("姓名: " + name);
        System.out.println("年齡: " + age);
        System.out.println("身高: " + height);
        System.out.println("整行內容: " + line);
    }
}
```

### 3.3 高效能輸入/輸出 (進階)

```java
// Java高效能IO
// 有關Java FastIO的處理，會另開一篇筆記記錄
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 建立 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 建立 PrintWriter（高效輸出）
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        // 讀取單詞（原 Scanner 的 next()）
        StringTokenizer st = new StringTokenizer(br.readLine());
        String name = st.nextToken();

        // 讀取整數（原 Scanner 的 nextInt()）
        int age = Integer.parseInt(st.nextToken());

        // 讀取浮點數（原 Scanner 的 nextDouble()）
        double height = Double.parseDouble(st.nextToken());

        // 讀整行字串（原 Scanner 的 nextLine()）
        String line = br.readLine(); // 已經自動讀到下一行，不需要額外消耗換行字元

        // 輸出
        out.println("姓名: " + name);
        out.println("年齡: " + age);
        out.println("身高: " + height);
        out.println("整行內容: " + line);

        // 刷新輸出
        out.flush();
    }
}
```

## 4 運算符

**作用**：用於執行程式碼的運算

本章我們主要講解以下幾類運算符：

| 運算符類型 | 作用                               |
| ---------- | ---------------------------------- |
| 算術運算符 | 用於處理四則運算                   |
| 賦值運算符 | 用於將運算式的值指派給變數         |
| 比較運算符 | 用於運算式的比較，並傳回真值或假值 |
| 邏輯運算符 | 用於根據運算式的值傳回真值或假值   |

### 4.1 算術運算符

**作用**：用於處理四則運算

算術運算符包括以下符號：

| 運算符 | 術語     | 範例        | 結果      |
| ------ | -------- | ----------- | --------- |
| +      | 正號     | +3          | 3         |
| -      | 負號     | -3          | -3        |
| +      | 加       | 10 + 5      | 15        |
| -      | 減       | 10 - 5      | 5         |
| *      | 乘       | 10 * 5      | 50        |
| /      | 除       | 10 / 5      | 2         |
| %      | 取模     | 10 % 3      | 1         |
| ++     | 前置遞增 | a=2; b=++a; | a=3; b=3; |
| ++     | 後置遞增 | a=2; b=a++; | a=3; b=2; |
| --     | 前置遞減 | a=2; b=--a; | a=1; b=1; |
| --     | 後置遞減 | a=2; b=a--; | a=1; b=2; |

**範例：**

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int a = number % 10;      // 取個位數
        int b = number / 10 % 10; // 取十位數
        int c = number / 100 % 10;// 取百位數
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
```

#### 4.1.1 型別轉換

數字進行運算時，資料型別不一樣不能運算，需要轉成一樣的，才能運算。

**隱式轉換（自動型別提升）：**

- 把一個取值範圍小的數值，轉成取值範圍大的資料

  ```java
  int a = 10;
  double b = a;
  ```

- 取值範圍小的，和取值範圍大的進行運算，小的會先提升為大的，再進行運算

- byte short char 三種型別的資料在運算的時候，都會直接先提升為int，然後再進行運算

**強制轉換：**

如果把一個取值範圍大的數值，賦值給取值範圍小的變數，是不允許直接賦值的。如果一定要這麼做就需要加入強制轉換

格式：`目標資料型別 變數名稱 = (目標資料型別)被強轉的資料;`

```java
int a = 300;
byte b = (byte) a;
```

**範例：**

```java
public class Main {
    public static void main(String[] args) {
        byte s1 = 100; 
        byte s2 = 100;
        // 語意與 (byte)s1 + s2 不同
        byte res = (byte)(s1 + s2); // 由於溢位，輸出結果為-56
        System.out.println(res); 
    }
}
```

#### 4.1.2 字串的"+"操作

- 當"+"操作中出現字串時，這個"+"是字串連接符，而不是算術運算符了。會將前後的資料進行拼接，並產生一個新的字串。
- 連續進行"+"操作時，從左到右逐個執行。
- 當（字元+字元/字元+數字）時，會把字元通過ASCII碼表查詢到對應的數字再進行計算。

**範例：**

```java
System.out.println(1 + 'a');      // 98
System.out.println('a' + "abc");  // 輸出字串 "aabc"
```

#### 4.1.3 遞增遞減運算符

**基本用法：**

| 符號 | 作用 | 說明        |
| ---- | ---- | ----------- |
| ++   | 加   | 變數的值加1 |
| --   | 減   | 變數的值減1 |

++和--無論是放在變數的前面還是後面，單獨寫一行結果是一樣的。

**前置和後置的區別：**

```java
int a = 10;
int b = a++;  // 先用後加
int a = 10;
int b = ++a;  // 先加後用
```

**範例：**

```java
public class Main {
    public static void main(String[] args) {
        int x = 10;
        // 先把x變數賦值給y，然後再遞增
        int y = x++;
        // x先遞增，然後再賦值給z
        int z = ++x;
        System.out.println("x: " + x); // 12
        System.out.println("y: " + y); // 10
        System.out.println("z: " + z); // 12
    }
}
```

### 4.2 賦值運算符

**作用**：用於將運算式的值指派給變數

**注意：**賦值運算符隱含強制型別轉換

賦值運算符包括以下幾個符號：

| 運算符 | 作用       | 範例        |
| ------ | ---------- | ----------- |
| =      | 賦值       | int a = 10; |
| +=     | 加後賦值   | a += b;     |
| -=     | 減後賦值   | a -= b;     |
| *=     | 乘後賦值   | a *= b;     |
| /=     | 除後賦值   | a /= b;     |
| %=     | 取餘後賦值 | a %= b;     |

### 4.3 比較運算符

**作用**：用於運算式的比較，並傳回boolean型別

**注意：**不要把"=="誤寫成"="

比較運算符有以下符號：

| 運算符 | 術語     | 範例   | 結果  |
| ------ | -------- | ------ | ----- |
| ==     | 相等於   | 4 == 3 | false |
| !=     | 不等於   | 4 != 3 | true  |
| <      | 小於     | 4 < 3  | false |
| >      | 大於     | 4 > 3  | true  |
| <=     | 小於等於 | 4 <= 3 | false |
| >=     | 大於等於 | 4 >= 1 | true  |

**範例：**

```java
import java.util.Scanner;

public class Main {
    /*
     * 輸入兩個數字，判斷 a 是否大於 b
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(a > b);
    }
}
```

### 4.4 邏輯運算符

**作用**：用於根據運算式的值傳回真值或假值

**注意：**邏輯運算符有短路效果

邏輯運算符有以下符號：

| 運算符 | 術語 | 範例     | 結果                                                         |
| ------ | ---- | -------- | ------------------------------------------------------------ |
| !      | 非   | !a       | 如果a為假，則!a為真；如果a為真，則!a為假。                   |
| &&     | 且   | a && b   | 如果a和b都為真，則結果為真，否則為假。<br />左邊為false，右邊不管是真是假，整個運算式結果一定是false |
| \|\|   | 或   | a \|\| b | 如果a和b有一個為真，則結果為真，二者都為假時，結果為假。<br />左邊為true，右邊不管是真是假，整個運算式結果一定是true |

> 總結：
>
> - 邏輯**且**運算符總結：==同真為真，其餘為假==
> - 邏輯**或**運算符總結：==同假為假，其餘為真==

### 4.5 位元運算符

**作用**：對數位的二進位形式進行位元運算

| 符號 | 作用       | 說明                         |
| ---- | ---------- | ---------------------------- |
| &    | 邏輯且     | 並且，兩邊都為真，結果才是真 |
| \|   | 邏輯或     | 或者，兩邊都為假，結果才是假 |
| ^    | 邏輯互斥或 | 相同為false，不同為true      |
| ~    | 邏輯非     | 取反                         |
| <<   | 左移       | 向左移動，低位補0            |
| >>   | 右移       | 向右移動，高位補0或1         |
| >>>  | 無符號右移 | 向右移動，高位補0            |

### 4.6 三元運算符

**作用**：可以進行判斷，根據判斷的結果得到不同的內容

**格式**：`關係運算式 ? 運算式1 : 運算式2;`

**範例：**

```java
import java.util.Scanner;

public class Main {
    /*
     * 輸出較大的數
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(a > b ? a : b); 
    }
}
```

### 4.7 運算符優先級

**作用**：表示各種運算符結合的先後順序

| 優先級 | 運算符                                             |
| ------ | -------------------------------------------------- |
| 1      | . () {}                                            |
| 2      | ! - ++ --                                          |
| 3      | * / %                                              |
| 4      | + -                                                |
| 5      | << >> >>>                                          |
| 6      | < <= > >= instanceof                               |
| 7      | == !=                                              |
| 8      | &                                                  |
| 9      | ^                                                  |
| 10     | \|                                                 |
| 11     | &&                                                 |
| 12     | \|\|                                               |
| 13     | ?:                                                 |
| 14     | = += -= *= /= %= &= （包括但不限於這些賦值運算符） |

> 提示：一般來說，不需要去刻意記憶運算符優先級，對於一些複雜的運算式，建議使用小括號來明確運算順序，這樣程式碼的可讀性會更高。

## 5 分支結構

### 5.1 if敘述句

#### 5.1.1 if敘述句第一種格式

**語法格式：**

```java
if (關係表達式) {
    敘述句主體;
}
```

**執行流程：**

1. 首先計算關係表達式的值
2. 如果關係表達式的值為true就執行敘述句主體
3. 如果關係表達式的值為false就不執行敘述句主體
4. 繼續執行後面的其他敘述句

**範例：**

```java
public class Main {
    public static void main(String[] args) {
        boolean isLightGreen = true;
        boolean isLightYellow = false;
        boolean isLightRed = false;
        
        if (isLightGreen) {
            System.out.println("gogogo!");
        }
        if (isLightYellow) {
            System.out.println("Slow!");
        }
        if (isLightRed) {
            System.out.println("Stop!");
        }
    }
}
```

#### 5.1.2 if敘述句第二種格式

**語法格式：**

```java
if (關係表達式) {
    敘述句主體1;
} else {
    敘述句主體2;
}
```

**執行流程：**

1. 首先計算關係表達式的值
2. 如果關係表達式的值為true就執行敘述句主體1
3. 如果關係表達式的值為false就執行敘述句主體2
4. 繼續執行後面的其他敘述句

**範例：**

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("請輸入一個整數：");
        int num = sc.nextInt();

        if (num % 2 == 0) {
            System.out.println(num + " 是偶數");
        } else {
            System.out.println(num + " 是奇數");
        }
    }
}
```

#### 5.1.3 if敘述句第三種格式

**語法格式：**

```java
if (關係表達式1) {
    敘述句主體1;
} else if (關係表達式2) {
    敘述句主體2;
} else {
    敘述句主體n+1;
}
```

**執行流程：**

1. 首先計算關係表達式1的值
2. 如果為true就執行敘述句主體1；如果為false就計算關係表達式2的值
3. 如果為true就執行敘述句主體2；如果為false就計算關係表達式3的值
4. 依此類推...
5. 如果所有關係表達式結果都為false，就執行敘述句主體n+1

**範例：**

```java
public class Main {
    public static void main(String[] args) {
        boolean isLightGreen = false;
        boolean isLightYellow = false;
        boolean isLightRed = true;

        if (isLightGreen) {
            System.out.println("gogogo!");
        } else if (isLightYellow) {
            System.out.println("slow!");
        } else if (isLightRed) {
            System.out.println("stop!");
        }
    }
}
```

**實用範例：**

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入您的分數：");
        int score = sc.nextInt();
        
        if (score >= 90) {
            System.out.println("優秀");
        } else if (score >= 80) {
            System.out.println("良好");
        } else if (score >= 70) {
            System.out.println("中等");
        } else if (score >= 60) {
            System.out.println("及格");
        } else {
            System.out.println("不及格");
        }
    }
}
```

### 5.2 switch敘述句（較少使用）

**語法格式：**

```java
switch(表達式) {
    case 值1:
        敘述句主體1;
        break;
    case 值2:
        敘述句主體2;
        break;
    default:
        敘述句主體n+1;
        break;
}
```

**執行流程：**

1. 首先計算表達式的值
2. 依次和case後面的值進行比較，如果有對應的值，就會執行相應的敘述句，在執行的過程中，遇到break就會結束
3. 如果所有的case後面的值和表達式的值都不匹配，就會執行default裡面的敘述句主體，然後結束整個switch敘述句

**格式說明：**

- **表達式**：（將要匹配的值）取值為byte、short、int、char。JDK5以後可以是列舉，JDK7以後可以是String
- **case**：後面跟的是要和表達式進行比較的值（被匹配的值）
- **break**：表示中斷、結束的意思，用來結束switch敘述句
- **default**：表示所有情況都不匹配的時候，就執行該處的內容，和if敘述句的else相似
- case後面的值只能是字面值，不能是變數
- case給出的值不允許重複

**基本範例：**

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. 鍵盤輸入星期數
        Scanner sc = new Scanner(System.in);
        System.out.println("請輸入星期：");
        int week = sc.nextInt();

        // 2. 利用 switch 對星期進行匹配
        switch (week) {
            case 1:
                System.out.println("跑步");
                break;
            case 2:
                System.out.println("游泳");
                break;
            case 3:
                System.out.println("慢走");
                break;
            case 4:
                System.out.println("動感單車");
                break;
            case 5:
                System.out.println("拳擊");
                break;
            case 6:
                System.out.println("爬山");
                break;
            case 7:
                System.out.println("好好吃一頓");
                break;
            default:
                System.out.println("沒有這個星期");
                break;
        }
    }
}
```

#### 5.2.1 switch其他知識點

**default的位置和省略**

- **default可以省略**：如果所有case都沒有匹配上，程式不會執行任何操作
- **default位置靈活**：default不一定要放在最後，可以放在switch的任何位置，但建議放在最後

**case穿透現象**

當case沒有對應的break時，程式不會跳出switch，而是繼續向下執行，直到遇見break或者整個switch結束為止。

**範例：**

```java
public class Main {
    public static void main(String[] args) {
        int num = 1;
        switch (num) {
            case 1:
                System.out.println("一");
                // 沒有break，會繼續執行下面的case
            case 2:
                System.out.println("二");
                break;
            case 3:
                System.out.println("三");
                break;
        }
        // 輸出結果：
        // 一
        // 二
    }
}
```

**switch新特性（JDK14+）**

Java 14引入了新的switch語法，使用箭頭語法（->），不會發生case穿透：

```java
// 新版JAVA語法
public class Main {
    public static void main(String[] args) {
        int number = 10;

        switch (number) {
            case 1 -> System.out.println("一");
            case 2 -> System.out.println("二");
            case 3 -> System.out.println("三");
            default -> System.out.println("沒有這種選項");
        }
    }
}
```

**多值匹配：**

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* 需求: 鍵盤輸入星期數，輸出工作日或休息日
           (1-5) 工作日，(6-7) 休息日
        */

        // 1. 鍵盤輸入星期數
        Scanner sc = new Scanner(System.in);
        System.out.println("請輸入一個整數表示星期：");
        int week = sc.nextInt();

        // 2. 利用 switch 敘述句選擇
        switch (week) {
            case 1, 2, 3, 4, 5 -> System.out.println("工作日");
            case 6, 7 -> System.out.println("休息日");
            default -> System.out.println("沒有這個星期");
        }
    }
}
```

#### 5.2.2 switch和if第三種格式各自的使用場景

**switch適用場景：**

- 針對某個變數的值進行等值判斷
- 給出的值比較少且固定
- 值的型別限於：byte、short、int、char、String、列舉

**if適用場景：**

- 對某個變數進行區間判斷
- 對某個變數進行不等值判斷
- 對布林型別變數進行true或false的判斷

**範例對比：**

```java
// 適合用switch的情況
int grade = 'A';
switch (grade) {
    case 'A' -> System.out.println("優秀");
    case 'B' -> System.out.println("良好");
    case 'C' -> System.out.println("及格");
    default -> System.out.println("不及格");
}

// 適合用if的情況
int score = 85;
if (score >= 90) {
    System.out.println("優秀");
} else if (score >= 80) {
    System.out.println("良好");
} else if (score >= 60) {
    System.out.println("及格");
} else {
    System.out.println("不及格");
}
```

> 總結：
>
> - 當需要對固定值進行判斷時，使用switch較為簡潔
> - 當需要進行範圍判斷或複雜條件判斷時，使用if更為合適
> - 新版本的switch語法（箭頭語法）可以避免case穿透問題，程式碼更簡潔安全

## 6 迴圈結構

**作用**：用於重複執行某段程式碼，直到滿足結束條件為止

Java提供了三種迴圈結構：

- for迴圈
- while迴圈  
- do...while迴圈

### 6.1 for迴圈

**語法格式：**

```java
for (初始化敘述句; 條件判斷敘述句; 條件控制敘述句) {
    迴圈體敘述句
}
```

**執行流程：**

1. 執行初始化敘述句
2. 執行條件判斷敘述句，看其結果是true還是false
   - 如果是false，迴圈結束
   - 如果是true，執行迴圈體敘述句
3. 執行條件控制敘述句
4. 回到②繼續執行條件判斷敘述句

**重要特點：**

- 初始化敘述句只執行一次
- 判斷敘述句為true，迴圈繼續
- 判斷敘述句為false，迴圈結束

**基本範例：**

```java
public class Main {
    public static void main(String[] args) {
        // 輸出1到10的數字
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
    }
}
```

**實用範例：**

```java
public class Main {
    public static void main(String[] args) {
        // 計算1到100之間偶數的和
        int sum = 0;
        for (int i = 2; i <= 100; i += 2) {
            sum += i;
        }
        System.out.println("1到100之間偶數的和為: " + sum);
    }
}
```

### 6.2 while迴圈

**語法格式：**

```java
初始化敘述句;
while (條件判斷敘述句) {
    迴圈體敘述句;
    條件控制敘述句;
}
```

**執行流程：**

1. 執行初始化敘述句
2. 執行條件判斷敘述句，看其結果是true還是false
   - 如果是false，迴圈結束
   - 如果是true，執行迴圈體敘述句
3. 執行條件控制敘述句
4. 回到②繼續執行條件判斷敘述句

**基本範例：**

```java
public class Main {
    public static void main(String[] args) {
        // 輸出1到10的數字
        int i = 1;
        while (i <= 10) {
            System.out.println(i);
            i++;
        }
    }
}
```

**實用範例：**

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("請輸入一個正整數（輸入0結束）：");
        int num = sc.nextInt();
        
        while (num != 0) {
            System.out.println("您輸入的數字是：" + num);
            System.out.println("請再輸入一個正整數（輸入0結束）：");
            num = sc.nextInt();
        }
        
        System.out.println("程式結束");
    }
}
```

### 6.3 do...while迴圈（較少使用）

**語法格式：**

```java
初始化敘述句;
do {
    迴圈體敘述句;
    條件控制敘述句;
} while (條件判斷敘述句);
```

**執行流程：**

1. 執行初始化敘述句
2. 執行迴圈體敘述句
3. 執行條件控制敘述句
4. 執行條件判斷敘述句，看其結果是true還是false
   - 如果是false，迴圈結束
   - 如果是true，回到②繼續執行

**特點：**

- do...while迴圈會先執行迴圈體，再進行條件判斷
- 因此，迴圈體至少會執行一次

**基本範例：**

```java
public class Main {
    public static void main(String[] args) {
        // 輸出1到10的數字
        int i = 1;
        do {
            System.out.println(i);
            i++;
        } while (i <= 10);
    }
}
```

### 6.4 for和while的比較

**相同點：**

- 運行規則都是一樣的

**不同點：**

- **for迴圈中**：控制迴圈的變數，因為歸屬for迴圈的語法結構中，在for迴圈結束後，就不能再次被訪問到了

- **while迴圈中**：控制迴圈的變數，對於while迴圈來說不歸屬其語法結構中，在while迴圈結束後，該變數還可以繼續使用

**使用場景：**

- **for迴圈**：知道迴圈次數或者迴圈的範圍
- **while迴圈**：不知道迴圈的次數和範圍，只知道迴圈的結束條件

### 6.5 跳轉控制敘述句

**作用**：用於控制迴圈的執行流程

Java提供了兩個跳轉控制敘述句：

- **continue**：跳過本次迴圈的剩餘敘述句，繼續下一次迴圈
- **break**：跳出當前迴圈

#### 6.5.1 continue敘述句

**作用**：跳過本次迴圈的剩餘敘述句，繼續下一次迴圈的執行

**範例：**

```java
public class Main {
    public static void main(String[] args) {
        // 輸出1到10之間的所有數字，但跳過5
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                continue; // 跳過本次迴圈，直接進入下一次迴圈
            }
            System.out.println(i);
        }
        // 輸出結果：1 2 3 4 6 7 8 9 10
    }
}
```

#### 6.5.2 break敘述句

**作用**：跳出當前迴圈

**範例：**

```java
public class Main {
    public static void main(String[] args) {
        // 輸出1到10，但遇到5就停止
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                break; // 跳出迴圈
            }
            System.out.println(i);
        }
        // 輸出結果：1 2 3 4
    }
}
```

#### 6.5.3 巢狀迴圈中的break和continue

在巢狀迴圈中，break和continue只對最近的迴圈起作用。

**範例：**

```java
public class Main {
    public static void main(String[] args) {
        // 巢狀迴圈範例
        for (int i = 1; i <= 3; i++) {
            System.out.println("外層迴圈：" + i);
            for (int j = 1; j <= 3; j++) {
                if (j == 2) {
                    continue; // 只跳過內層迴圈的本次執行
                }
                System.out.println("  內層迴圈：" + j);
            }
        }
    }
}
```

### 6.6 迴圈綜合練習

#### 6.6.1 九九乘法表

```java
public class Main {
    public static void main(String[] args) {
        // 九九乘法表
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "×" + i + "=" + (i * j) + "\t");
            }
            System.out.println();
        }
    }
}
```

#### 6.6.2 水仙花數

```java
public class Main {
    public static void main(String[] args) {
        // 找出所有的水仙花數（三位數，各位數字立方和等於本身）
        System.out.println("水仙花數有：");
        
        for (int i = 100; i <= 999; i++) {
            int ge = i % 10;         // 個位數
            int shi = i / 10 % 10;   // 十位數
            int bai = i / 100 % 10;  // 百位數
            
            if ((ge * ge * ge) + (shi * shi * shi) + (bai * bai * bai) == i) {
                System.out.println(i);
            }
        }
    }
}
```

#### 6.6.3 統計正負數

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int positiveCount = 0; // 正數個數
        int negativeCount = 0; // 負數個數
        
        System.out.println("請輸入10個整數：");
        
        for (int i = 1; i <= 10; i++) {
            System.out.print("請輸入第" + i + "個數：");
            int num = sc.nextInt();
            
            if (num > 0) {
                positiveCount++;
            } else if (num < 0) {
                negativeCount++;
            }
            // 0既不是正數也不是負數，所以不統計
        }
        
        System.out.println("正數有：" + positiveCount + "個");
        System.out.println("負數有：" + negativeCount + "個");
    }
}
```

> 總結：
>
> - for迴圈適合已知迴圈次數的情況
> - while迴圈適合未知迴圈次數，只知道結束條件的情況  
> - do...while迴圈適合至少需要執行一次迴圈體的情況
> - continue用於跳過本次迴圈的剩餘敘述句
> - break用於完全跳出迴圈
> - 巢狀迴圈中的跳轉控制敘述句只影響最近的迴圈

---

## 結語

本講義涵蓋了Java程式設計的基礎知識，包括：

1. **Java初識** - 程式結構、註解、變數、關鍵字等基本概念
2. **資料型別** - 基本資料型別和字串型別的使用
3. **資料輸入** - Scanner的使用和高效能IO
4. **運算符** - 各種運算符的使用和優先級
5. **分支結構** - if和switch敘述句的使用
6. **迴圈結構** - for、while、do...while迴圈和跳轉控制

這些內容為進一步學習Java物件導向程式設計、陣列、方法等進階主題打下了堅實的基礎。建議讀者多練習範例程式碼，並嘗試自己編寫小程式來鞏固所學知識。

祝您Java學習順利！
