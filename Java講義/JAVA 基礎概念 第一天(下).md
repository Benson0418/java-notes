# Java基礎教學講義 第二天 (Java 21)

## 7 陣列

### 7.1 陣列的概念

**作用**：陣列是一種容器，可以一次存放多個相同型別的數值

**特點**：
- 陣列中的元素在記憶體中是連續存放的
- 陣列的長度一旦建立就固定，不能動態變更
- 陣列本身地址放在堆疊區，而其內容則在堆積區（這點與C++的局部C風格陣列不同）

**陣列容器儲存資料注意事項**：

陣列容器在儲存資料時，需要結合隱式轉換考量：

- **int型別的陣列容器**：可以儲存 boolean、byte、short、int、double
- **double型別的陣列容器**：可以儲存 byte、short、int、long、float、double

> 建議：容器的型別，與儲存的資料型別保持一致

### 7.2 陣列的初始化

**語法格式：**

```java
// 方式一：動態初始化（指定長度）
資料型別[] 陣列名稱 = new 資料型別[長度];

// 方式二：靜態初始化（指定內容）
資料型別[] 陣列名稱 = new 資料型別[]{元素1, 元素2, 元素3, ...};

// 方式三：簡化靜態初始化
資料型別[] 陣列名稱 = {元素1, 元素2, 元素3, ...};
```

> 注意：當使用動態初始化時，如型別為int[]，每個元素皆預設為0

**範例：**

```java
public class Main {
    public static void main(String[] args) {
        // 動態初始化
        int[] arr1 = new int[5];
        System.out.println("動態初始化的陣列元素：");
        for (int i = 0; i < arr1.length; i++) {
            System.out.println("arr1[" + i + "] = " + arr1[i]);
        }
        
        // 靜態初始化
        int[] arr2 = new int[]{1, 2, 3, 4, 5};
        
        // 簡化靜態初始化
        int[] arr3 = {1, 2, 3, 4, 5};
        
        System.out.println("靜態初始化的陣列元素：");
        for (int i = 0; i < arr3.length; i++) {
            System.out.println("arr3[" + i + "] = " + arr3[i]);
        }
    }
}
```

### 7.3 陣列地址與元素存取

#### 7.3.1 陣列地址值

**陣列的地址值表示陣列在記憶體中的位置**

```java
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(arr);
        // 輸出結果類似：[I@1f32e575（地址值）
    }
}
```

