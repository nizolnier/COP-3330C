// public class PracticeExam 
// {
//     public static void main(String[] args) 
//     {
//         // Vehicle c = new Vehicle();
//         // System.out.println(c.maxSpeed);

//         // cant access child's methods
//         // Vehicle c1 = new Car();
//         // System.out.println(c1.maxSpeed);
        
//         Car c2 = new Car();
//         // System.out.println(c2.maxSpeed);

//         // c2.display();
//         // c2.vroom();
//     }
// }

// class Vehicle
// {
//     int maxSpeed = 120;

//     public void vroom()
//     {
//         System.out.println("vrooooom");
//     }

//     public Vehicle()
//     {
//         System.out.println("NO");
//     }
// }

// class Car extends Vehicle
// {
//     // now two maxSpeeds
//     int maxSpeed = 100;

//     public Car()
//     {
//         super();
//         System.out.println("YES");
//     }

//     public void display()
//     {
//         System.out.println(maxSpeed);
//         System.out.println(super.maxSpeed);
//     }

//     public void vroom()
//     {
//         super.vroom();
//         System.out.println("SHEEEEEEESH");
//     }
// }

// class Animal
// {
//     int age;
//     String food;

//     public Animal(int age, String food)
//     {
//         this.age = age;
//         this.food = food;
//     }
// }

// class Dog extends Animal
// {
//     String race;

//     public Dog(int age, String food, String race)
//     {
//         super(age, food);
//         this.race = race;
//     }
// }

// public class Practice implements fun
// {
//     public static void main(String[] args) 
//     {
//         System.out.println(color);
//     }

//     @Override
//     public void yo() {
//         // TODO Auto-generated method stub
        
//     }
    
// }

// interface fun
// {
//     String color = "blue";
//     public void yo();
// }

//////////////////////////////////////////////////////////////////////////////////////////

// Question 1
// public class Practice 
// {
//     public static void main(String[] args) 
//     {
//         int x = 1;
//         int y = 0;
        
//         try
//         {
//             System.out.println(x/y);
//         }
//         catch (Exception e)
//         {
//             System.out.println("1");
//         }
//         finally
//         {
//             System.out.println("2");
//         }
//     }
// }


// // Question 2
// public class Practice 
// {
//     public static void main(String[] args) 
//     {
//         int x = 1;
//         System.out.println(x);
//         change(x);
//         System.out.println(x);
//     }

//     public static void change(int x)
//     {
//         x = 3;
//     }
// }


// // Question 3/4
// public class Practice 
// {
//     public static void main(String[] args) 
//     {
//         int x = 1;
//         int y = 0;
//         String name = null;

//         try
//         {
//             // Whatever exception is caught first, you break out into its catch
//             // ONLY DO ONE CATCH

//             // if name is null, will cause NullPointerException
//             System.out.println(name.length());

//             // if y is 0 then you will get Arithmetic excpetion
//             System.out.println(x / y);
//         }
//         catch (ArithmeticException e)
//         {
//             System.out.println("1");
//         }
//         catch (NullPointerException e)
//         {
//             System.out.println("2");
//         }
//         catch (Exception e) // fail safe
//         {
//             System.out.println("3");
//         }
//     }
// }


// // Question 5
// public class Practice 
// {
//     public static void main(String[] args) 
//     {
//         int x = 1;
//         int y = 0;

//         try 
//         {
//             // 1 / 0 does not through exception, but u will do finally
//             x = y/x;
//         }
//         catch (Exception ArithmeticException)
//         {
//             System.out.println("3");
//         }
//         finally
//         {
//             System.out.println("4");
//         }
//     }
// }


// // Question 6 (Does not handle exception)
// public class Practice 
// {
//     public static void main(String[] args) 
//     {
//         fun();
//         System.out.println("1");
//     }

//     public static void fun() throws Exception
//     {
//         System.out.println("2");
//     }
// }


// // Question 7 (Does handle exception)
// public class Practice 
// {
//     public static void main(String[] args) 
//     {
//         try
//         {
//             fun();
//         }
//         catch (Exception e)
//         {
//             System.out.println("1");
//         }
//     }

