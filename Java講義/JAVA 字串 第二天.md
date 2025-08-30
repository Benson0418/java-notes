# Java基礎教學講義 - API與字串處理 (Java 21)

## 15 API

API (Application Programming Interface)：應用程式設計介面

簡單理解：API就是別人已經寫好的功能，我們不需要自己編寫，可以直接使用。

Java API：指的就是JDK中提供的各種功能的Java類別

這些類別將底層的實作封裝起來，我們不需要關心這些類別是如何實作的，只需要學習如何使用即可。

## 16 字串

1. String是Java預先定義好的一個類別，定義在java.lang套件中，因此使用時不需要匯入套件。

2. Java程式中的所有字串文字（例如"abcdefgfg"）都被視為此類別的物件。

3. 字串不可變，它們的值在建立後不能被更改。

### 16.1 建立字串的方式

**語法格式：**

賦值：

```java
String name = "abc";
```

使用new：

| 建構方式                       | 說明                                   |
| ------------------------------ | -------------------------------------- |
| public String()                | 建立空白字串                           |
| public String(String original) | 根據傳入的字串，建立一個新的字串物件   |
| public String(char[] chs)      | 根據字元陣列，建立字串物件             |
| public String(byte[] chs)      | 根據byte陣列，建立字串物件             |

**範例：**

```java
public class Main{
    public static void main(String[] args) {
        // 1. 建立空字串
        String s1 = new String();
        System.out.println(s1);

        // 2. 根據字串建立新字串
        String s2 = new String("Hello");
        System.out.println(s2);

        // 3. 用字元陣列建立字串
        char[] chars = {'J', 'a', 'v', 'a'};
        String s3 = new String(chars);
        System.out.println(s3); 

        // 4. 用byte陣列建立字串
        byte[] bytes = {65, 66, 67, 68};
        String s4 = new String(bytes);
        System.out.println(s4);  // 輸出：ABCD
    }
}
```

**注意：**

當使用雙引號直接賦值時，系統會檢查該字串在字串池中是否存在：
- 不存在：建立新的
- 存在：重複使用

### 16.2 字串的比較方式

在Java中，`==` 比較的是物件參照（記憶體位置），而不是字串內容。

```java
public class Main{
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2); // true, 兩者指向字串池中相同的物件

        String s3 = new String("abc");
        String s4 = new String("abc");
        System.out.println(s3 == s4); // false, 堆積記憶體中不同的物件
    }
}
```

**正確的字串比較方式：**

- boolean equals方法(要比較的字串)
- boolean equalsIgnoreCase(要比較的字串，忽略大小寫) 

```java
public class Main{
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "hello";
        
        boolean result1 = s1.equals(s2);
        System.out.println(result1); // false
        
        boolean result2 = s1.equalsIgnoreCase(s2);
        System.out.println(result2); // true
    }
}
```

### 16.3 遍歷字串

**語法：**

- public char charAt(int index)：根據索引傳回字元
- public int length()：傳回此字串的長度

```java
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            System.out.println(ch);
        }
    }
}
```

**注意：**

- 陣列的長度：陣列名稱.length 屬性，不加括號
- 字串的長度：字串物件.length() 方法，要加括號

### 16.4 字串擷取

**語法：**

- String substring(int beginIndex, int endIndex)：子字串包含起始位置，不含結束位置
- String substring(int beginIndex)：擷取至字串末尾

```java
public class Main{
    public static void main(String[] args) {
        String str = "Hello, World!";
        String str1 = str.substring(7, 12); // 擷取 "World"
        String str2 = str.substring(7); // 擷取 "World!"
        
        System.out.println(str1);
        System.out.println(str2);
    }
}
```

### 16.5 StringBuilder

StringBuilder可以看成是一個容器，建立之後裡面的內容是可變的，用來**提高字串的操作效率**。

**語法：**

| 方法名稱                         | 說明                                   |
| -------------------------------- | -------------------------------------- |
| public StringBuilder()           | 建立一個空白字串物件，不包含任何內容   |
| public StringBuilder(String Str) | 根據字串的內容，建立可變字串物件       |

```java
public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println(sb); 
    }
}
```

#### 16.5.1 StringBuilder常用方法

| 方法名稱                               | 說明                                                     |
| -------------------------------------- | -------------------------------------------------------- |
| public StringBuilder append(任意型別)  | 新增資料，並傳回StringBuilder容器本身（因此可以鏈式呼叫）|
| public StringBuilder reverse()         | 反轉容器內容，同樣傳回自身                               |
| public int length()                    | 傳回長度（字元出現個數）                                 |
| public String toString()               | 將StringBuilder轉換為String                              |

```java
public class Main {
    public static void main(String[] args) {
        // 建立 StringBuilder
        StringBuilder sb = new StringBuilder("Hello");

        // append 修改原物件並傳回自身
        sb.append(" World");
        System.out.println(sb); // Hello World

        // reverse 修改原物件並傳回自身
        sb.reverse().reverse(); // 連續兩次反轉回原本順序
        System.out.println(sb); // Hello World

        // length 傳回字元個數
        int len = sb.length();
        System.out.println("長度: " + len); // 長度: 11

        // toString 傳回 String 物件
        String str = sb.toString();
        System.out.println(str); // Hello World

        sb.reverse();
        System.out.println(sb); // dlroW olleH
    }
}
```