> 說明：[I@1f32e575 中的 [I 表示這是一個int型別的陣列，@ 後面的是十六進位的地址值

#### 7.3.2 陣列元素存取

**語法格式：**

```java
// 取得陣列元素
資料型別 變數名稱 = 陣列名稱[索引];

// 修改陣列元素
陣列名稱[索引] = 新數值;

// 取得陣列長度
int 長度 = 陣列名稱.length;
```

**範例：**

```java
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int sum = 0;
        
        // 遍歷陣列並計算總和
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
            sum += arr[i];
        }
        
        System.out.println("陣列總和: " + sum);
        System.out.println("陣列長度: " + arr.length);
        
        // 修改陣列元素
        arr[0] = 100;
        System.out.println("修改後 arr[0] = " + arr[0]);
    }
}
```

#### 7.3.3 陣列索引越界例外

**注意**：當存取了陣列中不存在的索引，就會引發索引越界例外

```java
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        
        // 正確的索引範圍：0 到 4
        System.out.println(arr[0]);  // 正確
        System.out.println(arr[4]);  // 正確
        
        // 以下會引發 ArrayIndexOutOfBoundsException
        // System.out.println(arr[5]);  // 錯誤！索引越界
        // System.out.println(arr[-1]); // 錯誤！索引越界
    }
}
```

### 7.4 陣列參考特性

**重要概念**：在Java中，陣列是參考型別，多個陣列變數可以指向同一個陣列物件

```java
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] brr = arr;  // brr 指向 arr 相同的陣列物件
        
        brr[3] = 100;     // 透過 brr 修改元素
        
        // 輸出 arr 的內容，會發現也被修改了
        for (int element : arr) {
            System.out.println(element);
        }
        // 輸出：1 2 3 100 5
    }
}
```

> 說明：由於 arr 和 brr 指向同一個陣列物件，所以透過任何一個變數修改陣列內容，都會影響到另一個變數看到的結果

### 7.5 增強型for迴圈

**作用**：簡化陣列遍歷的語法

**語法格式：**

```java
for (資料型別 變數名稱 : 陣列名稱) {
    迴圈體敘述句;
}
```

**範例：**

```java
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        
        // 傳統for迴圈
        System.out.println("傳統for迴圈：");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        
        // 增強型for迴圈
        System.out.println("增強型for迴圈：");
        for (int element : arr) {
            System.out.println(element);
        }
    }
}
```

> 注意：增強型for迴圈只能用於遍歷，無法修改陣列元素的值，也無法取得當前元素的索引

### 7.6 陣列綜合練習

#### 7.6.1 隨機打亂陣列

**需求**：將陣列中的元素順序隨機打亂

```java
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // 1. 定義陣列存儲 1~5
        int[] arr = {1, 2, 3, 4, 5};
        
        System.out.println("原始陣列：");
        printArray(arr);
        
        // 2. 建立 Random 物件
        Random r = new Random();
        
        // 3. 迴圈遍歷陣列，打亂資料順序
        for (int i = 0; i < arr.length; i++) {
            // 產生一個隨機索引
            int randomIndex = r.nextInt(arr.length);
            // 交換 arr[i] 與 arr[randomIndex]
            int temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }
        
        System.out.println("打亂後的陣列：");
        printArray(arr);
    }
    
    // 列印陣列的方法
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
```

#### 7.6.2 陣列元素查詢

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = {19, 28, 37, 46, 50};
        Scanner sc = new Scanner(System.in);
        
        System.out.print("請輸入要查詢的數字：");
        int target = sc.nextInt();
        
        int index = findElement(arr, target);
        
        if (index == -1) {
            System.out.println("未找到數字 " + target);
        } else {
            System.out.println("數字 " + target + " 在索引 " + index + " 位置");
        }
    }
    
    /**
     * 在陣列中查詢指定元素
     * @param arr 要查詢的陣列
     * @param target 要查詢的目標值
     * @return 找到返回索引，未找到返回-1
     */
    public static int findElement(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;  // 未找到
    }
}
```

## 8 方法

**Java裡面沒有函數，只有方法**

### 8.1 方法的概念

**作用**：方法是一段具有獨立功能的程式碼塊，不呼叫就不會執行

**好處**：
- 提高程式碼的複用性
- 提高程式碼的維護性
- 讓程式的邏輯更加清晰

### 8.2 方法的定義與呼叫

#### 8.2.1 無參數無回傳值的方法

**語法格式：**

```java
public static void 方法名稱() {
    方法主體（打包起來的程式碼）
}
```

**呼叫格式：**

```java
方法名稱();
```

**範例：**

```java
public class Main {
    public static void main(String[] args) {
        // 呼叫方法
        sayHello();
        sayHello();  // 可以重複呼叫
    }
    
    // 定義方法
    public static void sayHello() {
        System.out.println("Hello, World!");
        System.out.println("歡迎學習Java程式設計！");
    }
}
```

#### 8.2.2 有參數無回傳值的方法

**語法格式：**

```java
public static void 方法名稱(資料型別 變數名稱1, 資料型別 變數名稱2, ...) {
    方法主體
}
```

**呼叫格式：**

```java
方法名稱(參數值1, 參數值2, ...);
```

**範例：**

```java
public class Main {
    public static void main(String[] args) {
        // 呼叫帶參數的方法
        printSum(10, 20);
        printSum(5, 15);
    }
    
    // 定義帶參數的方法
    public static void printSum(int a, int b) {
        int sum = a + b;
        System.out.println(a + " + " + b + " = " + sum);
    }
}
```

#### 8.2.3 有參數有回傳值的方法

**語法格式：**

```java
public static 回傳值型別 方法名稱(資料型別 變數名稱1, 資料型別 變數名稱2, ...) {
    方法主體
    return 回傳值;
}
```

**呼叫格式：**

```java
資料型別 變數名稱 = 方法名稱(參數值1, 參數值2, ...);
```

**範例：**

```java
public class Main {
    public static void main(String[] args) {
        // 呼叫有回傳值的方法
        int result = add(5, 10);
        System.out.println("兩數相加的結果是: " + result);
        
        // 直接在輸出敘述句中呼叫方法
        System.out.println("15 + 25 = " + add(15, 25));
    }
    