//     public static void fun() throws Exception
//     {
//         // if this doesnt throw exception then you only do the stuff in try
//         System.out.println("2");

//         // But doing this will cause an exception
//         int x = 1 / 0;
//     }
// }


// Question 8 
// public class Practice 
// {
//     public static void main(String[] args) 
//     {
//         try
//         {
//             fun();
//         }
//         catch (Exception e)
//         {
//             System.out.println("1");
//         }
//     }

//     public static void fun() throws Exception
//     {
//         // you dont print the thing that throws the exception
//         System.out.println(2/0);
//     }
// }

// Question 9 (No work cuz obj not initialized)
// public class Practice 
// {
//     public static void main(String[] args) 
//     {
//         MyClass obj;
//         obj.doNothing();
//     }
// }

// class MyClass
// {
//     public int data;
//     public void doNothing()
//     {
//     }
// }


// Question 10
// interface myInterface
// {
//     public void doNothing();
// }

// class MyClass
// {
//     public static void doNothing()
//     {
//         System.out.println("Chilling!");
//     }
// }

// class Main
// {
//     public static void main(String[] args) 
//     {
//         myInterface myInter;
//         MyClass myobject;
//         // doNothing();
//     }

//     private static void doNothing() 
//     {
//         System.out.println("relaxing");
//     }
// }


// // Question 11
// interface myInterface
// {
//     public void doNothing();
// }

// class MyClass implements myInterface
// {
//     public void doNothing()
//     {
//         System.out.println("Chilling!");
//     }
// }

// class Main
// {
//     public static void main(String[] args) 
//     {
//         doNothing();
//         MyClass myobj = new MyClass();
//         myobj.doNothing();
//     }

//     private static void doNothing() 
//     {
//         System.out.println("relaxing");
//     }
// }


// // Question 12
// interface MyInterface
// {
//     public void doNothing();
// }

// // Doesnt have to implement it as its abstract
// abstract class myAbstract implements MyInterface
// {
//     abstract public void doNothing(int x);
// }

// // parameters need to be the same as the interface's
// class MyClass implements MyInterface
// {
//     public void doNothing(int x)
//     {
//         System.out.println("Chilling!");
//     }

//     public void doNothing()
//     {
//         System.out.println("Chilling!");
//     }
// }

// class Main
// {
//     public static void main(String[] args) 
//     {
//         MyClass myobj = new MyClass();
//         myobj.doNothing();
//     }

//     private static void doNothing() 
//     {
//         System.out.println("relaxing");
//     }
// }


// Question 13
// Cant extend your own class
// interface MyInterface
// {
//     public void doNothing();
// }

// // Doesnt have to implement it as its abstract
// abstract class myAbstract implements MyInterface
// {
//     abstract public void doNothing(int x);
// }

// // parameters need to be the same as the interface's
// class MyClass extends MyClass implements MyInterface
// {
//     public void doNothing(int x)
//     {
//         System.out.println("Chilling!");
//     }

//     public void doNothing()
//     {
//         System.out.println("Chilling!");
//     }
// }

// class Main
// {
//     public static void main(String[] args) 
//     {
//         MyClass myobj = new MyClass();
//         myobj.doNothing();
//     }

//     private static void doNothing() 
//     {
//         System.out.println("relaxing");
//     }
// }


// // Question 14
// class MyClass
// {
//     public int data;
// }

// class Main
// {
//     public static void main(String[] args) 
//     {
//         MyClass [] array = new MyClass[3];

//         try
//         {
//             for (int i = 0; i < 3; i++)
//             {
//                 // Missing this: array[i] = new MyClass();, so it will print bug
//                 array[i].data = i + 1;
//             }
//         }
//         catch (Exception e)
//         {
//             System.out.println("BUG");
//         }
//     }
// }


// Question 15
// class MyClass
// {
//     public int data;
//     public String toString()
//     {
//         return " " + data;
//     }
// }

// class Main
// {
//     public static void main(String[] args) 
//     {
//         MyClass [] array = new MyClass[3];

