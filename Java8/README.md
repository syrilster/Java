## Lambdas

Idea of replacing clutter in the code. i.e. lambda essentially will have only the parameter list and the body.For example remove unnecessary code from a anonymous class.

```
Thread th = new Thread(new Runnable() {
  public void run() {
   System.out.println("In another thread");
  }  
});
th.start();
```
Lambda code:

```
Thread th = new Thread(() ->  System.out.println("In another thread"));
th.start();

```