    // 定義有回傳值的方法
    public static int add(int a, int b) {
        return a + b;
    }
}
```

#### 8.2.4 方法呼叫的執行流程

**範例：**

```java
public class Main {
    // 輸出結果：a d e c b 
    public static void main(String[] args) {
        System.out.print("a ");
        method1();
        System.out.print("b ");
    }
    
    public static void method1() {
        method2();
        System.out.print("c ");
    }
    
    public static void method2() {
        System.out.print("d ");
        System.out.print("e ");
    }
}
```

**執行流程說明：**

1. 執行 main 方法，輸出 "a "
2. 呼叫 method1()
3. 在 method1() 中呼叫 method2()
4. 執行 method2()，輸出 "d " 和 "e "
5. method2() 結束，回到 method1()，輸出 "c "
6. method1() 結束，回到 main 方法，輸出 "b "

### 8.3 return關鍵字

**作用**：用於結束方法的執行

**重要規則：**

- **方法沒有回傳值**：可以不用寫 `return`，若寫了，表示方法結束
- **方法有回傳值**：一定要寫 `return`，表示方法結束並把結果回傳出去

**範例：**

```java
public class Main {
    public static void main(String[] args) {
        checkNumber(15);
        checkNumber(-5);
        
        int result = getAbsoluteValue(-10);
        System.out.println("絕對值是: " + result);
    }
    
    // 無回傳值的方法使用return
    public static void checkNumber(int num) {
        if (num < 0) {
            System.out.println("數字是負數，方法結束");
            return;  // 提前結束方法
        }
        System.out.println("數字是正數: " + num);
    }
    
    // 有回傳值的方法必須使用return
    public static int getAbsoluteValue(int num) {
        if (num < 0) {
            return -num;
        }
        return num;
    }
}
```

> 注意：`return` 敘述句下面不能寫程式碼，否則會編譯錯誤

### 8.4 方法的注意事項

**重要規則：**

- 方法不呼叫就不會執行
- 方法與方法之間是平級關係，不能互相巢狀定義
- 方法的編寫順序與執行順序無關
- 方法的回傳值型別為 `void` 表示沒有回傳值

**錯誤範例：**

```java
public class Main {
    public static void main(String[] args) {
        // 錯誤：不能在方法內部定義方法
        /*
        public static void method1() {
            // 這樣寫是錯誤的！
        }
        */
    }
    
    // 正確：方法應該在類別中平級定義
    public static void method1() {
        System.out.println("這是正確的方法定義");
    }
}
```

### 8.5 方法的多載

**概念**：在同一個類別中，定義了多個同名的方法，這些同名的方法具有同種的功能

**規則**：每個方法具有不同的**參數型別**或**參數個數**，這些同名的方法，就構成了多載關係

**簡單記憶**：同一個類別中，方法名稱相同，參數不同的方法。與回傳值無關

**參數不同的情況**：
- 個數不同
- 型別不同  
- 順序不同

#### 8.5.1 多載範例

```java
public class Main {
    // 方法多載示範
    
    // 兩個整數求和方法
    public static int sum(int a, int b) {
        return a + b;
    }
    
    // 三個整數求和方法
    public static int sum(int a, int b, int c) {
        return a + b + c;
    }
    
    // 四個整數求和方法
    public static int sum(int a, int b, int c, int d) {
        return a + b + c + d;
    }
    
    // 兩個小數求和方法
    public static double sum(double a, double b) {
        return a + b;
    }
    
    // main 方法測試
    public static void main(String[] args) {
        System.out.println("兩個整數求和: " + sum(1, 2));           // 呼叫兩個整數求和
        System.out.println("三個整數求和: " + sum(1, 2, 3));        // 呼叫三個整數求和
        System.out.println("四個整數求和: " + sum(1, 2, 3, 4));     // 呼叫四個整數求和
        System.out.println("兩個小數求和: " + sum(1.5, 2.5));       // 呼叫兩個小數求和
    }
}
```

#### 8.5.2 多載的判斷

**以下情況構成多載：**

```java
public static void method(int a) { }
public static void method(int a, int b) { }  // 參數個數不同

public static void method(int a) { }
public static void method(double a) { }      // 參數型別不同

public static void method(int a, double b) { }
public static void method(double a, int b) { }  // 參數順序不同
```

**以下情況不構成多載：**

```java
public static void method(int a) { }
public static int method(int a) { }   // 錯誤！只有回傳值型別不同