//         try
//         {
//             for (int i = 0; i < 3; i++)
//             {
//                 array[i] = new MyClass();
//                 array[i].data = i + 1;
//                 System.out.print(array[i]);
//             }
//         }
//         catch (Exception e)
//         {
//             System.out.println("BUG");
//         }
//     }
// }

// Question 16
// class MyClass extends Exception
// {
//     public int data;
//     MyClass()
//     {
//         data = 0;
//         data++;
//     }

//     public String toString()
//     {
//         return " " + data;
//     }
// }

// class Main
// {
//     public static void main(String[] args) 
//     {
//         try
//         {
//             throw new MyClass(); // throws MyClass exception (data = 0, data++)
//         }
//         catch (MyClass e)
//         {
//             System.out.println(e);
//         }
//     }
// }


// Question 17
// class MyClass extends Exception
// {
//     public static int data;
//     MyClass()
//     {
//         // data = 0;
//         data++;
//     }

//     public String toString()
//     {
//         return " " + data;
//     }
// }

// class Main
// {
//     public static void main(String[] args) 
//     {
//         // This here doesnt matter as we set data back to 0 anyways
//         MyClass.data = 1;

//         try
//         {
//             throw new MyClass(); // adds 1 to the count
//         }
//         catch (MyClass e)
//         {
//             MyClass obj = new MyClass(); // adds 1 to the count
//             System.out.println(obj);
//         }
//     }
// }


// // Question 18
// class ChangeClass
// {
//     public static void change(String test)
//     {
//         test = "Test2";
//     }

//     public static void main(String[] args) 
//     {
//         String test = "Test1";
//         ChangeClass.change(test);
//         System.out.println(test);    
//     }
// }


// // Question 19
// class ChangeClass
// {
//     public static String test;
//     public static void change()
//     {
//         test = "Test2";
//     }

//     public static void main(String[] args) 
//     {
//         ChangeClass.test = "Test1";
//         ChangeClass.change();
//         System.out.println(ChangeClass.test);    
//     }
// }


// // Question 20
// class Main
// {
//     public static void main(String[] args) 
//     {
//         try
//         {
//             System.out.println(new Test()); // creates new object
//         } 
//         catch(Exception t) // exception not caught
//         {
//             System.out.println(t);
//         }

//         System.out.println("Test");
//     }
// }

// class Test // extends Exception (This will trigger the catch)
// {
//     public String toString()
//     {
//         return "Test";
//     }
// }


// // Question 21
// class Main
// {
//     public static void main(String[] args) 
//     {
//         try
//         {
//             System.out.println(new Test()); // creates new object
//         } 
//         catch(Exception t) // exception not caught
//         {
//             System.out.println(t);
//         }

//         System.out.println("Test");
//     }
// }

// class Test // extends Exception (This will trigger the catch)
// {
//     public String toString()
//     {
//         return "Test";
//     }
// }


// // // Question 21
// class Main
// {
//     public static void main(String[] args) {
        
//     }
// }

// interface Iparent
// {
//     public int x = 1;
//     public void print();
// }

// class Child implements Iparent
// {
//     private int y;

//     public Child(int a, int b)
//     {
//         x = a; // cannot be assigned (in constructors)
//         y = b;
//     }

//     public void print()
//     {
//         System.out.println("Child" + y);
//     }
// }


// // Question 22
// class Main
// {
//     public static void main(String[] args) 
//     {
//         Iparent[] p = new Iparent[2];

//         try
//         {
//             p[0].print();
//         }
//         catch (Exception e)
//         {
//             System.out.println("BAD");
//         }
//     }
// }

// interface Iparent
// {
//     public int x = 1;
//     public void print();
// }

// class Child1 implements Iparent
// {
//     public void print()
//     {
//         System.out.println(x);
//     }
// }


// Question 24
// class Main
// {
//     private static void fun(int age) // needs: throws MyException
//     {
//         if (age < 0) throw new MyException(age);
//     }

//     public static void main(String[] args) 
//     {
//         try
//         {
//             fun(65);
//             System.out.println("DONE");
//         }
//         catch(Exception e)
//         {
//             System.out.println(e);
//         }
//     }
// }

// class MyException extends Exception
// {
//     private int age;
    
//     public MyException(int age)
//     {
//         this.age = age;
//     }
// }