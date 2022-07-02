package com.shzhangji.demo.requestcontext;

public class CustomContextHolder {
  private static final ThreadLocal<CustomContext> holder = new ThreadLocal<>();

  public static void set(CustomContext context) {
    holder.set(context);
  }

  public static CustomContext get() {
    return holder.get();
  }

  public static void remove() {
    holder.remove();
  }
}