public static void method(int a) { }
public static void method(int b) { }  // 錯誤！只有參數名稱不同
```

### 8.6 陣列與方法的綜合應用

#### 8.6.1 陣列作為方法參數

```java
public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        
        System.out.println("陣列總和: " + calculateSum(numbers));
        System.out.println("陣列最大值: " + findMax(numbers));
        
        printArray(numbers);
    }
    
    // 計算陣列總和
    public static int calculateSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
    
    // 找出陣列最大值
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    // 列印陣列
    public static void printArray(int[] arr) {
        System.out.print("陣列內容: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
```

#### 8.6.2 陣列拷貝方法

```java
public class Main {
    public static void main(String[] args) {
        // 1. 原始陣列
        int[] arr = {2, 5, 3, 5, 6, 7, 8, 9, 8, 4};
        
        // 2. 呼叫方法拷貝資料（從索引3到索引7，包含3不包含7）
        int[] copyArr = copyOfRange(arr, 3, 7);
        
        // 3. 遍歷 copyArr
        System.out.print("拷貝後的陣列內容: ");
        for (int i = 0; i < copyArr.length; i++) {
            System.out.print(copyArr[i] + " ");
        }
        System.out.println();
        
        // 4. 測試其他拷貝範圍
        int[] copyArr2 = copyOfRange(arr, 0, 5);
        System.out.print("另一個拷貝範例: ");
        for (int num : copyArr2) {
            System.out.print(num + " ");
        }
    }
    
    /**
     * 將陣列arr中從索引from (包含from)開始,到索引to結束(不包含to)的元素複製到新陣列中
     * @param arr 原始陣列
     * @param from 起始索引（包含）
     * @param to 結束索引（不包含）
     * @return 新的陣列
     */
    public static int[] copyOfRange(int[] arr, int from, int to) {
        // 1. 定義新陣列
        int[] newArr = new int[to - from];
        
        // 2. 把原始陣列arr中的from到to對應的元素,直接拷貝到newArr中
        // 偽造索引的思想
        int index = 0;
        for (int i = from; i < to; i++) {
            // 格式: 陣列名稱[索引] = 資料值
            newArr[index] = arr[i];
            index++;
        }
        
        // 3. 把新陣列回傳
        return newArr;
    }
}
```

#### 8.6.3 陣列排序方法

```java
public class Main {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("排序前：");
        printArray(arr);
        
        bubbleSort(arr);
        
        System.out.println("排序後：");
        printArray(arr);
    }
    
    /**
     * 氣泡排序法
     * @param arr 要排序的陣列
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交換元素
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    /**
     * 列印陣列
     * @param arr 要列印的陣列
     */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
```

## 9 補充：Random套件

**作用**：用於產生隨機數

**使用步驟：**

1. 匯入套件：`import java.util.Random;`
2. 建立物件：`Random r = new Random();`
3. 產生隨機數

### 9.1 Random的基本使用

```java
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // 建立Random物件
        Random r = new Random();
        
        // 產生隨機整數
        int randomInt = r.nextInt();
        System.out.println("隨機整數: " + randomInt);
        
        // 產生0到9的隨機整數
        int randomRange = r.nextInt(10);
        System.out.println("0-9的隨機數: " + randomRange);
        
        // 產生1到100的隨機整數
        int random1to100 = r.nextInt(100) + 1;
        System.out.println("1-100的隨機數: " + random1to100);
        
        // 產生隨機浮點數（0.0到1.0）
        double randomDouble = r.nextDouble();
        System.out.println("隨機浮點數: " + randomDouble);
        
        // 產生隨機布林值
        boolean randomBoolean = r.nextBoolean();
        System.out.println("隨機布林值: " + randomBoolean);
    }
}
```

### 9.2 Random的常用方法

| 方法名稱 | 說明 |
|---------|------|
| `nextInt()` | 產生隨機整數 |
| `nextInt(int bound)` | 產生0到bound-1的隨機整數 |
| `nextDouble()` | 產生0.0到1.0的隨機浮點數 |
| `nextBoolean()` | 產生隨機布林值 |
| `nextLong()` | 產生隨機長整數 |
| `nextFloat()` | 產生0.0到1.0的隨機單精度浮點數 |

### 9.3 Random應用範例

#### 9.3.1 隨機點名系統

```java
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] students = {"小明", "小華", "小美", "小強", "小婷"};
        Random r = new Random();
        
        System.out.println("今天的值日生是：");
        
        // 產生隨機索引
        int randomIndex = r.nextInt(students.length);
        System.out.println(students[randomIndex]);
    }
}
```

#### 9.3.2 隨機密碼產生器

```java
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String password = generatePassword(8);
        System.out.println("隨機密碼: " + password);
    }
    
    /**
     * 產生指定長度的隨機密碼
     * @param length 密碼長度
     * @return 隨機密碼字串
     */
    public static String generatePassword(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random r = new Random();
        StringBuilder password = new StringBuilder();
        
        for (int i = 0; i < length; i++) {
            int randomIndex = r.nextInt(chars.length());
            password.append(chars.charAt(randomIndex));
        }
        
        return password.toString();
    }
}
```

## 10 綜合練習題

### 10.1 陣列元素統計

**需求**：統計陣列中各個數字出現的次數

```java
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1, 3, 1, 4, 2};
        
        System.out.println("原始陣列：");
        printArray(arr);
        
        countNumbers(arr);
    }
    
    /**
     * 統計陣列中每個數字出現的次數
     * @param arr 要統計的陣列
     */
    public static void countNumbers(int[] arr) {
        // 找出陣列中的最大值，確定統計陣列的大小
        int max = findMax(arr);
        int[] count = new int[max + 1];
        
        // 統計每個數字出現的次數
        for (int num : arr) {
            count[num]++;
        }
        
        // 輸出統計結果
        System.out.println("數字出現次數統計：");
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                System.out.println("數字 " + i + " 出現了 " + count[i] + " 次");
            }
        }
    }
    
    /**
     * 找出陣列中的最大值
     * @param arr 輸入陣列
     * @return 最大值
     */
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    /**
     * 列印陣列
     * @param arr 要列印的陣列
     */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
