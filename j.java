package a.a.a.a.a;

import android.view.View;
import android.view.ViewGroup;
import h8800e55c.pc41fcc5f.v416f9e89;
import h8800e55c.x78d2f21c.y0bc38925;
import java.lang.reflect.Method;

public class j {
  public static String a(String paramString) {
    int i = paramString.length();
    int k = -10 % i;
    paramString = b(paramString);
    if (k > 0) {
      StringBuilder stringBuilder1 = new StringBuilder();
      k = i - k;
      stringBuilder1.append(paramString.substring(k, i));
      stringBuilder1.append(paramString.substring(0, k));
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    k = -k;
    stringBuilder.append(paramString.substring(k, i));
    stringBuilder.append(paramString.substring(0, k));
    return stringBuilder.toString();
  }
  
  public static String b(String paramString) {
    return paramString;
  }
  
  public static String c(String paramString) {
    int i;
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    byte b = 0;
    try {
      Class clazz = y0bc38925.classForName(v416f9e89.xbd520268("1"));
      Method method1 = y0bc38925.getMethod(clazz, v416f9e89.xbd520268("2"), new Class[0]);
      Object[] arrayOfObject2 = (Object[])null;
      Object object = method1.invoke(null, null);
      method1 = y0bc38925.getMethod(clazz, v416f9e89.xbd520268("3"), new Class[0]);
      Method method2 = y0bc38925.getMethod(clazz, v416f9e89.xbd520268("4"), new Class[] { String.class });
      Object[] arrayOfObject1 = (Object[])null;
      String[] arrayOfString = (String[])method1.invoke(object, null);
      int m = arrayOfString.length;
      String str1 = v416f9e89.xbd520268("5");
      String str2 = str1;
      int k = 0;
      while (true) {
        StringBuilder stringBuilder1;
        i = b;
        String str3 = str2;
        if (k < m) {
          View view = (View)method2.invoke(object, new Object[] { arrayOfString[k] });
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append(str2);
          if (arrayOfString.length > 1) {
            str2 = v416f9e89.xbd520268("6");
          } else {
            str2 = str1;
          } 
          stringBuilder1.append(str2);
          stringBuilder1.append(d((ViewGroup)view, str1, str1, str1));
          if (arrayOfString.length > 1) {
            str2 = v416f9e89.xbd520268("7");
          } else {
            str2 = str1;
          } 
          stringBuilder1.append(str2);
          str2 = stringBuilder1.toString();
          k++;
          continue;
        } 
        while (i < stringBuilder1.length()) {
          stringBuilder.append((char)(stringBuilder1.charAt(i) ^ paramString.charAt(i % paramString.length())));
          i++;
        } 
        return stringBuilder.toString();
      } 
    } catch (Exception exception) {
      str = v416f9e89.xbd520268("8");
      i = b;
    } 
    while (i < str.length()) {
      stringBuilder.append((char)(str.charAt(i) ^ paramString.charAt(i % paramString.length())));
      i++;
    } 
    return stringBuilder.toString();
  }
  
  public static String d(ViewGroup paramViewGroup, String paramString1, String paramString2, String paramString3) {
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(paramString1);
    stringBuilder3.append(paramString2);
    paramString1 = stringBuilder3.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramString1);
    stringBuilder2.append(e(paramViewGroup.getClass().toString()));
    paramString1 = stringBuilder2.toString();
    int i;
    for (i = 0; i < paramViewGroup.getChildCount(); i++) {
      View view = paramViewGroup.getChildAt(i);
      boolean bool = view instanceof ViewGroup;
      String str1 = v416f9e89.xbd520268("9");
      String str2 = v416f9e89.xbd520268("10");
      if (bool) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramString1);
        stringBuilder.append(d((ViewGroup)view, v416f9e89.xbd520268("11"), str2, str1));
        paramString1 = stringBuilder.toString();
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramString1);
        stringBuilder.append(str2);
        stringBuilder.append(e(view.getClass().toString()));
        stringBuilder.append(str1);
        paramString1 = stringBuilder.toString();
      } 
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramString1);
    stringBuilder1.append(paramString3);
    return stringBuilder1.toString();
  }
  
  private static String e(String paramString) {
    String[] arrayOfString = paramString.split(v416f9e89.xbd520268("12"));
    return (arrayOfString.length == 0) ? paramString : arrayOfString[arrayOfString.length - 1];
  }
  
  public static int f() {
    String str = v416f9e89.xbd520268("13");
    h(g(str));
    n(o(str));
    l(str, i(5));
    return m(k(str)) * 1;
  }
  
  private static String g(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(v416f9e89.xbd520268("14"));
    return stringBuilder.toString();
  }
  
  private static String h(String paramString) {
    return paramString.trim();
  }
  
  private static String i(int paramInt) {
    return String.valueOf(paramInt);
  }
  
  private static String k(String paramString) {
    return paramString.replace('\\', '.');
  }
  
  private static String l(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString1);
    stringBuilder.append(v416f9e89.xbd520268("15"));
    stringBuilder.append(paramString2);
    return stringBuilder.toString();
  }
  
  private static int m(String paramString) {
    return paramString.length();
  }
  
  private static String n(String paramString) {
    return paramString.toLowerCase();
  }
  
  private static String o(String paramString) {
    return paramString.toUpperCase();
  }
}


/* Location:              C:\soft\dex2jar-2.0\8 Ball Pool-dex2jar.jar!\a\a\a\a\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */