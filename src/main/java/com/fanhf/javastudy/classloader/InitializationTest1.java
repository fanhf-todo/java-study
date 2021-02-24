package com.fanhf.javastudy.classloader;

/**
 * @author fanhf
 * @Description 哪些场景下，java编译器就不会生成<clint>()方法。
 * @date 2021-01-28 16:10
 */
public class InitializationTest1 {
    //情况1：对非静态变量（基本数据类型或引用数据类型），不管是否显式赋值，都不会生成<clint>(),即都不会初始化
    public int num10;
    public int num11 = 1;
    public Integer num13;
    public Integer num12 = 1;
    public String str11;
    public String str12 = "fanhf";

   //情况2：对静态基本数据类型，没有显式赋值，也不会生成<clint>()
    public static int num20;
    /**情况3：对静态基本数据类型，有显式赋值，会生成<clint>()，说明是在初始化阶段赋值 */
    public static int num21 = 1;

    //情况4：包装类未显式赋值，不会生成<clint>()
    public static Integer num23;

    /**情况5：包装类显式赋值，会生成<clint>()，说明是在初始化阶段赋值 */
    public static Integer num22 = 1;

    /**情况6：引用类型string类型显式赋值（字面量或new），都会生成<clint>()，说明是在初始化阶段赋值，不显式赋值则不会生成<clint>()*/
    public static String str20;
    public static String str2 = "fanhf";
    public static String str3 = new String("fanhf");

   /**
    * 总结static： 静态的基本数据类型,包装类型和String类型，如果显式赋值则会生成<clint>()，说明是在初始化阶段赋值的
    *             静态的基本数据类型,包装类型和String类型，如果没有显式赋值则不会生成<clint>()，说明并没有赋值
    **/

   //情况7：static final修饰的基本数据类型（必须显式赋值，否则编译不通过）不会生成<clint>()
    //    说明不是在初始化赋值的，而是在链接阶段的准备环境赋值的（字段下面的num31下有个ConstantValue）。
    public static final int num31 = 3;

    /** 情况8：static final修饰的包装类型（必须显式赋值，否则编译不通过）会生成<clint>()，说明是在初始化阶段赋值 */
    public static final Integer num32 = 3;

    //情况9：static final修饰的String类型的字面量（必须显式赋值，否则编译不通过）不会生成<clint>()，
    //      说明不是在初始化赋值的，而是在链接阶段的准备环境赋值的（字段下面的str31下有个ConstantValue）。
    public static final String str31 = "fanhf";

   /** 情况10：static final修饰的String类型并通过new显式赋值（必须显式赋值，否则编译不通过）会生成<clint>()，说明是在初始化阶段赋值*/
    public static final String str32 = new String("");

/**
 *
 * 总结 static final
 *说明：使用static final修饰的字段的显式赋值的操作，到底是在哪个阶段进行的赋值？
 *情况1：在链接阶段的准备环境赋值
 *情况2：在初始化阶段的<clinit>()中赋值
 *
 *结论：
 *在链接阶段的准备环境赋值的情况：
 *1、对于基本数据类型的字段来说，如果使用static final修饰，则显式赋值（直接赋值常量，而非调用方法）通常是在链接阶段的准备环节进行
 *2、对于String来说，如果使用字面量的方式赋值，使用static final修饰的话，则显式赋值通常是在链接阶段的准备环节进行。
 *
 *在初始化阶段<clint>()中赋值的情况:
 *排除上述的在准备环境赋值的情况之外的情况。
 *
 *最终结论：使用 static final 修饰，且显式赋值中不涉及到方法或构造器调用的基本数据类型或String类型的显式赋值，是在链接阶段的准备环节进行。
 **/

}   