```

### 10.2 陣列反轉

**需求**：將陣列中的元素順序反轉

```java
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        System.out.println("反轉前：");
        printArray(arr);
        
        reverseArray(arr);
        
        System.out.println("反轉後：");
        printArray(arr);
    }
    
    /**
     * 反轉陣列元素
     * @param arr 要反轉的陣列
     */
    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        
        while (start < end) {
            // 交換元素
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            
            start++;
            end--;
        }
    }
    
    /**
     * 列印陣列
     * @param arr 要列印的陣列
     */
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
```

### 10.3 二維陣列基礎

**概念**：二維陣列可以理解為陣列的陣列，用於存放表格型資料

**語法格式：**

```java
// 動態初始化
資料型別[][] 陣列名稱 = new 資料型別[行數][列數];

// 靜態初始化
資料型別[][] 陣列名稱 = {{元素1, 元素2}, {元素3, 元素4}, ...};
```

**範例：**

```java
public class Main {
    public static void main(String[] args) {
        // 靜態初始化二維陣列
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("二維陣列內容：");
        printMatrix(matrix);
        
        // 動態初始化二維陣列
        int[][] dynamicMatrix = new int[3][3];
        
        // 填入資料
        int value = 1;
        for (int i = 0; i < dynamicMatrix.length; i++) {
            for (int j = 0; j < dynamicMatrix[i].length; j++) {
                dynamicMatrix[i][j] = value++;
            }
        }
        
        System.out.println("動態初始化的二維陣列：");
        printMatrix(dynamicMatrix);
    }
    