### 16.6 StringJoiner (JDK8以上)

- StringJoiner跟StringBuilder一樣，也可以看做是一個容器，建立之後裡面的內容是可變的
- 作用：提高字串的操作效率，使程式碼簡潔

**建構方法：**

| 方法名稱                                           | 說明                                                   |
| -------------------------------------------------- | ------------------------------------------------------ |
| public StringJoiner(間隔符號)                      | 建立一個StringJoiner物件，指定拼接時的間隔符號         |
| public StringJoiner(間隔符號, 開始符號, 結束符號)  | 建立一個StringJoiner，指定間隔符號、開始符號、結束符號 |

**成員方法：**

| 方法名稱                          | 說明                          |
| --------------------------------- | ----------------------------- |
| public StringJoiner add(新增內容) | 新增資料，傳回StringJoiner本身|
| public int length()               | 傳回長度（字元出現個數）      |
| public String toString()          | 傳回字串                      |

```java
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("程式語言: ");
        
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        sj.add("Java");
        sj.add("Python");
        sj.add("C++");
        System.out.println(sj.length()); // 輸出: 19 (包含分隔符和括號)

        System.out.println(sj); // 輸出: [Java, Python, C++]
        
        // 將 StringJoiner 的結果 append 到 StringBuilder
        sb.append(sj);
        System.out.println(sb); // 程式語言: [Java, Python, C++]
    }
}
```

**補充: 字串join用法 (JDK8)**

```java
public class Main {
    public static void main(String[] args) {
        // 使用 String.join() 將多個字串連接起來
        String result = String.join(", ", "Java", "Python", "C++");
        System.out.println(result); // 輸出: Java, Python, C++
        
        // 使用 List 和 String.join()
        List<String> languages = Arrays.asList("Go", "Rust", "Kotlin");
        String result2 = String.join(" | ", languages);
        System.out.println(result2); // 輸出: Go | Rust | Kotlin
    }
}
```

### 16.7 StringBuilder原理

- 預設建立一個長度為16的字元陣列
- 新增內容長度小於16直接存入
- 新增內容長度大於16會擴容（原來容量*2+2）
- 如果擴容長度還不夠，以實際長度為主

```java
public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        // 容量 (capacity)：StringBuilder 可以不重新分配的最大字元數
        // 長度 (length)：已經存入的字元數
        System.out.println(sb.capacity()); // 預設 16
        System.out.println(sb.length());   // 初始為 0

        sb.append("abcdefghijk1mnopqrstuvwxyz9123456789");

        System.out.println(sb.capacity()); // 自動擴容，新容量 34 或 36（取決於實作）
        System.out.println(sb.length());   // 已存入字元數: 36
    }
}
```

## 補充 字串處理應用實例

### 字串統計分析

```java
public class Main {
    public static void main(String[] args) {
        String text = "Hello Java Programming";
        
        // 統計字元個數
        System.out.println("字串長度: " + text.length());
        
        // 統計大寫字母個數
        int upperCount = 0;
        int lowerCount = 0;
        int digitCount = 0;
        
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isUpperCase(ch)) {
                upperCount++;
            } else if (Character.isLowerCase(ch)) {
                lowerCount++;
            } else if (Character.isDigit(ch)) {
                digitCount++;
            }
        }
        
        System.out.println("大寫字母個數: " + upperCount);
        System.out.println("小寫字母個數: " + lowerCount);
        System.out.println("數字個數: " + digitCount);
    }
}
```

### 字串轉換和處理

```java
public class Main {
    public static void main(String[] args) {
        String original = "  Hello World  ";
        
        // 移除前後空白
        String trimmed = original.trim();
        System.out.println("移除空白: '" + trimmed + "'");
        
        // 轉換大小寫
        System.out.println("轉大寫: " + trimmed.toUpperCase());
        System.out.println("轉小寫: " + trimmed.toLowerCase());
        
        // 字串替換
        String replaced = trimmed.replace("World", "Java");
        System.out.println("替換後: " + replaced);
        
        // 檢查字串開始和結束
        System.out.println("是否以Hello開始: " + trimmed.startsWith("Hello"));
        System.out.println("是否以World結束: " + trimmed.endsWith("World"));
        
        // 查找子字串位置
        int index = trimmed.indexOf("World");
        System.out.println("World的位置: " + index);
    }
}
```

### 字串分割和組合

```java
public class Main {
    public static void main(String[] args) {
        // 字串分割
        String fruits = "蘋果,香蕉,橘子,葡萄";
        String[] fruitArray = fruits.split(",");
        
        System.out.println("水果清單:");
        for (int i = 0; i < fruitArray.length; i++) {
            System.out.println((i + 1) + ". " + fruitArray[i]);
        }
        
        // 使用StringBuilder組合字串
        StringBuilder sb = new StringBuilder();
        sb.append("我喜歡吃: ");
        for (int i = 0; i < fruitArray.length; i++) {
            sb.append(fruitArray[i]);
            if (i < fruitArray.length - 1) {
                sb.append("、");
            }
        }
        System.out.println(sb.toString());
        
        // 使用StringJoiner組合字串
        StringJoiner joiner = new StringJoiner(" -> ", "路徑: ", " (結束)");
        joiner.add("首頁");
        joiner.add("產品");
        joiner.add("詳情");
        System.out.println(joiner.toString());
    }
}
```