    /**
     * 列印二維陣列
     * @param matrix 要列印的二維陣列
     */
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
```

### 10.4 陣列應用綜合練習

#### 10.4.1 學生成績管理系統

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("請輸入學生人數: ");
        int studentCount = sc.nextInt();
        
        String[] names = new String[studentCount];
        int[] scores = new int[studentCount];
        
        // 輸入學生資訊
        inputStudentInfo(names, scores, sc);
        
        // 顯示所有學生資訊
        System.out.println("\n=== 學生成績列表 ===");
        displayStudentInfo(names, scores);
        
        // 計算平均分數
        double average = calculateAverage(scores);
        System.out.println("班級平均分數: " + String.format("%.2f", average));
        
        // 找出最高分學生
        int maxIndex = findTopStudent(scores);
        System.out.println("最高分學生: " + names[maxIndex] + " (" + scores[maxIndex] + "分)");
    }
    
    /**
     * 輸入學生資訊
     */
    public static void inputStudentInfo(String[] names, int[] scores, Scanner sc) {
        for (int i = 0; i < names.length; i++) {
            System.out.print("請輸入第" + (i + 1) + "位學生姓名: ");
            names[i] = sc.next();
            System.out.print("請輸入" + names[i] + "的成績: ");
            scores[i] = sc.nextInt();
        }
    }
    
    /**
     * 顯示學生資訊
     */
    public static void displayStudentInfo(String[] names, int[] scores) {
        for (int i = 0; i < names.length; i++) {
            System.out.println((i + 1) + ". " + names[i] + ": " + scores[i] + "分");
        }
    }
    
    /**
     * 計算平均分數
     */
    public static double calculateAverage(int[] scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.length;
    }
    
    /**
     * 找出最高分學生的索引
     */
    public static int findTopStudent(int[] scores) {
        int maxIndex = 0;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > scores[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
```

#### 10.4.2 數字猜謎遊戲

```java
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        playGuessingGame();
    }
    
    /**
     * 數字猜謎遊戲
     */
    public static void playGuessingGame() {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        
        int targetNumber = r.nextInt(100) + 1;  // 1-100的隨機數
        int attempts = 0;
        int maxAttempts = 7;  // 最多猜7次
        
        System.out.println("=== 數字猜謎遊戲 ===");
        System.out.println("我想了一個1到100之間的數字，你能猜出來嗎？");
        System.out.println("你有" + maxAttempts + "次機會！");
        
        while (attempts < maxAttempts) {
            System.out.print("請輸入你的猜測 (第" + (attempts + 1) + "次): ");
            int guess = sc.nextInt();
            attempts++;
            
            if (guess == targetNumber) {
                System.out.println("🎉 恭喜你猜對了！答案就是 " + targetNumber);
                System.out.println("你總共猜了 " + attempts + " 次");
                return;
            } else if (guess < targetNumber) {
                System.out.println("太小了！再試試看");
            } else {
                System.out.println("太大了！再試試看");
            }
            
            if (attempts < maxAttempts) {
                System.out.println("還有 " + (maxAttempts - attempts) + " 次機會");
            }
        }
        
        System.out.println("😢 很遺憾，機會用完了！答案是 " + targetNumber);
    }
}
```

## 11 方法進階應用

### 11.1 方法的設計原則

**良好的方法設計應該遵循以下原則：**

1. **單一職責原則**：一個方法只做一件事
2. **參數合理**：參數不宜過多，通常不超過3-4個
3. **命名清晰**：方法名稱應該清楚表達方法的功能
4. **適當的回傳值**：根據需求決定是否需要回傳值

### 11.2 方法的可見性修飾符

**語法說明：**

```java
/*
public → 方法對所有類別都可見
private → 方法僅在本類別內可見  
protected → 方法在本類別、同套件和子類別可見
沒寫 → 預設 (default/package-private)，僅在同套件可見
*/

// static 方法 → 不需要建立物件即可呼叫
```

**範例：**

```java
public class Main {
    public static void main(String[] args) {
        // 呼叫public方法
        publicMethod();
        
        // 呼叫private方法
        privateMethod();
        
        // 呼叫預設方法
        defaultMethod();
    }
    
    // public方法 - 所有地方都可以存取
    public static void publicMethod() {
        System.out.println("這是public方法");
    }
    
    // private方法 - 只能在本類別內存取
    private static void privateMethod() {
        System.out.println("這是private方法");
    }
    
    // 預設方法 - 同套件內可以存取
    static void defaultMethod() {
        System.out.println("這是預設方法");
    }
}
```

### 11.3 遞迴方法

**概念**：方法呼叫自己的程式設計技巧

**重要組成**：
- **遞迴出口**：遞迴結束的條件
- **遞迴規則**：如何進行遞迴呼叫

#### 11.3.1 階乘計算

```java
public class Main {
    public static void main(String[] args) {
        int n = 5;
        int result = factorial(n);
        System.out.println(n + "! = " + result);
        
        // 測試其他數值
        for (int i = 1; i <= 6; i++) {
            System.out.println(i + "! = " + factorial(i));
        }
    }
    
    /**
     * 計算階乘的遞迴方法
     * @param n 要計算階乘的數
     * @return n的階乘
     */
    public static int factorial(int n) {
        // 遞迴出口
        if (n == 0 || n == 1) {
            return 1;
        }
        
        // 遞迴規則：n! = n × (n-1)!
        return n * factorial(n - 1);
    }
}
```

#### 11.3.2 費波納契數列

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("費波納契數列前10項：");
        for (int i = 1; i <= 10; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
        
        // 計算第20項
        System.out.println("第20項費波納契數: " + fibonacci(20));
    }
    