### 密碼強度檢驗器

```java
public class Main {
    public static void main(String[] args) {
        String[] passwords = {
            "123456",
            "password",
            "Password123",
            "MyStr0ng@P@ssw0rd"
        };
        
        for (String pwd : passwords) {
            int strength = checkPasswordStrength(pwd);
            System.out.println("密碼: " + pwd + " -> 強度: " + getStrengthText(strength));
        }
    }
    
    /**
     * 檢查密碼強度
     * @param password 要檢查的密碼
     * @return 強度等級 (0-4)
     */
    public static int checkPasswordStrength(String password) {
        int score = 0;
        
        // 長度檢查
        if (password.length() >= 8) {
            score++;
        }
        
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isLowerCase(ch)) {
                hasLower = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else {
                hasSpecial = true;
            }
        }
        
        if (hasUpper) score++;
        if (hasLower) score++;
        if (hasDigit) score++;
        if (hasSpecial) score++;
        
        return score;
    }
    
    /**
     * 取得強度描述
     */
    public static String getStrengthText(int strength) {
        switch (strength) {
            case 0, 1 -> { return "極弱"; }
            case 2 -> { return "弱"; }
            case 3 -> { return "中等"; }
            case 4 -> { return "強"; }
            case 5 -> { return "極強"; }
            default -> { return "未知"; }
        }
    }
}
```

### 文字格式化工具

```java
public class Main {
    public static void main(String[] args) {
        String text = "java programming is fun";
        
        // 標題格式化
        System.out.println("標題格式: " + toTitleCase(text));
        
        // 反轉單字
        System.out.println("反轉單字: " + reverseWords(text));
        
        // 移除重複字元
        System.out.println("移除重複字元: " + removeDuplicates("programming"));
        
        // 字串居中對齊
        System.out.println("居中對齊:");
        System.out.println(centerAlign("Java", 20, '*'));
        System.out.println(centerAlign("Programming", 20, '-'));
    }
    
    /**
     * 轉換為標題格式（每個單字首字母大寫）
     */
    public static String toTitleCase(String text) {
        String[] words = text.split(" ");
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() > 0) {
                String titleWord = Character.toUpperCase(word.charAt(0)) + 
                                 word.substring(1).toLowerCase();
                result.append(titleWord);
                if (i < words.length - 1) {
                    result.append(" ");
                }
            }
        }
        
        return result.toString();
    }
    
    /**
     * 反轉每個單字
     */
    public static String reverseWords(String text) {
        String[] words = text.split(" ");
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            StringBuilder reversedWord = new StringBuilder(words[i]);
            reversedWord.reverse();
            result.append(reversedWord);
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }
    
    /**
     * 移除重複字元
     */
    public static String removeDuplicates(String text) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            boolean isDuplicate = false;
            
            // 檢查是否已存在於result中
            for (int j = 0; j < result.length(); j++) {
                if (result.charAt(j) == ch) {
                    isDuplicate = true;
                    break;
                }
            }
            
            if (!isDuplicate) {
                result.append(ch);
            }
        }
        
        return result.toString();
    }
    
    /**
     * 字串居中對齊
     */
    public static String centerAlign(String text, int width, char fillChar) {
        if (text.length() >= width) {
            return text;
        }
        
        int totalPadding = width - text.length();
        int leftPadding = totalPadding / 2;
        int rightPadding = totalPadding - leftPadding;
        
        StringBuilder result = new StringBuilder();
        
        // 左邊填充
        for (int i = 0; i < leftPadding; i++) {
            result.append(fillChar);
        }
        
        // 原始文字
        result.append(text);
        
        // 右邊填充
        for (int i = 0; i < rightPadding; i++) {
            result.append(fillChar);
        }
        
        return result.toString();
    }
}
```

## 總結

本章節介紹了Java中字串處理的核心概念：

### 重點回顧

1. **String類別特性**：
   - 字串不可變性
   - 字串池機制
   - 正確的比較方式

2. **StringBuilder**：
   - 可變字串容器
   - 提高操作效率
   - 鏈式呼叫特性

3. **StringJoiner**：
   - 便於字串拼接
   - 支援分隔符號和包圍符號

4. **常用字串操作**：
   - 長度、擷取、分割
   - 大小寫轉換
   - 查找和替換

### 學習建議

- **理解不可變性**：掌握String不可變的特性，理解為什麼需要StringBuilder
- **選擇適當工具**：根據需求選擇String、StringBuilder或StringJoiner
- **熟悉常用方法**：多練習字串處理的各種方法
- **注意效能**：在需要頻繁操作字串時，選擇適當的工具

字串處理是程式設計的基礎技能，熟練掌握這些概念對於後續學習非常重要。