    /**
     * 計算費波納契數列第n項
     * @param n 項數
     * @return 第n項的值
     */
    public static int fibonacci(int n) {
        // 遞迴出口
        if (n == 1 || n == 2) {
            return 1;
        }
        
        // 遞迴規則：F(n) = F(n-1) + F(n-2)
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
```

## 12 專案實戰：簡易計算機

**需求**：設計一個簡易計算機，支援基本的四則運算

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.run();
    }
}

class Calculator {
    private Scanner sc = new Scanner(System.in);
    
    /**
     * 計算機主程式
     */
    public void run() {
        System.out.println("=== 簡易計算機 ===");
        System.out.println("支援運算：+ - * / %");
        System.out.println("輸入 'exit' 結束程式");
        
        while (true) {
            System.out.println("\n請選擇操作：");
            System.out.println("1. 基本運算");
            System.out.println("2. 進階功能");
            System.out.println("3. 結束程式");
            System.out.print("請輸入選項 (1-3): ");
            
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1 -> basicCalculation();
                case 2 -> advancedFeatures();
                case 3 -> {
                    System.out.println("謝謝使用，再見！");
                    return;
                }
                default -> System.out.println("無效選項，請重新輸入");
            }
        }
    }
    
    /**
     * 基本運算功能
     */
    private void basicCalculation() {
        System.out.print("請輸入第一個數字: ");
        double num1 = sc.nextDouble();
        
        System.out.print("請輸入運算符號 (+, -, *, /, %): ");
        String operator = sc.next();
        
        System.out.print("請輸入第二個數字: ");
        double num2 = sc.nextDouble();
        
        double result = calculate(num1, operator, num2);
        
        if (!Double.isNaN(result)) {
            System.out.println("計算結果: " + num1 + " " + operator + " " + num2 + " = " + result);
        }
    }
    
    /**
     * 執行基本運算
     */
    private double calculate(double num1, String operator, double num2) {
        switch (operator) {
            case "+" -> {
                return num1 + num2;
            }
            case "-" -> {
                return num1 - num2;
            }
            case "*" -> {
                return num1 * num2;
            }
            case "/" -> {
                if (num2 == 0) {
                    System.out.println("錯誤：除數不能為0");
                    return Double.NaN;
                }
                return num1 / num2;
            }
            case "%" -> {
                if (num2 == 0) {
                    System.out.println("錯誤：除數不能為0");
                    return Double.NaN;
                }
                return num1 % num2;
            }
            default -> {
                System.out.println("錯誤：不支援的運算符號");
                return Double.NaN;
            }
        }
    }
    
    /**
     * 進階功能
     */
    private void advancedFeatures() {
        System.out.println("=== 進階功能 ===");
        System.out.println("1. 計算平方");
        System.out.println("2. 計算平方根");
        System.out.println("3. 計算次方");
        System.out.print("請選擇功能 (1-3): ");
        
        int choice = sc.nextInt();
        
        switch (choice) {
            case 1 -> {
                System.out.print("請輸入數字: ");
                double num = sc.nextDouble();
                System.out.println("結果: " + num + "² = " + (num * num));
            }
            case 2 -> {
                System.out.print("請輸入數字: ");
                double num = sc.nextDouble();
                if (num < 0) {
                    System.out.println("錯誤：負數無法計算平方根");
                } else {
                    System.out.println("結果: √" + num + " = " + Math.sqrt(num));
                }
            }
            case 3 -> {
                System.out.print("請輸入底數: ");
                double base = sc.nextDouble();
                System.out.print("請輸入指數: ");
                double exponent = sc.nextDouble();
                System.out.println("結果: " + base + "^" + exponent + " = " + Math.pow(base, exponent));
            }
            default -> System.out.println("無效選項");
        }
    }
}
```

## 13 常見陣列演算法

### 13.1 排序演算法

#### 13.1.1 選擇排序法

```java
public class Main {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        
        System.out.println("選擇排序前：");
        printArray(arr);
        
        selectionSort(arr);
        
        System.out.println("選擇排序後：");
        printArray(arr);
    }
    
    /**
     * 選擇排序法
     * @param arr 要排序的陣列
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            // 找出未排序部分的最小值索引
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
            // 交換最小值到正確位置
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
    
    /**
     * 列印陣列
     */
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
```

#### 13.1.2 插入排序法

```java
public class Main {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        
        System.out.println("插入排序前：");
        printArray(arr);
        
        insertionSort(arr);
        
        System.out.println("插入排序後：");
        printArray(arr);
    }
    
    /**
     * 插入排序法
     * @param arr 要排序的陣列
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            
            // 將arr[0..i-1]中大於key的元素向後移動
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            
            arr[j + 1] = key;
        }
    }
    
    /**
     * 列印陣列
     */
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
```

### 13.2 搜尋演算法

#### 13.2.1 線性搜尋

```java
public class Main {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int target = 30;
        
        int index = linearSearch(arr, target);
        
        if (index != -1) {
            System.out.println("找到了！數字 " + target + " 在索引 " + index + " 位置");
        } else {
            System.out.println("未找到數字 " + target);
        }
    }
    
    /**
     * 線性搜尋
     * @param arr 要搜尋的陣列
     * @param target 目標值
     * @return 找到返回索引，未找到返回-1
     */
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
```

#### 13.2.2 二元搜尋（適用於已排序陣列）

```java
public class Main {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90};  // 已排序陣列
        int target = 50;
        
        int index = binarySearch(arr, target);
        
        if (index != -1) {
            System.out.println("找到了！數字 " + target + " 在索引 " + index + " 位置");
        } else {
            System.out.println("未找到數字 " + target);
        }
    }
    
    /**
     * 二元搜尋（陣列必須已排序）
     * @param arr 已排序的陣列
     * @param target 目標值
     * @return 找到返回索引，未找到返回-1
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;  // 未找到
    }
}
```

## 14 實用工具方法集合

### 14.1 陣列工具方法

```java
import java.util.Random;

public class ArrayUtils {
    
    /**
     * 列印陣列（一行）
     */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
    
    /**
     * 列印陣列（垂直）
     */
    public static void printArrayVertical(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("[" + i + "] = " + arr[i]);
        }
    }
    
    /**
     * 填充陣列隨機值
     */
    public static void fillRandomArray(int[] arr, int min, int max) {
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(max - min + 1) + min;
        }
    }
    
    /**
     * 複製陣列
     */
    public static int[] copyArray(int[] original) {
        int[] copy = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i];
        }
        return copy;
    }
    
    /**
     * 檢查陣列是否已排序
     */
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * 測試所有工具方法
     */
    public static void main(String[] args) {
        // 建立測試陣列
        int[] testArray = new int[5];
        fillRandomArray(testArray, 1, 100);
        
        System.out.println("隨機產生的陣列：");
        printArray(testArray);
        
        // 複製陣列
        int[] copiedArray = copyArray(testArray);
        System.out.println("複製的陣列：");
        printArray(copiedArray);
        
        // 檢查是否已排序
        System.out.println("陣列是否已排序: " + isSorted(testArray));
        
        // 排序並再次檢查
        bubbleSort(testArray);
        System.out.println("排序後的陣列：");
        printArray(testArray);
        System.out.println("陣列是否已排序: " + isSorted(testArray));
    }
    
    /**
     * 氣泡排序法
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交換元素
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
```

---

## 結語

本講義第二天的內容涵蓋了Java程式設計的進階基礎知識，包括：

1. **陣列** - 資料容器的使用，包括一維和二維陣列
2. **方法** - 程式碼的模組化，包括定義、呼叫、多載和遞迴
3. **Random套件** - 隨機數的產生和應用
4. **綜合應用** - 實際專案的開發實戰

**學習建議：**

- **多加練習**：陣列和方法是Java程式設計的核心概念，需要透過大量練習來熟練掌握
- **理解原理**：不只要會寫程式碼，更要理解底層的運作原理
- **注重設計**：學會設計良好的方法結構，提高程式碼的可讀性和維護性
- **實際應用**：嘗試將所學知識應用到實際問題的解決中

這些內容為後續學習Java物件導向程式設計、例外處理、檔案操作等進階主題打下了堅實的基礎。

**下一步學習方向：**
- 物件導向程式設計（類別與物件）
- 繼承與多型
- 介面與抽象類別
- 例外處理
- 集合框架

繼續加油，Java學習之路才剛開始！🚀